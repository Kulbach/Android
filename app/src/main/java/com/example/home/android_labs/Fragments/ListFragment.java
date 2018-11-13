package com.example.home.android_labs.Fragments;

import android.app.Activity;
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
import com.example.home.android_labs.Entity.Flowers;
import com.example.home.android_labs.Entity.Hit;
import com.example.home.android_labs.MainActivity;
import com.example.home.android_labs.R;
import com.example.home.android_labs.Retrofit.RetroClient;

import java.util.List;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListFragment extends Fragment {
    private CustomRecycleAdapter mAdapter;
    private boolean isChange = false;

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

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isChange = true;
                makeCall();
            }
        });

       mMoveToFavourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) v.getContext()).setFragment(new FavouritesFragment());
            }
        });

        makeCall();
        return view;
    }

    private void makeCall() {
        Call<Flowers> call = RetroClient.getApiService().getData();
        call.clone().enqueue(new Callback<Flowers>() {
            @Override
            public void onResponse(Call<Flowers> call, Response<Flowers> response) {
                Toast.makeText(getActivity(), R.string.successful_response,
                        Toast.LENGTH_LONG).show();
                if (response.body() == null) {
                    noData.setText(R.string.no_data);
                } else {
                    List<Hit> hits = response.body().getHits();
                    if(!isChange) {
                    setmAdapter(hits, mRecycleView, getActivity());
                    } else {
                        refreshData(hits);
                    }
                }
            }

            @Override
            public void onFailure(Call<Flowers> call, Throwable t) {
                Toast.makeText(getActivity(), R.string.unsuccessful_response
                        + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setmAdapter(List<Hit> hits,
                            RecyclerView recyclerView, Activity activity) {
        mAdapter = new CustomRecycleAdapter(activity, hits);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
    }

    public void refreshData(List<Hit> hits){
        mAdapter.clear();
        mAdapter.addAll(hits);
        mSwipeRefreshLayout.setRefreshing(false);
    }


}
