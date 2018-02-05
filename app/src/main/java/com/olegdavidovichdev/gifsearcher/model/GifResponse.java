package com.olegdavidovichdev.gifsearcher.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class GifResponse {

    @SerializedName("data")
    @Expose
    private List<Gif> data;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;
    @SerializedName("meta")
    @Expose
    private Meta meta;


    public List<Gif> getGifs() {
        return data;
    }

}
