package inventorysystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

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
        supplierCombo = new javax.swing.JComboBox<>();

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

        supplierCombo.setBackground(new java.awt.Color(255, 255, 255));
        supplierCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(supplierCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(supplierCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(459, Short.MAX_VALUE)
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
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
        myFrame.setAlwaysOnTop(true);
        myFrame.setAlwaysOnTop(false);
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        myFrame.setEnabled(true);
    }//GEN-LAST:event_formWindowClosed

    private void supplierComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierComboActionPerformed
        if(ready)
        {
            for(int i = purchaseTable.getRowCount(); i > 0; i--)
            {
                dtm.removeRow(i - 1);
                dtm2.removeRow(i - 1);
                itemIdList.clear();
            }
            updateTwoTables();
        }
    }//GEN-LAST:event_supplierComboActionPerformed

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
        dtm.addColumn("Supplier");
        dtm.addColumn("Item");
        dtm.addColumn("Article");
        dtm.addColumn("Brand");
        dtm.addColumn("Cost");
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
        dtm2.addColumn("No.");
        dtm2.addColumn("Client");
        dtm2.addColumn("Date of Sale");
        dtm2.addColumn("Total Price");
        dtm2.addColumn("Sales Status");
        dtm2.addColumn("Payment");
        salesTable.setModel(dtm2);
    }    
    private void updateComboBox()
    {
        ArrayList<String> listOfSupplier = new ArrayList<>();
        listOfSupplier.clear();
        SupplierDatabaseManager supplierDb = new SupplierDatabaseManager();
        try
        {
            supplierDb.processAllData();
        }catch(Exception e){ShowFreakingError(e + " - Error 0045");}
        
        ArrayList<String> suppliers = supplierDb.getNameList();
        supplierCombo.addItem("None");
        for(int i = 0; i < suppliers.size(); i++)
            supplierCombo.addItem(suppliers.get(i));
    }
    private void updateTwoTables()
    {
        JScrollPane scrollerA = jScrollPane2;
        JScrollPane scrollerB = jScrollPane3;
        scrollerA.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollerA.getVerticalScrollBar().setModel(scrollerB.getVerticalScrollBar().getModel());
        
        ItemDatabaseManager itemDb = new ItemDatabaseManager();
        try
        {
            itemDb.getItemsBySupplier(goodString(supplierCombo.getSelectedItem().toString()));
        }catch(Exception e){ShowFreakingError(e + " - Error 0046");}
        
        itemIdList = itemDb.getItemIdList();
        itemNameList = itemDb.getItemNameList();
        ArrayList<String> itemArticleList = itemDb.getItemArticleList();
        ArrayList<String> itemBrandList = itemDb.getItemBrandList();
        ArrayList<Double> itemCostList = itemDb.getItemCostList();
        ArrayList<String> itemSupplierList = itemDb.getItemSupplierList();
        
        extraIdList = new ArrayList<>(itemIdList);
        extraNameList = new ArrayList<>(itemNameList);
        int temp = 0;
        for(int i = 0; i < itemIdList.size(); i++)
        {
            String[] rowData = {
                itemSupplierList.get(i),
                itemNameList.get(i),
                itemArticleList.get(i),
                itemBrandList.get(i),
                (char)8369 + " " + itemCostList.get(i)
            };
            dtm.addRow(rowData);
            int extraRows = findSales(itemSupplierList.get(i), itemNameList.get(i));
            
            String[] emptyData = {};
            for(int j = 1; j < extraRows; j++)
            {
                extraIdList.add(temp, itemIdList.get(i));
                extraNameList.add(temp, itemNameList.get(i));
            }
            for(int j = 1; j < extraRows; j++)
            {
                dtm.addRow(emptyData);
                temp++;
            }
        }
        extraIdList2 = extraIdList;
        if(purchaseTable.getRowCount() >= 1)
        {
            purchaseTable.setRowSelectionInterval(0, 0);
        }
        purchaseTable.setRowHeight(30);
        
        if(salesTable.getRowCount() >= 1)
        {
            salesTable.setRowSelectionInterval(0, 0);
        }
        salesTable.setRowHeight(30);
    }
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
    private void openDetailsFrame(int num)
    {
        RecordDetailsFrame recordFrame = new RecordDetailsFrame();
        int id = Integer.parseInt(extraIdList2.get(num));
        recordFrame.openDetailsFrame(this, id, supplierCombo.getSelectedItem().toString(), extraNameList.get(num));
        
        recordFrame.setVisible(true);
        int x = (myFrame.getWidth() - recordFrame.getWidth()) / 2;
        int y = (myFrame.getHeight() - recordFrame.getHeight()) / 2;
        recordFrame.setLocation(x,y);
        setEnabled(false);
    }
    private void Popup(MouseEvent me, int num)
    {
        JPopupMenu sample = new JPopupMenu();
        JMenuItem adjust = new JMenuItem("View Item");
        adjust.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                openDetailsFrame(num);
            }
        });
        sample.add(adjust);
        sample.show(me.getComponent(), me.getX(), me.getY());
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
    public void openRecordsFrame(MainFrame main)
    {
        myFrame = main;
        initComponents();
        createColumns();
        createColumns2();
        updateComboBox();
        updateTwoTables();
        purchaseTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me)
            {
                if(SwingUtilities.isRightMouseButton(me))
                {
                    Popup(me, purchaseTable.getSelectedRow());
                }
            }
        });
        resizeColumnWidth(purchaseTable);
        resizeColumnWidth(salesTable);
        
        setupTable(purchaseTable, Color.WHITE, new Dimension(0,30), Color.black);
        setupTable(salesTable, Color.WHITE, new Dimension(0,30), Color.black);
        ready = true;
    }
    public void ShowFreakingError(String message)
    {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable purchaseTable;
    private javax.swing.JTable salesTable;
    private javax.swing.JComboBox<String> supplierCombo;
    // End of variables declaration//GEN-END:variables
}