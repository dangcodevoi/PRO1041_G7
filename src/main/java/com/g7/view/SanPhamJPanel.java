package com.g7.view;
public class SanPhamJPanel extends javax.swing.JPanel {
    public SanPhamJPanel() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TBP_SanPham = new javax.swing.JTabbedPane();
        Fame_SanPham = new javax.swing.JPanel();
        lbl_1 = new javax.swing.JLabel();
        lbl_5 = new javax.swing.JLabel();
        lbl_IDSanPham = new javax.swing.JLabel();
        lbl_3 = new javax.swing.JLabel();
        lbl_4 = new javax.swing.JLabel();
        lbl_TieuDe = new javax.swing.JLabel();
        lbl_2 = new javax.swing.JLabel();
        lbl_6 = new javax.swing.JLabel();
        lbl_9 = new javax.swing.JLabel();
        btn_Xoa = new javax.swing.JButton();
        btn_VeCuoi = new javax.swing.JButton();
        btn_VeSau = new javax.swing.JButton();
        btn_VeTruoc = new javax.swing.JButton();
        btn_VeDau = new javax.swing.JButton();
        btn_XemCTSP = new javax.swing.JButton();
        btn_ThemChatLieu = new javax.swing.JButton();
        btn_ThemDanhMuc = new javax.swing.JButton();
        btn_ThemNSX = new javax.swing.JButton();
        btn_Moi = new javax.swing.JButton();
        btn_ThemSp = new javax.swing.JButton();
        btn_SuaSp = new javax.swing.JButton();
        cbo_ChatLieu = new javax.swing.JComboBox<>();
        cbo_NSX = new javax.swing.JComboBox<>();
        cbo_DanhMuc = new javax.swing.JComboBox<>();
        SP1 = new javax.swing.JScrollPane();
        tbl_DanhSachSP = new javax.swing.JTable();
        SP2 = new javax.swing.JScrollPane();
        txt_GhiChu = new javax.swing.JTextArea();
        txt_TenSanPham = new javax.swing.JTextField();
        Fame_SanPhamCT = new javax.swing.JPanel();
        lbl_14 = new javax.swing.JLabel();
        lbl_IDSPCT = new javax.swing.JLabel();
        lbl_12 = new javax.swing.JLabel();
        lbl_17 = new javax.swing.JLabel();
        lbl_15 = new javax.swing.JLabel();
        lbl_10 = new javax.swing.JLabel();
        lbl_13 = new javax.swing.JLabel();
        lbl_TieuDe1 = new javax.swing.JLabel();
        lbl_11 = new javax.swing.JLabel();
        lbl_18 = new javax.swing.JLabel();
        btn_VeTruoc1 = new javax.swing.JButton();
        btn_VeDau1 = new javax.swing.JButton();
        btn_SuaCT = new javax.swing.JButton();
        btn_XoaCT = new javax.swing.JButton();
        btn_VeCuoiCT = new javax.swing.JButton();
        btn_VeSauCT = new javax.swing.JButton();
        btn_MoiCT = new javax.swing.JButton();
        btn_ThemCT = new javax.swing.JButton();
        btn_ThemMau = new javax.swing.JButton();
        btn_ThemKichThuoc = new javax.swing.JButton();
        cbo_KichThuoc = new javax.swing.JComboBox<>();
        cbo_SanPham = new javax.swing.JComboBox<>();
        cbo_Mau = new javax.swing.JComboBox<>();
        txt_SoLuongCT = new javax.swing.JTextField();
        txt_GiaBanCT = new javax.swing.JTextField();
        SP3 = new javax.swing.JScrollPane();
        txt_GhiChuCT = new javax.swing.JTextArea();
        SP4 = new javax.swing.JScrollPane();
        tbl_DanhSachSPCT = new javax.swing.JTable();
        HinhAnh = new javax.swing.JPanel();
        lbl_HinhAnh = new javax.swing.JLabel();
        lbl_TenSPCT = new javax.swing.JLabel();
        btn_Anh = new javax.swing.JButton();
        lbl_19 = new javax.swing.JLabel();

        TBP_SanPham.setBackground(new java.awt.Color(255, 255, 255));

