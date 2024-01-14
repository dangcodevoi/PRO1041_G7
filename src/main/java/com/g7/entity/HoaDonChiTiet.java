     
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
    private int idHoaDon;
    private int idCtSanPham;
    private int soLuong;
    private int donGia;
    private int trangThai;
    
}
