package com.example.eventhandlers;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class KeyboardEvents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyevents);

        // Link to textView and editView by their ids
        TextView showText = findViewById(R.id.showKey);
        EditText editText = findViewById(R.id.editTextInput);
        // Set up a listener for entering text with keyboard
        editText.setOnKeyListener(new View.OnKeyListener() {
            // Override the onKey method defined in View.OnKeyListener
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                // Show different text based on user input
                switch (i) {
                    case KeyEvent.KEYCODE_ENTER:
                        showText.setText(R.string.enter_key);
                        return true;
                    case KeyEvent.KEYCODE_SPACE:
                        showText.setText(R.string.space_key);
                        return true;
                    case KeyEvent.KEYCODE_PERIOD:
                        showText.setText(R.string.period_key);
                        return true;
                    case KeyEvent.KEYCODE_MINUS:
                        showText.setText(R.string.minus_key);
                        return true;
                    case KeyEvent.KEYCODE_SEMICOLON:
                        showText.setText(R.string.semicolon_key);
                        return true;
                }
                // event not consumed yet
                return false;
            }
        });

        // Set up a listener for interacting with the soft keyboard
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            // Override the onEditorAction method defined in TextView.OnEditorActionListener
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                // Show "Done" when the user finishes entering the text
                if(i == EditorInfo.IME_ACTION_DONE) {
                    showText.setText(R.string.done);
                }
                else {
                    showText.setText("");
                }
                return false;
            }
        });
    }
}
