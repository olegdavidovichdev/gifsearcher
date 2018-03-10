package com.olegdavidovichdev.gifsearcher.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.olegdavidovichdev.gifsearcher.Network.CheckNetwork;
import com.olegdavidovichdev.gifsearcher.R;
import com.olegdavidovichdev.gifsearcher.RecyclerViewItemClickListener;
import com.olegdavidovichdev.gifsearcher.adapter.GifAdapter;
import com.olegdavidovichdev.gifsearcher.model.Gif;
import com.olegdavidovichdev.gifsearcher.model.GifResponse;
import com.olegdavidovichdev.gifsearcher.model.Images;
import com.olegdavidovichdev.gifsearcher.model.Original;
import com.olegdavidovichdev.gifsearcher.model.OriginalStill;
import com.olegdavidovichdev.gifsearcher.model.RecyclerItem;
import com.olegdavidovichdev.gifsearcher.rest.ApiClient;
import com.olegdavidovichdev.gifsearcher.rest.ApiInterface;
import com.olegdavidovichdev.gifsearcher.rest.GiphyCallback;
import com.olegdavidovichdev.gifsearcher.rest.GiphyConfig;
import com.olegdavidovichdev.gifsearcher.rest.RequestListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;


public class MainActivity extends AppCompatActivity implements MainView, RequestListener,
        FloatingSearchView.OnSearchListener, FloatingSearchView.OnMenuItemClickListener,
        RecyclerViewItemClickListener {

    @BindView(R.id.floating_search_view) FloatingSearchView floatingSearchView;
    @BindView(R.id.recycler) RecyclerView recycler;
    @BindView(R.id.progress_bar) ProgressBar progressBar;
    private GifAdapter gifAdapter;

    private GiphyCallback giphyCallback;

    private List<RecyclerItem> previewList;
    private List<String> gifList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initializePreviewList();
        floatingSearchView.setOnSearchListener(this);
        floatingSearchView.setOnMenuItemClickListener(this);

        if (CheckNetwork.isInternetAvailable(this)) {
            onTrendingLoad();
        } else {
            showError(getString(R.string.connection_error));
        }
    }

    private void initializePreviewList() {
        previewList = new ArrayList<>();
        gifList = new ArrayList<>();
        gifAdapter = new GifAdapter(previewList, this);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recycler.setLayoutManager(llm);
        recycler.setAdapter(gifAdapter);
    }

    @Override
    public void onTrendingLoad() {
        ApiInterface apiInterface = ApiClient.getApiInterface();

        Call<GifResponse> call = apiInterface.getTrendingGifs(GiphyConfig.API_KEY);

        if (giphyCallback == null) {
            giphyCallback = new GiphyCallback(this);
        }

        if (CheckNetwork.isInternetAvailable(this)) {
            progressBar.setVisibility(View.VISIBLE);
            recycler.setVisibility(View.GONE);
            call.enqueue(giphyCallback);
        } else {
            showError(getString(R.string.connection_error));
        }
    }

    @Override
    public void onSearchLoad(String query) {
        ApiInterface apiInterface = ApiClient.getApiInterface();

        Call<GifResponse> call = apiInterface.getSearchGifs(query, GiphyConfig.API_KEY,
                GiphyConfig.SUPPORT_LANGUAGE);

        if (giphyCallback == null) {
            giphyCallback = new GiphyCallback(this);
        }

        if (CheckNetwork.isInternetAvailable(this)) {
            progressBar.setVisibility(View.VISIBLE);
            recycler.setVisibility(View.GONE);
            call.enqueue(giphyCallback);
        } else {
            showError(getString(R.string.connection_error));
        }
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(@NonNull List<Gif> listOfGifs) {
        progressBar.setVisibility(View.GONE);
        recycler.setVisibility(View.VISIBLE);

        clearLists();
        recycler.smoothScrollToPosition(0);

        for (Gif gif : listOfGifs) {

            Images images = gif.getImages();

            OriginalStill os = images.getOriginalStill();
            Original o = images.getOriginal();

            String previewUrl = os.getUrl();
            String gifUrl = o.getUrl();

            String userName;
            if (gif.getUser() != null) {
                userName = gif.getUser().getDisplayName();
            } else {
                userName = "Unknown";
            }

            RecyclerItem ri = new RecyclerItem(previewUrl, o.getSize(), userName, false);

            previewList.add(ri);
            gifList.add(gifUrl);
        }

        gifAdapter.notifyDataSetChanged();
    }

    private void clearLists() {
        if (!previewList.isEmpty()) {
            previewList.clear();
        }

        if (!gifList.isEmpty()) {
            gifList.clear();
        }
    }

    @Override
    public void onFailure(String message) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActionMenuItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_item_trends) {
            onTrendingLoad();
        }
    }

    @Override
    public void onSearchAction(String currentQuery) {
        if (!TextUtils.isEmpty(currentQuery)) {
            onSearchLoad(currentQuery);
        } else {
            showError(getString(R.string.input_error));
        }

    }

    @Override
    public void onSuggestionClicked(SearchSuggestion searchSuggestion) {
        // ignored
    }

    @Override
    public void onRecyclerItemClicked(int position) {
        String gifUrl = gifList.get(position);
        RecyclerItem ri = previewList.get(position);

        if (gifUrl != null && ri.getPreviewUrl() != null) {
            gifList.set(position, ri.getPreviewUrl());
            ri.setPreviewUrl(gifUrl);
            ri.setClicked(!ri.isClicked());
            gifAdapter.notifyItemChanged(position);
        } else {
            showError(getString(R.string.gif_error));
        }
    }

}
