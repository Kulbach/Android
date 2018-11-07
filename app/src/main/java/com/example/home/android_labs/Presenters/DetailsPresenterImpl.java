package com.example.home.android_labs.Presenters;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.home.android_labs.Entity.Hit;
import com.example.home.android_labs.Models.DetailsInteractor;
import com.example.home.android_labs.Views.DetailsView;

public class DetailsPresenterImpl implements DetailsPresenter {

    private DetailsView view;
    private DetailsInteractor interactor;

    public DetailsPresenterImpl(DetailsView view, DetailsInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }
    public void onAdd(){
        view.addToFavourite();
    }

    public void onRemove(){
        view.removeFromFavourite();
    }
    public void checkFavourite(Context context, Hit hit) {
        interactor.doFavourite(context, hit, this);
    }

    public void ifFavourite(Context context, Hit hit){
        interactor.isFavourite(context, hit, this);
    }

    public void  favouriteResult(boolean favourite){
        view.isFavourite(favourite);
    }

    public void getHit(Fragment fragment){
        interactor.getHit(fragment, this);
    }

    public void setHit(Hit hit){
        view.setHit(hit);
    }
}
