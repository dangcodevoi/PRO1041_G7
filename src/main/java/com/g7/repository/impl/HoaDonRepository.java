
package com.g7.repository.impl;

import com.g7.entity.HoaDon;
import com.g7.utils.JdbcHelper;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoaDonRepository {

    ArrayList<HoaDon> listHoaDon;
    Connection con = JdbcHelper.openDbConnection();

    public ArrayList<HoaDon> getlistHoaDon() {
        listHoaDon = new ArrayList();
        try {
            String sql = "SELECT HoaDon.Id, HoaDon.MaHD, HoaDon.NgayTao, HoaDon.NgayThanhToan,HoaDon.TongTien, HoaDon.SoTienDuocGiam,\n"
                    + "HoaDon.GhiChu, HoaDon.TrangThai, HoaDon.IdNhanVien, .HoaDon.IdKhachHang, KhachHang.TenKhachHang, KhachHang.SoDienThoai \n"
                    + "FROM HoaDon\n"
                    + "Inner JOIN KhachHang ON HoaDon.IdKhachHang = KhachHang.Id";

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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

//    public List<HoaDon> searchNameKH(String tenKhachHang) {
//    List<HoaDon> result = new ArrayList<>();
//    try {
//        Connection con = JdbcHelper.openDbConnection();
//        String sql = "SELECT HoaDon.Id, HoaDon.MaHD, HoaDon.NgayTao, HoaDon.NgayThanhToan, HoaDon.TongTien, HoaDon.SoTienDuocGiam, "
//                   + "HoaDon.GhiChu, HoaDon.TrangThai, HoaDon.IdNhanVien, HoaDon.IdKhachHang, KhachHang.TenKhachHang, KhachHang.SoDienThoai "
//                   + "FROM HoaDon "
//                   + "INNER JOIN KhachHang ON HoaDon.IdKhachHang = KhachHang.Id "
//                   + "WHERE KhachHang.TenKhachHang LIKE ? ";
//
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setString(1, "%" + tenKhachHang + "%"); // Using LIKE for partial match
//    //    ps.setInt(2, trangThai);
//        ResultSet rs = ps.executeQuery();
//
//        while (rs.next()) {
//            int id = rs.getInt(1);
//            String maHD = rs.getString(2);
//            String ngayTao = rs.getString(3);
//            String ngayThanhToan = rs.getString(4);
//            BigDecimal tongTien = rs.getBigDecimal(5);
//            BigDecimal soTienGiam = rs.getBigDecimal(6);
//            String ghiChu = rs.getString(7);
//            int trangThaiResult = rs.getInt(8);
//            String idNhanVien = rs.getString(9);
//            String idKhachHang = rs.getString(10);
//            String tenKhachHangResult = rs.getString(11);
//            String soDienThoai = rs.getString(12);
//
//            HoaDon hd = new HoaDon(id, maHD, ngayTao, ngayThanhToan, tongTien, soTienGiam, ghiChu, trangThaiResult, idKhachHang, idNhanVien, tenKhachHangResult, soDienThoai);
//            result.add(hd);
//        }
//
//        con.close();
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//    return result;
//}
}