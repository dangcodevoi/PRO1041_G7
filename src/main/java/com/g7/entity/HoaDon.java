
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
    private int idHoaDon;
    private Date ngayTao;
    private Date ngayThanhToan;
    private String idKhachHang;
    private String idNhanVien;
    private String maHD;
    private int tongTien;
    private int soTienGiam;
    private String ghiChu;
    private int trangThai;
    
    
        public String trangThai(int trangthai){
        if(trangthai == 1){
            return "Chưa thanh toán";
        }else{
            return "Đã thanh toán";
        }
    }
}
