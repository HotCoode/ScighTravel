package com.scigh.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by Abhay on 3/20/2015.
 */
public class LauncherActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean firstLaunch = prefs.getBoolean(getString(R.string.pref_previously_started), true);
        Intent intent;
        if (firstLaunch) {

            SharedPreferences.Editor edit = prefs.edit();
            edit.putBoolean(getString(R.string.pref_previously_started), Boolean.FALSE);
            edit.commit();

            intent = new Intent(this, IntroductionActivity.class);
            startActivity(intent);
            finish();
        } else {

            intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
