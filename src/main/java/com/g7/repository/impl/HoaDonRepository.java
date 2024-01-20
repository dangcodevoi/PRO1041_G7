package com.g7.repository.impl;

import com.g7.entity.HoaDon;
import com.g7.utils.JdbcHelper;
import java.math.BigDecimal;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
                String ngayTao = rs.getString(3);
                String ngayThanhToan = rs.getString(4);
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
public List<HoaDon> searchByDateTime(LocalDateTime fromDate, LocalDateTime toDate) {
        List<HoaDon> result = new ArrayList<>();
        try {
            Connection con = JdbcHelper.openDbConnection();
            String sql = "SELECT * FROM HoaDon WHERE NgayTao BETWEEN ? AND ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTimestamp(1, Timestamp.valueOf(fromDate));
            ps.setTimestamp(2, Timestamp.valueOf(toDate));
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                // Set các giá trị cho đối tượng HoaDon từ ResultSet
                hd.setId(rs.getInt("Id"));
                // ... Set các giá trị khác

                result.add(hd);
            }
            
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
//    public static void main(String[] args) {
//        HoaDonRepository hdsv = new HoaDonRepository();
//        System.out.println(hdsv.getlistHoaDon());
//    }
}
