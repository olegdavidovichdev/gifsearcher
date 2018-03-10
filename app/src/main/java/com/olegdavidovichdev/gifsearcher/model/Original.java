package com.olegdavidovichdev.gifsearcher.model;

import com.google.gson.annotations.SerializedName;


public class Original {

    @SerializedName("url")
    private String url;
    @SerializedName("size")
    private String size;


    public String getUrl() {
        return url;
    }

    public String getSize() {
        return size;
    }

}