package com.example.home.android_labs.Retrofit;

import com.example.home.android_labs.Retrofit.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {
    /**********URL********/
    private static final String ROOT_URL = "https://pixabay.com";

    /**
     * Get Retrofit Instance
     */

    private RetroClient(){};

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Get Api Service
     */

    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }
}
