package com.example.home.android_labs.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.home.android_labs.Entity.Hit;
import com.example.home.android_labs.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import static com.example.home.android_labs.MainActivity.DETAILS;
import static com.example.home.android_labs.MainActivity.FAVOURITES;

public class DetailsFragment extends Fragment {
    public static final int H = 1150;
    private Hit hit;
    private boolean isImageFitToScreen;
    private SharedPreferences mPrefs;
    private Bundle bundle;

    @BindView(R.id.image_details)
    ImageView imageView;
    @BindView(R.id.user_details)
    TextView user;
    @BindView(R.id.tags_details)
    TextView tags;
    @BindView(R.id.type_details)
    TextView type;
    @BindView(R.id.views_details)
    TextView views;
    @BindView(R.id.favourites_details)
    TextView favourites;
    @BindView(R.id.fav)
    ImageView fav;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_details, container, false);
        ButterKnife.bind(this, view);
        bundle = this.getArguments();
        getIncomingFragment();
        setItems();
        isFavourite();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controlImage();
            }
        });

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favouritesHandler();
            }
        });
        return view;
    }

    private void setItems() {
        Picasso.get().load(hit.getLargeImageURL()).into(imageView);
        user.setText(hit.getUser());
        tags.setText(hit.getTags());
        type.setText(hit.getType());
        views.setText(String.valueOf(hit.getViews()));
        favourites.setText(String.valueOf(hit.getFavorites()));
        mPrefs = getActivity().getSharedPreferences(FAVOURITES, Context.MODE_PRIVATE);
    }

    private void getIncomingFragment() {
        if (bundle != null) {
            hit = new Gson().fromJson(bundle.getString(DETAILS), Hit.class);
        }
    }

    private void controlImage() {
        if (isImageFitToScreen) {
            isImageFitToScreen = false;
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT, H));
        } else {
            isImageFitToScreen = true;
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams
                    .MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        }
    }

    private void favouritesHandler() {
        if (!mPrefs.contains(hit.getUser())) {
            fav.setImageResource(R.drawable.ic_favorite_black_24dp);
            mPrefs.edit().putString(hit.getUser(), new Gson().toJson(hit)).commit();
        } else {
            fav.setImageResource(R.drawable.ic_favorite_border_black_24dp);
            mPrefs.edit().remove(hit.getUser()).commit();
        }
    }

    private void isFavourite() {
        if (mPrefs.contains(hit.getUser()))
            fav.setImageResource(R.drawable.ic_favorite_black_24dp);
    }


}
