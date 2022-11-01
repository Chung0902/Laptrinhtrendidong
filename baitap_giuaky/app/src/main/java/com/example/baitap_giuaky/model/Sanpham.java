package com.example.baitap_giuaky.model;

public class Sanpham {
    private int mID;
    private String mTensanpham;
    private String mMota;
    private String mSoluong;
    private String mGiatien;

    public Sanpham() {
    }

    public Sanpham( String mTensanpham, String mMota, String mSoluong, String mGiatien) {
        this.mTensanpham = mTensanpham;
        this.mMota = mMota;
        this.mSoluong = mSoluong;
        this.mGiatien = mGiatien;
    }

    public Sanpham(int mID, String mTensanpham, String mMota, String mSoluong, String mGiatien) {
        this.mID = mID;
        this.mTensanpham = mTensanpham;
        this.mMota = mMota;
        this.mSoluong = mSoluong;
        this.mGiatien = mGiatien;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmTensanpham() {
        return mTensanpham;
    }

    public void setmTensanpham(String mTensanpham) {
        this.mTensanpham = mTensanpham;
    }

    public String getmMota() {
        return mMota;
    }

    public void setmMota(String mMota) {
        this.mMota = mMota;
    }

    public String getmSoluong() {
        return mSoluong;
    }

    public void setmSoluong(String mSoluong) {
        this.mSoluong = mSoluong;
    }

    public String getmGiatien() {
        return mGiatien;
    }

    public void setmGiatien(String mGiatien) {
        this.mGiatien = mGiatien;
    }
}
