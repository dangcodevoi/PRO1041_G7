
package com.g7.repository.impl;

import com.g7.entity.HoaDon;
import java.util.ArrayList;
import com.g7.utils.JdbcHelper;
import java.sql.*;

public class HoaDonSv {
    ArrayList<HoaDon> listHoaDon;
    Connection con = JdbcHelper.openDbConnection();
    public ArrayList<HoaDon> getlistHoaDon(){
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
//                HoaDon hd = new HoaDon(idHoaDon, ngayTao, ngayThanhToan, tongTien, soTienGiam, ghiChu, trangThai, idnv, idkh);
                HoaDon hd = new HoaDon(idHoaDon, ngayTao, ngayThanhToan, idkh, idnv, maHD, tongTien, soTienGiam, ghiChu, trangThai);
//                listHoaDon.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }
    
}
