package com.example.btl_android.Model;

public class TuVung {
    private int Id;
    private String LoaiTu;
    private String NghiaTV;
    private String PhienAm;
    private String ChuDe;
    private int HinhAnhTV;
    private int AmthanhTV;
    private String CauVD;
    private String TenTV;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLoaiTu() {
        return LoaiTu;
    }

    public void setLoaiTu(String loaiTu) {
        LoaiTu = loaiTu;
    }

    public String getPhienAm() {
        return PhienAm;
    }

    public void setPhienAm(String phienAm) {
        PhienAm = phienAm;
    }

    public String getCauVD() {
        return CauVD;
    }

    public void setCauVD(String cauVD) {
        CauVD = cauVD;
    }

    public TuVung() {

    }

    public TuVung(int id, String tenTV, String nghiaTV, int hinhAnhTV, int amthanhTV) {
        Id = id;
        TenTV = tenTV;
        NghiaTV = nghiaTV;
        HinhAnhTV = hinhAnhTV;
        AmthanhTV = amthanhTV;

    }



    public TuVung(String tenTV, String nghiaTV, int hinhAnhTV, int amthanhTV) {
        TenTV = tenTV;
        NghiaTV = nghiaTV;
        HinhAnhTV = hinhAnhTV;
        AmthanhTV = amthanhTV;
    }

    public String getTenTV() {
        return TenTV;
    }

    public void setTenTV(String tenTV) {
        TenTV = tenTV;
    }

    public String getNghiaTV() {
        return NghiaTV;
    }

    public void setNghiaTV(String nghiaTV) {
        NghiaTV = nghiaTV;
    }

    public int getHinhAnhTV() {
        return HinhAnhTV;
    }

    public void setHinhAnhTV(int hinhAnhTV) {
        HinhAnhTV = hinhAnhTV;
    }

    public int getAmthanhTV() {
        return AmthanhTV;
    }

    public void setAmthanhTV(int amthanhTV) {
        AmthanhTV = amthanhTV;
    }

    public String getChuDe() {
        return ChuDe;
    }

    public void setChuDe(String chuDe) {
        ChuDe = chuDe;
    }
}
