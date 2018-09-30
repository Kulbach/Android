package com.example.home.android_labs;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.android_labs.Entity.Flowers;
import com.example.home.android_labs.Entity.Hit;
import com.example.home.android_labs.Retrofit.RetroClient;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RetroClient retroClient = new RetroClient();
    private Call<Flowers> call = retroClient.getApiService().getData();
    private ListView mListMain;
    private CustomListAdapter mAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private TextView noData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mListMain = findViewById(R.id.lvMain);
        noData = findViewById(R.id.list_empty);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                makeCall();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        makeCall();
    }

    private void makeCall() {
        call.clone().enqueue(new Callback<Flowers>() {
            @Override
            public void onResponse(Call<Flowers> call, Response<Flowers> response) {
                Toast.makeText(MainActivity.this, R.string.successful_response,
                        Toast.LENGTH_LONG).show();
                if (response.body() == null) {
                    noData.setText(R.string.no_data);
                } else {
                    List<Hit> hits = response.body().getHits();
                    setmAdapter(hits);
                }
            }

            @Override
            public void onFailure(Call<Flowers> call, Throwable t) {
                Toast.makeText(MainActivity.this, R.string.unsuccessful_response
                        + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void setmAdapter(List<Hit> hits) {
        mAdapter = new CustomListAdapter(getApplicationContext(), R.layout.listview_layout, hits);
        mListMain.setAdapter(mAdapter);
    }

}
