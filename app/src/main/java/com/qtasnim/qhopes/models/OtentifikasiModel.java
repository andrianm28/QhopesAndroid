package com.qtasnim.qhopes.models;

public class OtentifikasiModel {
    String username,password;
    int Medrek,NIPDokter;

    public OtentifikasiModel(int Medrek, int NIPDokter){
        this.Medrek = Medrek;
        this.NIPDokter = NIPDokter;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMedrek() {
        return Medrek;
    }

    public void setMedrek(int medrek) {
        Medrek = medrek;
    }

    public int getNIPDokter() {
        return NIPDokter;
    }

    public void setNIPDokter(int NIPDokter) {
        this.NIPDokter = NIPDokter;
    }
}

