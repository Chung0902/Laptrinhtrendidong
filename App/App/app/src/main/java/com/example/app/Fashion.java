package com.example.app;

public class Fashion {
    private String ten;
    private String mota;
    private String tien;

    public Fashion() {
    }

    public Fashion(String ten, String mota, String tien) {
        this.ten = ten;
        this.mota = mota;
        this.tien = tien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getTien() {
        return tien;
    }

    public void setTien(String tien) {
        this.tien = tien;
    }
}

