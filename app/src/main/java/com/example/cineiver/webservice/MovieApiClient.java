package com.example.cineiver.webservice;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.cineiver.model.Movie;
import com.example.cineiver.model.MovieVideosResponse;
import com.example.cineiver.model.PopularMoviesResponse;
import com.example.cineiver.model.RequestedMovieResponse;
import com.example.cineiver.model.VideoData;
import com.example.cineiver.utils.Constants;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieApiClient{
    private static MovieApiClient client=null;
    MutableLiveData<List<Movie>> movies = new MutableLiveData<>();
    MutableLiveData<List<Movie>> requestedMovies = new MutableLiveData<>();
    MutableLiveData<List<VideoData>> videoDataList =new MutableLiveData<>();
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

    public MutableLiveData<List<VideoData>> getMovieTrailers(Long movieId){
        try{
            Call<MovieVideosResponse> movieTrailersCall = movieApiService.listTrailers(movieId,Constants.API_KEY);
            movieTrailersCall.enqueue(new Callback<MovieVideosResponse>() {
                @Override
                public void onResponse(Call<MovieVideosResponse> call, Response<MovieVideosResponse> response) {
                    if(response.isSuccessful()){
                        if(response.body()!=null){
                            List<VideoData> videoData = response.body().getResults();
                           // Log.d("videoData",response.body().getResults().toString());
                            if(videoData!=null){
                               //  Log.d("videoData",videoData.toString());
                               // Log.d("videoData",String.valueOf(videoData.size()).concat(" videoLinks"));
                                videoDataList.setValue(videoData);
                            }
                        }
                    }
                }
                @Override
                public void onFailure(Call<MovieVideosResponse> call, Throwable t) {
                    videoDataList.setValue(null);
                }
            });
        }catch(Exception e ){
            e.printStackTrace();
        }
        return videoDataList;
    }
    public MutableLiveData<List<Movie>> getRequestedMovies(String title){
        try{
            Call<RequestedMovieResponse> searchMoviesCall =  title!=null ? movieApiService.listSearchedMovies(title,Constants.API_KEY) :null;
            searchMoviesCall.enqueue(new Callback<RequestedMovieResponse>() {
                @Override
                public void onResponse(Call<RequestedMovieResponse> call, Response<RequestedMovieResponse> response) {
                    if(response.isSuccessful()){
                        if(response.body()!=null){
                            Log.d("searched",response.body().toString());
                            if(response.body().getResults()!=null){
                                requestedMovies.setValue(response.body().getResults());
                            }else {
                                Log.d("searched", "movies is null");
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<RequestedMovieResponse> call, Throwable t) {
                    requestedMovies.setValue(null);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
        return requestedMovies;
    }
}
