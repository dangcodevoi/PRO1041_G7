package com.g7.repository.impl;

import com.g7.entity.HoaDonChiTiet;
import com.g7.utils.JdbcHelper;

import java.util.ArrayList;
import java.sql.*;

public class HoaDonCtRepository {

    public ArrayList<HoaDonChiTiet> listHdct;
    Connection con = JdbcHelper.openDbConnection();

    ArrayList<HoaDonChiTiet> getListHdct(int id) {
        listHdct = new ArrayList<>();
        try {
            String sql = "SELECT [Id]\n"
                    + "      ,[IdHoaDon]\n"
                    + "      ,[IdCTSanPham]\n"
                    + "      ,[SoLuong]\n"
                    + "      ,[DonGia]\n"
                    + "      ,[TrangThai]\n"
                    + "  FROM [dbo].[HoaDonChiTiet]";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(id, 1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                this.listHdct.add(new HoaDonChiTiet(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHdct;
    }

    public void setHdct(ArrayList<HoaDonChiTiet> listHdct){
        this.listHdct = listHdct;
    }
}
