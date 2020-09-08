package com.example.cineiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.cineiver.model.Movie;
import com.example.cineiver.utils.ActivityDataHandler;
import com.example.cineiver.viewmodels.MovieSearchViewModel;

public class MovieSearchActivity extends AppCompatActivity {
    EditText movieEditText;
    MovieSearchViewModel movieSearchViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_search);
    }

}