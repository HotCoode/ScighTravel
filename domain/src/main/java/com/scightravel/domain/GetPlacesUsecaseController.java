package com.scightravel.domain;

import com.scigh.BusProvider;
import com.scightravel.model.entities.PlacesWrapper;
import com.scightravel.model.rest.RestDataSource;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

/**
 * Created by abhay on 3/23/2015.
 */
public class GetPlacesUsecaseController implements GetPlacesUsecase {

    private final RestDataSource mDataSource;
    private final Bus mUiBus;

    /**
     * Constructor of the class.
     *
     * @param uiBus The bus to communicate the domain module and the app module
     * @param dataSource The data source to retrieve the list of movies
     */
    public GetPlacesUsecaseController(RestDataSource dataSource, Bus uiBus) {

        if (dataSource == null)
            throw new IllegalArgumentException("RestDataSource cannot be null");

        if (uiBus == null)
            throw new IllegalArgumentException("Bus cannot be null");

        mDataSource = dataSource;
        mUiBus = uiBus;

        BusProvider.getRestBusInstance().register(this);
    }

    @Override
    public void requestPlaces() {
        mDataSource.getPlaces();
    }

    @Subscribe
    @Override
    public void onPlacesReceived(PlacesWrapper response) {

        sendPlacesToPresenter(response);
    }

    @Override
    public void sendPlacesToPresenter (PlacesWrapper response) {

        mUiBus.post(response);
    }

    @Override
    public void unRegister() {

        BusProvider.getRestBusInstance().unregister(this);
    }

    @Override
    public void execute() {
        requestPlaces();
    }
}
