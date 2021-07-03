package com.imran.adminpanel;



import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SplashScreen extends AppCompatActivity {

    TextView titletxt, introtxt;
    ImageView vectorimg, logoimg;
    Animation fade_animation, left_anim, right_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        titletxt = findViewById(R.id.apptitle_text);
        introtxt = findViewById(R.id.introduction_text);
        vectorimg = findViewById(R.id.vector_image);
        logoimg = findViewById(R.id.logo_image);

        //set faded animation
        fade_animation = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.fade_anim);
        fade_animation.setDuration(2000);
        vectorimg.setAnimation(fade_animation);

        //set left animation
        left_anim = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.slide_left);
        left_anim.setDuration(700);
        logoimg.setAnimation(left_anim);
        titletxt.setAnimation(left_anim);

        //set right animation
        right_anim = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.slide_right);
        right_anim.setDuration(700);
        introtxt.setAnimation(right_anim);

        Thread td = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(SplashScreen.this, HelpCenter.class));
                    overridePendingTransition(R.anim.slide_right,R.anim.slide_leftt);

                    finish();

                }
            }
        };
        td.start();
    }
}
