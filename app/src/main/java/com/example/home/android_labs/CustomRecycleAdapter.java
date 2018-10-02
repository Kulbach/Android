package com.example.home.android_labs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.home.android_labs.Entity.Hit;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomRecycleAdapter extends RecyclerView.Adapter<CustomRecycleAdapter.ViewHolder>  {

    private List<Hit> mHits;

    public CustomRecycleAdapter(List<Hit> hits) {
        mHits = hits;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.listview_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.userName.setText(mHits.get(position).getUser());
        holder.tags.setText(mHits.get(position).getTags());
        Picasso.get().load(mHits.get(position).getLargeImageURL()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mHits.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView userName;
        TextView tags;

        ViewHolder(View convertView) {
            super(convertView);
            imageView = convertView.findViewById(R.id.image);
            userName =  convertView.findViewById(R.id.user);
            tags =  convertView.findViewById(R.id.tags);
        }
    }
}
