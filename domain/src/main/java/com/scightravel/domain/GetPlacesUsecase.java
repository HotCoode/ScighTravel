package com.scightravel.domain;


import com.scightravel.model.entities.PlacesWrapper;

/**
 * Created by abhay on 3/23/2015.
 */
public interface GetPlacesUsecase extends Usecase {

    /**
     * Callback used to be notified when the places have been
     * received
     *
     * @param response the response containing a list with places
     */
    public void onPlacesReceived(PlacesWrapper response);

    /**
     * Request datasource for places
     */
    public void requestPlaces();

    /**
     * Sends the PlacesApiResponse through the communication system
     * to be received by the presenter in another module
     *
     * @param response the response containing a list with places
     */
    public void sendPlacesToPresenter(PlacesWrapper response);

    public void unRegister();
}
