package com.example.home.android_labs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.android_labs.Entity.Flowers;
import com.example.home.android_labs.Entity.Hit;
import com.example.home.android_labs.Retrofit.RetroClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String DETAILS = "details";
    private CustomRecycleAdapter mAdapter;

    @BindView(R.id.lvMain)
    RecyclerView mRecycleView;
    @BindView(R.id.list_empty)
    TextView noData;
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.move)
    Button mMoveToFavourites;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                makeCall();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        mMoveToFavourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        FavouritesActivity.class);
                startActivity(intent);
            }
        });

        makeCall();
    }

    private void makeCall() {
        Call<Flowers> call = RetroClient.getApiService().getData();
        call.clone().enqueue(new Callback<Flowers>() {
            @Override
            public void onResponse(Call<Flowers> call, Response<Flowers> response) {
                Toast.makeText(MainActivity.this, R.string.successful_response,
                        Toast.LENGTH_LONG).show();
                if (response.body() == null) {
                    noData.setText(R.string.no_data);
                } else {
                    List<Hit> hits = response.body().getHits();
                    setmAdapter(hits, mAdapter, mRecycleView, MainActivity.this);
                }
            }

            @Override
            public void onFailure(Call<Flowers> call, Throwable t) {
                Toast.makeText(MainActivity.this, R.string.unsuccessful_response
                        + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void setmAdapter(List<Hit> hits, CustomRecycleAdapter adapter,
                            RecyclerView recyclerView, Activity activity) {
        adapter = new CustomRecycleAdapter(activity, hits);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
