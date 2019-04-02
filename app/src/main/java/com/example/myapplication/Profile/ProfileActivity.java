package com.example.myapplication.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.myapplication.R;
import com.example.myapplication.Utils.BottomNavigationViewHelper;
import com.example.myapplication.Utils.GridImageAdapter;
import com.example.myapplication.Utils.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    private Context mContext = ProfileActivity.this;

    private static final String TAG = "ProfileActivity";

    private static final int ACTIVITY_NUM = 4;

    private static final int NUM_GRID_COLUMNS = 3;

    private ProgressBar mProgressBar;

    private ImageView profilePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Log.d(TAG, "onCreate: starting.");

        setupBottomNavigationView();
        setupToolbar();
        setupActivityWidgets();
        setProfileImage();

        tempGridSetup();
    }

    private void setupImageGrid(ArrayList<String> imageURLs) {
        GridView gridView = findViewById(R.id.gridView);

        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = gridWidth/NUM_GRID_COLUMNS;
        gridView.setColumnWidth(imageWidth);

        GridImageAdapter adapter = new GridImageAdapter(mContext, R.layout.layout_grid_image_view, "", imageURLs);
        gridView.setAdapter(adapter);
    }

    private void tempGridSetup() {
        ArrayList<String> imageURLs = new ArrayList<>();
        imageURLs.add("https://crackberry.com/sites/crackberry.com/files/styles/large/public/topic_images/2013/ANDROID.png?itok=xhm7jaxS");
        imageURLs.add("https://crackberry.com/sites/crackberry.com/files/styles/large/public/topic_images/2013/ANDROID.png?itok=xhm7jaxS");
        imageURLs.add("https://crackberry.com/sites/crackberry.com/files/styles/large/public/topic_images/2013/ANDROID.png?itok=xhm7jaxS");
        imageURLs.add("https://crackberry.com/sites/crackberry.com/files/styles/large/public/topic_images/2013/ANDROID.png?itok=xhm7jaxS");
        imageURLs.add("https://crackberry.com/sites/crackberry.com/files/styles/large/public/topic_images/2013/ANDROID.png?itok=xhm7jaxS");
        imageURLs.add("https://crackberry.com/sites/crackberry.com/files/styles/large/public/topic_images/2013/ANDROID.png?itok=xhm7jaxS");
        imageURLs.add("https://crackberry.com/sites/crackberry.com/files/styles/large/public/topic_images/2013/ANDROID.png?itok=xhm7jaxS");
        imageURLs.add("https://crackberry.com/sites/crackberry.com/files/styles/large/public/topic_images/2013/ANDROID.png?itok=xhm7jaxS");
        imageURLs.add("https://crackberry.com/sites/crackberry.com/files/styles/large/public/topic_images/2013/ANDROID.png?itok=xhm7jaxS");
        imageURLs.add("https://crackberry.com/sites/crackberry.com/files/styles/large/public/topic_images/2013/ANDROID.png?itok=xhm7jaxS");
        imageURLs.add("https://crackberry.com/sites/crackberry.com/files/styles/large/public/topic_images/2013/ANDROID.png?itok=xhm7jaxS");
        imageURLs.add("https://crackberry.com/sites/crackberry.com/files/styles/large/public/topic_images/2013/ANDROID.png?itok=xhm7jaxS");

        setupImageGrid(imageURLs);

    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);

        ImageView profileMenu = findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating to account settings");
                Intent intent = new Intent(mContext, AccountSettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setProfileImage() {
        Log.d(TAG, "setProfileImage: setting profile photo");
        String imageURL = "crackberry.com/sites/crackberry.com/files/styles/large/public/topic_images/2013/ANDROID.png?itok=xhm7jaxS";

        UniversalImageLoader.setImage(imageURL, profilePhoto, null, "https://");
    }
    
    private void setupActivityWidgets() {
        mProgressBar = findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);

        profilePhoto = findViewById(R.id.profile_photo);
    }
    /*
     * Bottom Navigation Setup
     */
    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem item = menu.getItem(ACTIVITY_NUM);
        item.setChecked(true);
    }
}
