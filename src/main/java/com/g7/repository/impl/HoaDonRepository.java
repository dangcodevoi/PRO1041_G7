package com.g7.repository.impl;

import com.g7.entity.HoaDon;
import com.g7.utils.JdbcHelper;
import java.math.BigDecimal;

import java.sql.*;
import java.util.ArrayList;

public class HoaDonRepository {

    ArrayList<HoaDon> listHoaDon;
    Connection con = JdbcHelper.openDbConnection();

    public ArrayList<HoaDon> getlistHoaDon() {
        listHoaDon = new ArrayList();
        try {
            String sql = "SELECT Id, MaHD, NgayTao, NgayThanhToan, TongTien, SoTienDuocGiam, GhiChu, TrangThai, IdNhanVien, IdKhachHang from HoaDon";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String maHD = rs.getString(2);
                Date ngayTao = rs.getDate(3);
                Date ngayThanhToan = rs.getDate(4);
                BigDecimal tongTien = rs.getBigDecimal(5);
                BigDecimal soTienGiam = rs.getBigDecimal(6);
                String ghiChu = rs.getString(7);
                int trangThai = rs.getInt(8);
                String idnv = rs.getString(9);
                String idkh = rs.getString(10);
                HoaDon hd = new HoaDon(id, maHD, ngayTao, ngayThanhToan, tongTien, soTienGiam, ghiChu, trangThai, idkh, idnv);
                listHoaDon.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public ArrayList<HoaDon> searchById(int id) {
    this.listHoaDon = new ArrayList<>();
    try {
        String sql = "SELECT Id, MaHD, NgayTao, NgayThanhToan, TongTien, SoTienDuocGiam, GhiChu, TrangThai, IdNhanVien, IdKhachHang FROM HoaDon WHERE Id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            this.listHoaDon.add(new HoaDon(
                    rs.getInt(1),
                    rs.getString(2), 
                    rs.getDate(3), 
                    rs.getDate(4), 
                    rs.getBigDecimal(5), 
                    rs.getBigDecimal(6),
                    rs.getString(7),
                    rs.getInt(8),
                    rs.getString(9),
                    rs.getString(10)));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return listHoaDon;
}
    

    public static void main(String[] args) {
        HoaDonRepository hdsv = new HoaDonRepository();
        System.out.println(hdsv.getlistHoaDon());
    }
}
