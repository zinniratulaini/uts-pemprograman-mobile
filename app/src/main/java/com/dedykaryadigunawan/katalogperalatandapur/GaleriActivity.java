package com.dedykaryadigunawan.katalogperalatandapur;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import com.dedykaryadigunawan.katalogperalatandapur.model.Dapur;

public class GaleriActivity extends AppCompatActivity {

    List<Dapur> dapurs;
    int indeksTampil = 0;
    String jenisDapur;
    Button btnPertama,btnTerakhir,btnSebelumnya,btnBerikutnya;
    TextView txJenis,txBarang,txHarga,txDeskripsi,txJudul;
    ImageView ivFotoDapur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_barang);
        Intent intent = getIntent();
        jenisDapur = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        dapurs = DataProvider.getHewansByTipe(this,jenisDapur);
        inisialisasiView();
        tampilkanProfil();
    }

    private void inisialisasiView() {
        btnPertama = findViewById(R.id.btnPertama);
        btnSebelumnya = findViewById(R.id.btnSebelumnya);
        btnBerikutnya = findViewById(R.id.btnBerikutnya);
        btnTerakhir = findViewById(R.id.btnTerakhir);

        btnPertama.setOnClickListener(view -> dapurPertama());
        btnTerakhir.setOnClickListener(view -> dapurTerakhir());
        btnSebelumnya.setOnClickListener(view -> dapurSebelumnya());
        btnBerikutnya.setOnClickListener(view -> dapurBerikutnya());

        txJenis = findViewById(R.id.txJenis);
        txBarang = findViewById(R.id.txBarang);
        txHarga = findViewById(R.id.txHarga);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoDapur = findViewById(R.id.gambarDapur);

        txJudul = findViewById(R.id.txJudul);
        txJudul.setText("Barang Dapur "+jenisDapur);
    }


    private void tampilkanProfil() {
        Dapur k = dapurs.get(indeksTampil);
        Log.d("Nonelektronik","Menampilkan nonelektronik "+k.getJenis());
        txJenis.setText(k.getJenis());
        txBarang.setText(k.getBarang());
        txHarga.setText(k.getHarga());
        txDeskripsi.setText(k.getDeskripsi());
        ivFotoDapur.setImageDrawable(this.getDrawable(k.getDrawableRes()));
    }

    private void dapurPertama() {
        int posAwal = 0;
        if (indeksTampil == posAwal) {
            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAwal;
            tampilkanProfil();
        }
    }

    private void dapurTerakhir() {
        int posAkhir = dapurs.size() - 1;
        if (indeksTampil == posAkhir) {
            Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAkhir;
            tampilkanProfil();
        }
    }

    private void dapurBerikutnya() {
        if (indeksTampil == dapurs.size() - 1) {
            Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil++;
            tampilkanProfil();
        }
    }

    private void dapurSebelumnya() {
        if (indeksTampil == 0) {
            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil--;
            tampilkanProfil();
        }
    }
}