package com.olegdavidovichdev.gifsearcher.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.olegdavidovichdev.gifsearcher.DialogCreator;
import com.olegdavidovichdev.gifsearcher.Network.CheckNetwork;
import com.olegdavidovichdev.gifsearcher.R;
import com.olegdavidovichdev.gifsearcher.adapter.GifAdapter;


import com.olegdavidovichdev.gifsearcher.model.Gif;
import com.olegdavidovichdev.gifsearcher.model.GifResponse;

import com.olegdavidovichdev.gifsearcher.rest.ApiClient;
import com.olegdavidovichdev.gifsearcher.rest.ApiInterface;
import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String API_KEY = "dc6zaTOxFJmzC";
    private static final String SUPPORT_LANGUAGE = "ru";
    private static final String TAG_CALL = "CallGIF";

    private FloatingSearchView floatingSearchView;
    private GifAdapter gifSearchAdapter, gifTrendAdapter;
    private ProgressDialog pg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ListView gifListView = (ListView) findViewById(R.id.gif_list_view);
        floatingSearchView = (FloatingSearchView) findViewById(R.id.floating_search_view);
        pg = new ProgressDialog(this);

        floatingSearchView.setOnMenuItemClickListener(new FloatingSearchView.OnMenuItemClickListener() {
            @Override
            public void onActionMenuItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.menu_item_trends) {

                    if (!CheckNetwork.isInternetAvailable(MainActivity.this))
                        Toast.makeText(MainActivity.this, "Please, check your Internet connection", Toast.LENGTH_SHORT).show();
                    else DialogCreator.onCreateDialog(pg, "Загрузка данных ...");

                    ApiInterface apiTrendService = ApiClient.getClient().create(ApiInterface.class);

                    Call<GifResponse> call = apiTrendService.getTrendingGifs(API_KEY);
                    call.enqueue(new Callback<GifResponse>() {
                        @Override
                        public void onResponse(Call<GifResponse> call, Response<GifResponse> response) {
                            Log.d(TAG_CALL, call.request().toString());
                            pg.hide();

                            List<Gif> data = response.body().getData();

                            final List<String> preview_trending_urls = new ArrayList<>();
                            final List<String> gif_trending_urls = new ArrayList<>();

                            for (Gif gif : data) {
                                Gif.Images images = gif.getImages();

                                Gif.Images.OriginalStill os = images.getOriginalStill();
                                Gif.Images.Original o = images.getOriginal();

                                String preview_trending_url = os.getUrl();
                                String gif_trending_url = o.getUrl();

                                preview_trending_urls.add(preview_trending_url);
                                gif_trending_urls.add(gif_trending_url);
                            }

                            Log.d(TAG, preview_trending_urls.toString());
                            Log.d(TAG, gif_trending_urls.toString());

                            gifTrendAdapter = new GifAdapter(getApplicationContext(), preview_trending_urls);
                            gifListView.setAdapter(gifTrendAdapter);

                            gifListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    String s = gif_trending_urls.get(i);
                                    preview_trending_urls.set(i, s);
                                    gifTrendAdapter.notifyDataSetChanged();
                                }
                            });
                        }

                        @Override
                        public void onFailure(Call<GifResponse> call, Throwable t) {
                            Log.d(TAG, t.toString());
                            pg.hide();
                        }
                    });
                }
            }
        });


        floatingSearchView.setOnSearchListener(new FloatingSearchView.OnSearchListener() {
            @Override
            public void onSuggestionClicked(SearchSuggestion searchSuggestion) {
            }

            @Override
            public void onSearchAction(String currentQuery) {
                if (!CheckNetwork.isInternetAvailable(MainActivity.this))
                    Toast.makeText(MainActivity.this, "Please, check your Internet connection", Toast.LENGTH_SHORT).show();
                else DialogCreator.onCreateDialog(pg, "Загрузка данных ...");

                ApiInterface apiSearchService = ApiClient.getClient().create(ApiInterface.class);

                Call<GifResponse> call = apiSearchService.getSearchGifs(currentQuery, API_KEY, SUPPORT_LANGUAGE);
                call.enqueue(new Callback<GifResponse>() {
                    @Override
                    public void onResponse(Call<GifResponse> call, Response<GifResponse> response) {
                        Log.d(TAG_CALL, call.request().toString());
                        pg.hide();
                        List<Gif> data = response.body().getData();
                        if (data.isEmpty()) {
                            Toast.makeText(MainActivity.this, "Gif's not found", Toast.LENGTH_SHORT).show();
                        }

                        final List<String> preview_search_urls = new ArrayList<>();
                        final List<String> gif_search_urls = new ArrayList<>();

                        for (Gif gif : data) {
                            Gif.Images images = gif.getImages();

                            Gif.Images.OriginalStill os = images.getOriginalStill();
                            Gif.Images.Original o = images.getOriginal();

                            String preview_search_url = os.getUrl();
                            String gif_search_url = o.getUrl();

                            preview_search_urls.add(preview_search_url);
                            gif_search_urls.add(gif_search_url);
                        }

                        Log.d(TAG, preview_search_urls.toString());
                        Log.d(TAG, gif_search_urls.toString());

                        gifSearchAdapter = new GifAdapter(getApplicationContext(), preview_search_urls);
                        gifListView.setAdapter(gifSearchAdapter);

                        gifListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                String s = gif_search_urls.get(i);
                                preview_search_urls.set(i, s);
                                gifSearchAdapter.notifyDataSetChanged();
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<GifResponse> call, Throwable t) {
                        Log.d(TAG, t.toString());
                        pg.hide();
                    }
                });
            }
        });
    }
}
