package com.example.cineiver.webservice;

import com.example.cineiver.model.Movie;
import com.example.cineiver.model.MovieVideosResponse;
import com.example.cineiver.model.PopularMoviesResponse;
import com.example.cineiver.model.RequestedMovieResponse;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApiService {

    String API_URL="https://api.themoviedb.org/3/";
    //requests
    @GET("movie/popular?language=fr-Fr&include_adult=false&append_to_response=videos,images")
    Call<PopularMoviesResponse> listPopularMovies(@Query("api_key") String api_key);

    @GET("search/movie?language=fr-Fr&include_adult=false&append_to_response=videos,images")
    Call<RequestedMovieResponse> listSearchedMovies(@Query("query")String title, @Query("api_key") String api_key);

    @GET("movie/{movie_id}/videos?language=fr-Fr&include_adult=false&append_to_response=videos,images")
    Call<MovieVideosResponse> listTrailers(@Path("movie_id")Long movie_id, @Query("api_key") String api_key);

}
