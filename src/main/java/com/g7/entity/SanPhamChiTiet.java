package com.g7.entity;

public class SanPhamChiTiet {

    private int idSanPham, idSanPhamCT, idMau, idKichThuoc, giaBan, soLuong;
    private String tenSanPhamCT, ghiChu;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(int idSanPham, int idSanPhamCT, int idMau, int idKichThuoc, int giaBan, int soLuong, String tenSanPhamCT, String ghiChu) {
        this.idSanPham = idSanPham;
        this.idSanPhamCT = idSanPhamCT;
        this.idMau = idMau;
        this.idKichThuoc = idKichThuoc;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.tenSanPhamCT = tenSanPhamCT;
        this.ghiChu = ghiChu;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public int getIdSanPhamCT() {
        return idSanPhamCT;
    }

    public void setIdSanPhamCT(int idSanPhamCT) {
        this.idSanPhamCT = idSanPhamCT;
    }

    public int getIdMau() {
        return idMau;
    }

    public void setIdMau(int idMau) {
        this.idMau = idMau;
    }

    public int getIdKichThuoc() {
        return idKichThuoc;
    }

    public void setIdKichThuoc(int idKichThuoc) {
        this.idKichThuoc = idKichThuoc;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenSanPhamCT() {
        return tenSanPhamCT;
    }

    public void setTenSanPhamCT(String tenSanPhamCT) {
        this.tenSanPhamCT = tenSanPhamCT;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}
