package com.example.oleg.androidlessonfirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView secondText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        secondText = (TextView) findViewById(R.id.second_view);

        if (getIntent().hasExtra(MainActivity.LABEL)) {
            secondText.setText(getIntent().getStringExtra(MainActivity.LABEL));
        }
    }
}
