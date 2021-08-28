package inventorysystem;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import myUtilities.SystemUtilities;

public class Database_AddFrame extends javax.swing.JFrame {
    
    Database_AddFrame addItemFrame;
    DatabaseFrame databaseFrame;
    ItemDatabaseManager itemDatabaseManager;
    
    boolean noError[] = new boolean[6];
    boolean isEmptyP = false;
    boolean isEmptyE = false;

    int currentCategory;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        database_itemName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        database_itemQuantity = new javax.swing.JTextField();
        database_itemCost = new javax.swing.JTextField();
        database_itemPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        database_itemCategory = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        database_itemSupplier = new javax.swing.JComboBox<>();
        monthCombo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        dayCombo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        yearCombo = new javax.swing.JComboBox<>();
        monthCombo1 = new javax.swing.JComboBox<>();
        dayCombo1 = new javax.swing.JComboBox<>();
        yearCombo1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        database_itemBrand = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        database_itemArticle = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Item");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        database_itemName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                database_itemNameFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Category");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Quantity");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Cost");

        database_itemQuantity.setText("0");
        database_itemQuantity.setEnabled(false);
        database_itemQuantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                database_itemQuantityFocusLost(evt);
            }
        });

        database_itemCost.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                database_itemCostFocusLost(evt);
            }
        });

        database_itemPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                database_itemPriceFocusLost(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Price");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Purchased Date");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Expiration Date");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setText("Add Item");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        database_itemCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                database_itemCategoryActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel9.setText("Supplier");

        database_itemSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                database_itemSupplierActionPerformed(evt);
            }
        });

        monthCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel10.setText("/");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel11.setText("/");

        yearCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboActionPerformed(evt);
            }
        });

        monthCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthCombo1ActionPerformed(evt);
            }
        });

        yearCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearCombo1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel12.setText("/");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel13.setText("/");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel14.setText("Brand");

        database_itemBrand.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                database_itemBrandFocusLost(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel15.setText("Article");

        database_itemArticle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                database_itemArticleFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(database_itemName)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(monthCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dayCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yearCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(database_itemCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(database_itemSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(database_itemQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(database_itemCost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(database_itemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(database_itemBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(database_itemArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(database_itemName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(database_itemQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(database_itemCost, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(database_itemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(database_itemBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(database_itemArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(dayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(monthCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(dayCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(yearCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(database_itemCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(database_itemSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean isAllTrue = noError[0] && noError[2] && noError[3] && noError[4] && noError[5];
        if(isAllTrue)
        {
            double cost = Double.parseDouble(database_itemCost.getText());
            double price = Double.parseDouble(database_itemPrice.getText());
            if(cost > price)
            {
                this.setAlwaysOnTop(false);
                JOptionPane.showMessageDialog(null, "Item Cost is greater than Item Price!", "Invalid Cost Value!", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                insertItemData();
                closeWindow();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        closeWindow();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void database_itemNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_database_itemNameFocusLost
        noError[0] = noErrorText(database_itemName);
    }//GEN-LAST:event_database_itemNameFocusLost

    private void database_itemQuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_database_itemQuantityFocusLost
        
    }//GEN-LAST:event_database_itemQuantityFocusLost

    private void database_itemCostFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_database_itemCostFocusLost
        noError[2] = noErrorNumber(database_itemCost);
    }//GEN-LAST:event_database_itemCostFocusLost

    private void database_itemPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_database_itemPriceFocusLost
        noError[3] = noErrorNumber(database_itemPrice);
    }//GEN-LAST:event_database_itemPriceFocusLost

    private void database_itemCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_database_itemCategoryActionPerformed

    }//GEN-LAST:event_database_itemCategoryActionPerformed

    private void database_itemSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_database_itemSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_database_itemSupplierActionPerformed

    private void yearComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearComboActionPerformed

    private void yearCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearCombo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearCombo1ActionPerformed

    private void monthComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthComboActionPerformed
        updateDate2(dayCombo, yearCombo, monthCombo.getSelectedIndex());
    }//GEN-LAST:event_monthComboActionPerformed

    private void monthCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthCombo1ActionPerformed
        updateDate2(dayCombo1, yearCombo1, monthCombo1.getSelectedIndex());
    }//GEN-LAST:event_monthCombo1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        closeWindow();
    }//GEN-LAST:event_formWindowClosing

    private void database_itemBrandFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_database_itemBrandFocusLost
        noError[4] = noErrorText(database_itemBrand);
    }//GEN-LAST:event_database_itemBrandFocusLost

    private void database_itemArticleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_database_itemArticleFocusLost
        noError[5] = noErrorText(database_itemArticle);
    }//GEN-LAST:event_database_itemArticleFocusLost
    private void insertItemData()
    {
        itemDatabaseManager = new ItemDatabaseManager();
        
        String name = goodString(database_itemName.getText().trim().strip());
        String category = goodString(database_itemCategory.getItemAt(database_itemCategory.getSelectedIndex()));
        double quantity = Double.parseDouble(database_itemQuantity.getText().trim().strip());
        double cost = Double.parseDouble(database_itemCost.getText().trim().strip());
        double price = Double.parseDouble(database_itemPrice.getText().trim().strip());
        double stockOut = 0;
        String supplier = goodString(database_itemSupplier.getSelectedItem().toString());
        String brand = goodString(database_itemBrand.getText());
        String article = goodString(database_itemArticle.getText());
        
        String purchaseDate, expirationDate;
        
        if(monthCombo.getSelectedIndex() != 0)
            purchaseDate = yearCombo.getSelectedItem() + "-" + monthCombo.getSelectedIndex() + "-" + dayCombo.getSelectedItem();
        else purchaseDate = "2000-01-01";
        if(monthCombo1.getSelectedIndex() != 0)
            expirationDate = yearCombo1.getSelectedItem() + "-" + monthCombo1.getSelectedIndex() + "-" + dayCombo1.getSelectedItem();
        else expirationDate = "2000-01-01";
        
        try
        {
            itemDatabaseManager.insertData(name, category, quantity, cost, price, stockOut, purchaseDate, expirationDate, supplier, brand, article);
        }catch(Exception e){ShowFreakingError(e + " - Error 0023");}
    }
    private String goodString(String data)
    {
        String temp = data.replaceAll("'", "\\\\'");
        return temp;
    }
    private boolean numberChecker(String s)
    {
        boolean valid = true;
        int dot = 0;
        for(int i = 0; i < s.length(); i++)
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
    private boolean emptyChecker(String s)
    {
        boolean isEmpty = true;
        
        if(s.length() > 0)
            isEmpty = false;
        return isEmpty;
    }
    private boolean noErrorText(JTextField textField)
    {
        if(emptyChecker(textField.getText().trim().strip()))
        {
            textField.setBackground(Color.red);
            textField.setForeground(Color.white);
            return false;
        }
        else
        {
            textField.setBackground(Color.white);
            textField.setForeground(Color.black);
            return true;
        }
    }
    private boolean noErrorNumber(JTextField textField)
    {
        if(emptyChecker(textField.getText().trim().strip()) || !numberChecker(textField.getText().trim().strip()))
        {
            textField.setBackground(Color.red);
            textField.setForeground(Color.white);
            return false;
        }
        else
        {
            textField.setBackground(Color.white);
            textField.setForeground(Color.black);
            return true;
        }
    }
    private void updateComboBox()
    {
        ArrayList<String> listOfCat = new ArrayList<>();
        listOfCat.add("Medicine");
        listOfCat.add("Medical Supplies");
        listOfCat.add("Office Supplies");
        listOfCat.add("Janitorial Supplies");
        listOfCat.add("General Merchandise");
        listOfCat.add("Foods");
        listOfCat.add("Laboratory Supplies");
        for(int i = 0; i <listOfCat.size(); i++)
        {
            database_itemCategory.addItem(listOfCat.get(i));
        }
        database_itemCategory.setSelectedIndex(currentCategory);
    }
    private void updateComboBox2()
    {
        SupplierDatabaseManager supplierDB = new SupplierDatabaseManager();
        try
        {
            supplierDB.processAllData();
        }catch(Exception e){ShowFreakingError(e + "");}
        
        ArrayList<String> listOfSup = supplierDB.getNameList();
        database_itemSupplier.addItem("None");
        for(int i = 0; i < listOfSup.size(); i++)
        {
            database_itemSupplier.addItem(listOfSup.get(i));
        }
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
            updateDate2(dayCombo, yearCombo, selectedMonth);
        
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
    private void closeWindow()
    {
        this.dispose();
        if(databaseFrame != null)
        {
            databaseFrame.setEnabled(true);
            databaseFrame.setAlwaysOnTop(true);
            databaseFrame.setAlwaysOnTop(false);
        }
    }
    public void openAddFrame(int cat, DatabaseFrame dbFrame, String keyword)
    {
        this.currentCategory = cat;
        this.databaseFrame = dbFrame;
        initComponents();
        updateComboBox();
        updateComboBox2();
        updateDate(monthCombo, dayCombo, yearCombo, 0);
        updateDate(monthCombo1, dayCombo1, yearCombo1, 0);
        
        database_itemName.setText(keyword);
    }
    public void ShowFreakingError(String message)
    {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField database_itemArticle;
    private javax.swing.JTextField database_itemBrand;
    private javax.swing.JComboBox<String> database_itemCategory;
    private javax.swing.JTextField database_itemCost;
    private javax.swing.JTextField database_itemName;
    private javax.swing.JTextField database_itemPrice;
    private javax.swing.JTextField database_itemQuantity;
    private javax.swing.JComboBox<String> database_itemSupplier;
    private javax.swing.JComboBox<String> dayCombo;
    private javax.swing.JComboBox<String> dayCombo1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JComboBox<String> monthCombo;
    private javax.swing.JComboBox<String> monthCombo1;
    private javax.swing.JComboBox<String> yearCombo;
    private javax.swing.JComboBox<String> yearCombo1;
    // End of variables declaration//GEN-END:variables
}