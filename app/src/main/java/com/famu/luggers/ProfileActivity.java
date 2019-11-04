package com.famu.luggers;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";


    private TextView tvMyLugs;
    private TextView tvProfile;
    private TextView tvSignOut;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvMyLugs = findViewById(R.id.tvMyLugs);
        tvProfile = findViewById(R.id.tvEdit);
        tvSignOut = findViewById(R.id.tvSignOut);

        tvSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOutActivity();
            }
        });

        tvProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editProfileActivity();
            }
        });
    }

    private void signOutActivity() {
        Log.d(TAG,  "Going to login screen");

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    private void editProfileActivity() {
        Log.d(TAG,  "Going to edit profile screen");

        Intent i = new Intent(this, EditProfileActivity.class);
        startActivity(i);
        finish();
    }
}
