package com.famu.luggers;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseUser;


public class EditProfileActivity extends AppCompatActivity {

    private static final String TAG = "EditProfileActivity";

    // pulling out references to UI elements on login screen
    private EditText epEmailAddress;
    private EditText epPassword;
    private EditText epFirstName;
    private EditText epLastName;
    private Button btnUpdate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);


        epEmailAddress = findViewById(R.id.epEmailAddress);
        epPassword = findViewById(R.id.epPassword);
        epFirstName = findViewById(R.id.epFirstName);
        epLastName = findViewById(R.id.epLastName);
        btnUpdate = findViewById(R.id.btnUpdate);


        final ParseUser currentUser = ParseUser.getCurrentUser();



        epFirstName.setText(currentUser.get("firstName").toString());
        epLastName.setText(currentUser.get("lastName").toString());
        epEmailAddress.setText(currentUser.get("email").toString());


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstname = epFirstName.getText().toString();
                String lastname = epLastName.getText().toString();
                String emailAddress = epEmailAddress.getText().toString();
                String password = epPassword.getText().toString();

                currentUser.put("firstName", firstname);
                currentUser.put("lastName", lastname);
                currentUser.put("email", emailAddress);
                currentUser.put("password", password);
                currentUser.saveInBackground();
                goProfileActivity();

            }
        });
    }

    private void goProfileActivity(){
        Log.d(TAG,  "Navigating to Profile");

        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
        finish();

    }
}
