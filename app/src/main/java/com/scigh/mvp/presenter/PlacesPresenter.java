package com.scigh.mvp.presenter;

import android.util.Log;

import com.scigh.BusProvider;
import com.scigh.mvp.views.PlacesView;
import com.scightravel.domain.GetPlacesUsecaseController;
import com.scightravel.model.entities.PlacesWrapper;
import com.scightravel.model.rest.RestPlacesSource;
import com.squareup.otto.Subscribe;


/**
 * Created by abhay on 3/23/2015.
 */
public class PlacesPresenter extends Presenter {

    private final PlacesView mPlacesView;
    private GetPlacesUsecaseController mGetPlaces;

    private boolean isLoading = false;
    private boolean mRegistered;


    public PlacesPresenter(PlacesView placesView) {

        mPlacesView = placesView;
        mGetPlaces = new GetPlacesUsecaseController(
                RestPlacesSource.getInstance(), BusProvider.getUIBusInstance());

    }

    public PlacesPresenter(PlacesView placesView, PlacesWrapper placesWrapper) {

        mPlacesView = placesView;
        mGetPlaces = new GetPlacesUsecaseController(
                RestPlacesSource.getInstance(), BusProvider.getUIBusInstance());
        onPlacesReceived(placesWrapper);
    }

    @Subscribe
    public void onPlacesReceived(PlacesWrapper placesWrapper) {


        Log.e("Debug", "onPlacesReceived places wrapper = " + placesWrapper.toString());

        if (mPlacesView.isTheListEmpty()) {
            mPlacesView.hideLoading();
            mPlacesView.showPlaces(placesWrapper.getResponse());

        } else {

            mPlacesView.hideActionLabel();
            mPlacesView.appendPlaces(placesWrapper.getResponse());
        }

        isLoading = false;
    }


    public void onEndListReached() {
        mGetPlaces.execute();
        mPlacesView.showLoadingLabel();
        isLoading = true;
    }

    @Override
    public void start() {

        if (mPlacesView.isTheListEmpty()) {

            BusProvider.getUIBusInstance().register(this);
            mRegistered = true;
            mPlacesView.showLoading();
            mGetPlaces.execute();
        }
    }

    @Override
    public void stop() {
    }

    public boolean isLoading() {

        return isLoading;
    }

    public void setLoading(boolean isLoading) {

        this.isLoading = isLoading;
    }
}