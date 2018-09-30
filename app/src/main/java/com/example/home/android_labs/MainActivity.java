package com.example.home.android_labs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.home.android_labs.Entity.Flowers;
import com.example.home.android_labs.Entity.Hit;
import com.example.home.android_labs.Retrofit.RetroClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RetroClient retroClient = new RetroClient();
    private Call<Flowers> call = retroClient.getApiService().getData();
    private ListView mListMain;
    private ArrayAdapter<String> mAdapter;
    private List<String> mList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mListMain = findViewById(R.id.lvMain);

        makeCall();
    }

    private void makeCall() {
        call.enqueue(new Callback<Flowers>() {
            @Override
            public void onResponse(Call<Flowers> call, Response<Flowers> response) {
                Toast.makeText(MainActivity.this, R.string.successful_response,
                        Toast.LENGTH_LONG).show();
                List<Hit> hits = response.body().getHits();
                hitsToString(hits);
            }

            @Override
            public void onFailure(Call<Flowers> call, Throwable t) {
                Toast.makeText(MainActivity.this, R.string.unsuccessful_response
                        + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void hitsToString(List<Hit> hits) {
        for (Hit hit : hits)
            mList.add(hit.toString());
        setmAdapter();
    }

    private void setmAdapter() {
        mAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, mList);
        mListMain.setAdapter(mAdapter);
    }
}
