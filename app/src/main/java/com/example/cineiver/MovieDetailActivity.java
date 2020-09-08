package com.example.cineiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.cineiver.model.Movie;
import com.example.cineiver.utils.ActivityDataHandler;
import com.example.cineiver.utils.Constants;
import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity implements ActivityDataHandler {
    Movie movie;
    Picasso img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
    }

    @Override
    public void getDataFromPreviousActivity() {
        Intent intent = getIntent();
        movie = intent.getParcelableExtra(Constants.MOVIELISTADAPTER_TAG);
        Log.d("MovieD", movie.toString());
    }
}