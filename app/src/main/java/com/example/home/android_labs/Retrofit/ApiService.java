package com.example.home.android_labs.Retrofit;

import com.example.home.android_labs.Entity.Flowers;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/api/?key=10256923-441119506eccb063322b5e8fc&q=yellow+flowers&image_type=photo")
    Call<Flowers> getData();
}
