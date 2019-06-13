package com.simrs.qt.simrs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class choice extends AppCompatActivity {
    private String m_Text = "";
    Button btnpilihpasien;
    Button btnpilihdokter;
    LayoutInflater li;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        btnpilihpasien = (Button) findViewById(R.id.btnpilpasien);
        btnpilihpasienOnclick();
        btnpilihdokter = (Button) findViewById(R.id.btnpildokter);
        btnpilihdokterOnclick();
    }

    public void btnpilihpasienOnclick()
    {
        btnpilihpasien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pilih =new Intent(choice.this, MainActivity.class);
                startActivity(pilih);
                finish();
            }
        });
    }

    public void btnpilihdokterOnclick()
    {
        btnpilihdokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showInputDialog();


            }
        });

    }

    protected void showInputDialog() {

        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(choice.this);
        View promptView = layoutInflater.inflate(R.layout.prompt_pilih, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(choice.this);
        alertDialogBuilder.setView(promptView);

        final EditText editText = (EditText) promptView.findViewById(R.id.txtInDokterNip);
        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    //    resultText.setText("Hello, " + editText.getText());
                        showMessage("Hello ","NIP = "+editText.getText()   );
                        Intent pilih =new Intent(choice.this, MainActivity.class);
                        startActivity(pilih);
                        finish();
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
}
