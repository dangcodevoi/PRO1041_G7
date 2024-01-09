package com.g7.crud;

import com.g7.entity.SanPham;
import com.g7.interfacee.SanPham_Interface;
import java.util.ArrayList;
import java.sql.*;

public class SanPham_Services implements SanPham_Interface {

    private Connection connect = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    @Override
    public ArrayList<SanPham> danhSachSanPham() {
        ArrayList<SanPham> list= new ArrayList<>();
        
        String sql="SELECT * FROM SANPHAM WHERE";
        try {
            
        } catch (Exception e) {
        }
        
        return list;
    }

    @Override
    public int themSanPham() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int suaSanPham() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int xoaSanPham() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
