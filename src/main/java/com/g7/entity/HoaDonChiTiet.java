     
package com.g7.entity;
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
public class HoaDonChiTiet {
    private int id;
    private int idHoaDon;
    private int idCtSanPham;
    private int soLuong;
    private Double donGia;
    private int trangThai;

    public HoaDonChiTiet(int idHoaDon, int idCtSanPham, int soLuong, Double donGia, int trangThai) {
        this.idHoaDon = idHoaDon;
        this.idCtSanPham = idCtSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.trangThai = trangThai;
    }
    
    
    
}


