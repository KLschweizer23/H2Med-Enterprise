package inventorysystem;

import inventoryPackage.InventoryDatabaseManager;
import inventoryPackage.ItemObject;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

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

    HashMap<String, String> customerNameAddress = new HashMap<>();

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
        hasDue = new javax.swing.JCheckBox();
        button_stockIn = new javax.swing.JButton();
        button_new = new javax.swing.JButton();
        button_prev = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        label_currentPage = new javax.swing.JLabel();
        label_totalPages = new javax.swing.JLabel();
        button_next = new javax.swing.JButton();

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
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        categoryCombo.setForeground(new java.awt.Color(0, 0, 0));
        categoryCombo.setFocusable(false);
        categoryCombo.setRequestFocusEnabled(false);
        categoryCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboActionPerformed(evt);
            }
        });
        jPanel2.add(categoryCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 83, 180, -1));

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
        jPanel2.add(stockOut_searchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 83, 250, -1));

        confirmButton.setBackground(new java.awt.Color(255, 255, 255));
        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });
        jPanel2.add(confirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1121, 474, 76, 30));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());

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
        newTable.setFocusable(false);
        newTable.setRequestFocusEnabled(false);
        newTable.setSelectionBackground(new java.awt.Color(177, 0, 0));
        newTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        newTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(newTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 325, 800, 230));

        addButton.setBackground(new java.awt.Color(255, 255, 255));
        addButton.setText("+");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel2.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 280, 47, 45));

        minusButton.setBackground(new java.awt.Color(255, 255, 255));
        minusButton.setText("-");
        minusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusButtonActionPerformed(evt);
            }
        });
        jPanel2.add(minusButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 325, 47, 45));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());

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
        oldTable.setFocusable(false);
        oldTable.setRequestFocusEnabled(false);
        oldTable.setSelectionBackground(new java.awt.Color(177, 0, 0));
        oldTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        oldTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        oldTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(oldTable);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 800, 210));

        stockout_comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockout_comboBoxActionPerformed(evt);
            }
        });
        jPanel2.add(stockout_comboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1131, 223, 156, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Invoice #");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(901, 171, -1, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Stock out Date");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(901, 199, -1, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Total Item/s");
        jLabel11.setToolTipText("");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1132, 362, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Total Cost");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1144, 402, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Total Price");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1136, 423, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText((char)8369 + "");
        jLabel14.setToolTipText("");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(946, 403, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText((char)8369 + "");
        jLabel15.setToolTipText("");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(946, 386, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Total Income");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1127, 383, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText((char)8369 + "");
        jLabel17.setToolTipText("");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(946, 423, -1, -1));

        labelItem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelItem.setText("0.0");
        jPanel2.add(labelItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(966, 369, -1, -1));

        labelCost.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelCost.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelCost.setText("0.0");
        jPanel2.add(labelCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(966, 403, -1, -1));

        labelPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPrice.setText("0.0");
        jPanel2.add(labelPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(966, 423, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Client");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(901, 222, -1, 20));

        labelGain.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelGain.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelGain.setText("0.0");
        jPanel2.add(labelGain, new org.netbeans.lib.awtextra.AbsoluteConstraints(966, 386, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel18.setText("/");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1117, 199, 10, 20));

        monthCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboActionPerformed(evt);
            }
        });
        jPanel2.add(monthCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1043, 200, 70, -1));

        jPanel2.add(dayCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1131, 200, 60, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel19.setText("/");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1195, 199, 10, 20));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Purchase Order #");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(901, 143, -1, 20));

        stockout_purchaseField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        stockout_purchaseField.setText("000");
        jPanel2.add(stockout_purchaseField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1147, 145, 140, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Delivery Receipt #");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(901, 115, -1, 20));

        stockout_deliveryField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        stockout_deliveryField.setText("000");
        jPanel2.add(stockout_deliveryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1147, 117, 140, -1));

        supplierCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierComboActionPerformed(evt);
            }
        });
        jPanel2.add(supplierCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 83, 190, -1));

        cashRadio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cashRadio.setSelected(true);
        cashRadio.setText("Cash");
        cashRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashRadioActionPerformed(evt);
            }
        });
        jPanel2.add(cashRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(901, 248, -1, 20));

        stockout_invoiceField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        stockout_invoiceField.setText("000");
        jPanel2.add(stockout_invoiceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1147, 173, 140, -1));

        chequeRadio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chequeRadio.setText("Cheque #");
        chequeRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chequeRadioActionPerformed(evt);
            }
        });
        jPanel2.add(chequeRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(901, 268, -1, 20));

        stockout_chequeField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        stockout_chequeField.setEnabled(false);
        stockout_chequeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockout_chequeFieldActionPerformed(evt);
            }
        });
        jPanel2.add(stockout_chequeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1133, 270, 154, -1));

        yearCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboActionPerformed(evt);
            }
        });
        jPanel2.add(yearCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1207, 200, 80, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Due Date");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 320, 80, 20));

        monthCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthCombo1ActionPerformed(evt);
            }
        });
        jPanel2.add(monthCombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 320, 70, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel24.setText("/");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 320, 10, 20));

        jPanel2.add(dayCombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 320, 60, -1));

        yearCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearCombo1ActionPerformed(evt);
            }
        });
        jPanel2.add(yearCombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 320, 80, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel25.setText("/");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 320, 10, 20));

        printButton.setBackground(new java.awt.Color(255, 255, 255));
        printButton.setText("Print");
        printButton.setEnabled(false);
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });
        jPanel2.add(printButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(951, 473, 76, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setText("Item Stock-Out");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 11, -1, 54));

        hasDue.setSelected(true);
        hasDue.setText("has Due Date");
        hasDue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hasDueActionPerformed(evt);
            }
        });
        jPanel2.add(hasDue, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 300, -1, -1));

        button_stockIn.setText("Stock In");
        button_stockIn.setFocusPainted(false);
        button_stockIn.setFocusable(false);
        button_stockIn.setRequestFocusEnabled(false);
        button_stockIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_stockInActionPerformed(evt);
            }
        });
        jPanel2.add(button_stockIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, 20));

        button_new.setText("New");
        button_new.setFocusPainted(false);
        button_new.setFocusable(false);
        button_new.setRequestFocusEnabled(false);
        button_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_newActionPerformed(evt);
            }
        });
        jPanel2.add(button_new, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 60, 20));

        button_prev.setText("Prev");
        button_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_prevActionPerformed(evt);
            }
        });
        jPanel2.add(button_prev, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 60, 20));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("of");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

        label_currentPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_currentPage.setText("1");
        jPanel2.add(label_currentPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        label_totalPages.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_totalPages.setText("1");
        jPanel2.add(label_totalPages, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 60, 10, -1));

        button_next.setText("Next");
        button_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_nextActionPerformed(evt);
            }
        });
        jPanel2.add(button_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 60, 20));

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
            label_currentPage.setText("1");
            updateTableData(MODE_FILTER_SEARCH, keyword, categoryCombo.getSelectedItem().toString());
        }catch(Exception e){ShowFreakingError(e + " - Error 0012");}
    }//GEN-LAST:event_stockOut_searchBarKeyReleased

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        if(stockout_comboBox.getItemCount() > 0)
        {
            if(monthCombo.getSelectedIndex() != 0)
            {
                if((hasDue.isSelected() && monthCombo1.getSelectedIndex() != 0) || !hasDue.isSelected())
                {
                    itemDatabaseManager = new ItemDatabaseManager();
                    StockOutDatabaseManager stockOutDatabaseManager = new StockOutDatabaseManager();
                    InvoiceDatabaseManager invoiceDatabaseManager = new InvoiceDatabaseManager();
                    boolean didInvoiceExist = false;
                    try
                    {
                        invoiceDatabaseManager.processDistinctNumbers(goodString(stockout_comboBox.getSelectedItem().toString()));
                        didInvoiceExist = invoiceDatabaseManager.checkInvoiceIfExist(Integer.parseInt(stockout_invoiceField.getText()));
                    }catch(Exception e){ShowFreakingError(e + " - Error 0034");}

                    if(!didInvoiceExist)
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
                                    insertInvoice(newItemIdList, newItemNameList, newItemCostList, newItemPriceList, newItemStockOutList, newItemSupplierList, newItemArticleList, newItemBrandList);
                                    SalesDatabaseManager salesDB = new SalesDatabaseManager();
                                    salesDB.insertOutstanding(date, goodString(stockout_comboBox.getSelectedItem().toString()), Double.parseDouble(labelPrice.getText()), Integer.parseInt(stockout_invoiceField.getText()));
                                }catch(Exception e){ShowFreakingError(e + " - Error 0035");}

                                confirmButton.setEnabled(false);
                                printButton.setEnabled(true);

                            }
                        }else JOptionPane.showMessageDialog(null, "No data to Stock Out!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }else JOptionPane.showMessageDialog(null, "Invoice Number already exists!", "Warning", JOptionPane.WARNING_MESSAGE);
                }else JOptionPane.showMessageDialog(null, "Please set the Due Date!", "Warning", JOptionPane.WARNING_MESSAGE);
            }else JOptionPane.showMessageDialog(null, "Please set the date!", "Warning", JOptionPane.WARNING_MESSAGE);
        }else JOptionPane.showMessageDialog(null, "No clients Available!", "Warning", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_confirmButtonActionPerformed
    private void insertInvoice(ArrayList<String> ids, ArrayList<String> items, ArrayList<Double> cost, ArrayList<Double> price, ArrayList<Double> quantity, ArrayList<String> itemSupplier, ArrayList<String> article, ArrayList<String> brand)
    {
        InvoiceDatabaseManager invoiceDatabaseManager = new InvoiceDatabaseManager();
        int invoiceNumber = Integer.parseInt(stockout_invoiceField.getText());
        int deliveryNumber = Integer.parseInt(stockout_deliveryField.getText());
        int purchaseNumber = Integer.parseInt(stockout_purchaseField.getText());
        String address = goodString(stockout_comboBox.getSelectedItem().toString());
        String invoice_date = yearCombo.getSelectedItem() + "-" + monthCombo.getSelectedIndex()+ "-" + dayCombo.getSelectedItem();
        String cheque = chequeRadio.isSelected() ? stockout_chequeField.getText() :  "Cash";
        String extraDay = ((dayCombo.getSelectedIndex() + 1) < 10 ? "0" + (dayCombo.getSelectedIndex() + 1) : dayCombo.getSelectedIndex() + 1) + "";
        String extraDueDate = monthCombo.getSelectedIndex() + 1 > 12 ? (Integer.parseInt(yearCombo.getSelectedItem().toString()) + 1) + "-" + "01" + "-" +  extraDay : yearCombo.getSelectedItem() + "-" + (monthCombo.getSelectedIndex() + 1 < 10 ? "0" + (monthCombo.getSelectedIndex() + 1) : monthCombo.getSelectedIndex() + 1) + "-" + extraDay;
        
        String dueDate = hasDue.isSelected() ? yearCombo1.getSelectedItem() + "-" + monthCombo1.getSelectedIndex()+ "-" + dayCombo1.getSelectedItem() : extraDueDate;
        boolean exist = false;
        InventoryDatabaseManager inventoryDb = new InventoryDatabaseManager();
        
        HashMap<String, String> tables = inventoryDb.getTables();
        String existingId = "";
        for(String id : tables.keySet())
            if(tables.get(id).equals(stockout_comboBox.getSelectedItem().toString().toLowerCase()))
            {
                existingId = id;
                exist = true;
                break;
            }

        for(int i = 0; i < items.size(); i++)
        {
            try
            {
                if(exist)
                {
                    String store = tables.get(existingId);
                    HashMap<String, String> map = inventoryDb.getItems(existingId, tables.get(existingId));
                    if(map.containsKey(ids.get(i)))
                    {
                        int oldStocks = Integer.parseInt(map.get(ids.get(i)));
                        double newStocks = quantity.get(i) + oldStocks;
                        inventoryDb.addStocks(existingId, store, ids.get(i), newStocks);
                    }
                    else
                    {
                        System.out.println("HERE1");
                        ItemObject io = new ItemObject();
                        System.out.println("HERE2");
                        io.setI_id(ids.get(i));
                        io.setItem(items.get(i));
                        io.setArticle(article.get(i));
                        io.setBrand(brand.get(i));
                        io.setPrice(price.get(i).toString());
                        io.setStocksLeft((int)(quantity.get(i) * 1));
                        
                        inventoryDb.insertItem(existingId, store, io);
                    }
                }
                invoiceDatabaseManager.insertData(invoiceNumber, goodString(items.get(i)), cost.get(i), price.get(i), quantity.get(i), address, 0, invoice_date, UNPAID, deliveryNumber, purchaseNumber, goodString(itemSupplier.get(i)), cheque, dueDate, 0);
            }catch(Exception e){ShowFreakingError(e + " - Error 0036");}
        }
    }
    private String goodString(String data)
    {
        String temp = data.replaceAll("'", "\\\\'");
        return temp;
    }
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        buttonAction();
    }//GEN-LAST:event_addButtonActionPerformed
    private void buttonAction()
    {
        if(oldTable.getRowCount() > 0)
        {
            String quantity;
            boolean pass;
            double newVal;
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
        }
    }
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
        minusAction();
    }//GEN-LAST:event_minusButtonActionPerformed
    private void minusAction()
    {
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
            processStockStats();
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
    }
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
                label_currentPage.setText("1");
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
                label_currentPage.setText("1");
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
        stockout_chequeField.setEnabled(false);
    }//GEN-LAST:event_cashRadioActionPerformed

    private void chequeRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chequeRadioActionPerformed
        hasDue.setSelected(true);
        stockout_chequeField.setEnabled(true);
    }//GEN-LAST:event_chequeRadioActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed

        try{
            String reportPath = System.getProperty("user.dir") + "\\StockoutReport.jrxml";
            String client = stockout_comboBox.getSelectedItem().toString();

            List<StockItems> collectionList = getStocks();

            JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(collectionList);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("CollectionBeanParam", itemsJRBean);
            parameters.put("logo", getClass().getResource("/Images/h2med_logo.png").toString());
            parameters.put("customerName", client);
            parameters.put("customerAddress", customerNameAddress.get(client));
            parameters.put("invoiceNumber", stockout_invoiceField.getText());
            parameters.put("purchaseNumber", stockout_purchaseField.getText());
            parameters.put("deliveryNumber", stockout_deliveryField.getText());
            parameters.put("invoiceDate", monthCombo.getSelectedItem() + " " + dayCombo.getSelectedItem() + ", " + yearCombo.getSelectedItem());
            if(cashRadio.isSelected())
            {
                parameters.put("method", "Cash");
                parameters.put("chequeNumber", "");
                parameters.put("dueDate", hasDue.isSelected() ? monthCombo1.getSelectedItem() + " " + dayCombo1.getSelectedItem() + ", " + yearCombo1.getSelectedItem() : "N/A");
            }
            else
            {
                parameters.put("method", "Post Dated Check");
                parameters.put("chequeNumber", "#" + stockout_chequeField.getText());
                parameters.put("dueDate", monthCombo1.getSelectedItem() + " " + dayCombo1.getSelectedItem() + ", " + yearCombo1.getSelectedItem());
            }

            InputStream input = new FileInputStream(new File(reportPath));
            JasperDesign jdesign = JRXmlLoader.load(input);


            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, parameters, new JREmptyDataSource());

            JasperViewer.viewReport(jprint, false);
        }catch(FileNotFoundException | JRException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_printButtonActionPerformed

    private ArrayList<StockItems> getStocks()
    {
        ArrayList<StockItems> itemsList = new ArrayList<>();

        for(int i = 0; i < dtm2.getRowCount(); i++)
        {
            StockItems items = new StockItems();
            items.setQuantity(dtm2.getValueAt(i, 6).toString());
            items.setItem(dtm2.getValueAt(i, 1).toString());
            items.setUnitPrice(dtm2.getValueAt(i, 5).toString());
            items.setTotalUnitPrice(dtm2.getValueAt(i, 7).toString());
            items.setTotalAmount(labelPrice.getText());
            itemsList.add(items);
        }
        return itemsList;
    }

    private void stockout_chequeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockout_chequeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockout_chequeFieldActionPerformed

    private void hasDueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hasDueActionPerformed
        radioActivation(hasDue.isSelected());
    }//GEN-LAST:event_hasDueActionPerformed

    private void button_stockInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_stockInActionPerformed

        String keyword = dtm.getRowCount() > 0 ? dtm.getValueAt(oldTable.getSelectedRow(), 1).toString() : stockOut_searchBar.getText();

        StockInFrame stockInFrame = new StockInFrame();
        stockInFrame.openStockInFrame(myFrame, keyword);
        stockInFrame.setVisible(true);
        int x = (getWidth() - stockInFrame.getWidth()) / 2;
        int y = (getHeight() - stockInFrame.getHeight()) / 2;
        stockInFrame.setLocation(x,y);
    }//GEN-LAST:event_button_stockInActionPerformed

    private void button_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_newActionPerformed
        String keyword = dtm.getRowCount() > 0 ? dtm.getValueAt(oldTable.getSelectedRow(), 1).toString() : stockOut_searchBar.getText();

        Database_AddFrame addItemFrame = new Database_AddFrame();
        addItemFrame.openAddFrame(categoryCombo.getSelectedIndex(), null, keyword);
        addItemFrame.setVisible(true);
        int x = (myFrame.getWidth() - addItemFrame.getWidth()) / 2;
        int y = (myFrame.getHeight() - addItemFrame.getHeight()) / 2;
        addItemFrame.setAlwaysOnTop(true);
        addItemFrame.setLocation(x,y);
    }//GEN-LAST:event_button_newActionPerformed

    private void button_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_prevActionPerformed
        int currentPage = Integer.parseInt(label_currentPage.getText());
        currentPage = currentPage == 1 ? 2 : currentPage ;
        label_currentPage.setText((--currentPage) + "");
        try
        {
            updateTableData(MODE_FILTER_SEARCH, stockOut_searchBar.getText(), categoryCombo.getSelectedItem().toString());
        }catch(Exception e){System.out.println(e);System.exit(0);}
    }//GEN-LAST:event_button_prevActionPerformed

    private void button_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_nextActionPerformed
        int currentPage = Integer.parseInt(label_currentPage.getText());
        int maxPage = Integer.parseInt(label_totalPages.getText());
        currentPage = currentPage == maxPage ? currentPage - 1 : currentPage;
        label_currentPage.setText((++currentPage) + "");
        try
        {
            updateTableData(MODE_FILTER_SEARCH, stockOut_searchBar.getText(), categoryCombo.getSelectedItem().toString());
        }catch(Exception e){System.out.println(e);System.exit(0);}
    }//GEN-LAST:event_button_nextActionPerformed
    private void radioActivation(boolean bool)
    {
        boolean isSelected = bool;
        jLabel23.setEnabled(isSelected);
        yearCombo1.setEnabled(isSelected);
        jLabel24.setEnabled(isSelected);
        monthCombo1.setEnabled(isSelected);
        jLabel25.setEnabled(isSelected);
        dayCombo1.setEnabled(isSelected);
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
        for (String month1 : month) {
            monthCombo.addItem(month1);
        }
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
            @Override
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
            @Override
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
        PaginationConfiguration pc = new PaginationConfiguration();

            int offset = (int) ((Double.parseDouble(label_currentPage.getText()) - 1) * pc.getLimit());
        
        String sup = supplierCombo.getSelectedIndex() == 0 ? "" : supplierCombo.getSelectedItem().toString();
                
        itemDatabaseManager.filterBySearch(goodString(keyword), goodString(category), goodString(sup), MODE_UNSORT, (int)pc.getLimit(), offset);

        int totalSize = itemDatabaseManager.getTotalData(goodString(keyword), goodString(category), "");

        label_totalPages.setText(((int) Math.ceil(totalSize / pc.getLimit())) + "");
        
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
                offset + i + 1 + "", itemNameList.get(i), itemArticleList.get(i), itemBrandList.get(i), itemSupplierList.get(i)
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
        String returnDate;
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
    public void updateComboBox2(boolean getDataOnly)
    {
        ArrayList<String> listOfAddress = new ArrayList<>();
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
        ArrayList<String> branchAddress = branchDatabaseManager.getBranchAddressList();
        ArrayList<String> clientAddress = clientDatabaseManager.getClientAddressList();

        for(int i = 0; i < branchNames.size(); i++)
        {
            listOfAddress.add(branchNames.get(i));
            customerNameAddress.put(branchNames.get(i), branchAddress.get(i));
        }
        for(int i = 0; i < clientNames.size(); i++)
        {
            listOfAddress.add(clientNames.get(i));
            customerNameAddress.put(clientNames.get(i), clientAddress.get(i));
        }

        for(int i = 0; i <listOfAddress.size() && !getDataOnly; i++)
        {
            stockout_comboBox.addItem(listOfAddress.get(i));
        }
    }
    public String getCustomernameAddress(String client)
    {
        return this.customerNameAddress.get(client);
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
        supplierCombo.addItem("All");
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
    private void setupCommands()
    {
        int property = JComponent.WHEN_IN_FOCUSED_WINDOW;
        getRootPane().registerKeyboardAction(e -> {
            buttonAction();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), property);
        oldTable.registerKeyboardAction(e -> {
            buttonAction();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), property);
        getRootPane().registerKeyboardAction(e -> {
            minusAction();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), property);
    }
    public void openStockOutFrame(MainFrame main)
    {
        myFrame = main;
        initComponents();
        updateComboBox3();
        updateComboBox2(false);
        updateComboBox();
        createColumns();
        createColumns2();
        prepareFieldNumbers();
        setupCommands();
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
            @Override
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
        JMenuItem editName = new JMenuItem("Edit Name");
        JMenuItem editPrice = new JMenuItem("Edit Price");
        editName.addActionListener((arg0) -> {
            String returnVal = JOptionPane.showInputDialog("Enter new Name:");
            if(returnVal != null ||returnVal.isBlank())
            {
                newItemNameList.set(num, returnVal);
                newTable.setValueAt(returnVal, num, 1);
            }
        });
        editPrice.addActionListener((ActionEvent arg0) -> {
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
        });
        sample.add(editName);
        sample.add(editPrice);
        sample.show(me.getComponent(), me.getX(), me.getY());
    }
    public void ShowFreakingError(String message)
    {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);System.exit(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton button_new;
    private javax.swing.JButton button_next;
    private javax.swing.JButton button_prev;
    private javax.swing.JButton button_stockIn;
    private javax.swing.JRadioButton cashRadio;
    private javax.swing.JComboBox<String> categoryCombo;
    private javax.swing.JRadioButton chequeRadio;
    private javax.swing.JButton confirmButton;
    private javax.swing.JComboBox<String> dayCombo;
    private javax.swing.JComboBox<String> dayCombo1;
    private javax.swing.JCheckBox hasDue;
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
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel label_currentPage;
    private javax.swing.JLabel label_totalPages;
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
