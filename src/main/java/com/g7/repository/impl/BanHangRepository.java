/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g7.repository.impl;

import com.g7.entity.HoaDon;
import com.g7.entity.HoaDonChiTiet;
import com.g7.entity.SanPhamChiTiet;
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
            + "FROM     dbo.ChiTietSanPham LEFT JOIN\n"
            + "                  dbo.DanhMuc ON dbo.ChiTietSanPham.Id = dbo.DanhMuc.Id LEFT JOIN\n"
            + "                  dbo.HinhAnh ON dbo.ChiTietSanPham.IdHinhAnh = dbo.HinhAnh.Id LEFT JOIN\n"
            + "                  dbo.KichCo ON dbo.ChiTietSanPham.IdKichCo = dbo.KichCo.Id LEFT JOIN\n"
            + "                  dbo.MauSac ON dbo.ChiTietSanPham.IdMauSac = dbo.MauSac.Id LEFT JOIN\n"
            + "                  dbo.NSX ON dbo.ChiTietSanPham.Id = dbo.NSX.Id LEFT JOIN\n"
            + "                  dbo.SanPham ON dbo.ChiTietSanPham.IdSanPham = dbo.SanPham.Id\n"
            + "				  WHERE ChiTietSanPham.TrangThai = 1		  \n"
            + "				  ORDER BY ID \n"
            + "				  OFFSET ? ROWS \n"
            + "				  FETCH NEXT ? ROWS ONLY;";

    String TotalItems_sp = "SELECT COUNT(*)\n"
            + "FROM     dbo.ChiTietSanPham INNER JOIN\n"
            + "                  dbo.DanhMuc ON dbo.ChiTietSanPham.Id = dbo.DanhMuc.Id LEFT JOIN\n"
            + "                  dbo.HinhAnh ON dbo.ChiTietSanPham.IdHinhAnh = dbo.HinhAnh.Id LEFT JOIN\n"
            + "                  dbo.KichCo ON dbo.ChiTietSanPham.IdKichCo = dbo.KichCo.Id LEFT JOIN\n"
            + "                  dbo.MauSac ON dbo.ChiTietSanPham.IdMauSac = dbo.MauSac.Id LEFT JOIN\n"
            + "                  dbo.NSX ON dbo.ChiTietSanPham.Id = dbo.NSX.Id LEFT JOIN\n"
            + "                  dbo.SanPham ON dbo.ChiTietSanPham.IdSanPham = dbo.SanPham.Id\n"
            + "				  WHERE ChiTietSanPham.TrangThai = 1";

    String select_Pagination_hdc = " SELECT dbo.HoaDon.MaHD, dbo.NhanVien.TenNhanVien, dbo.HoaDon.NgayTao, dbo.KhachHang.TenKhachHang, dbo.HoaDon.TrangThai, dbo.HoaDon.Id\n"
            + "FROM     dbo.HoaDon LEFT JOIN\n"
            + "                  dbo.KhachHang ON dbo.HoaDon.IdKhachHang = dbo.KhachHang.Id LEFT JOIN\n"
            + "                  dbo.NhanVien ON dbo.HoaDon.IdNhanVien = dbo.NhanVien.Id\n"
            + "				  WHERE HoaDon.TrangThai = 1\n"
            + "				  ORDER BY HoaDon.Id \n"
            + "				  OFFSET ? ROWS \n"
            + "				  FETCH NEXT ? ROWS ONLY";

//    String select_Pagination_gh = "	SELECT dbo.ChiTietSanPham.MaSanPham, dbo.SanPham.TenSanPham, dbo.HoaDonChiTiet.SoLuong, dbo.HoaDonChiTiet.DonGia\n"
//            + "FROM     dbo.HoaDonChiTiet LEFT JOIN\n"
//            + "                  dbo.HoaDon ON dbo.HoaDonChiTiet.IdHoaDon = dbo.HoaDon.Id Left JOIN\n"
//            + "                  dbo.SanPham ON dbo.HoaDonChiTiet.Id = dbo.SanPham.Id LEFT JOIN\n"
//            + "                  dbo.ChiTietSanPham ON dbo.HoaDonChiTiet.IdCTSanPham = dbo.ChiTietSanPham.Id\n"
//            + "				  WHERE HoaDon.Id LIKE ?\n"
//            + "				  ";
    String select_Pagination_gh = "SELECT dbo.ChiTietSanPham.MaSanPham, dbo.SanPham.TenSanPham, dbo.HoaDonChiTiet.SoLuong, dbo.HoaDonChiTiet.DonGia\n"
            + "FROM dbo.HoaDonChiTiet\n"
            + "LEFT JOIN dbo.HoaDon ON dbo.HoaDonChiTiet.IdHoaDon = dbo.HoaDon.Id\n"
            + "LEFT JOIN dbo.ChiTietSanPham ON dbo.HoaDonChiTiet.IdCTSanPham = dbo.ChiTietSanPham.Id\n"
            + "LEFT JOIN dbo.SanPham ON dbo.ChiTietSanPham.IdSanPham = dbo.SanPham.Id\n"
            + "WHERE dbo.HoaDon.Id = ? and dbo.HoaDonChiTiet.trangthai = 1";

    String TotalItimeHDC = " 	  SELECT COUNT(*)\n"
            + "            FROM     dbo.HoaDon LEFT JOIN\n"
            + "                              dbo.KhachHang ON dbo.HoaDon.IdKhachHang = dbo.KhachHang.Id LEFT JOIN\n"
            + "                           dbo.NhanVien ON dbo.HoaDon.IdNhanVien = dbo.NhanVien.Id\n"
            + "            			  WHERE HoaDon.TrangThai = 1";
    String select_byMaHd = "SELECT Id FROM dbo.HoaDon WHERE MaHD = ?";
    String Insert_hd = "INSERT INTO hoadon (IdNhanVien, IdKhachHang, MaHD) VALUES (?,?,?)";
    String select_byKH = " SELECT id FROM dbo.KhachHang WHERE MaKhachHang = ? ";
    String updateSoLuong = "UPDATE ChiTietSanPham SET SoLuong = ? WHERE Id = ?";
    String selectID_byMaSP = "SELECT id FROM chitietsanpham WHERE masanpham = ?";
    String updateSoLuongMA = "UPDATE ChiTietSanPham SET SoLuong = ? WHERE maSanPham = ?";
    String delete_giohang = "update hoadonchitiet set TrangThai = 2 where id = ?";