        Fame_SanPham.setBackground(new java.awt.Color(255, 255, 255));

        lbl_1.setText("ID Sản Phẩm:");

        lbl_5.setText("Danh Mục:");

        lbl_IDSanPham.setText("Không Cần Nhập");

        lbl_3.setText("Ghi Chú:");

        lbl_4.setText("Tên Sản Phẩm:");

        lbl_TieuDe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_TieuDe.setText("Quản Lý Sản Phẩm");

        lbl_2.setText("Nhà Sản Xuất:");

        lbl_6.setText("Chất Liệu:");

        lbl_9.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_9.setText("Chọn Sản Phẩm Để Xem Sản Phẩm Chi Tiết");

        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        btn_VeCuoi.setText(">>");
        btn_VeCuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VeCuoiActionPerformed(evt);
            }
        });

        btn_VeSau.setText(">");
        btn_VeSau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VeSauActionPerformed(evt);
            }
        });

        btn_VeTruoc.setText("<");
        btn_VeTruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VeTruocActionPerformed(evt);
            }
        });

        btn_VeDau.setText("<<");
        btn_VeDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VeDauActionPerformed(evt);
            }
        });

        btn_XemCTSP.setText("Xem Chi Tiết");
        btn_XemCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XemCTSPActionPerformed(evt);
            }
        });

        btn_ThemChatLieu.setText("+");
        btn_ThemChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemChatLieuActionPerformed(evt);
            }
        });

        btn_ThemDanhMuc.setText("+");
        btn_ThemDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemDanhMucActionPerformed(evt);
            }
        });

        btn_ThemNSX.setText("+");
        btn_ThemNSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemNSXActionPerformed(evt);
            }
        });

        btn_Moi.setText("Mới");
        btn_Moi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MoiActionPerformed(evt);
            }
        });

        btn_ThemSp.setText("Thêm");
        btn_ThemSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemSpActionPerformed(evt);
            }
        });

        btn_SuaSp.setText("Sửa");
        btn_SuaSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaSpActionPerformed(evt);
            }
        });

        cbo_ChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn" }));

        cbo_NSX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn" }));

        cbo_DanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn" }));

        tbl_DanhSachSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên", "Nhà SX", "Danh Muc", "Chất Liệu", "Trạng Thái", "Xuất Xứ"
            }
        ));
        tbl_DanhSachSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DanhSachSPMouseClicked(evt);
            }
        });
        SP1.setViewportView(tbl_DanhSachSP);

        txt_GhiChu.setColumns(20);
        txt_GhiChu.setRows(5);
        SP2.setViewportView(txt_GhiChu);

        txt_TenSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_TenSanPham.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_TenSanPham.setOpaque(true);

        javax.swing.GroupLayout Fame_SanPhamLayout = new javax.swing.GroupLayout(Fame_SanPham);
        Fame_SanPham.setLayout(Fame_SanPhamLayout);
        Fame_SanPhamLayout.setHorizontalGroup(
            Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Fame_SanPhamLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SP1)
                    .addGroup(Fame_SanPhamLayout.createSequentialGroup()
                        .addComponent(lbl_9)
                        .addGap(152, 152, 152)
                        .addComponent(btn_VeDau)
                        .addGap(18, 18, 18)
                        .addComponent(btn_VeTruoc)
                        .addGap(18, 18, 18)
                        .addComponent(btn_VeSau)
                        .addGap(18, 18, 18)
                        .addComponent(btn_VeCuoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_XemCTSP))
                    .addGroup(Fame_SanPhamLayout.createSequentialGroup()
                        .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(Fame_SanPhamLayout.createSequentialGroup()
                                .addComponent(lbl_1)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_IDSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_3)
                            .addGroup(Fame_SanPhamLayout.createSequentialGroup()
                                .addComponent(lbl_2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbo_NSX, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_ThemNSX))
                            .addComponent(SP2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                        .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Fame_SanPhamLayout.createSequentialGroup()
                                .addComponent(lbl_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Fame_SanPhamLayout.createSequentialGroup()
                                .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_4)
                                    .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_5)
                                        .addComponent(lbl_6, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(29, 29, 29)
                                .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_TenSanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Fame_SanPhamLayout.createSequentialGroup()
                                        .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cbo_ChatLieu, javax.swing.GroupLayout.Alignment.LEADING, 0, 256, Short.MAX_VALUE)
                                            .addComponent(cbo_DanhMuc, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_ThemDanhMuc, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btn_ThemChatLieu, javax.swing.GroupLayout.Alignment.TRAILING)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Fame_SanPhamLayout.createSequentialGroup()
                                .addComponent(btn_ThemSp)
                                .addGap(18, 18, 18)
                                .addComponent(btn_SuaSp)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Xoa)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Moi)))))
                .addGap(69, 69, 69))
        );
        Fame_SanPhamLayout.setVerticalGroup(
            Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Fame_SanPhamLayout.createSequentialGroup()
                .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Fame_SanPhamLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_1)
                            .addComponent(lbl_IDSanPham))
                        .addGap(19, 19, 19)
                        .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_2)
                            .addComponent(cbo_NSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ThemNSX))
                        .addGap(22, 22, 22)
                        .addComponent(lbl_3)
                        .addGap(8, 8, 8)
                        .addComponent(SP2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Fame_SanPhamLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_4)
                            .addComponent(txt_TenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_5)
                            .addComponent(cbo_DanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ThemDanhMuc))
                        .addGap(19, 19, 19)
                        .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_6)
                            .addComponent(cbo_ChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ThemChatLieu))
                        .addGap(86, 86, 86)
                        .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Moi)
                            .addComponent(btn_Xoa)
                            .addComponent(btn_SuaSp)
                            .addComponent(btn_ThemSp))))
                .addGap(24, 24, 24)
                .addComponent(SP1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_XemCTSP)
                        .addComponent(btn_VeCuoi)
                        .addComponent(btn_VeSau)
                        .addComponent(btn_VeTruoc)
                        .addComponent(btn_VeDau))
                    .addComponent(lbl_9))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        TBP_SanPham.addTab("Sản Phẩm", Fame_SanPham);

        Fame_SanPhamCT.setBackground(new java.awt.Color(255, 255, 255));

        lbl_14.setText("Màu:");

        lbl_IDSPCT.setText("1");

        lbl_12.setText("Ghi Chú:");

        lbl_17.setText("Giá Bán:");

        lbl_15.setText("Kích Thước:");

        lbl_10.setText("ID Sản Phẩm CT:");

        lbl_13.setText("Tên Sản Phẩm CT:");

        lbl_TieuDe1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_TieuDe1.setText("Sản Phẩm Chi Tiết");

        lbl_11.setText("Sản Phẩm");

        lbl_18.setText("Số Lượng:");

        btn_VeTruoc1.setText("<");
        btn_VeTruoc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VeTruoc1ActionPerformed(evt);
            }
        });

        btn_VeDau1.setText("<<");
        btn_VeDau1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VeDau1ActionPerformed(evt);
            }
        });

        btn_SuaCT.setText("Sửa");
        btn_SuaCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaCTActionPerformed(evt);
            }
        });

        btn_XoaCT.setText("Xóa");
        btn_XoaCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaCTActionPerformed(evt);
            }
        });

        btn_VeCuoiCT.setText(">>");
        btn_VeCuoiCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VeCuoiCTActionPerformed(evt);
            }
        });

        btn_VeSauCT.setText(">");
        btn_VeSauCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VeSauCTActionPerformed(evt);
            }
        });

        btn_MoiCT.setText("Mới");
        btn_MoiCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MoiCTActionPerformed(evt);
            }
        });

        btn_ThemCT.setText("Thêm");
        btn_ThemCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemCTActionPerformed(evt);
            }
        });

        btn_ThemMau.setText("+");
        btn_ThemMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemMauActionPerformed(evt);
            }
        });

        btn_ThemKichThuoc.setText("+");
        btn_ThemKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemKichThuocActionPerformed(evt);
            }
        });

        cbo_KichThuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn" }));

        cbo_SanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn" }));

        cbo_Mau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn" }));

        txt_SoLuongCT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_SoLuongCT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_SoLuongCT.setOpaque(true);

        txt_GiaBanCT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_GiaBanCT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_GiaBanCT.setOpaque(true);

        txt_GhiChuCT.setColumns(20);
        txt_GhiChuCT.setRows(5);
        SP3.setViewportView(txt_GhiChuCT);

        tbl_DanhSachSPCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên", "Màu", "Kích Thước", "Số Lượng", "Giá Bán", "Trạng Thái"
            }
        ));
        tbl_DanhSachSPCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DanhSachSPCTMouseClicked(evt);
            }
        });
        SP4.setViewportView(tbl_DanhSachSPCT);
        if (tbl_DanhSachSPCT.getColumnModel().getColumnCount() > 0) {
            tbl_DanhSachSPCT.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        HinhAnh.setBackground(new java.awt.Color(204, 204, 204));

        lbl_HinhAnh.setBackground(new java.awt.Color(0, 0, 0));
        lbl_HinhAnh.setText("                   Không Hiện Thị");

        javax.swing.GroupLayout HinhAnhLayout = new javax.swing.GroupLayout(HinhAnh);
        HinhAnh.setLayout(HinhAnhLayout);
        HinhAnhLayout.setHorizontalGroup(
            HinhAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_HinhAnh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
        );
        HinhAnhLayout.setVerticalGroup(
            HinhAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_HinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lbl_TenSPCT.setText("NIKEEE");

        btn_Anh.setText("+");
        btn_Anh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AnhActionPerformed(evt);
            }
        });

        lbl_19.setText("VND");

        javax.swing.GroupLayout Fame_SanPhamCTLayout = new javax.swing.GroupLayout(Fame_SanPhamCT);
        Fame_SanPhamCT.setLayout(Fame_SanPhamCTLayout);
        Fame_SanPhamCTLayout.setHorizontalGroup(
            Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                        .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(HinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(btn_Anh)))
                        .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                .addGap(356, 356, 356)
                                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Fame_SanPhamCTLayout.createSequentialGroup()
                                        .addComponent(btn_ThemCT)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_SuaCT)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_XoaCT)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_MoiCT))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Fame_SanPhamCTLayout.createSequentialGroup()
                                        .addComponent(lbl_TieuDe1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49))))
                            .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                        .addComponent(lbl_10)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_IDSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                            .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbl_12)
                                                .addComponent(SP3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(48, 48, 48))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Fame_SanPhamCTLayout.createSequentialGroup()
                                            .addComponent(lbl_11)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbo_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                        .addComponent(lbl_17)
                                        .addGap(29, 29, 29)
                                        .addComponent(txt_GiaBanCT, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                        .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_13)
                                            .addComponent(lbl_15)
                                            .addComponent(lbl_14))
                                        .addGap(29, 29, 29)
                                        .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_TenSPCT)
                                            .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                                    .addGap(99, 99, 99)
                                                    .addComponent(lbl_19)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lbl_18)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txt_SoLuongCT, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                                    .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(cbo_KichThuoc, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(cbo_Mau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btn_ThemMau)
                                                        .addComponent(btn_ThemKichThuoc)))))))
                                .addGap(1, 1, 1))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Fame_SanPhamCTLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(SP4, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69))
            .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                .addGap(394, 394, 394)
                .addComponent(btn_VeDau1)
                .addGap(18, 18, 18)
                .addComponent(btn_VeTruoc1)
                .addGap(18, 18, 18)
                .addComponent(btn_VeSauCT)
                .addGap(18, 18, 18)
                .addComponent(btn_VeCuoiCT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Fame_SanPhamCTLayout.setVerticalGroup(
            Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Fame_SanPhamCTLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                        .addComponent(lbl_TieuDe1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_13)
                                    .addComponent(lbl_TenSPCT))
                                .addGap(19, 19, 19)
                                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_14)
                                    .addComponent(cbo_Mau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_ThemMau))
                                .addGap(19, 19, 19)
                                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_15)
                                    .addComponent(cbo_KichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_ThemKichThuoc))
                                .addGap(18, 18, 18)
                                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_17)
                                    .addComponent(lbl_18)
                                    .addComponent(txt_GiaBanCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_SoLuongCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_19)))
                            .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_10)
                                    .addComponent(lbl_IDSPCT))
                                .addGap(19, 19, 19)
                                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_11)
                                    .addComponent(cbo_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addComponent(lbl_12)
                                .addGap(18, 18, 18)
                                .addComponent(SP3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(HinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_MoiCT)
                    .addComponent(btn_XoaCT)
                    .addComponent(btn_SuaCT)
                    .addComponent(btn_ThemCT)
                    .addComponent(btn_Anh))
                .addGap(18, 18, 18)
                .addComponent(SP4, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_VeCuoiCT)
                    .addComponent(btn_VeSauCT)
                    .addComponent(btn_VeTruoc1)
                    .addComponent(btn_VeDau1))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        TBP_SanPham.addTab("Chi Tiết Sản Phẩm", Fame_SanPhamCT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TBP_SanPham)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TBP_SanPham)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemNSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemNSXActionPerformed
        new viewCRUDThuocTinh().setVisible(true);
    }//GEN-LAST:event_btn_ThemNSXActionPerformed

    private void btn_ThemDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemDanhMucActionPerformed
        new viewCRUDThuocTinh().setVisible(true);
    }//GEN-LAST:event_btn_ThemDanhMucActionPerformed

    private void btn_ThemChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemChatLieuActionPerformed
        new viewCRUDThuocTinh().setVisible(true);
    }//GEN-LAST:event_btn_ThemChatLieuActionPerformed

    private void btn_ThemMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemMauActionPerformed
        new viewCRUDThuocTinh().setVisible(true);
    }//GEN-LAST:event_btn_ThemMauActionPerformed

    private void btn_ThemKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemKichThuocActionPerformed
        new viewCRUDThuocTinh().setVisible(true);
    }//GEN-LAST:event_btn_ThemKichThuocActionPerformed

    private void tbl_DanhSachSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DanhSachSPMouseClicked
        
    }//GEN-LAST:event_tbl_DanhSachSPMouseClicked

    private void btn_ThemSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemSpActionPerformed
        
    }//GEN-LAST:event_btn_ThemSpActionPerformed

    private void btn_SuaSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaSpActionPerformed
        
    }//GEN-LAST:event_btn_SuaSpActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_MoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MoiActionPerformed
        newForm();
    }//GEN-LAST:event_btn_MoiActionPerformed

    private void btn_VeDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VeDauActionPerformed
        
    }//GEN-LAST:event_btn_VeDauActionPerformed

    private void btn_VeTruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VeTruocActionPerformed
        
    }//GEN-LAST:event_btn_VeTruocActionPerformed

    private void btn_VeSauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VeSauActionPerformed
        
    }//GEN-LAST:event_btn_VeSauActionPerformed

    private void btn_VeCuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VeCuoiActionPerformed
        
    }//GEN-LAST:event_btn_VeCuoiActionPerformed

    private void btn_XemCTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XemCTSPActionPerformed
        
    }//GEN-LAST:event_btn_XemCTSPActionPerformed

    private void newForm() {
        lbl_IDSanPham.setText("Không Cần Nhập");
        cbo_NSX.setSelectedIndex(0);
        cbo_DanhMuc.setSelectedIndex(0);
        cbo_ChatLieu.setSelectedIndex(0);
        txt_TenSanPham.setText("");
        txt_GhiChu.setText("");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    //====================================SẢN PHẨM CHI TIẾT===================================================
    
    
    
    private void btn_ThemCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemCTActionPerformed
        
    }//GEN-LAST:event_btn_ThemCTActionPerformed

    private void btn_SuaCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaCTActionPerformed
        
    }//GEN-LAST:event_btn_SuaCTActionPerformed

    private void btn_XoaCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaCTActionPerformed
        
    }//GEN-LAST:event_btn_XoaCTActionPerformed

    private void btn_MoiCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MoiCTActionPerformed
        
    }//GEN-LAST:event_btn_MoiCTActionPerformed

    private void btn_VeDau1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VeDau1ActionPerformed
        
    }//GEN-LAST:event_btn_VeDau1ActionPerformed

    private void btn_VeTruoc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VeTruoc1ActionPerformed
        
    }//GEN-LAST:event_btn_VeTruoc1ActionPerformed

    private void btn_VeSauCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VeSauCTActionPerformed
        
    }//GEN-LAST:event_btn_VeSauCTActionPerformed

    private void btn_VeCuoiCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VeCuoiCTActionPerformed
        
    }//GEN-LAST:event_btn_VeCuoiCTActionPerformed

    private void tbl_DanhSachSPCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DanhSachSPCTMouseClicked
        
    }//GEN-LAST:event_tbl_DanhSachSPCTMouseClicked

    private void btn_AnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AnhActionPerformed
        
    }//GEN-LAST:event_btn_AnhActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fame_SanPham;
    private javax.swing.JPanel Fame_SanPhamCT;
    private javax.swing.JPanel HinhAnh;
    private javax.swing.JScrollPane SP1;
    private javax.swing.JScrollPane SP2;
    private javax.swing.JScrollPane SP3;
    private javax.swing.JScrollPane SP4;
    private javax.swing.JTabbedPane TBP_SanPham;
    private javax.swing.JButton btn_Anh;
    private javax.swing.JButton btn_Moi;
    private javax.swing.JButton btn_MoiCT;
    private javax.swing.JButton btn_SuaCT;
    private javax.swing.JButton btn_SuaSp;
    private javax.swing.JButton btn_ThemCT;
    private javax.swing.JButton btn_ThemChatLieu;
    private javax.swing.JButton btn_ThemDanhMuc;
    private javax.swing.JButton btn_ThemKichThuoc;
    private javax.swing.JButton btn_ThemMau;
    private javax.swing.JButton btn_ThemNSX;
    private javax.swing.JButton btn_ThemSp;
    private javax.swing.JButton btn_VeCuoi;
    private javax.swing.JButton btn_VeCuoiCT;
    private javax.swing.JButton btn_VeDau;
    private javax.swing.JButton btn_VeDau1;
    private javax.swing.JButton btn_VeSau;
    private javax.swing.JButton btn_VeSauCT;
    private javax.swing.JButton btn_VeTruoc;
    private javax.swing.JButton btn_VeTruoc1;
    private javax.swing.JButton btn_XemCTSP;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JButton btn_XoaCT;
    private javax.swing.JComboBox<String> cbo_ChatLieu;
    private javax.swing.JComboBox<String> cbo_DanhMuc;
    private javax.swing.JComboBox<String> cbo_KichThuoc;
    private javax.swing.JComboBox<String> cbo_Mau;
    private javax.swing.JComboBox<String> cbo_NSX;
    private javax.swing.JComboBox<String> cbo_SanPham;
    private javax.swing.JLabel lbl_1;
    private javax.swing.JLabel lbl_10;
    private javax.swing.JLabel lbl_11;
    private javax.swing.JLabel lbl_12;
    private javax.swing.JLabel lbl_13;
    private javax.swing.JLabel lbl_14;
    private javax.swing.JLabel lbl_15;
    private javax.swing.JLabel lbl_17;
    private javax.swing.JLabel lbl_18;
    private javax.swing.JLabel lbl_19;
    private javax.swing.JLabel lbl_2;
    private javax.swing.JLabel lbl_3;
    private javax.swing.JLabel lbl_4;
    private javax.swing.JLabel lbl_5;
    private javax.swing.JLabel lbl_6;
    private javax.swing.JLabel lbl_9;
    private javax.swing.JLabel lbl_HinhAnh;
    private javax.swing.JLabel lbl_IDSPCT;
    private javax.swing.JLabel lbl_IDSanPham;
    private javax.swing.JLabel lbl_TenSPCT;
    private javax.swing.JLabel lbl_TieuDe;
    private javax.swing.JLabel lbl_TieuDe1;
    private javax.swing.JTable tbl_DanhSachSP;
    private javax.swing.JTable tbl_DanhSachSPCT;
    private javax.swing.JTextArea txt_GhiChu;
    private javax.swing.JTextArea txt_GhiChuCT;
    private javax.swing.JTextField txt_GiaBanCT;
    private javax.swing.JTextField txt_SoLuongCT;
    private javax.swing.JTextField txt_TenSanPham;
    // End of variables declaration//GEN-END:variables
}
