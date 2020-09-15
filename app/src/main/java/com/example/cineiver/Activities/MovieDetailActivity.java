package com.example.cineiver.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.asura.library.posters.Poster;
import com.asura.library.posters.RemoteImage;
import com.asura.library.posters.RemoteVideo;
import com.asura.library.views.PosterSlider;
import com.example.cineiver.R;
import com.example.cineiver.model.Movie;
import com.example.cineiver.model.PosterSize;
import com.example.cineiver.model.VideoData;
import com.example.cineiver.repository.MovieRepository;
import com.example.cineiver.utils.ActivityDataHandler;
import com.example.cineiver.utils.Constants;
import com.example.cineiver.viewmodels.MovieListViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity extends AppCompatActivity implements ActivityDataHandler {
    Movie movie;
    ImageView movieDetailPictureView;
    TextView movieDetailTitleView;
    TextView movieDetailReleaseDateView;
    TextView movieDetailSynopsisView;
    PosterSlider slider;
    List<Poster> trailers;
    MovieListViewModel movieListViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        trailers=new ArrayList<>();
        movieListViewModel=new ViewModelProvider(this).get(MovieListViewModel.class);
        initAllViews();
        getDataFromPreviousActivity();
    }

    private void initAllViews() {
        movieDetailTitleView=findViewById(R.id.movieDetailTitle);
        movieDetailReleaseDateView=findViewById(R.id.movieDetailReleaseDate);
        movieDetailSynopsisView=findViewById(R.id.movieDetailSynopsis);
        movieDetailPictureView=findViewById(R.id.movieDetailPicture);
        slider = findViewById(R.id.poster_slider);
    }

    @Override
    public void getDataFromPreviousActivity() {
        Intent intent = getIntent();
        movie = intent.getParcelableExtra(Constants.MOVIELISTADAPTER_TAG);
        if(movie!=null){
            movieDetailTitleView.setText(movie.getTitle());
            movieDetailReleaseDateView.setText(movie.getReleaseDate());
            movieDetailSynopsisView.setText(movie.getOverview());
            Picasso.get().load(movie.getPosterPath(PosterSize.NORMAL)).into(movieDetailPictureView);
            getVideoData(movie.getId());
        }
    }
    private void getVideoData(Long movieId){
        movieListViewModel.getVideoDataList(movieId).observe(this,videoData -> {
            populateSlider(videoData);
        });
    }
    private void populateSlider(List<VideoData> videoLinks){
        for(VideoData data:videoLinks){
            trailers.add(new RemoteVideo(Uri.parse(data.getVideoLink())));
        }
        slider.setPosters(trailers);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}