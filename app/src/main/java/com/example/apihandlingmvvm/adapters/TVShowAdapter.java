package com.example.apihandlingmvvm.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apihandlingmvvm.R;
import com.example.apihandlingmvvm.databinding.ItemContainerTvShowBinding;
import com.example.apihandlingmvvm.listners.TvShowListeners;
import com.example.apihandlingmvvm.models.TVShow;

import java.util.List;

public class TVShowAdapter extends RecyclerView.Adapter<TVShowAdapter.TvShowVIewHolder> {
    private List<TVShow> tvShows;
    private LayoutInflater layoutInflater;
    private TvShowListeners tvShowListeners;

    public TVShowAdapter(List<TVShow> tvShows, TvShowListeners tvShowListeners) {
        this.tvShows = tvShows;
        this.tvShowListeners = tvShowListeners;
    }


    @NonNull
    @Override
    public TvShowVIewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemContainerTvShowBinding tvShowBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_container_tv_show, parent, false);
        return new TvShowVIewHolder(tvShowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowVIewHolder holder, int position) {
        holder.bindTvShow(tvShows.get(position));

    }

    @Override
    public int getItemCount() {
        return tvShows.size();
    }

    class TvShowVIewHolder extends RecyclerView.ViewHolder {
        private ItemContainerTvShowBinding itemContainerTvShowBinding;

        public TvShowVIewHolder(ItemContainerTvShowBinding itemContainerTvShowBinding) {
            super(itemContainerTvShowBinding.getRoot());
            this.itemContainerTvShowBinding = itemContainerTvShowBinding;
        }

        public void bindTvShow(TVShow tvShow) {
            itemContainerTvShowBinding.setTvShows(tvShow);
            itemContainerTvShowBinding.executePendingBindings();
            itemContainerTvShowBinding.getRoot().setOnClickListener(view -> tvShowListeners.onTvShowClicked(tvShow));
        }
    }
}
