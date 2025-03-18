package service;
import model.IbuHamil;
import java.util.ArrayList;

public class ManajemenIbuHamil {
    private ArrayList<IbuHamil> ibuHamilList;
    private int nextId;

    public ManajemenIbuHamil() {
        this.ibuHamilList = new ArrayList<>();
        this.nextId = 1;

        addIbuHamil("Citra", "12-01-2000", "Jl.Merbabu", "081234567890", 5, "Sehat");
        addIbuHamil("Rahma", "05-04-2002", "Jl.Pasundan", "081234567891", 3, "Sehat");
    }

    public IbuHamil addIbuHamil(String nama, String tglLahir, String alamat, String noTelp, int usiaKehamilan, String riwayatKesehatan) {
        IbuHamil ibuHamil = new IbuHamil(nextId++, nama, tglLahir, alamat, noTelp, usiaKehamilan, riwayatKesehatan);
        ibuHamilList.add(ibuHamil);
        return ibuHamil;
    }

    public ArrayList<IbuHamil> getAllIbuHamil() {
        return new ArrayList<>(ibuHamilList);
    }

    public IbuHamil getIbuHamilById(int id) {
        for (IbuHamil ibuHamil : ibuHamilList) {
            if (ibuHamil.getIdIbuHamil() == id) {
                return ibuHamil;
            }
        }
        return null;
    }

    public boolean updateIbuHamil(int id, String nama, String tglLahir, String alamat, String noTelp, int usiaKehamilan, String riwayatKesehatan) {
        for (IbuHamil ibuHamil : ibuHamilList) {
            if (ibuHamil.getIdIbuHamil() == id) {
                ibuHamil.setNama(nama);
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
            if (ibuHamil.getIdIbuHamil() == id) {
            ibuHamilList.remove(ibuHamil);
            return true;
            }
        }
        return false;
    }
}