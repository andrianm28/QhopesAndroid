package com.qtasnim.qhopes.models;

public class KontakModel {

    String title, alamat, email, nomor1, nomor2;



    public KontakModel(String title, String alamat, String email, String nomor1, String nomor2){
        this.title = title;
        this.alamat = alamat;
        this.email = email;
        this.nomor1 = nomor1;
        this.nomor2 = nomor2;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomor1() {
        return nomor1;
    }

    public void setNomor1(String nomor1) {
        this.nomor1 = nomor1;
    }

    public String getNomor2() {
        return nomor2;
    }

    public void setNomor2(String nomor2) {
        this.nomor2 = nomor2;
    }
}

