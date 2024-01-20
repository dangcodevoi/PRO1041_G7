/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.g7.view;

import com.g7.entity.HoaDon;
import com.g7.entity.HoaDonChiTiet;
import com.g7.entity.SanPhamChiTiet;
import com.g7.repository.impl.BanHangRepository;
import com.g7.viewmodel.CTSPBanHangViewModel;
import com.g7.viewmodel.GioHangViewModel;
import com.g7.viewmodel.HoaDonViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ddawng
 */
public class BanHangJPanel extends javax.swing.JPanel {

    private BanHangRepository BHRepo = new BanHangRepository();
    private DefaultTableModel defaultTableModelSP = new DefaultTableModel();
    private DefaultTableModel defaultTableModelGH = new DefaultTableModel();
    private DefaultTableModel defaultTableModelHDC = new DefaultTableModel();
    private List<CTSPBanHangViewModel> listSP = new ArrayList<>();
    private List<HoaDonViewModel> listHD = new ArrayList<>();
    private List<GioHangViewModel> listGH = new ArrayList<>();

    private int ht = 1;
    private int size = 100;
    private int htHDC = 1;

    public BanHangJPanel() {
        initComponents();
        FindDataSP(0, size);
        FindDataHDC(0, size);
        updatePageInfo();
        updatePageInfoHDC();
    }

    public void FindDataSP(int ht, int size) {
        List<CTSPBanHangViewModel> list = BHRepo.selectWithPagination(ht, size);
        defaultTableModelSP.setRowCount(0);
        defaultTableModelSP = (DefaultTableModel) tbSP.getModel();
        for (CTSPBanHangViewModel x : list) {
            defaultTableModelSP.addRow(new Object[]{
                x.getId(), x.getMasp(), x.getTensp(), x.getKichco(), x.getMausac(), x.getDanhmuc(), x.getNsx(), x.getSoluong(), x.getGiaban()
            });
        }
    }

    public void FindDataGH(int id) {
        List<GioHangViewModel> list = BHRepo.selectWithPaginationGH(id);
        defaultTableModelGH.setRowCount(0);
        defaultTableModelGH = (DefaultTableModel) tbGH.getModel();
        for (GioHangViewModel x : list) {
            defaultTableModelGH.addRow(new Object[]{
                x.getMasp(), x.getTensp(), x.getSoluong(), x.getDongia()
            });
        }
    }

    public void FindDataHDC(int ht, int size) {
        List<HoaDonViewModel> list = BHRepo.selectWithPaginationHDC(ht, size);
        defaultTableModelHDC.setRowCount(0);
        defaultTableModelHDC = (DefaultTableModel) tbHDC.getModel();
        for (HoaDonViewModel x : list) {
            defaultTableModelHDC.addRow(new Object[]{
                x.getMahd(), x.getTenNV(), x.getNgayTao(), x.getTenKH(), x.trangThai(x.getTrangThai())
            });
        }
    }

    private void updatePageInfo() {
        int totalItems = BHRepo.getTotalItems();
        int maxPage = (int) Math.ceil((double) totalItems / size);

        if (ht > maxPage) {
            ht = (maxPage == 0) ? 1 : maxPage;
        }

        lblPageSP.setText(ht + " / " + maxPage);
    }

    private void updatePageInfoHDC() {
        int totalItems = BHRepo.getTotalItemsHDC();
        int maxPage = (int) Math.ceil((double) totalItems / size);

        if (htHDC > maxPage) {
            htHDC = (maxPage == 0) ? 1 : maxPage;
        }

        lblPageHDC.setText(htHDC + " / " + maxPage);
    }

    public void PageLast() {
        int totalItems = BHRepo.getTotalItemsHDC();
        int lastPage = (int) Math.ceil((double) totalItems / size);
        htHDC = lastPage;
        int page = (htHDC - 1) * size;
        FindDataHDC(page, size);
        updatePageInfoHDC();
    }