//    String delete_giohang = "delete hoadonchitiet where id = ?";
    String TotalSL = "select soluong from chitietsanpham where masanpham = ?";

    public List<GioHangViewModel> selectWithPaginationGH(int id) {
        String sql = select_Pagination_gh;

        List<GioHangViewModel> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, id);
            while (rs.next()) {
                GioHangViewModel entity = new GioHangViewModel();
                entity.setMasp(rs.getString(1));
                entity.setTensp(rs.getString(2));
                System.out.println("Value of TenSanPham: " + rs.getString(2));
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

    public int selectIdByMaKH(String makh) {
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

    public String updateSoLuong(SanPhamChiTiet ctsp, int id) {
        try (Connection con = JdbcHelper.openDbConnection(); PreparedStatement ps = con.prepareStatement(updateSoLuong)) {
            ps.setObject(1, ctsp.getSoLuong());
            ps.setObject(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String updateSoLuongTM(SanPhamChiTiet ctsp, String ma) {
        try (Connection con = JdbcHelper.openDbConnection(); PreparedStatement ps = con.prepareStatement(updateSoLuongMA)) {
            ps.setObject(1, ctsp.getSoLuong());
            ps.setObject(2, ma);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public int selectIdByMaSP(String maSP) {
        int id = 0;

        try {
            ResultSet rs = JdbcHelper.query(selectID_byMaSP, maSP);

            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public int TongSLTrongCTSP(String maSP) {
        int id = 0;

        try {
            ResultSet rs = JdbcHelper.query(TotalSL, maSP);

            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
    
      public String updateSoLuong2(SanPhamChiTiet ctsp, int id) {
        try (Connection con = JdbcHelper.openDbConnection(); PreparedStatement ps = con.prepareStatement(updateSoLuong)) {
            ps.setObject(1, ctsp.getSoLuong());
            ps.setObject(2, id);
            
             if (ps.executeUpdate() > 0) {
                return "Sửa thành công";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Sửa không thành công";
    }

    public String addHDCT(HoaDonChiTiet hdct) {
        String sql = "INSERT INTO HoaDonChiTiet(IdHoaDon,IdCTSanPham,SoLuong, DonGia) VALUES (?,?,?,?)";
        try (Connection con = JdbcHelper.openDbConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, hdct.getIdHoaDon());
            ps.setObject(2, hdct.getIdCtSanPham());
            ps.setObject(3, hdct.getSoLuong());
            ps.setObject(4, hdct.getDonGia());

            if (ps.executeUpdate() > 0) {
                return "Thêm hóa đơn ct thành công";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Thêm hóa đơn ct thất bại";
    }

    public String deleteGioHang(int id) {
        try (Connection con = JdbcHelper.openDbConnection(); PreparedStatement ps = con.prepareStatement(delete_giohang)) {
            ps.setObject(1, id);

            if (ps.executeUpdate() > 0) {
                return "Xóa sản phẩm thành công";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Để xác nhận vui lòng chọn lại sản phẩm cần xóa";
    }
    private static final String UPDATE_HOADONCHITIET_TRANGTHAI = "UPDATE hoadonchitiet SET TrangThai = 2 WHERE id = ?";

    public String updateHoaDonChiTietTrangThai(int id) {
        try (Connection con = JdbcHelper.openDbConnection(); PreparedStatement ps = con.prepareStatement(UPDATE_HOADONCHITIET_TRANGTHAI)) {
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return "Cập nhật trạng thái thành công";
            } else {
                return "Không tìm thấy hóa đơn chi tiết có ID tương ứng hoặc không có sự thay đổi";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Đã xảy ra lỗi khi cập nhật trạng thái hóa đơn chi tiết", e);
        }
    }
//    public String deleteSPInGH(int id) {
//        try (Connection con = JdbcHelper.openDbConnection(); PreparedStatement ps = con.prepareStatement(delete_giohang)) {
//            ps.setObject(1, id);
//            ps.executeUpdate();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return null;
//    }
}
