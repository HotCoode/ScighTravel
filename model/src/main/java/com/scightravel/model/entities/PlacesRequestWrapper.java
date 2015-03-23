package com.scightravel.model.entities;

import java.util.List;

/**
 * Created by abhay on 3/23/2015.
 */
public class PlacesRequestWrapper {

    String currentLocation;
    String preferredLocation;
    List<String> themes;
    String month;
    Range distanceRange;

    public PlacesRequestWrapper(String currentLocation, String preferredLocation, List<String> themes, String month, Range distanceRange) {
        this.currentLocation = currentLocation;
        this.preferredLocation = preferredLocation;
        this.themes = themes;
        this.month = month;
        this.distanceRange = distanceRange;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    public List<String> getThemes() {
        return themes;
    }

    public void setThemes(List<String> themes) {
        this.themes = themes;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Range getDistanceRange() {
        return distanceRange;
    }

    public void setDistanceRange(Range distanceRange) {
        this.distanceRange = distanceRange;
    }
}
