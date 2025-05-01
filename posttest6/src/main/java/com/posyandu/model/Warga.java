package com.posyandu.model;

// Abstract class
public abstract class Warga {
    // Penggunaan final di atribut variabel id
    protected final int id;
    protected String nama, tglLahir;

    protected Warga(int id, String nama, String tglLahir) {
        this.id = id;
        this.nama = nama;
        this.tglLahir = tglLahir;
    }

    // Abstract method
    protected abstract int getId();

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