package com.lorenzomalferrari.holidaydiary;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };


    // UI references.
    private EditText emailText, passwordText;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        emailText = (EditText) findViewById(R.id.email);
        passwordText = (EditText) findViewById(R.id.password);

        //Esecuzione del bottone e rispettivo controllo dei dati inseriti
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //if profilo esiste già
                if (emailText.getText().toString().equals("malfe.lore@gmail.com") && passwordText.getText().toString().equals("123456")){
                    callMenu();
                }
                //else vai a crearti il profilo
                else{
                    callRegister();
                }
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

    }

    private boolean isEmailValid(String email) {
        //L'email deve contenere il campo @
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //La passowrd deve essere lunga almeno 6 caratteri
        return password.length() > 6;
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

