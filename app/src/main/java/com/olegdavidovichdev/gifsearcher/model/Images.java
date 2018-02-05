package com.olegdavidovichdev.gifsearcher.model;

import com.google.gson.annotations.SerializedName;


public class Images {

    @SerializedName("original_still")
    private OriginalStill originalStill;
    @SerializedName("original")
    private Original original;


    public OriginalStill getOriginalStill() {
        return originalStill;
    }

    public Original getOriginal() {
        return original;
    }

}