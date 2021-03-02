package com.techi4you.swipegestures;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
public class MainActivity extends AppCompatActivity {
    RelativeLayout layout;
    TextView textView;
    Button secondActivity;
    private GestureDetectorCompat mGestureDetectorCompat;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.relativeLayout);
        textView = findViewById(R.id.swipeMe);
        secondActivity = findViewById(R.id.secondActivity);

        secondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondExampleAcivity.class);
                startActivity(intent);

            }
        });


mGestureDetectorCompat = new GestureDetectorCompat(this, new GestureListener());
    }

private class GestureListener extends GestureDetector.SimpleOnGestureListener{
    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return super.onSingleTapUp(e);
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return super.onScroll(e1, e2, distanceX, distanceY);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        try {
            float diffY = e2.getY() - e1.getY();
            float diffX = e2.getX() - e1.getX();
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        onSwipeRight();
                    } else {
                        onSwipeLeft();
                    }
                }
            }
            else {
                if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        onSwipeDown();
                    } else {
                        onSwipeUp();
                    }
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;

    }

    @Override
    public void onShowPress(MotionEvent e) {
        super.onShowPress(e);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return super.onDown(e);
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Toast.makeText(MainActivity.this, "DOUBLE TAP", Toast.LENGTH_SHORT).show();
        return super.onDoubleTap(e);
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Toast.makeText(MainActivity.this, "DOUBLE TAP EVENT", Toast.LENGTH_SHORT).show();
        return super.onDoubleTapEvent(e);
    }

    @Override
    public boolean onContextClick(MotionEvent e) {

        Toast.makeText(MainActivity.this, "ON CLICK", Toast.LENGTH_SHORT).show();
        return super.onContextClick(e);
    }
}


    private void onSwipeUp() {
        Toast.makeText(MainActivity.this, "Swipe Up", Toast.LENGTH_SHORT).show();
    }

    private void onSwipeDown() {
        Toast.makeText(MainActivity.this, "Swipe Down", Toast.LENGTH_SHORT).show();

    }

    private void onSwipeLeft() {
        Toast.makeText(MainActivity.this, "Swipe left", Toast.LENGTH_SHORT).show();

    }

    private void onSwipeRight() {
        Toast.makeText(MainActivity.this, "Swipe Right", Toast.LENGTH_SHORT).show();

    }








    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}