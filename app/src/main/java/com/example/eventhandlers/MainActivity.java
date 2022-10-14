package com.example.eventhandlers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link to the spinner by its id
        Spinner seasons = findViewById(R.id.spinnerSeasons);
        // Create a listener for selecting an item in the spinner
        seasons.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // Override the onItemSelected method defined in AdapterView.OnItemSelectedListener
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Show the selected item
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(view.getContext(), text + " is selected", Toast.LENGTH_LONG).show();
            }

            // Override the onNothingSelected method defined in AdapterView.OnItemSelectedListener
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // unused
            }
        });
    }

    public void next(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}