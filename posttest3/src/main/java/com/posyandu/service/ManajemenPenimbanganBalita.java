package com.posyandu.service;
import com.posyandu.model.PenimbanganBalita;
import java.util.ArrayList;

public class ManajemenPenimbanganBalita {
    private ArrayList<PenimbanganBalita> penimbanganBalitaList;
    private int nextId;

    public ManajemenPenimbanganBalita() {
        this.penimbanganBalitaList = new ArrayList<>();
        this.nextId = 1;

        addPenimbanganBalita(1, "10-10-2023", "Baik", 10.5, 80.0, 45.0);
    }

    public PenimbanganBalita addPenimbanganBalita(int idBalita, String tglTimbang, String statusGizi, double beratBadan, double tinggiBadan, double lingkarKepala) {
        PenimbanganBalita penimbangan = new PenimbanganBalita(nextId++, idBalita, tglTimbang, statusGizi, beratBadan, tinggiBadan, lingkarKepala);
        penimbanganBalitaList.add(penimbangan);
        return penimbangan;
    }

    public ArrayList<PenimbanganBalita> getAllPenimbanganBalita() {
        return new ArrayList<>(penimbanganBalitaList);
    }

    public PenimbanganBalita getPenimbanganBalitaById(int id) {
        for (PenimbanganBalita penimbangan : penimbanganBalitaList) {
            if (penimbangan.getTimbangId() == id) {
                return penimbangan;
            }
        }
        return null;
    }

    public boolean updatePenimbanganBalita(int id, String tglTimbang, String statusGizi, double beratBadan, double tinggiBadan, double lingkarKepala) {
        for (PenimbanganBalita penimbangan : penimbanganBalitaList) {
            if (penimbangan.getTimbangId() == id) {
                penimbangan.setTglTimbang(tglTimbang);
                penimbangan.setStatusGizi(statusGizi);
                penimbangan.setBeratBadan(beratBadan);
                penimbangan.setTinggiBadan(tinggiBadan);
                penimbangan.setlingkarKepala(lingkarKepala);
                return true;
            }
        }
        return false;
    }

    public boolean deletePenimbanganBalita(int id) {
        for (PenimbanganBalita penimbangan : penimbanganBalitaList) {
            if (penimbangan.getTimbangId() == id) {
                penimbanganBalitaList.remove(penimbangan);
                return true;
            }
        }
        return false;
    }
}