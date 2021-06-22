package com.example.btl_android.Model;

public class NguPhap {
    private int Id;
    private String TenTL;
    private String DauHieuNB;
    private String CachSD;
    private String ViDu;
    private String ViDuTiengViet;

    public NguPhap() {

    }

    public NguPhap(int id, String tenTL, String cachSD, String viDu, String viDuTiengViet) {
        Id = id;
        TenTL = tenTL;
        CachSD = cachSD;
        ViDu = viDu;
        ViDuTiengViet = viDuTiengViet;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTenTL() {
        return TenTL;
    }

    public void setTenTL(String tenTL) {
        TenTL = tenTL;
    }

    public String getDauHieuNB() {
        return DauHieuNB;
    }

    public void setDauHieuNB(String dauHieuNB) {
        DauHieuNB = dauHieuNB;
    }

    public String getCachSD() {
        return CachSD;
    }

    public void setCachSD(String cachSD) {
        CachSD = cachSD;
    }

    public String getViDu() {
        return ViDu;
    }

    public void setViDu(String viDu) {
        ViDu = viDu;
    }

    public String getViDuTiengViet() {
        return ViDuTiengViet;
    }

    public void setViDuTiengViet(String viDuTiengViet) {
        ViDuTiengViet = viDuTiengViet;
    }
}
