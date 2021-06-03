package inventorysystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class StockOutFrame extends javax.swing.JFrame {

    MainFrame myFrame;
    ItemDatabaseManager itemDatabaseManager;
    
    ArrayList<String> itemIdList;
    ArrayList<String> itemNameList;
    ArrayList<String> itemCategoryList;
    ArrayList<Double> itemQuantityList;
    ArrayList<Double> itemCostList;
    ArrayList<Double> itemPriceList;
    ArrayList<String> itemSupplierList;
    ArrayList<String> itemBrandList;
    ArrayList<String> itemArticleList;
    
    ArrayList<String> newItemIdList = new ArrayList<>();
    ArrayList<String> newItemNameList = new ArrayList<>();
    ArrayList<String> newItemCategoryList = new ArrayList<>();
    ArrayList<Double> newItemQuantityList = new ArrayList<>();
    ArrayList<Double> newItemCostList = new ArrayList<>();
    ArrayList<Double> newItemPriceList = new ArrayList<>();
    ArrayList<Double> newItemStockOutList = new ArrayList<>();
    ArrayList<String> newItemSupplierList = new ArrayList<>();
    ArrayList<String> newItemBrandList = new ArrayList<>();
    ArrayList<String> newItemArticleList = new ArrayList<>();
    
    final private int MODE_PROCESS = 0;
    final private int MODE_FILTER_CATEGORY = 1;
    final private int MODE_FILTER_SEARCH = 2;
    
    final private int MODE_SORT = 0;
    final private int MODE_UNSORT = 1;
    
    final private int UNPAID = 0;
    final private int PARTIAL = 1;
    final private int PAID = 2;
    
    private boolean ready = false;
    
    DefaultTableModel dtm, dtm2;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        categoryCombo = new javax.swing.JComboBox<>();
        stockOut_searchBar = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        newTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        minusButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        oldTable = new javax.swing.JTable();
        stockout_comboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        labelItem = new javax.swing.JLabel();
        labelCost = new javax.swing.JLabel();
        labelPrice = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        labelGain = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        monthCombo = new javax.swing.JComboBox<>();
        dayCombo = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        stockout_purchaseField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        stockout_deliveryField = new javax.swing.JTextField();
        supplierCombo = new javax.swing.JComboBox<>();
        cashRadio = new javax.swing.JRadioButton();
        stockout_invoiceField = new javax.swing.JTextField();
        chequeRadio = new javax.swing.JRadioButton();
        stockout_chequeField = new javax.swing.JTextField();
        yearCombo = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        monthCombo1 = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        dayCombo1 = new javax.swing.JComboBox<>();
        yearCombo1 = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        printButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Stock Out");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 1400, 700));
        setMinimumSize(new java.awt.Dimension(1310, 590));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        categoryCombo.setForeground(new java.awt.Color(255, 255, 255));
        categoryCombo.setFocusable(false);
        categoryCombo.setRequestFocusEnabled(false);
        categoryCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboActionPerformed(evt);
            }
        });

        stockOut_searchBar.setBackground(new java.awt.Color(255, 255, 255));
        stockOut_searchBar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                stockOut_searchBarFocusLost(evt);
            }
        });
        stockOut_searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stockOut_searchBarKeyReleased(evt);
            }
        });

        confirmButton.setBackground(new java.awt.Color(255, 255, 255));
        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());

        newTable.setBackground(new java.awt.Color(255, 255, 255));
        newTable.setForeground(new java.awt.Color(0, 0, 0));
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
        newTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        newTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(newTable);

        addButton.setBackground(new java.awt.Color(255, 255, 255));
        addButton.setText("+");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        minusButton.setBackground(new java.awt.Color(255, 255, 255));
        minusButton.setText("-");
        minusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());

        oldTable.setBackground(new java.awt.Color(255, 255, 255));
        oldTable.setForeground(new java.awt.Color(0, 0, 0));
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
        oldTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        oldTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(oldTable);

        stockout_comboBox.setBackground(new java.awt.Color(255, 255, 255));
        stockout_comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockout_comboBoxActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Invoice #");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Stock out Date");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Total Item/s");
        jLabel11.setToolTipText("");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Total Cost");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Total Price");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText((char)8369 + "");
        jLabel14.setToolTipText("");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText((char)8369 + "");
        jLabel15.setToolTipText("");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Total Income");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText((char)8369 + "");
        jLabel17.setToolTipText("");

        labelItem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelItem.setText("0.0");

        labelCost.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelCost.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelCost.setText("0.0");

        labelPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPrice.setText("0.0");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Client");

        labelGain.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelGain.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelGain.setText("0.0");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel18.setText("/");

        monthCombo.setBackground(java.awt.Color.white);
        monthCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboActionPerformed(evt);
            }
        });

        dayCombo.setBackground(java.awt.Color.white);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel19.setText("/");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Purchase Order #");

        stockout_purchaseField.setBackground(new java.awt.Color(255, 255, 255));
        stockout_purchaseField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        stockout_purchaseField.setText("000");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Delivery Receipt #");

        stockout_deliveryField.setBackground(new java.awt.Color(255, 255, 255));
        stockout_deliveryField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        stockout_deliveryField.setText("000");

        supplierCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierComboActionPerformed(evt);
            }
        });

        cashRadio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cashRadio.setSelected(true);
        cashRadio.setText("Cash");
        cashRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashRadioActionPerformed(evt);
            }
        });

        stockout_invoiceField.setBackground(new java.awt.Color(255, 255, 255));
        stockout_invoiceField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        stockout_invoiceField.setText("000");

        chequeRadio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chequeRadio.setText("Cheque #");
        chequeRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chequeRadioActionPerformed(evt);
            }
        });

        stockout_chequeField.setBackground(new java.awt.Color(255, 255, 255));
        stockout_chequeField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        stockout_chequeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockout_chequeFieldActionPerformed(evt);
            }
        });

        yearCombo.setBackground(java.awt.Color.white);
        yearCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Due Date");

        monthCombo1.setBackground(java.awt.Color.white);
        monthCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthCombo1ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel24.setText("/");

        dayCombo1.setBackground(java.awt.Color.white);

        yearCombo1.setBackground(java.awt.Color.white);
        yearCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearCombo1ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel25.setText("/");

        printButton.setBackground(new java.awt.Color(255, 255, 255));
        printButton.setText("Print");
        printButton.setEnabled(false);
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setText("Item Stock-Out");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(stockOut_searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(categoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(supplierCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(688, 688, 688))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(minusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(50, 50, 50)
                                            .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel17)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(labelItem)
                                                    .addComponent(labelGain)
                                                    .addComponent(labelCost)
                                                    .addComponent(labelPrice)))))
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel20)
                                    .addComponent(cashRadio)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(94, 94, 94)
                                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(stockout_invoiceField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(stockout_purchaseField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(stockout_deliveryField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel16)
                                                        .addComponent(jLabel12)
                                                        .addComponent(jLabel13))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel11)))
                                                .addGap(87, 87, 87))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(monthCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(dayCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(yearCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(stockout_comboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                        .addComponent(dayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(2, 2, 2)
                                                        .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(27, 27, 27))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(chequeRadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(stockout_chequeField, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stockOut_searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supplierCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stockout_deliveryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stockout_purchaseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stockout_invoiceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(cashRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(stockout_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(monthCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(dayCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(yearCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(chequeRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(stockout_chequeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(31, 31, 31)))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(labelItem)
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelGain)
                                            .addComponent(jLabel15))
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelCost)
                                            .addComponent(jLabel14))
                                        .addGap(5, 5, 5)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelPrice)
                                            .addComponent(jLabel17)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16)
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(minusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stockOut_searchBarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stockOut_searchBarFocusLost

    }//GEN-LAST:event_stockOut_searchBarFocusLost

    private void stockOut_searchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockOut_searchBarKeyReleased
        String keyword = stockOut_searchBar.getText();
        try
        {
            updateTableData(MODE_FILTER_SEARCH, keyword, categoryCombo.getSelectedItem().toString());
        }catch(Exception e){ShowFreakingError(e + " - Error 0012");}
    }//GEN-LAST:event_stockOut_searchBarKeyReleased

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        if(stockout_comboBox.getItemCount() > 0)
        {
            if(monthCombo.getSelectedIndex() != 0)
            {
                itemDatabaseManager = new ItemDatabaseManager();
                StockOutDatabaseManager stockOutDatabaseManager = new StockOutDatabaseManager();
                InvoiceDatabaseManager invoiceDatabaseManager = new InvoiceDatabaseManager();
                boolean didInvoiceExist = false, didDeliveryExist = false, didPurchaseExist = false;
                try
                {
                    invoiceDatabaseManager.processDistinctNumbers(goodString(stockout_comboBox.getSelectedItem().toString()));
                    didInvoiceExist = invoiceDatabaseManager.checkInvoiceIfExist(Integer.parseInt(stockout_invoiceField.getText()));
                    didDeliveryExist = invoiceDatabaseManager.checkDeliveryIfExist(Integer.parseInt(stockout_deliveryField.getText()));
                    didPurchaseExist = invoiceDatabaseManager.checkPurchaseIfExist(Integer.parseInt(stockout_purchaseField.getText()));
                }catch(Exception e){ShowFreakingError(e + " - Error 0034");}

                if(!didInvoiceExist)
                {
                    if(!didDeliveryExist)
                    {
                        if(!didPurchaseExist)
                        {
                            String newStockOutIdValue = "";
                            try
                            {
                                newStockOutIdValue = stockOutDatabaseManager.getDistinctId().size() + 1 + "";
                            }catch(Exception e){ShowFreakingError(e + " - Error 0013");}

                            if(newTable.getRowCount() > 0)
                            {
                                Object[] options = {"Confirm", "Cancel"};
                                JPanel panel = new JPanel();
                                panel.add(new JLabel ("Please confirm to proceed!"));
                                int result = JOptionPane.showOptionDialog(null, panel, "Confirm Data", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                                    null, options, null);
                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
                                LocalDateTime now = LocalDateTime.now();  
                                String date = setFormat2(dtf.format(now));
                                if(result == JOptionPane.YES_OPTION)
                                {
                                    for(int i = 0; i < newTable.getRowCount(); i++)
                                    {
                                        int id = Integer.parseInt(newItemIdList.get(i));
                                        double newVal = newItemStockOutList.get(i);
                                        double quantityLeft = newItemQuantityList.get(i);
                                        double cost = newItemCostList.get(i);
                                        double price = newItemPriceList.get(i);
                                        String supplier = newItemSupplierList.get(i);
                                        try
                                        {
                                            itemDatabaseManager.updateQuantityById(id, quantityLeft);
                                            itemDatabaseManager.addStockOutById(id, newVal);
                                            stockOutDatabaseManager.insertData(newStockOutIdValue, id + "", newVal, date, goodString(stockout_comboBox.getSelectedItem().toString()),cost, price, goodString(supplier));
                                        }catch(Exception e){ShowFreakingError(e + " - Error 0014");}
                                    }
                                    try
                                    {
                                        insertInvoice(newItemNameList, newItemCostList, newItemPriceList, newItemStockOutList, newItemSupplierList);
                                        SalesDatabaseManager salesDB = new SalesDatabaseManager();
                                        salesDB.insertOutstanding(date, goodString(stockout_comboBox.getSelectedItem().toString()), Double.parseDouble(labelPrice.getText()), Integer.parseInt(stockout_invoiceField.getText()));
                                    }catch(Exception e){ShowFreakingError(e + " - Error 0035");}
                                    
                                    confirmButton.setEnabled(false);
                                    printButton.setEnabled(true);
                                    
                                }
                            }else JOptionPane.showMessageDialog(null, "No data to Stock Out!");
                        }else JOptionPane.showMessageDialog(null, "Purchase Number already exists!");
                    }else JOptionPane.showMessageDialog(null, "Delivery Number already exists!");
                }else JOptionPane.showMessageDialog(null, "Invoice Number already exists!");
            }else JOptionPane.showMessageDialog(null, "Please set the date!", "Warning", JOptionPane.WARNING_MESSAGE);
        }else JOptionPane.showMessageDialog(null, "No clients Available!", "Warning", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_confirmButtonActionPerformed
    private void insertInvoice(ArrayList<String> items, ArrayList<Double> cost, ArrayList<Double> price, ArrayList<Double> quantity, ArrayList<String> itemSupplier)
    {
        InvoiceDatabaseManager invoiceDatabaseManager = new InvoiceDatabaseManager();
        int invoiceNumber = Integer.parseInt(stockout_invoiceField.getText());
        int deliveryNumber = Integer.parseInt(stockout_deliveryField.getText());
        int purchaseNumber = Integer.parseInt(stockout_purchaseField.getText());
        String address = goodString(stockout_comboBox.getSelectedItem().toString());
        String invoice_date = yearCombo.getSelectedItem() + "-" + monthCombo.getSelectedIndex()+ "-" + dayCombo.getSelectedItem();
        String cheque = cashRadio.isSelected() ? "Cash" : stockout_chequeField.getText();
        String dueDate = cashRadio.isSelected() ? "- - / - -" : yearCombo1.getSelectedItem() + "-" + monthCombo1.getSelectedIndex()+ "-" + dayCombo1.getSelectedItem();
        for(int i = 0; i < items.size(); i++)
        {
            try
            {
                invoiceDatabaseManager.insertData(invoiceNumber, items.get(i), cost.get(i), price.get(i), quantity.get(i), address, 0, invoice_date, UNPAID, deliveryNumber, purchaseNumber, goodString(itemSupplier.get(i)), cheque, dueDate, 0);
            }catch(Exception e){ShowFreakingError(e + " - Error 0036");}
        }
    }
    private String goodString(String data)
    {
        String temp = data.replaceAll("'", "\\\\'");
        return temp;
    }
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String quantity = "";
        boolean pass;
        double newVal = 0;
        do
        {
            quantity = JOptionPane.showInputDialog("Enter quantity to Stock out:");
            if(quantity == null)
            {
                pass = true;
            }
            else
            {
                pass = isANumber(quantity);
                if(pass)
                {
                    newVal = Double.parseDouble(quantity);
                    if(!goodQuantity(oldTable.getSelectedRow(), newVal))
                    {
                        JOptionPane.showMessageDialog(null, "There are no enough stocks left for this item!", "Invalid Quantity", JOptionPane.ERROR_MESSAGE);
                        pass = false;
                    }
                    else
                        addToOtherTable(oldTable.getSelectedRow(), newVal);
                }
            }
        }while(!pass);
    }//GEN-LAST:event_addButtonActionPerformed
    private boolean goodQuantity(int num, double newVal)
    {
        String id = itemIdList.get(num);
        double currentQuantity = itemQuantityList.get(num);
        double totalQuantity = 0;
        if(newTable.getRowCount() > 0)
        {
            for(int i = 0; i < newTable.getRowCount(); i++)
            {
                if(newItemIdList.get(i).equals(id))
                {
                    
                    totalQuantity += newItemStockOutList.get(i);
                }
            }
            return !((totalQuantity + newVal) > currentQuantity);
        }
        else
            return !(newVal > currentQuantity);
    }
    private void minusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusButtonActionPerformed
        if(newTable.getRowCount() > 0)
        {
            int selectedNum = newTable.getSelectedRow();
            Object[] options = {"Confirm", "Cancel"};
            JPanel panel = new JPanel();
            panel.add(new JLabel ("Permission to Delete " + newTable.getValueAt(selectedNum, 1)));
            int result = JOptionPane.showOptionDialog(null, panel, "Delete Row", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, null);
            if(result == JOptionPane.YES_OPTION)
            {
                newItemIdList.remove(selectedNum);
                newItemNameList.remove(selectedNum);
                newItemCategoryList.remove(selectedNum);
                newItemQuantityList.remove(selectedNum);
                newItemStockOutList.remove(selectedNum);
                newItemCostList.remove(selectedNum);
                newItemPriceList.remove(selectedNum);
                newItemSupplierList.remove(selectedNum);
                
                dtm2.removeRow(selectedNum);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No data to Delete!");
        }
        for(int i = 1; i <= newTable.getRowCount(); i++)
        {
            newTable.setValueAt(i, i - 1, 0);
        }
        if(newTable.getRowCount() >= 1)
        {
            newTable.setRowSelectionInterval(0, newTable.getRowCount() - 1);
        }
        processStockStats();
    }//GEN-LAST:event_minusButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        myFrame.setEnabled(true);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        myFrame.setAlwaysOnTop(true);
        myFrame.setAlwaysOnTop(false);
    }//GEN-LAST:event_formWindowClosing

    private void stockout_comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockout_comboBoxActionPerformed
        if(ready)
        {
            prepareFieldNumbers();
        }
    }//GEN-LAST:event_stockout_comboBoxActionPerformed

    private void categoryComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboActionPerformed
        if(ready)
        {
            try
            {
                updateTableData(MODE_FILTER_SEARCH, stockOut_searchBar.getText(), categoryCombo.getSelectedItem().toString());
            }catch(Exception e){ShowFreakingError(e + " - Error 0051");}
        }
    }//GEN-LAST:event_categoryComboActionPerformed

    private void monthComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthComboActionPerformed
        if(ready)
        {
            updateDate2(dayCombo, yearCombo, monthCombo.getSelectedIndex());
        }
    }//GEN-LAST:event_monthComboActionPerformed

    private void supplierComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierComboActionPerformed
        if(ready)
        {
            try
            {
                updateTableData(MODE_FILTER_SEARCH, stockOut_searchBar.getText(), categoryCombo.getSelectedItem().toString());
            }catch(Exception e){ShowFreakingError(e + " - Error 0052");}
        }
    }//GEN-LAST:event_supplierComboActionPerformed

    private void yearComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearComboActionPerformed

    private void monthCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthCombo1ActionPerformed
        if(ready)
            updateDate(monthCombo1, dayCombo1, yearCombo1, monthCombo1.getSelectedIndex());
    }//GEN-LAST:event_monthCombo1ActionPerformed

    private void yearCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearCombo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearCombo1ActionPerformed

    private void cashRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashRadioActionPerformed
        radioActivation(true);
    }//GEN-LAST:event_cashRadioActionPerformed

    private void chequeRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chequeRadioActionPerformed
        radioActivation(false);
    }//GEN-LAST:event_chequeRadioActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        PrinterManager printerManager = new PrinterManager();
        MainFrame main = new MainFrame();

        ArrayList<Double> quantityList = new ArrayList<>();
        ArrayList<String> itemList = new ArrayList<>();
        ArrayList<String> descriptionList = new ArrayList<>();
        ArrayList<Double> priceList = new ArrayList<>();

        for(int i = 0; i < newTable.getRowCount(); i++)
        {
            quantityList.add(Double.parseDouble(newTable.getValueAt(i, 6).toString()));
            itemList.add(newTable.getValueAt(i, 1).toString());
            String article = newTable.getValueAt(i, 2).toString().equals("None") ? "" : newTable.getValueAt(i,2).toString() + "-";
            String brand = newTable.getValueAt(i, 3).toString().equals("None") ? "" : newTable.getValueAt(i,3).toString();
            descriptionList.add(article + brand);
            priceList.add(Double.parseDouble(newTable.getValueAt(i, 5).toString().substring(1)));
        }
        Map<String, String> data = new HashMap<String, String>();

        data.put("invoice", stockout_invoiceField.getText());
        data.put("purchase", stockout_purchaseField.getText());
        data.put("delivery", stockout_deliveryField.getText());
        data.put("invoiceDate", monthCombo.getSelectedItem() + " " + dayCombo.getSelectedItem() + ", " + yearCombo.getSelectedItem());
        data.put("client", stockout_comboBox.getSelectedItem().toString());
        data.put("mode", cashRadio.isSelected() + "");
        data.put("cheque", stockout_chequeField.getText());
        data.put("dueDate", monthCombo1.getSelectedItem() + " " + dayCombo1.getSelectedItem() + ", " + yearCombo1.getSelectedItem());

        printerManager.openPrinterManager(quantityList, itemList, descriptionList, priceList, data);
        int x = (main.getWidth() - printerManager.getWidth()) / 2;
        int y = (main.getHeight() - printerManager.getHeight()) / 2;
        printerManager.setLocation(x, y);
        printerManager.setVisible(true);
    }//GEN-LAST:event_printButtonActionPerformed

    private void stockout_chequeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockout_chequeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockout_chequeFieldActionPerformed
    private void radioActivation(boolean bool)
    {
        stockout_chequeField.setEnabled(!bool);
        jLabel23.setEnabled(!bool);
        yearCombo1.setEnabled(!bool);
        jLabel24.setEnabled(!bool);
        monthCombo1.setEnabled(!bool);
        jLabel25.setEnabled(!bool);
        dayCombo1.setEnabled(!bool);
    }
    private void addToOtherTable(int number, double newQuantity)
    {
        newItemIdList.add(itemIdList.get(number));
        newItemNameList.add(itemNameList.get(number));
        newItemCategoryList.add(itemCategoryList.get(number));
        newItemQuantityList.add(itemQuantityList.get(number) - newQuantity);
        newItemCostList.add(itemCostList.get(number));
        newItemPriceList.add(itemPriceList.get(number));
        newItemStockOutList.add(newQuantity);
        newItemSupplierList.add(itemSupplierList.get(number));
        newItemBrandList.add(itemBrandList.get(number));
        newItemArticleList.add(itemArticleList.get(number));
        String [] rowData = {
                newTable.getRowCount() + 1 + "", itemNameList.get(number), itemArticleList.get(number), itemBrandList.get(number),
            itemSupplierList.get(number),((char)8369) + (itemPriceList.get(number) + ""), (newQuantity + ""), 
            ((char)8369) + (newQuantity * itemPriceList.get(number) + "") 
            };
        dtm2.addRow(rowData);
        if(newTable.getRowCount() >= 1)
        {
            newTable.setRowSelectionInterval(0, newTable.getRowCount() - 1);
        }
        processStockStats();
    }
    private void processStockStats()
    {
        double totalQuan = newItemIdList.size();
        double totalGain = 0;
        double totalCost = 0;
        double totalPrice = 0;
        for(int i = 0; i < newItemIdList.size(); i++)
        {
            totalCost += newItemCostList.get(i) * newItemStockOutList.get(i);
            totalPrice += newItemPriceList.get(i) * newItemStockOutList.get(i);
            totalGain = totalPrice - totalCost;
        }
        
        labelItem.setText(totalQuan + "");
        labelGain.setText(totalGain + "");
        labelCost.setText(totalCost + "");
        labelPrice.setText(totalPrice + "");
    }
    private void updateDate(JComboBox monthCombo, JComboBox dayCombo, JComboBox yearCombo, int selectedMonth)
    {
        String[] month = {"None", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for(int i = 0; i < month.length; i++)
            monthCombo.addItem(month[i]);
        if(selectedMonth == 0)
        {
            dayCombo.addItem("None");
            yearCombo.addItem("None");
        }
        else
        {
            monthCombo.setSelectedIndex(selectedMonth);
            updateDate2(dayCombo, yearCombo, selectedMonth);
        }
    }
    private void updateDate2(JComboBox dayCombo, JComboBox yearCombo, int selectedMonth)
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
        }
    }
    private void createColumns2()
    {
        //dtm = (DefaultTableModel) displayTable.getModel();
        dtm2 = new DefaultTableModel(0,0)
        {
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        newTable.setModel(dtm2);
        dtm2.addColumn("Number");
        dtm2.addColumn("Item Name");
        dtm2.addColumn("Article");
        dtm2.addColumn("Brand");
        dtm2.addColumn("Supplier");
        dtm2.addColumn("Price");
        dtm2.addColumn("Quantity");
        dtm2.addColumn("Total Price");
    }
    private void createColumns()
    {
        //dtm = (DefaultTableModel) displayTable.getModel();
        dtm = new DefaultTableModel(0,0)
        {
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        oldTable.setModel(dtm);
        dtm.addColumn("Number");
        dtm.addColumn("Item Name");
        dtm.addColumn("Article");
        dtm.addColumn("Brand");
        dtm.addColumn("Supplier");
        dtm.addColumn("Quantity");
        dtm.addColumn("Price");
    }
    public void updateTableData(int mode, String keyword, String category) throws Exception
    {
        itemDatabaseManager = new ItemDatabaseManager();
                
        if(mode == MODE_PROCESS)
            itemDatabaseManager.processAllData(MODE_UNSORT);
        else if(mode == MODE_FILTER_CATEGORY)
            itemDatabaseManager.filterByCategory(goodString(categoryCombo.getSelectedItem().toString()), goodString(supplierCombo.getSelectedItem().toString()), MODE_UNSORT);
        else if(mode == MODE_FILTER_SEARCH)
            itemDatabaseManager.filterBySearch(goodString(keyword), goodString(category), goodString(supplierCombo.getSelectedItem().toString()), MODE_UNSORT);
        
        itemIdList = itemDatabaseManager.getItemIdList();
        itemNameList = itemDatabaseManager.getItemNameList();
        itemCategoryList = itemDatabaseManager.getItemCategoryList();
        itemQuantityList = itemDatabaseManager.getItemQuantityList();
        itemCostList = itemDatabaseManager.getItemCostList();
        itemPriceList = itemDatabaseManager.getItemPriceList();
        itemSupplierList = itemDatabaseManager.getItemSupplierList();
        itemBrandList = itemDatabaseManager.getItemBrandList();
        itemArticleList = itemDatabaseManager.getItemArticleList();
        
        dtm.setRowCount(0);
        
        for(int i = 0; i < itemIdList.size(); i++)
        {
            String [] rowData = {
                i + 1 + "", itemNameList.get(i), itemArticleList.get(i), itemBrandList.get(i), itemSupplierList.get(i)
                    ,itemQuantityList.get(i).toString(),((char)8369) +(itemPriceList.get(i) + "")
            };
            dtm.addRow(rowData);
        }
        if(oldTable.getRowCount() >= 1)
        {
            oldTable.setRowSelectionInterval(0, 0);
        }
        oldTable.setRowHeight(30);
    }
    private String setFormat2(String date)
    {
        String returnDate = "";
        String splitDate [] = date.split("/");
        returnDate = splitDate[0] + "-" + splitDate[1] + "-" + splitDate[2];
        return returnDate;
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
        for(int i = 0; i <listOfCat.size(); i++)
        {
            categoryCombo.addItem(listOfCat.get(i));
        }
    }    
    private void updateComboBox2()
    {
        ArrayList<String> listOfAddress = new ArrayList<String>();
        listOfAddress.clear();
        
        BranchDatabaseManager branchDatabaseManager = new BranchDatabaseManager();
        ClientDatabaseManager clientDatabaseManager = new ClientDatabaseManager();
        
        try
        {
            branchDatabaseManager.processAllData();
            clientDatabaseManager.processAllData();
        }catch(Exception e){ShowFreakingError(e + " - Error 0015");}
        
        ArrayList<String> branchNames = branchDatabaseManager.getBranchNameList();
        ArrayList<String> clientNames = clientDatabaseManager.getClientNameList();
        
        for(int i = 0; i < branchNames.size(); i++)
        {
            listOfAddress.add(branchNames.get(i));
        }
        for(int i = 0; i < clientNames.size(); i++)
        {
            listOfAddress.add(clientNames.get(i));
        }
        
        for(int i = 0; i <listOfAddress.size(); i++)
        {
            stockout_comboBox.addItem(listOfAddress.get(i));
        }
    }
    private void updateComboBox3()
    {
        ArrayList<String> listOfSupplier = new ArrayList<>();
        listOfSupplier.clear();
        SupplierDatabaseManager supplierDb = new SupplierDatabaseManager();
        try
        {
            supplierDb.processAllData();
        }catch(Exception e){ShowFreakingError(e + " - Error 0050");}
        
        ArrayList<String> suppliers = supplierDb.getNameList();
        supplierCombo.addItem("None");
        for(int i = 0; i < suppliers.size(); i++)
            supplierCombo.addItem(suppliers.get(i));
    }
    private boolean isANumber(String s)
    {
        boolean valid = s.length() > 0;
        int dot = 0;
        for(int i = 0; i < s.length() && valid; i++)
        {
            switch(s.charAt(i))
            {
                case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':case '.':
                    if(s.charAt(i)=='.')
                        dot++;
                    break;
                default:
                    valid = false;
                    break;
            }
        }
        if(dot > 1)
            valid = false;
            
        return valid;
    }
    private void prepareFieldNumbers()
    {
        int availableInvoiceNumber = 0;
        int availableDeliveryNumber = 0;
        int availablePurchaseNumber = 0;
        String address = stockout_comboBox.getItemCount() < 1 ? "" : stockout_comboBox.getSelectedItem().toString();
        InvoiceDatabaseManager invoiceDatabaseManager = new InvoiceDatabaseManager();
        try
        {
            invoiceDatabaseManager.processDistinctNumbers(goodString(address));
            availableInvoiceNumber = invoiceDatabaseManager.getAvailableInvoiceNumber();
            availableDeliveryNumber = invoiceDatabaseManager.getAvailableDeliveryNumber();
            availablePurchaseNumber = invoiceDatabaseManager.getAvailablePurchaseNumber();
        }catch(Exception e){ShowFreakingError(e + " - Error 0037");}
        stockout_invoiceField.setText(availableInvoiceNumber + "");
        stockout_deliveryField.setText(availableDeliveryNumber + "");
        stockout_purchaseField.setText(availablePurchaseNumber + "");
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
    public void openStockOutFrame(MainFrame main)
    {
        myFrame = main;
        initComponents();
        updateComboBox3();
        updateComboBox2();
        updateComboBox();
        createColumns();
        createColumns2();
        prepareFieldNumbers();
        updateDate(monthCombo, dayCombo, yearCombo, 0);
        updateDate(monthCombo1, dayCombo1, yearCombo1, 0);
        newTable.setRowHeight(30);
        buttonGroup1.add(cashRadio);
        buttonGroup1.add(chequeRadio);
        radioActivation(true);
        try
        {
            updateTableData(MODE_FILTER_SEARCH, stockOut_searchBar.getText(), categoryCombo.getSelectedItem().toString());
        }catch(Exception e){ShowFreakingError(e + " - Error 0011");}
        
        newTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me)
            {
                if(SwingUtilities.isRightMouseButton(me))
                {
                    Popup(me, newTable.getSelectedRow());
                }
            }
        });
        setupTable(newTable, Color.white, new Dimension(0,30), Color.black);
        setupTable(oldTable, Color.white, new Dimension(0,30), Color.black);
        resizeColumnWidth(newTable);
        resizeColumnWidth(oldTable);
        ready = true;
    }
    private void Popup(MouseEvent me, int num)
    {
        double cost = newItemCostList.get(num);
        JPopupMenu sample = new JPopupMenu();
        JMenuItem adjust = new JMenuItem("New Price");
        adjust.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String returnVal = JOptionPane.showInputDialog("Enter new Price:");
                if(returnVal != null)
                {
                    if(isANumber(returnVal))
                    {
                        double returnValDouble = Double.parseDouble(returnVal);
                        
                        if(cost < returnValDouble)
                        {
                            newItemPriceList.set(num, returnValDouble);
                            newTable.setValueAt((char)8369 + "" + returnValDouble + "", num, 5);
                            newTable.setValueAt((char)8369 + "" + (returnValDouble * newItemStockOutList.get(num)), num, 7);
                            processStockStats();
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Price is too low than Item's Cost!", "Invalid Cost Value", JOptionPane.WARNING_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Please input a proper value!", "Invalid Cost Value!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        sample.add(adjust);
        sample.show(me.getComponent(), me.getX(), me.getY());
    }
    public void ShowFreakingError(String message)
    {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCost;
    private javax.swing.JLabel labelGain;
    private javax.swing.JLabel labelItem;
    private javax.swing.JLabel labelPrice;
    private javax.swing.JButton minusButton;
    private javax.swing.JComboBox<String> monthCombo;
    private javax.swing.JComboBox<String> monthCombo1;
    private javax.swing.JTable newTable;
    private javax.swing.JTable oldTable;
    private javax.swing.JButton printButton;
    private javax.swing.JTextField stockOut_searchBar;
    private javax.swing.JTextField stockout_chequeField;
    private javax.swing.JComboBox<String> stockout_comboBox;
    private javax.swing.JTextField stockout_deliveryField;
    private javax.swing.JTextField stockout_invoiceField;
    private javax.swing.JTextField stockout_purchaseField;
    private javax.swing.JComboBox<String> supplierCombo;
    private javax.swing.JComboBox<String> yearCombo;
    private javax.swing.JComboBox<String> yearCombo1;
    // End of variables declaration//GEN-END:variables
}
