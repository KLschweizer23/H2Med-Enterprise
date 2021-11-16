package inventorysystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import myUtilities.DatabaseFunctions;
import myUtilities.SystemUtilities;

public class RecordsFrame extends javax.swing.JFrame {
    
    MainFrame myFrame;
    
    DefaultTableModel dtm, dtm2, dtm3;
    
    boolean ready = false;
    
    ArrayList<String> itemIdKeyList;
    ArrayList<String> itemIdList;
    ArrayList<String> itemNameList;
    
    ArrayList<String> extraIdList;
    ArrayList<String> extraIdList2;
    ArrayList<String> extraNameList;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        salesTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        purchaseTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        label_purchase = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        label_paidSales = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        label_unpaidSales = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        expensesTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        label_expenses = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comboBox_supplier = new javax.swing.JComboBox<>();
        comboBox_customer = new javax.swing.JComboBox<>();
        btn_newExpenses = new javax.swing.JButton();
        btn_newExpenses1 = new javax.swing.JButton();
        comboBox_year = new javax.swing.JComboBox<>();
        comboBox_month = new javax.swing.JComboBox<>();

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

        jPanel1.setPreferredSize(new java.awt.Dimension(1088, 650));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Records");

        salesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            }, new String[]
            {

            }
        ));
        salesTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        salesTable.setSelectionBackground(new java.awt.Color(177, 0, 0));
        salesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        salesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(salesTable);

        purchaseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            }, new String[]
            {

            }
        ));
        purchaseTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        purchaseTable.setSelectionBackground(new java.awt.Color(177, 0, 0));
        purchaseTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        purchaseTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(purchaseTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Total Purchases:");

        label_purchase.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_purchase.setText("0.0");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Total Paid Sales:");

        label_paidSales.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_paidSales.setText("0.0");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Total Unpaid Sales:");

        label_unpaidSales.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_unpaidSales.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_unpaidSales.setText("0.0");

        expensesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            }, new String[]
            {

            }
        ));
        expensesTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        expensesTable.setSelectionBackground(new java.awt.Color(177, 0, 0));
        expensesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        expensesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(expensesTable);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Purchase");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Sales");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Total Expenses:");

        label_expenses.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_expenses.setText("0.0");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Expenses");

        comboBox_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_supplierActionPerformed(evt);
            }
        });

        comboBox_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_customerActionPerformed(evt);
            }
        });

        btn_newExpenses.setText("New Expenses");
        btn_newExpenses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newExpensesActionPerformed(evt);
            }
        });

        btn_newExpenses1.setText("Delete Selected Expense");
        btn_newExpenses1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newExpenses1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label_purchase))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(comboBox_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_newExpenses)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_newExpenses1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_expenses)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBox_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label_paidSales)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label_unpaidSales))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBox_customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_newExpenses)
                        .addComponent(btn_newExpenses1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(label_paidSales)
                        .addComponent(jLabel3)
                        .addComponent(label_unpaidSales))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(label_expenses))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(label_purchase)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        comboBox_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_yearActionPerformed(evt);
            }
        });

        comboBox_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_monthActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboBox_month, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBox_year, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBox_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1312, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        myFrame.setAlwaysOnTop(true);
        myFrame.setAlwaysOnTop(false);
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        myFrame.setEnabled(true);
    }//GEN-LAST:event_formWindowClosed

    private void comboBox_monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_monthActionPerformed
        if(ready){
            processPurchases();
            processSales();
            processExpenses();
        }
    }//GEN-LAST:event_comboBox_monthActionPerformed

    private void comboBox_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_yearActionPerformed
        if(ready){
            processPurchases();
            processSales();
            processExpenses();
        }
    }//GEN-LAST:event_comboBox_yearActionPerformed

    private void btn_newExpensesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newExpensesActionPerformed
        ExpensesFormDialog efd = new ExpensesFormDialog(this, true);
        int x = (myFrame.getWidth() - efd.getWidth()) / 2;
        int y = (myFrame.getHeight() - efd.getHeight()) / 2;
        efd.setLocation(x,y);
        efd.setVisible(true);
    }//GEN-LAST:event_btn_newExpensesActionPerformed

    private void btn_newExpenses1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newExpenses1ActionPerformed
        if(expensesTable.getRowCount() > 0)
        {
            ExpensesDatabaseManager edb = new ExpensesDatabaseManager();
            int id = Integer.parseInt(dtm3.getValueAt(expensesTable.getSelectedRow(), 0).toString());
            try
            {
                edb.deleteExpense(id);
            }catch(Exception e){System.out.println(e);System.exit(0);}
            processExpenses();
        }
    }//GEN-LAST:event_btn_newExpenses1ActionPerformed

    private void comboBox_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_supplierActionPerformed
        if(ready){
            processPurchases();
        }
    }//GEN-LAST:event_comboBox_supplierActionPerformed

    private void comboBox_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_customerActionPerformed
        if(ready){
            processSales();
        }
    }//GEN-LAST:event_comboBox_customerActionPerformed

    private void createColumns()
    {
        dtm = new DefaultTableModel(0,0)
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        dtm.addColumn("Date");
        dtm.addColumn("Supplier");
        dtm.addColumn("Reference #");
        dtm.addColumn("Collection Receipt");
        dtm.addColumn("Amount");
        purchaseTable.setModel(dtm);
    }
    private void createColumns2()
    {
        dtm2 = new DefaultTableModel(0,0)
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        dtm2.addColumn("Date");
        dtm2.addColumn("Invoice #");
        dtm2.addColumn("Customer");
        dtm2.addColumn("Total Purchase");
        dtm2.addColumn("Collection Receipt");
        salesTable.setModel(dtm2);
    }
    private void updateMonthsYears(){
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] years = {"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"};
        
        for(String month : months)
            comboBox_month.addItem(month);
        for(String year : years)
            comboBox_year.addItem(year);
    }
    private void processSales(){
        dtm2.setRowCount(0);
        
        DatabaseFunctions df = new DatabaseFunctions();
        
        String[] numericMonths = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        String dateQuery = comboBox_year.getSelectedItem().toString() + "-" + numericMonths[comboBox_month.getSelectedIndex()];
        String customer = comboBox_customer.getSelectedItem().toString();
        customer = customer.equals("All") ? "" : customer;
        String query = "SELECT DISTINCT(INVOICE_NUMBER) as invoiceNumber from invoicetable WHERE INVOICE_DATE LIKE '" + dateQuery + "%' AND ADDRESS LIKE '%" + customer + "%' ORDER BY ID DESC;";
        
        HashMap<String, ArrayList> map = df.customReturnQuery(query, new String[]{"invoiceNumber"});
        ArrayList<String> invoiceIdList = map.get("invoiceNumber");
        Thread t = new Thread(() -> {
            double totalPaid = 0;
            double totalUnpaid = 0;
            for(int i = 0; i < invoiceIdList.size(); i++){
                int invoiceID = Integer.parseInt(invoiceIdList.get(i));
                SalesObject[] sos = getSalesObject(invoiceID, dateQuery);
                for(int j = 0; j < sos.length; j++)
                {
                    SalesObject so = sos[j];
                    String[] rowData = {
                        so.getDate(),
                        so.getInvoiceNumber(),
                        so.getCustomer(),
                        (char)8369 + " " + so.getTotalPurchase(),
                        so.getCollectionReceipt()
                    };
                    dtm2.addRow(rowData);
                    totalUnpaid += Double.parseDouble(so.getTotalPurchase());
                    totalPaid += so.getPaid();
                }
            }
            System.out.println(totalUnpaid + " - " + totalPaid);
            totalUnpaid -= totalPaid;
            updateSales(totalPaid, totalUnpaid);
        });
        t.start();
        salesTable.setRowHeight(30);
        resizeColumnWidth(salesTable);
    }
    private void updatePurchase(double total){
        DecimalFormat df = new DecimalFormat();
        label_purchase.setText((char)8369 + " " + df.format(total));
    }
    private void updateSales(double totalPaid, double totalUnpaid){
        DecimalFormat df = new DecimalFormat();
        label_paidSales.setText((char)8369 + " " + df.format(totalPaid));
        label_unpaidSales.setText((char)8369 + " " + df.format(totalUnpaid));
    }
    private void processPurchases(){
        dtm.setRowCount(0);
        
        DatabaseFunctions df = new DatabaseFunctions();
        
        String[] numericMonths = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        String dateQuery = comboBox_year.getSelectedItem().toString() + "-" + numericMonths[comboBox_month.getSelectedIndex()];
        String supplier = comboBox_supplier.getSelectedItem().toString();
        supplier = supplier.equals("All") ? "" : supplier;
        String query = "SELECT DISTINCT(STOCK_IN_ID) as 'stockID' FROM stockintable WHERE ITEM_DATE_IN LIKE '" + dateQuery + "%' AND ITEM_SUPPLIER LIKE '%" + supplier + "%' ORDER BY ID DESC;";
        
        HashMap<String, ArrayList> map = df.customReturnQuery(query, new String[]{"stockID"});
        ArrayList<String> stockIdList = map.get("stockID");
        
        Thread t = new Thread(() -> {
            double total = 0;
            for(int i = 0; i < stockIdList.size(); i++){
                int stockInID = Integer.parseInt(stockIdList.get(i));
                PurchasesObject po = getPurchaseObject(stockInID, dateQuery);

                String[] rowData = {
                    po.getDate(),
                    po.getSupplier(),
                    po.getReferenceNumber(),
                    po.getCollectionReceipt(),
                    (char)8369 + " " + po.getAmount()
                };
                dtm.addRow(rowData);
                total += Double.parseDouble(po.getAmount());
            }
            updatePurchase(total);
        });
        t.start();
        purchaseTable.setRowHeight(30);        
        resizeColumnWidth(purchaseTable);
    }
    private SalesObject[] getSalesObject(int invoiceID, String date){
        SalesObject[] sos = new SalesObject[0];
        
        DatabaseFunctions df = new DatabaseFunctions();
        
        String[] keyName = {"date", "customer", "invoiceNumber", "total", "collection", "paid"};
        String query = "SELECT INVOICE_DATE as date,  ADDRESS as customer, INVOICE_NUMBER as invoiceNumber, SUM(PRICE * QUANTITY) as total, COLLECTION as collection, PAID as paid FROM invoicetable WHERE INVOICE_NUMBER = " + invoiceID + " AND INVOICE_DATE LIKE '" + date + "%' GROUP BY ADDRESS;";
        
        HashMap<String, ArrayList> map = df.customReturnQuery(query, keyName);
        if(map.get("invoiceNumber") != null)
        {
            sos = new SalesObject[map.get("invoiceNumber").size()];
            for(int i = 0; i < map.get("invoiceNumber").size(); i ++)
            {
                SalesObject so = new SalesObject();
                so.setInvoiceNumber(map.get("invoiceNumber").get(i).toString());
                so.setDate(map.get("date").get(i).toString());
                so.setCustomer(map.get("customer").get(i).toString());
                so.setTotalPurchase(map.get("total").get(i).toString());
                so.setCollectionReceipt(map.get("collection").get(i).toString());
                so.setPaid(Double.parseDouble(map.get("paid").get(i).toString()));
                System.out.println(so.getPaid());
                sos[i] = so;
            }
            System.out.println(sos.length);
        }
        
        return sos;
    }
    private PurchasesObject getPurchaseObject(int stockID, String date){
        PurchasesObject po = new PurchasesObject();
        
        DatabaseFunctions df = new DatabaseFunctions();
        
        String[] keyName = {"stockID", "date", "supplier", "refNumber", "collectionReceipt", "amount"};
        String query = "SELECT STOCK_IN_ID as stockID, ITEM_DATE_IN as date, ITEM_SUPPLIER as supplier, REFERENCE_NUMBER as refNumber, COLLECTION_RECEIPT as collectionReceipt, SUM((ITEM_QUANTITY * ITEM_COST)) as amount from stockintable WHERE STOCK_IN_ID = " + stockID + " AND ITEM_DATE_IN LIKE '" + date + "%'";
        
        HashMap<String, ArrayList> map = df.customReturnQuery(query, keyName);
        
        if(map.get("stockID") != null){
            po.setId(map.get("stockID").get(0).toString());
            po.setDate(map.get("date").get(0).toString());
            po.setSupplier(map.get("supplier").get(0).toString());
            po.setReferenceNumber(map.get("refNumber").get(0).toString());
            po.setCollectionReceipt(map.get("collectionReceipt").get(0).toString());
            po.setAmount(map.get("amount").get(0).toString());
        }
        
        return po;
    }
    private void createColumns3()
    {
        dtm3 = new DefaultTableModel(0,0)
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        expensesTable.setModel(dtm3);
        dtm3.addColumn("ID");
        dtm3.addColumn("Date");
        dtm3.addColumn("Particulars");
        dtm3.addColumn("Amount");
        dtm3.addColumn("Description");
        dtm3.addColumn("Collection Receipt");
        dtm3.addColumn("Reference #");
    }
    
    private void listOfSuppliers()
    {
        DatabaseFunctions df = new DatabaseFunctions();
        String query = "SELECT DISTINCT(ITEM_SUPPLIER) as suppliers FROM stockintable ORDER BY ITEM_SUPPLIER ASC;";
        
        HashMap<String, ArrayList> map = df.customReturnQuery(query, new String[]{"suppliers"});
        comboBox_supplier.addItem("All");
        for(int i = 0; i < (map.get("suppliers") == null ? 0 : map.get("suppliers").size()); i++)
            comboBox_supplier.addItem(map.get("suppliers").get(i).toString());
    }
    
    private void listOfCustomers()
    {
        DatabaseFunctions df = new DatabaseFunctions();
        String query = "SELECT DISTINCT(ADDRESS) as customers FROM invoicetable i ORDER BY ADDRESS ASC;";
        
        HashMap<String, ArrayList> map = df.customReturnQuery(query, new String[]{"customers"});
        comboBox_customer.addItem("All");
        for(int i = 0; i < (map.get("customers") == null ? 0 : map.get("customers").size()); i++)
            comboBox_customer.addItem(map.get("customers").get(i).toString());
    }
    
    private void processExpenses()
    {
        dtm3.setRowCount(0);
        
        ExpensesDatabaseManager edb = new ExpensesDatabaseManager();
        String[] numericMonths = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        String dateQuery = comboBox_year.getSelectedItem().toString() + "-" + numericMonths[comboBox_month.getSelectedIndex()];
        
        ArrayList<ExpensesObject> eoList = edb.getListObject(dateQuery);
        double totalExpenses = 0;
        for(ExpensesObject eo : eoList){
            String[] rowData = {
                eo.getId(),
                eo.getDate(),
                eo.getParticulars(),
                (char)8369 + " " + eo.getAmount(),
                eo.getReason() + (eo.getOtherReason().isBlank() ? "" : ": " + eo.getOtherReason()),
                eo.getCollection_receipt(),
                eo.getReference_number()
            };
            dtm3.addRow(rowData);
            System.out.println(eo.getAmount());
            totalExpenses += Double.parseDouble(eo.getAmount().replace(",", ""));
        }
        if(dtm.getRowCount() > 0)
            expensesTable.setRowSelectionInterval(0, 0);
        expensesTable.setRowHeight(30);
        label_expenses.setText((char)8369 + " " + totalExpenses);    
        resizeColumnWidth(expensesTable);
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
//    private void openDetailsFrame(int num)
//    {
//        RecordDetailsFrame recordFrame = new RecordDetailsFrame();
//        int id = Integer.parseInt(extraIdList2.get(num));
//        recordFrame.openDetailsFrame(this, id, supplierCombo.getSelectedItem().toString(), extraNameList.get(num));
//        
//        recordFrame.setVisible(true);
//        int x = (myFrame.getWidth() - recordFrame.getWidth()) / 2;
//        int y = (myFrame.getHeight() - recordFrame.getHeight()) / 2;
//        recordFrame.setLocation(x,y);
//        setEnabled(false);
//    }
//    private void processTotalAmount()
//    {
//        StockInDatabaseManager inDb = new StockInDatabaseManager();
//        String tot = "";
//        try
//        {
//            tot = inDb.getTotalAmount(goodString(supplierCombo.getSelectedItem().toString()));
//        }catch(Exception e){System.out.println(e);System.exit(0);}
//        records_payValue.setText(tot);
//    }
//    private void Popup(MouseEvent me, int num)
//    {
//        JPopupMenu sample = new JPopupMenu();
//        JMenuItem adjust = new JMenuItem("View Item");
//        adjust.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                openDetailsFrame(num);
//            }
//        });
//        sample.add(adjust);
//        sample.show(me.getComponent(), me.getX(), me.getY());
//    }
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
    public void openRecordsFrame(MainFrame main)
    {
        myFrame = main;
        initComponents();
        createColumns();
        createColumns2();
        createColumns3();
        updateMonthsYears();
        //updateTwoTables();
        listOfSuppliers();
        listOfCustomers();
        processPurchases();
        processSales();
        processExpenses();
//        purchaseTable.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent me)
//            {
//                if(SwingUtilities.isRightMouseButton(me))
//                    Popup(me, purchaseTable.getSelectedRow());
//            }
//        });
        
        setupTable(purchaseTable, Color.WHITE, new Dimension(0,30), Color.black);
        setupTable(salesTable, Color.WHITE, new Dimension(0,30), Color.black);
        
//        processTotalAmount();
        ready = true;
    }
    public void ShowFreakingError(String message)
    {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);System.exit(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_newExpenses;
    private javax.swing.JButton btn_newExpenses1;
    private javax.swing.JComboBox<String> comboBox_customer;
    private javax.swing.JComboBox<String> comboBox_month;
    private javax.swing.JComboBox<String> comboBox_supplier;
    private javax.swing.JComboBox<String> comboBox_year;
    private javax.swing.JTable expensesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel label_expenses;
    private javax.swing.JLabel label_paidSales;
    private javax.swing.JLabel label_purchase;
    private javax.swing.JLabel label_unpaidSales;
    private javax.swing.JTable purchaseTable;
    private javax.swing.JTable salesTable;
    // End of variables declaration//GEN-END:variables
}