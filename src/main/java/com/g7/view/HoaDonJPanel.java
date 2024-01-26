package com.g7.view;

import com.g7.entity.HoaDon;
import com.g7.entity.HoaDonChiTiet;
import com.g7.repository.impl.HoaDonRepository;
import com.g7.repository.impl.HoaDonCtRepository;
import java.util.ArrayList;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class HoaDonJPanel extends javax.swing.JPanel {

    private ArrayList<HoaDon> listh = new ArrayList<>();
    private HoaDonRepository hdsv = new HoaDonRepository();
    private HoaDonCtRepository hdctsv = new HoaDonCtRepository();
    DefaultTableModel dtm = new DefaultTableModel();

    int id;

    public HoaDonJPanel() {
        initComponents();
        cbotrangThai.addItem("Tất cả");
        cbotrangThai.addItem("Đã Thanh Toán");
        cbotrangThai.addItem("Chưa Thanh Toán");
        loadDataHd(listh);
    }

    public void loadDataHd(List<HoaDon> list) {
        dtm = (DefaultTableModel) tblhoaDon.getModel();
        List<HoaDon> dshd = hdsv.getlistHoaDon();
        dtm.setRowCount(0);
        for (HoaDon hd : dshd) {
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblhoaDon = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblhoaDonChiTiet = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbotrangThai = new javax.swing.JComboBox<>();
        txtMaHoaDon = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Hóa đơn");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Chi tiết hóa đơn");

        cbotrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotrangThaiActionPerformed(evt);
            }
        });

        txtMaHoaDon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaHoaDonKeyReleased(evt);
            }
        });

        jLabel3.setText("Tìm Hoá Đơn:");

        jLabel4.setText("Trạng Thái:");

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
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addComponent(btnSearch))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbotrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbotrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tblhoaDon.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(dtm);
        tblhoaDon.setRowSorter(obj);

        // Get the selected item from the ComboBox
        String selectedTrangThai = cbotrangThai.getSelectedItem().toString();

        // Check the selected item and apply the filter accordingly
        if (!selectedTrangThai.equals("Tất cả")) {
            obj.setRowFilter(RowFilter.regexFilter(selectedTrangThai, 8)); // 8 is the column index of "Trạng Thái"
        } else {
            // If "Tất cả" is selected, check if the search field is empty
            String maHd = txtMaHoaDon.getText().trim();
            if (!maHd.isEmpty()) {
                obj.setRowFilter(RowFilter.regexFilter(maHd, 1)); // 1 is the column index of "Mã Hoá Đơn" (MaHD)
            } else {
                tblhoaDon.setRowSorter(obj);
                obj.setRowFilter(null); // Clear the filter if search field is empty
            }
        }
//        DefaultTableModel dtm = (DefaultTableModel) tblhoaDon.getModel();
//        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(dtm);
//        tblhoaDon.setRowSorter(obj);
//        obj.setRowFilter(RowFilter.regexFilter(txtTenKhachHang.getText()));
    }//GEN-LAST:event_btnSearchActionPerformed

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
            obj.setRowFilter(null);        }
    }//GEN-LAST:event_txtMaHoaDonKeyReleased

    private void cbotrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotrangThaiActionPerformed

    }//GEN-LAST:event_cbotrangThaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbotrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblhoaDon;
    private javax.swing.JTable tblhoaDonChiTiet;
    private javax.swing.JTextField txtMaHoaDon;
    // End of variables declaration//GEN-END:variables
}
