package com.example.cineiver.webservice;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.cineiver.model.Movie;
import com.example.cineiver.model.PopularMoviesResponse;
import com.example.cineiver.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieApiClient{
    private static MovieApiClient client=null;
    private MovieApiService movieApiService;
    private MovieApiClient(){
        movieApiService=getMovieApiServiceInstance();
    }
    public static MovieApiClient getMovieApiClientInstance() {
        return client==null? client=new MovieApiClient(): client;
    }

    private static MovieApiService getMovieApiServiceInstance() {
        return new Retrofit.Builder().baseUrl(MovieApiService.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieApiService.class);
    }
   public MutableLiveData<List<Movie>> getPopularMovies(){
       MutableLiveData<List<Movie>> movies = new MutableLiveData<>();
        try {
           Call<PopularMoviesResponse> popularMoviesResponseCall =movieApiService.listPopularMovies(Constants.API_KEY);
            popularMoviesResponseCall.enqueue(new Callback<PopularMoviesResponse>() {
                @Override
                public void onResponse(Call<PopularMoviesResponse> call, Response<PopularMoviesResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                           // Log.d("MOVIEAPI", response.body().getResults().toString());
                            //popularMoviesResponse=response;
                           // Log.d("movieApi", response.body().toString());
                           // Log.d("Api", response.body().getResults().toString());
                         //   Log.d("listSize", String.valueOf(response.body().getResults().size()).concat(" items"));
                            movies.setValue(response.body().getResults());
                            //Log.d("Response",movies.toString());
                            //Log.d("Response",popularMoviesResponse.toString());
                        }
                    }
                }
                @Override
                public void onFailure(Call<PopularMoviesResponse> call, Throwable t) {
                   // Log.d("POPULAR_MOVIES_ERROR",t.getMessage());
                    movies.setValue(null);
                }
            });
        } catch (Exception e){
            e.printStackTrace();
        }
       return movies;
    }

}
