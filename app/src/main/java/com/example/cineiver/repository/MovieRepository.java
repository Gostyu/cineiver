package com.example.cineiver.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.cineiver.model.Movie;
import com.example.cineiver.webservice.MovieApiClient;

import java.util.List;

public class MovieRepository {
    MovieApiClient mClient;
    LiveData<List<Movie>> movies;
    public MovieRepository(){
        mClient=MovieApiClient.getMovieApiClientInstance();
        movies = mClient.getPopularMovies();
    }

    public LiveData<List<Movie>> getMovies (){
    //    mClient=MovieApiClient.getMovieApiClientInstance();
      //  movies =mClient.getPopularMovies();
       /* if(mClient==null){
            Log.d("MovieRp", "mClient is NULL");
        }else{
            Log.d("MovieRp", "mClient is not NULL");
            movies = mClient.getPopularMovies();
            if(movies!=null) {
                Log.d("MovieRp", movies.toString());
            }else{
                Log.d("MovieRp", "movies is NULL");
            }
        }*/
      //  Log.d("MovieRP",MovieApiClient.getMovieApiClientInstance().getPopularMovies().toString());
        return movies;
    }

}
