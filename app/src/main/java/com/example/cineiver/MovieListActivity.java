package com.example.cineiver;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.cineiver.adapters.MovieListAdapter;
import com.example.cineiver.model.Movie;
import com.example.cineiver.repository.MovieRepository;
import com.example.cineiver.viewmodels.MovieListViewModel;

import java.util.List;

public class MovieListActivity extends AppCompatActivity{
    RecyclerView recyclerView;
    MovieListAdapter movieListAdapter;
    MovieListViewModel movieListViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //MovieApiClient client= MovieApiClient.getMovieApiClientInstance();
        //client.getPopularMovies();
        /*MovieRepository repository = new MovieRepository();
        List<Movie> movieList =repository.getMovies();
        if(movieList!=null){
            Log.d("onCreateData",movieList.toString());
        }*/
        createRecyclerView();
       MovieRepository repository = new MovieRepository();
       repository.getMovies();
        createMovieViewModel();
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
        movieListViewModel.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                Log.d("onCreate",movies.toString());
                movieListAdapter.setMovies(movies);
                movieListAdapter.notifyDataSetChanged();
            }
        });
    }

}