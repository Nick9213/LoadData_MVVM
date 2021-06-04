package com.example.apihandlingmvvm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.apihandlingmvvm.models.TvShowDetails;
import com.example.apihandlingmvvm.repositories.TvShowDetailsRepository;
import com.example.apihandlingmvvm.responses.TvShowDetailsResponse;

public class TvShowDetailsViewModel extends ViewModel {
    private TvShowDetailsRepository tvShowDetailsRepository;

    public TvShowDetailsViewModel() {
        tvShowDetailsRepository = new TvShowDetailsRepository();
    }

    public LiveData<TvShowDetailsResponse> getTvShowDetails(String tvShowId) {
        return tvShowDetailsRepository.getTvShowDetails(tvShowId);
    }
}
