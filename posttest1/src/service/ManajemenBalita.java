package service;
import model.Balita;
import java.util.ArrayList;

public class ManajemenBalita {
    private ArrayList<Balita> balitaList;
    private int nextId;
    
    public ManajemenBalita() {
        this.balitaList = new ArrayList<>();
        this.nextId = 1;
        
        addBalita("Ryan", "12-01-2023", "Laki-laki", "Ani", "Budi", "081234567890");
        addBalita("Ronaldo", "05-04-2022", "Laki-laki", "Citra", "Dodi", "081234567891");
    }
    
    public Balita addBalita(String namaBalita, String tglLahir, String jenisKelamin, String namaIbu, String namaAyah, String noTelpOrtu) {
        Balita balita = new Balita(nextId++, namaBalita, tglLahir, jenisKelamin, namaIbu, namaAyah, noTelpOrtu);
        balitaList.add(balita);
        return balita;
    }
    
    public ArrayList<Balita> getAllBalita() {
        return new ArrayList<>(balitaList);
    }
    
    public Balita getBalitaById(int id) {
        for (Balita balita : balitaList) {
            if (balita.getId() == id) {
                return balita;
            }
        }
        return null;
    }
    
    public boolean updateBalita(int id, String namaBalita, String tglLahir, String jenisKelamin, String namaIbu, String namaAyah, String noTelpOrtu) {
        for (Balita balita : balitaList) {
            if (balita.getId() == id) {
                balita.setNama(namaBalita);
                balita.setTglLahir(tglLahir);
                balita.setJenisKelamin(jenisKelamin);
                balita.setNamaIbu(namaIbu);
                balita.setNamaAyah(namaAyah);
                balita.setNoTelpOrtu(noTelpOrtu);
                return true;
            }
        }
        return false;
    }
    
    public boolean deleteBalita(int id) {
        for (Balita balita : balitaList) {
            if (balita.getId() == id) {
            balitaList.remove(balita);
            return true;
            }
        }
        return false;
    }
}