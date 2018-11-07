package com.example.home.android_labs.Models;

import com.example.home.android_labs.Entity.Hit;

import java.util.List;

public interface MainInteractor {
    interface OnFinishedListener {
        void onFinished(List<Hit> noticeArrayList, boolean isChange);

        void onFailure(Throwable t);
    }

    void getHitArrayList(MainInteractor.OnFinishedListener onFinishedListener,
                         boolean isChange);
}
