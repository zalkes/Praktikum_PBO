package com.posyandu.model;

public class Penimbangan {
    protected int idTimbang;
    protected String tglTimbang, statusGizi;
    protected double beratBadan, tinggiBadan;

    public Penimbangan (int idTimbang, String tglTimbang, String statusGizi, double beratBadan, double tinggiBadan) {
        this.idTimbang = idTimbang;
        this.tglTimbang = tglTimbang;
        this.statusGizi = statusGizi;
        this.beratBadan = beratBadan;
        this.tinggiBadan = tinggiBadan;
    } 

    public int getTimbangId(){
        return idTimbang;
    }

    public String getTglTimbang(){
        return tglTimbang;
    }

    public String getStatusGizi(){
        return statusGizi;
    }

    public double getBeratBadan(){
        return beratBadan;
    }

    public double getTinggiBadan(){
        return tinggiBadan;
    }

    public void setTglTimbang(String tglTimbang){
        this.tglTimbang = tglTimbang;
    }
    
    public void setStatusGizi(String statusGizi){
        this.statusGizi = statusGizi;
    }
    
    public void setBeratBadan(double beratBadan){
        this.beratBadan = beratBadan;
    }

    public void setTinggiBadan(double tinggiBadan){
        this.tinggiBadan = tinggiBadan;
    }
}