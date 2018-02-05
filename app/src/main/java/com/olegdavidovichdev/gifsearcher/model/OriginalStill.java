package com.olegdavidovichdev.gifsearcher.model;

import com.google.gson.annotations.SerializedName;

public class OriginalStill {

    @SerializedName("url")
    private String url;
    @SerializedName("width")
    private String width;
    @SerializedName("height")
    private String height;

    public String getUrl() {
        return url;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }

}