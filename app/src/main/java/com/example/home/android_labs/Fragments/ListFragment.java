package com.example.home.android_labs.Fragments;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.android_labs.Adapters.CustomRecycleAdapter;
import com.example.home.android_labs.Entity.Hit;
import com.example.home.android_labs.HitIntractorImpl;
import com.example.home.android_labs.MainList;
import com.example.home.android_labs.MainPresenterImpl;
import com.example.home.android_labs.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListFragment extends Fragment implements MainList.MainView {
    private CustomRecycleAdapter mAdapter;
    private boolean isChange = false;
    private MainList.MainPresenter presenter;

    @BindView(R.id.lvMain)
    RecyclerView mRecycleView;
    @BindView(R.id.list_empty)
    TextView noData;
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.move)
    Button mMoveToFavourites;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_main, container, false);
        ButterKnife.bind(this, view);
        initializeRecyclerView();

        presenter = new MainPresenterImpl(this, new HitIntractorImpl());
        getData();
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isChange = true;
                getData();
            }
        });

        return view;
    }


    private void initializeRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecycleView.setLayoutManager(layoutManager);
    }

    private void getData(){
        presenter.requestDataFromServer(isChange);
    }

    @Override
    public void setDataToRecyclerView(List<Hit> hitArrayList) {
        mAdapter = new CustomRecycleAdapter(getActivity(), hitArrayList);
        mRecycleView.setAdapter(mAdapter);
    }

    @Override
    public void refreshData(List<Hit> hits) {
        mAdapter.clear();
        mAdapter.addAll(hits);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(getActivity(), R.string.unsuccessful_response
                + throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

}
