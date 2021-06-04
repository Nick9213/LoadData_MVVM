package com.example.apihandlingmvvm.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.apihandlingmvvm.constants.Constants.BASE_URL;

public class ApiClient {
    public static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if (retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
