package com.lorenzomalferrari.holidaydiary;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.lorenzomalferrari.holidaydiary.model.DatabaseHelper;

/**
 *
 * @author Lorenzo Malferrari - www.lorenzomalferrari.com
 */
public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText email,password;
    DatabaseHelper databaseHelper;


    //Variabili di test
    LinearLayout layoutTop, layoutDown;
    Animation uptodown, downtoup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        databaseHelper = new DatabaseHelper(this);
        btnLogin = findViewById(R.id.btnLogin);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        //
        layoutTop = findViewById(R.id.layoutTop);
        layoutDown = findViewById(R.id.layoutDown);
        //Animazione da top a down
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        layoutTop.setAnimation(uptodown);
        //Animazione da down a top
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        layoutDown.setAnimation(downtoup);

        checkLogin();
    }

    /**
     *
     */
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

    /**
     * Chiama la MenuActivity (Navigation Drawer Activity)
     */
    private void callMenu(){
        Intent intent = new Intent(this, MenuActivity.class);
        this.startActivity(intent);
    }

    /**
     * Chiama la RegisterActivity
     */
    private void callRegister(){
        Intent intent = new Intent(this, RegistrationActivity.class);
        this.startActivity(intent);
    }
}
