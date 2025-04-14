package com.posyandu.model;

public class Warga {
    protected int id;
    protected String nama, tglLahir;

    public Warga(int id, String nama, String tglLahir) {
        this.id = id;
        this.nama = nama;
        this.tglLahir = tglLahir;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }
}