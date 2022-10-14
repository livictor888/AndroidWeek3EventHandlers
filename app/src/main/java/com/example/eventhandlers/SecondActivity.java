package com.example.eventhandlers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Link to the spinner by its id
        Spinner spCountries = findViewById(R.id.spinnerCountries);
        // Create a list of countries
        ArrayList<String> countries = new ArrayList<>();
        countries.add("Choose a country");
        countries.add("Canada");
        countries.add("United States");
        countries.add("Mexico");
        countries.add("India");
        countries.add("China");
        countries.add("Japan");
        countries.add("Australia");

        // Create an adapter with the list of String
        ArrayAdapter<String> data = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
        // Set the layout style for the drop down menu
        data.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Attach the ArrayAdapter to spinner
        spCountries.setAdapter(data);
        // Create a listener for selecting an item in the spinner
        spCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // Override the onItemSelected method defined in AdapterView.OnItemSelectedListener
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get the String representation of the selected item
                String text = parent.getItemAtPosition(position).toString();
                if(!text.equals("Choose a country")) {
                    // Show Toast message when a country is selected
                    Toast.makeText(view.getContext(), text + " is selected", Toast.LENGTH_SHORT).show();
                }
            }

            // Override the onNothingSelected method defined in AdapterView.OnItemSelectedListener
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // unused
            }
        });

        // Link to the delete button by its id
        Button delete = findViewById(R.id.btnDelete);
        // Create a listener for clicking the delete button
        delete.setOnClickListener(new View.OnClickListener() {
            // Override the onClick method defined in View.OnClickListener
            @Override
            public void onClick(View view) {
                // Get the String representation of the selected item
                String text = spCountries.getSelectedItem().toString();
                if(!text.equals("Choose a country")) {
                    // Remove the selected String from the ArrayList
                    countries.remove(text);
                    Toast.makeText(view.getContext(), text + " is removed", Toast.LENGTH_SHORT).show();
                    // Create an adapter with the updated list of String
                    ArrayAdapter<String> new_data = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_item, countries);
                    // Set the layout style for the drop down menu
                    new_data.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    // Attach the ArrayAdapter to spinner
                    spCountries.setAdapter(new_data);
                }
                else {
                    // Display a message when no country is selected
                    Toast.makeText(view.getContext(), "No country is selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Create a button to show some message
        Button show = findViewById(R.id.btnShowMessage);
        MyOnClickListener myLister = new MyOnClickListener();
        show.setOnClickListener(myLister);

        // Create a button to start the third Activity
        Button next = findViewById(R.id.btnThirdAct);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the third Activity
                Intent intent = new Intent(view.getContext(), ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

}