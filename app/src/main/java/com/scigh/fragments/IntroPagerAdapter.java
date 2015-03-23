package com.scigh.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class IntroPagerAdapter extends FragmentPagerAdapter {

	public IntroPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int i) {
		switch (i) {
		case 0:
			return new IntroFragment1();

		case 1:
			return new IntroFragment2();

		case 2:
			return new IntroFragment3();

		default:
			return null;
		}
	}

	@Override
	public int getCount() {
		return 3;
	}

}