package com.olegdavidovichdev.gifsearcher.model;

import com.google.gson.annotations.SerializedName;


public class Gif {

    @SerializedName("type")
    private String type;
    @SerializedName("id")
    private String id;
    @SerializedName("slug")
    private String slug;
    @SerializedName("url")
    private String url;
    @SerializedName("bitly_gif_url")
    private String bitlyGifUrl;
    @SerializedName("bitly_url")
    private String bitlyUrl;
    @SerializedName("embed_url")
    private String embedUrl;
    @SerializedName("username")
    private String username;
    @SerializedName("source")
    private String source;
    @SerializedName("rating")
    private String rating;
    @SerializedName("caption")
    private String caption;
    @SerializedName("content_url")
    private String contentUrl;
    @SerializedName("source_tld")
    private String sourceTld;
    @SerializedName("source_post_url")
    private String sourcePostUrl;
    @SerializedName("import_datetime")
    private String importDatetime;
    @SerializedName("trending_datetime")
    private String trendingDatetime;
    @SerializedName("images")
    private Images images;
    @SerializedName("user")
    private User user;


    public Images getImages() {
        return images;
    }

    public User getUser() {
        return user;
    }

}
