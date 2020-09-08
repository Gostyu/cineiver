package com.example.cineiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.cineiver.adapters.MovieListAdapter;
import com.example.cineiver.viewmodels.MovieListViewModel;

import java.util.List;

public class MovieListActivity extends AppCompatActivity{
    RecyclerView recyclerView;
    MovieListAdapter movieListAdapter;
    MovieListViewModel movieListViewModel;
    ImageView searchButtonView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launchMovieSearchActivity();
        createRecyclerView();
        createMovieViewModel();
    }
    void launchMovieSearchActivity(){
        searchButtonView=findViewById(R.id.search_button);
        searchButtonView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(),MovieSearchActivity.class);
            startActivity(intent);
        });
    }
    void createRecyclerView(){
        recyclerView=findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(layoutManager);
        movieListAdapter = new MovieListAdapter(getBaseContext());
        recyclerView.setAdapter(movieListAdapter);
        recyclerView.setVisibility(View.VISIBLE);
    }
    void createMovieViewModel(){
         movieListViewModel=new ViewModelProvider(this).get(MovieListViewModel.class);
        populateRecyclerView();
    }

    private void populateRecyclerView() {
        movieListViewModel.getMovies().observe(this, movies -> {
            //Log.d("onCreate",movies.toString());
           // Log.d("onCreate",String.valueOf(movies.size()).concat(" items"));
            movieListAdapter.setMovies(movies);
            movieListAdapter.notifyDataSetChanged();
        });
    }

}