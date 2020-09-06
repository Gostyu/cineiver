package com.example.cineiver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cineiver.webservice.MovieApiClient;

public class MovieListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //MovieApiClient client= new MovieApiClient();
        //client.getPopularMovies();
    }
}