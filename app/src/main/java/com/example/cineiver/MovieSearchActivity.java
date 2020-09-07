package com.example.cineiver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cineiver.model.Movie;

public class MovieSearchActivity extends AppCompatActivity {
    Movie movie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_search);
    }
}