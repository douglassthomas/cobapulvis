package com.example.tes20april;

public class PasienModel {
    private String idPasien;
    private String nama;
    private String status;

    public PasienModel(String idPasien, String nama, String status) {
        this.idPasien = idPasien;
        this.nama = nama;
        this.status = status;
    }

    public String getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(String idPasien) {
        this.idPasien = idPasien;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
