package com.example.home.android_labs.Models;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.home.android_labs.Entity.Hit;
import com.example.home.android_labs.Repositories.DetailsRepository;
import com.google.gson.Gson;

import static com.example.home.android_labs.MainActivity.DETAILS;
import static com.example.home.android_labs.MainActivity.FAVOURITES;

public class DetailsInteractorImpl implements DetailsInteractor {

    DetailsRepository repository;
    DetailsInteractor.OnFinishedListener onFinishedListener;
    SharedPreferences mPrefs;

    public DetailsInteractorImpl(DetailsRepository repository,
                                 OnFinishedListener onFinishedListener) {
        this.repository = repository;
        this.onFinishedListener = onFinishedListener;
        this.mPrefs = repository.getContext().
                getSharedPreferences(FAVOURITES, Context.MODE_PRIVATE);
    }

    public void doFavourite(Hit hit) {
        if (!mPrefs.contains(hit.getUser())) {
            mPrefs.edit().putString(hit.getUser(), new Gson().toJson(hit)).commit();
            onFinishedListener.onAdd();
        } else {
            mPrefs.edit().remove(hit.getUser()).commit();
            onFinishedListener.onRemove();
        }
    }

    public void isFavourite(Hit hit) {
        if (mPrefs.contains(hit.getUser())) {
            onFinishedListener.favouriteResult(true);
        } else {
            onFinishedListener.favouriteResult(false);
        }
    }

    public void getHit() {
        Bundle bundle = repository.getFragment().getArguments();
        if (bundle != null) {
            Hit hit = new Gson().fromJson(bundle.getString(DETAILS), Hit.class);
            onFinishedListener.setHit(hit);
        }
    }
}
