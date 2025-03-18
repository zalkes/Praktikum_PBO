package model;

public class IbuHamil {
    public int idIbuHamil, usiaKehamilan;
    public String nama, tglLahir, alamat, noTelp, riwayatKesehatan;

    public IbuHamil(int idIbuHamil, String nama, String tglLahir, String alamat, String noTelp, int usiaKehamilan, String riwayatKesehatan) {
        this.idIbuHamil = idIbuHamil;
        this.nama = nama;
        this.tglLahir = tglLahir;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.usiaKehamilan = usiaKehamilan;
        this.riwayatKesehatan = riwayatKesehatan;
    }

    public int getIdIbuHamil() {
        return idIbuHamil;
    }

    public String getNama() {
        return nama;
    }

    public String getTglLahir() {
        return tglLahir;
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

    public void setIdIbuHamil(int idIbuHamil) {
        this.idIbuHamil = idIbuHamil;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
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
        return String.format("%-10s | %-15s | %-13s | %-18s | %-18s | %-10s | %-15s", idIbuHamil, nama, tglLahir, alamat, noTelp, usiaKehamilan, riwayatKesehatan);
    }
}
