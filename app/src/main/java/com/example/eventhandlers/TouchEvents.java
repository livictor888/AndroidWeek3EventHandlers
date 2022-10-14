package com.example.eventhandlers;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class TouchEvents extends AppCompatActivity {

    @SuppressLint({"ResourceType", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touchevents);

        // Link to the layout of current activity
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.touch_layout);
        // Set up a listener to monitor touch events
        constraintLayout.setOnTouchListener(new View.OnTouchListener() {
            // Override the onTouch method defined in the OnTouchListener
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // Define coordinate variables for the down, up and move actions
                float downX, downY, upX, upY, moveX, moveY;
                // Derive the action of the motionEvent
                int action = motionEvent.getAction();
                // Write debug logs for different actions
                if (action == MotionEvent.ACTION_DOWN) {
                    Log.d("MotionEvent", "ACTION_DOWN");
                    downX = motionEvent.getX();
                    downY = motionEvent.getY();
                    Log.d("MotionEvent", "downX = " + downX);
                    Log.d("MotionEvent", "downY = " + downY);
                    return true;
                } else if (action == MotionEvent.ACTION_UP){
                    Log.d("MotionEvent", "ACTION_UP");
                    upX = motionEvent.getX();
                    upY = motionEvent.getY();
                    Log.d("MotionEvent", "upX = " + upX);
                    Log.d("MotionEvent", "upY = " + upY);
                    return true;
                } else if (action == MotionEvent.ACTION_MOVE){
                    Log.d("MotionEvent", "ACTION_MOVE");
                    moveX = motionEvent.getX();
                    moveY = motionEvent.getY();
                    Log.d("MotionEvent", "moveX = " + moveX);
                    Log.d("MotionEvent", "moveY = " + moveY);
                    return true;
                }
                return false;
            }
        });
    }
}
