package com.example.apihandlingmvvm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.apihandlingmvvm.repositories.MostPopularTvShowsRepository;
import com.example.apihandlingmvvm.responses.TvShowResponses;

public class MostPopularTvShowsViewModel extends ViewModel {
    private MostPopularTvShowsRepository mostPopularTvShowsRepository;

    public MostPopularTvShowsViewModel() {
        this.mostPopularTvShowsRepository = new MostPopularTvShowsRepository();
    }

    public LiveData<TvShowResponses> getMostPopularTvShows(int page) {
        return mostPopularTvShowsRepository.getMostPopularTvShows(page);
    }
}
