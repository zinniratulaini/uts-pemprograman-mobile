package com.dedykaryadigunawan.katalogperalatandapur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnElektronik,btnNonelektronik;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();

    }

    private void inisialisasiView() {
        btnElektronik = findViewById(R.id.btn_buka_Elektronik);
        btnNonelektronik = findViewById(R.id.btn_buka_ras_Nonelektronik);
        btnElektronik.setOnClickListener(view -> bukaGaleri("Elektronik"));
        btnNonelektronik.setOnClickListener(view -> bukaGaleri("Nonelektronik"));
    }

    private void bukaGaleri(String jenisDapur) {
        Log.d("MAIN","Buka activity Elektronik");
        Intent intent = new Intent(this, GaleriActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, jenisDapur);
        startActivity(intent);
    }

}