package com.g7.repository.impl;

import com.g7.entity.SanPham;
import com.g7.repository.SP_SPCT_Repository;
import com.g7.utils.JdbcHelper;
import java.util.ArrayList;
import java.sql.*;

public class SanPhamRepository implements SP_SPCT_Repository {

    private Connection connect = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    @Override
    public ArrayList<SanPham> selectOffset(int indexOffset) {
        ArrayList list = new ArrayList();
        String sql = "SELECT\n"
                + "                         SP.Id AS SanPham_Id,\n"
                + "                         SP.TenSanPham,\n"
                + "                         SP.IdDanhMuc,\n"
                + "                         DM.TenDanhMuc,\n"
                + "                         SP.IdChatLieu,\n"
                + "                         CL.TenChatLieu,\n"
                + "                         SP.IdNSX,\n"
                + "                         NSX.TenNSX\n"
                + "                     FROM\n"
                + "                         SanPham SP\n"
                + "                     JOIN\n"
                + "                         DanhMuc DM ON SP.IdDanhMuc = DM.Id\n"
                + "                     JOIN\n"
                + "                         ChatLieu CL ON SP.IdChatLieu = CL.Id\n"
                + "                     JOIN\n"
                + "                         NSX ON SP.IdNSX = NSX.Id\n"
                + "                     WHERE\n"
                + "                         SP.TrangThai = 1\n"
                + "                     ORDER BY\n"
                + "                         SP.Id\n";
        if (indexOffset != -1) {
            sql += " OFFSET " + indexOffset * 5 + "0 ROWS FETCH NEXT 50 ROWS ONLY";
        }
        try {
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new SanPham(
                        resultSet.getInt("SanPham_Id"),
                        resultSet.getInt("IdNSX"),
                        resultSet.getInt("IdDanhMuc"),
                        resultSet.getInt("IdChatLieu"),
                        resultSet.getString("TenSanPham"),
                        resultSet.getString("TenNSX"),
                        resultSet.getString("TenChatLieu"),
                        resultSet.getString("TenDanhMuc")));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Lỗi A-01: " + e.getMessage());
            return null;
        }
    }

    @Override
    public int create(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
