package com.example.home.android_labs.Models;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.home.android_labs.Entity.Hit;
import com.example.home.android_labs.Repositories.FavouritesRepository;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.example.home.android_labs.MainActivity.FAVOURITES;

public class FavouritesInteractorImpl implements FavouritesInteractor {

    FavouritesRepository repository;
    FavouritesInteractor.OnFinishedListener onFinishedListener;

    public FavouritesInteractorImpl(FavouritesRepository repository,
                                 OnFinishedListener onFinishedListener) {
        this.repository = repository;
        this.onFinishedListener = onFinishedListener;
    }

    public void getHitArrayList(){
        SharedPreferences mPrefs = repository.getContext().
                getSharedPreferences(FAVOURITES, Context.MODE_PRIVATE);
        List<Hit> hits = new ArrayList<>();
        Map<String, ?> map = mPrefs.getAll();

        for (Map.Entry<String, ?> entry : map.entrySet()) {
            Hit hit = new Gson().fromJson(entry.getValue().toString(), Hit.class);
            hits.add(hit);
        }
        onFinishedListener.addData(hits);
    }
}
