package com.g7.entity;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author Ddawng
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon {
<<<<<<< HEAD
    private int idHoaDon;
=======
    private String MaHoaDon;
>>>>>>> 5b9b17e85a82bd44a752415918c69d55b5b4cd37
    private Date ngayTao;
    private Date ngayThanhToan;
    private String idKhachHang;
    private String idNhanVien;
    private String maHD;
    private int tongTien;
    private int soTienGiam;
    private String ghiChu;
    private int trangThai;
    
    public String getTrangThaiLabel() {
        if (trangThai == 1) {
            return "Chưa thanh toán";
        } else {
            return "Đã thanh toán";
        }
    }
}
