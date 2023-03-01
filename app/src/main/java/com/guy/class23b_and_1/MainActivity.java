package com.guy.class23b_and_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    MaterialTextView main_LBL_name;
    MaterialTextView main_LBL_greeting;
    MaterialButton main_BTN_clickHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_LBL_name = findViewById(R.id.main_LBL_name);
        main_LBL_greeting = findViewById(R.id.main_LBL_greeting);
        main_BTN_clickHere = findViewById(R.id.main_BTN_clickHere);






        main_BTN_clickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGreeting();
            }
        });
    }

    public void showGreeting() {
        main_LBL_greeting.setVisibility(View.VISIBLE);

        String title = getString(R.string.hi) + " Noy";
        main_LBL_name.setText(title);
    }
}