package com.sevent.sevent;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Opening extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(Opening.this, Login.class);
                startActivity(homeIntent);
                overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
