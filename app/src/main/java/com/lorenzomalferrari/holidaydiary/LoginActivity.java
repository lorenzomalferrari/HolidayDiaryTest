package com.lorenzomalferrari.holidaydiary;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.RelativeLayout;
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
    private EditText email, password;
    private Button btnLogin;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        databaseHelper  = new DatabaseHelper(this);

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
                        if(res.getCount() == 0) {
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
        Intent intent = new Intent(this, RegisterActivity.class);
        this.startActivity(intent);
    }

}

