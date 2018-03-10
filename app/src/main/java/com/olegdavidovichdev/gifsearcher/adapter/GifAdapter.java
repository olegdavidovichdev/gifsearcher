package com.olegdavidovichdev.gifsearcher.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;
import com.olegdavidovichdev.gifsearcher.R;
import com.olegdavidovichdev.gifsearcher.RecyclerViewItemClickListener;
import com.olegdavidovichdev.gifsearcher.model.RecyclerItem;
import com.olegdavidovichdev.gifsearcher.utils.Converter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GifAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<RecyclerItem> recyclerItems;
    private RecyclerViewItemClickListener listener;

    public GifAdapter(List<RecyclerItem> recyclerItems, RecyclerViewItemClickListener listener) {
        this.recyclerItems = recyclerItems;
        this.listener = listener;
    }


    public class GifHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.full_layout) FrameLayout flFull;
        @BindView(R.id.size_layout) RelativeLayout rlSize;
        @BindView(R.id.gif_image_view) ImageView gif;
        @BindView(R.id.layout_click_to_play) RelativeLayout rlClickToPlay;
        @BindView(R.id.gif_size) TextView tvGifSize;
        @BindView(R.id.user) TextView tvUser;

        GifHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            flFull.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                listener.onRecyclerItemClicked(getAdapterPosition());
            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_gif, parent, false);
        return new GifHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GifHolder gifHolder = (GifHolder) holder;
        RecyclerItem ri = recyclerItems.get(position);

        Ion.with(gifHolder.gif).load(ri.getPreviewUrl());

        if (ri.isClicked()) {
            gifHolder.rlClickToPlay.setVisibility(View.GONE);
            gifHolder.rlSize.setVisibility(View.GONE);
        } else {
            gifHolder.rlClickToPlay.setVisibility(View.VISIBLE);
            gifHolder.rlSize.setVisibility(View.VISIBLE);
            gifHolder.tvGifSize.setText(gifHolder.tvGifSize.getContext().getString(R.string.gif_size,
                    Converter.convertBToMB(ri.getGifSize())));
        }

        gifHolder.tvUser.setText(gifHolder.tvUser.getContext().getString(R.string.gif_user, ri.getUser()));
    }

    @Override
    public int getItemCount() {
        return recyclerItems.size();
    }

}