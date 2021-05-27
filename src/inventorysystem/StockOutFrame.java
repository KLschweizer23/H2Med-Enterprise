package inventorysystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

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

        jLabel8 = new javax.swing.JLabel();
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
        stockout_invoiceField = new javax.swing.JTextField();
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
        yearCombo = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        stockout_purchaseField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        stockout_deliveryField = new javax.swing.JTextField();
        supplierCombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Stock Out");
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setText("Item Stock-Out");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        categoryCombo.setForeground(new java.awt.Color(255, 255, 255));
        categoryCombo.setFocusable(false);
        categoryCombo.setRequestFocusEnabled(false);
        categoryCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboActionPerformed(evt);
            }
        });
        getContentPane().add(categoryCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 160, -1));

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
        getContentPane().add(stockOut_searchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 250, -1));

        confirmButton.setBackground(new java.awt.Color(255, 255, 255));
        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });
        getContentPane().add(confirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 420, 76, 30));

        newTable.setBackground(new java.awt.Color(255, 252, 237));
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 800, 230));

        addButton.setBackground(new java.awt.Color(255, 255, 255));
        addButton.setText("+");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 280, 47, 45));

        minusButton.setBackground(new java.awt.Color(255, 255, 255));
        minusButton.setText("-");
        minusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusButtonActionPerformed(evt);
            }
        });
        getContentPane().add(minusButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 330, 47, 45));

        oldTable.setBackground(new java.awt.Color(255, 252, 237));
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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 114, 800, 210));

        stockout_comboBox.setBackground(new java.awt.Color(255, 255, 255));
        stockout_comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockout_comboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(stockout_comboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 240, 140, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Invoice #");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 180, -1, 20));

        stockout_invoiceField.setBackground(new java.awt.Color(255, 255, 255));
        stockout_invoiceField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        stockout_invoiceField.setText("000");
        getContentPane().add(stockout_invoiceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 180, 140, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Stock out Date");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 210, -1, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Total Item/s");
        jLabel11.setToolTipText("");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 280, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Total Cost");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 320, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Total Price");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 340, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText((char)8369 + "");
        jLabel14.setToolTipText("");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 320, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText((char)8369 + "");
        jLabel15.setToolTipText("");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 300, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Total Income");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 300, 80, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText((char)8369 + "");
        jLabel17.setToolTipText("");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 340, -1, -1));

        labelItem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelItem.setText("0.0");
        getContentPane().add(labelItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 280, -1, -1));

        labelCost.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelCost.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelCost.setText("0.0");
        getContentPane().add(labelCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 320, -1, -1));

        labelPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPrice.setText("0.0");
        getContentPane().add(labelPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 340, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Client");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 240, -1, 20));

        labelGain.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelGain.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelGain.setText("0.0");
        getContentPane().add(labelGain, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 300, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel18.setText("/");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 210, 10, 20));

        monthCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboActionPerformed(evt);
            }
        });
        getContentPane().add(monthCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 210, 70, -1));

        getContentPane().add(dayCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 210, 60, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel19.setText("/");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 210, 10, 20));

        yearCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboActionPerformed(evt);
            }
        });
        getContentPane().add(yearCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 210, 80, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Purchase Order #");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 150, -1, 20));

        stockout_purchaseField.setBackground(new java.awt.Color(255, 255, 255));
        stockout_purchaseField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        stockout_purchaseField.setText("000");
        getContentPane().add(stockout_purchaseField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 150, 140, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Delivery Receipt #");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 120, -1, 20));

        stockout_deliveryField.setBackground(new java.awt.Color(255, 255, 255));
        stockout_deliveryField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        stockout_deliveryField.setText("000");
        getContentPane().add(stockout_deliveryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 120, 140, -1));

        supplierCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierComboActionPerformed(evt);
            }
        });
        getContentPane().add(supplierCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 170, -1));

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
                    invoiceDatabaseManager.processDistinctNumbers(stockout_comboBox.getSelectedItem().toString());
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
                                            stockOutDatabaseManager.insertData(newStockOutIdValue, id + "", newVal, date, stockout_comboBox.getSelectedItem().toString(),cost, price,supplier);
                                        }catch(Exception e){ShowFreakingError(e + " - Error 0014");}
                                    }
                                    try
                                    {
                                        insertInvoice(newItemNameList, newItemCostList, newItemPriceList, newItemStockOutList, newItemSupplierList);
                                        SalesDatabaseManager salesDB = new SalesDatabaseManager();
                                        salesDB.insertOutstanding(date, stockout_comboBox.getSelectedItem().toString(), Double.parseDouble(labelPrice.getText()), Integer.parseInt(stockout_invoiceField.getText()));
                                    }catch(Exception e){ShowFreakingError(e + " - Error 0035");}
                                    dispose();
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
        for(int i = 0; i < items.size(); i++)
        {
            try
            {
                invoiceDatabaseManager.insertData(invoiceNumber, items.get(i), cost.get(i), price.get(i), quantity.get(i), address, 0, invoice_date, UNPAID, deliveryNumber, purchaseNumber, itemSupplier.get(i));
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

    private void yearComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearComboActionPerformed

    private void supplierComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierComboActionPerformed
        if(ready)
        {
            try
            {
                updateTableData(MODE_FILTER_SEARCH, stockOut_searchBar.getText(), categoryCombo.getSelectedItem().toString());
            }catch(Exception e){ShowFreakingError(e + " - Error 0052");}
        }
    }//GEN-LAST:event_supplierComboActionPerformed
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
            invoiceDatabaseManager.processDistinctNumbers(address);
            availableInvoiceNumber = invoiceDatabaseManager.getAvailableInvoiceNumber();
            availableDeliveryNumber = invoiceDatabaseManager.getAvailableDeliveryNumber();
            availablePurchaseNumber = invoiceDatabaseManager.getAvailablePurchaseNumber();
        }catch(Exception e){ShowFreakingError(e + " - Error 0037");}
        stockout_invoiceField.setText(availableInvoiceNumber + "");
        stockout_deliveryField.setText(availableDeliveryNumber + "");
        stockout_purchaseField.setText(availablePurchaseNumber + "");
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
        newTable.setRowHeight(30);
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
    private javax.swing.JComboBox<String> categoryCombo;
    private javax.swing.JButton confirmButton;
    private javax.swing.JComboBox<String> dayCombo;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCost;
    private javax.swing.JLabel labelGain;
    private javax.swing.JLabel labelItem;
    private javax.swing.JLabel labelPrice;
    private javax.swing.JButton minusButton;
    private javax.swing.JComboBox<String> monthCombo;
    private javax.swing.JTable newTable;
    private javax.swing.JTable oldTable;
    private javax.swing.JTextField stockOut_searchBar;
    private javax.swing.JComboBox<String> stockout_comboBox;
    private javax.swing.JTextField stockout_deliveryField;
    private javax.swing.JTextField stockout_invoiceField;
    private javax.swing.JTextField stockout_purchaseField;
    private javax.swing.JComboBox<String> supplierCombo;
    private javax.swing.JComboBox<String> yearCombo;
    // End of variables declaration//GEN-END:variables
}
