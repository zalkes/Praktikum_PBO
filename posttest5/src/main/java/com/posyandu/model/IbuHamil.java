package com.posyandu.model;

public class IbuHamil extends Warga {
    private int usiaKehamilan;
    private String alamat, noTelp, riwayatKesehatan;

    public IbuHamil(int id, String nama, String tglLahir, String alamat, String noTelp, int usiaKehamilan, String riwayatKesehatan) {
        super(id, nama, tglLahir);
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.usiaKehamilan = usiaKehamilan;
        this.riwayatKesehatan = riwayatKesehatan;
    }

    public int getId() {
        return id;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public int getUsiaKehamilan() {
        return usiaKehamilan;
    }

    public String getRiwayatKesehatan() {
        return riwayatKesehatan;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public void setUsiaKehamilan(int usiaKehamilan) {
        this.usiaKehamilan = usiaKehamilan;
    }

    public void setRiwayatKesehatan(String riwayatKesehatan) {
        this.riwayatKesehatan = riwayatKesehatan;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-15s | %-13s | %-18s | %-18s | %-7s Minggu | %-15s", id, nama, tglLahir, alamat, noTelp, usiaKehamilan, riwayatKesehatan);
    }
}
