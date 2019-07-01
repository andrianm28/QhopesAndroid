package com.qtasnim.qhopes.activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.qtasnim.qhopes.R;

public class PilihanPeranActivity extends AppCompatActivity {

    private Button mBtnDokter,mBtnPasien,mBtnLoginDokter;
    private EditText mInputNipDokter;
    private Dialog dialog;

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
        dialog.setContentView(R.layout.view_dialog_splashscreen);
        mInputNipDokter = dialog.findViewById(R.id.input_nip_dokter);
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
                Intent jumpActivity = new Intent(PilihanPeranActivity.this, MainActivity.class);
                startActivity(jumpActivity);
                finish();
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
}
