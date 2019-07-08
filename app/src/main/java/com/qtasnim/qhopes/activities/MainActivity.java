package com.qtasnim.qhopes.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.qtasnim.qhopes.R;
import com.qtasnim.qhopes.misc.BottomNavigationViewHelper;
import com.qtasnim.qhopes.models.OtentifikasiModel;
import com.qtasnim.qhopes.navigation.fragments.AppointmentNavFragment;
import com.qtasnim.qhopes.navigation.fragments.DiagnosisNavFragment;
import com.qtasnim.qhopes.navigation.fragments.HomeNavFragment;
import com.qtasnim.qhopes.navigation.fragments.ProfilNavFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ArrayList<OtentifikasiModel> mModelData = new ArrayList<>();
    FloatingActionButton fab;
    Dialog dialog;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    HomeNavFragment fm1 =  new HomeNavFragment();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.frameLayout,fm1 );
                    fragmentTransaction1.commit();
                    return true;
                case R.id.navigation_appointment:
                    AppointmentNavFragment fm2 =  new AppointmentNavFragment();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.frameLayout,fm2 );
                    fragmentTransaction2.commit();
                    return  true;
                case R.id.navigation_diagnosis:
                    DiagnosisNavFragment fm3 =  new DiagnosisNavFragment();
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.frameLayout,fm3 );
                    fragmentTransaction3.commit();
                    return true;
                case R.id.navigation_profil:
                    ProfilNavFragment fm4 =  new ProfilNavFragment();
                    FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction4.replace(R.id.frameLayout,fm4 );
                    fragmentTransaction4.commit();
                    return true;
            }
            return false;
        }
    };
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        fab = findViewById(R.id.fab);
        fabOnClick();
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        HomeNavFragment fm =  new HomeNavFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fm );
        fragmentTransaction.commit();
    }
    private void initData() {
        mModelData.add(new OtentifikasiModel(12345,12345));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return true;
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    public void onBackPressed() {
       // moveTaskToBack(false);
        showExitAlert();
    }

    protected void showExitAlert() {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Apakah anda yakin mau keluar ?");
        alertDialogBuilder.setCancelable(true)
                .setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    public void fabOnClick() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, NavPendaftaranFormActivity.class);
                startActivity(intent);

            }
        });
    }
}
