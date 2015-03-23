package com.scigh.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.scigh.utils.ColorFadingPageTransformer;
import com.scigh.fragments.IntroPagerAdapter;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;


public class IntroductionActivity extends ActionBarActivity {

    PageIndicator mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_intro);

        ViewPager pager = (ViewPager) findViewById(R.id.fullscreen_pager);

        IntroPagerAdapter introPagerAdapter = new IntroPagerAdapter(
                getSupportFragmentManager());
        pager.setAdapter(introPagerAdapter);
        pager.setPageTransformer(true, new ColorFadingPageTransformer());
        mIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        mIndicator.setViewPager(pager);
    }
}
