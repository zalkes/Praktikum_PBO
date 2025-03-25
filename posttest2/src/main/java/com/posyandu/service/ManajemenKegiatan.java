package com.posyandu.service;
import com.posyandu.model.Kegiatan;
import java.util.ArrayList;

public class ManajemenKegiatan {
    private ArrayList<Kegiatan> kegiatanList;
    private int nextId;

    public ManajemenKegiatan() {
        this.kegiatanList = new ArrayList<>();
        this.nextId = 1;

        addKegiatan("Imunisasi", "12-01-2023", "08:00", "Ani");
    }

   public Kegiatan addKegiatan(String namaKegiatan, String tanggal, String waktu, String kader) {
        Kegiatan kegiatan = new Kegiatan(nextId++, namaKegiatan, tanggal, waktu, kader);
        kegiatanList.add(kegiatan);
        return kegiatan;
    }

    public ArrayList<Kegiatan> getAllKegiatan() {
        return kegiatanList;
    }

    public Kegiatan getKegiatanById(int id) {
        for (Kegiatan kegiatan : kegiatanList) {
            if (kegiatan.getIdKegiatan() == id) {
                return kegiatan;
            }
        }
        return null;
    }

    public boolean updateKegiatan(int id, String namaKegiatan, String tanggal, String waktu, String kader) {
        for (Kegiatan kegiatan : kegiatanList) {
            if (kegiatan.getIdKegiatan() == id) {
                kegiatan.setNamaKegiatan(namaKegiatan);
                kegiatan.setTanggal(tanggal);
                kegiatan.setWaktu(waktu);
                kegiatan.setKader(kader);
                return true;
            }
        }
        return false;
    }

    public boolean deleteKegiatan(int id) {
        for (Kegiatan kegiatan : kegiatanList) {
            if (kegiatan.getIdKegiatan() == id) {
                kegiatanList.remove(kegiatan);
                return true;
            }
        }
        return false;
    }
}