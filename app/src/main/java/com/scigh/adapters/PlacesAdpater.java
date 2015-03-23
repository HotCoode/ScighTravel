package com.scigh.adapters;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.scigh.Constants;
import com.scigh.activities.R;
import com.scigh.utils.RecyclerViewClickListener;
import com.scightravel.model.entities.Place;

import java.util.List;


/**
 * Created by abhay on 3/23/2015.
 */
public class PlacesAdpater extends RecyclerView.Adapter<PlaceViewHolder> {

    private Context mContext;
    private List<Place> mPlaceList;
    private RecyclerViewClickListener mRecyclerClickListener;

    public PlacesAdpater(List<Place> mPlaceList) {
        Log.e("Debug", "PlacesAdapter" + mPlaceList.toString());
        this.mPlaceList = mPlaceList;
    }

    public List<Place> getPlaceList() {

        return mPlaceList;
    }

    public void setRecyclerListListener(RecyclerViewClickListener mRecyclerClickListener) {
        this.mRecyclerClickListener = mRecyclerClickListener;
    }

    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View rowView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_place, viewGroup, false);

        this.mContext = viewGroup.getContext();

        return new PlaceViewHolder(rowView, mRecyclerClickListener);
    }

    @Override
    public void onBindViewHolder(final PlaceViewHolder holder, final int position) {

        Place selectedPlace = mPlaceList.get(position);
        Log.e("Debug", selectedPlace.toString());

        holder.titleTextView.setText(selectedPlace.getLocationName());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            holder.coverImageView.setTransitionName("cover" + position);

        String posterURL = Constants.BASIC_STATIC_URL + selectedPlace.getLocationImageUrl();

//        Picasso.with(mContext)
//                .load(posterURL)
//                .fit().centerCrop()
//                .into(holder.coverImageView, new Handler.Callback() {
//                    @Override
//                    public void onSuccess() {
//
//                        mPlaceList.get(position).setPlaceReady(true);
//                    }
//
//                    @Override
//                    public void onError() {
//
//                    }
//                });
    }

    public boolean isPlaceReady(int position) {

        return mPlaceList.get(position).isPlaceReady();
    }

    @Override
    public int getItemCount() {

        return mPlaceList.size();
    }

    public void appendPlaces(List<Place> placeList) {

        mPlaceList.addAll(placeList);
        notifyDataSetChanged();
    }
}

class PlaceViewHolder extends RecyclerView.ViewHolder implements View.OnTouchListener {

    private final RecyclerViewClickListener onClickListener;
    TextView titleTextView;
    TextView authorTextView;
    ImageView coverImageView;

    public PlaceViewHolder(View itemView, RecyclerViewClickListener onClickListener) {

        super(itemView);

        titleTextView = (TextView) itemView.findViewById(R.id.tvPlaceTitle);
//        coverImageView = (ImageView) itemView.findViewById(R.id.item_movie_cover);
//        coverImageView.setDrawingCacheEnabled(true);
//        coverImageView.setOnTouchListener(this);
        this.onClickListener = onClickListener;
    }

    public void setReady(boolean ready) {

        coverImageView.setTag(ready);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_UP && event.getAction() != MotionEvent.ACTION_MOVE) {

            onClickListener.onClick(v, getPosition(), event.getX(), event.getY());
        }
        return true;
    }
}