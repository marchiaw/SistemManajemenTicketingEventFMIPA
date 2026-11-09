package com.mycompany.manajemen_ticketing;

public class Panitia extends Pengguna {
    private String jabatanOrganisasi;

    public Panitia(String nama, String id, String jabatanOrganisasi) {
        super(nama, id);
        this.jabatanOrganisasi = jabatanOrganisasi;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Nama Panitia : " + getNama());
        System.out.println("ID Panitia   : " + getId());
        System.out.println("Jabatan      : " + jabatanOrganisasi);
    }
}