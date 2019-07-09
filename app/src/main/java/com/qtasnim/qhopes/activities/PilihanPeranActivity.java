package com.qtasnim.qhopes.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.qtasnim.qhopes.R;

public class PilihanPeranActivity extends AppCompatActivity {

    private Button mBtnDokter,mBtnPasien;
    private TextInputEditText mInputNipDokter;
    private Dialog dialog;
    private MaterialButton mBtnLoginDokter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // buat fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pilihan_peran);
        getSupportActionBar().hide();

        mBtnPasien = findViewById(R.id.btn_pasien);
        mBtnDokter = findViewById(R.id.btn_dokter);

        mBtnDokter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                DokterDialog();
            }
        });

        mBtnPasien.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent jumpActivity= new Intent(PilihanPeranActivity.this, MainActivity.class);
                startActivity(jumpActivity);
                finish();
            }
        });

    }
    private void DokterDialog(){
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.view_dialog_dokter_form);
        mInputNipDokter = dialog.findViewById(R.id.input_nip_dokter_form);
        mBtnLoginDokter = dialog.findViewById(R.id.btn_login_dokter);
        mBtnPasien.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                Intent jumpActivity= new Intent(PilihanPeranActivity.this, PilihanPeranActivity.class);
                startActivity(jumpActivity);
                finish();
            }
        });
        mBtnLoginDokter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final String isNip = mInputNipDokter.getText().toString();
                if (isNip.matches("12345")){
                    showGreetingAlert();
                    dialog.dismiss();
                }else{
                    showNipAlert();
                }
            }
        });
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    protected void showNipAlert() {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PilihanPeranActivity.this);
        alertDialogBuilder.setTitle("Alert");
        alertDialogBuilder.setMessage("NIP Tidak Ditemukan!");
        alertDialogBuilder.setCancelable(true)
                .setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
    protected void showGreetingAlert() {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PilihanPeranActivity.this);
        alertDialogBuilder.setTitle("Selamat Datang");
        alertDialogBuilder.setMessage("Dokter Ayana \nNIP : 12345");
        alertDialogBuilder.setCancelable(true)
                .setPositiveButton("Masuk", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent jumpActivity = new Intent(PilihanPeranActivity.this, MainActivity.class);
                        startActivity(jumpActivity);
                        finish();
                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
}
