package com.olegdavidovichdev.gifsearcher.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    private static final String BASE_URL = "http://api.giphy.com/";
    private static Retrofit retrofit = null;
    private static ApiInterface apiInterface = null;

    private static void getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            if (apiInterface == null) {
                apiInterface = retrofit.create(ApiInterface.class);
            }
        }
    }

    public static ApiInterface getApiInterface() {
        if (apiInterface == null) {
            getClient();
        }

        return apiInterface;
    }

}
