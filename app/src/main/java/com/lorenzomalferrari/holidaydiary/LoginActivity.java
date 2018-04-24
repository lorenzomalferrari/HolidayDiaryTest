package com.lorenzomalferrari.holidaydiary;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

//My import
import com.lorenzomalferrari.holidaydiary.model.DatabaseHelper;
import com.lorenzomalferrari.holidaydiary.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    // UI references.
    private EditText emailText, passwordText;
    private View mProgressView;
    private View mLoginFormView;
    private User user = new User("malfe.lore@gmail.com","123456");
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        databaseHelper  = new DatabaseHelper(this);

        // Set up the login form.
        emailText = findViewById(R.id.email); //email inserita dall'utente
        passwordText = findViewById(R.id.password); //password inserita dall'utente

        //Esecuzione del bottone e rispettivo controllo dei dati inseriti
        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //interrogo il db per sapere se email e password sono già presenti e se hanno lo stesso id

                //if profilo esiste già
                if (emailText.getText().toString().equals(user.getEmail()) && passwordText.getText().toString().equals(user.getPassword())){
                    callMenu();
                }
                //else vai a crearti il profilo
                else{
                    callRegister();
                }
            }
        });

        //mLoginFormView = findViewById(R.id.login_form);
        //mProgressView = findViewById(R.id.login_progress);

    }

    //Metodo funzionante e testato
    //Da usare per controllo durante la registrazione
    private boolean isEmailValid(String email) {
        //L'email deve contenere il campo @
        if (email.contains("@") == true){
            return true;
        }
        else {
            return false;
        }
    }


    //Metodo funzionante e testato
    //Da usare per controllo durante la registrazione
    private boolean isPasswordValid(String password) {
        //La passowrd deve essere lunga almeno 6 caratteri
        if ((password.length() >= 6) == true){
            return true;
        }
        else {
            return false;
        }
    }

    //Chiama la RegisterActivity
    private void callRegister(){
        Intent intent = new Intent(this, RegisterActivity.class);
        this.startActivity(intent);
    }


    //Chiama la MenuActivity (Navigation Drawer Activity)
    private void callMenu(){
        Intent intent = new Intent(this, MenuActivity.class);
        this.startActivity(intent);
    }

}

