package com.example.apihandlingmvvm.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.apihandlingmvvm.network.ApiClient;
import com.example.apihandlingmvvm.network.ApiServices;
import com.example.apihandlingmvvm.responses.TvShowDetailsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvShowDetailsRepository {
    private ApiServices apiServices;

    public TvShowDetailsRepository() {
        apiServices = ApiClient.getRetrofit().create(ApiServices.class);
    }

    public LiveData<TvShowDetailsResponse> getTvShowDetails(String tvShowId) {
        MutableLiveData<TvShowDetailsResponse> data = new MutableLiveData<>();
        apiServices.getTVShowDetails(tvShowId).enqueue(new Callback<TvShowDetailsResponse>() {
            @Override
            public void onResponse(Call<TvShowDetailsResponse> call, Response<TvShowDetailsResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<TvShowDetailsResponse> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
