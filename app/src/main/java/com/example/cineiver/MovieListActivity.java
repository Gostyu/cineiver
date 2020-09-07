package com.example.cineiver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.cineiver.adapters.MovieListAdapter;
import com.example.cineiver.model.Movie;
import com.example.cineiver.webservice.MovieApiClient;

import java.util.List;

public class MovieListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //MovieApiClient client= new MovieApiClient();
        //client.getPopularMovies();
    }
    void createRecyclerView(List<Movie> movies){
        recyclerView=findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(layoutManager);
        MovieListAdapter movieListAdapter = new MovieListAdapter(movies,getBaseContext());
        recyclerView.setAdapter(movieListAdapter);
        recyclerView.setVisibility(View.VISIBLE);
    }
}