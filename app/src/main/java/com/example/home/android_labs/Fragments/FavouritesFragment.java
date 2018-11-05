package com.example.home.android_labs.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.home.android_labs.Adapters.CustomRecycleAdapter;
import com.example.home.android_labs.Entity.Hit;
import com.example.home.android_labs.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.home.android_labs.MainActivity.FAVOURITES;

public class FavouritesFragment extends Fragment {

    private CustomRecycleAdapter mAdapter;
    private List<Hit> mHitList;
    private SharedPreferences mPrefs;

    @BindView(R.id.lvMain)
    RecyclerView mRecycleView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_favourites, container, false);
        ButterKnife.bind(this, view);
        mHitList = new ArrayList<>();
        getFavourites();
        setmAdapter(mHitList, mAdapter, mRecycleView, getActivity());
        return view;
    }

    private void getFavourites() {
        mPrefs = getActivity().getSharedPreferences(FAVOURITES, Context.MODE_PRIVATE);
        Map<String, ?> map = mPrefs.getAll();

        for (Map.Entry<String, ?> entry : map.entrySet()) {
            Hit hit = new Gson().fromJson(entry.getValue().toString(), Hit.class);
            mHitList.add(hit);
        }
    }

    public void setmAdapter(List<Hit> hits, CustomRecycleAdapter adapter,
                            RecyclerView recyclerView, Activity activity) {
        adapter = new CustomRecycleAdapter(activity, hits);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
