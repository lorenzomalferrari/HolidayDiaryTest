package com.lorenzomalferrari.holidaydiary;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.lorenzomalferrari.holidaydiary.model.DatabaseHelper;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DatabaseHelper databaseHelper;
    Button btnVisaulizzaDati;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //add this line to display menu1 when the activity is loaded
        /* Modificare in modo che legga lo stato della pagina così se ruoto tel non cambia la situazione */
        displaySelectedScreen(R.id.nav_homepage);

        btnVisaulizzaDati = findViewById(R.id.btnViewUsers);
        //
        viewTableData();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        //calling the method displayselectedscreen and passing the id of selected menu
        displaySelectedScreen(item.getItemId());
        //make this method blank
        return true;
    }

    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_homepage:
                fragment = new HomePageFragment();
                break;
            case R.id.nav_travels:
                fragment = new TravelsFragment();
                break;
            case R.id.nav_notes:
                fragment = new NotesFragment();
                break;
            case R.id.nav_pictures:
                fragment = new PicturesFragment();
                break;
            case R.id.nav_position:
                fragment = new PositionFragment();
                break;
            case R.id.nav_account:
                fragment = new AccountFragment();
                break;
            case R.id.nav_settings:
                fragment = new SettingsFragment();
                break;
            case R.id.nav_privacytermsofuse:
                fragment = new PrivacyTermsFragment();
                break;
            case R.id.nav_version:
                fragment = new VersionFragment();
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }



    public void viewTableData(){
        btnVisaulizzaDati.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor cursor = databaseHelper.getAllUsers();
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
