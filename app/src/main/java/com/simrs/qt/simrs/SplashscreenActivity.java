package com.simrs.qt.simrs;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class SplashscreenActivity extends AppCompatActivity {
    private int waktu_loading=1000;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_splashscreen);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Dialog();
            }
        }, waktu_loading);

    }

    private void Dialog(){
        dialog = new AlertDialog.Builder(SplashscreenActivity.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_splashscreen,null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Masuk Sebagai:");

        dialog.setPositiveButton("DOKTER", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showInputDialog();
            }
        });
        dialog.setNegativeButton("PASIEN", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent pilih =new Intent(SplashscreenActivity.this, MainActivity.class);
                startActivity(pilih);
                finish();
            }
        });
        dialog.show();

    }
    protected void showInputDialog() {

        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(SplashscreenActivity.this);
        View promptView = layoutInflater.inflate(R.layout.prompt_pilih, null);
        android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(SplashscreenActivity.this);
        alertDialogBuilder.setView(promptView);

        final EditText editText = (EditText) promptView.findViewById(R.id.txtInDokterNip);
        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //    resultText.setText("Hello, " + editText.getText());
                        showMessage("Hello ","NIP = "+editText.getText()   );
                        Intent pilih =new Intent(SplashscreenActivity.this, MainActivity.class);
                        startActivity(pilih);
                        finish();
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Dialog();
                            }
                        });

        // create an alert dialog
        android.app.AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
    public void showMessage(String title,String message)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

}
