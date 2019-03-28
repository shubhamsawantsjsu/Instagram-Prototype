package com.example.myapplication.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.example.myapplication.Home.HomeActivity;
import com.example.myapplication.Likes.LikesActivity;
import com.example.myapplication.Profile.ProfileActivity;
import com.example.myapplication.R;
import com.example.myapplication.Search.SearchActivity;
import com.example.myapplication.Share.SharesActivity;
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

    public static void enableNavigation(final Context context, BottomNavigationViewEx bottomNavigationViewEx) {

        bottomNavigationViewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()) {

                    case R.id.ic_house:
                        Intent houseIntent = new Intent(context, HomeActivity.class);
                        context.startActivity(houseIntent);
                        break;

                    case R.id.ic_search:
                        Intent searchIntent = new Intent(context, SearchActivity.class);
                        context.startActivity(searchIntent);
                        break;

                    case R.id.ic_circle:
                        Intent shareIntent = new Intent(context, SharesActivity.class);
                        context.startActivity(shareIntent);
                        break;

                    case R.id.ic_alert:
                        Intent likesIntent = new Intent(context, LikesActivity.class);
                        context.startActivity(likesIntent);
                        break;

                    case R.id.ic_android:
                        Intent profileIntent = new Intent(context, ProfileActivity.class);
                        context.startActivity(profileIntent);
                        break;
                }

                return false;
            }
        });

    }
}
