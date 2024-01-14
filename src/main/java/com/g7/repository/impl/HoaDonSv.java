package com.g7.repository.impl;

import com.g7.entity.HoaDon;
import com.g7.utils.JdbcHelper;

import java.sql.*;
import java.util.ArrayList;

public class HoaDonSv {
    private ArrayList<HoaDon> listHoaDon;
    String SQL_SELECTALL = " SELECT [MaHD] ,[NgayTao], [NgayThanhToan]\n" +
"                           ,[TongTien]\n" +
"                           ,[SoTienDuocGiam]\n" +
"                           ,[GhiChu]\n" +
"                           ,[TrangThai]\n" +
"                       FROM [dbo].[HoaDon]";
    
    public ArrayList<HoaDon> getListHoaDon() {
        listHoaDon = new ArrayList<>();
        String sql = SQL_SELECTALL;
        try (Connection con = JdbcHelper.openDbConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String maHoaDon = rs.getString(1);
                Date ngayTao = rs.getDate(2);
                Date ngayThanhToan = rs.getDate(3);
                int tongTien = rs.getInt(4);
                int soTienGiam = rs.getInt(5);
                String ghiChu = rs.getString(6);
                int trangThai = rs.getInt(7);
                HoaDon hd = new HoaDon(maHoaDon, ngayTao, ngayThanhToan, tongTien, soTienGiam, ghiChu, trangThai);
                listHoaDon.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }
    
    public static void main(String[] args) {
        HoaDonSv hdsv = new HoaDonSv();
        System.out.println(hdsv.getListHoaDon());
    }
}
