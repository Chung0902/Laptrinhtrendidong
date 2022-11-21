package com.example.bktra2.Data.model;

public class Cayxanh {
    private int mID;
    private String mTenkhoahoc;
    private String mTenthuonggoi;
    private String mDactinh;
    private String mMaula;

    public Cayxanh() {
    }

    public Cayxanh( String mTenkhoahoc, String mTenthuonggoi, String mDactinh, String mMaula) {
        this.mTenkhoahoc = mTenkhoahoc;
        this.mTenthuonggoi = mTenthuonggoi;
        this.mDactinh = mDactinh;
        this.mMaula = mMaula;
    }

    public Cayxanh(int mID, String mTenkhoahoc, String mTenthuonggoi, String mDactinh, String mMaula) {
        this.mID = mID;
        this.mTenkhoahoc = mTenkhoahoc;
        this.mTenthuonggoi = mTenthuonggoi;
        this.mDactinh = mDactinh;
        this.mMaula = mMaula;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmTenkhoahoc() {
        return mTenkhoahoc;
    }

    public void setmTenkhoahoc(String mTenkhoahoc) {
        this.mTenkhoahoc = mTenkhoahoc;
    }

    public String getmTenthuonggoi() {
        return mTenthuonggoi;
    }

    public void setmTenthuonggoi(String mTenthuonggoi) {
        this.mTenthuonggoi = mTenthuonggoi;
    }

    public String getmDactinh() {
        return mDactinh;
    }

    public void setmDactinh(String mDactinh) {
        this.mDactinh = mDactinh;
    }

    public String getmMaula() {
        return mMaula;
    }

    public void setmMaula(String mMaula) {
        this.mMaula = mMaula;
    }
}
