package inventorysystem;

public class ExpensesFormDialog extends javax.swing.JDialog {
    
    /**
     * Creates new form ExpensesFormDialog
     * @param parent
     * @param modal
     */
    public ExpensesFormDialog(RecordsFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        buttonGroup.add(radio_cash);
        buttonGroup.add(radio_postDatedCheck);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        field_particulars = new javax.swing.JTextField();
        radio_cash = new javax.swing.JRadioButton();
        radio_postDatedCheck = new javax.swing.JRadioButton();
        checkBox_isPaid = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        field_amount = new javax.swing.JTextField();
        combo_reason = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        pane_otherReason = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        combo_month = new javax.swing.JComboBox<>();
        combo_day = new javax.swing.JComboBox<>();
        combo_year = new javax.swing.JComboBox<>();
        field_pdc = new javax.swing.JTextField();
        button_create = new javax.swing.JButton();
        button_cancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        field_collectionReceipt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        field_referenceNumber = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Particulars");

        radio_cash.setSelected(true);
        radio_cash.setText("Cash");
        radio_cash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_cashActionPerformed(evt);
            }
        });

        radio_postDatedCheck.setText("Post Dated Check");
        radio_postDatedCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_postDatedCheckActionPerformed(evt);
            }
        });

        checkBox_isPaid.setText("Expense already paid");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Amount");

        combo_reason.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Education Expenses", "Freight Cost", "Gasoline Expenses", "Insurance Plan", "License and Legal Expenses", "Loans", "Office and Store Lease", "Office Equipment And Supplies", "Payroll and Employment Benefits: PAG-IBIG", "Payroll and Employment Benefits: PHILHEALTH", "Payroll and Employment Benefits: SSS", "Personal Expenses", "Sales Commission", "Telephone Expenses", "Utility Expenses", "Others" }));
        combo_reason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_reasonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(pane_otherReason);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Date Of Expense");

        combo_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        combo_day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        combo_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));

        field_pdc.setText("Jan 01, 2021");
        field_pdc.setEnabled(false);

        button_create.setText("Create Expense");
        button_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_createActionPerformed(evt);
            }
        });

        button_cancel.setText("Cancel Expense");
        button_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Collection Receipt");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Reference Number");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(field_amount)
                    .addComponent(field_particulars)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(field_pdc, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radio_postDatedCheck, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_create)))
                    .addComponent(field_referenceNumber)
                    .addComponent(field_collectionReceipt)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(combo_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(radio_cash)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(combo_reason, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBox_isPaid))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(0, 115, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(field_particulars, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(field_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(field_collectionReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(field_referenceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_reason, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBox_isPaid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radio_cash)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio_postDatedCheck)
                    .addComponent(button_create))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_pdc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_cancel))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo_reasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_reasonActionPerformed

    }//GEN-LAST:event_combo_reasonActionPerformed

    private void radio_postDatedCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_postDatedCheckActionPerformed
        setPDC(true);
    }//GEN-LAST:event_radio_postDatedCheckActionPerformed

    private void radio_cashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_cashActionPerformed
        setPDC(false);
    }//GEN-LAST:event_radio_cashActionPerformed

    private void button_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_createActionPerformed
        ExpensesObject eo = new ExpensesObject();
        
        String date = combo_year.getSelectedItem() + "-" + (combo_month.getSelectedIndex() + 1 < 10 ? "0" + (combo_month.getSelectedIndex() + 1) : combo_month.getSelectedIndex() + 1) + "-" + combo_day.getSelectedItem();
        String particulars = field_particulars.getText();
        String amount = field_amount.getText();
        String reason = combo_reason.getSelectedItem() + "";
        String otherReason = pane_otherReason.getText();
        String method = radio_cash.isSelected() ? "Cash" : "Post Dated Check";
        String dueDate = radio_cash.isSelected() ? "" : field_pdc.getText();
        String collection = field_collectionReceipt.getText();
        String reference = field_referenceNumber.getText();
        
        eo.setDate(date);
        eo.setParticulars(particulars);
        eo.setAmount(amount);
        eo.setReason(reason);
        eo.setOtherReason(otherReason);
        eo.setPaid(checkBox_isPaid.isSelected());
        eo.setMethod(method);
        eo.setDueDate(dueDate);
        eo.setCollection_receipt(collection);
        eo.setReference_number(reference);
        
        ExpensesDatabaseManager edb = new ExpensesDatabaseManager();
        
        try
        {
            edb.insertExpenses(eo);
        }catch(Exception e){System.out.println(e);System.exit(0);}
        
        dispose();
        
    }//GEN-LAST:event_button_createActionPerformed

    private void button_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_button_cancelActionPerformed
    
    private void setPDC(boolean isPDC)
    {
        field_pdc.setEnabled(isPDC);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton button_cancel;
    private javax.swing.JButton button_create;
    private javax.swing.JCheckBox checkBox_isPaid;
    private javax.swing.JComboBox<String> combo_day;
    private javax.swing.JComboBox<String> combo_month;
    private javax.swing.JComboBox<String> combo_reason;
    private javax.swing.JComboBox<String> combo_year;
    private javax.swing.JTextField field_amount;
    private javax.swing.JTextField field_collectionReceipt;
    private javax.swing.JTextField field_particulars;
    private javax.swing.JTextField field_pdc;
    private javax.swing.JTextField field_referenceNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane pane_otherReason;
    private javax.swing.JRadioButton radio_cash;
    private javax.swing.JRadioButton radio_postDatedCheck;
    // End of variables declaration//GEN-END:variables
}
