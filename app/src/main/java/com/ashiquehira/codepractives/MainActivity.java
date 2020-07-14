package com.ashiquehira.codepractives;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView avgTextView;
    double time = 0d;
    private Chronometer chronometer;
    private boolean isRunning = false;

    ArrayList<Integer> times = new ArrayList<Integer>();
    String sDuration;
    int iDuration;
    int counter;
    int sum = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        avgTextView = findViewById(R.id.textView2);
        chronometer = new Chronometer(this);
    }

    public void start(View view) {

        if (!isRunning) {
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            isRunning = true;


        }else {

            isRunning = false;
            chronometer.stop();
            int elapsedMillis = (int) (SystemClock.elapsedRealtime() - chronometer.getBase());
            iDuration = elapsedMillis / 1000;
            sDuration = String.valueOf(iDuration);
            textView.setText(sDuration);
            times.add(iDuration);
            counter+=1;

        }
        if (counter > 6) {
            int j = counter - 7;
            sum = 0;
            int avg = 0;
            for (int i = counter-1 ; (i+1) > j; i--) {
                sum += times.get(i);
                Log.e("the sum is ",String.valueOf(sum));
            }
            avg = sum / 7;
            avgTextView.setText(String.valueOf(avg));

            Log.e("the counter is",String.valueOf(counter));
        }

    }


}
