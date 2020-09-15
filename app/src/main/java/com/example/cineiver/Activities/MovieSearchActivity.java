package com.example.cineiver.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cineiver.R;
import com.example.cineiver.adapters.MovieListAdapter;
import com.example.cineiver.model.Movie;
import com.example.cineiver.repository.MovieRepository;
import com.example.cineiver.utils.ActivityDataHandler;
import com.example.cineiver.viewmodels.MovieListViewModel;
import com.example.cineiver.viewmodels.MovieSearchViewModel;

public class MovieSearchActivity extends AppCompatActivity {
    EditText movieEditText;
    MovieSearchViewModel movieViewModel;
    RecyclerView recyclerView;
    MovieListAdapter movieListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_search);
        movieEditText=findViewById(R.id.movieEditText);
        createRecyclerView();
        movieViewModel= new ViewModelProvider(this).get(MovieSearchViewModel.class);
        setMovieEditTextListener();
    }
    private void setMovieEditTextListener(){
        movieEditText.setOnEditorActionListener((textView, i, keyEvent) -> {
            if (i == EditorInfo.IME_ACTION_SEARCH) {
                getRequestedMovies(textView.getText().toString());
                return true;
            }
            return false;
        });
    }
    void createRecyclerView(){
        recyclerView=findViewById(R.id.movieSearchrecyclerView);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(layoutManager);
        movieListAdapter = new MovieListAdapter(getBaseContext());
        recyclerView.setAdapter(movieListAdapter);
        recyclerView.setVisibility(View.VISIBLE);
    }
    private void getRequestedMovies(String title) {
        movieViewModel.getRequestedMoviesByName(title).observe(this, movies -> {
            movieListAdapter.setMovies(movies);
            movieListAdapter.notifyDataSetChanged();
        });
    }



}