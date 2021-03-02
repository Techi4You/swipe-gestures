package com.techi4you.swipegestures;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;
public class SecondExampleAcivity extends AppCompatActivity {
    RelativeLayout layout;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.relativeLayout);
        layout.setOnTouchListener(new OnSwipeTouchListener(SecondExampleAcivity.this) {
            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                Toast.makeText(SecondExampleAcivity.this, "Swipe Left gesture detected", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                Toast.makeText(SecondExampleAcivity.this, "Swipe Right gesture detected", Toast.LENGTH_SHORT).show();
            }
        });
    }
}