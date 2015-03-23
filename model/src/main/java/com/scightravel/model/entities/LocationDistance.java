package com.scightravel.model.entities;

import java.io.Serializable;

public class LocationDistance implements Serializable {

    private String unit;
    private int distance;

    public LocationDistance(String unit, int distance) {

        this.unit = unit;
        this.distance = distance;
    }


    /**
     * @return The unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit The unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return The distance
     */
    public int getDistance() {
        return distance;
    }

    /**
     * @param distance The distance
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }
}