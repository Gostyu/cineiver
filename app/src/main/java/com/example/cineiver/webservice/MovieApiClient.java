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
                           // Log.i("MOVIEAPI", response.body().getResults().toString());
                            //popularMoviesResponse=response;
                          //  Log.i("MOVIEAPI", response.body().toString());
                            Log.i("LIST", response.body().getResults().toString());
                            movies.setValue(response.body().getResults());
                            //Log.i("Response",movies.toString());
                            //Log.i("Response",popularMoviesResponse.toString());
                        }
                    }
                }
                @Override
                public void onFailure(Call<PopularMoviesResponse> call, Throwable t) {
                    Log.d("POPULAR_MOVIES_ERROR",t.getMessage());
                    movies.setValue(null);
                }
            });
        } catch (Exception e){
            e.printStackTrace();
        }
       return movies;
    }

}
