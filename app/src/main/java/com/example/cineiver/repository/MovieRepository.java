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
        return movies;
    }

}
