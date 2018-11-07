package com.example.home.android_labs.Presenters;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.home.android_labs.Entity.Hit;

public interface DetailsPresenter {
    void checkFavourite(Context context, Hit hit);
    void onAdd();
    void onRemove();
    void ifFavourite(Context context, Hit hit);
    void favouriteResult(boolean favourite);
    void getHit(Fragment fragment);
    void setHit(Hit hit);
}
