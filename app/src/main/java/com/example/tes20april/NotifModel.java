package com.example.tes20april;

public class NotifModel {
    private String idPasien;
    private String namaPasien;
    private String tanggal;
    private String status;

    public NotifModel(String idPasien, String namaPasien, String tanggal, String status) {
        this.idPasien = idPasien;
        this.namaPasien = namaPasien;
        this.tanggal = tanggal;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(String idPasien) {
        this.idPasien = idPasien;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
