package com.g7.repository.impl;

import com.g7.entity.HoaDon;
import com.g7.utils.JdbcHelper;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HoaDonRepository {

    ArrayList<HoaDon> listHoaDon;
    Connection con = JdbcHelper.openDbConnection();


    public ArrayList<HoaDon> getlistHoaDon(int page) {
        listHoaDon = new ArrayList();
        try {
            // Số dòng bắt đầu của trang hiện tại

            // Câu lệnh SQL sử dụng OFFSET và FETCH để phân trang
            String sql = "SELECT HoaDon.Id, HoaDon.MaHD, CONVERT(DATE, HoaDon.NgayTao),CONVERT(DATE, HoaDon.NgayThanhToan), HoaDon.TongTien, HoaDon.SoTienDuocGiam, "
                    + "HoaDon.GhiChu, HoaDon.TrangThai, HoaDon.IdNhanVien, HoaDon.IdKhachHang, KhachHang.TenKhachHang, KhachHang.SoDienThoai "
                    + "FROM HoaDon "
                    + "INNER JOIN KhachHang ON HoaDon.IdKhachHang = KhachHang.Id "
                    + "ORDER BY HoaDon.Id desc "
                    + "OFFSET " + page * 50 + " ROWS FETCH NEXT 50 ROWS ONLY";

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
                String idNhanVien = rs.getString(9);
                String idKhachHang = rs.getString(10);
                String tenKhachHang = rs.getString(11);
                String soDienThoai = rs.getString(12);

                HoaDon hd = new HoaDon(id, maHD, ngayTao, ngayThanhToan, tongTien, soTienGiam, ghiChu, trangThai, idKhachHang, idNhanVien, tenKhachHang, soDienThoai);
                listHoaDon.add(hd);
            }
        } catch (SQLException e) {
            System.out.println("lỗi: " + e.getMessage());
        }
        return listHoaDon;
    }

    public List<HoaDon> timKiem(String tuKhoa, int page) {
        List<HoaDon> danhSachHoaDon = new ArrayList<>();
        String SQL = "SELECT HoaDon.Id, HoaDon.MaHD, CONVERT(DATE, HoaDon.NgayTao),CONVERT(DATE, HoaDon.NgayThanhToan), HoaDon.TongTien, HoaDon.SoTienDuocGiam, \n"
                + "HoaDon.GhiChu, HoaDon.TrangThai, HoaDon.IdNhanVien, HoaDon.IdKhachHang, KhachHang.TenKhachHang, KhachHang.SoDienThoai \n"
                + "FROM HoaDon \n"
                + "INNER JOIN KhachHang ON HoaDon.IdKhachHang = KhachHang.Id \n"
                + "WHERE (HoaDon.MaHD LIKE ? OR KhachHang.SoDienThoai LIKE ? OR KhachHang.TenKhachHang LIKE ?) \n"
                + "ORDER BY HoaDon.Id DESC \n"
                + "OFFSET " + page * 50 + " ROWS FETCH NEXT 50 ROWS ONLY";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);

            String tuKhoaV2 = "%" + tuKhoa + "%";

            ps.setString(1, tuKhoaV2); // Tham số 1 tương ứng với HoaDon.MaHD
            ps.setString(2, tuKhoaV2); // Tham số 2 tương ứng với KhachHang.SoDienThoai
            ps.setString(3, tuKhoaV2); // Tham số 3 tương ứng với KhachHang.TenKhachHang

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
                String idNhanVien = rs.getString(9);
                String idKhachHang = rs.getString(10);
                String tenKhachHang = rs.getString(11);
                String soDienThoai = rs.getString(12);

                HoaDon hd = new HoaDon(id, maHD, ngayTao, ngayThanhToan, tongTien, soTienGiam, ghiChu, trangThai, idKhachHang, idNhanVien, tenKhachHang, soDienThoai);
                danhSachHoaDon.add(hd);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return danhSachHoaDon;
    }
     public List<HoaDon> timKiemByDate(String a, String b, int page) {
        List<HoaDon> danhSachHoaDon = new ArrayList<>();
        String SQL = "SELECT HoaDon.Id, HoaDon.MaHD,  CONVERT(DATE, HoaDon.NgayTao),CONVERT(DATE, HoaDon.NgayThanhToan), HoaDon.TongTien, HoaDon.SoTienDuocGiam, \n"
                + "HoaDon.GhiChu, HoaDon.TrangThai, HoaDon.IdNhanVien, HoaDon.IdKhachHang, KhachHang.TenKhachHang, KhachHang.SoDienThoai \n"
                + "FROM HoaDon \n"
                + "INNER JOIN KhachHang ON HoaDon.IdKhachHang = KhachHang.Id \n"
                +  "WHERE CONVERT(DATE, HoaDon.NgayTao)= ? AND  CONVERT(DATE, HoaDon.NgayThanhToan) = ? \n"
                + "ORDER BY HoaDon.Id DESC \n"
                + "OFFSET " + page * 50 + " ROWS FETCH NEXT 50 ROWS ONLY";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ps.setString(1, a);
            ps.setString(2, b);

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
                String idNhanVien = rs.getString(9);
                String idKhachHang = rs.getString(10);
                String tenKhachHang = rs.getString(11);
                String soDienThoai = rs.getString(12);

                HoaDon hd = new HoaDon(id, maHD, ngayTao, ngayThanhToan, tongTien, soTienGiam, ghiChu, trangThai, idKhachHang, idNhanVien, tenKhachHang, soDienThoai);
                danhSachHoaDon.add(hd);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return danhSachHoaDon;
    }
      public List<HoaDon> timKiemByCreatedDate(String a, int page) {
        List<HoaDon> danhSachHoaDon = new ArrayList<>();
        String SQL = "SELECT HoaDon.Id, HoaDon.MaHD,  CONVERT(DATE, HoaDon.NgayTao),CONVERT(DATE, HoaDon.NgayThanhToan), HoaDon.TongTien, HoaDon.SoTienDuocGiam, \n"
                + "HoaDon.GhiChu, HoaDon.TrangThai, HoaDon.IdNhanVien, HoaDon.IdKhachHang, KhachHang.TenKhachHang, KhachHang.SoDienThoai \n"
                + "FROM HoaDon \n"
                + "INNER JOIN KhachHang ON HoaDon.IdKhachHang = KhachHang.Id \n"
                +  "WHERE CONVERT(DATE, HoaDon.NgayTao)= ? \n"
                + "ORDER BY HoaDon.Id DESC \n"
                + "OFFSET " + page * 50 + " ROWS FETCH NEXT 50 ROWS ONLY";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ps.setString(1, a);

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
                String idNhanVien = rs.getString(9);
                String idKhachHang = rs.getString(10);
                String tenKhachHang = rs.getString(11);
                String soDienThoai = rs.getString(12);

                HoaDon hd = new HoaDon(id, maHD, ngayTao, ngayThanhToan, tongTien, soTienGiam, ghiChu, trangThai, idKhachHang, idNhanVien, tenKhachHang, soDienThoai);
                danhSachHoaDon.add(hd);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return danhSachHoaDon;
    }
       public List<HoaDon> timKiemByEndDate(String a, int page) {
        List<HoaDon> danhSachHoaDon = new ArrayList<>();
        String SQL = "SELECT HoaDon.Id, HoaDon.MaHD,  CONVERT(DATE, HoaDon.NgayTao),CONVERT(DATE, HoaDon.NgayThanhToan), HoaDon.TongTien, HoaDon.SoTienDuocGiam, \n"
                + "HoaDon.GhiChu, HoaDon.TrangThai, HoaDon.IdNhanVien, HoaDon.IdKhachHang, KhachHang.TenKhachHang, KhachHang.SoDienThoai \n"
                + "FROM HoaDon \n"
                + "INNER JOIN KhachHang ON HoaDon.IdKhachHang = KhachHang.Id \n"
                +  "WHERE  CONVERT(DATE, HoaDon.NgayThanhToan) = ? \n"
                + "ORDER BY HoaDon.Id DESC \n"
                + "OFFSET " + page * 50 + " ROWS FETCH NEXT 50 ROWS ONLY";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ps.setString(1, a);

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
                String idNhanVien = rs.getString(9);
                String idKhachHang = rs.getString(10);
                String tenKhachHang = rs.getString(11);
                String soDienThoai = rs.getString(12);

                HoaDon hd = new HoaDon(id, maHD, ngayTao, ngayThanhToan, tongTien, soTienGiam, ghiChu, trangThai, idKhachHang, idNhanVien, tenKhachHang, soDienThoai);
                danhSachHoaDon.add(hd);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return danhSachHoaDon;
    }

}
