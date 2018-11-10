package com.example.home.android_labs.Models;
import com.example.home.android_labs.Entity.Hit;

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
