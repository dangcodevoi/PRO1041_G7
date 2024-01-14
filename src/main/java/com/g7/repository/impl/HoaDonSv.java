
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
            String sql = "select MaHD, NgayTao, NgayThanhToan, TongTien, SoTienDuocGiam, GhiChu, TrangThai from HoaDon";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                String idHoaDon = rs.getString(1);
                Date ngayTao = rs.getDate(2);
                Date ngayThanhToan = rs.getDate(3);
                int tongTien = rs.getInt(4);
                int soTienGiam = rs.getInt(5);
                String ghiChu = rs.getString(6);
                int trangThai = rs.getInt(7);
                HoaDon hd = new HoaDon(idHoaDon, ngayTao, ngayThanhToan, tongTien, soTienGiam, ghiChu, trangThai);
                listHoaDon.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }
    
}
