package com.famu.luggers;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    // pulling out references to UI elements on login screen
    private EditText etEmailAddress;
    private EditText etPassword;
    private Button btnLogin;
    private TextView tvRegisterMover;
    private Boolean isBanned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            etEmailAddress = findViewById(R.id.etEmailAddress);
            etPassword = findViewById(R.id.etPassword);
            tvRegisterMover = findViewById(R.id.tvRegisterMover);
            btnLogin = findViewById(R.id.btnLogin);

        final ParseUser currentUser = ParseUser.getCurrentUser();
        isBanned = currentUser.getBoolean("isBanned");


        btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String username = etEmailAddress.getText().toString();
                    String password = etPassword.getText().toString();
                    login(username, password);
                }
            });

            tvRegisterMover.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goRegisterActivity();
                }
            });
    }

    private void login(String username, String password) {

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {

                if( e != null){
                    //TODO: better error handling
                    Toast.makeText(MainActivity.this, "Incorrect Username/Password", Toast.LENGTH_SHORT).show();
                    Log.e(TAG,  "Issue with login");
                    e.printStackTrace();
                    return;
                } else if (isBanned) {
                    Toast.makeText(MainActivity.this, "You are banned", Toast.LENGTH_SHORT).show();
                    return;
                } else {

                    //TODO: navigate to new activity if the user has signed properly
                    goMainActivity();
                }
            }
        });
    }

    private void goMainActivity() {
        Log.d(TAG,  "Navigating to Profile");

        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
        finish();

    }

    private void goRegisterActivity() {

        Log.d(TAG,  "Navigating to Register Activity");

        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
        finish();
    }


}
