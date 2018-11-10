package com.example.home.android_labs.Presenters;

import com.example.home.android_labs.Entity.Hit;
import com.example.home.android_labs.Models.DetailsInteractor;
import com.example.home.android_labs.Models.DetailsInteractorImpl;
import com.example.home.android_labs.Repositories.DetailsRepository;
import com.example.home.android_labs.Views.DetailsView;

public class DetailsPresenterImpl implements DetailsPresenter, DetailsInteractor.OnFinishedListener{

    private DetailsView view;
    private DetailsInteractor interactor;
    DetailsRepository repository;

    public DetailsPresenterImpl(DetailsView view,
                                DetailsRepository repository) {
        this.repository = repository;
        this.view = view;
        this.interactor = new DetailsInteractorImpl(repository, this);
    }

    @Override
    public void onAdd() {
        view.addToFavourite();
    }

    @Override
    public void onRemove() {
        view.removeFromFavourite();
    }

    public void checkFavourite(Hit hit) {
        interactor.doFavourite(hit);
    }

    public void ifFavourite(Hit hit) {
        interactor.isFavourite(hit);
    }

    @Override
    public void favouriteResult(boolean favourite) {
        view.isFavourite(favourite);
    }

    public void getHit() {
        interactor.getHit();
    }

    @Override
    public void setHit(Hit hit) {
        view.setHit(hit);
    }
}
