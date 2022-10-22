package com.example.relativeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button countbotton;
    private Button toastbutton;
    private int CurrentC = 0;
    private int result =0;
    private static final String KEY_INDEX = "index";

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i("Land", "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, CurrentC);
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countbotton = (Button) findViewById(R.id.countb);
        TextView con = (TextView) findViewById(R.id.result);

        if (savedInstanceState != null) {
            CurrentC = savedInstanceState.getInt(KEY_INDEX, 0);
            con.setText(String.valueOf(CurrentC));
        }

        countbotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentC++;
                result = CurrentC;
                String result = String.valueOf(CurrentC);
                con.setText(result);

            }
        });
        toastbutton = (Button) findViewById(R.id.toastb);
        toastbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        Integer.toString(CurrentC),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}