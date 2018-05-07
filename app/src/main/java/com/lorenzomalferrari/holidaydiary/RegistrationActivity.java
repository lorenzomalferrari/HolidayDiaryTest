package com.lorenzomalferrari.holidaydiary;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.lorenzomalferrari.holidaydiary.model.DatabaseHelper;

import java.util.ArrayList;

public class RegistrationActivity extends AppCompatActivity {

    /**
     *
     */
    DatabaseHelper databaseHelper;
    Button btnAddData,btnviewAll,btnDelete;
    RadioButton gender;
    EditText id,firstName,lastName,username,password,conf_password,email,city,country,birthdate;
    Button btnviewUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Oggetto della classe DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // FirstName
        firstName = findViewById(R.id.register_firstNameValue);
        // LastName
        lastName = findViewById(R.id.register_lastNameValue);
        // Username
        username =  findViewById(R.id.register_usarnameValue);
        // Email
        email =  findViewById(R.id.register_emailValue);
        // Password
        password =  findViewById(R.id.register_passwordValue);
        // Confirm Password
        conf_password =  findViewById(R.id.register_passwordValueValidate);
        // City
        city =  findViewById(R.id.register_cityValue);
        // Country
        country =  findViewById(R.id.register_countryValue);
        // Gender
        gender = getRadioButtonChecked();
        // Birthdate
        birthdate =  findViewById(R.id.register_birthdateValue);

        btnAddData = findViewById(R.id.btnSave);
        btnviewAll = findViewById(R.id.button_viewAll);
        btnviewUpdate= findViewById(R.id.button_update);
        btnDelete= findViewById(R.id.button_delete);

        //Aggiunta Utente
        AddData();
        //Visualizzo lista di tutti gli Utenti con tutti i rispettivi campi
        viewAll();
        //Aggiorno dati (id,nome,cognome,password)
        UpdateData();
        //Cancello utente sapendo id
        DeleteData();
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

    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = databaseHelper.deleteData(id.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(RegistrationActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(RegistrationActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    /**
     * Svuoto l'intera tabella
     */
    private void DeleteAllDatabase() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Ancora da modificare --> Scopo cancellare tutti i dati nella taabella
                        Integer deletedRows = databaseHelper.deleteData(id.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(RegistrationActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(RegistrationActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = databaseHelper.updateData(id.getText().toString(),
                                firstName.getText().toString(),
                                lastName.getText().toString(),password.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(RegistrationActivity.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(RegistrationActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = databaseHelper.insertData(createArrayList());
                        if(isInserted == true) {
                            Toast.makeText(RegistrationActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                            callMenu();
                        }
                        else
                            Toast.makeText(RegistrationActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = databaseHelper.getAllUsers();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Nome :"+ res.getString(1)+"\n");
                            buffer.append("Cognome :"+ res.getString(2)+"\n");
                            buffer.append("Username :"+ res.getString(3)+"\n");
                            buffer.append("Password :"+ res.getString(4)+"\n");
                            buffer.append("Email :"+ res.getString(5)+"\n");
                            buffer.append("City :"+ res.getString(6)+"\n");
                            buffer.append("Country :"+ res.getString(7)+"\n");
                            buffer.append("Gender :"+ res.getString(8)+"\n");
                            buffer.append("Birthdate :"+ res.getString(10)+"\n\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    /**
     * Mostro un messagio a seconda dei dati che ricevo
     * @param title
     * @param Message
     */
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);//funziona solo con Activity
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    /**
     * Chiamata alla MenuActivity (Navigation Drawer Activity)
     */
    //Chiama la MenuActivity (Navigation Drawer Activity)
    private void callMenu(){
        Intent intent = new Intent(this, MenuActivity.class);
        this.startActivity(intent);
    }
}