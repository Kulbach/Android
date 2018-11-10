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
import com.example.home.android_labs.Presenters.FavouritesPresenter;
import com.example.home.android_labs.Presenters.FavouritesPresenterImpl;
import com.example.home.android_labs.R;
import com.example.home.android_labs.Repositories.FavouritesRepository;
import com.example.home.android_labs.Views.FavouritesView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.home.android_labs.MainActivity.FAVOURITES;

public class FavouritesFragment extends Fragment implements FavouritesView {

    private CustomRecycleAdapter mAdapter;
    private FavouritesRepository repository;
    private FavouritesPresenter presenter;

    @BindView(R.id.lvMain)
    RecyclerView mRecycleView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_favourites, container, false);
        ButterKnife.bind(this, view);
        repository = new FavouritesRepository(getActivity());
        presenter = new FavouritesPresenterImpl(this, repository);
        initializeRecyclerView();
        getFavourites();
        return view;
    }

    private void getFavourites() {
        presenter.requestDataFromStorage();
    }

    private void initializeRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecycleView.setLayoutManager(layoutManager);
    }

    @Override
    public void setDataToRecyclerView(List<Hit> hits) {
        mAdapter = new CustomRecycleAdapter(getActivity(), hits);
        mRecycleView.setAdapter(mAdapter);
    }

}
