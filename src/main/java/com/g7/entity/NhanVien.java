/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g7.entity;

import java.io.Serializable;

/**
 *
 * @author Ddawng
 */
public class NhanVien implements Serializable {

    private int IDNhanVien;
    private String TenNhanVien;
    private int GioiTinh;
    private String NgaySinh;
    private String SDT;
    private String DiaChi;
    private String Email;
    private String NgayTao;
    private String MatKhau;
    private int IDChucVu;
    private int TrangThai;

    @Override
    public String toString() {
        return this.TenNhanVien;
    }

    
    public NhanVien() {
    }

    public NhanVien(int IDNhanVien, String TenNhanVien, int GioiTinh, String NgaySinh, String SDT, String DiaChi, String Email, String NgayTao, String MatKhau, int IDChucVu, int TrangThai) {
        this.IDNhanVien = IDNhanVien;
        this.TenNhanVien = TenNhanVien;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.NgayTao = NgayTao;
        this.MatKhau = MatKhau;
        this.IDChucVu = IDChucVu;
        this.TrangThai = TrangThai;
    }

    public int getIDNhanVien() {
        return IDNhanVien;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public String getSDT() {
        return SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getEmail() {
        return Email;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public int getIDChucVu() {
        return IDChucVu;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setIDNhanVien(int IDNhanVien) {
        this.IDNhanVien = IDNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public void setIDChucVu(int IDChucVu) {
        this.IDChucVu = IDChucVu;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

}
