/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TugasAkhir;

/**
 *
 * @author fahre
 */
import Database.dbconnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.io.InputStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;




public class MenuKamarPIC extends javax.swing.JFrame {
    /**
     * Creates new form MenuPIC
     */
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    private String imagePath;
    
    public MenuKamarPIC() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        DefaultTableModel model = new DefaultTableModel();
        tblkamar.setModel(model);
        tampilkanDataTabel(); // Panggil metode tampilkanDataTabel() di sini
        tblkamar.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblkamarMouseClicked(evt);
        }
    });
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnsearchActionPerformed(evt);
    }
});
     cbstatuscustomer.addItemListener((ItemEvent e) -> {
         if (e.getStateChange() == ItemEvent.SELECTED) {
             String selectedStatus = (String) cbstatuscustomer.getSelectedItem();
             handleStatusChange(selectedStatus);
         }
        });
     cbfasilitas.addActionListener(e -> {
    String selectedFasilitas = (String) cbfasilitas.getSelectedItem();
    
    if (selectedFasilitas != null) {
        switch (selectedFasilitas) {
            case "Tipe A (Kosongan)":
                txtbiaya.setText("Rp.735.000");
                break;
            case "Tipe B (Kasur, Lemari)":
                txtbiaya.setText("Rp.885.000");
                break;
            case "Tipe C (Ac, Kasur, Lemari)":
                txtbiaya.setText("Rp.1.125.000");
                break;
            default:
                // Pilihan lain, sesuaikan dengan kebutuhan
                break;
        }
        
        String selectedStatus = (String) cbstatuscustomer.getSelectedItem();
        if ("Baru DP (Booking)".equals(selectedStatus)) {
            hitungDanSetPelunasan();
        }
    }
});
        txtbiaya.setEditable(false);
        
        cbstatuscustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbstatuscustomerActionPerformed(evt);
            }
        });
        
        pack();
        cbstatuscustomer.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedStatus = (String) cbstatuscustomer.getSelectedItem();
                handleStatusChange(selectedStatus);
            }
        });
        cbnama.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Mendapatkan nilai yang dipilih dari cbnama
        String selectedName = (String) cbnama.getSelectedItem();
        
        // Jika opsi "Kosong" dipilih
        if (selectedName != null && selectedName.equals("Kosong")) {
            // Mengatur nilai komponen-komponen sesuai dengan kebutuhan
            cbstatuscustomer.setSelectedItem("-");
            txtjumdp.setText("");
            cbstatus.setSelectedItem("Belum Terisi");
            txtbiaya.setText("-");
            cbstatus_pembayaran.setSelectedItem("-");
            txtpelunasan.setText("-");
            cbjenispembayaran.setSelectedItem("-");
        }
    }
});
        isiComboBoxNama();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnhapus = new javax.swing.JButton();
        btntambah = new javax.swing.JButton();
        btnubah = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtnokamar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbstatus = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbfasilitas = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbstatus_pembayaran = new javax.swing.JComboBox<>();
        txtbiaya = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txttglmasuk = new com.toedter.calendar.JDateChooser();
        cbstatuscustomer = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtjumdp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtpelunasan = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbnama = new javax.swing.JComboBox<>();
        cbjenispembayaran = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblkamar = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtsearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnsearch = new javax.swing.JButton();
        btnprint = new javax.swing.JButton();
        btntotalbiaya = new javax.swing.JButton();
        btntotalbiaya1 = new javax.swing.JButton();
        btntotalbiaya2 = new javax.swing.JButton();
        txttampilbiaya = new javax.swing.JTextField();
        txttampildp = new javax.swing.JTextField();
        txttotalpelunasan = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnlogout = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Kamar");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo.png")).getImage());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(64, 61, 61));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("RESIDENCE");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(157, 159, 157));
        jLabel10.setText("NUR");

        btnhapus.setBackground(new java.awt.Color(242, 242, 242));
        btnhapus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnhapus.setText("HAPUS");
        btnhapus.setBorder(null);
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btntambah.setBackground(new java.awt.Color(242, 242, 242));
        btntambah.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btntambah.setText("TAMBAH");
        btntambah.setBorder(null);
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        btnubah.setBackground(new java.awt.Color(242, 242, 242));
        btnubah.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnubah.setText("UBAH");
        btnubah.setBorder(null);
        btnubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnubahActionPerformed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(242, 242, 242));
        jLabel11.setText("Nomor Kamar");

        txtnokamar.setBorder(null);

        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Fasilitas");

        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Status Kamar");

        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("Nama Customer");

        cbstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sudah Terisi", "Belum Terisi", "-" }));

        jLabel12.setForeground(new java.awt.Color(242, 242, 242));
        jLabel12.setText("Tanggal Masuk");

        cbfasilitas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipe A (Kosongan)", "Tipe B (Kasur, Lemari)", "Tipe C (Ac, Kasur, Lemari)", "-" }));

        jLabel6.setForeground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("Status Pembayaran");

        cbstatus_pembayaran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sudah Lunas", "Belum Lunas", "-" }));

        txtbiaya.setBorder(null);

        jLabel13.setForeground(new java.awt.Color(242, 242, 242));
        jLabel13.setText("Harga Sewa");

        cbstatuscustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baru DP (Booking)", "Sudah Lunas", "-" }));

        jLabel7.setForeground(new java.awt.Color(242, 242, 242));
        jLabel7.setText("Status Customer");

        txtjumdp.setBorder(null);

        jLabel8.setForeground(new java.awt.Color(242, 242, 242));
        jLabel8.setText("Jumlah DP");

        txtpelunasan.setBorder(null);

        jLabel14.setForeground(new java.awt.Color(242, 242, 242));
        jLabel14.setText("Kurangnya Biaya Pelunasan");

        cbjenispembayaran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Transfer", "-" }));

        jLabel15.setForeground(new java.awt.Color(242, 242, 242));
        jLabel15.setText("Jenis Pembayaran");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(cbjenispembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(cbstatus_pembayaran, 0, 301, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(cbfasilitas, 0, 301, Short.MAX_VALUE)
                            .addComponent(txtpelunasan)
                            .addComponent(jLabel14))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(cbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtbiaya)
                        .addComponent(txttglmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel7)
                        .addComponent(cbstatuscustomer, 0, 301, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addComponent(txtnokamar, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtjumdp)
                        .addComponent(cbnama, 0, 301, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnubah, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnokamar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(4, 4, 4)
                .addComponent(cbnama, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbstatuscustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtjumdp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbfasilitas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttglmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbstatus_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpelunasan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbjenispembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnubah, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel2.setBackground(new java.awt.Color(253, 253, 253));

        tblkamar.setBackground(new java.awt.Color(253, 253, 253));
        tblkamar.setModel(new javax.swing.table.DefaultTableModel(
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
        tblkamar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblkamarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblkamar);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        txtsearch.setBorder(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(64, 61, 61));
        jLabel2.setText("Search :");

        btnsearch.setBackground(new java.awt.Color(242, 242, 242));
        btnsearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnsearch.setText("search");
        btnsearch.setBorder(null);
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        btnprint.setBackground(new java.awt.Color(242, 242, 242));
        btnprint.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnprint.setText("CETAK DATA");
        btnprint.setBorder(null);
        btnprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintActionPerformed(evt);
            }
        });

        btntotalbiaya.setBackground(new java.awt.Color(242, 242, 242));
        btntotalbiaya.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btntotalbiaya.setText("TOTAL BIAYA");
        btntotalbiaya.setBorder(null);
        btntotalbiaya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntotalbiayaActionPerformed(evt);
            }
        });

        btntotalbiaya1.setBackground(new java.awt.Color(242, 242, 242));
        btntotalbiaya1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btntotalbiaya1.setText("TOTAL DP");
        btntotalbiaya1.setBorder(null);
        btntotalbiaya1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntotalbiaya1ActionPerformed(evt);
            }
        });

        btntotalbiaya2.setBackground(new java.awt.Color(242, 242, 242));
        btntotalbiaya2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btntotalbiaya2.setText("TOTAL PELUNASAN");
        btntotalbiaya2.setBorder(null);
        btntotalbiaya2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntotalbiaya2ActionPerformed(evt);
            }
        });

        txttampilbiaya.setBorder(null);

        txttampildp.setBorder(null);

        txttotalpelunasan.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnprint, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 342, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btntotalbiaya1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btntotalbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txttampildp, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttampilbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txttotalpelunasan)
                    .addComponent(btntotalbiaya2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnprint, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntotalbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntotalbiaya1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntotalbiaya2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttampilbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotalpelunasan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttampildp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jMenuBar1.setMinimumSize(new java.awt.Dimension(81, 35));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(81, 35));

        jMenu1.setText("Exit");

        mnlogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logout.png"))); // NOI18N
        mnlogout.setText("Logout");
        mnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnlogoutActionPerformed(evt);
            }
        });
        jMenu1.add(mnlogout);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Manage");

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/home.png"))); // NOI18N
        jMenuItem6.setText("Home");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/person.png"))); // NOI18N
        jMenu5.setText("Manage Person");

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/customer.png"))); // NOI18N
        jMenuItem8.setText("Customer");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem8);

        jMenu2.add(jMenu5);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/managekeuangan.png"))); // NOI18N
        jMenu7.setText("Manage Keuangan");

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/biaya.png"))); // NOI18N
        jMenuItem10.setText("Pengeluaran");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem10);

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/report.png"))); // NOI18N
        jMenuItem11.setText("Laporan Bulanan");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem11);

        jMenu2.add(jMenu7);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Service");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/maintenance.png"))); // NOI18N
        jMenuItem2.setText("Maintenance");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Information");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/biaya.png"))); // NOI18N
        jMenuItem3.setText("Cetak Informasi Tarif Kontrakan");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/peraturan.png"))); // NOI18N
        jMenuItem4.setText("Cetak Peraturan Kontrakan");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/maintenance_report.png"))); // NOI18N
        jMenuItem5.setText("Cetak Informasi Maintenance");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void handleStatusChange(String selectedStatus) {
    switch (selectedStatus) {
        case "Baru DP (Booking)":
            txtjumdp.setEnabled(true);
            txtpelunasan.setEnabled(true);
            cbstatus_pembayaran.setSelectedItem("Belum Lunas");
            cbstatus_pembayaran.setEnabled(false);
            break;
        case "Sudah Lunas":
            txtjumdp.setText("-");
            txtjumdp.setEnabled(false);
            txtpelunasan.setText("-");
            txtpelunasan.setEnabled(false);
            cbstatus_pembayaran.setSelectedItem("Sudah Lunas");
            cbstatus_pembayaran.setEnabled(false);

            break;
        default:
            break;
    }
}
    private void isiComboBoxNama() { //Combobox nama otomatis
        try {
            // Mendapatkan koneksi dari kelas dbconnection
            Connection conn = dbconnection.koneksi();

            // Query SQL untuk mengambil semua nama dari tabel customer
            String query = "SELECT nama FROM customer";

            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();
                // Bersihkan isi ComboBox cbnama sebelum menambahkan data baru
                cbnama.removeAllItems();
                // Tambahkan setiap nama ke dalam ComboBox cbnama
                while (rs.next()) {
                    cbnama.addItem(rs.getString("nama"));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Gagal mengisi ComboBox nama: " + e.getMessage());
            e.printStackTrace(); // Menampilkan stack trace untuk debug
        }
    }

    private boolean isNamaExist(String nama) throws SQLException {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        // Mendapatkan koneksi dari kelas dbconnection
        conn = dbconnection.koneksi();
        // Query SQL untuk memeriksa apakah nama sudah ada dalam tabel customer
        String query = "SELECT COUNT(*) FROM kamar WHERE nama = ?";
        ps = conn.prepareStatement(query);
        ps.setString(1, nama);
        rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            // Jika count lebih dari 0, berarti nama sudah ada
            return count > 0;
        }
    } finally {
        // Menutup koneksi, PreparedStatement, dan ResultSet
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    return false;
}
    private boolean isNoKamarExist(String noKamar) throws SQLException {
    Connection conn = dbconnection.koneksi();
    String query = "SELECT COUNT(*) FROM kamar WHERE no_kamar = ?";
    try (PreparedStatement ps = conn.prepareStatement(query)) {
        ps.setString(1, noKamar);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        }
    }
    return false;
}
    private void hitungDanSetPelunasan() {
    // Mendapatkan nilai dari txtjumdp dan txtbiaya
    String strJumDP = txtjumdp.getText().equals("-") ? "0" : txtjumdp.getText();
    String strBiaya = txtbiaya.getText().replaceAll("[^0-9]", "");

    try {
        // Mengonversi string ke dalam nilai numerik
        double jumDP = NumberFormat.getNumberInstance().parse(strJumDP).doubleValue();
        double biaya = NumberFormat.getNumberInstance().parse(strBiaya).doubleValue();

        // Menghitung pelunasan
        double pelunasan = biaya - jumDP;

        // Mengatur nilai txtPelunasan dengan format mata uang yang diinginkan
        txtpelunasan.setText("Rp." + NumberFormat.getInstance().format(pelunasan));
    } catch (ParseException e) {
        e.printStackTrace(); // Handle kesalahan pengonversian jika diperlukan
    }
}
    private void cbstatuscustomerActionPerformed(java.awt.event.ActionEvent evt) {
        String statusCustomer = (String) cbstatuscustomer.getSelectedItem();

    if (statusCustomer.equals("Baru DP (Booking)")) {
        aturInputJumlahDP(true);
        aturInputPelunasan(false, "");
        
        // Set cbstatus menjadi "Belum Lunas" dan nonaktifkan
        cbstatus_pembayaran.setSelectedItem("Belum Lunas");
        cbstatus_pembayaran.setEnabled(false);
    } else if (statusCustomer.equals("Sudah Lunas")) {
        aturInputJumlahDP(false);
        aturInputPelunasan(false, "-");
        
        // Set cbstatus menjadi "Sudah Lunas" dan nonaktifkan
        cbstatus_pembayaran.setSelectedItem("Sudah Lunas");
        cbstatus_pembayaran.setEnabled(false);
    }    
        
    }
    
    private void aturInputJumlahDP(boolean aktif) {
        txtjumdp.setEnabled(aktif);
        txtjumdp.setText("");
    }

    private void aturInputPelunasan(boolean aktif, String nilai) {
        txtpelunasan.setEnabled(aktif);
        txtpelunasan.setText(nilai);
    }
    private void mnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnlogoutActionPerformed
        // TODO add your handling code here:
        LoginForm pindah = new LoginForm();
        pindah.setVisible(true);
        dispose();
    }//GEN-LAST:event_mnlogoutActionPerformed
    
    private void tampilkanDataTabel() {
         try {
        Connection conn = dbconnection.koneksi();
        String sql = "SELECT * FROM kamar";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        // Menggunakan DefaultTableModel untuk menampung data dari ResultSet
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nomor Kamar");
        model.addColumn("Nama Customer");
        model.addColumn("Status Customer");
        model.addColumn("Jumlah DP");
        model.addColumn("Status Kamar");
        model.addColumn("Fasilitas");
        model.addColumn("Tanggal Masuk");
        model.addColumn("Biaya Sewa Bulanan");
        model.addColumn("Status Pembayaran");
        model.addColumn("Biaya Pelunasan");
        model.addColumn("Jenis Pembayaran");

        while (rs.next()) {
            // Ambil data dari ResultSet
            String no_kamar = rs.getString("no_kamar");
            String namaCustomer = rs.getString("nama");
            String statusCustomer = rs.getString("status_customer");
            String jumlahDp = rs.getString("jumlahdp");
            String status = rs.getString("status_kamar");
            String fasilitas = rs.getString("fasilitas");

            // Mengambil data tanggal dari ResultSet
            java.util.Date tglMasukDate = rs.getDate("tgl_masuk");

            String biaya = rs.getString("biaya");
            String statusPembayaran = rs.getString("status_pembayaran");
            String biayaPelunasan = rs.getString("biaya_pelunasan");
            String jenisPembayaran = rs.getString("jenis_pembayaran");

            // Tambahkan data ke dalam model
            model.addRow(new Object[]{no_kamar, namaCustomer, statusCustomer, jumlahDp, status, fasilitas, tglMasukDate, biaya, statusPembayaran, biayaPelunasan, jenisPembayaran});
        }

        // Set model ke dalam tabel
        tblkamar.setModel(model);

        // Aktifkan pengurutan pada tabel
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        tblkamar.setRowSorter(sorter);

        // Atur pengurutan awal (misalnya, berdasarkan kolom "Nomor Kamar" secara default)
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        sorter.sort();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(rootPane, "Error saat menampilkan data: " + e.getMessage());
    } finally {
        // Tidak perlu menutup koneksi di sini karena koneksi didapatkan dari kelas dbconnection
    }
    }
    private void tampilkanData() {
         try {
        Connection conn = dbconnection.koneksi();
        String sql = "SELECT * FROM kamar";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        // Menggunakan DefaultTableModel untuk menampung data dari ResultSet
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nomor Kamar");
        model.addColumn("Nama Customer");
        model.addColumn("Status Customer");
        model.addColumn("Jumlah DP");
        model.addColumn("Status Kamar");
        model.addColumn("Fasilitas");
        model.addColumn("Tanggal Masuk");
        model.addColumn("Biaya Sewa Bulanan");
        model.addColumn("Status Pembayaran");
        model.addColumn("Biaya Pelunasan");
        model.addColumn("Jenis Pembayaran");

        while (rs.next()) {
            // Ambil data dari ResultSet
            String no_kamar = rs.getString("no_kamar");
            String namaCustomer = rs.getString("nama");
            String statusCustomer = rs.getString("status_customer");
            String jumlahDp = rs.getString("jumlahdp");
            String status = rs.getString("status_kamar");
            String fasilitas = rs.getString("fasilitas");

            // Mengambil data tanggal dari ResultSet
            java.util.Date tglMasukDate = rs.getDate("tgl_masuk");

            String biaya = rs.getString("biaya");
            String statusPembayaran = rs.getString("status_pembayaran");
            String biayaPelunasan = rs.getString("biaya_pelunasan");
            String jenisPembayaran = rs.getString("jenis_pembayaran");

            // Tambahkan data ke dalam model
            model.addRow(new Object[]{no_kamar, namaCustomer, statusCustomer, jumlahDp, status, fasilitas, tglMasukDate, biaya, statusPembayaran, biayaPelunasan, jenisPembayaran});
        }

        // Set model ke dalam tabel
        tblkamar.setModel(model);

        // Aktifkan pengurutan pada tabel
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        tblkamar.setRowSorter(sorter);

        // Atur pengurutan awal (misalnya, berdasarkan kolom "Nomor Kamar" secara default)
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        sorter.sort();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(rootPane, "Error saat menampilkan data: " + e.getMessage());
    } finally {
        // Tidak perlu menutup koneksi di sini karena koneksi didapatkan dari kelas dbconnection
    }
    }
    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
     try {
        // Mendapatkan koneksi dari kelas dbconnection
        Connection conn = dbconnection.koneksi();

        // Pengambilan nilai dari inputan pencarian
        String searchText = txtsearch.getText();

        // Cek apakah searchText kosong
        if (searchText.isEmpty()) {
            tampilkanDataTabel(); // Jika kosong, tampilkan semua data
            return;
        }

        // Query SQL untuk melakukan pencarian berdasarkan teks pada kolom tertentu
        String searchQuery = "SELECT * FROM kamar WHERE no_kamar LIKE ? OR nama LIKE ? OR status_customer LIKE ? OR jumlahdp LIKE ? OR fasilitas LIKE ?  OR status_kamar LIKE ? OR tgl_masuk LIKE ? OR biaya LIKE ? OR status_pembayaran LIKE ? OR biaya_pelunasan LIKE ?OR jenis_pembayaran LIKE ?";
        PreparedStatement ps = conn.prepareStatement(searchQuery);
        ps.setString(1, "%" + searchText + "%");
        ps.setString(2, "%" + searchText + "%");
        ps.setString(3, "%" + searchText + "%");
        ps.setString(4, "%" + searchText + "%");
        ps.setString(5, "%" + searchText + "%");
        ps.setString(6, "%" + searchText + "%");
        ps.setString(7, "%" + searchText + "%");
        ps.setString(8, "%" + searchText + "%");
        ps.setString(9, "%" + searchText + "%");
        ps.setString(10, "%" + searchText + "%");
        ps.setString(11, "%" + searchText + "%");

        ResultSet rs = ps.executeQuery();

        // Menghapus semua baris dalam model tabel
        DefaultTableModel model = (DefaultTableModel) tblkamar.getModel();
        model.setRowCount(0);

        // Menambahkan hasil pencarian ke dalam model tabel
        while (rs.next()) {
            Object[] row = {
                rs.getString("no_kamar"),
                rs.getString("nama"),
                rs.getString("status_customer"),
                rs.getString("jumlahdp"),
                rs.getString("fasilitas"),
                rs.getString("status_kamar"),
                rs.getString("tgl_masuk"),
                rs.getString("biaya"),
                rs.getString("status_pembayaran"), 
                rs.getString("biaya_pelunasan"),
                rs.getString("jenis_pembayaran"),
            };
            model.addRow(row);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(rootPane, "Pencarian gagal: " + e.getMessage());
    }
    }//GEN-LAST:event_btnsearchActionPerformed

    private void tblkamarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkamarMouseClicked
        int baris = tblkamar.rowAtPoint(evt.getPoint());

    txtnokamar.setText(tblkamar.getValueAt(baris, 0).toString());
    String nama = tblkamar.getValueAt(baris, 1).toString();
    cbnama.setSelectedItem(nama);
    
    String statusCustomer = tblkamar.getValueAt(baris, 2).toString();
    cbstatuscustomer.setSelectedItem(statusCustomer);
    
    txtjumdp.setText(tblkamar.getValueAt(baris, 3).toString());
    
    String fasilitas = tblkamar.getValueAt(baris, 4).toString();
    cbfasilitas.setSelectedItem(fasilitas);
    String statusKamar = tblkamar.getValueAt(baris, 5).toString();
    cbstatus.setSelectedItem(statusKamar);

    Date tanggalMasuk = (Date) tblkamar.getValueAt(baris, 6);

    if (tanggalMasuk != null) {
        // Mengatur nilai tanggal langsung ke JDateChooser
        txttglmasuk.setDate(tanggalMasuk);
    }
    txtbiaya.setText(tblkamar.getValueAt(baris, 7).toString());
    
    String statusPembayaran = tblkamar.getValueAt(baris, 8).toString();
    cbstatus_pembayaran.setSelectedItem(statusPembayaran);
    
    txtpelunasan.setText(tblkamar.getValueAt(baris, 9).toString());
    
    String jenisPembayaran = tblkamar.getValueAt(baris, 10).toString();
    cbjenispembayaran.setSelectedItem(jenisPembayaran);
    
    }//GEN-LAST:event_tblkamarMouseClicked

    private void btnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahActionPerformed
        try {
        // Mendapatkan koneksi dari kelas dbconnection
        Connection conn = dbconnection.koneksi();

        // Pengambilan nilai dari inputan pengguna
        String noKamarUpdateInput = txtnokamar.getText();
        String nama = (String) cbnama.getSelectedItem();
        String statusCustomer = (String) cbstatuscustomer.getSelectedItem();
        String jumlahDp = txtjumdp.getText();
        String status = (String) cbstatus.getSelectedItem();
        String fasilitas = (String) cbfasilitas.getSelectedItem();

        // Mengambil nilai tanggal dari JDateChooser
        Date tglMasukDate = txttglmasuk.getDate();

        // Mengubah nilai Date menjadi String dengan format yang sesuai
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String tglMasuk = (tglMasukDate != null) ? dateFormat.format(tglMasukDate) : null;

        String biaya = txtbiaya.getText();
        String statusPembayaran = (String) cbstatus_pembayaran.getSelectedItem();
        String biayaPelunasan = txtpelunasan.getText();
        
        String jenisPembayaran = (String) cbjenispembayaran.getSelectedItem();

        // Query SQL untuk memeriksa apakah no_kamar sudah ada
        String checkIdkamarQuery = "SELECT COUNT(*) FROM kamar WHERE no_kamar = ?";
        try (PreparedStatement checkIdkamarPS = conn.prepareStatement(checkIdkamarQuery)) {
            checkIdkamarPS.setString(1, noKamarUpdateInput);
            try (ResultSet rs = checkIdkamarPS.executeQuery()) {
                if (!rs.next() || rs.getInt(1) == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Data dengan Nomor Kamar tersebut tidak ditemukan");
                    return;
                }
            }
        }

        // Query SQL untuk mengubah data pada tabel kamar
        String updateQuery = "UPDATE kamar SET nama = ?, status_customer = ?, jumlahdp = ?, status_kamar = ?, fasilitas = ?, tgl_masuk = ?, biaya = ?, status_pembayaran = ?, biaya_pelunasan = ?, jenis_pembayaran = ? WHERE no_kamar = ?";
        try (PreparedStatement ps = conn.prepareStatement(updateQuery)) {
            ps.setString(1, nama);
            ps.setString(2, statusCustomer);
            ps.setString(3, jumlahDp);
            ps.setString(4, status);
            ps.setString(5, fasilitas);
            ps.setString(6, tglMasuk);
            ps.setString(7, biaya);
            ps.setString(8, statusPembayaran);
            ps.setString(9, biayaPelunasan);
            ps.setString(10, jenisPembayaran);
            ps.setString(11, noKamarUpdateInput);

            int updateResult = ps.executeUpdate();
            if (updateResult > 0) {
                JOptionPane.showMessageDialog(rootPane, "Data berhasil diubah");
                tampilkanData(); // Tampilkan kembali data pada tabel setelah mengubah
            } else {
                JOptionPane.showMessageDialog(rootPane, "Data gagal diubah");
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(rootPane, "Ubah data gagal: " + e.getMessage());
        e.printStackTrace(); // Menampilkan stack trace untuk debug
    }
    kosongkan();
    }//GEN-LAST:event_btnubahActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        try {
        // Mendapatkan nilai nama dari ComboBox cbnama
        String nama = (String) cbnama.getSelectedItem();
        // Memeriksa apakah nama tidak kosong
        if (nama == null || nama.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Nama Customer tidak boleh kosong");
            return; // Keluar dari method jika nama kosong
        }

        // Mendapatkan koneksi dari kelas dbconnection
        Connection conn = dbconnection.koneksi();

        // Pengambilan nilai dari inputan pengguna
        String noKamarInput = txtnokamar.getText();
        // Format noKamar menjadi "K-XX"
        String noKamar = String.format("K-%02d", Integer.valueOf(noKamarInput));

        // Memeriksa apakah nomor kamar sudah ada dalam database
        if (isNoKamarExist(noKamar)) {
            JOptionPane.showMessageDialog(rootPane, "Nomor Kamar Sudah Ada!");
            return; // Keluar dari method jika nomor kamar sudah ada
        }

        String status_customer = (String) cbstatuscustomer.getSelectedItem();
        String jumlahdp = txtjumdp.getText();
        String status = (String) cbstatus.getSelectedItem();
        String fasilitas = (String) cbfasilitas.getSelectedItem(); 
        Date tglMasukDate = txttglmasuk.getDate();
        String biaya = txtbiaya.getText();
        String statusPembayaran = (String) cbstatus_pembayaran.getSelectedItem();
        String biayaPelunasan = txtpelunasan.getText();
        String jenisPembayaran = (String) cbjenispembayaran.getSelectedItem(); 
        
        // Query SQL untuk menambahkan data baru ke tabel kamar
        String insertQuery = "INSERT INTO kamar (no_kamar, nama, status_customer, jumlahdp, status_kamar, fasilitas, tgl_masuk, biaya, status_pembayaran, biaya_pelunasan, jenis_pembayaran) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(insertQuery)) {
            ps.setString(1, noKamar);
            ps.setString(2, nama);
            ps.setString(3, status_customer);
            ps.setString(4, jumlahdp);
            ps.setString(5, status);
            ps.setString(6, fasilitas);
            ps.setDate(7, (tglMasukDate != null) ? new java.sql.Date(tglMasukDate.getTime()) : null);
            ps.setString(8, biaya);
            ps.setString(9, statusPembayaran);
            ps.setString(10, biayaPelunasan);
            ps.setString(11, jenisPembayaran);
            
            int updateResult = ps.executeUpdate();
            if (updateResult > 0) {
                JOptionPane.showMessageDialog(rootPane, "Data berhasil ditambahkan");
                kosongkan(); // Setelah berhasil, kosongkan inputan
                tampilkanData(); // Tampilkan kembali data pada tabel
            } else {
                JOptionPane.showMessageDialog(rootPane, "Data gagal ditambahkan");
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(rootPane, "Tambah data gagal: " + e.getMessage());
        e.printStackTrace(); // Menampilkan stack trace untuk debug
    }
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        try {
            // Mendapatkan koneksi dari kelas dbconnection
            Connection conn = dbconnection.koneksi();

            // Pengambilan nilai id_pic dari inputan pengguna
            String idkamarToDelete = txtnokamar.getText(); // Gantilah dengan komponen input yang sesuai

            // Query SQL untuk menghapus data berdasarkan id_pic
            String deleteQuery = "DELETE FROM kamar WHERE no_kamar = ?";
            PreparedStatement deletePS = conn.prepareStatement(deleteQuery);
            deletePS.setString(1, idkamarToDelete);

            int deleteResult = deletePS.executeUpdate();
            if (deleteResult > 0) {
                JOptionPane.showMessageDialog(rootPane, "Data berhasil dihapus");
                tampilkanData(); // Tampilkan kembali data pada tabel setelah menghapus
            } else {
                JOptionPane.showMessageDialog(rootPane, "Data dengan Nomor Kamar tersebut tidak ditemukan");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Hapus data gagal: " + ex.getMessage());
        }
        kosongkan();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintActionPerformed
        // TODO add your handling code here:
        try {
        // Mendapatkan input stream dari file JasperReport
        InputStream reportStream;
            reportStream = getClass().getResourceAsStream("/Reports/Report_DataKamar.jasper");

        // Memeriksa apakah input stream berhasil didapatkan
        if (reportStream != null) {
            // Mengisi laporan dengan data dari database dan file JasperReport
            JasperPrint jp = JasperFillManager.fillReport(reportStream, null, dbconnection.koneksi());
            
            // Menampilkan laporan menggunakan JasperViewer
            JasperViewer.viewReport(jp, false);
        } else {
            JOptionPane.showMessageDialog(this, "JasperReport file not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (JRException e) {
        JOptionPane.showMessageDialog(this, "Error Displaying Report: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnprintActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        MenuServicePIC pindah = new MenuServicePIC();
        pindah.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        try {
            // Mendapatkan input stream dari file JasperReport
            InputStream reportStream;
            reportStream = getClass().getResourceAsStream("/Reports/InformasiTarif.jasper");

            // Memeriksa apakah input stream berhasil didapatkan
            if (reportStream != null) {
                // Mengisi laporan dengan data dari database dan file JasperReport
                JasperPrint jp = JasperFillManager.fillReport(reportStream, null, dbconnection.koneksi());

                // Menampilkan laporan menggunakan JasperViewer
                JasperViewer.viewReport(jp, false);
            } else {
                JOptionPane.showMessageDialog(this, "JasperReport file not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (JRException e) {
            JOptionPane.showMessageDialog(this, "Error Displaying Report: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        try {
            // Mendapatkan input stream dari file JasperReport
            InputStream reportStream;
            reportStream = getClass().getResourceAsStream("/Reports/InformasiPeraturan.jasper");

            // Memeriksa apakah input stream berhasil didapatkan
            if (reportStream != null) {
                // Mengisi laporan dengan data dari database dan file JasperReport
                JasperPrint jp = JasperFillManager.fillReport(reportStream, null, dbconnection.koneksi());

                // Menampilkan laporan menggunakan JasperViewer
                JasperViewer.viewReport(jp, false);
            } else {
                JOptionPane.showMessageDialog(this, "JasperReport file not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (JRException e) {
            JOptionPane.showMessageDialog(this, "Error Displaying Report: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        try {
            // Mendapatkan input stream dari file JasperReport
            InputStream reportStream;
            reportStream = getClass().getResourceAsStream("/Reports/InformasiKerusakan.jasper");

            // Memeriksa apakah input stream berhasil didapatkan
            if (reportStream != null) {
                // Mengisi laporan dengan data dari database dan file JasperReport
                JasperPrint jp = JasperFillManager.fillReport(reportStream, null, dbconnection.koneksi());

                // Menampilkan laporan menggunakan JasperViewer
                JasperViewer.viewReport(jp, false);
            } else {
                JOptionPane.showMessageDialog(this, "JasperReport file not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (JRException e) {
            JOptionPane.showMessageDialog(this, "Error Displaying Report: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void btntotalbiayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntotalbiayaActionPerformed
        int totalBiaya = 0;

    // Mengambil model dari tabel
    DefaultTableModel model = (DefaultTableModel) tblkamar.getModel();

    // Melakukan iterasi pada setiap baris tabel
    for (int i = 0; i < model.getRowCount(); i++) {
        // Mengambil nilai biaya dari setiap baris
        String biayaString = (String) model.getValueAt(i, 7); // Kolom biaya adalah indeks 7

        // Jika biaya kosong, ubah menjadi "0"
        if (biayaString.isEmpty()) {
            biayaString = "0";
        }

        // Menghapus "Rp." dan karakter pemisah ribuan (".")
        biayaString = biayaString.replace("Rp.", "").replace(".", "").trim();

        // Mengubah "-" menjadi nilai 0
        if (biayaString.equals("-")) {
            biayaString = "0";
        }

        // Mengkonversi string menjadi angka
        int biaya = Integer.parseInt(biayaString);

        // Menambahkan biaya ke totalBiaya
        totalBiaya += biaya;
    }

    // Format angka dengan pemisah ribuan
    DecimalFormat formatter = (DecimalFormat) DecimalFormat.getInstance();
    formatter.applyPattern("#,###");

    // Menampilkan total biaya di txttampilbiaya
    txttampilbiaya.setText("Rp. " + formatter.format(totalBiaya));

    try {
        // Siapkan koneksi ke database
        Connection conn = dbconnection.koneksi();

        // Siapkan SQL SELECT query untuk memeriksa apakah data sudah ada sebelumnya
        String checkQuery = "SELECT total_pendapatan FROM total_keuntungan";

        // Persiapkan PreparedStatement untuk mengeksekusi query
        PreparedStatement checkPs = conn.prepareStatement(checkQuery);

        // Eksekusi query SELECT untuk mendapatkan hasil
        ResultSet rs = checkPs.executeQuery();

        // Jika ada hasil, berarti data sudah ada sebelumnya
        if (rs.next()) {
            // Beritahu user bahwa data sudah ada di database
            JOptionPane.showMessageDialog(null, "Data sudah ada dalam database.");
        } else {
            // Jika tidak ada hasil, berarti data belum ada
            // Siapkan SQL INSERT query
            String insertQuery = "INSERT INTO total_keuntungan (total_pendapatan) VALUES (?)";

            // Persiapkan PreparedStatement
            PreparedStatement insertPs = conn.prepareStatement(insertQuery);

            // Masukkan total biaya ke dalam PreparedStatement
            insertPs.setInt(1, totalBiaya);

            // Eksekusi query INSERT
            insertPs.executeUpdate();

            // Tutup PreparedStatement dan koneksi
            insertPs.close();
            conn.close();

            // Beritahu user bahwa total biaya telah disimpan
            JOptionPane.showMessageDialog(null, "Total biaya telah disimpan ke dalam database.");
        }

        // Tutup PreparedStatement dan koneksi
        checkPs.close();
        conn.close();
    } catch (Exception e) {
        // Tangani jika terjadi kesalahan
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_btntotalbiayaActionPerformed

    private void btntotalbiaya1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntotalbiaya1ActionPerformed
         int totalJumlahDP = 0;

    // Mengambil model dari tabel
    DefaultTableModel model = (DefaultTableModel) tblkamar.getModel();

    // Melakukan iterasi pada setiap baris tabel
    for (int i = 0; i < model.getRowCount(); i++) {
        // Mengambil nilai jumlahdp dari setiap baris
        String jumlahDPString = (String) model.getValueAt(i, 3); // Kolom jumlahdp adalah indeks 3
        
        // Menghapus karakter pemisah ribuan (",") jika ada
        jumlahDPString = jumlahDPString.replaceAll("[^0-9]", "");
        
        // Mengkonversi string menjadi angka, jika string kosong, ubah menjadi 0
        int jumlahDP = jumlahDPString.isEmpty() ? 0 : Integer.parseInt(jumlahDPString);
        
        // Menambahkan jumlahdp ke totalJumlahDP
        totalJumlahDP += jumlahDP;
    }

    // Format angka dengan pemisah ribuan dan simbol mata uang "Rp."
    DecimalFormat formatter = (DecimalFormat) DecimalFormat.getInstance();
    formatter.applyPattern("#,###");

    // Menampilkan total jumlah DP di txttampildp
    txttampildp.setText("Rp. " + formatter.format(totalJumlahDP));
    }//GEN-LAST:event_btntotalbiaya1ActionPerformed

    private void btntotalbiaya2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntotalbiaya2ActionPerformed
         int totalBiayaPelunasan = 0;

    // Mengambil model dari tabel
    DefaultTableModel model = (DefaultTableModel) tblkamar.getModel();

    // Melakukan iterasi pada setiap baris tabel
    for (int i = 0; i < model.getRowCount(); i++) {
        // Mengambil nilai biaya_pelunasan dari setiap baris
        String biayaPelunasanString = (String) model.getValueAt(i, 9); // Kolom biaya_pelunasan adalah indeks 9
        
        // Menghilangkan "Rp." dan karakter pemisah ribuan (",") jika ada
        biayaPelunasanString = biayaPelunasanString.replace("Rp.", "").replaceAll("[^0-9-]", "");
        
        // Mengkonversi string menjadi angka, jika string kosong, ubah menjadi 0
        int biayaPelunasan = 0;
        if (!biayaPelunasanString.isEmpty()) {
            // Mengubah "-" menjadi nilai 0
            biayaPelunasan = biayaPelunasanString.equals("-") ? 0 : Integer.parseInt(biayaPelunasanString);
        }
        
        // Menambahkan biaya_pelunasan ke totalBiayaPelunasan
        totalBiayaPelunasan += biayaPelunasan;
    }

    // Format angka dengan pemisah ribuan dan simbol mata uang "Rp."
    DecimalFormat formatter = (DecimalFormat) DecimalFormat.getInstance();
    formatter.applyPattern("#,###");

    // Menampilkan total biaya pelunasan di txttotalpelunasan
    txttotalpelunasan.setText("Rp. " + formatter.format(totalBiayaPelunasan));
    }//GEN-LAST:event_btntotalbiaya2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        MenuUtamaPIC pindah = new MenuUtamaPIC();
        pindah.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        MenuCustomerPIC pindah = new MenuCustomerPIC();
        pindah.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        MenuPengeluaranPIC pindah = new MenuPengeluaranPIC();
        pindah.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        MenuLaporanBulananPIC pindah = new MenuLaporanBulananPIC();
        pindah.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem11ActionPerformed
    
    private void kosongkan() {
    txtnokamar.setText("");
    txttglmasuk.setDate(null); // Mengosongkan JDateChooser
    txtbiaya.setText("");
    txtjumdp.setText("");
    txtpelunasan.setText("");
 
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuKamarPIC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuKamarPIC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuKamarPIC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuKamarPIC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuKamarPIC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnprint;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton btntambah;
    private javax.swing.JButton btntotalbiaya;
    private javax.swing.JButton btntotalbiaya1;
    private javax.swing.JButton btntotalbiaya2;
    private javax.swing.JButton btnubah;
    private javax.swing.JComboBox<String> cbfasilitas;
    private javax.swing.JComboBox<String> cbjenispembayaran;
    private javax.swing.JComboBox<String> cbnama;
    private javax.swing.JComboBox<String> cbstatus;
    private javax.swing.JComboBox<String> cbstatus_pembayaran;
    private javax.swing.JComboBox<String> cbstatuscustomer;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnlogout;
    private javax.swing.JTable tblkamar;
    private javax.swing.JTextField txtbiaya;
    private javax.swing.JTextField txtjumdp;
    private javax.swing.JTextField txtnokamar;
    private javax.swing.JTextField txtpelunasan;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txttampilbiaya;
    private javax.swing.JTextField txttampildp;
    private com.toedter.calendar.JDateChooser txttglmasuk;
    private javax.swing.JTextField txttotalpelunasan;
    // End of variables declaration//GEN-END:variables
}
