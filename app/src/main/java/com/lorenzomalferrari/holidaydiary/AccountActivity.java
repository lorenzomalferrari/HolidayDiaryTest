package com.lorenzomalferrari.holidaydiary;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lorenzomalferrari.holidaydiary.model.DatabaseHelper;

public class AccountActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    Button btnVisaulizzaDati;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        databaseHelper = new DatabaseHelper(this);
        //button
        btnVisaulizzaDati = findViewById(R.id.btnViewUsersA);
        //
        viewTableData();
    }


    public void viewTableData() {
        btnVisaulizzaDati.setOnClickListener(
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
}


