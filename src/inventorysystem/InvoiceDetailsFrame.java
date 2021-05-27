package inventorysystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InvoiceDetailsFrame extends javax.swing.JFrame {

    InvoiceFrame invoiceFrame;
    
    private int currentInvoiceNumber = 0;
    private double outstanding = 0;
    private double paid = 0;
    
    ArrayList<String> itemList;
    ArrayList<Double> priceList;
    ArrayList<Double> quantityList;
    
    DefaultTableModel dtm;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        invoiceTitle = new javax.swing.JLabel();
        labelItem = new javax.swing.JLabel();
        labelItem1 = new javax.swing.JLabel();
        labelItem2 = new javax.swing.JLabel();
        labelItem3 = new javax.swing.JLabel();
        invoice_outstanding = new javax.swing.JLabel();
        labelItem5 = new javax.swing.JLabel();
        invoice_paid = new javax.swing.JLabel();
        labelItem6 = new javax.swing.JLabel();
        invoice_status = new javax.swing.JLabel();
        invoice_Pay = new javax.swing.JButton();
        invoice_number = new javax.swing.JLabel();
        invoice_client = new javax.swing.JLabel();
        invoice_date = new javax.swing.JLabel();
        invoice_Delete = new javax.swing.JButton();
        labelItem4 = new javax.swing.JLabel();
        purchase_number = new javax.swing.JLabel();
        labelItem7 = new javax.swing.JLabel();
        delivery_number = new javax.swing.JLabel();

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

        invoiceTable.setBackground(new java.awt.Color(255, 252, 237));
        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            }, new String[]
            {

            }
        ));
        invoiceTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        invoiceTable.setSelectionBackground(new java.awt.Color(177, 0, 0));
        invoiceTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        invoiceTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(invoiceTable);

        invoiceTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        invoiceTitle.setText("Invoice Details");

        labelItem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem.setText("Invoice #");

        labelItem1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem1.setText("Client");

        labelItem2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem2.setText("Issue Date");

        labelItem3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelItem3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem3.setText("Outstanding");

        invoice_outstanding.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        invoice_outstanding.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        invoice_outstanding.setText("0.00");

        labelItem5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelItem5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem5.setText("Paid");

        invoice_paid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        invoice_paid.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        invoice_paid.setText("0.00");

        labelItem6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelItem6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem6.setText("Status");

        invoice_status.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        invoice_status.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        invoice_status.setText("Unpaid");

        invoice_Pay.setText("Pay Invoice");
        invoice_Pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoice_PayActionPerformed(evt);
            }
        });

        invoice_number.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        invoice_number.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        invoice_number.setText("000");

        invoice_client.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        invoice_client.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        invoice_client.setText("N/A");

        invoice_date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        invoice_date.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        invoice_date.setText("0/0/0000");

        invoice_Delete.setText("Delete Invoice");
        invoice_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoice_DeleteActionPerformed(evt);
            }
        });

        labelItem4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem4.setText("Purchase #");

        purchase_number.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        purchase_number.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        purchase_number.setText("000");

        labelItem7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem7.setText("Delivery #");

        delivery_number.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        delivery_number.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        delivery_number.setText("000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(invoiceTitle)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelItem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelItem3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelItem5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelItem6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(invoice_outstanding, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(invoice_paid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(invoice_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(invoice_client, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(invoice_number, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(invoice_date, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))
                            .addComponent(invoice_Pay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(invoice_Delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(labelItem4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                                .addComponent(purchase_number, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(labelItem7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                                .addComponent(delivery_number, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelItem7)
                    .addComponent(delivery_number))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelItem4)
                    .addComponent(purchase_number))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelItem)
                    .addComponent(invoice_number))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelItem1)
                    .addComponent(invoice_client))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelItem2)
                    .addComponent(invoice_date))
                .addGap(38, 38, 38)
                .addComponent(labelItem3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invoice_outstanding)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelItem5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invoice_paid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelItem6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invoice_status)
                .addGap(37, 37, 37)
                .addComponent(invoice_Pay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invoice_Delete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(invoiceTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        invoiceFrame.setEnabled(true);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        invoiceFrame.setAlwaysOnTop(true);
        invoiceFrame.setAlwaysOnTop(false);
    }//GEN-LAST:event_formWindowClosing

    private void invoice_PayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoice_PayActionPerformed
        String payment = "";
        boolean pass;
        double pay = 0;
        double currentOutstanding = Double.parseDouble(invoice_outstanding.getText().substring(2));
        if(currentOutstanding == 0)
        {
            JOptionPane.showMessageDialog(null, "This is already paid!", "No need for payment", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            do
            {
                payment = JOptionPane.showInputDialog("Enter Value of Payment:");
                if(payment == null)
                {
                    pass = true;
                }
                else
                {
                    pass = isANumber(payment);
                    if(pass)
                    {
                        int result = JOptionPane.showConfirmDialog(null, "Payment is " + (char)8369 + " " + payment + ". Do you wish to Proceed?", "Confirming Data", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if(result == JOptionPane.YES_OPTION)
                        {
                            pay = Double.parseDouble(payment);
                            if(pay > currentOutstanding)
                            {
                                JOptionPane.showMessageDialog(null, "Payment is too much!", "Invalid Payment", JOptionPane.ERROR_MESSAGE);
                                pass = false;
                            }
                            else
                                processPaymentDetails(pay);
                        }
                        else if (result == JOptionPane.NO_OPTION)
                        {
                            pass = false;
                        }
                    }
                }
            }while(!pass);
        }
    }//GEN-LAST:event_invoice_PayActionPerformed

    private void invoice_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoice_DeleteActionPerformed
        deleteInvoice(currentInvoiceNumber, invoice_client.getText());
    }//GEN-LAST:event_invoice_DeleteActionPerformed
    private void deleteInvoice(int id, String address)
    {
        InvoiceDatabaseManager invoiceDb = new InvoiceDatabaseManager();
        try
        {
            invoiceDb.deleteData(id, address);
        }catch(Exception e){ShowFreakingError(e + " - Error 0042");}
        dispose();
    }
    private void processPaymentDetails(double payment)
    {
        InvoiceDatabaseManager invoiceDB = new InvoiceDatabaseManager();
        
        double currentOutstanding = Double.parseDouble(invoice_outstanding.getText().substring(2));
        int status = 0;
        
        if(payment < currentOutstanding)
        {
            status = 1;
            currentOutstanding -= payment;
        }
        else if(payment == currentOutstanding)
        {
            status = 2;
            currentOutstanding -= payment;
        }
        
        outstanding = currentOutstanding;
        
        invoice_status.setText(getStatus(status));
        invoice_outstanding.setText((char)8369 + " " + currentOutstanding);
        invoice_paid.setText((char)8369 + " " + (payment + paid));
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
        LocalDateTime now = LocalDateTime.now();  
        String date = setFormat2(dtf.format(now));
        
        try
        {
            invoiceDB.processPayment(currentInvoiceNumber, payment + paid, status, goodString(invoice_client.getText()));
            SalesDatabaseManager salesDB = new SalesDatabaseManager();
            salesDB.insertSales(Integer.parseInt(invoice_number.getText()), date, payment, goodString(invoice_client.getText()));
        }catch(Exception e){ShowFreakingError(e + " - Error 0038");}
        dispose();
        invoiceFrame.setAlwaysOnTop(true);
        invoiceFrame.setAlwaysOnTop(false);
    }
    private String goodString(String data)
    {
        String temp = data.replaceAll("'", "\\\\'");
        return temp;
    }
    private String setFormat2(String date)
    {
        String returnDate = "";
        String splitDate [] = date.split("/");
        returnDate = splitDate[0] + "-" + splitDate[1] + "-" + splitDate[2];
        return returnDate;
    }
    private String getStatus(int num)
    {
        String returnVal = "";
        switch(num)
        {
            case 0: returnVal = "Unpaid";break;
            case 1: returnVal = "Partially Paid";break;
            case 2: returnVal = "Paid";break;
        }
        
        return returnVal;
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
        invoiceTable.setModel(dtm);
        dtm.addColumn("Item");
        dtm.addColumn("Quantity");
        dtm.addColumn("Price");
        dtm.addColumn("Total Price");
    }
    private void updateTableData()
    {
        InvoiceDatabaseManager invoiceDB = new InvoiceDatabaseManager();
        try
        {
            invoiceDB.getItemsByInvoiceNumber(currentInvoiceNumber, goodString(invoice_client.getText()));
        }catch(Exception e){ShowFreakingError(e + " - Error 0039");}
        itemList = invoiceDB.getItemsList();
        priceList = invoiceDB.getPriceList();
        quantityList = invoiceDB.getQuantityList();
        
        dtm.setRowCount(0);
        
        for(int i = 0; i < itemList.size(); i++)
        {
            double totalPrice = priceList.get(i) * quantityList.get(i);
            
            String[] rowData = {itemList.get(i), quantityList.get(i) + "", (char)8369 + " " + priceList.get(i) + "", (char)8369 + " " + totalPrice + ""};
            dtm.addRow(rowData);
        }
        if(invoiceTable.getRowCount() >= 1)
        {
            invoiceTable.setRowSelectionInterval(0, 0);
        }
        invoiceTable.setRowHeight(30);
    }
    
    public void openDetailsFrame(InvoiceFrame invoice, int invoiceNum, String totalPrice, String totalPaid, String status, String client, String date, String delivery, String purchase)
    {
        invoiceFrame = invoice;
        
        initComponents();
        currentInvoiceNumber = invoiceNum;
        createColumns();
        
        delivery_number.setText(delivery);
        purchase_number.setText(purchase);
        invoice_number.setText(invoiceNum + "");
        invoice_client.setText(client);
        invoice_date.setText(date);
        
        paid = Double.parseDouble(totalPaid);
        outstanding = Double.parseDouble(totalPrice) - paid;
        
        invoice_outstanding.setText((char)8369 + " " + outstanding + "");
        invoice_paid.setText((char)8369 + " " + paid);
        invoice_status.setText(status);
        updateTableData();
    }
    public void ShowFreakingError(String message)
    {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel delivery_number;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JLabel invoiceTitle;
    private javax.swing.JButton invoice_Delete;
    private javax.swing.JButton invoice_Pay;
    private javax.swing.JLabel invoice_client;
    private javax.swing.JLabel invoice_date;
    private javax.swing.JLabel invoice_number;
    private javax.swing.JLabel invoice_outstanding;
    private javax.swing.JLabel invoice_paid;
    private javax.swing.JLabel invoice_status;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelItem;
    private javax.swing.JLabel labelItem1;
    private javax.swing.JLabel labelItem2;
    private javax.swing.JLabel labelItem3;
    private javax.swing.JLabel labelItem4;
    private javax.swing.JLabel labelItem5;
    private javax.swing.JLabel labelItem6;
    private javax.swing.JLabel labelItem7;
    private javax.swing.JLabel purchase_number;
    // End of variables declaration//GEN-END:variables
}
