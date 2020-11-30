package com.dedykaryadigunawan.katalogperalatandapur.model;

public class Dapur {
    private String jenis;
    private String barang;
    private String harga;
    private String deskripsi;
    private int drawableRes;

    public Dapur(String jenis, String barang, String harga, String deskripsi, int drawableRes) {
        this.jenis = jenis;
        this.barang = barang;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.drawableRes = drawableRes;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getBarang() {
        return barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getDrawableRes() {
        return drawableRes;
    }

    public void setDrawableRes(int drawableRes) {
        this.drawableRes = drawableRes;
    }
}
