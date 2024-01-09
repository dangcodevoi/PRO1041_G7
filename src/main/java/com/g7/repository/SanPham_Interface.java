package com.g7.repository;

import com.g7.interfacee.*;
import com.g7.entity.SanPham;
import java.util.ArrayList;

public interface SanPham_Interface {

    public ArrayList<SanPham> danhSachSanPham();

    public int themSanPham();

    public int suaSanPham();

    public int xoaSanPham();
}
