package com.example.btl_android.Model;

public class HinhAnhCDNP {
    private String TenHinh;
    private int HinhChuDeNP;

    public HinhAnhCDNP(String tenHinh, int hinhChuDeNP) {
        TenHinh = tenHinh;
        HinhChuDeNP = hinhChuDeNP;
    }

    public String getTenHinh() {
        return TenHinh;
    }

    public void setTenHinh(String tenHinh) {
        TenHinh = tenHinh;
    }

    public int getHinhChuDeNP() {
        return HinhChuDeNP;
    }

    public void setHinhChuDeNP(int hinhChuDeNP) {
        HinhChuDeNP = hinhChuDeNP;
    }
}
