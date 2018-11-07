package com.example.home.android_labs.Models;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.home.android_labs.Entity.Hit;
import com.example.home.android_labs.Presenters.DetailsPresenter;
import com.google.gson.Gson;

import static com.example.home.android_labs.MainActivity.DETAILS;
import static com.example.home.android_labs.MainActivity.FAVOURITES;

public class DetailsInteractorImpl implements DetailsInteractor {

    public void doFavourite(Context context, Hit hit, DetailsPresenter detailsPeresenter) {
        SharedPreferences mPrefs = context.getSharedPreferences(FAVOURITES, Context.MODE_PRIVATE);
        if (!mPrefs.contains(hit.getUser())) {
            mPrefs.edit().putString(hit.getUser(), new Gson().toJson(hit)).commit();
            detailsPeresenter.onAdd();
        } else {
            mPrefs.edit().remove(hit.getUser()).commit();
            detailsPeresenter.onRemove();
        }
    }

    public void isFavourite(Context context, Hit hit, DetailsPresenter detailsPeresenter) {
        SharedPreferences mPrefs = context.getSharedPreferences(FAVOURITES, Context.MODE_PRIVATE);
        if (mPrefs.contains(hit.getUser())) {
            detailsPeresenter.favouriteResult(true);
        } else {
            detailsPeresenter.favouriteResult(false);
        }
    }

    public void getHit(Fragment fragment, DetailsPresenter detailsPeresenter) {
        Bundle bundle = fragment.getArguments();
        if (bundle != null) {
            Hit hit = new Gson().fromJson(bundle.getString(DETAILS), Hit.class);
            detailsPeresenter.setHit(hit);
        }
    }
}
