package com.example.gifsearcher.adapter;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.gifsearcher.R;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import java.util.List;


public class GifAdapter extends BaseAdapter {

    private static final String TAG = GifAdapter.class.getSimpleName();

    private Context context;
    private LayoutInflater layoutInflater;
    private List<String> urls;

    public GifAdapter(Context context, List<String> urls) {
        this.context = context;
        this.urls = urls;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return urls.size();
    }

    @Override
    public Object getItem(int i) {
        return urls.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null) {
            v = layoutInflater.inflate(R.layout.list_item_gif, viewGroup, false);
        }

        String url = (String) getItem(i);

        ImageView gifImageView = (ImageView) v.findViewById(R.id.gif_image_view);
        final ProgressBar progressBar = (ProgressBar) v.findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.getIndeterminateDrawable()
                .setColorFilter(context.getResources()
                        .getColor(R.color.colorPrimary), PorterDuff.Mode.MULTIPLY);


        Ion.with(gifImageView).load(url).setCallback(new FutureCallback<ImageView>() {
            @Override
            public void onCompleted(Exception e, ImageView result) {
                progressBar.setVisibility(View.GONE);
            }
        });

        Log.d(TAG, "url = " + url);

        return v;
    }



}