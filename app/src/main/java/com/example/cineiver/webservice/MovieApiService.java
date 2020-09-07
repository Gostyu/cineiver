package com.example.cineiver.webservice;

import com.example.cineiver.model.PopularMoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {

    String API_URL="https://api.themoviedb.org/3/";
    //requests
    @GET("movie/popular?language=fr-Fr&include_adult=false&append_to_response=videos,images")
    Call<PopularMoviesResponse> listPopularMovies(@Query("api_key") String api_key);

}
