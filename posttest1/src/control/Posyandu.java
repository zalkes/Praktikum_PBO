package control;
import model.Balita;
import model.IbuHamil;
import service.ManajemenBalita;
import service.ManajemenIbuHamil;

import java.util.ArrayList;

public class Posyandu {
    private ManajemenBalita manajemenBalita;
    private ManajemenIbuHamil manajemenIbuHamil;

    public Posyandu() {
        this.manajemenBalita = new ManajemenBalita();
        this.manajemenIbuHamil = new ManajemenIbuHamil();
    }

    public Balita addBalita(String namaBalita, String tglLahir, String jenisKelamin, String namaIbu, String namaAyah, String noTelpOrtu) {
        return manajemenBalita.addBalita(namaBalita, tglLahir, jenisKelamin, namaIbu, namaAyah, noTelpOrtu);
    }

    public ArrayList<Balita> getAllBalita() {
        return manajemenBalita.getAllBalita();
    }

    public Balita getBalitaById(int id) {
        return manajemenBalita.getBalitaById(id);
    }

    public boolean updateBalita(int id, String namaBalita, String tglLahir, String jenisKelamin, String namaIbu, String namaAyah, String noTelpOrtu) {
        return manajemenBalita.updateBalita(id, namaBalita, tglLahir, jenisKelamin, namaIbu, namaAyah, noTelpOrtu);
    }

    public boolean deleteBalita(int id) {
        return manajemenBalita.deleteBalita(id);
    }

    public IbuHamil addIbuHamil(String nama, String tglLahir, String alamat, String noTelp, int usiaKehamilan, String riwayatKesehatan) {
        return manajemenIbuHamil.addIbuHamil(nama, tglLahir, alamat, noTelp, usiaKehamilan, riwayatKesehatan);
    }

    public ArrayList<IbuHamil> getAllIbuHamil() {
        return manajemenIbuHamil.getAllIbuHamil();
    }

    public IbuHamil getIbuHamilById(int id) {
        return manajemenIbuHamil.getIbuHamilById(id);
    }

    public boolean updateIbuHamil(int id, String nama, String tglLahir, String alamat, String noTelp, int usiaKehamilan, String riwayatKesehatan) {
        return manajemenIbuHamil.updateIbuHamil(id, nama, tglLahir, alamat, noTelp, usiaKehamilan, riwayatKesehatan);
    }

    public boolean deleteIbuHamil(int id) {
        return manajemenIbuHamil.deleteIbuHamil(id);
    }
}
