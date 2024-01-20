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
                + "                         CTS.MoTa,\n"
                + "                         CTS.MaSanPham"
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
                + "                     OFFSET " + (indexOffset * 5) + "0 ROWS\n"
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
                        resultSet.getInt("GiaBan"),
                        resultSet.getInt("SoLuong"),
                        resultSet.getString("TenSanPham"),
                        resultSet.getString("TenHinhAnh"),
                        resultSet.getString("TenMauSac"),
                        resultSet.getString("MoTa"),
                        resultSet.getString("KichCo"),
                        resultSet.getString("MaSanPham")
                ));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Lỗi B-01: " + e.getMessage());
            return null;
        }
    }

    public SanPhamChiTiet selectById(int id) {
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
                + "                         CTS.MoTa,\n"
                + "                         CTS.MaSanPham"
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
                + "                         CTS.TrangThai = 1 and CTS.id=\n" + id
                + "                     ORDER BY\n"
                + "                         CTS.Id\n";
        try {
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            SanPhamChiTiet sp = null;
            while (resultSet.next()) {
                sp = new SanPhamChiTiet(
                        resultSet.getInt("SanPham_Id"),
                        resultSet.getInt("ChiTietSanPham_Id"),
                        resultSet.getInt("MauSac_Id"),
                        resultSet.getInt("KichCo_Id"),
                        resultSet.getInt("GiaBan"),
                        resultSet.getInt("SoLuong"),
                        resultSet.getString("TenSanPham"),
                        resultSet.getString("TenHinhAnh"),
                        resultSet.getString("TenMauSac"),
                        resultSet.getString("MoTa"),
                        resultSet.getString("KichCo"),
                        resultSet.getString("MaSanPham"));
            }
            return sp;
        } catch (SQLException e) {
            System.out.println("Lỗi B-01: " + e.getMessage());
            return null;
        }
    }

    @Override
    public int create(Object o) {
        String sql = "INSERT INTO ChiTietSanPham\n"
                + "           (IdSanPham\n"
                + "           ,IdKichCo\n"
                + "           ,IdMauSac\n"
                + "           ,IdHinhAnh\n"
                + "           ,GiaBan\n"
                + "           ,SoLuong\n"
                + "           ,MoTa"
                + "           ,MaSanPham)  \n"
                + "     VALUES "
                + "  (?,?,?,?,?,?,?,?)";
        try {
            SanPhamChiTiet sp = (SanPhamChiTiet) o;

            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setInt(1, sp.getIdSanPham());
            preparedStatement.setInt(2, sp.getIdKichThuoc());
            preparedStatement.setInt(3, sp.getIdMau());
            preparedStatement.setInt(4, 1);
            preparedStatement.setInt(5, sp.getGiaBan());
            preparedStatement.setInt(6, sp.getSoLuong());
            preparedStatement.setString(7, sp.getGhiChu());
            preparedStatement.setString(8, sp.getMaSanPham());

            preparedStatement.executeUpdate();
            return 0;
        } catch (SQLException e) {
            System.out.println("Lỗi B-02: " + e.getMessage());
            return 1;
        }
    }

    @Override
    public int update(Object o) {
        String sql = "update chitietsanpham set idsanpham=?,idkichco=?,idmausac=?,idhinhanh=?,giaban=?,soluong=?,mota=?,masanpham=? where id=?";
        try {
            SanPhamChiTiet sp = (SanPhamChiTiet) o;

            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setInt(1, sp.getIdSanPham());
            preparedStatement.setInt(2, sp.getIdKichThuoc());
            preparedStatement.setInt(3, sp.getIdMau());
            preparedStatement.setInt(4, 1);
            preparedStatement.setInt(5, sp.getGiaBan());
            preparedStatement.setInt(6, sp.getSoLuong());
            preparedStatement.setString(7, sp.getGhiChu());
            preparedStatement.setString(8, sp.getMaSanPham());
            preparedStatement.setInt(9, sp.getIdSanPhamCT());

            preparedStatement.executeUpdate();
            return 0;
        } catch (SQLException e) {
            System.out.println("Lỗi B-03:" + e.getMessage());
            return 1;
        }
    }

    @Override
    public int remove(int id) {
        String sql = "update chitietsanpham set trangthai=0 where id=" + id;
        try {

            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);

            preparedStatement.executeUpdate();
            return 0;
        } catch (SQLException e) {
            System.out.println("Lỗi B-04:" + e.getMessage());
            return 1;
        }
    }

    public int checkThuocTinhCT(int idSanPham, int idMau, int idKichThuoc) {
        String sql = "Select id from chitietsanpham where idSanPham=?,id mausac=?,idkichco=?;";
        try {
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setInt(1, idSanPham);
            preparedStatement.setInt(1, idMau);
            preparedStatement.setInt(1, idKichThuoc);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                return resultSet.getInt("id");
            }
            return -1;
        } catch (SQLException e) {
            System.out.println("Lỗi B-06:" + e.getMessage());
            return -1;
        }
    }
}
