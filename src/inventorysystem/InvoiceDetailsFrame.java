package inventorysystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class InvoiceDetailsFrame extends javax.swing.JFrame {

    InvoiceFrame invoiceFrame;
    
    private int currentInvoiceNumber = 0;
    private double outstanding = 0;
    private double paid = 0;
    
    private int collectionNumber;
    
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
        labelMethod = new javax.swing.JLabel();
        changeLabel = new javax.swing.JLabel();
        changeLabel2 = new javax.swing.JLabel();
        invoice_dueDate = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelItem8 = new javax.swing.JLabel();
        receivedField = new javax.swing.JTextField();
        labelItem9 = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        labelItem10 = new javax.swing.JLabel();
        sumField = new javax.swing.JTextField();
        labelItem11 = new javax.swing.JLabel((char)8369 + "");
        labelItem12 = new javax.swing.JLabel();
        forField = new javax.swing.JTextField();
        labelItem13 = new javax.swing.JLabel();
        checkField = new javax.swing.JTextField();
        labelItem14 = new javax.swing.JLabel();
        bankField = new javax.swing.JTextField();
        dateField = new javax.swing.JTextField();
        labelItem15 = new javax.swing.JLabel();
        collectionField = new javax.swing.JTextField();
        labelItem16 = new javax.swing.JLabel();
        invoice_Update = new javax.swing.JButton();

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        invoice_Pay.setBackground(new java.awt.Color(0, 204, 0));
        invoice_Pay.setForeground(new java.awt.Color(255, 255, 255));
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

        invoice_Delete.setBackground(new java.awt.Color(255, 0, 0));
        invoice_Delete.setForeground(new java.awt.Color(255, 255, 255));
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

        labelMethod.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelMethod.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelMethod.setText("N/A");

        changeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        changeLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        changeLabel.setText("Payment Method");

        changeLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        changeLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        changeLabel2.setText("Due Date");

        invoice_dueDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        invoice_dueDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        invoice_dueDate.setText("0/0/0000");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelItem8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem8.setText("Received from");

        receivedField.setBackground(new java.awt.Color(255, 255, 255));

        labelItem9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem9.setText("Address");

        addressField.setBackground(new java.awt.Color(255, 255, 255));

        labelItem10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem10.setText("Sum");

        sumField.setBackground(new java.awt.Color(255, 255, 255));

        labelItem11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        labelItem12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem12.setText("Payment for");

        forField.setBackground(new java.awt.Color(255, 255, 255));

        labelItem13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem13.setText("Check#");

        checkField.setBackground(new java.awt.Color(255, 255, 255));

        labelItem14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem14.setText("Bank");

        bankField.setBackground(new java.awt.Color(255, 255, 255));

        dateField.setBackground(new java.awt.Color(255, 255, 255));

        labelItem15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem15.setText("Date");

        collectionField.setBackground(new java.awt.Color(255, 255, 255));

        labelItem16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem16.setText("CR #");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelItem8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(receivedField))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelItem9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addressField))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelItem12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(labelItem10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(labelItem11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sumField)
                            .addComponent(forField)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelItem13)
                            .addComponent(labelItem14))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bankField)
                            .addComponent(checkField)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelItem15, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(labelItem16, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(collectionField)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelItem16)
                    .addComponent(collectionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelItem15)
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelItem8)
                    .addComponent(receivedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelItem9)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelItem10)
                    .addComponent(sumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelItem11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelItem12)
                    .addComponent(forField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelItem13)
                    .addComponent(checkField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelItem14)
                    .addComponent(bankField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        invoice_Update.setBackground(new java.awt.Color(255, 255, 255));
        invoice_Update.setForeground(new java.awt.Color(0, 0, 0));
        invoice_Update.setText("Update Invoice");
        invoice_Update.setEnabled(false);
        invoice_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoice_UpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(invoiceTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelItem4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelItem7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelItem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(changeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(changeLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(purchase_number, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(delivery_number, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(invoice_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(labelMethod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(invoice_dueDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invoice_number, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(invoice_client, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                        .addGap(44, 44, 44)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(invoice_Pay, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invoice_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invoice_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(invoiceTitle)
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                            .addComponent(changeLabel)
                            .addComponent(labelMethod))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelItem1)
                            .addComponent(invoice_client))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelItem2)
                            .addComponent(invoice_date))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(changeLabel2)
                            .addComponent(invoice_dueDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelItem3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invoice_outstanding)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelItem5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invoice_paid)
                                .addGap(10, 10, 10)
                                .addComponent(labelItem6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invoice_status)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invoice_Delete)
                            .addComponent(invoice_Pay)
                            .addComponent(invoice_Update))
                        .addGap(29, 29, 29))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        boolean filledUp =
                !collectionField.getText().isEmpty() &&
                !dateField.getText().isEmpty() &&
                !receivedField.getText().isEmpty() &&
                !addressField.getText().isEmpty() &&
                !sumField.getText().isEmpty() &&
                !forField.getText().isEmpty() &&
                !checkField.getText().isEmpty() &&
                !bankField.getText().isEmpty()
                ;
        CollectionDatabaseManager collectionDb = new CollectionDatabaseManager();
        boolean doesExist = true;
        try
        {
            doesExist = collectionDb.isReceiptExist(Integer.parseInt(collectionField.getText()));
        }catch(Exception e){System.out.println(e);}
        
        if(filledUp)
        {
            if(!(doesExist && invoice_status.getText().equals("Paid")))
            {
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
                                    {
                                        processPaymentDetails(pay);
                                        insertCollectionDetails();
                                    }
                                }
                                else if (result == JOptionPane.NO_OPTION)
                                {
                                    pass = false;
                                }
                            }
                        }
                    }while(!pass);
                }
            } else JOptionPane.showMessageDialog(null, "CR# already exist!");
        } else JOptionPane.showMessageDialog(null, "Please fill up all details before processing payment!");
    }//GEN-LAST:event_invoice_PayActionPerformed

    private void invoice_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoice_DeleteActionPerformed
        deleteInvoice(currentInvoiceNumber, invoice_client.getText());
    }//GEN-LAST:event_invoice_DeleteActionPerformed

    private void invoice_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoice_UpdateActionPerformed
        boolean filledUp =
                !collectionField.getText().isEmpty() &&
                !dateField.getText().isEmpty() &&
                !receivedField.getText().isEmpty() &&
                !addressField.getText().isEmpty() &&
                !sumField.getText().isEmpty() &&
                !forField.getText().isEmpty() &&
                !checkField.getText().isEmpty() &&
                !bankField.getText().isEmpty()
                ;
        if(filledUp)
        {
            String payment = "";
            boolean pass;
            double pay = 0;
            double currentOutstanding = Double.parseDouble(invoice_outstanding.getText().substring(2));
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
                            {
                                processPaymentDetails(pay);
                                updateCollectionDetails();
                            }
                        }
                        else if (result == JOptionPane.NO_OPTION)
                        {
                            pass = false;
                        }
                    }
                }
            }while(!pass);
        } else JOptionPane.showMessageDialog(null, "Please fill up all details before processing payment!");
    }//GEN-LAST:event_invoice_UpdateActionPerformed
    private void deleteInvoice(int id, String address)
    {
        InvoiceDatabaseManager invoiceDb = new InvoiceDatabaseManager();
        try
        {
            invoiceDb.deleteData(id, goodString(address));
        }catch(Exception e){ShowFreakingError(e + " - Error 0042");}
        dispose();
    }
    private void insertCollectionDetails()
    {
        CollectionDatabaseManager collectionDb = new CollectionDatabaseManager();
        
        int cr = Integer.parseInt(collectionField.getText());
        String date = dateField.getText();
        String received = receivedField.getText();
        String address = addressField.getText();
        double sum = Double.parseDouble(sumField.getText());
        String payment = forField.getText();
        String check = checkField.getText();
        String bank = bankField.getText();
        
        try
        {
            collectionDb.insertData(cr, goodString(received), goodString(address), sum, goodString(payment), goodString(check), goodString(bank), goodString(date), currentInvoiceNumber);
        }catch(Exception e){System.out.println(e);}
    }
    
    private void updateCollectionDetails()
    {
        CollectionDatabaseManager collectionDb = new CollectionDatabaseManager();
        
        int cr = Integer.parseInt(collectionField.getText());
        String date = dateField.getText();
        String received = receivedField.getText();
        String address = addressField.getText();
        double sum = Double.parseDouble(sumField.getText());
        String payment = forField.getText();
        String check = checkField.getText();
        String bank = bankField.getText();
        
        try
        {
            collectionDb.updateData(cr, goodString(received), goodString(address), sum, goodString(payment), goodString(check), goodString(bank), goodString(date), currentInvoiceNumber);
        }catch(Exception e){System.out.println(e);}
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
            invoiceDB.updateCollection(Integer.parseInt(collectionField.getText()), currentInvoiceNumber, goodString(invoice_client.getText()));
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
    private void prepareFields(String client, boolean isPaid)
    {
        if(!isPaid)
        {
            receivedField.setText(client);
            forField.setText(currentInvoiceNumber + "");
        }
        else
        {
            CollectionDatabaseManager colDb = new CollectionDatabaseManager();
            try
            {
                colDb.getDataByReceipt(collectionNumber);
            }catch(Exception e){System.out.println(e);}
            collectionField.setText(colDb.getCollectionList().get(0) + "");
            dateField.setText(colDb.getDateList().get(0));
            receivedField.setText(colDb.getReceivedList().get(0));
            addressField.setText(colDb.getAddressList().get(0));
            sumField.setText(colDb.getSumList().get(0) + "");
            forField.setText(colDb.getPaymentList().get(0));
            checkField.setText(colDb.getCheckList().get(0));
            bankField.setText(colDb.getBankList().get(0));
        }
        enableField(isPaid);
    }
    private void enableField(boolean isPaid)
    {
        collectionField.setEnabled(!isPaid);
        dateField.setEnabled(!isPaid);
        receivedField.setEnabled(!isPaid);
        addressField.setEnabled(!isPaid);
        sumField.setEnabled(!isPaid);
        forField.setEnabled(!isPaid);
        checkField.setEnabled(!isPaid);
        bankField.setEnabled(!isPaid);
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
    public void openDetailsFrame(InvoiceFrame invoice, int invoiceNum, String totalPrice, String totalPaid, String status, String client, String date, String delivery, String purchase, boolean isCash, String cheque, String due, int collection)
    {
        invoiceFrame = invoice;
        
        initComponents();
        currentInvoiceNumber = invoiceNum;
        collectionNumber = collection;
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
        if(isCash)
        {
            changeLabel.setText("Payment Method");
            labelMethod.setText("Cash");
            
            changeLabel2.setText("");
            invoice_dueDate.setText("");
        }
        else
        {
            changeLabel.setText("Cheque #");
            labelMethod.setText(cheque);
            
            invoice_dueDate.setText(due);
        }
        
        prepareFields(client, !status.equals("Unpaid"));
        resizeColumnWidth(invoiceTable);
        setupTable(invoiceTable, Color.white, new Dimension(0,30), Color.black);
        updateTableData();
        
        boolean isPartial = status.equals("Partially Paid");
        
        enableField(status.equals("Paid"));
        invoice_Pay.setEnabled(!isPartial);
        invoice_Update.setEnabled(isPartial);
    }
    public void ShowFreakingError(String message)
    {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private javax.swing.JTextField bankField;
    private javax.swing.JLabel changeLabel;
    private javax.swing.JLabel changeLabel2;
    private javax.swing.JTextField checkField;
    private javax.swing.JTextField collectionField;
    private javax.swing.JTextField dateField;
    private javax.swing.JLabel delivery_number;
    private javax.swing.JTextField forField;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JLabel invoiceTitle;
    private javax.swing.JButton invoice_Delete;
    private javax.swing.JButton invoice_Pay;
    private javax.swing.JButton invoice_Update;
    private javax.swing.JLabel invoice_client;
    private javax.swing.JLabel invoice_date;
    private javax.swing.JLabel invoice_dueDate;
    private javax.swing.JLabel invoice_number;
    private javax.swing.JLabel invoice_outstanding;
    private javax.swing.JLabel invoice_paid;
    private javax.swing.JLabel invoice_status;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelItem;
    private javax.swing.JLabel labelItem1;
    private javax.swing.JLabel labelItem10;
    private javax.swing.JLabel labelItem11;
    private javax.swing.JLabel labelItem12;
    private javax.swing.JLabel labelItem13;
    private javax.swing.JLabel labelItem14;
    private javax.swing.JLabel labelItem15;
    private javax.swing.JLabel labelItem16;
    private javax.swing.JLabel labelItem2;
    private javax.swing.JLabel labelItem3;
    private javax.swing.JLabel labelItem4;
    private javax.swing.JLabel labelItem5;
    private javax.swing.JLabel labelItem6;
    private javax.swing.JLabel labelItem7;
    private javax.swing.JLabel labelItem8;
    private javax.swing.JLabel labelItem9;
    private javax.swing.JLabel labelMethod;
    private javax.swing.JLabel purchase_number;
    private javax.swing.JTextField receivedField;
    private javax.swing.JTextField sumField;
    // End of variables declaration//GEN-END:variables
}
