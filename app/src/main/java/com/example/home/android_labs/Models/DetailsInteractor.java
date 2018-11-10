package com.example.home.android_labs.Models;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.home.android_labs.Entity.Hit;
import com.example.home.android_labs.Presenters.DetailsPresenter;

public interface DetailsInteractor {

    interface OnFinishedListener {
        void onAdd();
        void onRemove();
        void favouriteResult(boolean change);
        void setHit(Hit hit);
    }

    void doFavourite(Hit hit);
    void isFavourite(Hit hit);
    void getHit();
}
