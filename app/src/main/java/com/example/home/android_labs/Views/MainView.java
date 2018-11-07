package com.example.home.android_labs.Views;

import com.example.home.android_labs.Entity.Hit;

import java.util.List;

public interface MainView {
    void setDataToRecyclerView(List<Hit> noticeArrayList);
    void refreshData(List<Hit> hits);
    void onResponseFailure(Throwable throwable);
}
