package com.example.voyageverse;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;

public class Splash extends AppCompatActivity {

    private static final int SPLASH_SCREEN_DURATION = 3000; // Duration in milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Initing  the LottieAnimationView
        LottieAnimationView lottieAnimationView = findViewById(R.id.lottieAnimationView);
        lottieAnimationView.playAnimation();

        // Handles and  MainActivity after the splash screen duration
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start MainActivity
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish(); // Close the SplashActivity
            }
        }, 2000);
    }
}
