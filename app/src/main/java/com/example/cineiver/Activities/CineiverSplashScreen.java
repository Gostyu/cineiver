package com.example.cineiver.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.cineiver.R;
import com.example.cineiver.utils.Constants;

public class CineiverSplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cineiver_splash_screen);
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(getBaseContext(),MovieListActivity.class));
            finish();
        }, Constants.TIMEOUT);
    }


}