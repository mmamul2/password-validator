package com.matt.password_validator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void validatePassword(View view){
    //String xxxx = ((EditText) findViewById(R.id.password)).getText().toString();
   // System.out.println(password);

        ((TextView) findViewById(R.id.message)).setText("gggggggggg");



    }
}
