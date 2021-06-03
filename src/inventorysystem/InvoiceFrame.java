package inventorysystem;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class InvoiceFrame extends javax.swing.JFrame {

    MainFrame myFrame;
    InvoiceDatabaseManager invoiceDatabaseManager;
    
    DefaultTableModel dtm;
    
    ArrayList<Integer> invoiceIdList;
    ArrayList<Integer> invoiceNumberList;
    ArrayList<String> itemList;
    ArrayList<Double> costList;
    ArrayList<Double> priceList;
    ArrayList<Double> quantityList;
    ArrayList<String> addressList;
    ArrayList<Double> paidList;
    ArrayList<String> invoiceDateList;
    ArrayList<Integer> invoiceStatusList;
    ArrayList<Integer> deliveryNumberList;
    ArrayList<Integer> purchaseNumberList;
    ArrayList<String> chequeNumberList;
    ArrayList<String> dueDateList;
    ArrayList<Integer> collection;
    
    ArrayList<Integer> distinctInvoiceNumberList;
    ArrayList<Integer> invoiceNumberLocations = new ArrayList<>();
    
    private int MODE_PROCESS = 0;
    private int MODE_FILTER_CATEGORY = 1;
    private int MODE_FILTER_SEARCH = 2;
    
    boolean ready = false;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        invoice_addressCombo = new javax.swing.JComboBox<>();
        invoice_filter = new javax.swing.JTextField();
        labelItem = new javax.swing.JLabel();
        labelItem1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        invoice_paid = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        invoice_outstanding = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setText("Invoices");

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
        jScrollPane1.setViewportView(invoiceTable);

        invoice_addressCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoice_addressComboActionPerformed(evt);
            }
        });

        invoice_filter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                invoice_filterKeyReleased(evt);
            }
        });

        labelItem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem.setText("Invoice #:");

        labelItem1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelItem1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelItem1.setText("Client");

        invoice_paid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        invoice_paid.setForeground(new java.awt.Color(51, 153, 0));
        invoice_paid.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        invoice_paid.setText("0.00");

        jLabel15.setForeground(new java.awt.Color(0, 204, 0));
        jLabel15.setText("Paid");

        invoice_outstanding.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        invoice_outstanding.setForeground(new java.awt.Color(0, 0, 0));
        invoice_outstanding.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        invoice_outstanding.setText("0.00");

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Outstanding");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(invoice_outstanding))
                    .addComponent(jLabel17))
                .addGap(91, 91, 91)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(invoice_paid)))
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoice_outstanding)
                    .addComponent(invoice_paid))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(labelItem, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invoice_filter, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invoice_addressCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(invoice_filter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelItem)
                            .addComponent(invoice_addressCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelItem1)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void invoice_addressComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoice_addressComboActionPerformed
        if(ready)
        {
            try
            {
                String address = invoice_addressCombo.getItemCount() < 1 ? "" : invoice_addressCombo.getSelectedItem().toString();
                updateTableData(MODE_FILTER_SEARCH, invoice_filter.getText(), address);
            }catch(Exception e){ShowFreakingError(e + " - Error 0030");}
        }
    }//GEN-LAST:event_invoice_addressComboActionPerformed

    private void invoice_filterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invoice_filterKeyReleased
        String keyword = invoice_filter.getText();
        try
        {
            String address = invoice_addressCombo.getItemCount() < 1 ? "" : invoice_addressCombo.getSelectedItem().toString();
            updateTableData(MODE_FILTER_SEARCH, keyword, address);
        }catch(Exception e){ShowFreakingError(e + " - Error 0031");}
    }//GEN-LAST:event_invoice_filterKeyReleased
    private String goodString(String data)
    {
        String temp = data.replaceAll("'", "\\\\'");
        return temp;
    }
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        myFrame.setEnabled(true);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        myFrame.setAlwaysOnTop(true);
        myFrame.setAlwaysOnTop(false);
    }//GEN-LAST:event_formWindowClosing

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(ready)
        {
            String keyword = invoice_filter.getText();
            try
            {
                String address = invoice_addressCombo.getItemCount() < 1 ? "" : invoice_addressCombo.getSelectedItem().toString();
                updateTableData(MODE_FILTER_SEARCH, keyword, address);
            }catch(Exception e){ShowFreakingError(e + " - Error 0032");}
        }
    }//GEN-LAST:event_formWindowGainedFocus
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
        dtm.addColumn("CR #");
        dtm.addColumn("Invoice #");
        dtm.addColumn("Delivery #");
        dtm.addColumn("Purchase #");
        dtm.addColumn("Issue Date");
        dtm.addColumn("Days Old");
        dtm.addColumn("Client");
        dtm.addColumn("Payment Method");
        dtm.addColumn("Total");
        dtm.addColumn("Paid");
        dtm.addColumn("Due Date");
        dtm.addColumn("Status");
    }
    private void updateComboBox()
    {
        ArrayList<String> listOfAddress = new ArrayList<String>();
        listOfAddress.clear();
        
        BranchDatabaseManager branchDatabaseManager = new BranchDatabaseManager();
        ClientDatabaseManager clientDatabaseManager = new ClientDatabaseManager();
        
        try
        {
            branchDatabaseManager.processAllData();
            clientDatabaseManager.processAllData();
        }catch(Exception e){ShowFreakingError(e + " - Error 0053");}
        
        ArrayList<String> branchNames = branchDatabaseManager.getBranchNameList();
        ArrayList<String> clientNames = clientDatabaseManager.getClientNameList();
        
        for(int i = 0; i < branchNames.size(); i++)
        {
            listOfAddress.add(branchNames.get(i));
        }
        for(int i = 0; i < clientNames.size(); i++)
        {
            listOfAddress.add(clientNames.get(i));
        }
        for(int i = 0; i <listOfAddress.size(); i++)
        {
            invoice_addressCombo.addItem(listOfAddress.get(i));
        }
    }
    public void updateTableData(int mode, String keyword, String address) throws Exception
    {
        invoiceDatabaseManager = new InvoiceDatabaseManager();
        if(mode == MODE_PROCESS)
            invoiceDatabaseManager.processAllData();
        else if(mode==MODE_FILTER_CATEGORY)
            invoiceDatabaseManager.filterByCategory(goodString(address));
        else if(mode==MODE_FILTER_SEARCH)
            invoiceDatabaseManager.filterBySearch(goodString(keyword), goodString(address));
        
        invoiceIdList = invoiceDatabaseManager.getIdList();
        invoiceNumberList = invoiceDatabaseManager.getInvoiceNumberList();
        itemList = invoiceDatabaseManager.getItemsList();
        costList = invoiceDatabaseManager.getCostList();
        priceList = invoiceDatabaseManager.getPriceList();
        quantityList = invoiceDatabaseManager.getQuantityList();
        addressList = invoiceDatabaseManager.getAddressList();
        paidList = invoiceDatabaseManager.getPaidList();
        invoiceDateList = invoiceDatabaseManager.getInvoiceDateList();
        invoiceStatusList = invoiceDatabaseManager.getInvoiceStatusList();
        deliveryNumberList = invoiceDatabaseManager.getDeliveryNumberList();
        purchaseNumberList = invoiceDatabaseManager.getPurchaseNumberList();
        chequeNumberList = invoiceDatabaseManager.getItemChequeList();
        dueDateList = invoiceDatabaseManager.getItemDueDateList();
        collection = invoiceDatabaseManager.getCollection();
        
        invoiceNumberLocations.clear();
        distinctInvoiceNumberList = makeDistinct(invoiceNumberList);
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
        LocalDate now = LocalDate.now();  
        String today = setFormat(dtf.format(now));
        
        dtm.setRowCount(0);
        
        double currentTotalPrice = 0, currentTotalPaid = 0;
        
        for(int i = 0; i < distinctInvoiceNumberList.size(); i++)
        {
            String date = invoiceDateList.get(invoiceNumberLocations.get(i));
            long dayInterval = dayInterval(today, date);
            date = changeDateFormat(date);
            double currentPrice = getTotalPrice(distinctInvoiceNumberList.get(i));
            double currentPaid = paidList.get(invoiceNumberLocations.get(i));
            
            currentTotalPrice += currentPrice;
            currentTotalPaid += currentPaid;
            
            String[] rowData = {collection.get(invoiceNumberLocations.get(i)) + "",
                distinctInvoiceNumberList.get(i) + "", deliveryNumberList.get(invoiceNumberLocations.get(i)) + "", purchaseNumberList.get(invoiceNumberLocations.get(i)) + "",
                date, getDetailedAging(dayInterval) + "", addressList.get(invoiceNumberLocations.get(i)), chequeNumberList.get(i),
                (char)8369 + " " + currentPrice, (char)8369 + " " + currentPaid, dueDateList.get(i),
                getStatus(invoiceStatusList.get(invoiceNumberLocations.get(i)))
            };
            dtm.addRow(rowData);
        }
        invoice_outstanding.setText((char)8369 + " " + (currentTotalPrice - currentTotalPaid) + "");
        invoice_paid.setText((char)8369 + " " + currentTotalPaid + "");
        
        if(invoiceTable.getRowCount() >= 1)
        {
            invoiceTable.setRowSelectionInterval(0, 0);
        }
        invoiceTable.setRowHeight(30);
    }
    private String getDetailedAging(long dayInterval)
    {
        final int year = 365;
        final int month = 31;
        
        String returnDetails = "";
        
        int years = (int)dayInterval / year;
        dayInterval %= year;
        int months = (int)dayInterval / month;
        dayInterval %= month;
        int days = (int)dayInterval;
        
        if(years > 0)
            returnDetails += years + " Years ";
        if(months > 0)
            returnDetails += months + " Months ";
        if(days >= 0)
            returnDetails += days + " Days";
        
        return returnDetails;
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
    private double getTotalPrice(int num)
    {
        double totalPrice = 0;
        for(int i = 0; i < invoiceNumberList.size(); i++)
        {
            if(invoiceNumberList.get(i) == num)
            {
                totalPrice += priceList.get(i) * quantityList.get(i);
            }
        }
        return totalPrice;
    }
    private long dayInterval(String date, String today)
    {
        
        date = date.substring(0, 10);
        today = today.substring(0, 10);
        LocalDate dateBefore = LocalDate.parse(date);
        LocalDate dateAfter = LocalDate.parse(today);
        
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateAfter,dateBefore);
        
        return noOfDaysBetween;
    }
    private String setFormat(String date)
    {
        String returnDate = "";
        String splitDate [] = date.split("/");
        returnDate = splitDate[0] + "-" + splitDate[1] + "-" + splitDate[2];
        return returnDate;
    }
    private String changeDateFormat(String date)
    {
        String [] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        
        date = date.substring(0, 10);
        
        String splitDate[] = date.split("-");
        
        String finalDate = months[Integer.parseInt(splitDate[1]) - 1] + " " + splitDate[2] + ", " + splitDate[0];
        
        return finalDate;
    }
    public ArrayList<Integer> makeDistinct(ArrayList<Integer> list)
    {
        ArrayList<Integer> returnList = new ArrayList<>();
        
        boolean hasExist;
        
        for(int i = 0; i < list.size(); i++)
        {
            hasExist = false;
            for(int j = 0; j < returnList.size(); j++)
            {
                if(returnList.get(j) == list.get(i))
                {
                    hasExist = true;
                    break;
                }
            }
            if(!hasExist)
            {
                invoiceNumberLocations.add(i);
                returnList.add(list.get(i));
            }
        }
        
        return returnList;
    }
    
    private void showRightClickMenu(MouseEvent me, int num)
    {
        JPopupMenu invoiceAction = new JPopupMenu();
        JMenuItem viewInvoice = new JMenuItem("View invoice");
        viewInvoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                viewInvoice(num);
            }
        });
        invoiceAction.add(viewInvoice);
        invoiceAction.show(me.getComponent(), me.getX(), me.getY());
    }
    private void viewInvoice(int num)
    {
        InvoiceDetailsFrame invoiceDetailsFrame = new InvoiceDetailsFrame();
        MainFrame myFrame = new MainFrame();
        
        int selected = invoiceTable.getSelectedRow();
        String totalPrice = invoiceTable.getValueAt(selected, 8).toString().substring(2);
        String totalPaid = invoiceTable.getValueAt(selected, 9).toString().substring(2);
        String status = invoiceTable.getValueAt(selected, 11).toString();
        String client = invoiceTable.getValueAt(selected, 6).toString();
        String date = invoiceTable.getValueAt(selected, 4).toString();
        String delivery = invoiceTable.getValueAt(selected, 2).toString();
        String purchase = invoiceTable.getValueAt(selected, 3).toString();
        int collection = Integer.parseInt(invoiceTable.getValueAt(selected, 0).toString());
        
        String method = invoiceTable.getValueAt(selected, 7).toString();
        String dueDate = invoiceTable.getValueAt(selected, 11).toString();
        
        boolean isCash = method.toLowerCase().charAt(0) == 'c';
         
        invoiceDetailsFrame.openDetailsFrame(this, num, totalPrice, totalPaid, status, client, date, delivery, purchase, isCash, method, dueDate, collection);
        
        invoiceDetailsFrame.setVisible(true);
        int x = (myFrame.getWidth() - invoiceDetailsFrame.getWidth()) / 2;
        int y = (myFrame.getHeight() - invoiceDetailsFrame.getHeight()) / 2;
        invoiceDetailsFrame.setLocation(x,y);
        this.setEnabled(false);
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
    public void openInvoiceFrame(MainFrame main)
    {
        myFrame = main;
        initComponents();
        createColumns();
        updateComboBox();
        try
        {
            String address = invoice_addressCombo.getItemCount() < 1 ? "" : invoice_addressCombo.getSelectedItem().toString();
            updateTableData(MODE_PROCESS, invoice_filter.getText(), address);
        }catch(Exception e){ShowFreakingError(e + "- Error 0054");}
        invoiceTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me)
            {
                if(SwingUtilities.isRightMouseButton(me))
                {
                    showRightClickMenu(me, Integer.parseInt(invoiceTable.getValueAt(invoiceTable.getSelectedRow(), 1).toString()));
                }
            }
        });
        resizeColumnWidth(invoiceTable);
        ready = true;
    }
    public void ShowFreakingError(String message)
    {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable invoiceTable;
    private javax.swing.JComboBox<String> invoice_addressCombo;
    private javax.swing.JTextField invoice_filter;
    private javax.swing.JLabel invoice_outstanding;
    private javax.swing.JLabel invoice_paid;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelItem;
    private javax.swing.JLabel labelItem1;
    // End of variables declaration//GEN-END:variables
}
