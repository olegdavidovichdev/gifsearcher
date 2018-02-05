package com.olegdavidovichdev.gifsearcher.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.olegdavidovichdev.gifsearcher.Network.CheckNetwork;
import com.olegdavidovichdev.gifsearcher.R;
import com.olegdavidovichdev.gifsearcher.adapter.GifAdapter;
import com.olegdavidovichdev.gifsearcher.model.Gif;
import com.olegdavidovichdev.gifsearcher.model.GifResponse;
import com.olegdavidovichdev.gifsearcher.model.Images;
import com.olegdavidovichdev.gifsearcher.model.Original;
import com.olegdavidovichdev.gifsearcher.model.OriginalStill;
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
        AdapterView.OnItemClickListener, FloatingSearchView.OnSearchListener,
        FloatingSearchView.OnMenuItemClickListener {

    @BindView(R.id.floating_search_view) FloatingSearchView floatingSearchView;
    @BindView(R.id.gif_list_view) ListView gifListView;
    @BindView(R.id.progress_bar) ProgressBar progressBar;
    private GifAdapter gifAdapter;

    private GiphyCallback giphyCallback;

    private List<String> previewList;
    private List<String> gifList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initializePreviewList();
        gifListView.setOnItemClickListener(this);
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
        gifAdapter = new GifAdapter(this, previewList);
        gifListView.setAdapter(gifAdapter);
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
            gifListView.setVisibility(View.GONE);
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
            gifListView.setVisibility(View.GONE);
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
        gifListView.setVisibility(View.VISIBLE);

        clearLists();
        gifListView.smoothScrollToPosition(0);

        for (Gif gif : listOfGifs) {

            Images images = gif.getImages();

            OriginalStill os = images.getOriginalStill();
            Original o = images.getOriginal();

            String previewUrl = os.getUrl();
            String gifUrl = o.getUrl();

            previewList.add(previewUrl);
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
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String gifUrl = gifList.get(i);
        String previewUrl = previewList.get(i);

        if (gifUrl != null && previewUrl != null) {
            previewList.set(i, gifUrl);
            gifList.set(i, previewUrl);
            gifAdapter.notifyDataSetChanged();
        } else {
            showError(getString(R.string.gif_error));
        }
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

}
