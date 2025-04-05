package com.posyandu.service;
import com.posyandu.model.IbuHamil;
import java.util.ArrayList;

public class ManajemenIbuHamil {
    private ArrayList<IbuHamil> ibuHamilList;
    private int nextId;

    public ManajemenIbuHamil() {
        this.ibuHamilList = new ArrayList<>();
        this.nextId = 1;

        addIbuHamil("Citra", "12-01-2000", "Jl.Merbabu", "081234567890", 5, "Tidak Ada");
        addIbuHamil("Rahma", "05-04-2002", "Jl.Pasundan", "081234567891", 3, "Tidak Ada");
    }

    public IbuHamil addIbuHamil(String namaIbuHamil, String tglLahir, String alamat, String noTelp, int usiaKehamilan, String riwayatKesehatan) {
        IbuHamil ibuHamil = new IbuHamil(nextId++, namaIbuHamil, tglLahir, alamat, noTelp, usiaKehamilan, riwayatKesehatan);
        ibuHamilList.add(ibuHamil);
        return ibuHamil;
    }

    public ArrayList<IbuHamil> getAllIbuHamil() {
        return new ArrayList<>(ibuHamilList);
    }

    public IbuHamil getIbuHamilById(int id) {
        for (IbuHamil ibuHamil : ibuHamilList) {
            if (ibuHamil.getId() == id) {
                return ibuHamil;
            }
        }
        return null;
    }

    public boolean updateIbuHamil(int id, String namaIbuHamil, String tglLahir, String alamat, String noTelp, int usiaKehamilan, String riwayatKesehatan) {
        for (IbuHamil ibuHamil : ibuHamilList) {
            if (ibuHamil.getId() == id) {
                ibuHamil.setNama(namaIbuHamil);
                ibuHamil.setTglLahir(tglLahir);
                ibuHamil.setAlamat(alamat);
                ibuHamil.setNoTelp(noTelp);
                ibuHamil.setUsiaKehamilan(usiaKehamilan);
                ibuHamil.setRiwayatKesehatan(riwayatKesehatan);
                return true;
            }
        }
        return false;
    }

    public boolean deleteIbuHamil(int id) {
        for (IbuHamil ibuHamil : ibuHamilList) {
            if (ibuHamil.getId() == id) {
            ibuHamilList.remove(ibuHamil);
            return true;
            }
        }
        return false;
    }
}