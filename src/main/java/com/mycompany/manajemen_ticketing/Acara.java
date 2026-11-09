package com.mycompany.manajemen_ticketing;

import java.util.ArrayList;

public class Acara {
    private String namaAcara;
    private String ruangan;
    private int kuotaMax;
    private ArrayList<Mahasiswa> daftarPeserta; 

    public Acara(String namaAcara, String ruangan, int kuotaMax) {
        this.namaAcara = namaAcara;
        this.ruangan = ruangan;
        this.kuotaMax = kuotaMax;
        this.daftarPeserta = new ArrayList<>(); 
    }

    public String getNamaAcara() { return namaAcara; }
    public String getRuangan() { return ruangan; }
    public int getSisaKuota() { return kuotaMax - daftarPeserta.size(); }

    public void daftar(Mahasiswa mhs) {
        // Validasi ketersediaan kuota
        if (daftarPeserta.size() >= kuotaMax) {
            System.out.println(">> GAGAL! Kuota acara sudah penuh.");
            return;
        }

        // Validasi duplikasi pendaftar berdasarkan NPM
        for (Mahasiswa peserta : daftarPeserta) {
            if (peserta.getId().equals(mhs.getId())) {
                System.out.println(">> DITOLAK! Anda (NPM: " + mhs.getId() + ") sudah terdaftar di acara ini.");
                return;
            }
        }

        // Proses pendaftaran berhasil
        daftarPeserta.add(mhs);
        mhs.tambahTiket(this.namaAcara); 
        System.out.println(">> BERHASIL! Tiket Anda telah diterbitkan.");
    }

    public void lihatDaftarPeserta() {
        System.out.println("\n=== DAFTAR PESERTA " + namaAcara.toUpperCase() + " ===");
        if (daftarPeserta.isEmpty()) {
            System.out.println("Belum ada pendaftar.");
        } else {
            for (int i = 0; i < daftarPeserta.size(); i++) {
                Mahasiswa m = daftarPeserta.get(i);
                System.out.println((i + 1) + ". " + m.getNama() + " (" + m.getId() + ") - " + m.getProgramStudi());
            }
        }
        System.out.println("Total Pendaftar: " + daftarPeserta.size() + "/" + kuotaMax);
    }
}

//tes