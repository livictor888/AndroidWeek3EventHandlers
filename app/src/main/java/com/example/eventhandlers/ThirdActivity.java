package com.example.eventhandlers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Link to the checkbox by its id
        CheckBox check_box = findViewById(R.id.checkBox);
        // Create a listener for checking the checkbox
        check_box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            // Override the onCheckedChanged method defined in CompoundButton.OnCheckedChangeListener
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                // Show different messages based on whether the checkbox is checked or not
                if(b) {
                    Toast.makeText(getApplicationContext(), "a student", Toast.LENGTH_SHORT).show();
                }
                else  {
                    Toast.makeText(getApplicationContext(), "not a student", Toast.LENGTH_SHORT).show();
                }
            }
        });


        // Link to the radiogroup by its id
        RadioGroup radio_group = findViewById(R.id.radioGroup);
        // Create a listener for checking radio buttons in the radiogroup
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            // Override the onCheckedChanged method defined in RadioGroup.OnCheckedChangeListener
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                // Show different messages based on which radio button is checked
                switch(i) {
                    case R.id.junior:
                        Toast.makeText(getApplicationContext(), "Junior", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.middle:
                        Toast.makeText(getApplicationContext(), "Mid-Level", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.senior:
                        Toast.makeText(getApplicationContext(), "Senior", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        // Link to the seekbar by its id
        SeekBar seekSatisfaction = findViewById(R.id.seekBar);
        // Create a listener for changing the progress on the seekbar
        seekSatisfaction.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            // Override the onStartTrackingTouch method defined in SeekBar.OnSeekBarChangeListener
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Show the starting progress when the seekbar is pressed
                int progress = seekBar.getProgress();
                float percent = (float) progress/100;
                Toast.makeText(getApplicationContext(), "Start: " + percent, Toast.LENGTH_SHORT).show();
            }

            // Override the onStopTrackingTouch method defined in SeekBar.OnSeekBarChangeListener
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Show the stopping progress when the seekbar is released
                int progress = seekBar.getProgress();
                float percent = (float) progress/100;
                Toast.makeText(getApplicationContext(), "Stop: " + percent, Toast.LENGTH_SHORT).show();
            }

            // Override the onProgressChanged method defined in SeekBar.OnSeekBarChangeListener
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                // Show the changing progress
                Toast.makeText(getApplicationContext(), i+"%", Toast.LENGTH_SHORT).show();
            }
        });

        // Create a button to start the KeyEvents Activity
        Button toKey = findViewById(R.id.btnToKeyEvents);
        toKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), KeyboardEvents.class);
                startActivity(intent);
            }
        });

        // Create a button to start the TouchEvents Activity
        Button toTouch = findViewById(R.id.btnToTouchEvents);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), TouchEvents.class);
                startActivity(intent);
            }
        };
        toTouch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), TouchEvents.class);
                startActivity(intent);
            }
        });
    }
}
