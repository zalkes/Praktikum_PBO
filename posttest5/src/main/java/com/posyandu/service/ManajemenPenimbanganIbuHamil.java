package com.posyandu.service;
import com.posyandu.model.PenimbanganIbuHamil;
import java.util.ArrayList;

public class ManajemenPenimbanganIbuHamil {
    private ArrayList<PenimbanganIbuHamil> penimbanganIbuHamilList;
    private int nextId;

    public ManajemenPenimbanganIbuHamil(){
        this.penimbanganIbuHamilList = new ArrayList<>();
        this.nextId = 1;
        addPenimbanganIbuHamil(1, "10-10-2023", "Baik", 60.0, 160.0, 25.0, 120);
    }

    public PenimbanganIbuHamil addPenimbanganIbuHamil(int idIbuHamil, String tglTimbang, String statusGizi, double beratBadan, double tinggiBadan, double lingkarLengan, int tekananDarah){
        PenimbanganIbuHamil penimbangan = new PenimbanganIbuHamil(nextId++, idIbuHamil, tglTimbang, statusGizi, beratBadan, tinggiBadan, lingkarLengan, tekananDarah);
        penimbanganIbuHamilList.add(penimbangan);
        return penimbangan;
    }

    public ArrayList<PenimbanganIbuHamil> getAllPenimbanganIbuHamil(){
        return new ArrayList<>(penimbanganIbuHamilList);
    }

    public PenimbanganIbuHamil getPenimbanganIbuHamilById(int id){
        for (PenimbanganIbuHamil penimbangan : penimbanganIbuHamilList){
            if (penimbangan.getTimbangId() == id){
                return penimbangan;
            }
        }
        return null;
    }

    public boolean updatePenimbanganIbuHamil(int id, String tglTimbang, String statusGizi, double beratBadan, double tinggiBadan, double lingkarLengan, int tekananDarah){
        for (PenimbanganIbuHamil penimbangan : penimbanganIbuHamilList){
            if (penimbangan.getTimbangId() == id){
                penimbangan.setTglTimbang(tglTimbang);
                penimbangan.setStatusGizi(statusGizi);
                penimbangan.setBeratBadan(beratBadan);
                penimbangan.setTinggiBadan(tinggiBadan);
                penimbangan.setLingkarLengan(lingkarLengan);
                penimbangan.setTekananDarah(tekananDarah);
                return true;
            }
        }
        return false;
    }

    public boolean deletePenimbanganIbuHamil(int id){
        for (PenimbanganIbuHamil penimbangan : penimbanganIbuHamilList){
            if (penimbangan.getTimbangId() == id){
                penimbanganIbuHamilList.remove(penimbangan);
                return true;
            }
        }
        return false;
    }
}
