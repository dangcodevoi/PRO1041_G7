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
    private String MaHoaDon;
    private Date ngayTao;
    private Date ngayThanhToan;
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
