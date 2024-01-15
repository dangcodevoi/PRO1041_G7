/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g7.repository.impl;

import com.g7.entity.HoaDon;
import com.g7.utils.JdbcHelper;
import com.g7.viewmodel.CTSPBanHangViewModel;
import com.g7.viewmodel.GioHangViewModel;
import com.g7.viewmodel.HoaDonViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ddawng
 */
public class BanHangRepository {

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

    String select_Pagination_hdc = "SELECT dbo.HoaDon.MaHD, dbo.NhanVien.TenNhanVien, dbo.HoaDon.NgayTao, dbo.KhachHang.TenKhachHang, HoaDon.TrangThai, HoaDon.Id\n"
            + "FROM     dbo.HoaDon INNER JOIN\n"
            + "                  dbo.HoaDonChiTiet ON dbo.HoaDon.Id = dbo.HoaDonChiTiet.IdHoaDon INNER JOIN\n"
            + "                  dbo.KhachHang ON dbo.HoaDon.IdKhachHang = dbo.KhachHang.Id INNER JOIN\n"
            + "                  dbo.NhanVien ON dbo.HoaDon.IdNhanVien = dbo.NhanVien.Id\n"
            + "				  WHERE HoaDonChiTiet.TrangThai = 1		  \n"
            + "				  ORDER BY HoaDon.Id \n"
            + "				  OFFSET ? ROWS \n"
            + "				  FETCH NEXT ? ROWS ONLY";

    String select_Pagination_gh = "	SELECT dbo.ChiTietSanPham.MaSanPham, dbo.SanPham.TenSanPham, dbo.HoaDonChiTiet.SoLuong, dbo.HoaDonChiTiet.DonGia\n"
            + "FROM     dbo.HoaDonChiTiet INNER JOIN\n"
            + "                  dbo.HoaDon ON dbo.HoaDonChiTiet.IdHoaDon = dbo.HoaDon.Id INNER JOIN\n"
            + "                  dbo.SanPham ON dbo.HoaDonChiTiet.Id = dbo.SanPham.Id INNER JOIN\n"
            + "                  dbo.ChiTietSanPham ON dbo.HoaDonChiTiet.IdCTSanPham = dbo.ChiTietSanPham.Id\n"
            + "				  WHERE HoaDon.Id LIKE ?\n"
            + "				  ORDER BY MaHD \n"
            + "				  OFFSET ? ROWS \n"
            + "				  FETCH NEXT ? ROWS ONLY";
    
    String TotalItimeHDC = "SELECT COUNT(*) FROM dbo.HoaDon";
    String select_byMaHd = "SELECT Id FROM dbo.HoaDon WHERE MaHD = ?";
    String Insert_hd = "INSERT INTO hoadon (IdNhanVien, IdKhachHang, MaHD) VALUES (?,?,?)";
    String select_byKH = " SELECT id FROM dbo.KhachHang WHERE MaKhachHang = ? ";

    public List<GioHangViewModel> selectWithPaginationGH(int id, int offset, int fetchSize) {
        String sql = select_Pagination_gh;

        List<GioHangViewModel> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, id, offset, fetchSize);
            while (rs.next()) {
                GioHangViewModel entity = new GioHangViewModel();
                entity.setMasp(rs.getString(1));
                entity.setTensp(rs.getString(2));
                entity.setSoluong(rs.getInt(3));
                entity.setDongia(rs.getDouble(4));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<HoaDonViewModel> selectWithPaginationHDC(int offset, int fetchSize) {
        String sql = select_Pagination_hdc;

        List<HoaDonViewModel> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, offset, fetchSize);
            while (rs.next()) {
                HoaDonViewModel entity = new HoaDonViewModel();
                entity.setMahd(rs.getString(1));
                entity.setTenNV(rs.getString(2));
                entity.setNgayTao(rs.getDate(3));
                entity.setTenKH(rs.getString(4));
                entity.setTrangThai(rs.getInt(5));
                entity.setIdhd(rs.getInt(6));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

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
    
    
    public int getTotalItemsHDC() {
        int totalItems = 0;

        try {
            ResultSet rs = JdbcHelper.query(TotalItimeHDC);

            if (rs.next()) {
                totalItems = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalItems;
    }
     public int selectByMa(String maHd) {
       int id = 0;

        try {
            ResultSet rs = JdbcHelper.query(select_byMaHd, maHd);

            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
    
    public List<HoaDonViewModel> selectBySql(String sql, Object... args) {
        List<HoaDonViewModel> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                HoaDonViewModel entity = new HoaDonViewModel();
                entity.setIdhd(rs.getInt(1));
                list.add(entity);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public int selectMaxIDHD() {
       int id = 0;
        String QuerymaxID = "SELECT MAX(id) FROM HoaDon";
        try {
            ResultSet rs = JdbcHelper.query(QuerymaxID);

            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
    
      
    public String selectByIdHD(int id) {
       String ma = null;
       
       String select_ByIDHD = "SELECT MaHD FROM dbo.HoaDon WHERE Id = ?";
        try {
            ResultSet rs = JdbcHelper.query(select_byKH, id);

            if (rs.next()) {
                ma = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ma;
    }
    
    public String addHoaDon(HoaDon hd) {
        try (Connection con = JdbcHelper.openDbConnection(); PreparedStatement ps = con.prepareStatement(Insert_hd)) {
            
//            String query = "SELECT MAX(MaHD) FROM HoaDon";
//            Statement statement = con.createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//            if (resultSet.next()) {
//                int maxID = resultSet.getInt(1);
//                if (maxID != null) {
//                    int maxMaHDNumber = Integer.parseInt(maxMaHD.replace("HD", ""));
//                    int nextMaHDNumber = maxMaHDNumber + 1;
//                    String nextMaHD = "HD" + String.format("%05d", nextMaHDNumber);
//                    hd.setMaHD(nextMaHD);
//                }
//            }

//            int idmax = selectMaxIDHD();
//            String maHD =  selectByIdHD(idmax);
//            if(maHD != null){
//                int maxMaHDNumber = Integer.parseInt(maHD.replace("HD", ""));
//                int nextMaHDNumber = maxMaHDNumber + 1;
//                String nextMaHD = "HD" + String.format("%03d", nextMaHDNumber);
//                System.out.println(nextMaHD);
//                hd.setMaHD(nextMaHD);
//            }

            ps.setObject(1, hd.getIdNhanVien());
            ps.setObject(2, hd.getIdKhachHang());
            ps.setObject(3, hd.getMaHD());
            if (ps.executeUpdate() > 0) {
                return "Thêm hóa đơn thành công";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Thêm hóa đơn thất bại";
    }
    
    
    public int selectIdByMaNV(String makh) {
       int id = 0;

        try {
            ResultSet rs = JdbcHelper.query(select_byKH, makh);

            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

}
