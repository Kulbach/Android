package com.example.home.android_labs.Models;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.home.android_labs.Entity.Hit;
import com.example.home.android_labs.Presenters.DetailsPresenter;

public interface DetailsInteractor {
    void doFavourite(Context context, Hit hit, DetailsPresenter detailsPeresenter);
    void isFavourite(Context context, Hit hit, DetailsPresenter detailsPeresenter);
    void getHit(Fragment fragment, DetailsPresenter presenter);
}
