package com.example.home.android_labs;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText inputName;
    private EditText inputSurname;
    private EditText inputEmail;
    private EditText inputPhone;
    private EditText inputPassword;
    private EditText inputConfirmedPassword;
    private Button submit;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        inputName = findViewById(R.id.inputName);
        inputSurname = findViewById(R.id.inputSurname);
        inputEmail = findViewById(R.id.inputEmail);
        inputPhone = findViewById(R.id.inputPhone);
        inputPassword = findViewById(R.id.inputPassword);
        inputConfirmedPassword = findViewById(R.id.inputConfirmedPassword);
        submit = findViewById(R.id.Submit);
        result = findViewById(R.id.Result);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> errors = validate();
                if (errors.isEmpty()) {
                    result.setTextColor(Color.parseColor("#00FF00"));
                    result.setText("Registration was completed successfully");
                } else {
                    result.setTextColor(Color.parseColor("#FF0000"));
                    result.setText(errors.toString());
                }


            }
        });


    }

    public List<String> validate() {
        List<String> errors = new ArrayList<>();
        String name = inputName.getText().toString();
        String surname = inputSurname.getText().toString();
        String email = inputEmail.getText().toString();
        String phone = inputPhone.getText().toString();
        String password = inputPassword.getText().toString();
        String confirmedPassword = inputConfirmedPassword.getText().toString();

        Pattern namePattern = Pattern.compile("^[A-Z][a-z\\s]{1,}");
        Pattern passwordPattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,}");
        Matcher matcherName = namePattern.matcher(name);
        Matcher matcherSurname = namePattern.matcher(surname);
        Matcher matcherPassword = passwordPattern.matcher(password);

        if (name.isEmpty())
            errors.add("Field name is empty \n");

        else {
            if (matcherName.matches() == false)
                errors.add("Name must be started with a capital letter and consist only of letters \n");
        }
        if (surname.isEmpty())
            errors.add("Field surname is empty \n");

        else {
            if (matcherSurname.matches() == false)
                errors.add("Surname must be started with a capital letter and consist only of letters \n");
        }
        if (email.isEmpty())
            errors.add("Field email is empty \n");

        else {
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                errors.add("Email is invalid \n");
        }
        if (phone.isEmpty())
            errors.add("Field phone is empty \n");

        else {
            if (!Patterns.PHONE.matcher(phone).matches())
                errors.add("Phone number is invalid \n");
        }
        if (password.isEmpty())
            errors.add("Field password is empty \n");

        else {
            if (password.length() > 6)
                if (matcherPassword.matches() == false)
                    errors.add("Password must consist of capital letters, small letters and numbers \n");
                else
                    errors.add("Password length must be at least 6 characters \n");

        }
        if (confirmedPassword.isEmpty())
            errors.add("Field confirmed password is empty \n");

        else {
            if (!confirmedPassword.equals(password))
                errors.add("Passwords do not match \n");

        }

        return errors;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
