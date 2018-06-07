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
        String passToValidate = ((EditText) findViewById(R.id.password)).getText().toString();
        String blankPass = "No password entered";

        if(passToValidate.equals("")){
            ((TextView) findViewById(R.id.message)).setText(blankPass);
            return;
        }

        int checksPassed = Validator.validate(passToValidate);
        String status[] = {"Very Weak", "Weak", "Not Strong", "Strong"};

        if(checksPassed <= 1){
            ((TextView) findViewById(R.id.message)).setText(status[0]);
        } else if(checksPassed == 2){
            ((TextView) findViewById(R.id.message)).setText(status[1]);
        } else if(checksPassed <= 4){
            ((TextView) findViewById(R.id.message)).setText(status[2]);
        } else if(checksPassed == 5){
            ((TextView) findViewById(R.id.message)).setText(status[3]);
        }
    }
}
