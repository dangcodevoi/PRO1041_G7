package com.g7.entity;

public class SanPhamChiTiet {

    private int idSanPham, idSanPhamCT, idMau, idKichThuoc, giaBan, soLuong;
    private String tenSanPham, hinhAnh, mau, ghiChu, kichThuoc;
    private boolean trangThai;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(int idSanPham, int idSanPhamCT, int idMau, int idKichThuoc, String kichThuoc, int giaBan, int soLuong, String tenSanPham, String hinhAnh, String mau, String ghiChu, boolean trangThai) {
        this.idSanPham = idSanPham;
        this.idSanPhamCT = idSanPhamCT;
        this.idMau = idMau;
        this.idKichThuoc = idKichThuoc;
        this.kichThuoc = kichThuoc;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.tenSanPham = tenSanPham;
        this.hinhAnh = hinhAnh;
        this.mau = mau;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
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
        return tenSanPham + "-" + mau + "-" + kichThuoc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

}
