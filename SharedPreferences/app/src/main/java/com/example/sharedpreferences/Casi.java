package com.example.sharedpreferences;

public class Casi {
    private String Ten;
    private String Nghedanh;
    private String Quocgia;
    private String Sosao;
    private int Hinh;

    public Casi(String ten, String nghedanh, String quocgia, String sosao, int hinh) {
        Ten = ten;
        Nghedanh = nghedanh;
        Quocgia = quocgia;
        Sosao = sosao;
        Hinh = hinh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getNghedanh() {
        return Nghedanh;
    }

    public void setNghedanh(String nghedanh) {
        Nghedanh = nghedanh;
    }

    public String getQuocgia() {
        return Quocgia;
    }

    public void setQuocgia(String quocgia) {
        Quocgia = quocgia;
    }

    public String getSosao() {
        return Sosao;
    }

    public void setSosao(String sosao) {
        Sosao = sosao;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
