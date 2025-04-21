package com.posyandu.menu;

//Buat poin plus: penggunaan package Jcommander menggunakan Maven untuk validasi input
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

import com.posyandu.control.Posyandu;
import com.posyandu.model.Balita;
import com.posyandu.model.IbuHamil;
import com.posyandu.model.Kegiatan;
import com.posyandu.model.PenimbanganBalita;
import com.posyandu.model.PenimbanganIbuHamil;

import java.util.ArrayList;
import java.util.Scanner;

//Penggunaan access modifier public
public class MainMenu {
    //Penggunaan access modifier private
    private Scanner scanner;
    private Posyandu posyandu;

    public MainMenu() {
        this.scanner = new Scanner(System.in);
        this.posyandu = new Posyandu();
    }

    private static class IntegerInput {
        @Parameter(names = "-value", description = "Integer value", required = true)
        private Integer value;
    }

    private static class StringInput {
        @Parameter(names = "-value", description = "String value", required = true)
        private String value;
    }

    //Penggunaan access modifier default
    void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    void hold() {
        System.out.println("\n\nTekan enter untuk kembali");
        scanner.nextLine();
    }

    //Untuk penggunaan access modifier private ada di model balita, ibu hamil, dan kegiatan

    private int getIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                IntegerInput intCommand = new IntegerInput();
                JCommander.newBuilder()
                        .addObject(intCommand)
                        .build()
                        .parse("-value", input);
                return intCommand.value;
            } catch (ParameterException e) {
                System.out.print("Input harus berupa angka! Silakan masukkan kembali: ");
            }
        }
    }

    private String getStringInput() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.print("Input tidak boleh kosong! Silakan masukkan kembali: ");
                    continue;
                }
                StringInput stringCommand = new StringInput();
                JCommander.newBuilder()
                        .addObject(stringCommand)
                        .build()
                        .parse("-value", input);
                return stringCommand.value;
            } catch (ParameterException e) {
                System.out.print("Input tidak valid! Silakan masukkan kembali: ");
            }
        }
    }

    public void showMainMenu() {
        int pilihan;
        do {
            clearScreen();
            System.out.println("=========================================");
            System.out.println("     SELAMAT DATANG DI POSYANDU AKASIA");
            System.out.println("-----------------------------------------");
            System.out.println("                 MAIN MENU");
            System.out.println("-----------------------------------------");
            System.out.println("[1] Manajemen Data Balita");
            System.out.println("[2] Manajemen Data Ibu Hamil");
            System.out.println("[3] Manajemen Kegiatan");
            System.out.println("[4] Manajemen Data Penimbangan Balita");
            System.out.println("[5] Manajemen Data Penimbangan Ibu Hamil");
            System.out.println("[6] Keluar");
            System.out.println("=========================================");
            System.out.print("Pilih menu: ");
            pilihan = getIntInput();
            switch (pilihan) {
                case 1:
                    balitaMenu();
                    break;
                case 2:
                    ibuHamilMenu();
                    break;
                case 3:
                    kegiatanMenu();
                    break;
                case 4:
                    penimbanganBalitaMenu();
                    break;
                case 5:
                    penimbanganIbuHamilMenu();
                    break;
                case 6:
                    clearScreen();
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    hold();
            }
        } while (pilihan != 6);
    }

    private void balitaMenu() {
        int pilihan;
        do {
            clearScreen();
            System.out.println("=================================");
            System.out.println("      MANAJEMEN DATA BALITA");
            System.out.println("---------------------------------");
            System.out.println("[1] Tampilkan Data Balita");
            System.out.println("[2] Tambah Data Balita");
            System.out.println("[3] Update Data Balita");
            System.out.println("[4] Hapus Data Balita");
            System.out.println("[5] Kembali ke Menu Utama");
            System.out.println("=================================");
            System.out.print("Pilih menu: ");
            pilihan = getIntInput();
            switch (pilihan) {
                case 1:
                    clearScreen();
                    showBalita();
                    showBalita(jumlahBalita);
                    hold();
                    break;
                case 2:
                    clearScreen();
                    addBalita();
                    hold();
                    break;
                case 3:
                    clearScreen();
                    showBalita();
                    updateBalita();
                    hold();
                    break;
                case 4:
                    clearScreen();
                    showBalita();
                    deleteBalita();
                    hold();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (pilihan != 5);
    }

    int jumlahBalita = 0;
    private void showBalita(){
        ArrayList<Balita> balitaList = posyandu.getAllBalita();
        if (balitaList.isEmpty()) {
            System.out.println("Tidak ada data balita");
        } else {
            System.out.println(String.format("%-10s | %-15s | %-13s | %-14s | %-17s | %-19s | %-20s", "ID", "Nama", "Tanggal Lahir", "Jenis Kelamin", "Nama Ibu", "Nama Ayah", "No. Telepon Orang Tua"));
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            for (Balita balita : balitaList) {
                jumlahBalita++;
                System.out.println(balita.toString());
            }
        }
    }

    //Method overloading 
    private void showBalita(int jumlahBaris) {
        ArrayList<Balita> balitaList = posyandu.getAllBalita();
        System.out.println("\nJumlah Balita Terdaftar: " + balitaList.size());
    }

    private void addBalita() {
        System.out.println("=================================");
        System.out.println("       TAMBAH DATA BALITA");
        System.out.println("=================================");
        
        System.out.print("Nama Balita: ");
        String namaBalita = getStringInput();
        
        System.out.print("Tanggal Lahir (dd-mm-yyyy): ");
        String tglLahir = getStringInput();
        
        System.out.print("Jenis Kelamin (Laki-laki/Perempuan): ");
        String jenisKelamin = getStringInput();
        
        System.out.print("Nama Ibu: ");
        String namaIbu = getStringInput();
        
        System.out.print("Nama Ayah: ");
        String namaAyah = getStringInput();
        
        System.out.print("No. Telepon Orang Tua: ");
        String noTelpOrtu = getStringInput();
        
        posyandu.addBalita(namaBalita, tglLahir, jenisKelamin, namaIbu, namaAyah, noTelpOrtu);
        System.out.println("Data balita berhasil ditambahkan");
    }

    private void updateBalita() {
        if (posyandu.getAllBalita().isEmpty()) {
            return;
        }
        System.out.println("=================================");
        System.out.println("       UPDATE DATA BALITA");
        System.out.println("=================================");
        
        System.out.print("Masukkan ID Balita yang akan diupdate: ");
        int id = getIntInput();
        
        Balita balita = posyandu.getBalitaById(id);
        if (balita == null) {
            System.out.println("Data balita tidak ditemukan");
        } else {
            System.out.print("Nama Balita: ");
            String namaBalita = getStringInput();
            
            System.out.print("Tanggal Lahir (dd-mm-yyyy): ");
            String tglLahir = getStringInput();
            
            System.out.print("Jenis Kelamin (Laki-laki/Perempuan): ");
            String jenisKelamin = getStringInput();
            
            System.out.print("Nama Ibu: ");
            String namaIbu = getStringInput();
            
            System.out.print("Nama Ayah: ");
            String namaAyah = getStringInput();
            
            System.out.print("No. Telepon Orang Tua: ");
            String noTelpOrtu = getStringInput();
            
            posyandu.updateBalita(id, namaBalita, tglLahir, jenisKelamin, namaIbu, namaAyah, noTelpOrtu);
            System.out.println("Data balita berhasil diupdate");
        }
    }

    private void deleteBalita() {
        if (posyandu.getAllBalita().isEmpty()) {
            return;
        }
        System.out.println("=================================");
        System.out.println("       HAPUS DATA BALITA");
        System.out.println("=================================");
        
        System.out.print("ID Balita yang akan dihapus: ");
        int id = getIntInput();
        
        if (posyandu.deleteBalita(id)) {
            System.out.println("Data balita berhasil dihapus");
        } else {
            System.out.println("Data balita tidak ditemukan");
        }
    }

    private void ibuHamilMenu() {
        int pilihan;
        do {
            clearScreen();
            System.out.println("=================================");
            System.out.println("      MANAJEMEN DATA IBU HAMIL");
            System.out.println("---------------------------------");
            System.out.println("[1] Tampilkan Data Ibu Hamil");
            System.out.println("[2] Tambah Data Ibu Hamil");
            System.out.println("[3] Update Data Ibu Hamil");
            System.out.println("[4] Hapus Data Ibu Hamil");
            System.out.println("[5] Kembali ke Menu Utama");
            System.out.println("===============================");
            System.out.print("Pilih menu: ");
            pilihan = getIntInput();
            switch (pilihan) {
                case 1:
                    clearScreen();
                    showIbuHamil();
                    showIbuHamil(jumlahIbuHamil);
                    hold();
                    break;
                case 2:
                    clearScreen();
                    addIbuHamil();
                    hold();
                    break;
                case 3:
                    clearScreen();
                    showIbuHamil();
                    updateIbuHamil();
                    hold();
                    break;
                case 4:
                    clearScreen();
                    showIbuHamil();
                    deleteIbuHamil();
                    hold();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    hold();
            }
        } while (pilihan != 5);
    }

    int jumlahIbuHamil = 0;
    private void showIbuHamil(){
        ArrayList<IbuHamil> ibuHamilList = posyandu.getAllIbuHamil();
        if (ibuHamilList.isEmpty()) {
            System.out.println("Tidak ada data ibu hamil");
        } else {
            System.out.println(String.format("%-10s | %-15s | %-13s | %-18s | %-18s | %-10s | %-15s", "ID", "Nama", "Tanggal Lahir", "Alamat", "No. Telepon", "Usia Kehamilan", "Riwayat Kesehatan"));
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            for (IbuHamil ibuHamil : ibuHamilList) {
                System.out.println(ibuHamil.toString());
                jumlahIbuHamil++;
            }
        }
    }

    //Method overloading
    private void showIbuHamil(int jumlahIbuHamil) {
        ArrayList<IbuHamil> ibuHamilList = posyandu.getAllIbuHamil();
        System.out.println("\nJumlah Ibu Hamil Terdaftar: " + ibuHamilList.size());
    }

    private void addIbuHamil() {
        System.out.println("=================================");
        System.out.println("       TAMBAH DATA IBU HAMIL");
        System.out.println("=================================");
        
        System.out.print("Nama Ibu Hamil: ");
        String namaIbuHamil = getStringInput();
        
        System.out.print("Tanggal Lahir (dd-mm-yyyy): ");
        String tglLahir = getStringInput();
        
        System.out.print("Alamat: ");
        String alamat = getStringInput();
        
        System.out.print("No. Telepon: ");
        String noTelp = getStringInput();
        
        System.out.print("Usia Kehamilan (minggu): ");
        int usiaKehamilan = getIntInput();
        
        System.out.print("Riwayat Kesehatan: ");
        String riwayatKesehatan = getStringInput();
        
        posyandu.addIbuHamil(namaIbuHamil, tglLahir, alamat, noTelp, usiaKehamilan, riwayatKesehatan);
        System.out.println("Data ibu hamil berhasil ditambahkan");
    }

    private void updateIbuHamil() {
        if (posyandu.getAllIbuHamil().isEmpty()) {
            return;
        }
        System.out.println("=================================");
        System.out.println("       UPDATE DATA IBU HAMIL");
        System.out.println("=================================");
        
        System.out.print("Masukkan ID Ibu Hamil yang akan diupdate: ");
        int id = getIntInput();
        
        IbuHamil ibuHamil = posyandu.getIbuHamilById(id);
        if (ibuHamil == null) {
            System.out.println("Data ibu hamil tidak ditemukan");
        } else {
            System.out.print("Nama Ibu Hamil: ");
            String nama = getStringInput();
            
            System.out.print("Tanggal Lahir (dd-mm-yyyy): ");
            String tglLahir = getStringInput();
            
            System.out.print("Alamat: ");
            String alamat = getStringInput();
            
            System.out.print("No. Telepon: ");
            String noTelp = getStringInput();
            
            System.out.print("Usia Kehamilan (minggu): ");
            int usiaKehamilan = getIntInput();
            
            System.out.print("Riwayat Kesehatan: ");
            String riwayatKesehatan = getStringInput();
            
            posyandu.updateIbuHamil(id, nama, tglLahir, alamat, noTelp, usiaKehamilan, riwayatKesehatan);
            System.out.println("Data ibu hamil berhasil diupdate");
        }
    }

    private void deleteIbuHamil() {
        if (posyandu.getAllIbuHamil().isEmpty()) {
            return;
        }
        System.out.println("=================================");
        System.out.println("       HAPUS DATA IBU HAMIL");
        System.out.println("=================================");
        
        System.out.print("ID Ibu Hamil yang akan dihapus: ");
        int id = getIntInput();
        
        if (posyandu.deleteIbuHamil(id)) {
            System.out.println("Data ibu hamil berhasil dihapus");
        } else {
            System.out.println("Data ibu hamil tidak ditemukan");
        }
    }

    private void kegiatanMenu() {
        int pilihan;
        do {
            clearScreen();
            System.out.println("=================================");
            System.out.println("       MANAJEMEN KEGIATAN");
            System.out.println("---------------------------------");
            System.out.println("[1] Tampilkan Data Kegiatan");
            System.out.println("[2] Tambah Data Kegiatan");
            System.out.println("[3] Update Data Kegiatan");
            System.out.println("[4] Hapus Data Kegiatan");
            System.out.println("[5] Kembali ke Menu Utama");
            System.out.println("=================================");
            System.out.print("Pilih menu: ");
            pilihan = getIntInput();
            switch (pilihan) {
                case 1:
                    clearScreen();
                    showKegiatan();
                    hold();
                    break;
                case 2:
                    clearScreen();
                    addKegiatan();
                    hold();
                    break;
                case 3:
                    clearScreen();
                    showKegiatan();
                    updateKegiatan();
                    hold();
                    break;
                case 4:
                    clearScreen();
                    showKegiatan();
                    deleteKegiatan();
                    hold();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    hold();
            }
        } while (pilihan != 5);
    }
    
    private void showKegiatan(){
        ArrayList<Kegiatan> kegiatanList = posyandu.getAllKegiatan();
        if (kegiatanList.isEmpty()) {
            System.out.println("Tidak ada data kegiatan");
        } else {
            System.out.println(String.format("%-5s | %-20s | %-10s | %-10s | %-15s", "ID", "Nama Kegiatan", "Tanggal", "Waktu", "Kader Bertugas"));
            System.out.println("---------------------------------------------------------------------------------------------");
            for (Kegiatan kegiatan : kegiatanList) {
                System.out.println(kegiatan.toString());
            }
        }
    }

    private void addKegiatan() {
        System.out.println("=================================");
        System.out.println("       TAMBAH DATA KEGIATAN");
        System.out.println("=================================");
        
        System.out.print("Nama Kegiatan: ");
        String namaKegiatan = getStringInput();
        
        System.out.print("Tanggal (dd-mm-yyyy): ");
        String tanggal = getStringInput();
        
        System.out.print("Waktu: ");
        String waktu = getStringInput();
        
        System.out.print("Kader Bertugas: ");
        String kader = getStringInput();
        
        posyandu.addKegiatan(namaKegiatan, tanggal, waktu, kader);
        System.out.println("Data kegiatan berhasil ditambahkan");
    }

    private void updateKegiatan() {
        if (posyandu.getAllKegiatan().isEmpty()) {
            return;
        }
        System.out.println("=================================");
        System.out.println("       UPDATE DATA KEGIATAN");
        System.out.println("=================================");
        
        System.out.print("Masukkan ID Kegiatan yang akan diupdate: ");
        int id = getIntInput();
        
        Kegiatan kegiatan = posyandu.getKegiatanById(id);
        if (kegiatan == null) {
            System.out.println("Data kegiatan tidak ditemukan");
        } else {
            System.out.print("Nama Kegiatan: ");
            String namaKegiatan = getStringInput();
            
            System.out.print("Tanggal (dd-mm-yyyy): ");
            String tanggal = getStringInput();
            
            System.out.print("Waktu: ");
            String waktu = getStringInput();
            
            System.out.print("Kader: ");
            String kader = getStringInput();
            
            posyandu.updateKegiatan(id, namaKegiatan, tanggal, waktu, kader);
            System.out.println("Data kegiatan berhasil diupdate");
        }
    }

    private void deleteKegiatan() {
        if (posyandu.getAllKegiatan().isEmpty()) {
            return;
        }
        System.out.println("=================================");
        System.out.println("       HAPUS DATA KEGIATAN");
        System.out.println("=================================");
        
        System.out.print("ID Kegiatan yang akan dihapus: ");
        int id = getIntInput();
        
        if (posyandu.deleteKegiatan(id)) {
            System.out.println("Data kegiatan berhasil dihapus");
        } else {
            System.out.println("Data kegiatan tidak ditemukan");
        }
    }

    private void penimbanganBalitaMenu() {
       int pilihan;
        do {
            clearScreen();
            System.out.println("=====================================");
            System.out.println("  MANAJEMEN DATA PENIMBANGAN BALITA");
            System.out.println("-------------------------------------");
            System.out.println("[1] Tampilkan Data Penimbangan Balita");
            System.out.println("[2] Tambah Data Penimbangan Balita");
            System.out.println("[3] Update Data Penimbangan Balita");
            System.out.println("[4] Hapus Data Penimbangan Balita");
            System.out.println("[5] Kembali ke Menu Utama");
            System.out.println("=====================================");
            System.out.print("Pilih menu: ");
            pilihan = getIntInput();
            switch (pilihan) {
                case 1:
                    clearScreen();
                    showPenimbanganBalita();
                    hold();
                    break;
                case 2:
                    clearScreen();
                    showBalita();
                    addPenimbanganBalita();
                    hold();
                    break;
                case 3:
                    clearScreen();
                    showPenimbanganBalita();
                    updatePenimbanganBalita();
                    hold();
                    break;
                case 4:
                    clearScreen();
                    showPenimbanganBalita();
                    deletePenimbanganBalita();
                    hold();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    hold();
            }
        } while (pilihan != 5);
    }

    private void showPenimbanganBalita(){
        ArrayList<PenimbanganBalita> penimbanganBalitaList = posyandu.getAllPenimbanganBalita();
        if (penimbanganBalitaList.isEmpty()) {
            System.out.println("Tidak ada data penimbangan balita");
        } else {
            System.out.println(String.format("%-5s | %-5s | %-15s | %-14s | %-17s | %-19s | %-15s" , "ID Timbang", "ID Balita", "Tanggal Timbang", "Status Gizi", "Berat Badan", "Tinggi Badan", "Lingkar Kepala"));
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            for (PenimbanganBalita penimbangan : penimbanganBalitaList) {
                System.out.println(penimbangan.toString());
            }
        }
    }

    private void addPenimbanganBalita() {
        System.out.println("=================================");
        System.out.println("  TAMBAH DATA PENIMBANGAN BALITA");
        System.out.println("=================================");
        int idBalita;
        do {
            System.out.print("ID Balita: ");
            idBalita = getIntInput();
            if (posyandu.getBalitaById(idBalita) == null) {
                System.out.println("ID Balita tidak ditemukan. Silakan coba lagi.");
            } else {
                break;
            }
        } while (true);
        
        System.out.print("Tanggal (dd-mm-yyyy): ");
        String tglTimbang = getStringInput();
        
        System.out.print("Status Gizi: ");
        String statusGizi = getStringInput();
        
        System.out.print("Berat Badan (kg): ");
        double beratBadan = getIntInput();
        
        System.out.print("Tinggi Badan (cm): ");
        double tinggiBadan = getIntInput();
        
        System.out.print("Lingkar Kepala (cm): ");
        double lingkarKepala = getIntInput();
        
        posyandu.addPenimbanganBalita(idBalita, tglTimbang, statusGizi, beratBadan, tinggiBadan, lingkarKepala);
        System.out.println("Data penimbangan balita berhasil ditambahkan");
    }

    private void updatePenimbanganBalita() {
        if (posyandu.getAllPenimbanganBalita().isEmpty()) {
            return;
        }
        System.out.println("=================================");
        System.out.println("  UPDATE DATA PENIMBANGAN BALITA");
        System.out.println("=================================");
        
        System.out.print("Masukkan ID Penimbangan Balita yang akan diupdate: ");
        int id = getIntInput();
        
        PenimbanganBalita penimbangan = posyandu.getPenimbanganBalitaById(id);
        if (penimbangan == null) {
            System.out.println("Data penimbangan balita tidak ditemukan");
        } else {        
            System.out.print("Tanggal (dd-mm-yyyy): ");
            String tglTimbang = getStringInput();
            
            System.out.print("Status Gizi: ");
            String statusGizi = getStringInput();
            
            System.out.print("Berat Badan (kg): ");
            double beratBadan = getIntInput();
            
            System.out.print("Tinggi Badan (cm): ");
            double tinggiBadan = getIntInput();
            
            System.out.print("Lingkar Kepala (cm): ");
            double lingkarKepala = getIntInput();
            
            posyandu.updatePenimbanganBalita(id, tglTimbang, statusGizi, beratBadan, tinggiBadan, lingkarKepala);
            System.out.println("Data penimbangan balita berhasil diupdate");
        }
    }

    private void deletePenimbanganBalita() {
        if (posyandu.getAllPenimbanganBalita().isEmpty()) {
            return;
        }
        System.out.println("=================================");
        System.out.println("  HAPUS DATA PENIMBANGAN BALITA");
        System.out.println("=================================");
        
        System.out.print("ID Penimbangan Balita yang akan dihapus: ");
        int id = getIntInput();
        
        if (posyandu.deletePenimbanganBalita(id)) {
            System.out.println("Data penimbangan balita berhasil dihapus");
        } else {
            System.out.println("Data penimbangan balita tidak ditemukan");
        }
    }

    private void penimbanganIbuHamilMenu() {
        int pilihan;
        do {
            clearScreen();
            System.out.println("======================================");
            System.out.println(" MANAJEMEN DATA PENIMBANGAN IBU HAMIL");
            System.out.println("--------------------------------------");
            System.out.println("[1] Tampilkan Data Penimbangan Ibu Hamil");
            System.out.println("[2] Tambah Data Penimbangan Ibu Hamil");
            System.out.println("[3] Update Data Penimbangan Ibu Hamil");
            System.out.println("[4] Hapus Data Penimbangan Ibu Hamil");
            System.out.println("[5] Kembali ke Menu Utama");
            System.out.println("======================================");
            System.out.print("Pilih menu: ");
            pilihan = getIntInput();
            switch (pilihan) {
                case 1:
                    clearScreen();
                    showPenimbanganIbuHamil();
                    hold();
                    break;
                case 2:
                    clearScreen();
                    showIbuHamil();
                    addPenimbanganIbuHamil();
                    hold();
                    break;
                case 3:
                    clearScreen();
                    showPenimbanganIbuHamil();
                    updatePenimbanganIbuHamil();
                    hold();
                    break;
                case 4:
                    clearScreen();
                    showPenimbanganIbuHamil();
                    deletePenimbanganIbuHamil();
                    hold();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    hold();
            }
        } while (pilihan != 5);
    }

    private void showPenimbanganIbuHamil(){
        ArrayList<PenimbanganIbuHamil> penimbanganIbuHamilList = posyandu.getAllPenimbanganIbuHamil();
        if (penimbanganIbuHamilList.isEmpty()) {
            System.out.println("Tidak ada data penimbangan ibu hamil");
        } else {
            System.out.println(String.format("%-10s | %-11s | %-15s | %-14s | %-14s | %-14s | %-14s | %-15s", "ID Timbang", "ID Ibu Hamil", "Tanggal Timbang", "Status Gizi", "Berat Badan", "Tinggi Badan", "Lingkar Lengan", "Tekanan Darah"));
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
            for (PenimbanganIbuHamil penimbangan : penimbanganIbuHamilList) {
                System.out.println(penimbangan.toString());
            }
        }
    }

    private void addPenimbanganIbuHamil() {
        System.out.println("=================================");
        System.out.println("  TAMBAH DATA PENIMBANGAN IBU HAMIL");
        System.out.println("=================================");
        int idIbuHamil;
        do {
            System.out.print("ID Ibu Hamil: ");
            idIbuHamil = getIntInput();
            if (posyandu.getIbuHamilById(idIbuHamil) == null) {
                System.out.println("ID Ibu Hamil tidak ditemukan. Silakan coba lagi.");
            } else {
                break;
            }
        } while (true);
        
        System.out.print("Tanggal (dd-mm-yyyy): ");
        String tglTimbang = getStringInput();
        
        System.out.print("Status Gizi: ");
        String statusGizi = getStringInput();
        
        System.out.print("Berat Badan (kg): ");
        double beratBadan = getIntInput();
        
        System.out.print("Tinggi Badan (cm): ");
        double tinggiBadan = getIntInput();
        
        System.out.print("Lingkar Lengan (cm): ");
        double lingkarLengan = getIntInput();
        
        System.out.print("Tekanan Darah: ");
        int tekananDarah = getIntInput();
        
        posyandu.addPenimbanganIbuHamil(idIbuHamil, tglTimbang, statusGizi, beratBadan, tinggiBadan, lingkarLengan, tekananDarah);
        System.out.println("Data penimbangan ibu hamil berhasil ditambahkan");
    }

    private void updatePenimbanganIbuHamil() {
        if (posyandu.getAllPenimbanganIbuHamil().isEmpty()) {
            return;
        }
        System.out.println("=================================");
        System.out.println("  UPDATE DATA PENIMBANGAN IBU HAMIL");
        System.out.println("=================================");
        
        System.out.print("Masukkan ID Penimbangan Ibu Hamil yang akan diupdate: ");
        int id = getIntInput();
        
        PenimbanganIbuHamil penimbangan = posyandu.getPenimbanganIbuHamilById(id);
        if (penimbangan == null) {
            System.out.println("Data penimbangan ibu hamil tidak ditemukan");
        } else {
            System.out.print("Tanggal (dd-mm-yyyy): ");
            String tglTimbang = getStringInput();
            
            System.out.print("Status Gizi: ");
            String statusGizi = getStringInput();
            
            System.out.print("Berat Badan (kg): ");
            double beratBadan = getIntInput();
            
            System.out.print("Tinggi Badan (cm): ");
            double tinggiBadan = getIntInput();
            
            System.out.print("Lingkar Lengan (cm): ");
            double lingkarLengan = getIntInput();
            
            System.out.print("Tekanan Darah: ");
            int tekananDarah = getIntInput();
            
            posyandu.updatePenimbanganIbuHamil(id, tglTimbang, statusGizi, beratBadan, tinggiBadan, lingkarLengan, tekananDarah);
            System.out.println("Data penimbangan ibu hamil berhasil diupdate");
        }
    }

    private void deletePenimbanganIbuHamil() {
        if (posyandu.getAllPenimbanganIbuHamil().isEmpty()) {
            return;
        }
        System.out.println("=================================");
        System.out.println("  HAPUS DATA PENIMBANGAN IBU HAMIL");
        System.out.println("=================================");
        
        System.out.print("ID Penimbangan Ibu Hamil yang akan dihapus: ");
        int id = getIntInput();
        
        if (posyandu.deletePenimbanganIbuHamil(id)) {
            System.out.println("Data penimbangan ibu hamil berhasil dihapus");
        } else {
            System.out.println("Data penimbangan ibu hamil tidak ditemukan");
        }
    }
}