package model;

public class Balita {
    private int id;
    private String namaBalita, tglLahir, jenisKelamin, namaIbu, namaAyah, noTelpOrtu;
    
    public Balita(int id, String namaBalita, String tglLahir, String jenisKelamin, String namaIbu, String namaAyah, String noTelpOrtu) {
        this.id = id;
        this.namaBalita = namaBalita;
        this.tglLahir = tglLahir;
        this.jenisKelamin = jenisKelamin;
        this.namaIbu = namaIbu;
        this.namaAyah = namaAyah;
        this.noTelpOrtu = noTelpOrtu;
    }
    
    public int getId() {
        return id;
    }
    
    public String getNama() {
        return namaBalita;
    }
    
    public String getTglLahir() {
        return tglLahir;
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
    
    public void setNama(String nama) {
        this.namaBalita = nama;
    }
    
    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
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
        return String.format("%-10s | %-15s | %-13s | %-14s | %-17s | %-19s | %-20s", id, namaBalita, tglLahir, jenisKelamin, namaIbu, namaAyah, noTelpOrtu);
    }
}