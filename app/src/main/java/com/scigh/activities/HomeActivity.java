package com.scigh.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnimationUtils;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.scigh.adapters.PlacesAdpater;
import com.scigh.fragments.RightDrawerFragment;
import com.scigh.mvp.presenter.PlacesPresenter;
import com.scigh.mvp.views.PlacesView;
import com.scigh.utils.RecyclerInsetsDecoration;
import com.scigh.utils.RecyclerViewClickListener;
import com.scigh.views.AutofitRecyclerView;
import com.scightravel.model.entities.Place;
import com.scightravel.model.entities.PlacesWrapper;

import java.util.List;


/**
 * Created by Abhay on 3/20/2015.
 */
public class HomeActivity extends ActionBarActivity implements RecyclerViewClickListener, View.OnClickListener, PlacesView {

    private Toolbar mToolbar;
    private AutofitRecyclerView mRecycler;
    private RightDrawerFragment mRightDrawerFragment;

    private PlacesPresenter mPlacesPresenter;
    private PlacesAdpater mPlacesAdapter;

    int pastVisiblesItems, visibleItemCount, totalItemCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        initViews();

        if (savedInstanceState == null) {
            mPlacesPresenter = new PlacesPresenter(this);

        } else {
            PlacesWrapper placesWrapper = (PlacesWrapper) savedInstanceState
                    .getSerializable("places_wrapper");

            mPlacesPresenter = new PlacesPresenter(this, placesWrapper);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        if (mPlacesAdapter != null) {
            outState.putSerializable("places_wrapper",
                    new PlacesWrapper(mPlacesAdapter.getPlaceList()));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPlacesPresenter.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPlacesPresenter.start();
    }


    private void initViews() {
        // Setup toolbar
        mToolbar = (Toolbar) findViewById(R.id.activity_home_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        mToolbar.setNavigationOnClickListener(this);

        // Setup Recycler View
        mRecycler = (AutofitRecyclerView) findViewById(R.id.recycler_home);
        mRecycler.addItemDecoration(new RecyclerInsetsDecoration(this));
        mRecycler.setOnScrollListener(recyclerScrollListener);

        // Right Drawer
        mRightDrawerFragment = (RightDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mRightDrawerFragment.setUp(R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    private void showToolbar() {

        mToolbar.startAnimation(AnimationUtils.loadAnimation(this,
                R.anim.translate_up_off));
    }

    private void hideToolbar() {

        mToolbar.startAnimation(AnimationUtils.loadAnimation(this,
                R.anim.translate_up_on));
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showPlaces(List<Place> placesList) {
        mPlacesAdapter = new PlacesAdpater(placesList);
        mPlacesAdapter.setRecyclerListListener(this);
        mRecycler.setAdapter(mPlacesAdapter);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void hideError() {

    }

    @Override
    public void showLoadingLabel() {
        Snackbar loadingSnackBar = Snackbar.with(this)
                .text("Loading more places")
                .actionLabel("Cancel")
                .duration(Snackbar.SnackbarDuration.LENGTH_SHORT)
                .color(getResources().getColor(R.color.theme_primary))
                .actionColor(getResources().getColor(R.color.theme_accent));

        SnackbarManager.show(loadingSnackBar);
    }

    @Override
    public void showCompleteLabel() {
        Snackbar overflowSnackBar = Snackbar.with(this)
                .text("That's all for now. Come back later")
                .actionLabel("Ok")
                .duration(Snackbar.SnackbarDuration.LENGTH_SHORT)
                .color(getResources().getColor(R.color.theme_primary))
                .actionColor(getResources().getColor(R.color.theme_accent));

        SnackbarManager.show(overflowSnackBar);
    }

    @Override
    public void hideActionLabel() {

        SnackbarManager.dismiss();
    }

    @Override
    public boolean isTheListEmpty() {

        return (mPlacesAdapter == null) || mPlacesAdapter.getPlaceList().isEmpty();
    }

    @Override
    public void appendPlaces(List<Place> placesList) {
        mPlacesAdapter.appendPlaces(placesList);
    }

    private RecyclerView.OnScrollListener recyclerScrollListener = new RecyclerView.OnScrollListener() {
        public boolean flag;

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

            super.onScrolled(recyclerView, dx, dy);

            visibleItemCount = mRecycler.getLayoutManager().getChildCount();
            totalItemCount = mRecycler.getLayoutManager().getItemCount();
            pastVisiblesItems = ((GridLayoutManager) mRecycler.getLayoutManager()).findFirstVisibleItemPosition();

            if ((visibleItemCount + pastVisiblesItems) >= totalItemCount && !mPlacesPresenter.isLoading()) {
                //mPlacesPresenter.onEndListReached();
            }

            // Is scrolling up
            if (dy > 10) {

                if (!flag) {

                    showToolbar();
                    flag = true;
                }

                // Is scrolling down
            } else if (dy < -10) {

                if (flag) {

                    hideToolbar();
                    flag = false;
                }
            }
        }
    };

    @Override
    public void onClick(View v, int position, float x, float y) {

    }
}
