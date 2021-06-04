package com.example.apihandlingmvvm.network;

import com.example.apihandlingmvvm.models.TVShow;
import com.example.apihandlingmvvm.responses.TvShowDetailsResponse;
import com.example.apihandlingmvvm.responses.TvShowResponses;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {
    @GET("most-popular")
    Call<TvShowResponses> getMostPopularShows(@Query("page") int page);

    @GET("show-details")
    Call<TvShowDetailsResponse> getTVShowDetails(@Query("q") String tvShowId);
}
