package com.posyandu.model;

public class PenimbanganBalita extends Penimbangan {
    private int idBalita;
    private double lingkarKepala;

    public PenimbanganBalita(int idTimbang, int idBalita, String tglTimbang, String statusGizi, double beratBadan, double tinggiBadan, double lingkarKepala) {
        super(idTimbang, tglTimbang, statusGizi, beratBadan, tinggiBadan);
        this.idBalita = idBalita;
        this.lingkarKepala = lingkarKepala;
    }

    public int getIdBalita() {
        return idBalita;
    }

    public double getlingkarKepala() {
        return lingkarKepala;
    }

    public void setIdBalita(int idBalita) {
        this.idBalita = idBalita;
    }
    
    public void setlingkarKepala(double lingkarKepala) {
        this.lingkarKepala = lingkarKepala;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-9s | %-15s | %-14s | %-17s | %-19s | %-15s", idTimbang, idBalita, tglTimbang, statusGizi, beratBadan, tinggiBadan, lingkarKepala);
    }
}