package com.posyandu.model;

public class Balita extends Warga {
    private String jenisKelamin, namaIbu, namaAyah, noTelpOrtu;
    
    public Balita(int id, String nama, String tglLahir, String jenisKelamin, String namaIbu, String namaAyah, String noTelpOrtu) {
        super(id, nama, tglLahir);
        this.jenisKelamin = jenisKelamin;
        this.namaIbu = namaIbu;
        this.namaAyah = namaAyah;
        this.noTelpOrtu = noTelpOrtu;
    }
    
    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public String getNamaIbu() {
        return namaIbu;
    }

    public String getNamaAyah() {
        return namaAyah;
    }

    public String getNoTelpOrtu() {
        return noTelpOrtu;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    public void setNamaAyah(String namaAyah) {
        this.namaAyah = namaAyah;
    }

    public void setNoTelpOrtu(String noTelpOrtu) {
        this.noTelpOrtu = noTelpOrtu;
    }
    
    @Override
    public String toString() {
        return String.format("%-10s | %-15s | %-13s | %-14s | %-17s | %-19s | %-20s", id, nama, tglLahir, jenisKelamin, namaIbu, namaAyah, noTelpOrtu);
    }
}