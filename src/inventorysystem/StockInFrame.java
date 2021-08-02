package inventorysystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class StockInFrame extends javax.swing.JFrame {
    
    MainFrame myFrame;
    ItemDatabaseManager itemDatabaseManager;

    ArrayList<String> itemIdList;
    ArrayList<String> itemNameList;
    ArrayList<String> itemCategoryList;
    ArrayList<Double> itemQuantityList;
    ArrayList<Double> itemCostList;
    ArrayList<String> itemSupplierList;
    ArrayList<Double> itemStockInList;
    ArrayList<String> itemBrandList;
    ArrayList<String> itemArticleList;

    ArrayList<String> newItemIdList = new ArrayList<>();
    ArrayList<String> newItemNameList = new ArrayList<>();
    ArrayList<String> newItemCategoryList = new ArrayList<>();
    ArrayList<Double> newItemQuantityList = new ArrayList<>();
    ArrayList<Double> newItemCostList = new ArrayList<>();
    ArrayList<String> newItemSupplierList = new ArrayList<>();
    ArrayList<Double> newItemTotalCostList = new ArrayList<>();
    ArrayList<String> newItemBrandList = new ArrayList<>();
    ArrayList<String> newItemArticleList = new ArrayList<>();
    
    ArrayList<Double> newItemStockInList = new ArrayList<>();

    private final int MODE_PROCESS = 0;
    private final int MODE_FILTER_CATEGORY = 1;
    private final int MODE_FILTER_SEARCH = 2;
    
    private final int MODE_UNSORT = 1;
  
    //NOT PAID = 1
    //PAID = 0
    
    DefaultTableModel dtm;
    DefaultTableModel dtm2;
    
    boolean ready = false;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        yearCombo = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        dayCombo = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        monthCombo = new javax.swing.JComboBox<>();
        labelItem = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        labelCost = new javax.swing.JLabel();
        cashRadio = new javax.swing.JRadioButton();
        chequeRadio = new javax.swing.JRadioButton();
        stockin_chequeField = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        monthCombo1 = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        dayCombo1 = new javax.swing.JComboBox<>();
        yearCombo1 = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        purchaseButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        oldTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        newTable = new javax.swing.JTable();
        stockIn_searchBar = new javax.swing.JTextField();
        categoryCombo = new javax.swing.JComboBox<>();
        supplierCombo = new javax.swing.JComboBox<>();
        addButton = new javax.swing.JButton();
        minusButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Stock-in");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Total Item/s");
        jLabel11.setToolTipText("");

        yearCombo.setFocusable(false);
        yearCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel18.setText("/");

        confirmButton.setBackground(new java.awt.Color(255, 255, 255));
        confirmButton.setText("Confirm Stock In Items");
        confirmButton.setFocusable(false);
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText((char)8369 + "");
        jLabel17.setToolTipText("");

        dayCombo.setFocusable(false);
        dayCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayComboActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Total Cost");

        monthCombo.setFocusable(false);
        monthCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboActionPerformed(evt);
            }
        });

        labelItem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelItem.setText("0.0");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Stock in Date");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel19.setText("/");

        labelCost.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelCost.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelCost.setText("0.0");

        cashRadio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cashRadio.setSelected(true);
        cashRadio.setText("Cash");
        cashRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashRadioActionPerformed(evt);
            }
        });

        chequeRadio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chequeRadio.setText("Cheque #");
        chequeRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chequeRadioActionPerformed(evt);
            }
        });

        stockin_chequeField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Due Date");

        monthCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthCombo1ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel24.setText("/");

        yearCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearCombo1ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel25.setText("/");

        purchaseButton.setBackground(new java.awt.Color(255, 255, 255));
        purchaseButton.setText("Create Purchase Order");
        purchaseButton.setFocusable(false);
        purchaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(27, 27, 27)
                        .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(dayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelItem)
                                    .addComponent(labelCost))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11)))
                    .addComponent(cashRadio, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chequeRadio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stockin_chequeField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(monthCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(dayCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(yearCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(purchaseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(confirmButton, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(cashRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chequeRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stockin_chequeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(monthCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dayCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(yearCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelItem)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(labelCost)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(103, 103, 103)
                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(purchaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        oldTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            }, new String[]
            {

            }
        ));
        oldTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        oldTable.setSelectionBackground(new java.awt.Color(177, 0, 0));
        oldTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        oldTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        oldTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(oldTable);

        newTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            }, new String[]
            {

            }
        ));
        newTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        newTable.setSelectionBackground(new java.awt.Color(177, 0, 0));
        newTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        newTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        newTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(newTable);

        stockIn_searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stockIn_searchBarKeyReleased(evt);
            }
        });

        categoryCombo.setForeground(new java.awt.Color(255, 255, 255));
        categoryCombo.setFocusable(false);
        categoryCombo.setRequestFocusEnabled(false);
        categoryCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboActionPerformed(evt);
            }
        });

        supplierCombo.setFocusable(false);
        supplierCombo.setRequestFocusEnabled(false);
        supplierCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierComboActionPerformed(evt);
            }
        });

        addButton.setBackground(new java.awt.Color(65, 210, 27));
        addButton.setFocusable(false);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        minusButton.setBackground(new java.awt.Color(255, 8, 8));
        minusButton.setFocusable(false);
        minusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(stockIn_searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(supplierCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(stockIn_searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(categoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(supplierCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minusButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setText("Item Stock-In");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void supplierComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierComboActionPerformed
        if(ready)
        {
            try
            {
                updateTableData(MODE_FILTER_SEARCH, stockIn_searchBar.getText(), categoryCombo.getSelectedItem().toString());
            }catch(Exception e){ShowFreakingError(e + " Error 0048");}
            resizeColumnWidth(oldTable);
        }
    }//GEN-LAST:event_supplierComboActionPerformed

    private void categoryComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboActionPerformed
        if(ready)
        {
            try 
            {
                updateTableData(MODE_FILTER_SEARCH, stockIn_searchBar.getText(), categoryCombo.getSelectedItem().toString());
            } catch (Exception e) {ShowFreakingError("" + e + " - Error 0007");} 
        }
    }//GEN-LAST:event_categoryComboActionPerformed

    private void stockIn_searchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockIn_searchBarKeyReleased
        String keyword = stockIn_searchBar.getText();
        try 
        {
            updateTableData(this.MODE_FILTER_SEARCH, keyword, categoryCombo.getSelectedItem().toString());
        } catch (Exception e) {ShowFreakingError("" + e + " - Error 0008");} 
    }//GEN-LAST:event_stockIn_searchBarKeyReleased

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String quantity = "";
        boolean pass;
        double newVal = 0;
        do
        {
            quantity = JOptionPane.showInputDialog("Enter quantity to Stock in:");
            if(quantity == null)
                pass = true;
            else
            {
                pass = isANumber(quantity);
                if(pass)
                {
                    newVal = Double.parseDouble(quantity);                    
                    addToOtherTable(oldTable.getSelectedRow(), newVal);
                }
            }
        }while(!pass);
    }//GEN-LAST:event_addButtonActionPerformed

    private void minusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusButtonActionPerformed
        if (this.newTable.getRowCount() > 0) 
        {
            int selectedNum = newTable.getSelectedRow();
            Object[] options = { "Confirm", "Cancel" };
            JPanel panel = new JPanel();
            panel.add(new JLabel("Permission to Delete " + newTable.getValueAt(selectedNum, 1)));
            int result = JOptionPane.showOptionDialog(null, panel, "Delete Row", 0, 2, null, options, null);
            if (result == 0) 
            {
                  newItemIdList.remove(selectedNum);
                  newItemNameList.remove(selectedNum);
                  newItemCategoryList.remove(selectedNum);
                  newItemQuantityList.remove(selectedNum);
                  newItemSupplierList.remove(selectedNum);
                  newItemTotalCostList.remove(selectedNum);
                  newItemStockInList.remove(selectedNum);
                  dtm2.removeRow(selectedNum);
            } 
        }
        else
            JOptionPane.showMessageDialog(null, "No data to Delete!");
        
        for(int i = 1; i <= newTable.getRowCount(); i++)
            newTable.setValueAt(i, i - 1, 0); 
        
        if(newTable.getRowCount() >= 1)
            newTable.setRowSelectionInterval(0, newTable.getRowCount() - 1); 
        processStocksStats(cashRadio.isSelected());
    }//GEN-LAST:event_minusButtonActionPerformed

    private void monthComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthComboActionPerformed
        if(ready)
        {
            int month = monthCombo.getSelectedIndex() == 0 ? 1 : monthCombo.getSelectedIndex();
            updateDate(monthCombo, month);
            updateDate2(dayCombo, yearCombo, month, Integer.parseInt(dayCombo.getSelectedItem().toString()), Integer.parseInt(yearCombo.getSelectedItem().toString()));
            LocalDate custom = LocalDate.of(Integer.parseInt(yearCombo.getSelectedItem().toString()), month, Integer.parseInt(dayCombo.getSelectedItem().toString()));
            dateUpdater(custom);
        }
    }//GEN-LAST:event_monthComboActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        if(monthCombo.getSelectedIndex() != 0)
        {
            itemDatabaseManager = new ItemDatabaseManager();
            StockInDatabaseManager stockInDatabaseManager = new StockInDatabaseManager();
            String newStockInIdValue = "";
            try {
                newStockInIdValue = stockInDatabaseManager.getDistinctId().size() + "";
            }catch (Exception e) {ShowFreakingError("" + e + " - Error 0009");} 

            if (this.newTable.getRowCount() > 0) 
            {
                if(cashRadio.isSelected() || (chequeRadio.isSelected() && !stockin_chequeField.getText().isBlank()))
                {
                    Object[] options = { "Confirm", "Cancel" };
                    JPanel panel = new JPanel();
                    panel.add(new JLabel("Please confirm to proceed!"));
                    int result = JOptionPane.showOptionDialog(null, panel, "Confirm Data", 0, 2, null, options, null);
                    if (result == 0) 
                    {
                        for (int i = 0; i < newTable.getRowCount(); i++) 
                        {
                            int id = Integer.parseInt(newItemIdList.get(i));
                            double newVal = newItemQuantityList.get(i);
                            double cost = newItemCostList.get(i);
                            String supplier = goodString(newItemSupplierList.get(i));
                            double stockIn = newItemStockInList.get(i);
                            String date = yearCombo.getSelectedItem() + "-" + monthCombo.getSelectedIndex() + "-" + dayCombo.getSelectedItem();
                            boolean isCash = cashRadio.isSelected();
                            String method = isCash ? "cash" : stockin_chequeField.getText();
                            int status = isCash ? 0 : 1;
                            String due = yearCombo1.getSelectedItem() + "-" + monthCombo1.getSelectedIndex() + "-" + dayCombo1.getSelectedItem();
                            double total = isCash ? Double.parseDouble(labelCost.getText()) : 0.0;
                            try 
                            {
                                SalesDatabaseManager salesDB = new SalesDatabaseManager();
                                int trans_id = salesDB.getNewestId();
                                itemDatabaseManager.updateQuantityById(id, newVal);
                                stockInDatabaseManager.insertData(newStockInIdValue, "" + id, newVal, date, cost, supplier, stockIn, method, status, due, trans_id);
                                salesDB.insertCost(date, total);
                            } catch (Exception e) {ShowFreakingError("" + e + " - Error 0010");} 
                        } 
                        dispose();
                    } 
                } else JOptionPane.showMessageDialog(null, "Please fill all fields!");
            } else JOptionPane.showMessageDialog(null, "No data to Stock In!");
        } else JOptionPane.showMessageDialog(null, "Please set date properly!", "Error Date", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.myFrame.setEnabled(true);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.myFrame.setAlwaysOnTop(true);
        this.myFrame.setAlwaysOnTop(false);
    }//GEN-LAST:event_formWindowClosing

    private void cashRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashRadioActionPerformed
        radioActivation(true);
    }//GEN-LAST:event_cashRadioActionPerformed

    private void chequeRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chequeRadioActionPerformed
        radioActivation(false);
    }//GEN-LAST:event_chequeRadioActionPerformed

    private void monthCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthCombo1ActionPerformed
        
    }//GEN-LAST:event_monthCombo1ActionPerformed

    private void yearCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearCombo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearCombo1ActionPerformed

    private void dayComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayComboActionPerformed

    }//GEN-LAST:event_dayComboActionPerformed

    private void yearComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboActionPerformed
        yearCombo1.setSelectedItem(yearCombo.getSelectedItem());
    }//GEN-LAST:event_yearComboActionPerformed

    private void purchaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseButtonActionPerformed

        try{
            SupplierDatabaseManager sDb = new SupplierDatabaseManager();
            String reportPath = System.getProperty("user.dir") + "\\PurchaseReport.jrxml";
            String supplier = supplierCombo.getSelectedItem().toString();
            
            List<StockItems> collectionList = getItems();
            
            JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(collectionList);
            
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("CollectionBeanParam", itemsJRBean);
            parameters.put("logo", getClass().getResource("/Images/h2med_logo.png").toString());
            parameters.put("supplierName", supplier);
            parameters.put("supplierAddress", sDb.getAddressByName(supplier));
            parameters.put("dateOfRequest", LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
            
            InputStream input = new FileInputStream(new File(reportPath));
            JasperDesign jdesign = JRXmlLoader.load(input);
            
            
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, parameters, new JREmptyDataSource());
            
            JasperViewer.viewReport(jprint, false);
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_purchaseButtonActionPerformed
    private ArrayList<StockItems> getItems()
    {
        ArrayList<StockItems> itemsList = new ArrayList<>();
        
        for(int i = 0; i < dtm2.getRowCount(); i++)
        {
            StockItems item = new StockItems();
            
            item.setItem(dtm2.getValueAt(i, 1).toString());
            item.setArticle(dtm2.getValueAt(i, 2).toString());
            item.setBrand(dtm2.getValueAt(i, 3).toString());
            item.setQuantity(dtm2.getValueAt(i, 5).toString());
            double unitPrice = Double.parseDouble(dtm2.getValueAt(i, 6).toString()) / Double.parseDouble(dtm2.getValueAt(i, 5).toString());
            //JOptionPane.showMessageDialog(null, unitPrice + " = " + dtm2.getValueAt(i, 6).toString() + " / " + dtm2.getValueAt(i, 5).toString());
            item.setUnitPrice(unitPrice + "");
            item.setTotalUnitPrice(dtm2.getValueAt(i, 6).toString());
            item.setTotalAmount(returnGoodNumber(labelCost.getText()));
            
            itemsList.add(item);
        }
        return itemsList;
    }
    private String returnGoodNumber(String num)
    {
        int returnPoint = num.length();
        for(int i = 0; i < num.length(); i++)
            if(num.charAt(i) == '.' && (i + 3) < returnPoint)
                return num.substring(0, i + 2);
        return num;
    }
    private void radioActivation(boolean bool)
    {
        bool = !bool;
        stockin_chequeField.setEnabled(bool);
        monthCombo1.setEnabled(bool);
        dayCombo1.setEnabled(bool);
        yearCombo1.setEnabled(bool);
        
        processStocksStats(!bool);
    }
    
    private void addToOtherTable(int number, double newQuantity) {
        newItemIdList.add(itemIdList.get(number));
        newItemNameList.add(itemNameList.get(number));
        newItemCostList.add(itemCostList.get(number));
        newItemSupplierList.add(itemSupplierList.get(number));
        newItemCategoryList.add(itemCategoryList.get(number));
        newItemQuantityList.add((itemQuantityList.get(number)) + newQuantity);
        newItemTotalCostList.add(newQuantity * (itemCostList.get(number)));
        newItemStockInList.add(newQuantity);
        String[] rowData = {newTable.getRowCount() + 1 + "", itemNameList.get(number), itemArticleList.get(number),
            itemBrandList.get(number), itemSupplierList.get(number), "" + newQuantity, 
            (newQuantity * (Double.parseDouble(dtm.getValueAt(oldTable.getSelectedRow(), 6).toString().substring(2)))) + ""
        };
        dtm2.addRow(rowData);
        if (newTable.getRowCount() >= 1)
            newTable.setRowSelectionInterval(0, newTable.getRowCount() - 1); 

        newTable.setRowHeight(30);
        processStocksStats(cashRadio.isSelected());
        resizeColumnWidth(newTable);
    }

    private void processStocksStats(boolean isCash) 
    {
        if(isCash)
        {
            double totalItem = newItemIdList.size();
            double totalCost = 0.0;
            for (int i = 0; i < newItemTotalCostList.size(); i++)
                totalCost += newItemTotalCostList.get(i); 
            labelItem.setText("" + totalItem);
            labelCost.setText("" + totalCost);
                    
            for(int i = 0; i < newItemStockInList.size(); i++)
                newTable.setValueAt(newItemTotalCostList.get(i), i, 6);
        }
        else
        {
            labelCost.setText("0.0");
            for(int i = 0; i < newItemIdList.size(); i++)
            {
                newTable.setValueAt("0.0", i, 6);
            }
        }

    }

    private void createColumns2() 
    {
        dtm2 = new DefaultTableModel(0, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
          };
        dtm2.addColumn("#");
        dtm2.addColumn("Item Name");
        dtm2.addColumn("Item Article");
        dtm2.addColumn("Item Brand");
        dtm2.addColumn("Supplier");
        dtm2.addColumn("Quantity");
        dtm2.addColumn("Total Cost");

        newTable.setModel(dtm2);
    }

    private void createColumns() 
    {
        dtm = new DefaultTableModel(0, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
          };
        dtm.addColumn("#");
        dtm.addColumn("Item Name");
        dtm.addColumn("Article");
        dtm.addColumn("Brand");
        dtm.addColumn("Supplier");
        dtm.addColumn("Quantity");
        dtm.addColumn("Cost");
        dtm.addColumn("Category");
        oldTable.setModel(dtm);
    }

    public void updateTableData(int mode, String keyword, String category) throws Exception 
    {
        itemDatabaseManager = new ItemDatabaseManager();
        
        String sup = supplierCombo.getSelectedIndex() == 0 ? "" : supplierCombo.getSelectedItem().toString();
        
        switch (mode) {
            case MODE_PROCESS:
                itemDatabaseManager.processAllData(MODE_UNSORT);
                break;
            case MODE_FILTER_CATEGORY:
                itemDatabaseManager.filterByCategory(goodString(categoryCombo.getSelectedItem().toString()), goodString(sup),MODE_UNSORT);
                break;
            case MODE_FILTER_SEARCH:
                itemDatabaseManager.filterBySearch(goodString(keyword), goodString(category), goodString(sup),MODE_UNSORT);
                break;
            default:
                break;
        }

        itemIdList = itemDatabaseManager.getItemIdList();
        itemNameList = itemDatabaseManager.getItemNameList();
        itemCategoryList = itemDatabaseManager.getItemCategoryList();
        itemQuantityList = itemDatabaseManager.getItemQuantityList();
        itemCostList = itemDatabaseManager.getItemCostList();
        itemSupplierList = itemDatabaseManager.getItemSupplierList();
        itemBrandList = itemDatabaseManager.getItemBrandList();
        itemArticleList = itemDatabaseManager.getItemArticleList();

        dtm.setRowCount(0);
        
        for (int i = 0; i < itemIdList.size(); i++) 
        {
            String[] rowData = {i + 1 + "", itemNameList.get(i), itemArticleList.get(i), itemBrandList.get(i), itemSupplierList.get(i), 
                itemQuantityList.get(i).toString(), "" + (char)8369 + " " + itemCostList.get(i),itemCategoryList.get(i) 
            };
          dtm.addRow(rowData);
        }
        if(oldTable.getRowCount() >= 1)
            oldTable.setRowSelectionInterval(0, 0); 
        oldTable.setRowHeight(30);
    }
    private String goodString(String data)
    {
        String temp = data.replaceAll("'", "\\\\'");
        return temp;
    }
    private void updateComboBox() 
    {
        ArrayList<String> listOfCat = new ArrayList<>();
        listOfCat.clear();
        listOfCat.add("All");
        listOfCat.add("Medicine");
        listOfCat.add("Medical Supplies");
        listOfCat.add("Office Supplies");
        listOfCat.add("Janitorial Supplies");
        listOfCat.add("General Merchandise");
        listOfCat.add("Foods");
        listOfCat.add("Laboratory Supplies");
        for(int i = 0; i < listOfCat.size(); i++)
            this.categoryCombo.addItem(listOfCat.get(i)); 
    }

    private boolean isANumber(String s) 
    {
        boolean valid = false;
        if (s != null) 
        {
            valid = (s.length() > 0);
            int dot = 0;
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) 
                {
                    case '.':case '0':case '1':case '2':case '3':case '4':case '5':
                    case '6':case '7':case '8':case '9':
                    if (s.charAt(i) == '.')
                        dot++; 
                    break;
                    default:
                        valid = false;
                    break;
                } 
            } 
        if (dot > 1)
            valid = false; 
        } 
        return valid;
    }
    public void removeTransactionDetails(boolean applyRemove)
    {
        if(applyRemove)
        {
            int selectedNum = newTable.getRowCount() - 1;
            newItemIdList.remove(selectedNum);
            newItemNameList.remove(selectedNum);
            newItemCategoryList.remove(selectedNum);
            newItemQuantityList.remove(selectedNum);
            newItemSupplierList.remove(selectedNum);
            newItemTotalCostList.remove(selectedNum);
            newItemStockInList.remove(selectedNum);
            dtm2.removeRow(selectedNum);
            for(int i = 1; i <= newTable.getRowCount(); i++)
                newTable.setValueAt(i, i - 1, 0); 

            if(newTable.getRowCount() >= 1)
                newTable.setRowSelectionInterval(0, newTable.getRowCount() - 1); 
            processStocksStats(cashRadio.isSelected());
        }
    }
    public void changeTransactionDetails()
    {
        newItemTotalCostList.set(newTable.getSelectedRow(), 0.0);
        newTable.setValueAt((char)8369 + " 0", newTable.getSelectedRow(), 6);
        processStocksStats(cashRadio.isSelected());
    }
    private void updateComboBox2()
    {
        ArrayList<String> listOfSupplier = new ArrayList<>();
        listOfSupplier.clear();
        SupplierDatabaseManager supplierDb = new SupplierDatabaseManager();
        try
        {
            supplierDb.processAllData();
        }catch(Exception e){ShowFreakingError(e + " - Error 0049");}
        
        ArrayList<String> suppliers = supplierDb.getNameList();
        supplierCombo.addItem("All");
        supplierCombo.addItem("None");
        for(int i = 0; i < suppliers.size(); i++)
            supplierCombo.addItem(suppliers.get(i));
    }
    public void resizeColumnWidth(JTable table) 
    {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) 
        {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) 
            {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 300)
                width=300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
    private ImageIcon getScaledImageIcon(String imageName, int height, int width)
    {
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/Images/" + imageName)).getImage());
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(height, width, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImage);
        return imageIcon;
    }
    private void setupTable(JTable table, Color background, Dimension dim, Color foreground)
    {
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(background);
        headerRenderer.setPreferredSize(dim);
        headerRenderer.setForeground(foreground);
        
        for (int i = 0; i < table.getModel().getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }
    private void updateDate(JComboBox monthCombo, int selectedMonth)
    {
        String[] month = {"None","Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        monthCombo.removeAllItems();
        for (String month1 : month)
            monthCombo.addItem(month1);
        monthCombo.setSelectedIndex(selectedMonth);
        
    }
    private void updateDate2(JComboBox dayCombo, JComboBox yearCombo, int selectedMonth, int selectedDay, int selectedYear)
    {
        yearCombo.removeAllItems();
        dayCombo.removeAllItems();

        int days[] = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year[] = {2015,2016,2017,2018,2019,2020,2021,2022,2023,2024,2025,2026,2027,2028,2029,2030,2031,2032,2033,2034,2035,2036,2037,2038,2039,2040};

        for(int i = 0; i < days[selectedMonth]; i++)
        {
            dayCombo.addItem(i + 1);
        }
        if(selectedMonth != 0)
        {
            for(int i = 0; i < year.length; i++)
                yearCombo.addItem(year[i] + "");
            int lastDay = selectedDay > dayCombo.getItemCount() ? dayCombo.getItemCount() - 1: selectedDay;
            dayCombo.setSelectedItem(lastDay);
            yearCombo.setSelectedItem(selectedYear + "");
        }
    }
    private void dateUpdater(LocalDate customNow) throws DateTimeException
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDate now = customNow == null ? LocalDate.now() : customNow;
        int nextTempYear;
        int nextTempMonth;
        if(now.getMonthValue() == 12)
        {
            nextTempYear = now.getYear() + 1;
            nextTempMonth = 1;
        }
        else
        {
            nextTempYear = now.getYear();
            nextTempMonth = now.getMonthValue() + 1;
        }
        LocalDate next = LocalDate.of(nextTempYear, nextTempMonth, now.getDayOfMonth()); //checkNextMonth(LocalDate.of(nextTempYear, nextTempMonth, now.getDayOfMonth()));
        String today = dtf.format(now);
        String nextMonth = dtf.format(next);
        String data[] = today.split("-");
        String data2[] = nextMonth.split("-");
        int year = Integer.parseInt(data[0]);
        int month = Integer.parseInt(data[1]);
        int day = Integer.parseInt(data[2]);
        updateDate(monthCombo, month);
        updateDate2(dayCombo, yearCombo, month, day, year);
        int month1 = Integer.parseInt(data2[1]);
        updateDate(monthCombo1, month1);
        updateDate2(dayCombo1, yearCombo1, month1, day, year);
    }
    public void openStockInFrame(MainFrame main) {
        initComponents();
        myFrame = main;
        createColumns();
        createColumns2();
        updateComboBox2();
        updateComboBox();
        dateUpdater(null);
        buttonGroup1.add(cashRadio);
        buttonGroup1.add(chequeRadio);
        radioActivation(cashRadio.isSelected());
        try 
        {
            updateTableData(MODE_FILTER_SEARCH, stockIn_searchBar.getText(),categoryCombo.getSelectedItem().toString());
        }catch (Exception e) {ShowFreakingError("" + e + " - Error 0006");} 
        resizeColumnWidth(newTable);
        resizeColumnWidth(oldTable);
        setupTable(oldTable, Color.white, new Dimension(0, 30), Color.black);
        setupTable(newTable, Color.white, new Dimension(0, 30), Color.black);
        addButton.setIcon(getScaledImageIcon("plus_icon.png", 30, 30));
        minusButton.setIcon(getScaledImageIcon("minus_icon.png",30,30));
        resizeColumnWidth(oldTable);
        resizeColumnWidth(newTable);
        ready = true;
    }
  
    public void ShowFreakingError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", 0);System.exit(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cashRadio;
    private javax.swing.JComboBox<String> categoryCombo;
    private javax.swing.JRadioButton chequeRadio;
    private javax.swing.JButton confirmButton;
    private javax.swing.JComboBox<String> dayCombo;
    private javax.swing.JComboBox<String> dayCombo1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCost;
    private javax.swing.JLabel labelItem;
    private javax.swing.JButton minusButton;
    private javax.swing.JComboBox<String> monthCombo;
    private javax.swing.JComboBox<String> monthCombo1;
    private javax.swing.JTable newTable;
    private javax.swing.JTable oldTable;
    private javax.swing.JButton purchaseButton;
    private javax.swing.JTextField stockIn_searchBar;
    private javax.swing.JTextField stockin_chequeField;
    private javax.swing.JComboBox<String> supplierCombo;
    private javax.swing.JComboBox<String> yearCombo;
    private javax.swing.JComboBox<String> yearCombo1;
    // End of variables declaration//GEN-END:variables
}