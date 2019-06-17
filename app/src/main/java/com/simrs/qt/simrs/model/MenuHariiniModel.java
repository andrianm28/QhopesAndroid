package com.simrs.qt.simrs.model;

public class MenuHariiniModel {

    String nama_poliklinik,nama_dokter,jam_praktek;
    int jumlah_pasien, jumlah_terlayani, kuota_pasien;
    boolean check_in;

//    String spesialis;
//    String jam;
    String feature;

    public MenuHariiniModel(
            String nama_dokter,
            String nama_poliklinik,
            String jam_praktek,
            String feature
//            int jumlah_pasien,
//            int jumlah_terlayani,
//            int kuota_pasien,
//            boolean check_in
            ) {
        this.nama_poliklinik = nama_poliklinik;
        this.nama_dokter = nama_dokter;
        this.jam_praktek = jam_praktek;
//        this.feature = feature;
//        this.jumlah_pasien = jumlah_pasien;
//        this.jumlah_terlayani = jumlah_terlayani;
//        this.kuota_pasien = kuota_pasien;
//        this.check_in = check_in;
    }

    public String getNama_poliklinik() {
        return nama_poliklinik;
    }

    public void setNama_poliklinik(String nama_poliklinik) {
        this.nama_poliklinik = nama_poliklinik;
    }

    public String getNama_dokter() {
        return nama_dokter;
    }

    public void setNama_dokter(String nama_dokter) {
        this.nama_dokter = nama_dokter;
    }

    public String getJam_praktek() {
        return jam_praktek;
    }

    public void setJam_praktek(String jam_praktek) {
        this.jam_praktek = jam_praktek;
    }

    public int getJumlah_pasien() {
        return jumlah_pasien;
    }

    public void setJumlah_pasien(int jumlah_pasien) {
        this.jumlah_pasien = jumlah_pasien;
    }

    public int getJumlah_terlayani() {
        return jumlah_terlayani;
    }

    public void setJumlah_terlayani(int jumlah_terlayani) {
        this.jumlah_terlayani = jumlah_terlayani;
    }

    public int getKuota_pasien() {
        return kuota_pasien;
    }

    public void setKuota_pasien(int kuota_pasien) {
        this.kuota_pasien = kuota_pasien;
    }
}
