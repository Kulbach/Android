package com.example.home.android_labs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.example.home.android_labs.Entity.Hit;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.example.home.android_labs.DetailsActivity.FAVOURITES;

public class FavouritesActivity extends AppCompatActivity {

    private CustomRecycleAdapter mAdapter;
    private List<Hit> mHitList;
    private RecyclerView mRecycleView;
    private SharedPreferences mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);
        mHitList = new ArrayList<>();
        mRecycleView = findViewById(R.id.lvMain);

        getFavourites();
        new MainActivity().setmAdapter(mHitList, mAdapter, mRecycleView,
                FavouritesActivity.this);

    }

    private void getFavourites() {
        mPrefs = getSharedPreferences(FAVOURITES, Context.MODE_PRIVATE);
        Map<String, ?> map = mPrefs.getAll();

        for (Map.Entry<String, ?> entry : map.entrySet()) {
            Hit hit = new Gson().fromJson(entry.getValue().toString(), Hit.class);
            mHitList.add(hit);
        }
    }
}
