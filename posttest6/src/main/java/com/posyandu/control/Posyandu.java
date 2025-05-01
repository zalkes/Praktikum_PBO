package com.posyandu.control;
import com.posyandu.model.Balita;
import com.posyandu.model.IbuHamil;
import com.posyandu.model.Kegiatan;
import com.posyandu.model.PenimbanganBalita;
import com.posyandu.model.PenimbanganIbuHamil;
import com.posyandu.service.ManajemenBalita;
import com.posyandu.service.ManajemenIbuHamil;
import com.posyandu.service.ManajemenKegiatan;
import com.posyandu.service.ManajemenPenimbanganIbuHamil;
import com.posyandu.service.ManajemenPenimbanganBalita;

import java.util.ArrayList;

public class Posyandu {
    private ManajemenBalita manajemenBalita;
    private ManajemenIbuHamil manajemenIbuHamil;
    private ManajemenKegiatan manajemenKegiatan;
    private ManajemenPenimbanganBalita manajemenPenimbanganBalita;
    private ManajemenPenimbanganIbuHamil manajemenPenimbanganIbuHamil;

    public Posyandu() {
        this.manajemenBalita = new ManajemenBalita();
        this.manajemenIbuHamil = new ManajemenIbuHamil();
        this.manajemenKegiatan = new ManajemenKegiatan();
        this.manajemenPenimbanganBalita = new ManajemenPenimbanganBalita();
        this.manajemenPenimbanganIbuHamil = new ManajemenPenimbanganIbuHamil();
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

    public Kegiatan addKegiatan(String namaKegiatan, String tanggal, String waktu, String kader) {
        return manajemenKegiatan.addKegiatan(namaKegiatan, tanggal, waktu, kader);
    }

    public ArrayList<Kegiatan> getAllKegiatan() {
        return manajemenKegiatan.getAllKegiatan();
    }

    public Kegiatan getKegiatanById(int id) {
        return manajemenKegiatan.getKegiatanById(id);
    }

    public boolean updateKegiatan(int id, String namaKegiatan, String tanggal, String waktu, String kader) {
        return manajemenKegiatan.updateKegiatan(id, namaKegiatan, tanggal, waktu, kader);
    }

    public boolean deleteKegiatan(int id) {
        return manajemenKegiatan.deleteKegiatan(id);
    }

    public PenimbanganBalita addPenimbanganBalita(int idBalita, String tglTimbang, String statusGizi, double beratBadan, double tinggiBadan, double lingkarKepala) {
        return manajemenPenimbanganBalita.addPenimbanganBalita(idBalita, tglTimbang, statusGizi, beratBadan, tinggiBadan, lingkarKepala);
    }

    public ArrayList<PenimbanganBalita> getAllPenimbanganBalita() {
        return manajemenPenimbanganBalita.getAllPenimbanganBalita();
    }

    public PenimbanganBalita getPenimbanganBalitaById(int id) {
        return manajemenPenimbanganBalita.getPenimbanganBalitaById(id);
    }
    
    public boolean updatePenimbanganBalita(int id, String tglTimbang, String statusGizi, double beratBadan, double tinggiBadan, double lingkarKepala) {
        return manajemenPenimbanganBalita.updatePenimbanganBalita(id, tglTimbang, statusGizi, beratBadan, tinggiBadan, lingkarKepala);
    }

    public boolean deletePenimbanganBalita(int id) {
        return manajemenPenimbanganBalita.deletePenimbanganBalita(id);
    }

    public PenimbanganIbuHamil addPenimbanganIbuHamil(int idIbuHamil, String tglTimbang, String statusGizi, double beratBadan, double tinggiBadan, double lingkarLengan, int tekananDarah) {
        return manajemenPenimbanganIbuHamil.addPenimbanganIbuHamil(idIbuHamil, tglTimbang, statusGizi, beratBadan, tinggiBadan, lingkarLengan, tekananDarah);
    }

    public ArrayList<PenimbanganIbuHamil> getAllPenimbanganIbuHamil() {
        return manajemenPenimbanganIbuHamil.getAllPenimbanganIbuHamil();
    }

    public PenimbanganIbuHamil getPenimbanganIbuHamilById(int id) {
        return manajemenPenimbanganIbuHamil.getPenimbanganIbuHamilById(id);
    }

    public boolean updatePenimbanganIbuHamil(int id, String tglTimbang, String statusGizi, double beratBadan, double tinggiBadan, double lingkarLengan, int tekananDarah) {
        return manajemenPenimbanganIbuHamil.updatePenimbanganIbuHamil(id, tglTimbang, statusGizi, beratBadan, tinggiBadan, lingkarLengan, tekananDarah);
    }

    public boolean deletePenimbanganIbuHamil(int id) {
        return manajemenPenimbanganIbuHamil.deletePenimbanganIbuHamil(id);
    }
}