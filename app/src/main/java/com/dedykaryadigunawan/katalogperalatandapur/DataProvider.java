package com.dedykaryadigunawan.katalogperalatandapur;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import com.dedykaryadigunawan.katalogperalatandapur.model.Dapur;
import com.dedykaryadigunawan.katalogperalatandapur.model.Elektronik;
import com.dedykaryadigunawan.katalogperalatandapur.model.Nonelektronik;

public class DataProvider {
    private static List<Dapur> dapurs = new ArrayList<>();

    private static List<Elektronik> initDataElektronik(Context ctx) {
        List<Elektronik> elektroniks = new ArrayList<>();
        elektroniks.add(new Elektronik("blender", "Rp 400.000.00",
                "kegunaan blender adalah untuk mencampur bahan, menghancurkan es batu atau bahan keras lain, membuat smoothie.", R.drawable.blender));
        elektroniks.add(new Elektronik("ricecooker", "Rp 300.000.00",
                "ricecooker atau penanak nasi adalah alat listrik yang berfungsi untuk memasak atau menanak nasi.", R.drawable.rice_coker));
        elektroniks.add(new Elektronik("mixer ", "Rp 250.000.00",
                "Mikser atau alat pengaduk adalah alat mekanis yang digunakan untuk mencampur bahan adonan yang biasanya digunakan untuk pembuatan kue.. Pencampuran ini dikenal dengan mix dalam bahasa Inggris, sehingga alatnya dikenal dengan nama pencampur ('mixer').", R.drawable.mixer));
        elektroniks.add(new Elektronik("Microwave ", "Rp 1000.000.00",
                "Fungsi mendasar pada microwave biasanya dipakai untuk membuat popcorn, memasak mie instan, ataupun mencairkan daging beku.", R.drawable.microwave));
        elektroniks.add(new Elektronik("Toaster (Pemanggang Roti)", "Rp 200.000.00",
                "Fungsi toaster sebagai pemanggang roti menjadi andalan bagi pecinta roti panggang. Alat untuk memanggang roti ini juga memiliki beberapa fitur dan fungsi pada setiap bagian-bagian pentingnya.", R.drawable.panggangan_roti));
        return elektroniks;
    }

    private static List<Nonelektronik> initDataNonelektronik(Context ctx) {
        List<Nonelektronik> nonelektroniks = new ArrayList<>();
        nonelektroniks.add(new Nonelektronik("Pisau", "Rp 25.000.00",
                "Pisau ialah alat yang digunakan untuk memotong sebuah benda. Pisau terdiri dari dua bagian utama, yaitu bilah pisau dan gagang atau pegangan pisau.", R.drawable.pisau));
        nonelektroniks.add(new Nonelektronik("Kompor", "Rp 450.000.00",
                "alat masak yang menghasilkan panas tinggi. Kompor mempunyai ruang tertutup / terisolasi dari luar sebagai tempat bahan bakar diproses untuk memberikan pemanasan bagi barang-barang yang diletakkan di atasnya.", R.drawable.kompor));
        nonelektroniks.add(new Nonelektronik("Wajan", "Rp 55.000.00",
                "Satu wajan itu bisa digunakan untuk berbagai fungsi, dari menggoreng, menumis, memanggang, hingga memasak makanan berkuah.  ", R.drawable.wajan));
        nonelektroniks.add(new Nonelektronik("Panci", "Rp 65.000.00",
                "adalah alat masak yang terbuat dari logam (alumunium, baja, dll) dan berbentuk silinder atau mengecil pada bagian bawahnya.", R.drawable.panci));
        nonelektroniks.add(new Nonelektronik("Parutan", "Rp 25.000.00",
                "adalah sebuah peralatan dapur yang digunakan untuk memarut makanan menjadi potongan-potongan halus.", R.drawable.parutan));
        return nonelektroniks;
    }

    private static void initAllDapurs(Context ctx) {
        dapurs.addAll(initDataElektronik(ctx));
        dapurs.addAll(initDataNonelektronik(ctx));
    }

    public static List<Dapur> getAllDapur(Context ctx) {
        if (dapurs.size() == 0) {
            initAllDapurs(ctx);
        }
        return dapurs;
    }

    public static List<Dapur> getHewansByTipe(Context ctx, String jenis) {
        List<Dapur> dapursByType = new ArrayList<>();
        if (dapurs.size() == 0) {
            initAllDapurs(ctx);
        }
        for (Dapur h : dapurs) {
            if (h.getJenis().equals(jenis)) {
                dapursByType.add(h);
            }
        }
        return dapursByType;
    }

}
