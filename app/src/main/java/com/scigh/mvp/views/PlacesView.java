package com.scigh.mvp.views;

import com.scightravel.model.entities.Place;

import java.util.List;


/**
 * Created by abhay on 3/23/2015.
 */
public interface PlacesView extends MVPView {

    void showPlaces(List<Place> placesList);

    void showLoading ();

    void hideLoading ();

    void showError (String error);

    void hideError ();

    void showLoadingLabel();

    void hideActionLabel ();

    boolean isTheListEmpty ();

    void appendPlaces (List<Place> movieList);
}

