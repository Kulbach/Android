package com.example.home.android_labs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UsersActivity extends AppCompatActivity {
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list = new ArrayList<>();

        ListView lvMain = (ListView) findViewById(R.id.lvMain);

        SharedPreferences mPrefs = getSharedPreferences("MyPrefs",
                Context.MODE_PRIVATE);
        Map<String, ?> map = mPrefs.getAll();

        for(Map.Entry<String,?> entry : map.entrySet()){
            Gson gson = new Gson();
            String json = entry.getValue().toString();
            Log.e("Переменная json", "кек");
            Users user = gson.fromJson(json, Users.class);
            String info = user.getFirstName() + "\n" + user.getLastName() + "\n" + user.getPhone();
            list.add(info);
            }




        Log.e("Длина массива", Integer.toString(list.size()));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);

        lvMain.setAdapter(adapter);

    }

}
