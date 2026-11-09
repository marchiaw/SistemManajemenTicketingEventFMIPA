package com.mycompany.manajemen_ticketing;

// Inheritance: Mahasiswa mewarisi Pengguna
import java.util.ArrayList;

public class Mahasiswa extends Pengguna {
    private String programStudi;
    private ArrayList<String> tiketSaya; 

    public Mahasiswa(String nama, String id, String programStudi) {
        super(nama, id);
        this.programStudi = programStudi;
        this.tiketSaya = new ArrayList<>(); 
    }

    public String getProgramStudi() { return programStudi; }

    public void tambahTiket(String namaAcara) {
        tiketSaya.add(namaAcara);
    }

    public void lihatTiketSaya() {
        System.out.println("\n=== TIKET SAYA ===");
        if (tiketSaya.isEmpty()) {
            System.out.println("Anda belum mendaftar acara apa pun.");
        } else {
            for (int i = 0; i < tiketSaya.size(); i++) {
                System.out.println((i + 1) + ". " + tiketSaya.get(i));
            }
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Nama Mahasiswa : " + getNama());
        System.out.println("NPM            : " + getId());
        System.out.println("Program Studi  : " + programStudi);
    }
}

//tes