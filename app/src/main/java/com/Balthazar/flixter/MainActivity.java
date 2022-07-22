package com.Balthazar.flixter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtFlixter, txtMovie;
    RelativeLayout relativeLayout;
    Animation txtAnimation, layoutAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAnimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.fall_down);
        layoutAnimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.bottom_to_top);

        txtFlixter = findViewById(R.id.txtFlixter);
        txtMovie = findViewById(R.id.txtMovie);
        relativeLayout = findViewById(R.id.relMain);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                relativeLayout.setVisibility(View.VISIBLE);
                relativeLayout.setAnimation(layoutAnimation);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        txtFlixter.setVisibility(View.VISIBLE);
                        txtMovie.setVisibility(View.VISIBLE);


                        txtFlixter.setAnimation(txtAnimation);
                        txtMovie.setAnimation(txtAnimation);
                    }
                }, 900);
            }
        },500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Login_Activity.class);
                startActivity(intent);
            }
        },6000);
    }
}