package com.example.home.android_labs.Models;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.home.android_labs.Entity.Hit;
import com.google.gson.Gson;

import java.util.Map;

import static com.example.home.android_labs.MainActivity.FAVOURITES;

public class FavouritesInteractorImpl implements FavouritesInteractor {
    public void getHitArrayList(Context context){
        /*SharedPreferences mPrefs = getActivity().getSharedPreferences(FAVOURITES, Context.MODE_PRIVATE);
        Map<String, ?> map = mPrefs.getAll();

        for (Map.Entry<String, ?> entry : map.entrySet()) {
            Hit hit = new Gson().fromJson(entry.getValue().toString(), Hit.class);
            mHitList.add(hit);
        }*/
    }
}
