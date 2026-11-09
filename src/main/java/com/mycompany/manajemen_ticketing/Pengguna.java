package com.mycompany.manajemen_ticketing;

public class Pengguna {
    // Atribut dasar pengguna
    private String nama;
    private String id; 

    public Pengguna(String nama, String id) {
        this.nama = nama;
        this.id = id;
    }

    // Getter untuk enkapsulasi
    public String getNama() { return nama; }
    public String getId() { return id; }

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama + " | ID: " + id);
    }
}