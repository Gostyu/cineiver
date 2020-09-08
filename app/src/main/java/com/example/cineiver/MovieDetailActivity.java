package com.example.cineiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.asura.library.views.PosterSlider;
import com.example.cineiver.model.Movie;
import com.example.cineiver.model.PosterSize;
import com.example.cineiver.utils.ActivityDataHandler;
import com.example.cineiver.utils.Constants;
import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity implements ActivityDataHandler {
    Movie movie;
    ImageView movieDetailPictureView;
    TextView movieDetailTitleView;
    TextView movieDetailReleaseDateView;
    TextView movieDetailSynopsisView;
    PosterSlider slider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        initAllViews();
        getDataFromPreviousActivity();
    }

    private void initAllViews() {
        movieDetailTitleView=findViewById(R.id.movieDetailTitle);
        movieDetailReleaseDateView=findViewById(R.id.movieDetailReleaseDate);
        movieDetailSynopsisView=findViewById(R.id.movieDetailSynopsis);
        movieDetailPictureView=findViewById(R.id.movieDetailPicture);
    }

    @Override
    public void getDataFromPreviousActivity() {
        Intent intent = getIntent();
        movie = intent.getParcelableExtra(Constants.MOVIELISTADAPTER_TAG);
        if(movie!=null){
            //Log.d("detailA", movie.toString());
            movieDetailTitleView.setText(movie.getOriginalTitle());
            movieDetailReleaseDateView.setText("Date de sortie : ".concat(movie.getReleaseDate()));
            movieDetailSynopsisView.setText(movie.getOverview());
            Picasso.get().load(movie.getPosterPath(PosterSize.NORMAL)).into(movieDetailPictureView);
        }
    }
}