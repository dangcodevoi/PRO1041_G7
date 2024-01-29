package com.g7.view;

import com.g7.entity.HoaDon;
import com.g7.entity.HoaDonChiTiet;
import com.g7.repository.impl.HoaDonRepository;
import com.g7.repository.impl.HoaDonCtRepository;
import java.util.ArrayList;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class HoaDonJPanel extends javax.swing.JPanel {

    private ArrayList<HoaDon> listh = new ArrayList<>();
    private HoaDonRepository hdsv = new HoaDonRepository();
    private HoaDonCtRepository hdctsv = new HoaDonCtRepository();
    DefaultTableModel dtm = new DefaultTableModel();
    private int currentPage = 1;
    private int pageSize = 10;
    int id;
    int ht;

    public HoaDonJPanel() {
        initComponents();
        loadDataHd(listh);
    }

    public void loadDataHd(List<HoaDon> list) {
        dtm = (DefaultTableModel) tblhoaDon.getModel();
        dtm.setRowCount(0);
        for (HoaDon hd : list) {
            dtm.addRow(new Object[]{
                hd.getId(),
                hd.getMaHD(),
                hd.getNgayTao(),
                hd.getNgayThanhToan(),
                hd.getTongTien(),
                hd.getSoTienGiam(),
                hd.getTenKhachHang(),
                hd.getSoDienThoai(),
                hd.trangThai(hd.getTrangThai())
            });
        }
    }

    public void loadHdct() {
        DefaultTableModel dtm = (DefaultTableModel) tblhoaDonChiTiet.getModel();
        dtm.setRowCount(0);
        for (HoaDonChiTiet ct : hdctsv.getListHdct(id)) {
            dtm.addRow(new Object[]{
                ct.getId(),
                ct.getIdHoaDon(),
                ct.getIdCtSanPham(),
                ct.getSoLuong(),
                ct.getDonGia(),
                ct.trangThai(ct.getTrangThai())
            });
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblhoaDon = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblhoaDonChiTiet = new javax.swing.JTable();
        btnSearchMaHD = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnlon = new javax.swing.JButton();
        btnnhoMax = new javax.swing.JButton();
        btnnho = new javax.swing.JButton();
        btnlonMax = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        rdodaThanhToan = new javax.swing.JRadioButton();
        rdochuaThanhToan = new javax.swing.JRadioButton();
        CalendarNgaySinh = new com.toedter.calendar.JDateChooser();
        CalendarNgaySinh1 = new com.toedter.calendar.JDateChooser();
        btnSearchDate = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        tblhoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID ", "Mã Hoá Đơn", "Ngày Tạo", "Ngày Thanh Toán", "Tổng Tiền", "Số Tiền Giảm", "Tên Khách Hàng", "Số Điện Thoại", "Trạng Thái"
            }
        ));
        tblhoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblhoaDon);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        tblhoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "ID Hoá Đơn", "ID Sản Phẩm", "Số Lượng ", "Đơn Giá", "Trạng Thái"
            }
        ));
        jScrollPane1.setViewportView(tblhoaDonChiTiet);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnSearchMaHD.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnSearchMaHD.setText("Tìm kiếm");
        btnSearchMaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchMaHDActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Hóa đơn");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Chi tiết hóa đơn");

        txtMaHoaDon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaHoaDonKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Ngày Tạo:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Trạng Thái:");

        btnlon.setText(">");
        btnlon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlonActionPerformed(evt);
            }
        });

        btnnhoMax.setText("<<");
        btnnhoMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnhoMaxActionPerformed(evt);
            }
        });

        btnnho.setText("<");
        btnnho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnhoActionPerformed(evt);
            }
        });

        btnlonMax.setText(">>");
        btnlonMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlonMaxActionPerformed(evt);
            }
        });

        jLabel5.setText("?");

        buttonGroup1.add(rdodaThanhToan);
        rdodaThanhToan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rdodaThanhToan.setText("Đã Thanh Toán");
        rdodaThanhToan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdodaThanhToanItemStateChanged(evt);
            }
        });
        rdodaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdodaThanhToanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdochuaThanhToan);
        rdochuaThanhToan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rdochuaThanhToan.setSelected(true);
        rdochuaThanhToan.setText("Chưa Thanh Toán");
        rdochuaThanhToan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdochuaThanhToanItemStateChanged(evt);
            }
        });

        btnSearchDate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnSearchDate.setText("Tìm kiếm");
        btnSearchDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDateActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Tìm Hoá Đơn:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Ngày Thanh Toán:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(155, 155, 155))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel4)
                                        .addGap(33, 33, 33))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(btnSearchMaHD)
                                        .addGap(155, 155, 155))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdodaThanhToan)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdochuaThanhToan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CalendarNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(btnSearchDate))
                            .addComponent(CalendarNgaySinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(369, 369, 369)
                .addComponent(btnnhoMax)
                .addGap(18, 18, 18)
                .addComponent(btnnho)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(btnlon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnlonMax)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSearchMaHD))
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearchDate)
                            .addComponent(jLabel3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CalendarNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CalendarNgaySinh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(rdodaThanhToan)
                        .addComponent(rdochuaThanhToan)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnhoMax)
                    .addComponent(btnnho)
                    .addComponent(jLabel5)
                    .addComponent(btnlon)
                    .addComponent(btnlonMax))
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchMaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchMaHDActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tblhoaDon.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(dtm);
        tblhoaDon.setRowSorter(obj);

        String maHd = txtMaHoaDon.getText().trim();
        if (!maHd.isEmpty()) {
            obj.setRowFilter(RowFilter.regexFilter(maHd, 1));
        } else {
            tblhoaDon.setRowSorter(obj);
            obj.setRowFilter(null);

        }
    }//GEN-LAST:event_btnSearchMaHDActionPerformed

    private void tblhoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhoaDonMouseClicked
        int selectedRow = tblhoaDon.getSelectedRow();
        if (selectedRow >= 0) {
            id = (int) tblhoaDon.getValueAt(selectedRow, 0);
            loadHdct();
        }
    }//GEN-LAST:event_tblhoaDonMouseClicked

    private void txtMaHoaDonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaHoaDonKeyReleased
        DefaultTableModel dtm = (DefaultTableModel) tblhoaDon.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(dtm);
        tblhoaDon.setRowSorter(obj);
        String maHd = txtMaHoaDon.getText().trim();
        if (!maHd.isEmpty()) {
            obj.setRowFilter(RowFilter.regexFilter(maHd, 1));
        } else {
            tblhoaDon.setRowSorter(obj);
            obj.setRowFilter(null);
        }
    }//GEN-LAST:event_txtMaHoaDonKeyReleased

    private void btnnhoMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnhoMaxActionPerformed
      loadDataHd(hdsv.getlistHoaDon(0));

    }//GEN-LAST:event_btnnhoMaxActionPerformed

    private void btnnhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnhoActionPerformed
       
    }//GEN-LAST:event_btnnhoActionPerformed

    private void btnlonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlonActionPerformed

    private void btnlonMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlonMaxActionPerformed
      loadDataHd(hdsv.getlistHoaDon(9));
    }//GEN-LAST:event_btnlonMaxActionPerformed

    private void rdodaThanhToanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdodaThanhToanItemStateChanged

    }//GEN-LAST:event_rdodaThanhToanItemStateChanged

    private void rdochuaThanhToanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdochuaThanhToanItemStateChanged

    }//GEN-LAST:event_rdochuaThanhToanItemStateChanged

    private void rdodaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdodaThanhToanActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_rdodaThanhToanActionPerformed

    private void btnSearchDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchDateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser CalendarNgaySinh;
    private com.toedter.calendar.JDateChooser CalendarNgaySinh1;
    private javax.swing.JButton btnSearchDate;
    private javax.swing.JButton btnSearchMaHD;
    private javax.swing.JButton btnlon;
    private javax.swing.JButton btnlonMax;
    private javax.swing.JButton btnnho;
    private javax.swing.JButton btnnhoMax;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdochuaThanhToan;
    private javax.swing.JRadioButton rdodaThanhToan;
    private javax.swing.JTable tblhoaDon;
    private javax.swing.JTable tblhoaDonChiTiet;
    private javax.swing.JTextField txtMaHoaDon;
    // End of variables declaration//GEN-END:variables
}
