package com.scigh.mvp.presenter;

/**
 * Created by abhay on 3/23/2015.
 */
public abstract class Presenter {

    /**
     * Called when the presenter is initialized
     */
    public abstract void start();

    /**
     * Called when the presenter is stop, i.e when an activity
     * or a fragment finishes
     */
    public abstract void stop();
}