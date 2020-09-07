package com.example.cineiver.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cineiver.MovieSearchActivity;
import com.example.cineiver.R;
import com.example.cineiver.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    List<Movie> movies;
    Context context;

    public MovieListAdapter(List<Movie> movies, Context context) {
        this.movies = movies!=null? movies:movies;
        this.context = context;
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
        public void updateCardView(String Imgsrc,String title,String releaseDate, String synopsis){
            Picasso.get().load(Imgsrc).into(moviePictureView);
            movieTitleView.setText(title);
            movieReleaseDateView.setText(releaseDate);
            movieSynopsisView.setText(synopsis);
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
        movieViewHolder.updateCardView(movies.get(i).getPosterPath(),
                movies.get(i).getTitle(),
                movies.get(i).getReleaseDate(),
                movies.get(i).getOverview());
        movieViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MovieSearchActivity.class);
                intent.putExtra("MOVIE",movies.get(movieViewHolder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
