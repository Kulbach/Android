package com.example.home.android_labs.Models;

import android.content.Context;

import com.example.home.android_labs.Entity.Hit;

import java.util.List;

public interface FavouritesInteractor {
    interface OnFinishedListener {
        void addData(List<Hit> hits);
    }
    void getHitArrayList();
}
