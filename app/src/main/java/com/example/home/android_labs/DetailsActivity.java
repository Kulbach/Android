package com.example.home.android_labs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.home.android_labs.Entity.Hit;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.home.android_labs.MainActivity.DETAILS;


public class DetailsActivity extends AppCompatActivity {

    public static final String FAVOURITES = "Favourites";
    public static final int H = 1150;
    private Hit hit;
    private boolean isImageFitToScreen;
    private SharedPreferences mPrefs;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        initializeItems();
        getIncomingIntent();
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
    }

    private void initializeItems() {
        imageView = findViewById(R.id.image_details);
        user = findViewById(R.id.user_details);
        tags = findViewById(R.id.tags_details);
        type = findViewById(R.id.type_details);
        views = findViewById(R.id.views_details);
        favourites = findViewById(R.id.favourites_details);
        fav = findViewById(R.id.fav);
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra(DETAILS)) {
            hit = new Gson().fromJson(getIntent().getStringExtra("details"), Hit.class);
        }
    }

    private void setItems() {
        Picasso.get().load(hit.getLargeImageURL()).into(imageView);
        user.setText(hit.getUser());
        tags.setText(hit.getTags());
        type.setText(hit.getType());
        views.setText(String.valueOf(hit.getViews()));
        favourites.setText(String.valueOf(hit.getFavorites()));
        mPrefs = getSharedPreferences(FAVOURITES, Context.MODE_PRIVATE);
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
