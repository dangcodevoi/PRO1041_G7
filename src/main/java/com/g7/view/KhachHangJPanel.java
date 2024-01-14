package com.g7.view;

import com.g7.entity.KhachHang;
import com.g7.repository.impl.KhachHangRepository;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class KhachHangJPanel extends javax.swing.JPanel {

    private KhachHangRepository KHrepo = new KhachHangRepository();
    private DefaultTableModel defaultTableModelKH = new DefaultTableModel();

    private int ht = 1;
    private int size = 100;

    public KhachHangJPanel() {
        initComponents();
        setOpaque(false);
        updatePageInfo();
        findWithPaginationKH(0, size);
    }

    public void findWithPaginationKH(int ht, int c) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        DecimalFormat f = new DecimalFormat("#,##0.##");
        List<KhachHang> list = KHrepo.selectWithPagination(ht, c);
        defaultTableModelKH.setRowCount(0);
        defaultTableModelKH = (DefaultTableModel) tbKhachHang.getModel();
        for (KhachHang x : list) {
            defaultTableModelKH.addRow(new Object[]{
                x.getIDKhachHang(), x.getMaKhachHang(), x.getTenKhachHang(), x.getSDT(), df.format(x.getNgayTao()), x.getTrangThai()
            });
        }
    }

    private void updatePageInfo() {
        int totalItems = KHrepo.getTotalItems();
        int maxPage = (int) Math.ceil((double) totalItems / size);

        if (ht > maxPage) {
            ht = (maxPage == 0) ? 1 : maxPage;
        }

        lbPresentPage.setText(ht + " / " + maxPage);
    }

    public boolean vaildatedTimKiem() {
        if (txtTimKiem.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa \n VD :Mã KH: KH0001,\nTên KH: Irene Cline", "Error", 1);
            txtTimKiem.requestFocus();
            return false;
        }
        return true;
    }

    public void findWithKeywordMaKH(String keyword, int ht, int c) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        DecimalFormat f = new DecimalFormat("#,##0.##");
        List<KhachHang> list = KHrepo.findWithPaginationbyMaKH(keyword, ht, c);
        defaultTableModelKH.setRowCount(0);
        defaultTableModelKH = (DefaultTableModel) tbKhachHang.getModel();
        for (KhachHang x : list) {
            defaultTableModelKH.addRow(new Object[]{
                x.getIDKhachHang(), x.getMaKhachHang(), x.getTenKhachHang(), x.getSDT(), df.format(x.getNgayTao()), x.getTrangThai()
            });
        }
        int totalItems = KHrepo.getTotalSearchItemsMaKH();
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
        jPanel1 = new javax.swing.JPanel();
        lbMaKhachHang = new javax.swing.JLabel();
        txtIDKhachHang = new javax.swing.JTextField();
        lbHoTen = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSoDT = new javax.swing.JTextField();
        cbbTrangThai = new javax.swing.JComboBox<>();
        lbTrangThai = new javax.swing.JLabel();
        bntThem = new javax.swing.JButton();
        bntSua = new javax.swing.JButton();
        bntLamMoi = new javax.swing.JButton();
        lbIDKhachHang = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        bntTimKiem = new javax.swing.JButton();
        bntXoa = new javax.swing.JButton();
        bntFirstPage = new javax.swing.JButton();
        bntPrevPage = new javax.swing.JButton();
        bntNextPage = new javax.swing.JButton();
        bntLastPage = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhachHang = new javax.swing.JTable();
        lbPresentPage = new javax.swing.JLabel();
        lbQuanLyKhachHang = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1083, 643));

        lbMaKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbMaKhachHang.setText("Mã Khách Hàng:");

        lbHoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbHoTen.setText("Họ và tên:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Số điện thoại:");

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Chọn trạng thái----", "Đang hoạt động", "Dừng hoạt động" }));

        lbTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTrangThai.setText("Trạng thái:");

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

        bntLamMoi.setText("Làm mới");
        bntLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLamMoiActionPerformed(evt);
            }
        });

        lbIDKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbIDKhachHang.setText("ID Khách Hàng:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbIDKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMaKhachHang))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbbTrangThai, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSoDT, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtIDKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(bntThem)
                        .addGap(66, 66, 66)
                        .addComponent(bntSua, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(bntLamMoi)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIDKhachHang)
                    .addComponent(txtIDKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaKhachHang)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoTen)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTrangThai)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105))
        );

        bntTimKiem.setText("Tìm kiếm");
        bntTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntTimKiemActionPerformed(evt);
            }
        });

        bntXoa.setText("Xóa Khách Hàng");

        bntFirstPage.setText("|<");
        bntFirstPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntFirstPageActionPerformed(evt);
            }
        });

        bntPrevPage.setText("<<");
        bntPrevPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntPrevPageActionPerformed(evt);
            }
        });

        bntNextPage.setText(">>");
        bntNextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNextPageActionPerformed(evt);
            }
        });

        bntLastPage.setText(">|");
        bntLastPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLastPageActionPerformed(evt);
            }
        });

        tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID KHÁCH HÀNG", "MÃ KHÁCH HÀNG", "HỌ VÀ TÊN", "SỐ ĐIỆN THOẠI", "NGÀY TẠO", "TRẠNG THÁI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbKhachHang);

        lbPresentPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPresentPage.setText("?");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bntXoa)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bntTimKiem))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(bntFirstPage)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bntPrevPage)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbPresentPage, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bntNextPage)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bntLastPage)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntTimKiem)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntLastPage)
                    .addComponent(bntXoa)
                    .addComponent(bntFirstPage)
                    .addComponent(bntPrevPage)
                    .addComponent(bntNextPage)
                    .addComponent(lbPresentPage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lbQuanLyKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbQuanLyKhachHang.setText("QUẢN LÝ KHÁCH HÀNG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbQuanLyKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbQuanLyKhachHang)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bntLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLamMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntLamMoiActionPerformed

    private void bntSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntSuaActionPerformed

    private void bntThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntThemActionPerformed

    private void bntFirstPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntFirstPageActionPerformed
        // TODO add your handling code here:
        ht = 1;
        findWithPaginationKH(0, size);
        updatePageInfo();
    }//GEN-LAST:event_bntFirstPageActionPerformed

    private void bntPrevPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPrevPageActionPerformed
        // TODO add your handling code here:
        if (ht > 1) {
            ht--;
        }
        int page = (ht - 1) * size;
        findWithPaginationKH(page, size);
        updatePageInfo();
    }//GEN-LAST:event_bntPrevPageActionPerformed

    private void bntNextPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNextPageActionPerformed
        // TODO add your handling code here:
        int TotalItime = KHrepo.getTotalItems();
        int TotalPage = TotalItime / size;
        System.out.println(TotalItime);
        System.out.println(TotalPage);
        if (ht < TotalPage) {
            ht++;
            int page = (ht - 1) * size;
            findWithPaginationKH(page, size);
            updatePageInfo();

        } else {
            ht = 1;
            findWithPaginationKH(0, size);
            updatePageInfo();
        }
    }//GEN-LAST:event_bntNextPageActionPerformed

    private void bntLastPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLastPageActionPerformed
        // TODO add your handling code here:
        int totalItems = KHrepo.getTotalItems();
        int lastPage = (int) Math.ceil((double) totalItems / size);
        ht = lastPage;
        int page = (ht - 1) * size;
        findWithPaginationKH(page, size);
        updatePageInfo();
    }//GEN-LAST:event_bntLastPageActionPerformed

    private void bntTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntTimKiemActionPerformed
        // TODO add your handling code here:
        if (vaildatedTimKiem()) {
            String keyword = txtTimKiem.getText();
            findWithKeywordMaKH(keyword, 0, 100);
        }
    }//GEN-LAST:event_bntTimKiemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbHoTen;
    private javax.swing.JLabel lbIDKhachHang;
    private javax.swing.JLabel lbMaKhachHang;
    private javax.swing.JLabel lbPresentPage;
    private javax.swing.JLabel lbQuanLyKhachHang;
    private javax.swing.JLabel lbTrangThai;
    private javax.swing.JTable tbKhachHang;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtIDKhachHang;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtSoDT;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
