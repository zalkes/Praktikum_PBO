package com.posyandu.model;

public class PenimbanganIbuHamil extends Penimbangan {
    private int idIbuHamil, tekananDarah;
    private double lingkarLengan;

    public PenimbanganIbuHamil(int idTimbang, int idIbuHamil, String tglTimbang, String statusGizi, double beratBadan, double tinggiBadan, double lingkarLengan, int tekananDarah) {
        super(idTimbang, tglTimbang, statusGizi, beratBadan, tinggiBadan);
        this.idIbuHamil = idIbuHamil;
        this.lingkarLengan = lingkarLengan;
        this.tekananDarah = tekananDarah;
    }

    public int getIdIbuHamil() {
        return idIbuHamil;
    }

    public double getLingkarLengan() {
        return lingkarLengan;
    }

    public int getTekananDarah() {
        return tekananDarah;
    }

    public void setIdIbuHamil(int idIbuHamil) {
        this.idIbuHamil = idIbuHamil;
    }

    public void setLingkarLengan(double lingkarLengan) {
        this.lingkarLengan = lingkarLengan;
    }

    public void setTekananDarah(int tekananDarah){
        this.tekananDarah = tekananDarah;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-12s | %-15s | %-14s | %-14s | %-14s | %-14s | %-15s", idTimbang, idIbuHamil, tglTimbang, statusGizi, beratBadan, tinggiBadan, lingkarLengan, tekananDarah);
    }
}
