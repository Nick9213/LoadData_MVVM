package com.example.apihandlingmvvm.responses;

import com.example.apihandlingmvvm.models.TvShowDetails;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TvShowDetailsResponse {
    @SerializedName("tvShow")
    @Expose
    private TvShowDetails tvShowDetails;

    public TvShowDetails getTvShowDetails() {
        return tvShowDetails;
    }

}
