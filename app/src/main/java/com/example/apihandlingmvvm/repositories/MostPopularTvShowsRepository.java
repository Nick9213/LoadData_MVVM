package com.example.apihandlingmvvm.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.apihandlingmvvm.network.ApiClient;
import com.example.apihandlingmvvm.network.ApiServices;
import com.example.apihandlingmvvm.responses.TvShowResponses;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MostPopularTvShowsRepository {

    private ApiServices apiServices;

    public MostPopularTvShowsRepository() {
        apiServices = ApiClient.getRetrofit().create(ApiServices.class);
    }

    public LiveData<TvShowResponses> getMostPopularTvShows(int page) {
        MutableLiveData<TvShowResponses> data = new MutableLiveData<>();
        apiServices.getMostPopularShows(page).enqueue(new Callback<TvShowResponses>() {
            @Override
            public void onResponse(@NonNull Call<TvShowResponses> call, @NonNull Response<TvShowResponses> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<TvShowResponses> call, @NonNull Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
