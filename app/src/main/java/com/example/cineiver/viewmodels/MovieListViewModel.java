package com.example.cineiver.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.cineiver.model.Movie;
import com.example.cineiver.repository.MovieRepository;

import java.util.List;

public class MovieListViewModel extends ViewModel {
    LiveData<List<Movie>>movies;
    MovieRepository repository;
    public MovieListViewModel(){
        repository = new MovieRepository();
    }
    public LiveData<List<Movie>> getMovies() {
       return repository.getMovies();
    }
}
