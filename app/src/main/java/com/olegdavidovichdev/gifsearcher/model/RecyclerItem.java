package com.olegdavidovichdev.gifsearcher.model;


public class RecyclerItem {

    private String previewUrl;
    private String gifSize;
    private String user;
    private boolean isClicked;
    private int previewHeight;


    public RecyclerItem(String previewUrl, String gifSize, String user, boolean isClicked) {
        this.previewUrl = previewUrl;
        this.gifSize = gifSize;
        this.user = user;
        this.isClicked = isClicked;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getGifSize() {
        return gifSize;
    }

    public String getUser() {
        return user;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

}