package com.example.home.android_labs.Presenters;

import com.example.home.android_labs.Entity.Hit;
import com.example.home.android_labs.Models.FavouritesInteractor;
import com.example.home.android_labs.Models.FavouritesInteractorImpl;
import com.example.home.android_labs.Repositories.FavouritesRepository;
import com.example.home.android_labs.Views.FavouritesView;

import java.util.List;

public class FavouritesPresenterImpl implements FavouritesPresenter,
        FavouritesInteractor.OnFinishedListener {

    FavouritesView view;
    FavouritesInteractor interactor;
    FavouritesRepository repository;

    public FavouritesPresenterImpl(FavouritesView view, FavouritesRepository repository) {
        this.view = view;
        this.repository = repository;
        this.interactor = new FavouritesInteractorImpl(repository, this);
    }

    public void addData(List<Hit> hits) {
        view.setDataToRecyclerView(hits);
    }

    public void requestDataFromStorage() {
        interactor.getHitArrayList();
    }
}
