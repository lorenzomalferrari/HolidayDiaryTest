package com.lorenzomalferrari.holidaydiary;


import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lorenzomalferrari.holidaydiary.model.DatabaseHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment {

    DatabaseHelper databaseHelper;
    Button btnVisaulizzaDati;

    public HomePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle(R.string.homepage);
    }


    public void viewTableData(){
        btnVisaulizzaDati.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor cursor = databaseHelper.getAllData();
                        if (cursor.getCount() == 0){
                            //show message
                            showMessage("Errore","Trovo niente");
                            return;
                        }
                        else {
                            StringBuffer buffer = new StringBuffer();
                            while (cursor.moveToNext()){
                                buffer.append("Id : "+ cursor.getString(0)+"\n");
                                buffer.append("Nome : "+ cursor.getString(1)+"\n");
                                buffer.append("Cognome : "+ cursor.getString(2)+"\n");
                                buffer.append("Username : "+ cursor.getString(3)+"\n");
                                buffer.append("Password : "+ cursor.getString(4)+"\n");
                                buffer.append("City : "+ cursor.getString(5)+"\n");
                            }

                            // show all data
                            showMessage("Data",buffer.toString());
                        }
                    }
                }
        );
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
