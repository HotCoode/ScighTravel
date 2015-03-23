package com.scightravel.model.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by abhay on 3/23/2015.
 * This class takes the Place array and can implement pagination when required
 */

public class PlacesWrapper implements Serializable {

    @SerializedName("response")
    private List<Place> response;

    public PlacesWrapper(List<Place> response) {
        this.response = response;
    }

    public List<Place> getResponse() {
        return response;
    }
}
