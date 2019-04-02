package com.example.myapplication.Profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myapplication.R;
import com.example.myapplication.Utils.UniversalImageLoader;

public class EditProfileFragment extends Fragment {

    private static final String TAG = "EditProfileFragment";

    private ImageView mProfilePhoto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile, container, false);
        mProfilePhoto = view.findViewById(R.id.profile_photo);

        //backArrow for navigating back to "ProfileActivity"
        ImageView backArrow = view.findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating back to profile activity");
                getActivity().finish();
            }
        });

        setProfileImage();

        return view;
    }

    private void setProfileImage() {
        Log.d(TAG, "setProfileImage: setting profile image");

        String imageURL = "crackberry.com/sites/crackberry.com/files/styles/large/public/topic_images/2013/ANDROID.png?itok=xhm7jaxS";

        UniversalImageLoader.setImage(imageURL, mProfilePhoto, null, "https://");
    }
}
