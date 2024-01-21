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
            if (indexOffset == 0) {
                sql += " OFFSET 0 ROWS FETCH NEXT 50 ROWS ONLY";
            } else {
                sql += " OFFSET " + (indexOffset * 50 - 1) + " ROWS FETCH NEXT 50 ROWS ONLY";
            }
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
        String sql = "insert into "
                + "sanpham(tensanpham,idnsx,iddanhmuc,idchatlieu,trangthai)"
                + " values(?,?,?,?,1)";
        try {
            SanPham sp = (SanPham) o;
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, sp.getTenSanPham());
            preparedStatement.setInt(2, sp.getIdNhaSX());
            preparedStatement.setInt(3, sp.getIdDanhMuc());
            preparedStatement.setInt(4, sp.getIdChatLieu());

            preparedStatement.executeUpdate();

            return 0;
        } catch (SQLException e) {
            System.out.println("Lỗi A-02 " + e.getMessage());
            return 1;
        }
    }

    @Override
    public int update(Object o) {
        String sql = "update sanpham set tensanpham=?, idnsx=?, iddanhmuc=?,idchatlieu=? where id=?";
        try {
            SanPham sp = (SanPham) o;
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, sp.getTenSanPham());
            preparedStatement.setInt(2, sp.getIdNhaSX());
            preparedStatement.setInt(3, sp.getIdDanhMuc());
            preparedStatement.setInt(4, sp.getIdChatLieu());
            preparedStatement.setInt(5, sp.getIdSanPham());

            preparedStatement.executeUpdate();

            return 0;
        } catch (SQLException e) {
            System.out.println("Lỗi A-03 " + e.getMessage());
            return 1;
        }
    }

    @Override
    public int remove(int id) {
        String sql = "update sanpham set trangthai=0 where id=" + id;
        try {
            connect = JdbcHelper.openDbConnection();

            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.executeUpdate();

            return 0;
        } catch (SQLException e) {
            System.out.println("Lỗi A-04 " + e.getMessage());
            return 1;
        }
    }

    public SanPham selectById(int id) {
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
                + "                         SP.TrangThai = 1 and SP.id= " + id;
        try {
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            SanPham sp = null;
            while (resultSet.next()) {
                sp = new SanPham(
                        resultSet.getInt("SanPham_Id"),
                        resultSet.getInt("IdNSX"),
                        resultSet.getInt("IdDanhMuc"),
                        resultSet.getInt("IdChatLieu"),
                        resultSet.getString("TenSanPham"),
                        resultSet.getString("TenNSX"),
                        resultSet.getString("TenChatLieu"),
                        resultSet.getString("TenDanhMuc"));
            }
            return sp;
        } catch (SQLException e) {
            System.out.println("Lỗi A-05: " + e.getMessage());
            return null;
        }
    }

    public int selectIdByName(String tenSanPham) {
        String sql = "select id from sanpham where tenSanPham=?";
        try {
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareCall(sql);
            preparedStatement.setString(1, tenSanPham);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt("id");
            }
            return -1;
        } catch (SQLException e) {
            return -1;
        }
    }

    public int ktrThuocTinh(int idNSX, int idChatLieu, int idDanhMuc) {
        String sql = "select id from sanpham where idnsx=? and idchatlieu=? and iddanhmuc=?";
        try {
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareCall(sql);
            preparedStatement.setInt(1, idNSX);
            preparedStatement.setInt(2, idChatLieu);
            preparedStatement.setInt(3, idDanhMuc);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                return resultSet.getInt("id");
            }
            return -1;
        } catch (SQLException e) {
            return -1;
        }
    }

    public int soDongData() {
        String sql = "select count(*) as soDong from sanpham where trangThai=1";
        try {
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareCall(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("soDong") % 50 != 0) {
                    return resultSet.getInt("soDong") / 50 + 1;
                } else {
                    return resultSet.getInt("soDong") / 50;
                }
            }
            return -1;
        } catch (SQLException e) {
            return -1;
        }
    }
    
    

}
