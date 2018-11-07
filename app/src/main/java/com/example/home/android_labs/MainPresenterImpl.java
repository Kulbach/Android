package com.example.home.android_labs;

import com.example.home.android_labs.Entity.Hit;

import java.util.List;

public class MainPresenterImpl implements MainList.MainPresenter,
        MainList.HitIntractor.OnFinishedListener {

    private MainList.MainView view;
    private MainList.HitIntractor interactor;

    public MainPresenterImpl(MainList.MainView mainView, MainList.HitIntractor hitIntractor) {
        this.view = mainView;
        this.interactor = hitIntractor;
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
