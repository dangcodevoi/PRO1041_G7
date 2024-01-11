/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g7.repository.impl;

import com.g7.utils.JdbcHelper;
import com.g7.viewmodel.CTSPBanHangViewModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ddawng
 */
public class BanHangRepository {

//    String select_all_sp = "SELECT dbo.ChiTietSanPham.Id, dbo.ChiTietSanPham.MaSanPham, dbo.SanPham.TenSanPham, dbo.KichCo.KichCo, dbo.MauSac.TenMauSac, dbo.DanhMuc.TenDanhMuc, dbo.NSX.TenNSX, dbo.ChiTietSanPham.SoLuong, \n"
//            + "                  dbo.ChiTietSanPham.GiaBan\n"
//            + "FROM     dbo.ChiTietSanPham INNER JOIN\n"
//            + "                  dbo.DanhMuc ON dbo.ChiTietSanPham.Id = dbo.DanhMuc.Id INNER JOIN\n"
//            + "                  dbo.HinhAnh ON dbo.ChiTietSanPham.IdHinhAnh = dbo.HinhAnh.Id INNER JOIN\n"
//            + "                  dbo.KichCo ON dbo.ChiTietSanPham.IdKichCo = dbo.KichCo.Id INNER JOIN\n"
//            + "                  dbo.MauSac ON dbo.ChiTietSanPham.IdMauSac = dbo.MauSac.Id INNER JOIN\n"
//            + "                  dbo.NSX ON dbo.ChiTietSanPham.Id = dbo.NSX.Id INNER JOIN\n"
//            + "                  dbo.SanPham ON dbo.ChiTietSanPham.IdSanPham = dbo.SanPham.Id\n"
//            + "				  WHERE ChiTietSanPham.TrangThai = 1		  \n"
//            + "				  ORDER BY ID \n"
//            + "				  OFFSET 0 ROWS \n"
//            + "				  FETCH NEXT 100 ROWS ONLY;";
    String select_Pagination_sp = "SELECT dbo.ChiTietSanPham.Id, dbo.ChiTietSanPham.MaSanPham, dbo.SanPham.TenSanPham, dbo.KichCo.KichCo, dbo.MauSac.TenMauSac, dbo.DanhMuc.TenDanhMuc, dbo.NSX.TenNSX, dbo.ChiTietSanPham.SoLuong, \n"
            + "                  dbo.ChiTietSanPham.GiaBan\n"
            + "FROM     dbo.ChiTietSanPham INNER JOIN\n"
            + "                  dbo.DanhMuc ON dbo.ChiTietSanPham.Id = dbo.DanhMuc.Id INNER JOIN\n"
            + "                  dbo.HinhAnh ON dbo.ChiTietSanPham.IdHinhAnh = dbo.HinhAnh.Id INNER JOIN\n"
            + "                  dbo.KichCo ON dbo.ChiTietSanPham.IdKichCo = dbo.KichCo.Id INNER JOIN\n"
            + "                  dbo.MauSac ON dbo.ChiTietSanPham.IdMauSac = dbo.MauSac.Id INNER JOIN\n"
            + "                  dbo.NSX ON dbo.ChiTietSanPham.Id = dbo.NSX.Id INNER JOIN\n"
            + "                  dbo.SanPham ON dbo.ChiTietSanPham.IdSanPham = dbo.SanPham.Id\n"
            + "				  WHERE ChiTietSanPham.TrangThai = 1		  \n"
            + "				  ORDER BY ID \n"
            + "				  OFFSET ? ROWS \n"
            + "				  FETCH NEXT ? ROWS ONLY;";

    String TotalItems_sp = "SELECT COUNT(*) FROM dbo.ChiTietSanPham WHERE ChiTietSanPham.TrangThai = 1";

//    public List<CTSPBanHangViewModel> selectBySqlSP(String sql, Object... args) {
//        List<CTSPBanHangViewModel> list = new ArrayList<>();
//        try {
//            ResultSet rs = JdbcHelper.query(sql, args);
//            while (rs.next()) {
//                CTSPBanHangViewModel entity = new CTSPBanHangViewModel();
//                entity.setId(rs.getString(1));
//                entity.setMasp(rs.getString(2));
//                entity.setTensp(rs.getString(3));
//                entity.setKichco(rs.getString(4));
//                entity.setMausac(rs.getString(5));
//                entity.setDanhmuc(rs.getString(6));
//                entity.setNsx(rs.getString(7));
//                entity.setSoluong(rs.getInt(8));
//                entity.setGiaban(rs.getDouble(9));
//                list.add(entity);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return list;
//    }
//    public List<CTSPBanHangViewModel> getAllSP() {
//        return selectBySqlSP(select_all_sp);
//    }
    public List<CTSPBanHangViewModel> selectWithPagination(int offset, int fetchSize) {

        String sql = select_Pagination_sp;

        List<CTSPBanHangViewModel> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, offset, fetchSize);
            while (rs.next()) {
                CTSPBanHangViewModel entity = new CTSPBanHangViewModel();
                entity.setId(rs.getString(1));
                entity.setMasp(rs.getString(2));
                entity.setTensp(rs.getString(3));
                entity.setKichco(rs.getString(4));
                entity.setMausac(rs.getString(5));
                entity.setDanhmuc(rs.getString(6));
                entity.setNsx(rs.getString(7));
                entity.setSoluong(rs.getInt(8));
                entity.setGiaban(rs.getDouble(9));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public int getTotalItems() {
        int totalItems = 0;

        try {
            ResultSet rs = JdbcHelper.query(TotalItems_sp);

            if (rs.next()) {
                totalItems = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();  
        }

        return totalItems;
    }

}
