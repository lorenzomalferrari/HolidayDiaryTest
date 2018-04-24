package com.lorenzomalferrari.holidaydiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.lorenzomalferrari.holidaydiary.model.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    //
    EditText firstName,lastName,username,password,conf_password,email,city,country,birthdate;
    //
    RadioButton gender;
    //
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        databaseHelper  = new DatabaseHelper(this);

        //Setto le mie variabili con i dati che mi arrivano dai campi
        getContent();

        Button saveButon = (Button) findViewById(R.id.registerButton);
        saveButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //attemptLogin();
                callMenu();

            }
        });
    }

    private void callMenu(){
        Intent intent = new Intent(this, MenuActivity.class);
        this.startActivity(intent);
    }

    /**
     *
     */
    private void getContent() {
        // FirstName
        firstName = (EditText) findViewById(R.id.register_firstNameValue);
        // LastName
        lastName = (EditText) findViewById(R.id.register_lastNameValue);
        // Username
        username = (EditText) findViewById(R.id.register_usarnameValue);
        // Password
        password = (EditText) findViewById(R.id.register_passwordValue);
        // Confirm Password
        conf_password = (EditText) findViewById(R.id.register_passwordValueValidate);
        // Email
        email = (EditText) findViewById(R.id.register_emailValue);
        // City
        city = (EditText) findViewById(R.id.register_cityValue);
        // Country
        country = (EditText) findViewById(R.id.register_countryValue);
        // Birthdate
        birthdate = (EditText) findViewById(R.id.register_birthdateValue);
        // Gender
        gender = getRadioButtonChecked();
        // bntRegister
        btnRegister = (Button) findViewById(R.id.registerButton);
    }

    /**
     * 
     * @return
     */
    private RadioButton getRadioButtonChecked(){
        RadioButton radioMale = (RadioButton) findViewById(R.id.radioButtonMale);
        RadioButton radioFemale = (RadioButton) findViewById(R.id.radioButtonFemale);
        if (radioMale.isChecked() == true){
            return radioMale;
        }
        else
            return radioFemale;
    }
}
