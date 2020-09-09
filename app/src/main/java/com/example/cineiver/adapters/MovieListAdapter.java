package com.example.cineiver.adapters;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cineiver.Activities.MovieDetailActivity;
import com.example.cineiver.R;
import com.example.cineiver.model.Movie;
import com.example.cineiver.model.PosterSize;
import com.example.cineiver.utils.Constants;
import com.example.cineiver.utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    private List<Movie> movies;
    private Context context;

    public MovieListAdapter(Context context) {
        this.context = context;
        movies=new ArrayList<Movie>();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView moviePictureView;
        TextView movieTitleView;
        TextView movieReleaseDateView;
        TextView movieSynopsisView;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);
            moviePictureView=itemView.findViewById(R.id.moviePicture);
            movieTitleView=itemView.findViewById(R.id.movieTitle);
            movieReleaseDateView=itemView.findViewById(R.id.movieReleaseDate);
            movieSynopsisView=itemView.findViewById(R.id.movieSynopsis);

        }
        public void updateCardView(String imgSrc,String title,String releaseDate, String synopsis){
           // Log.d("MLAdapter",imgSrc);
            Picasso.get().load(imgSrc).into(moviePictureView);
            movieTitleView.setText(title);
            movieReleaseDateView.setText(releaseDate);
            movieSynopsisView.setText(Utils.reduceString(synopsis));
        }

    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.movielist_item,viewGroup,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        movieViewHolder.updateCardView(movies.get(i).getPosterPath(PosterSize.SMALL),
                movies.get(i).getTitle(),
                movies.get(i).getReleaseDate(),
                movies.get(i).getOverview());

        movieViewHolder.cardView.setOnClickListener(view -> {
            //Log.d("onClick","onClick works");
            context= view.getContext();
            Intent intent = new Intent(context, MovieDetailActivity.class);
            intent.putExtra(Constants.MOVIELISTADAPTER_TAG,movies.get(movieViewHolder.getAdapterPosition()));
            context.startActivity(intent);
        });
    }
    @Override
    public int getItemCount() {
        return movies.size();
    }
    public void setMovies(List<Movie> movies){
            this.movies=movies;
    }
}
