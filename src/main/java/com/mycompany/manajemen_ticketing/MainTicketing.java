package com.mycompany.manajemen_ticketing;

import java.util.ArrayList;
import java.util.Scanner;

public class MainTicketing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Penyimpanan data sementara selama program berjalan
        ArrayList<Acara> daftarAcara = new ArrayList<>();
        Panitia panitia1 = new Panitia("Putra", "12345", "Admin Pusat FMIPA");
        
        // Menambahkan satu acara default agar list tidak kosong
        daftarAcara.add(new Acara("Seminar Web3 & Blockchain", "Aula FMIPA", 2));
        
        int role;
        do {
            System.out.println("\n==================================");
            System.out.println("SISTEM TICKETING FMIPA UNILA");
            System.out.println("==================================");
            System.out.println("Masuk sebagai:");
            System.out.println("1. Mahasiswa (Peserta)");
            System.out.println("2. Panitia (Admin)");
            System.out.println("3. Matikan Sistem");
            System.out.print("Pilih (1-3): ");
            role = input.nextInt();
            input.nextLine(); // Membersihkan sisa baris baru (newline) dari nextInt
            
            if (role == 1) {
                // Alur pendaftaran mahasiswa dipindah ke dalam menu role
                System.out.println("\n--- REGISTRASI MAHASISWA ---");
                System.out.print("Masukkan Nama Anda : ");
                String nama = input.nextLine();
                System.out.print("Masukkan NPM Anda  : ");
                String npm = input.nextLine();
                System.out.print("Masukkan Prodi     : ");
                String prodi = input.nextLine();
                
                Mahasiswa mhs1 = new Mahasiswa(nama, npm, prodi);
                
                int menuMhs;
                do {
                    System.out.println("\n--- DASHBOARD MAHASISWA ---");
                    System.out.println("1. Lihat Acara & Daftar");
                    System.out.println("2. Lihat Tiket Saya");
                    System.out.println("3. Profil Saya");
                    System.out.println("4. Logout");
                    System.out.print("Pilih: ");
                    menuMhs = input.nextInt();
                    
                    if (menuMhs == 1) {
                        System.out.println("\n[DAFTAR ACARA TERSEDIA]");
                        if (daftarAcara.isEmpty()) {
                            System.out.println("Belum ada acara yang dipublikasikan.");
                        } else {
                            for (int i = 0; i < daftarAcara.size(); i++) {
                                Acara a = daftarAcara.get(i);
                                System.out.println((i + 1) + ". " + a.getNamaAcara() + " (Kuota: " + a.getSisaKuota() + ")");
                            }
                            
                            System.out.print("Pilih nomor acara untuk mendaftar (0 untuk batal): ");
                            int pilihanAcara = input.nextInt();
                            
                            if (pilihanAcara > 0 && pilihanAcara <= daftarAcara.size()) {
                                // Memanggil fungsi daftar pada objek acara yang dipilih
                                daftarAcara.get(pilihanAcara - 1).daftar(mhs1);
                            }
                        }
                    } else if (menuMhs == 2) {
                        mhs1.lihatTiketSaya(); 
                    } else if (menuMhs == 3) {
                        mhs1.tampilkanInfo();
                    }
                } while (menuMhs != 4);
                
            } else if (role == 2) {
                int menuPanitia;
                do {
                    System.out.println("\n--- DASHBOARD PANITIA ---");
                    System.out.println("1. Buat Acara Baru");
                    System.out.println("2. Cek Daftar Peserta");
                    System.out.println("3. Profil Panitia");
                    System.out.println("4. Logout");
                    System.out.print("Pilih: ");
                    menuPanitia = input.nextInt();
                    input.nextLine(); // Membersihkan newline
                    
                    if (menuPanitia == 1) {
                        System.out.println("\n[INPUT ACARA BARU]");
                        System.out.print("Nama Acara : ");
                        String namaAcara = input.nextLine();
                        System.out.print("Ruangan    : ");
                        String ruangan = input.nextLine();
                        System.out.print("Kuota Max  : ");
                        int kuota = input.nextInt();
                        
                        // Menambahkan objek Acara baru ke dalam ArrayList
                        daftarAcara.add(new Acara(namaAcara, ruangan, kuota));
                        System.out.println(">> ACARA BERHASIL DIPUBLIKASIKAN!");
                        
                    } else if (menuPanitia == 2) {
                        if (daftarAcara.isEmpty()) {
                            System.out.println("Belum ada acara yang dibuat.");
                        } else {
                            for (int i = 0; i < daftarAcara.size(); i++) {
                                System.out.println((i + 1) + ". " + daftarAcara.get(i).getNamaAcara());
                            }
                            System.out.print("Pilih nomor acara untuk dicek: ");
                            int cekAcara = input.nextInt();
                            
                            if (cekAcara > 0 && cekAcara <= daftarAcara.size()) {
                                daftarAcara.get(cekAcara - 1).lihatDaftarPeserta();
                            }
                        }
                    } else if (menuPanitia == 3) {
                        panitia1.tampilkanInfo();
                    }
                } while (menuPanitia != 4);
            }
            
        } while (role != 3);
        
        System.out.println("Sistem dimatikan.");
        input.close();
    }
}

//tess