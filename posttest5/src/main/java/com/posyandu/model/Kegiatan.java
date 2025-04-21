package com.posyandu.model;

public class Kegiatan {
    //Penggunaan access modifier protected
    protected int idKegiatan;
    protected String namaKegiatan, tanggal, waktu, kader;

    public Kegiatan(int idKegiatan, String namaKegiatan, String tanggal, String waktu, String kader) {
        this.idKegiatan = idKegiatan;
        this.namaKegiatan = namaKegiatan;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.kader = kader;
    }

    public int getIdKegiatan() {
        return idKegiatan;
    }

    public String getNamaKegiatan() {
        return namaKegiatan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getWaktu() {
        return waktu;
    }

    public String getKader() {
        return kader;
    }

    public void setNamaKegiatan(String namaKegiatan) {
        this.namaKegiatan = namaKegiatan;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public void setKader(String kader) {
        this.kader = kader;
    }

    @Override
    public String toString() {
        return String.format("%-5d | %-20s | %-10s | %-10s | %-10s", idKegiatan, namaKegiatan, tanggal, waktu, kader);
    }
}