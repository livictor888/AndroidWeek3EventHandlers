package com.example.eventhandlers;

import android.view.View;
import android.widget.Toast;

public class MyOnClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Button Clicked", Toast.LENGTH_LONG).show();
    }
}