    private void deleteSPinGH() {
        int rowHD = tbHDC.getSelectedRow();
        int rowGH = tbGH.getSelectedRow();
//        int rowSP = tbSP.getSelectedRow();
        if (rowGH < 0) {
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm muốn xóa khỏi giỏ hàng");
        } else {

            int tempTT = JOptionPane.showOptionDialog(this, "Bạn có chắc muốn xóa sản phẩm khỏi giỏ hàng không ?", "Xóa sản phẩm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (tempTT == JOptionPane.YES_OPTION) {
                String maSP = tbGH.getValueAt(rowGH, 0).toString();
                int SLtrongGH = Integer.parseInt(tbGH.getValueAt(rowGH, 2).toString());
                int SLTrongCTSP = BHRepo.TongSLTrongCTSP(maSP);
                int tongSP = SLTrongCTSP + SLtrongGH;
                SanPhamChiTiet sp = new SanPhamChiTiet(tongSP);
                BHRepo.updateSoLuongTM(sp, maSP);
                int idHD = BHRepo.selectByMa(tbHDC.getValueAt(rowHD, 0).toString());
                System.out.println(idHD);
                JOptionPane.showMessageDialog(this, BHRepo.updateHoaDonChiTietTrangThai(idHD));
//                FindDataGH(idHD);
            }
        }

    }

    private void updateSPGH() {
        int rowHD = tbHDC.getSelectedRow();
        int row = tbSP.getSelectedRow();
        int rowGH = tbGH.getSelectedRow();

        if (rowHD < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn thêm sản phẩm");
        } else {
            String soLuongMoi = JOptionPane.showInputDialog("Mời nhập số lượng cần cập nhật: ");
            if (soLuongMoi != null) {
                if (!soLuongMoi.matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(this, "Nhập đúng định dạng");
                } else {
                    int slHienTai = Integer.parseInt(tbGH.getValueAt(row, 2).toString());
                    int slGH = Integer.parseInt(tbGH.getValueAt(row, 7).toString());
                    int SoLuongTong = slHienTai + slGH;
                    if (SoLuongTong < Integer.parseInt(soLuongMoi)) {
                        JOptionPane.showMessageDialog(this, "Sản phẩm không đủ số lượng");
                    } else {
                        SanPhamChiTiet sp = new SanPhamChiTiet(Integer.parseInt(soLuongMoi));
                        int idSP = BHRepo.selectIdByMaSP(tbGH.getValueAt(rowGH, 0).toString());
                        BHRepo.updateSoLuong(sp, idSP);
                        
                    }
                    GioHangViewModel gh = new GioHangViewModel();
                    gh.setSoluong(Integer.parseInt(soLuongMoi));
                    listGH.add(gh);
                    int idHD = BHRepo.selectByMa(tbHDC.getValueAt(rowHD, 0).toString());
                    FindDataGH(idHD);
                }
            }
        }
    }

