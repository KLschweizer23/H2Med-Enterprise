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
    
    DefaultTableModel dtm, dtm2;
    
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
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        salesTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        purchaseTable = new javax.swing.JTable();
        comboBox_month = new javax.swing.JComboBox<>();
        comboBox_year = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        label_purchase = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        label_sales = new javax.swing.JLabel();

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

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Sales");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Purchase");

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

        comboBox_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_monthActionPerformed(evt);
            }
        });

        comboBox_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_yearActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Total Purchases:");

        label_purchase.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_purchase.setText("0.0");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Total Sales:");

        label_sales.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_sales.setText("0.0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(comboBox_month, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBox_year, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_purchase)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_sales)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBox_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(label_purchase)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(label_sales)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(480, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(440, 440, 440))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(210, 210, 210))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
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
        }
    }//GEN-LAST:event_comboBox_monthActionPerformed

    private void comboBox_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_yearActionPerformed
        if(ready){
            processPurchases();
            processSales();
        }
    }//GEN-LAST:event_comboBox_yearActionPerformed

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
        String[] years = {"2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"};
        
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
        String query = "SELECT DISTINCT(INVOICE_NUMBER) as invoiceNumber from invoicetable WHERE INVOICE_DATE LIKE '" + dateQuery + "%' ORDER BY ID DESC;";
        
        HashMap<String, ArrayList> map = df.customReturnQuery(query, new String[]{"invoiceNumber"});
        ArrayList<String> invoiceIdList = map.get("invoiceNumber");
        Thread t = new Thread(() -> {
            double total = 0;
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
                    total += Double.parseDouble(so.getTotalPurchase());
                }
            }
            updateSales(total);
        });
        t.start();
        salesTable.setRowHeight(30);
    }
    private void updatePurchase(double total){
        DecimalFormat df = new DecimalFormat();
        label_purchase.setText((char)8369 + " " + df.format(total));
    }
    private void updateSales(double total){
        DecimalFormat df = new DecimalFormat();
        label_sales.setText((char)8369 + " " + df.format(total));
    }
    private void processPurchases(){
        dtm.setRowCount(0);
        
        DatabaseFunctions df = new DatabaseFunctions();
        
        String[] numericMonths = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        String dateQuery = comboBox_year.getSelectedItem().toString() + "-" + numericMonths[comboBox_month.getSelectedIndex()];
        String query = "SELECT DISTINCT(STOCK_IN_ID) as 'stockID' FROM stockintable WHERE ITEM_DATE_IN LIKE '" + dateQuery + "%' ORDER BY ID DESC;";
        
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
    }
    private SalesObject[] getSalesObject(int invoiceID, String date){
        SalesObject[] sos = new SalesObject[0];
        
        DatabaseFunctions df = new DatabaseFunctions();
        
        String[] keyName = {"date", "customer", "invoiceNumber", "total", "collection"};
        String query = "SELECT INVOICE_DATE as date,  ADDRESS as customer, INVOICE_NUMBER as invoiceNumber, SUM(COST * PRICE) as total, COLLECTION as collection FROM invoicetable WHERE INVOICE_NUMBER = " + invoiceID + " AND INVOICE_DATE LIKE '" + date + "%' GROUP BY ADDRESS;";
        
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
                
                sos[i] = so;
            }
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
//    private void updateTwoTables()
//    {
//        JScrollPane scrollerA = jScrollPane2;
//        JScrollPane scrollerB = jScrollPane3;
//        scrollerA.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
//        scrollerA.getVerticalScrollBar().setModel(scrollerB.getVerticalScrollBar().getModel());
//        
//        ItemDatabaseManager itemDb = new ItemDatabaseManager();
//        try
//        {
//            itemDb.getItemsBySupplier(goodString(supplierCombo.getSelectedItem().toString()));
//        }catch(Exception e){ShowFreakingError(e + " - Error 0046");}
//        
//        itemIdList = itemDb.getItemIdList();
//        itemNameList = itemDb.getItemNameList();
//        ArrayList<String> itemArticleList = itemDb.getItemArticleList();
//        ArrayList<String> itemBrandList = itemDb.getItemBrandList();
//        ArrayList<Double> itemCostList = itemDb.getItemCostList();
//        ArrayList<String> itemSupplierList = itemDb.getItemSupplierList();
//        
//        extraIdList = new ArrayList<>(itemIdList);
//        extraNameList = new ArrayList<>(itemNameList);
//        int temp = 0;
//        for(int i = 0; i < itemIdList.size(); i++)
//        {
//            final String supplier = itemSupplierList.get(i);
//            final String item = itemNameList.get(i);
//            final String article = itemArticleList.get(i);
//            final String brand = itemBrandList.get(i);
//            final String cost = itemCostList.get(i) +"";
//            final String id = itemIdList.get(i);
//            final int extraRows = findSales(supplier, item);
//            final int finalTemp = temp;
//            Thread t = new Thread()
//            {
//                @Override
//                public void run()
//                {
//                    String[] rowData = {
//                        supplier,
//                        item,
//                        article,
//                        brand,
//                        (char)8369 + " " + cost
//                    };
//                    dtm.addRow(rowData);
//
//                    String[] emptyData = {};
//                    for(int j = 1; j < extraRows; j++)
//                    {
//                        extraIdList.add(finalTemp, id);
//                        extraNameList.add(finalTemp, item);
//                    }
//                    for(int j = 1; j < extraRows; j++)
//                        dtm.addRow(emptyData);
//                }
//            };
//            t.start();
//            temp += extraRows;
//            temp++;
//        }
//        extraIdList2 = extraIdList;
//        if(purchaseTable.getRowCount() >= 1)
//        {
//            purchaseTable.setRowSelectionInterval(0, 0);
//        }
//        purchaseTable.setRowHeight(30);
//        
//        if(salesTable.getRowCount() >= 1)
//        {
//            salesTable.setRowSelectionInterval(0, 0);
//        }
//        salesTable.setRowHeight(30);
//    }
    private String goodString(String data)
    {
        String temp = data.replaceAll("'", "\\\\'");
        return temp;
    }
    private int findSales(String _supplier, String _name)
    {
        int count = 0;
        
        InvoiceDatabaseManager invoiceDb = new InvoiceDatabaseManager();
        try
        {
            invoiceDb.getDataBySupplier(goodString(_supplier), goodString(_name));
        }catch(Exception e){ShowFreakingError(e + " - Error 0047");}
        ArrayList<String> clientList = invoiceDb.getAddressList();
        ArrayList<String> dateList = invoiceDb.getInvoiceDateList();
        ArrayList<Double> priceList = invoiceDb.getPriceList();
        ArrayList<Double> quantityList = invoiceDb.getQuantityList();
        ArrayList<Integer> saleStatusList = invoiceDb.getInvoiceStatusList();
        ArrayList<Double> paymentList = invoiceDb.getPaidList();
        
        for(int i = 0; i < invoiceDb.getItemsList().size(); i++)
        {
            double totalPrice = priceList.get(i) * quantityList.get(i);
            String[] rowData = {
                i + 1 + "", clientList.get(i), dateList.get(i).substring(0,10),totalPrice + "", 
                setProperStatus(saleStatusList.get(i)), (char)8369 + " " + paymentList.get(i)
            };
            
            dtm2.addRow(rowData);
            count++;
        }
        if(count == 0)
        {
            String[] rowData = {"- - / - -","- - / - -","- - / - -","- - / - -","- - / - -","- - / - -"};
            dtm2.addRow(rowData);
        }
        return count;
    }
    private String setProperStatus (int status)
    {
        String returnVal = "";
        switch (status) {
            case 0:
                returnVal = "Outstanding";
                break;
            case 1:
                returnVal = "Partial";
                break;
            case 2:
                returnVal = "Paid";
                break;
            default:
                break;
        }
        
        return returnVal;
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
        updateMonthsYears();
        //updateTwoTables();
        processPurchases();
        processSales();
//        purchaseTable.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent me)
//            {
//                if(SwingUtilities.isRightMouseButton(me))
//                    Popup(me, purchaseTable.getSelectedRow());
//            }
//        });
        resizeColumnWidth(purchaseTable);
        resizeColumnWidth(salesTable);
        
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
    private javax.swing.JComboBox<String> comboBox_month;
    private javax.swing.JComboBox<String> comboBox_year;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label_purchase;
    private javax.swing.JLabel label_sales;
    private javax.swing.JTable purchaseTable;
    private javax.swing.JTable salesTable;
    // End of variables declaration//GEN-END:variables
}