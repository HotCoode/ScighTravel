package com.scigh.utils;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

import com.scigh.activities.R;


public class ColorFadingPageTransformer implements PageTransformer {
    public void transformPage(View view, float position) {

        int pageWidth = view.getWidth();

        View imageView = view.findViewById(R.id.background_view);
        View contentView = view.findViewById(R.id.content_area);

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left
        } else if (position <= 0) { // [-1,0]

            // This page is moving
            // to the left

            // Counteract the default swipe
            view.setTranslationX(pageWidth * -position);
            if (contentView != null) {
                // But swipe the contentView
                contentView.setTranslationX(pageWidth * position);
            }
            if (imageView != null) {
                // Fade the image in
                imageView.setAlpha(1 + position);
            }

        } else if (position <= 1) { // (0,1]
            // This page is moving in from the right

            // Counteract the default swipe
            view.setTranslationX(pageWidth * -position);
            if (contentView != null) {
                // But swipe the contentView
                contentView.setTranslationX(pageWidth * position);
            }
            if (imageView != null) {
                // Fade the image out
                imageView.setAlpha(1 - position);
            }
        } else { // (1,+Infinity]
            // This page is way off-screen to the right
        }
    }
}