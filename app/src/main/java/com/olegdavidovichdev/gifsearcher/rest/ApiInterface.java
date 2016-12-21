package com.olegdavidovichdev.gifsearcher.rest;


import com.olegdavidovichdev.gifsearcher.model.GifResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Oleg on 21.09.2016.
 */
public interface ApiInterface {

    @GET("/v1/gifs/trending")
    Call<GifResponse> getTrendingGifs(@Query("api_key") String apiKey);

    @GET("/v1/gifs/search")
    Call<GifResponse> getSearchGifs(@Query("q") String searchQuery, @Query("api_key") String apiKey, @Query("lang") String supportLanguages);
}
