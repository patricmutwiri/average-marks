package com.mutwiri.averagemarks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected EditText name;
    protected EditText marks;
    protected TextView results;

    protected int avgMark = 0;
    protected String stdName = "", myTag="Err";
    protected String resultsDisplay = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // init
        marks = (EditText) findViewById(R.id.editText);
        name = (EditText) findViewById(R.id.editText3);
        results = (TextView) findViewById(R.id.textView4);
        Button calc = (Button) findViewById(R.id.button);

        // get data
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    avgMark = Integer.parseInt(marks.getText().toString());
                    stdName = name.getText().toString();
                    // conditions
                    if (avgMark<50) {
                        resultsDisplay = "FAIL";
                    } else if(avgMark < 65) {
                        resultsDisplay = "C";
                    } else if(avgMark < 75) {
                        resultsDisplay = "B";
                    } else {
                        resultsDisplay = "A";
                    }
                    results.setText(String.format("\nGrade for %s is %s ",stdName,resultsDisplay));
                } catch (Exception e) {
                    Log.v(myTag," Exception on getting input");
                    results.setText("Enter both name and average grade please.");
                }
            }
        });
    }
}
