package com.example.home.android_labs.Presenters;

import com.example.home.android_labs.Entity.Hit;
import com.example.home.android_labs.Models.MainInteractor;
import com.example.home.android_labs.Models.MainInteractorImpl;
import com.example.home.android_labs.Presenters.MainPresenter;
import com.example.home.android_labs.Views.MainView;

import java.util.List;

public class MainPresenterImpl implements MainPresenter,
        MainInteractor.OnFinishedListener {

    private MainView view;
    private MainInteractor interactor;

    public MainPresenterImpl(MainView mainView) {
        this.view = mainView;
        this.interactor = new MainInteractorImpl();
    }

    @Override
    public void requestDataFromServer(boolean isChange) {
        interactor.getHitArrayList(this, isChange);
    }


    @Override
    public void onFinished(List<Hit> hitArrayList, boolean isChange) {
        if (view != null) {
            if (!isChange) {
                view.setDataToRecyclerView(hitArrayList);
            } else {
                view.refreshData(hitArrayList);
            }
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if (view != null) {
            view.onResponseFailure(t);
        }
    }
}
