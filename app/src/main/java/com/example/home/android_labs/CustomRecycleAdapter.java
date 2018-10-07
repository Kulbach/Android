package com.example.home.android_labs;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.home.android_labs.Entity.Hit;
import com.squareup.picasso.Picasso;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import static com.example.home.android_labs.MainActivity.DETAILS;

public class CustomRecycleAdapter extends RecyclerView.Adapter<CustomRecycleAdapter.ViewHolder>  {

    private List<Hit> mHits;
    private Context mContext;


    public CustomRecycleAdapter(Context context, List<Hit> hits) {
        mContext = context;
        mHits = hits;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.listview_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.userName.setText(mHits.get(position).getUser());
        holder.tags.setText(mHits.get(position).getTags());
        Picasso.get().load(mHits.get(position).getLargeImageURL()).into(holder.imageView);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtra(DETAILS, new Gson().toJson(mHits.get(position)));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mHits.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView userName;
        TextView tags;
        LinearLayout parentLayout;

        ViewHolder(View convertView) {
            super(convertView);
            imageView = convertView.findViewById(R.id.image);
            userName =  convertView.findViewById(R.id.user);
            tags =  convertView.findViewById(R.id.tags);
            parentLayout = convertView.findViewById(R.id.parent_layout);
        }
    }
}
