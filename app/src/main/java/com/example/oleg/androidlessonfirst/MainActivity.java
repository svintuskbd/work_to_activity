package com.example.oleg.androidlessonfirst;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String LABEL = "label";
    TextView textView;
    EditText inputText1;
    EditText inputText2;
    Button actionAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_linear);

        inputText1 = (EditText) findViewById(R.id.input_text17);
        inputText2 = (EditText) findViewById(R.id.input_text2);

        actionAlert = (Button) findViewById(R.id.action_alert);
        textView = (TextView) findViewById(R.id.text_view);

        textView.setText(savedInstanceState == null ? "" : savedInstanceState.getString(LABEL));



        inputText1.addTextChangedListener(new OnTextChangeListener() {
            @Override
            public void afterTextChanged(Editable editable) {
                printTextView();
            }
        });

        inputText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                printTextView();
            }
        });

        actionAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String str = inputText1.getText().toString();
//                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(LABEL, textView.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString(LABEL, textView.getText().toString());
    }

    @SuppressLint("SetTextI18n")
    private void printTextView() {
        textView.setText(inputText1.getText().toString() + ", " + inputText2.getText().toString());
    }
}