    private void insertGH() {
        int rowHD = tbHDC.getSelectedRow();
        int row = tbSP.getSelectedRow();

        CTSPBanHangViewModel sp = new CTSPBanHangViewModel();
        String SLInTableSP = tbSP.getValueAt(row, 7).toString();
        if (rowHD < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn thêm sản phẩm");
        } else {
            String soLuong = JOptionPane.showInputDialog("Mời bạn nhập số lượng: ");

            if (soLuong != null) {
                if (!soLuong.matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng dịnh dangk");
                } else if (Integer.parseInt(soLuong) > Integer.parseInt(SLInTableSP)) {
                    JOptionPane.showMessageDialog(this, "Số lượng vượt quá");
                } else {
                    String masp = tbSP.getValueAt(row, 1).toString();
                    String tenSP1 = Objects.toString(tbSP.getValueAt(row, 2), "");
                    double donGia = Double.parseDouble(tbSP.getValueAt(row, 8).toString());
                    GioHangViewModel gh = new GioHangViewModel();
                    gh.setSoluong(Integer.parseInt(soLuong));
                    gh.setMasp(masp);
                    gh.setTensp(tenSP1);
                    gh.setDongia(donGia);

                    boolean trung = false;
                    int i = 0;
                    for (GioHangViewModel x : listGH) {
                        i++;
                        if (x.getMasp().contains(masp)) {
                            trung = true;
                        }
                    }
                    if (trung) {
                        JOptionPane.showMessageDialog(this, "Sản phẩm đã có trong giỏ hàng");
                    } else {
                        listGH.add(gh);
                        int TSL = Integer.parseInt(tbSP.getValueAt(row, 7).toString());
                        sp.setSoluong(TSL - Integer.parseInt(soLuong));

                        int idHD = BHRepo.selectByMa(tbHDC.getValueAt(rowHD, 0).toString());
                        int idSP = Integer.parseInt(tbSP.getValueAt(row, 0).toString());
                        int soLuong1 = Integer.parseInt(soLuong);
                        double dongia1 = Double.parseDouble(tbSP.getValueAt(row, 8).toString());

                        HoaDonChiTiet hdct = new HoaDonChiTiet(idHD, idSP, soLuong1, donGia);
                        JOptionPane.showMessageDialog(this, BHRepo.addHDCT(hdct));

                        SanPhamChiTiet sp1 = new SanPhamChiTiet(sp.getSoluong());
                        BHRepo.updateSoLuong(sp1, idSP);

                        FindDataGH(idHD);

                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbHDC = new javax.swing.JTable();
        btnLastHDC = new javax.swing.JButton();
        btnNextHDC = new javax.swing.JButton();
        lblPageHDC = new javax.swing.JLabel();
        btnPreHDC = new javax.swing.JButton();
        btnFirstHDC = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbGH = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSP = new javax.swing.JTable();
        btnPre = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        lblPageSP = new javax.swing.JLabel();
        btnAddToCart = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblTienKhachDUa = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lblMaKH = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbHTTT = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        lblTT = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnTaoHD = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn chờ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tbHDC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "Nhân viên tạo", "Ngày tạo", "Khách hàng", "Trạng thái"
            }
        ));
        tbHDC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHDCMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbHDC);

        btnLastHDC.setText(">|");
        btnLastHDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastHDCActionPerformed(evt);
            }
        });

        btnNextHDC.setText(">>");
        btnNextHDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextHDCActionPerformed(evt);
            }
        });

        lblPageHDC.setText("?");

        btnPreHDC.setText("<<");
        btnPreHDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreHDCActionPerformed(evt);
            }
        });

        btnFirstHDC.setText("|<");
        btnFirstHDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstHDCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnFirstHDC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPreHDC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPageHDC, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNextHDC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLastHDC)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPreHDC)
                    .addComponent(btnFirstHDC)
                    .addComponent(btnNextHDC)
                    .addComponent(btnLastHDC)
                    .addComponent(lblPageHDC))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giỏ hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tbGH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng", "Đơn giá"
            }
        ));
        jScrollPane3.setViewportView(tbGH);

        jButton6.setText("Xóa");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Sửa");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tbSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã SP", "Tên SP", "Kích cỡ", "Màu sắc", "Danh mục", "NSX", "Số lượng", "Giá bán"
            }
        ));
        tbSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSP);

        btnPre.setText("<<");
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        lblPageSP.setText("?");

        btnAddToCart.setText("+");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPageSP, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddToCart)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnAddToCart)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPre)
                    .addComponent(btnFirst)
                    .addComponent(btnNext)
                    .addComponent(btnLast)
                    .addComponent(lblPageSP))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Mã khách hàng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Tên khách hàng");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Mã hóa đơn");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Ngày tạo");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Tổng tiền");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Giảm giá");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Thanh toán");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Hình thức thanh toán");

        lblTienKhachDUa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTienKhachDUa.setText("Tiền khách đưa");

        lblTienThua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTienThua.setText("Tiền thừa");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Ghi chú");

        txtTienKhachDua.setText("0");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        lblMaKH.setText("KH001");

        jLabel13.setText("Khách vãng lai");

        jLabel14.setText("HD++");

        jLabel15.setText("Date");

        jLabel16.setText("0");

        cbHTTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển khoản" }));
        cbHTTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbHTTTMouseClicked(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel17.setText("0");

        lblTT.setText("0");

        jButton1.setText("Thanh toán");

        jButton2.setText("Hủy hóa đơn");

        jButton3.setText("Làm mới");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnTaoHD.setText("Tạo Hóa đơn");
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        jButton5.setText("Chọn");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(49, 49, 49)
                        .addComponent(jButton2)
                        .addGap(37, 37, 37)
                        .addComponent(jButton3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(lblTienThua)
                            .addComponent(jLabel11)
                            .addComponent(lblTienKhachDUa))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTT)
                            .addComponent(jLabel17)
                            .addComponent(cbHTTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTaoHD)
                                .addGap(48, 48, 48))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblMaKH)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5)
                                .addGap(22, 22, 22)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblMaKH)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel14)
                    .addComponent(btnTaoHD))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(cbHTTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTienKhachDUa)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTienThua)
                    .addComponent(lblTT))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

        int TotalItime = BHRepo.getTotalItems();
        int TotalPage = TotalItime / size;

        if (ht <= TotalPage) {
            ht++;
            int page = (ht - 1) * size;
            FindDataSP(page, size);
            updatePageInfo();
            System.out.println(ht);
            System.out.println(page);

        } else {
            ht = 1;
            FindDataSP(0, size);
            updatePageInfo();
        }

    }//GEN-LAST:event_btnNextActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        ht = 1;
        FindDataSP(0, size);
        updatePageInfo();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        if (ht > 1) {
            ht--;
        }
        int page = (ht - 1) * size;
        FindDataSP(page, size);
        updatePageInfo();
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        int totalItems = BHRepo.getTotalItems();
        int lastPage = (int) Math.ceil((double) totalItems / size);
        ht = lastPage;
        int page = (ht - 1) * size;
        FindDataSP(page, size);
        updatePageInfo();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnFirstHDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstHDCActionPerformed
        htHDC = 1;
        FindDataHDC(0, size);
        updatePageInfoHDC();
    }//GEN-LAST:event_btnFirstHDCActionPerformed

    private void btnPreHDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreHDCActionPerformed
        if (htHDC > 1) {
            htHDC--;
        }
        int page = (htHDC - 1) * size;
        FindDataHDC(page, size);
        updatePageInfoHDC();
    }//GEN-LAST:event_btnPreHDCActionPerformed

    private void btnNextHDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextHDCActionPerformed
        int TotalItime = BHRepo.getTotalItemsHDC();
        int TotalPage = TotalItime / size;

        if (htHDC <= TotalPage) {
            htHDC++;
            int page = (htHDC - 1) * size;
            FindDataHDC(page, size);
            updatePageInfoHDC();
            System.out.println(htHDC);
            System.out.println(page);

        } else {
            htHDC = 1;
            FindDataHDC(0, size);
            updatePageInfoHDC();
        }
    }//GEN-LAST:event_btnNextHDCActionPerformed

    private void btnLastHDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastHDCActionPerformed
        PageLast();
    }//GEN-LAST:event_btnLastHDCActionPerformed

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed
        HoaDon hd = new HoaDon();
        Random random = new Random();
        int min = 10000;
        int max = 100000;
        int soHD = random.nextInt(max - min + 1) + min;
        String MaHd = "HD" + soHD;
        hd.setMaHD(MaHd);
        hd.setIdNhanVien("1");
        int idKH = BHRepo.selectIdByMaKH(lblMaKH.getText());
        hd.setIdKhachHang(String.valueOf(idKH));
        BHRepo.addHoaDon(hd);
        PageLast();
        JOptionPane.showMessageDialog(this, "Tạo hóa đơn chờ thành công");
    }//GEN-LAST:event_btnTaoHDActionPerformed

    private void tbHDCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHDCMouseClicked
        int row = tbHDC.getSelectedRow();
        String Mahd = tbHDC.getValueAt(row, 0).toString();
        int id = BHRepo.selectByMa(Mahd);
        FindDataGH(id);
    }//GEN-LAST:event_tbHDCMouseClicked

    private void tbSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSPMouseClicked

    }//GEN-LAST:event_tbSPMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbHTTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbHTTTMouseClicked
        if (cbHTTT.getSelectedItem().equals("Tiền mặt")) {
            lblTienKhachDUa.setVisible(true);
            lblTT.setVisible(true);
            txtTienKhachDua.setVisible(true);
            lblTienThua.setVisible(true);
        } else {
            lblTienKhachDUa.setVisible(false);
            lblTT.setVisible(false);
            txtTienKhachDua.setVisible(false);
            lblTienThua.setVisible(false);
        }
    }//GEN-LAST:event_cbHTTTMouseClicked

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        insertGH();
        FindDataSP(0, size);

    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        deleteSPinGH();
        FindDataSP(0, size);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        updateSPGH();
        FindDataSP(0, size);

    }//GEN-LAST:event_jButton7MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnFirstHDC;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLastHDC;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNextHDC;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnPreHDC;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JComboBox<String> cbHTTT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblMaKH;
    private javax.swing.JLabel lblPageHDC;
    private javax.swing.JLabel lblPageSP;
    private javax.swing.JLabel lblTT;
    private javax.swing.JLabel lblTienKhachDUa;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JTable tbGH;
    private javax.swing.JTable tbHDC;
    private javax.swing.JTable tbSP;
    private javax.swing.JTextField txtTienKhachDua;
    // End of variables declaration//GEN-END:variables
}
