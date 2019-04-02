package com.example.myapplication.Home;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.myapplication.R;
import com.example.myapplication.Utils.BottomNavigationViewHelper;
import com.example.myapplication.Utils.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nostra13.universalimageloader.core.ImageLoader;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";

    private static final int ACTIVITY_NUM = 0;

    private Context mContext = HomeActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: starting.");

        initImageLoader();
        setupBottomNavigationView();
        setupViewPager();
    }

    /*
     * Responsible for adding 3 tabs: Camera, Home, Messages
     */
    private void setupViewPager() {
        SectionPageAdapter sectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
        sectionPageAdapter.addItem(new CameraFragment());       // index 0
        sectionPageAdapter.addItem(new HomeFragment());         // index 1
        sectionPageAdapter.addItem(new MessagesFragment());     // index 2
        ViewPager viewPager = findViewById(R.id.container);
        viewPager.setAdapter(sectionPageAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);            //camera icon
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_instagram_icon);    // instagram icon
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_arrow);             // messages icon
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

    private void initImageLoader() {
        UniversalImageLoader universalImageLoader  = new UniversalImageLoader(mContext);
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }
}
