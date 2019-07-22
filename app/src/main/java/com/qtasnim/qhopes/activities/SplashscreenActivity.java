package com.qtasnim.qhopes.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.qtasnim.qhopes.R;

public class SplashscreenActivity extends AppCompatActivity {
    private int waktuLoading = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // buat fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent jumpActivity = new Intent(SplashscreenActivity.this, LandingActivity.class);
                startActivity(jumpActivity);
                finish();
            }
        }, waktuLoading);
    }
}
