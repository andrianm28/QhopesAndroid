package com.qtasnim.qhopes;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.qtasnim.qhopes.activities.MainActivity;

public class SplashscreenActivity extends AppCompatActivity {
    private int waktuLoading = 1000;
    AlertDialog.Builder mDialog;
    Dialog dialog;
    LayoutInflater mInflaterDialog;
    View mViewDialog;
    Button btnPasien,btnDokter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // buat fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                DialogPilihan();
                Intent jumpActivity = new Intent(SplashscreenActivity.this, PilihanPeranActivity.class);
                startActivity(jumpActivity);
                finish();
            }
        }, waktuLoading);
    }
    private void DialogPilihan(){
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.view_dialog_splashscreen);
        btnPasien = dialog.findViewById(R.id.btn_pasien);
        btnDokter = dialog.findViewById(R.id.btn_dokter);
        btnPasien.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                Intent jumpActivity= new Intent(SplashscreenActivity.this, PilihanPeranActivity.class);
                startActivity(jumpActivity);
                finish();
            }
        });
        btnDokter.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                DokterDialog();
            }
        });
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                finish();
            }
        });
        dialog.show();
    }

    private void DokterDialog(){
        LayoutInflater layoutInflater = LayoutInflater.from(SplashscreenActivity.this);
        View promptView = layoutInflater.inflate(R.layout.view_dialog_dokter_splashscreen, null);
        android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(SplashscreenActivity.this);
        alertDialogBuilder.setView(promptView);
        final EditText editText = (EditText) promptView.findViewById(R.id.txtInDokterNip);
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //    resultText.setText("Hello, " + editText.getText());
                        showMessage("Hello ","NIP = "+editText.getText()   );
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                DialogPilihan();
                            }
                        });
        android.app.AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    public void showMessage(String title,String message)
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("masuk", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent pilih =new Intent(SplashscreenActivity.this, MainActivity.class);
                startActivity(pilih);
                finish();
            }
        });
        builder.show();

    }
}
