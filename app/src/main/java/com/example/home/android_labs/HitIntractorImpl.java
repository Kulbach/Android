package com.example.home.android_labs;

import android.widget.Toast;

import com.example.home.android_labs.Entity.Flowers;
import com.example.home.android_labs.Entity.Hit;
import com.example.home.android_labs.Retrofit.RetroClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HitIntractorImpl implements MainList.HitIntractor {
    @Override
    public void getHitArrayList(final OnFinishedListener onFinishedListener, final boolean isChange){
        Call<Flowers> call = RetroClient.getApiService().getData();
        call.clone().enqueue(new Callback<Flowers>() {
            @Override
            public void onResponse(Call<Flowers> call, Response<Flowers> response) {
                onFinishedListener.onFinished(response.body().getHits(), isChange);
            }

            @Override
            public void onFailure(Call<Flowers> call, Throwable t) {
               onFinishedListener.onFailure(t);
            }
        });
    }
}
