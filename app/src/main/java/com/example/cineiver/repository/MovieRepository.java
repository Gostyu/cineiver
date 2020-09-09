package com.example.cineiver.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.cineiver.model.Movie;
import com.example.cineiver.model.VideoData;
import com.example.cineiver.webservice.MovieApiClient;

import java.util.List;

public class MovieRepository {
    MovieApiClient mClient;
    LiveData<List<Movie>> movies;
    LiveData<List<VideoData>> data;

    public MovieRepository(){
        mClient=MovieApiClient.getMovieApiClientInstance();
        movies = mClient.getPopularMovies();
    }

    public LiveData<List<Movie>> getMovies (){
        return movies;
    }

    public LiveData<List<VideoData>> getVideoDataList(Long movieId) {
        Log.d("getVideoDataList",String.valueOf(movieId));
        if(mClient==null){
            Log.d("mClient","mClient is null");
        }else{
            data=mClient.getMovieTrailers(movieId);
        }
         return data;
    }
}
