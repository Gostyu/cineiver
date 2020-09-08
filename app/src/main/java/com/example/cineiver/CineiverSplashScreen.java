package com.example.cineiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class CineiverSplashScreen extends AppCompatActivity {
    int TIMEOUT=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cineiver_splash_screen);
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(getBaseContext(),MovieListActivity.class));
            finish();
        },TIMEOUT);
    }


}