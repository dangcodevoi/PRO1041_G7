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
    public void updateTrangThai(int id, int trangThai) {
        try {
            Connection con = JdbcHelper.openDbConnection();
            String sql = "UPDATE HoaDon SET TrangThai = ? WHERE Id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, trangThai);
            ps.setInt(2, id);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//        HoaDonRepository hdsv = new HoaDonRepository();
//        System.out.println(hdsv.getlistHoaDon());
//    }
}
