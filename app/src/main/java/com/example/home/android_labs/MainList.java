package com.example.home.android_labs;

import com.example.home.android_labs.Entity.Hit;

import java.util.List;

public interface MainList {

    interface MainPresenter{

        void requestDataFromServer(boolean isChange);

    }

    interface MainView {

        void setDataToRecyclerView(List<Hit> noticeArrayList);
        void refreshData(List<Hit> hits);

        void onResponseFailure(Throwable throwable);

    }

    /**
     * Intractors are classes built for fetching data from your database, web services, or any other data source.
     **/
    interface HitIntractor {

        interface OnFinishedListener {
            void onFinished(List<Hit> noticeArrayList, boolean isChange);
            void onFailure(Throwable t);
        }

        void getHitArrayList(OnFinishedListener onFinishedListener, boolean isChange);
    }
}
