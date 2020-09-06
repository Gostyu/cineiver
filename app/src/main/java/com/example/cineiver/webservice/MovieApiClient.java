package com.example.cineiver.webservice;

import android.util.Log;

import com.example.cineiver.model.Movie;
import com.example.cineiver.model.PopularMoviesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieApiClient{
   // private static MovieApiClient instance=null;
    private static MovieApiService client = null;
    private static String API_KEY = "391f63013b803cbd3de2634d4d8619cf";
    public MovieApiClient(){

    }

    public static MovieApiService createClient() {
        return client==null? new Retrofit.Builder().baseUrl(MovieApiService.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieApiService.class) : client;
    }
   public static void getPopularMovies(){
        try {
            Call<PopularMoviesResponse> popularMoviesResponseCall =createClient().listPopularMovies(API_KEY);
            popularMoviesResponseCall.enqueue(new Callback<PopularMoviesResponse>() {
                @Override
                public void onResponse(Call<PopularMoviesResponse> call, Response<PopularMoviesResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            Log.i("MOVIEAPI", response.body().getResults().toString());
                        }
                    }
                }
                @Override
                public void onFailure(Call<PopularMoviesResponse> call, Throwable t) {
                    Log.d("POPULAR_MOVIES_ERROR",t.getMessage());
                }
            });
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
