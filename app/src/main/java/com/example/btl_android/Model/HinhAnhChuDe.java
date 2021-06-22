package com.example.btl_android.Model;

public class HinhAnhChuDe {
    private String TenHinh;
    private int HinhChuDe;



    public HinhAnhChuDe(String tenHinh, int hinhChuDe) {
        TenHinh = tenHinh;
        HinhChuDe = hinhChuDe;
    }

    public String getTenHinh() {
        return TenHinh;
    }

    public void setTenHinh(String tenHinh) {
        TenHinh = tenHinh;
    }

    public int getHinhChuDe() {
        return HinhChuDe;
    }

    public void setHinhChuDe(int hinhChuDe) {
        HinhChuDe = hinhChuDe;
    }
}
