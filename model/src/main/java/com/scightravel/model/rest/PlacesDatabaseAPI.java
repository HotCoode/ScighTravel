package com.scightravel.model.rest;

import com.scightravel.model.entities.PlacesWrapper;

import retrofit.Callback;
import retrofit.http.POST;

/**
 * Created by abhay on 3/23/2015.
 */
public interface PlacesDatabaseAPI {

    @POST("/api/places/")
    void getPlaces(
            Callback<PlacesWrapper> callback);
}


