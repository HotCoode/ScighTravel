package com.scightravel.model.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhay on 3/23/2015.
 */
public class Place implements Serializable {

    @SerializedName("location_name")
    private String locationName;
    @SerializedName("location_distance")
    private LocationDistance locationDistance;
    @SerializedName("location_image_url")
    private String locationImageUrl;
    @SerializedName("price_per_person")
    private PricePerPerson pricePerPerson;
    @SerializedName("weather_condition_icon_url")
    private String weatherConditionIconUrl;
    @SerializedName("location_tags")
    private List<LocationTag> locationTags = new ArrayList<LocationTag>();
    private boolean placeReady;

    public Place(String locationName, String locationImageUrl, String weatherConditionIconUrl,
                 LocationDistance locationDistance, PricePerPerson pricePerPerson,
                 List<LocationTag> locationTags) {

        this.locationName = locationName;
        this.locationDistance = locationDistance;
        this.locationImageUrl = locationImageUrl;
        this.pricePerPerson = pricePerPerson;
        this.weatherConditionIconUrl = weatherConditionIconUrl;
        this.locationTags = locationTags;
    }

    /**
     * @return The locationName
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * @param locationName The location_name
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * @return The locationDistance
     */
    public LocationDistance getLocationDistance() {
        return locationDistance;
    }

    /**
     * @param locationDistance The location_distance
     */
    public void setLocationDistance(LocationDistance locationDistance) {
        this.locationDistance = locationDistance;
    }

    /**
     * @return The locationImageUrl
     */
    public String getLocationImageUrl() {
        return locationImageUrl;
    }

    /**
     * @param locationImageUrl The location_image_url
     */
    public void setLocationImageUrl(String locationImageUrl) {
        this.locationImageUrl = locationImageUrl;
    }

    /**
     * @return The pricePerPerson
     */
    public PricePerPerson getPricePerPerson() {
        return pricePerPerson;
    }

    /**
     * @param pricePerPerson The price_per_person
     */
    public void setPricePerPerson(PricePerPerson pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    /**
     * @return The weatherConditionIconUrl
     */
    public String getWeatherConditionIconUrl() {
        return weatherConditionIconUrl;
    }

    /**
     * @param weatherConditionIconUrl The weather_condition_icon_url
     */
    public void setWeatherConditionIconUrl(String weatherConditionIconUrl) {
        this.weatherConditionIconUrl = weatherConditionIconUrl;
    }

    /**
     * @return The locationTags
     */
    public List<LocationTag> getLocationTags() {
        return locationTags;
    }

    /**
     * @param locationTags The location_tags
     */
    public void setLocationTags(List<LocationTag> locationTags) {
        this.locationTags = locationTags;
    }

    public void setPlaceReady(boolean movieReady) {

        this.placeReady = movieReady;
    }

    public boolean isPlaceReady() {

        return placeReady;
    }
}
