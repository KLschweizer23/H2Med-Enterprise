package inventorysystem;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Database_AddSupplierFrame extends javax.swing.JFrame {
    
    SupplierDatabaseManager supplierDatabaseManager = new SupplierDatabaseManager();
    DatabaseFrame dbFrame;
    
    boolean noErrorName = false;
    boolean noErrorAddress = false;
    boolean noErrorContact = false;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        database_supplierContact = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        database_supplierAddress = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        database_supplierName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        database_supplierContact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                database_supplierContactFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Contact");

        database_supplierAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                database_supplierAddressFocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Address");

        database_supplierName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                database_supplierNameFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Name");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setText("Add Supplier");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(175, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap(173, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(database_supplierAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(database_supplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(database_supplierContact, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(database_supplierName, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(database_supplierAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(database_supplierContact, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        closeWindow();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(noErrorName && noErrorAddress && noErrorContact)
        {
            insertSupplierData();
            closeWindow();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void database_supplierContactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_database_supplierContactFocusLost
        noErrorContact = noErrorText(database_supplierContact);
    }//GEN-LAST:event_database_supplierContactFocusLost

    private void database_supplierAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_database_supplierAddressFocusLost
        noErrorAddress = noErrorText(database_supplierAddress);
    }//GEN-LAST:event_database_supplierAddressFocusLost

    private void database_supplierNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_database_supplierNameFocusLost
        noErrorName = noErrorText(database_supplierName);
    }//GEN-LAST:event_database_supplierNameFocusLost

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        closeWindow();
    }//GEN-LAST:event_formWindowClosing
    private void closeWindow()
    {
        this.dispose();
        dbFrame.setEnabled(true);
        dbFrame.setAlwaysOnTop(true);
        dbFrame.setAlwaysOnTop(false);
    }
    private void insertSupplierData()
    {
        supplierDatabaseManager = new SupplierDatabaseManager();
        
        String name = goodString(database_supplierName.getText());
        String address = goodString(database_supplierAddress.getText());
        String contact = goodString(database_supplierContact.getText());
        
        try
        {
            supplierDatabaseManager.insertData(name, address, contact);
        }catch(Exception e){ShowFreakingError(e + "");}
    }
    private String goodString(String data)
    {
        String temp = data.replaceAll("'", "\\\\'");
        return temp;
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
    public void openAddFrame(DatabaseFrame dbFrame)
    {
        this.dbFrame = dbFrame;
        initComponents();
    }

    public void ShowFreakingError(String message)
    {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField database_supplierAddress;
    private javax.swing.JTextField database_supplierContact;
    private javax.swing.JTextField database_supplierName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
