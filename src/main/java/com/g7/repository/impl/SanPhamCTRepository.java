package com.g7.repository.impl;

import com.g7.entity.SanPhamChiTiet;
import com.g7.repository.SP_SPCT_Repository;
import com.g7.utils.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SanPhamCTRepository implements SP_SPCT_Repository {

    private Connection connect = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    @Override
    public ArrayList<SanPhamChiTiet> selectOffset(int indexOffset) {
        if (indexOffset == 0) {
            indexOffset = 1;
        }
        ArrayList<SanPhamChiTiet> list = new ArrayList<>();
        String sql = "SELECT\n"
                + "                         CTS.[Id] AS ChiTietSanPham_Id,\n"
                + "                         CTS.IdSanPham AS SanPham_Id,\n"
                + "                         SP.TenSanPham,\n"
                + "                         CTS.IdKichCo AS KichCo_Id,\n"
                + "                         KC.KichCo,\n"
                + "                         CTS.IdMauSac AS MauSac_Id,\n"
                + "                         MS.TenMauSac,\n"
                + "                         HA.TenHinhAnh,\n"
                + "                         CTS.GiaBan,\n"
                + "                         CTS.SoLuong,\n"
                + "                         CTS.MoTa\n"
                + "                     FROM\n"
                + "                         ChiTietSanPham CTS\n"
                + "                     JOIN\n"
                + "                         SanPham SP ON CTS.IdSanPham = SP.Id\n"
                + "                     JOIN\n"
                + "                         KichCo KC ON CTS.IdKichCo = KC.Id\n"
                + "                     JOIN\n"
                + "                         MauSac MS ON CTS.IdMauSac = MS.Id\n"
                + "                     JOIN\n"
                + "                         HinhAnh HA ON CTS.IdHinhAnh = HA.Id\n"
                + "                     WHERE\n"
                + "                         CTS.TrangThai = 1\n"
                + "                     ORDER BY\n"
                + "                         CTS.Id\n"
                + "                     OFFSET "+(indexOffset*5)+"0 ROWS\n"
                + "                     FETCH NEXT 50 ROWS ONLY;";
        try {
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new SanPhamChiTiet(
                        resultSet.getInt("SanPham_Id"),
                        resultSet.getInt("ChiTietSanPham_Id"),
                        resultSet.getInt("MauSac_Id"),
                        resultSet.getInt("KichCo_Id"),
                        resultSet.getString("KichCo"),
                        resultSet.getInt("GiaBan"),
                        resultSet.getInt("SoLuong"),
                        resultSet.getString("TenSanPham"),
                        resultSet.getString("TenHinhAnh"),
                        resultSet.getString("TenMauSac"),
                        resultSet.getString("MoTa"),
                        true));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Lỗi B-01: "+e.getMessage());
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
