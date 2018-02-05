package com.olegdavidovichdev.gifsearcher.rest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.olegdavidovichdev.gifsearcher.R;
import com.olegdavidovichdev.gifsearcher.model.GifResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GiphyCallback implements Callback<GifResponse> {

    private RequestListener listener;
    private Context context;

    public GiphyCallback(@NonNull RequestListener listener) {
        this.listener = listener;

        if (listener instanceof AppCompatActivity) {
            context = (AppCompatActivity) listener;
        }
    }

    @Override
    public void onResponse(Call<GifResponse> call, Response<GifResponse> response) {
        if (response.isSuccessful()) {
            if (!response.body().getGifs().isEmpty()) {
                listener.onSuccess(response.body().getGifs());
            } else {
                listener.onFailure(context.getString(R.string.gif_list_is_empty));
            }
        } else {
            listener.onFailure(context.getString(R.string.server_error));
        }
    }

    @Override
    public void onFailure(Call<GifResponse> call, Throwable t) {
        listener.onFailure(t.getMessage());
    }

}