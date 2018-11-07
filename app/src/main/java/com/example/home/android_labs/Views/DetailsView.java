package com.example.home.android_labs.Views;

import com.example.home.android_labs.Entity.Hit;

public interface DetailsView {
    void addToFavourite();
    void removeFromFavourite();
    void isFavourite(boolean favourite);
    void setHit(Hit hit);

}
