package com.g7.view;

import com.g7.entity.NhanVien;
import com.g7.repository.impl.NhanVienRepository;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class NhanVienJPanel extends javax.swing.JPanel {

    private NhanVienRepository NVrepo = new NhanVienRepository();
    private DefaultTableModel defaultTableModelKH = new DefaultTableModel();
    
    private int ht = 1;
    private int size = 100;
    
    public NhanVienJPanel() {
        initComponents();
        setOpaque(false);
        updatePageInfo();
        findWithPaginationNV(0, size);
    }
    
    public void findWithPaginationNV(int ht, int c) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        DecimalFormat f = new DecimalFormat("#,##0.##");
        List<NhanVien> list = NVrepo.selectWithPagination(ht, c);
        defaultTableModelKH.setRowCount(0);
        defaultTableModelKH = (DefaultTableModel) tbNhanVien.getModel();
        for (NhanVien x : list) {
            defaultTableModelKH.addRow(new Object[]{
                x.getIDNhanVien(), 
                x.getTenNhanVien(), 
                x.getGioiTinh(),
                df.format(x.getNgaySinh()), 
                x.getSDT(),
                x.getDiaChi(),
                x.getEmail(), 
                df.format(x.getNgayTao()),
                x.getMatKhau(),
                x.getChucVu(), 
                x.getTrangThai()
            });
        }
    }

    private void updatePageInfo() {
        int totalItems = NVrepo.getTotalItems();
        int maxPage = (int) Math.ceil((double) totalItems / size);

        if (ht > maxPage) {
            ht = (maxPage == 0) ? 1 : maxPage;
        }

        lbPresentPage.setText(ht + " / " + maxPage);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        tabNhanVien = new javax.swing.JTabbedPane();
        pnlNhanVien = new javax.swing.JPanel();
        bntLamMoi = new javax.swing.JButton();
        lbIDNhanVien = new javax.swing.JLabel();
        bntThem = new javax.swing.JButton();
        bntSua = new javax.swing.JButton();
        cbbTrangThai = new javax.swing.JComboBox<>();
        txtEmail = new javax.swing.JTextField();
        lbEmail = new javax.swing.JLabel();
        lbTrangThai = new javax.swing.JLabel();
        lbGhiChu = new javax.swing.JLabel();
        lbGioiTinh = new javax.swing.JLabel();
        lbSoDT = new javax.swing.JLabel();
        txtSoDT = new javax.swing.JTextField();
        ckbNam = new javax.swing.JCheckBox();
        ckbNu = new javax.swing.JCheckBox();
        txtDiaChi = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtIDNhanVien = new javax.swing.JTextField();
        lbHoTen = new javax.swing.JLabel();
        lbDiaChi = new javax.swing.JLabel();
        lbChucVu = new javax.swing.JLabel();
        ckbNhanVien = new javax.swing.JCheckBox();
        cbkQuanLy = new javax.swing.JCheckBox();
        lbMatKhau = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        SP2 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        lbQuanLyNhanVien = new javax.swing.JLabel();
        pnlDanhSachNV = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNhanVien = new javax.swing.JTable();
        bntTimKiem = new javax.swing.JButton();
        bntLastPage = new javax.swing.JButton();
        bntNextPage = new javax.swing.JButton();
        bntPrevPage = new javax.swing.JButton();
        bntFirstPage = new javax.swing.JButton();
        bntXoa = new javax.swing.JButton();
        lbPresentPage = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1083, 643));

        bntLamMoi.setText("Làm mới");
        bntLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLamMoiActionPerformed(evt);
            }
        });

        lbIDNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbIDNhanVien.setText("ID Nhân viên:");

        bntThem.setText("Thêm");
        bntThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntThemActionPerformed(evt);
            }
        });

        bntSua.setText("Sửa");
        bntSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSuaActionPerformed(evt);
            }
        });

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Chọn trạng thái----", "Đang hoạt động", "Dừng hoạt động" }));

        lbEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbEmail.setText("Email:");

        lbTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTrangThai.setText("Trạng thái:");

        lbGhiChu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbGhiChu.setText("Ghi chú:");

        lbGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbGioiTinh.setText("Giới tính:");

        lbSoDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSoDT.setText("Số điện thoại:");

        buttonGroup1.add(ckbNam);
        ckbNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ckbNam.setText("Nam");

        buttonGroup1.add(ckbNu);
        ckbNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ckbNu.setText("Nữ");

        lbHoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbHoTen.setText("Họ và tên:");

        lbDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDiaChi.setText("Địa chỉ:");

        lbChucVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbChucVu.setText("Chức vụ:");

        buttonGroup2.add(ckbNhanVien);
        ckbNhanVien.setText("Nhân viên");

        buttonGroup2.add(cbkQuanLy);
        cbkQuanLy.setText("Quản lý");

        lbMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbMatKhau.setText("Mật khẩu:");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        SP2.setViewportView(txtGhiChu);

        lbQuanLyNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbQuanLyNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQuanLyNhanVien.setText("QUẢN LÝ NHÂN VIÊN");

        javax.swing.GroupLayout pnlNhanVienLayout = new javax.swing.GroupLayout(pnlNhanVien);
        pnlNhanVien.setLayout(pnlNhanVienLayout);
        pnlNhanVienLayout.setHorizontalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addContainerGap(196, Short.MAX_VALUE)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                .addComponent(lbIDNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(txtIDNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                    .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                            .addGap(134, 134, 134)
                                            .addComponent(ckbNam)
                                            .addGap(48, 48, 48)
                                            .addComponent(ckbNu))
                                        .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                            .addGap(47, 47, 47)
                                            .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtSoDT)
                                                .addComponent(txtDiaChi)
                                                .addComponent(txtHoTen)
                                                .addComponent(txtEmail)
                                                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                    .addComponent(lbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(130, 130, 130)
                                    .addComponent(ckbNhanVien)
                                    .addGap(34, 34, 34)
                                    .addComponent(cbkQuanLy))
                                .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                    .addComponent(lbMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(47, 47, 47)
                                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                    .addComponent(lbGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(47, 47, 47)
                                    .addComponent(SP2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(bntThem)
                        .addGap(111, 111, 111)
                        .addComponent(bntSua)
                        .addGap(100, 100, 100)
                        .addComponent(bntLamMoi)
                        .addGap(0, 327, Short.MAX_VALUE))))
        );
        pnlNhanVienLayout.setVerticalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbIDNhanVien)
                            .addComponent(txtIDNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbQuanLyNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMatKhau)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoTen)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDiaChi)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSoDT)
                    .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGioiTinh)
                    .addComponent(ckbNam)
                    .addComponent(ckbNu))
                .addGap(18, 18, 18)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTrangThai)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbChucVu)
                    .addComponent(ckbNhanVien)
                    .addComponent(cbkQuanLy))
                .addGap(18, 18, 18)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbGhiChu)
                    .addComponent(SP2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        tabNhanVien.addTab("NHÂN VIÊN", pnlNhanVien);

        tbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID NHÂN VIÊN", "HỌ VÀ TÊN", "GIỚI TÍNH", "NGÀY SINH", "SỐ ĐIỆN THOẠI", "ĐỊA CHỈ", "EMAIL", "NGÀY TẠO", "MẬT KHẨU", "CHỨC VỤ", "TRẠNG THÁI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbNhanVien);

        bntTimKiem.setText("Tìm kiếm");
        bntTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntTimKiemActionPerformed(evt);
            }
        });

        bntLastPage.setText(">|");
        bntLastPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLastPageActionPerformed(evt);
            }
        });

        bntNextPage.setText(">>");
        bntNextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNextPageActionPerformed(evt);
            }
        });

        bntPrevPage.setText("<<");
        bntPrevPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntPrevPageActionPerformed(evt);
            }
        });

        bntFirstPage.setText("|<");
        bntFirstPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntFirstPageActionPerformed(evt);
            }
        });

        bntXoa.setText("Xóa Nhân Viên");

        lbPresentPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPresentPage.setText("?");

        javax.swing.GroupLayout pnlDanhSachNVLayout = new javax.swing.GroupLayout(pnlDanhSachNV);
        pnlDanhSachNV.setLayout(pnlDanhSachNVLayout);
        pnlDanhSachNVLayout.setHorizontalGroup(
            pnlDanhSachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDanhSachNVLayout.createSequentialGroup()
                .addContainerGap(635, Short.MAX_VALUE)
                .addGroup(pnlDanhSachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDanhSachNVLayout.createSequentialGroup()
                        .addComponent(bntXoa)
                        .addGap(30, 30, 30)
                        .addComponent(bntFirstPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntPrevPage)
                        .addGap(7, 7, 7)
                        .addComponent(lbPresentPage, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntNextPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntLastPage)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDanhSachNVLayout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bntTimKiem)
                        .addGap(33, 33, 33))))
        );
        pnlDanhSachNVLayout.setVerticalGroup(
            pnlDanhSachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDanhSachNVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDanhSachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntTimKiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDanhSachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntFirstPage)
                    .addComponent(bntPrevPage)
                    .addComponent(bntNextPage)
                    .addComponent(bntLastPage)
                    .addComponent(bntXoa)
                    .addComponent(lbPresentPage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabNhanVien.addTab("DANH SÁCH NHÂN VIÊN", pnlDanhSachNV);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabNhanVien)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabNhanVien, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bntSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntSuaActionPerformed

    private void bntThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntThemActionPerformed

    private void bntLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLamMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntLamMoiActionPerformed

    private void bntTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntTimKiemActionPerformed

    private void bntFirstPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntFirstPageActionPerformed
        // TODO add your handling code here:
        ht = 1;
        findWithPaginationNV(0, size);
        updatePageInfo();
    }//GEN-LAST:event_bntFirstPageActionPerformed

    private void bntPrevPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPrevPageActionPerformed
        // TODO add your handling code here:
        if (ht > 1) {
            ht--;
        }
        int page = (ht - 1) * size;
        findWithPaginationNV(page, size);
        updatePageInfo();
    }//GEN-LAST:event_bntPrevPageActionPerformed

    private void bntNextPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNextPageActionPerformed
        // TODO add your handling code here:
        int TotalItime = NVrepo.getTotalItems();
        int TotalPage = TotalItime / size;
        System.out.println(TotalItime);
        System.out.println(TotalPage);
        if (ht < TotalPage) {
            ht++;
            int page = (ht - 1) * size;
            findWithPaginationNV(page, size);
            updatePageInfo();

        } else {
            ht = 1;
            findWithPaginationNV(0, size);
            updatePageInfo();
        }
    }//GEN-LAST:event_bntNextPageActionPerformed

    private void bntLastPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLastPageActionPerformed
        // TODO add your handling code here:
        int totalItems = NVrepo.getTotalItems();
        int lastPage = (int) Math.ceil((double) totalItems / size);
        ht = lastPage;
        int page = (ht - 1) * size;
        findWithPaginationNV(page, size);
        updatePageInfo();
    }//GEN-LAST:event_bntLastPageActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane SP2;
    private javax.swing.JButton bntFirstPage;
    private javax.swing.JButton bntLamMoi;
    private javax.swing.JButton bntLastPage;
    private javax.swing.JButton bntNextPage;
    private javax.swing.JButton bntPrevPage;
    private javax.swing.JButton bntSua;
    private javax.swing.JButton bntThem;
    private javax.swing.JButton bntTimKiem;
    private javax.swing.JButton bntXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JCheckBox cbkQuanLy;
    private javax.swing.JCheckBox ckbNam;
    private javax.swing.JCheckBox ckbNhanVien;
    private javax.swing.JCheckBox ckbNu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbChucVu;
    private javax.swing.JLabel lbDiaChi;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbGhiChu;
    private javax.swing.JLabel lbGioiTinh;
    private javax.swing.JLabel lbHoTen;
    private javax.swing.JLabel lbIDNhanVien;
    private javax.swing.JLabel lbMatKhau;
    private javax.swing.JLabel lbPresentPage;
    private javax.swing.JLabel lbQuanLyNhanVien;
    private javax.swing.JLabel lbSoDT;
    private javax.swing.JLabel lbTrangThai;
    private javax.swing.JPanel pnlDanhSachNV;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JTabbedPane tabNhanVien;
    private javax.swing.JTable tbNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtIDNhanVien;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtSoDT;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
