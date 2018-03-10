package com.olegdavidovichdev.gifsearcher.model;

import com.google.gson.annotations.SerializedName;


public class User {

    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("banner_url")
    private String bannerUrl;
    @SerializedName("profile_url")
    private String profileUrl;
    @SerializedName("username")
    private String username;
    @SerializedName("display_name")
    private String displayName;
    @SerializedName("twitter")
    private String twitter;
    @SerializedName("is_verified")
    private boolean isVerified;


    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getTwitter() {
        return twitter;
    }

    public boolean getIsVerified() {
        return isVerified;
    }

}