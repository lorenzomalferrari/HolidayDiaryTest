package com.lorenzomalferrari.holidaydiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.lorenzomalferrari.holidaydiary.model.DatabaseHelper;

import java.util.ArrayList;

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
        // Inizializzazione dell'oggetto DatabaseHelper
        databaseHelper  = new DatabaseHelper(this);
        //Setto le mie variabili con i dati che mi arrivano dai campi
        getContent();
        //
        Button saveButon = findViewById(R.id.registerButton);
        saveButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ottengo i valori inseriti nei campi della Register Activity
                getContent();
                //Controllo che i campi siano corretti prima di salvarli

                //Inserisco i dati nel database
                boolean isInserted = databaseHelper.insertData(createArrayList());
                //Notifico all'utente il fatto che laregistrazione è stata effettuata o meno
                if (isInserted == true){
                    Toast.makeText(RegisterActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                    //Chiamo il Menu dell'applicazione
                    callMenu();
                }
                else{
                    Toast.makeText(RegisterActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    /**
     * Metodo che mi consente di raggruppare tutti i valori presi dalla registrazione
     * @return un oggetto di classe ArrayList
     */
    private ArrayList createArrayList(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(firstName.getText().toString());
        arrayList.add(lastName.getText().toString());
        arrayList.add(username.getText().toString());
        arrayList.add(password.getText().toString());
        arrayList.add(email.getText().toString());
        arrayList.add(city.getText().toString());
        arrayList.add(country.getText().toString());
        arrayList.add(gender.getText().toString());
        arrayList.add(birthdate.getText().toString());
        return arrayList;
    }


    /**
     * Chiamo il Menu dell'applicazione (Navigation Drawer Activity)
     */
    private void callMenu(){
        Intent intent = new Intent(this, MenuActivity.class);
        this.startActivity(intent);
    }

    /**
     * Compilo i campi con i dati inseriti dall'utente
     */
    private void getContent() {
        // FirstName
        firstName = findViewById(R.id.register_firstNameValue);
        // LastName
        lastName = findViewById(R.id.register_lastNameValue);
        // Username
        username =  findViewById(R.id.register_usarnameValue);
        // Password
        password =  findViewById(R.id.register_passwordValue);
        // Confirm Password
        conf_password =  findViewById(R.id.register_passwordValueValidate);
        // Email
        email =  findViewById(R.id.register_emailValue);
        // City
        city =  findViewById(R.id.register_cityValue);
        // Country
        country =  findViewById(R.id.register_countryValue);
        // Birthdate
        birthdate =  findViewById(R.id.register_birthdateValue);
        // Gender
        gender = getRadioButtonChecked();
        // bntRegister
        //btnRegister =  findViewById(R.id.registerButton);
    }

    /**
     * Metodo per ottenere il radioButton selezionato
     * @return
     */
    private RadioButton getRadioButtonChecked(){
        RadioButton radioMale =  findViewById(R.id.radioButtonMale);
        RadioButton radioFemale =  findViewById(R.id.radioButtonFemale);
        if (radioMale.isChecked() == true){
            return radioMale;
        }
        else
            return radioFemale;
    }

    /**
     * Controllo della password per la validazione
     * @return true se è ok false e non è ok
     */
    private boolean canvalidPassword(){
        boolean isConvalid = false;
        //Prima controllo che password e conf_password siano uguali
        if (password.getText().toString().equals(conf_password.getText().toString()) == true){
            //Controllo che password > 6 char
        }

        //Controllo che password non contenga lettere strane
        return isConvalid;
    }
}
