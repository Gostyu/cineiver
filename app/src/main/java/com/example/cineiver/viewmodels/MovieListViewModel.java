package com.example.cineiver.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.cineiver.model.Movie;
import com.example.cineiver.model.VideoData;
import com.example.cineiver.repository.MovieRepository;

import java.util.List;

public class MovieListViewModel extends ViewModel {
    MovieRepository repository;
    public MovieListViewModel(){
        repository = new MovieRepository();
    }
    public LiveData<List<Movie>> getMovies() {
       return repository.getMovies();
    }
    public LiveData<List<VideoData>> getVideoDataList(Long movieId) {
        return repository.getVideoDataList(movieId);
    }
}
