/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g7.repository.impl;

import com.g7.entity.NhanVien;
import com.g7.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class NhanVienRepository {

    String select_Pagination_NV = "SELECT NhanVien.Id,NhanVien.TenNhanVien, NhanVien.GioiTinh,NhanVien.NgaySinh,NhanVien.SoDienThoai,NhanVien.DiaChi,NhanVien.Email,NhanVien.NgayTao,NhanVien.MatKhau,ChucVu.ChucVu,NhanVien.TrangThai\n"
            + "FROM NhanVien JOIN ChucVu \n"
            + "ON NhanVien.IdChucVU = ChucVu.Id\n"
            + "WHERE NhanVien.TrangThai = 1\n"
            + "ORDER BY NhanVien.Id \n"
            + "OFFSET ? ROWS\n"
            + "FETCH NEXT ? ROWS ONLY;";
    
    String sqlCount = "select count(*) from dbo.NhanVien where NhanVien.Trangthai = 1";
    
    public List<NhanVien> selectWithPagination(int offset, int fetchSize) {

        String sql = select_Pagination_NV;

        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, offset, fetchSize);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setIDNhanVien(rs.getInt(1));
                entity.setTenNhanVien(rs.getString(2));
                entity.setGioiTinh(rs.getInt(3));
                entity.setNgaySinh(rs.getDate(4));
                entity.setSDT(rs.getString(5));
                entity.setDiaChi(rs.getString(6));
                entity.setEmail(rs.getString(7));
                entity.setNgayTao(rs.getDate(8));
                entity.setMatKhau(rs.getString(9));
                entity.setChucVu(rs.getString(10));
                entity.setTrangThai(rs.getInt(11));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    public int getTotalItems() {
        int totalItems = 0;

        try {
            ResultSet rs = JdbcHelper.query(sqlCount);

            if (rs.next()) {
                totalItems = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalItems;
    }
}
