package com.g7.repository.impl;

import com.g7.entity.HoaDon;
import com.g7.utils.JdbcHelper;

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
                int idHoaDon = rs.getInt(1);
                String maHD = rs.getString(2);
                Date ngayTao = rs.getDate(3);
                Date ngayThanhToan = rs.getDate(4);
                int tongTien = rs.getInt(5);
                int soTienGiam = rs.getInt(6);
                String ghiChu = rs.getString(7);
                int trangThai = rs.getInt(8);
                String idnv = rs.getString(9);
                String idkh = rs.getString(10);
                HoaDon hd = new HoaDon(idHoaDon, maHD, ngayTao, ngayThanhToan, idkh, idnv, maHD, tongTien, soTienGiam, ghiChu, trangThai);
               listHoaDon.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

//    public ArrayList<HoaDon> getHoaDon() {
//    String SQL_SELECTALL = " SELECT [MaHD] ,[NgayTao], [NgayThanhToan]\n"
//            + "                           ,[TongTien]\n"
//            + "                           ,[SoTienDuocGiam]\n"
//            + "                           ,[GhiChu]\n"
//            + "                           ,[TrangThai]\n"
//            + "                       FROM [dbo].[HoaDon]";
//
//    
//        listHoaDon = new ArrayList<>();
//        String sql = SQL_SELECTALL;
//        try ( Connection con = JdbcHelper.openDbConnection();  PreparedStatement ps = con.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {
//
//            while (rs.next()) {
//                String maHoaDon = rs.getString(1);
//                Date ngayTao = rs.getDate(2);
//                Date ngayThanhToan = rs.getDate(3);
//                int tongTien = rs.getInt(4);
//                int soTienGiam = rs.getInt(5);
//                String ghiChu = rs.getString(6);
//                int trangThai = rs.getInt(7);
//                HoaDon hd = new HoaDon(maHoaDon, ngayTao, ngayThanhToan, tongTien, soTienGiam, ghiChu, trangThai);
//                listHoaDon.add(hd);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return listHoaDon;
//    }

    public static void main(String[] args) {
        HoaDonRepository hdsv = new HoaDonRepository();
        System.out.println(hdsv.getlistHoaDon());
    }
}

