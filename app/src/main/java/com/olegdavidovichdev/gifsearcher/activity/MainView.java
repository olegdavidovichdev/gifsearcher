package com.olegdavidovichdev.gifsearcher.activity;


public interface MainView {

    void onTrendingLoad();

    void onSearchLoad(String query);

    void showError(String message);

}