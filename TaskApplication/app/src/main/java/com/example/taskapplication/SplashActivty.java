package com.example.taskapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivty extends AppCompatActivity {

    private static final int SPLASH_TIMEOUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activty);
        // Using a Handler to delay the transition to the main activity

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the main activity
                Intent intent = new Intent(SplashActivty.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Close the splash activity to prevent it from coming back when the user presses the back button
            }
        }, SPLASH_TIMEOUT);
    }
}