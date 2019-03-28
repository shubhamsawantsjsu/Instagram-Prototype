package com.example.myapplication.Utils;

import android.util.Log;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationViewHelper {

    private static final String TAG = "BottomNavViewHelper";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx) {
        Log.d(TAG, "setupBottomNavigationView: setting up bottom navigation view");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.setItemHorizontalTranslationEnabled(false);
        bottomNavigationViewEx.setLabelVisibilityMode(1);
        bottomNavigationViewEx.setTextVisibility(false);
    }
}
