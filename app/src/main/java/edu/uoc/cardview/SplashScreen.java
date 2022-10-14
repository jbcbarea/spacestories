package edu.uoc.cardview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    LottieAnimationView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                //getSupportActionBar().hide();
                Intent intent = new Intent(edu.uoc.cardview.SplashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

        Timer time = new Timer();
        time.schedule(task, 4000);

        getSupportActionBar().hide();
        l = findViewById(R.id.splashLottie);

        //l.animate().translationY(1600).setDuration(5000).setStartDelay(1000);
        // backG.animate().translationY(-2500).setDuration(3000).setStartDelay(1000);
    }
}