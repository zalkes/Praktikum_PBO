package menu;
import control.Posyandu;
import model.Balita;
import model.IbuHamil;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    private Scanner scanner;
    private Posyandu posyandu;

    public MainMenu() {
        this.scanner = new Scanner(System.in);
        this.posyandu = new Posyandu();
    }

    public void showMainMenu(){
        int pilihan;
        do {
            System.out.println("=================================");
            System.out.println("SELAMAT DATANG DI POSYANDU AKASIA");
            System.out.println("---------------------------------");
            System.out.println("            MAIN MENU");
            System.out.println("---------------------------------");
            System.out.println("[1] Manajemen Data Balita");
            System.out.println("[2] Manajemen Data Ibu Hamil");
            System.out.println("[3] Keluar");
            System.out.println("=================================");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    balitaMenu();
                    break;
                case 2:
                    ibuHamilMenu();
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan program ini");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (pilihan != 3);
    }

    private void balitaMenu() {
        int pilihan;
        do {
            System.out.println("=================================");
            System.out.println("      MANAJEMEN DATA BALITA");
            System.out.println("---------------------------------");
            System.out.println("[1] Tampilkan Data Balita");
            System.out.println("[2] Tambah Data Balita");
            System.out.println("[3] Update Data Balita");
            System.out.println("[4] Hapus Data Balita");
            System.out.println("[5] Kembali ke Menu Utama");
            System.out.println("===============================");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    showBalita();;
                    break;
                case 2:
                    addBalita();;
                    break;
                case 3:
                    updateBalita();;
                    break;
                case 4:
                    deleteBalita();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (pilihan != 5);
    }  
    
    private void showBalita(){
        System.out.println(String.format("%-10s | %-15s | %-13s | %-14s | %-17s | %-19s | %-20s", "ID", "Nama", "Tanggal Lahir", "Jenis Kelamin", "Nama Ibu", "Nama Ayah", "No. Telepon Orang Tua"));
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        ArrayList<Balita> balitaList = posyandu.getAllBalita();
        if (balitaList.isEmpty()) {
            System.out.println("Tidak ada data balita");
        } else {
            for (Balita balita : balitaList) {
                System.out.println(balita.toString());
            }
        }
    }

    private void addBalita(){
        System.out.println("=================================");
        System.out.println("       TAMBAH DATA BALITA");
        System.out.println("=================================");
        System.out.print("Nama Balita: ");
        String namaBalita = scanner.next();
        System.out.print("Tanggal Lahir (dd-mm-yyyy): ");
        String tglLahir = scanner.next();
        System.out.print("Jenis Kelamin (Laki-laki/Perempuan): ");
        String jenisKelamin = scanner.next();
        System.out.print("Nama Ibu: ");
        String namaIbu = scanner.next();
        System.out.print("Nama Ayah: ");
        String namaAyah = scanner.next();
        System.out.print("No. Telepon Orang Tua: ");
        String noTelpOrtu = scanner.next();
        posyandu.addBalita(namaBalita, tglLahir, jenisKelamin, namaIbu, namaAyah, noTelpOrtu);
        System.out.println("Data balita berhasil ditambahkan");
    }

    private void updateBalita(){
        System.out.println("=================================");
        System.out.println("       UPDATE DATA BALITA");
        System.out.println("=================================");
        System.out.print("Masukkan ID Balita yang akan diupdate: ");
        int id = scanner.nextInt();
        Balita balita = posyandu.getBalitaById(id);
        if (balita == null) {
            System.out.println("Data balita tidak ditemukan");
        } else {
            System.out.print("Nama Balita: ");
            String namaBalita = scanner.next();
            System.out.print("Tanggal Lahir (dd-mm-yyyy): ");
            String tglLahir = scanner.next();
            System.out.print("Jenis Kelamin (Laki-laki/Perempuan): ");
            String jenisKelamin = scanner.next();
            System.out.print("Nama Ibu: ");
            String namaIbu = scanner.next();
            System.out.print("Nama Ayah: ");
            String namaAyah = scanner.next();
            System.out.print("No. Telepon Orang Tua: ");
            String noTelpOrtu = scanner.next();
            posyandu.updateBalita(id, namaBalita, tglLahir, jenisKelamin, namaIbu, namaAyah, noTelpOrtu);
            System.out.println("Data balita berhasil diupdate");
        }
    }

    private void deleteBalita(){
        System.out.println("=================================");
        System.out.println("       HAPUS DATA BALITA");
        System.out.println("=================================");
        System.out.print("ID Balita yang akan dihapus: ");
        int id = scanner.nextInt();
        if (posyandu.deleteBalita(id)) {
            System.out.println("Data balita berhasil dihapus");
        } else {
            System.out.println("Data balita tidak ditemukan");
        }
    }

    private void ibuHamilMenu() {
        int pilihan;
        do {
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
            pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    showIbuHamil();
                    break;
                case 2:
                    addIbuHamil();
                    break;
                case 3:
                    updateIbuHamil();
                    break;
                case 4:
                    deleteIbuHamil();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (pilihan != 5);
    }

    private void showIbuHamil(){
        System.out.println(String.format("%-10s | %-15s | %-13s | %-18s | %-18s | %-10s | %-15s", "ID", "Nama", "Tanggal Lahir", "Alamat", "No. Telepon", "Usia Kehamilan", "Riwayat Kesehatan"));
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        ArrayList<IbuHamil> ibuHamilList = posyandu.getAllIbuHamil();
        if (ibuHamilList.isEmpty()) {
            System.out.println("Tidak ada data ibu hamil");
        } else {
            for (IbuHamil ibuHamil : ibuHamilList) {
                System.out.println(ibuHamil.toString());
            }
        }
    }

    private void addIbuHamil(){
        System.out.println("=================================");
        System.out.println("       TAMBAH DATA IBU HAMIL");
        System.out.println("=================================");
        System.out.print("Nama Ibu Hamil: ");
        String nama = scanner.next();
        System.out.print("Tanggal Lahir (dd-mm-yyyy): ");
        String tglLahir = scanner.next();
        System.out.print("Alamat: ");
        String alamat = scanner.next();
        System.out.print("No. Telepon: ");
        String noTelp = scanner.next();
        System.out.print("Usia Kehamilan (minggu): ");
        int usiaKehamilan = scanner.nextInt();
        System.out.print("Riwayat Kesehatan: ");
        String riwayatKesehatan = scanner.next();
        posyandu.addIbuHamil(nama, tglLahir, alamat, noTelp, usiaKehamilan, riwayatKesehatan);
        System.out.println("Data ibu hamil berhasil ditambahkan");
    }

    private void updateIbuHamil(){
        System.out.println("=================================");
        System.out.println("       UPDATE DATA IBU HAMIL");
        System.out.println("=================================");
        System.out.print("Masukkan ID Ibu Hamil yang akan diupdate: ");
        int id = scanner.nextInt();
        IbuHamil ibuHamil = posyandu.getIbuHamilById(id);
        if (ibuHamil == null) {
            System.out.println("Data ibu hamil tidak ditemukan");
        } else {
            System.out.print("Nama Ibu Hamil: ");
            String nama = scanner.next();
            System.out.print("Tanggal Lahir (dd-mm-yyyy): ");
            String tglLahir = scanner.next();
            System.out.print("Alamat: ");
            String alamat = scanner.next();
            System.out.print("No. Telepon: ");
            String noTelp = scanner.next();
            System.out.print("Usia Kehamilan (minggu): ");
            int usiaKehamilan = scanner.nextInt();
            System.out.print("Riwayat Kesehatan: ");
            String riwayatKesehatan = scanner.next();
            posyandu.updateIbuHamil(id, nama, tglLahir, alamat, noTelp, usiaKehamilan, riwayatKesehatan);
            System.out.println("Data ibu hamil berhasil diupdate");
        }
    }

    private void deleteIbuHamil(){
        System.out.println("=================================");
        System.out.println("       HAPUS DATA IBU HAMIL");
        System.out.println("=================================");
        System.out.print("ID Ibu Hamil yang akan dihapus: ");
        int id = scanner.nextInt();
        if (posyandu.deleteIbuHamil(id)) {
            System.out.println("Data ibu hamil berhasil dihapus");
        } else {
            System.out.println("Data ibu hamil tidak ditemukan");
        }
    }
}
