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

        if(passToValidate.equals("")){
            ((TextView) findViewById(R.id.message)).setText("No password entered");
            return;
        }

        int checksPassed = Validator.validate(passToValidate);

        //Cannot pass 0 check, is it fails the "password" test it will pass the length check.
        //Included 0 for completeness
        switch(checksPassed){
            case 0: ((TextView) findViewById(R.id.message)).setText("Very Weak");
                    break;
            case 1: ((TextView) findViewById(R.id.message)).setText("Very Weak");
                    break;
            case 2: ((TextView) findViewById(R.id.message)).setText("Weak");
                    break;
            case 3: ((TextView) findViewById(R.id.message)).setText("Not Strong");
                    break;
            case 4: ((TextView) findViewById(R.id.message)).setText("Not Strong");
                    break;
            case 5: ((TextView) findViewById(R.id.message)).setText("Strong");
                    break;
        }

    }
}
