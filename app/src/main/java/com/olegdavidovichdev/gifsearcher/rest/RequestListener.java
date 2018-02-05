package com.olegdavidovichdev.gifsearcher.rest;

import android.support.annotation.NonNull;

import com.olegdavidovichdev.gifsearcher.model.Gif;

import java.util.List;


public interface RequestListener {

    void onSuccess(@NonNull List<Gif> listOfGifs);

    void onFailure(String message);

}