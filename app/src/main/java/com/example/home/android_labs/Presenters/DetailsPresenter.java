package com.example.home.android_labs.Presenters;

import com.example.home.android_labs.Entity.Hit;

public interface DetailsPresenter {
    void checkFavourite(Hit hit);
    void ifFavourite(Hit hit);
    void getHit();
}
