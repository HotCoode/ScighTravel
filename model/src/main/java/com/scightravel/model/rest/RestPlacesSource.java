package com.scightravel.model.rest;

import com.scigh.BusProvider;
import com.scigh.Constants;
import com.scightravel.model.entities.PlacesWrapper;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by abhay on 3/23/2015.
 */
public class RestPlacesSource implements RestDataSource {

    public static RestPlacesSource INSTANCE;
    private final PlacesDatabaseAPI placesDBApi;

    private RestPlacesSource() {

        RestAdapter placesAPIRest = new RestAdapter.Builder()
                .setEndpoint(Constants.PLACES_DB_HOST)
                .setLogLevel(RestAdapter.LogLevel.BASIC)
                .build();

        placesDBApi = placesAPIRest.create(PlacesDatabaseAPI.class);
    }

    public static RestPlacesSource getInstance() {

        if (INSTANCE == null)
            INSTANCE = new RestPlacesSource();

        return INSTANCE;
    }


    public Callback retrofitCallback = new Callback() {
        @Override
        public void success(Object o, Response response) {

            if (o instanceof PlacesWrapper) {
                PlacesWrapper placesApiResponse = (PlacesWrapper) o;
                BusProvider.getRestBusInstance().post(
                        placesApiResponse);
            }
        }

        @Override
        public void failure(RetrofitError error) {

            System.out.printf("[DEBUG] RestMovieSource failure - " + error.getMessage());
        }
    };

    @Override
    public void getPlaces() {

        placesDBApi.getPlaces(retrofitCallback);

    }


}
