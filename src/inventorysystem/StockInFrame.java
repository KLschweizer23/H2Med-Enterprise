package inventorysystem;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.swing.JComboBox;

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

    private int MODE_PROCESS = 0;
    private int MODE_FILTER_CATEGORY = 1;
    private int MODE_FILTER_SEARCH = 2;

    private int MODE_SORT = 0;
    private int MODE_UNSORT = 1;
  
    DefaultTableModel dtm;
    DefaultTableModel dtm2;
    
    boolean ready = false;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        supplierCombo = new javax.swing.JComboBox<>();
        categoryCombo = new javax.swing.JComboBox<>();
        stockIn_searchBar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        oldTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        newTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        minusButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        monthCombo = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        dayCombo = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        yearCombo = new javax.swing.JComboBox<>();
        confirmButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        labelCost = new javax.swing.JLabel();
        labelItem = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

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

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setText("Item Stock-In");

        supplierCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierComboActionPerformed(evt);
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

        stockIn_searchBar.setBackground(new java.awt.Color(255, 255, 255));
        stockIn_searchBar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                stockIn_searchBarFocusLost(evt);
            }
        });
        stockIn_searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stockIn_searchBarKeyReleased(evt);
            }
        });

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

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Stock in Date");

        monthCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel18.setText("/");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel19.setText("/");

        yearCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboActionPerformed(evt);
            }
        });

        confirmButton.setBackground(new java.awt.Color(255, 255, 255));
        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Total Cost");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText((char)8369 + "");
        jLabel17.setToolTipText("");

        labelCost.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelCost.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelCost.setText("0.0");

        labelItem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelItem.setText("0.0");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Total Item/s");
        jLabel11.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 518, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addContainerGap(527, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stockIn_searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(categoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(supplierCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
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
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelItem)
                                            .addComponent(labelCost))))
                                .addGap(198, 198, 198)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel11))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(minusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stockIn_searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supplierCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(172, 172, 172)
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(minusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelItem)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(labelCost)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
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

    private void stockIn_searchBarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stockIn_searchBarFocusLost

    }//GEN-LAST:event_stockIn_searchBarFocusLost

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
                        String supplier = newItemSupplierList.get(i);
                        double stockIn = newItemStockInList.get(i);
                        String date = yearCombo.getSelectedItem() + "-" + monthCombo.getSelectedIndex() + "-" + dayCombo.getSelectedItem();
                        String method = newTransactionMethodList.get(i);
                        int status = newTransactionStatusList.get(i);
                        String due = newTransactionDueList.get(i);
                        try 
                        {
                            this.itemDatabaseManager.updateQuantityById(id, newVal);
                            stockInDatabaseManager.insertData(newStockInIdValue, "" + id, newVal, date, cost, supplier, stockIn, method, status, due);
                            SalesDatabaseManager salesDB = new SalesDatabaseManager();
                            salesDB.insertCost(date, cost * stockIn);
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
        dtm2.addColumn("Number");
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
        dtm.addColumn("Number");
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
            itemDatabaseManager.filterByCategory(categoryCombo.getSelectedItem().toString(), supplierCombo.getSelectedItem().toString(),MODE_UNSORT);
        else if(mode == MODE_FILTER_SEARCH)
            itemDatabaseManager.filterBySearch(keyword, category, supplierCombo.getSelectedItem().toString(),MODE_UNSORT);

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