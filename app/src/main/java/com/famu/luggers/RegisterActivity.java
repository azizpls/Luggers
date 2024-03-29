package com.famu.luggers;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";

    // pulling out references to UI elements on login screen
    private EditText etEmailAddress;
    private EditText etPassword;
    private EditText etFirstName;
    private EditText etLastName;
    private Button btnSignup;
    private TextView tvLoginMover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //Removes top status bar

        setContentView(R.layout.activity_register);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etEmailAddress = findViewById(R.id.etEmailAddress);
        etPassword = findViewById(R.id.etPassword);
        btnSignup = findViewById(R.id.btnSignUp);
        tvLoginMover = findViewById(R.id.tvLoginMover);

        tvLoginMover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLoginActivity();
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstname = etFirstName.getText().toString();
                String lastname = etLastName.getText().toString();
                String emailAddress = etEmailAddress.getText().toString();
                String password = etPassword.getText().toString();
                String username = etEmailAddress.getText().toString();
                Boolean isBanned = false;


                register(username,emailAddress, password, firstname, lastname, isBanned);
                goProfileActivity();

            }
        });






    }

    private void goLoginActivity() {
        Log.d(TAG,  "Navigating to Login Activity");

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();

    }

    private void register(String username, String emailAddress, String password, String firstname, String lastname, Boolean isBanned) {
        // Create the ParseUser
        ParseUser user = new ParseUser();
        // Set core properties
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(emailAddress);



        user.put("firstName", firstname);
        user.put("lastName", lastname);
        user.put("isBanned", isBanned);
        user.getString("firstName");



        // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {


                    // Hooray! Let them use the app now.
                    goProfileActivity();

                } else {
                    // Sign up didn't succeed. Look at the ParseExceptio®n
                    // to figure out what went wrong
                    Log.e(TAG, "Issue with Registration");
                    e.printStackTrace();
                    return;
                }
            }
        });


    }

    private void goProfileActivity() {
        Log.d(TAG,  "Navigating to Main Activity");

        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
        finish();
    }




}
