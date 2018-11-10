package com.example.home.android_labs.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.home.android_labs.Entity.Hit;
import com.example.home.android_labs.Presenters.DetailsPresenter;
import com.example.home.android_labs.Presenters.DetailsPresenterImpl;
import com.example.home.android_labs.R;
import com.example.home.android_labs.Repositories.DetailsRepository;
import com.example.home.android_labs.Views.DetailsView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsFragment extends Fragment implements DetailsView {
    public static final int H = 1150;
    private Hit hit;
    private boolean isImageFitToScreen;
    private DetailsPresenter presenter;
    private DetailsRepository repository;

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
        repository = new DetailsRepository(getActivity(), this);
        presenter = new DetailsPresenterImpl(this, repository);
        getHit();
        setItems();
        ifFavouriteOnStart();

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
    }

    public void getHit() {
        presenter.getHit();
    }

    public void ifFavouriteOnStart() {
        presenter.ifFavourite(hit);
    }

    public void favouritesHandler() {
        presenter.checkFavourite(hit);
    }

    @Override
    public void setHit(Hit hit) {
        this.hit = hit;
    }

    @Override
    public void addToFavourite() {
        fav.setImageResource(R.drawable.ic_favorite_black_24dp);
    }

    @Override
    public void removeFromFavourite() {
        fav.setImageResource(R.drawable.ic_favorite_border_black_24dp);
    }

    @Override
    public void isFavourite(boolean favourite) {
        if (favourite)
            fav.setImageResource(R.drawable.ic_favorite_black_24dp);
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
}
