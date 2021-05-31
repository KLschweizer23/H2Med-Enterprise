package inventorysystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class stockin_addDetailsFrame extends javax.swing.JFrame {

    StockInFrame stockin;
    boolean isCash = true;
    
    final private int PAID = 0;
    final private int UNPAID = 1;
    
    private double totalPrice = 0;
    private boolean applyRemove = true;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        labelItem1 = new javax.swing.JLabel();
        labelItem2 = new javax.swing.JLabel();
        labelItem3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        costLabel = new javax.swing.JLabel();
        supplierLabel = new javax.swing.JLabel();
        cashRadio = new javax.swing.JRadioButton();
        postRadio = new javax.swing.JRadioButton();
        pdcPanel = new javax.swing.JPanel();
        dayCombo1 = new javax.swing.JComboBox<>();
        monthCombo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        monthCombo1 = new javax.swing.JComboBox<>();
        yearCombo1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        dayCombo = new javax.swing.JComboBox<>();
        yearCombo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        labelItem4 = new javax.swing.JLabel();
        labelItem5 = new javax.swing.JLabel();
        chequeField = new javax.swing.JTextField();
        labelItem6 = new javax.swing.JLabel();
        labelItem7 = new javax.swing.JLabel();
        paidField = new javax.swing.JTextField();
        labelItem8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        labelItem9 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        labelItem1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem1.setText("Item Name");

        labelItem2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem2.setText("Item Cost");

        labelItem3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem3.setText("Supplier");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setText("Transaction Details");

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameLabel.setText("Item Name");

        costLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        costLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        costLabel.setText("Item Cost");

        supplierLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        supplierLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        supplierLabel.setText("Supplier");

        cashRadio.setSelected(true);
        cashRadio.setText("Cash");
        cashRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashRadioActionPerformed(evt);
            }
        });

        postRadio.setText("Post Dated Check");
        postRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postRadioActionPerformed(evt);
            }
        });

        pdcPanel.setEnabled(false);

        dayCombo1.setBackground(new java.awt.Color(255, 255, 255));

        monthCombo.setBackground(new java.awt.Color(255, 255, 255));
        monthCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel10.setText("/");

        monthCombo1.setBackground(new java.awt.Color(255, 255, 255));
        monthCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthCombo1ActionPerformed(evt);
            }
        });

        yearCombo1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel12.setText("/");

        dayCombo.setBackground(new java.awt.Color(255, 255, 255));

        yearCombo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel11.setText("/");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel13.setText("/");

        labelItem4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem4.setText("Transact Date:");

        labelItem5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem5.setText("Due Date:");

        chequeField.setBackground(new java.awt.Color(255, 255, 255));

        labelItem6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem6.setText("Cheque No.:");

        labelItem7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem7.setText("Paid");

        paidField.setBackground(new java.awt.Color(255, 255, 255));

        labelItem8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelItem8.setText((char)8369 + "");

        javax.swing.GroupLayout pdcPanelLayout = new javax.swing.GroupLayout(pdcPanel);
        pdcPanel.setLayout(pdcPanelLayout);
        pdcPanelLayout.setHorizontalGroup(
            pdcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pdcPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pdcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelItem4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelItem5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelItem6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pdcPanelLayout.createSequentialGroup()
                        .addComponent(labelItem7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(labelItem8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pdcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chequeField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pdcPanelLayout.createSequentialGroup()
                        .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pdcPanelLayout.createSequentialGroup()
                        .addComponent(monthCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dayCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yearCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(paidField))
                .addContainerGap())
        );
        pdcPanelLayout.setVerticalGroup(
            pdcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pdcPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pdcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(dayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelItem4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pdcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monthCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(dayCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(yearCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelItem5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pdcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chequeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelItem6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pdcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paidField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelItem7)
                    .addComponent(labelItem8))
                .addContainerGap())
        );

        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        labelItem9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem9.setText("Total Cost");

        totalLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalLabel.setText("Supplier");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelItem3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(supplierLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(costLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(postRadio)
                            .addComponent(cashRadio))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pdcPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(labelItem9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelItem1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelItem2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelItem3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(costLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(supplierLabel)))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelItem9)
                    .addComponent(totalLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cashRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(postRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pdcPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        stockin.setAlwaysOnTop(true);
        stockin.setAlwaysOnTop(false);
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        stockin.setEnabled(true);
        stockin.removeTransactionDetails(applyRemove);
    }//GEN-LAST:event_formWindowClosed

    private void monthComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthComboActionPerformed
        updateDate2(dayCombo, yearCombo, monthCombo.getSelectedIndex());
    }//GEN-LAST:event_monthComboActionPerformed

    private void monthCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthCombo1ActionPerformed
        updateDate2(dayCombo1, yearCombo1, monthCombo1.getSelectedIndex());
    }//GEN-LAST:event_monthCombo1ActionPerformed

    private void cashRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashRadioActionPerformed
        enableChild(false);
    }//GEN-LAST:event_cashRadioActionPerformed

    private void postRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postRadioActionPerformed
        enableChild(true);
    }//GEN-LAST:event_postRadioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String dueDate = yearCombo1.getSelectedItem() + "-" + monthCombo1.getSelectedIndex() + "-" + dayCombo1.getSelectedItem();
        if(isCash)
        {
            String method = "cash";
            stockin.addTransactionDetails(method, PAID, dueDate);
            applyRemove = false;
            dispose();
        }
        else
        {
            if(chequeField.getText().length() > 0 && !alreadyExist(chequeField.getText()))
            {
                if((Double.parseDouble(paidField.getText()) == totalPrice) || paidField.getText().equals("0"))
                {
                    String method = chequeField.getText();
                    boolean isPaid = totalPrice - Double.parseDouble(paidField.getText()) == 0;
                    boolean notPaid = Double.parseDouble(paidField.getText()) == 0;
                    if(isPaid && !notPaid)
                        stockin.addTransactionDetails(method, PAID, dueDate);
                    else
                    {
                        stockin.changeTransactionDetails();
                        stockin.addTransactionDetails(method, UNPAID, dueDate);
                    }
                    applyRemove = false;
                    dispose();
                }
                else
                    JOptionPane.showMessageDialog(null, "Payment is not equal for Item's total price!", "Something's Wrong", JOptionPane.ERROR_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null, "Please fill or change the cheque field!", "Something's Wrong", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private boolean alreadyExist(String text)
    {
        
        return false;
    }
    private void enableChild(boolean setValue)
    {
        isCash = !setValue;
        monthCombo.setEnabled(setValue);
        dayCombo.setEnabled(setValue);
        yearCombo.setEnabled(setValue);
        monthCombo1.setEnabled(setValue);
        dayCombo1.setEnabled(setValue);
        yearCombo1.setEnabled(setValue);
        chequeField.setEnabled(setValue);
        paidField.setEnabled(setValue);
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
    private void setDates()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        
        LocalDate now = LocalDate.now();  
        String date = dtf.format(now);
        String splitDate[] = date.split("-");
        updateDate(monthCombo, dayCombo, yearCombo, Integer.parseInt(splitDate[1]));
        dayCombo.setSelectedIndex(Integer.parseInt(splitDate[2]) - 1);
        yearCombo.setSelectedItem(splitDate[0]);
        
        LocalDate next = now.plusMonths(1);
        String dueDate = dtf.format(next);
        String splitDue[] = dueDate.split("-");
        updateDate(monthCombo1, dayCombo1, yearCombo1, Integer.parseInt(splitDue[1]));
        dayCombo1.setSelectedIndex(Integer.parseInt(splitDue[2]) - 1);
        yearCombo1.setSelectedItem(splitDue[0]);
    }
    public void setDetails(String itemName, String itemCost, String supplier, double totalPrice)
    {
        this.nameLabel.setText(itemName);
        this.costLabel.setText(itemCost);
        this.supplierLabel.setText(supplier);
        this.totalLabel.setText((char)8369 + " " + totalPrice);
        
        this.totalPrice = totalPrice;
    }
    public void openAddDetailsFrame(StockInFrame stock)
    {
        stockin = stock;
        initComponents();
        buttonGroup1.add(cashRadio);
        buttonGroup1.add(postRadio);
        setDates();
        enableChild(false);
    }
    public void ShowFreakingError(String message)
    {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cashRadio;
    private javax.swing.JTextField chequeField;
    private javax.swing.JLabel costLabel;
    private javax.swing.JComboBox<String> dayCombo;
    private javax.swing.JComboBox<String> dayCombo1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelItem1;
    private javax.swing.JLabel labelItem2;
    private javax.swing.JLabel labelItem3;
    private javax.swing.JLabel labelItem4;
    private javax.swing.JLabel labelItem5;
    private javax.swing.JLabel labelItem6;
    private javax.swing.JLabel labelItem7;
    private javax.swing.JLabel labelItem8;
    private javax.swing.JLabel labelItem9;
    private javax.swing.JComboBox<String> monthCombo;
    private javax.swing.JComboBox<String> monthCombo1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField paidField;
    private javax.swing.JPanel pdcPanel;
    private javax.swing.JRadioButton postRadio;
    private javax.swing.JLabel supplierLabel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JComboBox<String> yearCombo;
    private javax.swing.JComboBox<String> yearCombo1;
    // End of variables declaration//GEN-END:variables
}
