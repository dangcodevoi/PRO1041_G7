/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g7.repository.impl;

import com.g7.entity.HoaDonChiTiet;
import com.g7.entity.KhuyenMai;
import com.g7.repository.G7Repository;
import com.g7.utils.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hùng Nguyễn
 */
public class KhuyenMaiRepository extends G7Repository<KhuyenMai, Integer> {

    String INSERT_KM = "INSERT INTO KhuyenMai ([TenKhuyenMai], [MoTa], [KieuGiamGia], [MucGiamGia], [NgayBatDau], [NgayKetThuc]) VALUES (?,?,?,?,?,?)";
    String UPDATE_KM = "UPDATE KhuyenMai set TenKhuyenMai = ?, MoTa = ?, KieuGiamGia = ?, MucGiamGia = ?, NgayBatDau = ?, NgayKetThuc = ? Where Id = ?";
    String DELETE_KM = "UPDATE KhuyenMai set TrangThai = 0 where Id = ?";
    String SELECT_ALL_KM = "select * from KhuyenMai where TrangThai = '1'";
    String SELECT_BY_ID_SQL = "select * from KhuyenMai where TenKhuyenMai = ?";

    @Override
    public void insert(KhuyenMai entity) {
        JdbcHelper.update(INSERT_KM, entity.getTenKhuyenMai(), entity.getMoTa(), entity.isKieuGiamGia(), entity.getMucGiamGia(), entity.getNgayBatDau(), entity.getNgayKetThuc(), entity.getTrangThai());
    }

    @Override
    public void update(KhuyenMai entity) {
        JdbcHelper.update(UPDATE_KM, entity.getTenKhuyenMai(), entity.getMoTa(), entity.isKieuGiamGia(), entity.getMucGiamGia(), entity.getNgayBatDau(), entity.getNgayKetThuc(), entity.getTrangThai());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_KM, id);
    }

    @Override
    public List<KhuyenMai> selectAll() {
        return this.selectBySql(SELECT_ALL_KM);
    }

    @Override
    public KhuyenMai selectById(Integer id) {
        List<KhuyenMai> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhuyenMai> selectBySql(String sql, Object... args) {
        List<KhuyenMai> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setIDKhuyenMai(rs.getInt(1));
                km.setTenKhuyenMai(rs.getString(2));
                km.setMoTa(rs.getString(3));
                km.setKieuGiamGia(rs.getBoolean(4));
                km.setMucGiamGia(rs.getDouble(5));
                km.setNgayBatDau(rs.getDate(6));
                km.setNgayKetThuc(rs.getDate(7));
//                km.setTrangThai(rs.getInt(8));
                list.add(km);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void update21(String entity) {
        JdbcHelper.update(DELETE_KM, entity);
    }

    public String addKM(KhuyenMai km) {
        String sql = "Insert into khuyenmai(TenKhuyenMai, Mota, kieuGiamGia, MucGiamGia, NgayBatdau, NgayKetThuc)\n"
                + "					values (?,?,?,?,?,?)";
        try (Connection con = JdbcHelper.openDbConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, km.getTenKhuyenMai());
            ps.setObject(2, km.getMoTa());
            ps.setObject(3, km.isKieuGiamGia());
            ps.setObject(4, km.getMucGiamGia());
            ps.setObject(5, km.getNgayBatDau());
            ps.setObject(6, km.getNgayKetThuc());


            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String updateKM(KhuyenMai km, int ma){
        String sql = "UPDATE KhuyenMai set TenKhuyenMai = ?, MoTa = ?, KieuGiamGia = ?, MucGiamGia = ?, NgayBatDau = ?, NgayKetThuc = ? Where Id = ?";
        try (Connection con = JdbcHelper.openDbConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setObject(1, km.getTenKhuyenMai());
            ps.setObject(2, km.getMoTa());
            ps.setObject(3, km.isKieuGiamGia());
            ps.setObject(4, km.getMucGiamGia());
            ps.setObject(5, km.getNgayBatDau());
            ps.setObject(6, km.getNgayKetThuc());
            ps.setObject(7, ma);
            
            
        } catch (Exception e) {
        }
        return null;
    }

}
