/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g7.repository.impl;

import com.g7.entity.KhachHang;
import com.g7.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class KhachHangRepository {

    String select_Pagination_kh = "SELECT dbo.KhachHang.id,dbo.KhachHang.MaKhachHang,dbo.KhachHang.TenKhachHang,dbo.KhachHang.SoDienThoai,dbo.KhachHang.NgayTao,dbo.KhachHang.TrangThai\n"
            + "FROM dbo.KhachHang\n"
            + "WHERE dbo.KhachHang.TrangThai = 1 ORDER BY ID\n"
            + "OFFSET ? ROWS\n"
            + "FETCH NEXT  ? ROWS ONLY;";

    String sqlCount = "select count(*) from dbo.KhachHang where KhachHang.Trangthai = 1";

    String find_byMaKH = "SELECT dbo.KhachHang.id,dbo.KhachHang.MaKhachHang,dbo.KhachHang.TenKhachHang,dbo.KhachHang.SoDienThoai,dbo.KhachHang.NgayTao,dbo.KhachHang.TrangThai\n"
            + "FROM dbo.KhachHang WHERE MaKhachHang LIKE '%?%' ORDER BY ID\n"
            + "OFFSET ? ROWS\n"
            + "FETCH NEXT ? ROWS ONLY;";

    String sqlCountMaKH = "select count(*) from dbo.KhachHang where KhachHang.MaKhachHang LIKE '%?%'";

    String find_byTenKH = "SELECT dbo.KhachHang.id,dbo.KhachHang.MaKhachHang,dbo.KhachHang.TenKhachHang,dbo.KhachHang.SoDienThoai,dbo.KhachHang.NgayTao,dbo.KhachHang.TrangThai\n"
            + "FROM dbo.KhachHang WHERE TenKhachHang = %?% ORDER BY ID\n"
            + "OFFSET ? ROWS\n"
            + "FETCH NEXT  ? ROWS ONLY;";

    public List<KhachHang> selectWithPagination(int offset, int fetchSize) {

        String sql = select_Pagination_kh;

        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, offset, fetchSize);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setIDKhachHang(rs.getInt(1));
                entity.setMaKhachHang(rs.getString(2));
                entity.setTenKhachHang(rs.getString(3));
                entity.setSDT(rs.getString(4));
                entity.setNgayTao(rs.getDate(5));
                entity.setTrangThai(rs.getInt(6));
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

    public int getTotalSearchItemsMaKH() {
        int totalItems = 0;

        try {
            ResultSet rs = JdbcHelper.query(sqlCountMaKH);

            if (rs.next()) {
                totalItems = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalItems;
    }

    public List<KhachHang> findWithPaginationbyMaKH(String maKH, int offset, int fetchSize) {

        String sql = find_byMaKH;

        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, maKH, offset, fetchSize);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setIDKhachHang(rs.getInt(1));
                entity.setMaKhachHang(rs.getString(2));
                entity.setTenKhachHang(rs.getString(3));
                entity.setSDT(rs.getString(4));
                entity.setNgayTao(rs.getDate(5));
                entity.setTrangThai(rs.getInt(6));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<KhachHang> findWithPaginationbyTenKH(String TenKH, int offset, int fetchSize) {

        String sql = find_byMaKH;

        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, TenKH, offset, fetchSize);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setIDKhachHang(rs.getInt(1));
                entity.setMaKhachHang(rs.getString(2));
                entity.setTenKhachHang(rs.getString(3));
                entity.setSDT(rs.getString(4));
                entity.setNgayTao(rs.getDate(5));
                entity.setTrangThai(rs.getInt(6));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setIDKhachHang(rs.getInt(1));
                list.add(entity);
            }
        } catch (Exception e) {
        }
        return list;
    }

}