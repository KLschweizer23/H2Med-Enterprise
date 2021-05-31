package inventorysystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

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
    ArrayList<String> newTransactionMethodList = new ArrayList<>();
    ArrayList<Integer> newTransactionStatusList = new ArrayList<>();
    ArrayList<String> newTransactionDueList = new ArrayList<>();

    private final int MODE_PROCESS = 0;
    private final int MODE_FILTER_CATEGORY = 1;
    private final int MODE_FILTER_SEARCH = 2;

    private final int MODE_UNSORT = 1;
  
    DefaultTableModel dtm;
    DefaultTableModel dtm2;
    
    boolean ready = false;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        yearCombo.setBackground(new java.awt.Color(255, 255, 255));
        yearCombo.setFocusable(false);
        yearCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel18.setText("/");

        confirmButton.setBackground(new java.awt.Color(255, 255, 255));
        confirmButton.setText("Confirm");
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

        dayCombo.setBackground(new java.awt.Color(255, 255, 255));
        dayCombo.setFocusable(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Total Cost");

        monthCombo.setBackground(new java.awt.Color(255, 255, 255));
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
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
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelItem)
                                    .addComponent(labelCost))))
                        .addGap(198, 198, 198)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108)
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
                .addGap(78, 78, 78))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        oldTable.setBackground(new java.awt.Color(255, 255, 255));
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

        newTable.setBackground(new java.awt.Color(255, 255, 255));
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

        stockIn_searchBar.setBackground(new java.awt.Color(255, 255, 255));
        stockIn_searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stockIn_searchBarKeyReleased(evt);
            }
        });

        categoryCombo.setBackground(new java.awt.Color(255, 255, 255));
        categoryCombo.setForeground(new java.awt.Color(255, 255, 255));
        categoryCombo.setFocusable(false);
        categoryCombo.setRequestFocusEnabled(false);
        categoryCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboActionPerformed(evt);
            }
        });

        supplierCombo.setBackground(new java.awt.Color(255, 255, 255));
        supplierCombo.setFocusable(false);
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
                        .addComponent(categoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    
                    stockin_addDetailsFrame addFrame = new stockin_addDetailsFrame();
                    addFrame.openAddDetailsFrame(this);
                    addFrame.setVisible(true);
                    setEnabled(false);
                    addFrame.setLocation((myFrame.getWidth() - addFrame.getWidth()) / 2, (myFrame.getHeight() - addFrame.getHeight()) / 2);
                    
                    int row = oldTable.getSelectedRow();
                    String name = oldTable.getValueAt(row, 1).toString();
                    String cost = oldTable.getValueAt(row, 6).toString().substring(2);
                    String supplier = oldTable.getValueAt(row, 4).toString();
                    double total = Double.parseDouble(cost) * newVal;
                    addFrame.setDetails(name, cost, supplier, total);
                    
                    addToOtherTable(this.oldTable.getSelectedRow(), newVal);
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
        processStocksStats();
    }//GEN-LAST:event_minusButtonActionPerformed

    private void monthComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthComboActionPerformed
        updateDate2(dayCombo, yearCombo, monthCombo.getSelectedIndex());
    }//GEN-LAST:event_monthComboActionPerformed

    private void yearComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearComboActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        if(monthCombo.getSelectedIndex() != 0)
        {
            itemDatabaseManager = new ItemDatabaseManager();
            StockInDatabaseManager stockInDatabaseManager = new StockInDatabaseManager();
            String newStockInIdValue = "";
            try {
                newStockInIdValue = "" + stockInDatabaseManager.getDistinctId().size() + 1;
            }catch (Exception e) {ShowFreakingError("" + e + " - Error 0009");} 

            if (this.newTable.getRowCount() > 0) 
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
                        String method = newTransactionMethodList.get(i);
                        int status = newTransactionStatusList.get(i);
                        String due = newTransactionDueList.get(i);
                        double total = newItemTotalCostList.get(i);
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
            } 
            else
              JOptionPane.showMessageDialog(null, "No data to Stock In!");
        }
        else
            JOptionPane.showMessageDialog(null, "Please set date properly!", "Error Date", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.myFrame.setEnabled(true);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.myFrame.setAlwaysOnTop(true);
        this.myFrame.setAlwaysOnTop(false);
    }//GEN-LAST:event_formWindowClosing

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
            "" + newQuantity * (itemCostList.get(number))
        };
        dtm2.addRow((Object[])rowData);
        if (newTable.getRowCount() >= 1)
            newTable.setRowSelectionInterval(0, newTable.getRowCount() - 1); 

        newTable.setRowHeight(30);
        processStocksStats();
    }

    private void processStocksStats() 
    {
        double totalItem = newItemIdList.size();
        double totalCost = 0.0D;
        for (int i = 0; i < newItemTotalCostList.size(); i++)
            totalCost += (newItemTotalCostList.get(i)); 
        labelItem.setText("" + totalItem);
        labelCost.setText("" + totalCost);
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
        if(mode == MODE_PROCESS)
            itemDatabaseManager.processAllData(MODE_UNSORT);
        else if(mode == MODE_FILTER_CATEGORY)
            itemDatabaseManager.filterByCategory(goodString(categoryCombo.getSelectedItem().toString()), goodString(supplierCombo.getSelectedItem().toString()),MODE_UNSORT);
        else if(mode == MODE_FILTER_SEARCH)
            itemDatabaseManager.filterBySearch(goodString(keyword), goodString(category), goodString(supplierCombo.getSelectedItem().toString()),MODE_UNSORT);

        itemIdList = itemDatabaseManager.getItemIdList();
        itemNameList = itemDatabaseManager.getItemNameList();
        itemCategoryList = itemDatabaseManager.getItemCategoryList();
        itemQuantityList = itemDatabaseManager.getItemQuantityList();
        itemCostList = itemDatabaseManager.getItemCostList();
        itemSupplierList = itemDatabaseManager.getItemSupplierList();
        ArrayList<Date> itemPurchaseDateList = itemDatabaseManager.getItemPurchaseDateList();
        ArrayList<Date> itemExpirationDateList = itemDatabaseManager.getItemExpirationDateList();
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
    private void updateDate(JComboBox monthCombo, JComboBox dayCombo, JComboBox yearCombo, int selectedMonth)
    {
        String[] month = {"None", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (String month1 : month)
            monthCombo.addItem(month1);
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
    public void addTransactionDetails(String method, int status, String due)
    {
        newTransactionMethodList.add(method);
        newTransactionStatusList.add(status);
        newTransactionDueList.add(due);
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
            processStocksStats();
        }
    }
    public void changeTransactionDetails()
    {
        newItemTotalCostList.set(newTable.getSelectedRow(), 0.0);
        
        newTable.setValueAt((char)8369 + " 0", newTable.getSelectedRow(), 6);
        
        processStocksStats();
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
    public void openStockInFrame(MainFrame main) {
        initComponents();
        myFrame = main;
        createColumns();
        createColumns2();
        updateComboBox2();
        updateComboBox();
        updateDate(monthCombo, dayCombo, yearCombo, 0);
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
        ready = true;
    }
  
  public void ShowFreakingError(String message) {
    JOptionPane.showMessageDialog(null, message, "Error", 0);
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox<String> categoryCombo;
    private javax.swing.JButton confirmButton;
    private javax.swing.JComboBox<String> dayCombo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JTable newTable;
    private javax.swing.JTable oldTable;
    private javax.swing.JTextField stockIn_searchBar;
    private javax.swing.JComboBox<String> supplierCombo;
    private javax.swing.JComboBox<String> yearCombo;
    // End of variables declaration//GEN-END:variables
}