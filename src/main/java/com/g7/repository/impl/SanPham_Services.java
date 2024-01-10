package com.g7.repository.impl;

import com.g7.entity.SanPham;
import com.g7.repository.G7Repository;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

public class SanPham_Services extends G7Repository {

    private Connection connect = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    @Override
    public void insert(Object entity) {
    }

    @Override
    public void update(Object entity) {
    }

    @Override
    public void delete(Object id) {
    }

    @Override
    public List selectAll() {
        ArrayList list = new ArrayList();
        String sql = "";
        try {
            
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Object selectById(Object id) {
        ArrayList list = new ArrayList();
        String sql = "";
        try {
            
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public List selectBySql(String sql, Object... args) {
        ArrayList list = new ArrayList();
        try {
            
        } catch (Exception e) {
        }
        return list;
    }

}
