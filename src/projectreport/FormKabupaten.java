
package projectreport;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


public class FormKabupaten extends javax.swing.JFrame {

	
	public FormKabupaten() {
		initComponents();
		tampilKabupaten();
		tampilKecamatan();
		tampilKelurahan();
		getDataMahasiswa();
	}
	
	private void getDataMahasiswa()
	{	
            DefaultTableModel isiTabel = new DefaultTableModel();
            isiTabel.addColumn("Id");
            isiTabel.addColumn("Nama");
            isiTabel.addColumn("NIM");
            isiTabel.addColumn("Jurusan");
            isiTabel.addColumn("Jenis Kelamin");
            isiTabel.addColumn("Jalan");
            isiTabel.addColumn("Kabupaten");
            isiTabel.addColumn("Kecamatan");
            isiTabel.addColumn("Kelurahan");

            try {
                    Connection conn = (Connection)Koneksi.koneksiDB();
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM mahasiswa");

                    // mengganti isi tabel
                    while (rs.next()) {				
                            isiTabel.addRow(new Object[]{
                                rs.getString(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7),
                                rs.getString(8),
                                rs.getString(9)
                            });
                    }
                    jTable1.setModel(isiTabel);

            } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Tidak bisa load data dari tabel mahasiswa");
            }
	}
	
	private void tampilKabupaten()
	{
            try {
                    Connection conn = (Connection)Koneksi.koneksiDB();
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM kabupaten");
                    kabupaten.addItem("------Pilih Kabupaten------");

                    // tampil data di combobox
                    while (rs.next()) {
                            kabupaten.addItem(rs.getString("kabupaten_nama"));
                    }
                    rs.close();
                    st.close();
            } catch (SQLException e) {
                    System.out.println(e.getMessage());
            }
	}
	
	private void tampilKecamatan()
	{
            try {
                    Connection conn = (Connection)Koneksi.koneksiDB();
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM kecamatan");
                    kecamatan.addItem("------Pilih Kecamatan------");

                    // tampil data di combobox
                    while (rs.next()) {
                            kecamatan.addItem(rs.getString("kecamatan_nama"));
                    }
                    rs.close();
                    st.close();
            } catch (SQLException e) {
                    System.out.println(e.getMessage());
            }
	}
	
	private void tampilKelurahan()
	{
            try {
                    Connection conn = (Connection)Koneksi.koneksiDB();
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM kelurahan");
                    kelurahan.addItem("------Pilih Kelurahan------");

                    // tampil data di combobox
                    while (rs.next()) {
                            kelurahan.addItem(rs.getString("kelurahan_nama"));
                    }
                    rs.close();
                    st.close();
            } catch (SQLException e) {
                    System.out.println(e.getMessage());
            }
	}

	
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        kabupaten = new javax.swing.JComboBox<String>();
        kecamatan = new javax.swing.JComboBox<String>();
        kelurahan = new javax.swing.JComboBox<String>();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nim = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jurusan = new javax.swing.JComboBox<String>();
        jLabel11 = new javax.swing.JLabel();
        jenis_kelamin = new javax.swing.JComboBox<String>();
        jLabel12 = new javax.swing.JLabel();
        jalan = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();
        printDataMhs = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        printDataAddress = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Form Mahasiswa");

        jLabel2.setText("Kabupaten");

        jLabel3.setText("Kecamatan");

        jLabel4.setText("Kelurahan");

        kabupaten.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                kabupatenItemStateChanged(evt);
            }
        });
        kabupaten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kabupatenActionPerformed(evt);
            }
        });

        kecamatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kecamatanActionPerformed(evt);
            }
        });

        kelurahan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelurahanActionPerformed(evt);
            }
        });

        addButton.setText("Simpan");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Hapus");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Nama");

        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });

        jLabel6.setText("Nim");

        nim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nimActionPerformed(evt);
            }
        });

        jLabel7.setText("Jurusan");

        jLabel8.setText("Info Mahasiswa");

        jLabel9.setText("Info Alamat");

        jLabel10.setText("Daftar Mahasiswa");

        jurusan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sipil", "Arsitektur", "Informatika" }));

        jLabel11.setText("Jenis Kelamin");

        jenis_kelamin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "L", "P" }));

        jLabel12.setText("Jalan");

        editButton.setText("Ubah");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        printDataMhs.setText("Data Mahasiswa");
        printDataMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printDataMhsActionPerformed(evt);
            }
        });

        resetBtn.setText("Reset");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        printDataAddress.setText("Daftar Kabupaten/Kecamatan/kelurahan");
        printDataAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printDataAddressActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(printDataMhs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(printDataAddress)
                .addGap(157, 157, 157))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel11))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(262, 262, 262)
                                        .addComponent(jLabel9))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(nim)
                                                    .addComponent(nama)
                                                    .addComponent(jurusan, 0, 152, Short.MAX_VALUE)
                                                    .addComponent(jenis_kelamin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(89, 89, 89)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel12)
                                                    .addComponent(jLabel4))
                                                .addGap(107, 107, 107))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(addButton)
                                                .addGap(69, 69, 69)
                                                .addComponent(editButton)
                                                .addGap(78, 78, 78)
                                                .addComponent(deleteButton)
                                                .addGap(61, 61, 61)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(kecamatan, 0, 157, Short.MAX_VALUE)
                                            .addComponent(kelurahan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(kabupaten, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jalan)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(resetBtn))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(202, 202, 202)
                                        .addComponent(jLabel1))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(jLabel10)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel12)
                    .addComponent(jalan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(kabupaten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(kecamatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jenis_kelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(kelurahan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(deleteButton)
                    .addComponent(editButton)
                    .addComponent(resetBtn))
                .addGap(19, 19, 19)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(printDataMhs, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printDataAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kabupatenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kabupatenActionPerformed
		
    }//GEN-LAST:event_kabupatenActionPerformed

    private void kecamatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kecamatanActionPerformed
        
    }//GEN-LAST:event_kecamatanActionPerformed

    private void kelurahanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelurahanActionPerformed
		
    }//GEN-LAST:event_kelurahanActionPerformed

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        
    }//GEN-LAST:event_namaActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try {
                // ambil id
                int id = 0;

                // ambil aktif
                int pil = 0;
                String gender = "";
                pil = jenis_kelamin.getSelectedIndex();
                if (pil == 0) {
                        gender = "L";
                } else if (pil == 1) {
                        gender = "P";
                }

                Connection koneksi = (Connection)Koneksi.koneksiDB();
                String sql = "INSERT INTO mahasiswa VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = koneksi.prepareStatement(sql);
                ps.setInt(1, id);
                ps.setString(2, nama.getText());
                ps.setString(3, nim.getText());
                ps.setString(4, jurusan.getSelectedItem().toString());
                ps.setString(5, gender);
                ps.setString(6, jalan.getText());
                ps.setString(7, kabupaten.getSelectedItem().toString());
                ps.setString(8, kecamatan.getSelectedItem().toString());
                ps.setString(9, kelurahan.getSelectedItem().toString());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Berhasil menambahkan");
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Gagal menambah pegawai baru");
                System.out.println(e.toString());
        }
        getDataMahasiswa();
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        String kode = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
        try {
                String sql = "DELETE from mahasiswa WHERE mahasiswa_id=?";
                Connection koneksi = (Connection)Koneksi.koneksiDB();
                PreparedStatement ps = koneksi.prepareStatement(sql);
                ps.setString(1, kode);
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null, "Berhasil menghapus");
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal menghapus");
        }
        getDataMahasiswa();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void kabupatenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_kabupatenItemStateChanged

    }//GEN-LAST:event_kabupatenItemStateChanged

    private void nimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nimActionPerformed
        
    }//GEN-LAST:event_nimActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int baris = jTable1.rowAtPoint(evt.getPoint());
        String nama = jTable1.getValueAt(baris, 1).toString();
        this.nama.setText(nama);
        String nim = jTable1.getValueAt(baris, 2).toString();
        this.nim.setText(nim);
        String jurusan = jTable1.getValueAt(baris, 3).toString();
        this.jurusan.setSelectedItem(jurusan);
        String jenisKelamin = jTable1.getValueAt(baris, 4).toString();
        this.jenis_kelamin.setSelectedItem(jenisKelamin);
        String jalan = jTable1.getValueAt(baris, 5).toString();
        this.jalan.setText(jalan);
        String kabupaten = jTable1.getValueAt(baris, 6).toString();
        this.kabupaten.setSelectedItem(kabupaten);
        String kecamatan = jTable1.getValueAt(baris, 7).toString();
        this.kecamatan.setSelectedItem(kecamatan);
        String kelurahan = jTable1.getValueAt(baris, 8).toString();
        this.kelurahan.setSelectedItem(kelurahan);
    }//GEN-LAST:event_jTable1MouseClicked

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        String kode = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
        try {
                String sql = "UPDATE mahasiswa SET nama_mahasiswa=?, nim=?, jurusan=?, jenis_kelamin=?, jalan=?, kabupaten=?, kecamatan=?, kelurahan=? WHERE mahasiswa_id=?";
                Connection koneksi = (Connection)Koneksi.koneksiDB();
                PreparedStatement ps = koneksi.prepareStatement(sql);

                int pil = 0;
                String gender = "";
                pil = jenis_kelamin.getSelectedIndex();
                if (pil == 0) {
                        gender = "L";
                } else if (pil == 1) {
                        gender = "P";
                }

                ps.setString(1, nama.getText());
                ps.setString(2, nim.getText());
                ps.setString(3, jurusan.getSelectedItem().toString());
                ps.setString(4, gender);
                ps.setString(5, jalan.getText());
                ps.setString(6, kabupaten.getSelectedItem().toString());
                ps.setString(7, kecamatan.getSelectedItem().toString());
                ps.setString(8, kelurahan.getSelectedItem().toString());
                ps.setString(9, kode);
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null, "Berhasil mengubah");
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Gagal mengubah");
                System.out.println(e.getMessage());
        }
        getDataMahasiswa();
    }//GEN-LAST:event_editButtonActionPerformed

    private void printDataMhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printDataMhsActionPerformed
        try {
            InputStream file = getClass().getResourceAsStream("/projectreport/ReportData.jrxml");
            JasperDesign jd = JRXmlLoader.load(file);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, Koneksi.koneksiDB());
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        getDataMahasiswa();
    }//GEN-LAST:event_printDataMhsActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        nama.setText("");
        nim.setText("");
        jurusan.setSelectedIndex(0);
        jenis_kelamin.setSelectedIndex(0);
        jalan.setText("");
        kabupaten.setSelectedIndex(0);
        kecamatan.setSelectedIndex(0);
        kelurahan.setSelectedIndex(0);
    }//GEN-LAST:event_resetBtnActionPerformed

    private void printDataAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printDataAddressActionPerformed
        try {
            InputStream file = getClass().getResourceAsStream("/projectreport/ReportData2.jrxml");
            JasperDesign jd = JRXmlLoader.load(file);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, Koneksi.koneksiDB());
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_printDataAddressActionPerformed

	
	public static void main(String args[]) {
		
            java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                            new FormKabupaten().setVisible(true);
                    }
            });
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jalan;
    private javax.swing.JComboBox<String> jenis_kelamin;
    private javax.swing.JComboBox<String> jurusan;
    private javax.swing.JComboBox<String> kabupaten;
    private javax.swing.JComboBox<String> kecamatan;
    private javax.swing.JComboBox<String> kelurahan;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nim;
    private javax.swing.JButton printDataAddress;
    private javax.swing.JButton printDataMhs;
    private javax.swing.JButton resetBtn;
    // End of variables declaration//GEN-END:variables
}
