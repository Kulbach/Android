package com.example.home.android_labs;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.home.android_labs.Entity.Hit;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends ArrayAdapter<Hit> {

    List<Hit> mHits;
    Context mContext;
    int mResource;

    public CustomListAdapter(Context context, int resource, List<Hit> objects) {
        super(context, resource, objects);
        mHits = objects;
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listview_layout,
                    null, true);
        }

        Hit hit = getItem(position);

        ImageView imageView = convertView.findViewById(R.id.image);
        Picasso.get().load(hit.getLargeImageURL()).into(imageView);
        TextView userName = convertView.findViewById(R.id.user);
        userName.setText("By " +  hit.getUser());
        TextView tags = convertView.findViewById(R.id.tags);
        tags.setText("tags: " + hit.getTags());

        return convertView;
    }
}
