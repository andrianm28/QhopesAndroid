package com.simrs.qt.simrs.model;

public class MenuHariiniModel {

    String nama_poliklinik, nama_dokter, jam_praktek, jumlah_pasien, jumlah_terlayani, kuota_pasien, check_in;


    public MenuHariiniModel(
            String nama_poliklinik,
            String nama_dokter,
            String jam_praktek,
            String jumlah_pasien,
            String jumlah_terlayani,
            String kuota_pasien,
            String check_in
            ) {
        this.nama_poliklinik = nama_poliklinik;
        this.nama_dokter = nama_dokter;
        this.jam_praktek = jam_praktek;
        this.jumlah_pasien = jumlah_pasien;
        this.jumlah_terlayani = jumlah_terlayani;
        this.kuota_pasien = kuota_pasien;
        this.check_in = check_in;
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

    public String getJumlah_pasien() {
        return jumlah_pasien;
    }

    public void setJumlah_pasien(String jumlah_pasien) {
        this.jumlah_pasien = jumlah_pasien;
    }

    public String getJumlah_terlayani() {
        return jumlah_terlayani;
    }

    public void setJumlah_terlayani(String jumlah_terlayani) {
        this.jumlah_terlayani = jumlah_terlayani;
    }

    public String getKuota_pasien() {
        return kuota_pasien;
    }

    public void setKuota_pasien(String kuota_pasien) {
        this.kuota_pasien = kuota_pasien;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }
}
