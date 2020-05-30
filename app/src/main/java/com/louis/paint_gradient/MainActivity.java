package com.louis.paint_gradient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(new MyGradientView(this));
//        setContentView(R.layout.activity_main);
//        setContentView(new RadarGradientView(this));
        setContentView(new ZoomImageView(this));
    }
}