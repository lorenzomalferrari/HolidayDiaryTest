package com.lorenzomalferrari.holidaydiary;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lorenzomalferrari.holidaydiary.model.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText email,password;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        databaseHelper = new DatabaseHelper(this);
        btnLogin = findViewById(R.id.btnLogin);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        checkLogin();
    }

    public void checkLogin() {
        btnLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = databaseHelper.getData(email.getText().toString(),password.getText().toString());
                        if(res.getCount() == 0 || res == null) {
                            callRegister();
                        }
                        else {
                            callMenu();
                        }
                    }
                }
        );
    }

    //Chiama la MenuActivity (Navigation Drawer Activity)
    private void callMenu(){
        Intent intent = new Intent(this, MenuActivity.class);
        this.startActivity(intent);
    }

    //Chiama la RegisterActivity
    private void callRegister(){
        Intent intent = new Intent(this, RegistrationActivity.class);
        this.startActivity(intent);
    }
}
