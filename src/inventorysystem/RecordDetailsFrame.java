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
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class RecordDetailsFrame extends javax.swing.JFrame {

    RecordsFrame recordsFrame;
    
    private int selectedId;
    
    DefaultTableModel dtm;
    
    ArrayList<String> idList;
    ArrayList<String> itemNameList;
    ArrayList<String> itemCostList ;
    ArrayList<String> itemQuantityList;
    ArrayList<String> transactionMethodList;
    ArrayList<Integer> transactionStatusList;
    ArrayList<String> transactionDueList;
    ArrayList<String> itemDateList;
    ArrayList<Integer> itemTransactionIdList;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        recordTable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        supplierLabel = new javax.swing.JLabel();

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

        recordTable.setBackground(new java.awt.Color(255, 252, 237));
        recordTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            }, new String[]
            {

            }
        ));
        recordTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        recordTable.setSelectionBackground(new java.awt.Color(177, 0, 0));
        recordTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        recordTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(recordTable);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Item Supplier:");
        jLabel12.setToolTipText("");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Item Name:");
        jLabel13.setToolTipText("");

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nameLabel.setText("Item Name:");
        nameLabel.setToolTipText("");

        supplierLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        supplierLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        supplierLabel.setText("Item Name:");
        supplierLabel.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(supplierLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(nameLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(supplierLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        recordsFrame.setAlwaysOnTop(true);
        recordsFrame.setAlwaysOnTop(false);
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        recordsFrame.setEnabled(true);
    }//GEN-LAST:event_formWindowClosed

    private void createColumns()
    {
        //dtm = (DefaultTableModel) displayTable.getModel();
        dtm = new DefaultTableModel(0,0)
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        dtm.addColumn("Transaction method");
        dtm.addColumn("Cheque Number");
        dtm.addColumn("Transaction Date");
        dtm.addColumn("Due Date");
        dtm.addColumn("Total Cost");
        dtm.addColumn("Status");
        recordTable.setModel(dtm);
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
    private void prepareData(String _supplier)
    {
        StockInDatabaseManager stockInDb = new StockInDatabaseManager();
        try
        {
            stockInDb.getDataBySupplierAndItem(goodString(_supplier), selectedId);
        }catch(Exception e){ShowFreakingError(e + " - Error 0043");}
        idList = stockInDb.getIdList();
        itemNameList = stockInDb.getFkItemNameList();
        itemCostList = stockInDb.getItemCostList();
        itemQuantityList = stockInDb.getItemStockInList();
        transactionMethodList = stockInDb.getTransactionMethodList();
        transactionStatusList = stockInDb.getTransactionStatusList();
        transactionDueList = stockInDb.getTransactionDueList();
        itemDateList = stockInDb.getItemDateInList();
        itemTransactionIdList = stockInDb.getTransactionIdList();
        for(int i = 0; i < idList.size(); i++)
        {
            double totalCost = Double.parseDouble(itemCostList.get(i)) * Double.parseDouble(itemQuantityList.get(i));
            String[] rowData = {
                determineMethod(transactionMethodList.get(i)), determineCheque(transactionMethodList.get(i)),itemDateList.get(i).substring(0,10),
                transactionStatusList.get(i) == 0 ? "- - / - -" : transactionDueList.get(i), 
                (char)8369 + " " + totalCost, determineStatus(transactionStatusList.get(i))
            };
            dtm.addRow(rowData);
        }
        if(recordTable.getRowCount() >= 1)
        {
            recordTable.setRowSelectionInterval(0, 0);
        }
        recordTable.setRowHeight(30);
    }
    private String goodString(String data)
    {
        String temp = data.replaceAll("'", "\\\\'");
        return temp;
    }
    private String determineMethod(String method)
    {
        if(method.equals("cash"))
            return "Cash";
        else
            return "Post Date Check";
    }
    private String determineCheque(String data)
    {
        if(data.equals("cash"))
            return "N/A";
        else
            return "# " + data;
    }
    private String determineStatus(int status)
    {
        if(status == 0)
            return "Paid";
        else
            return "Not Paid";
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
    private void processPayment(int num, String supplier)
    {
        if(transactionStatusList.get(num) == 1)
        {
            double totalCost = Double.parseDouble(itemCostList.get(num)) * Double.parseDouble(itemQuantityList.get(num));
            String returnVal = JOptionPane.showInputDialog("Enter Payment:");
            if(returnVal != null)
            {
                if(isANumber(returnVal))
                {
                    double returnValDouble = Double.parseDouble(returnVal);

                    if(totalCost == returnValDouble)
                    {
                        StockInDatabaseManager stockInDb = new StockInDatabaseManager();
                        SalesDatabaseManager salesDb = new SalesDatabaseManager();
                        try
                        {
                            stockInDb.updateTransactionStatus(goodString(supplier), Integer.parseInt(idList.get(num)), 0);
                            salesDb.updateCost(itemTransactionIdList.get(num), totalCost, goodString(supplier));
                        }catch(Exception e){ShowFreakingError(e + " - Error 0044");}
                        for(int i = recordTable.getRowCount(); i > 0; i--)
                            dtm.removeRow(i - 1);
                        prepareData(supplier);
                    }
                    else JOptionPane.showMessageDialog(null, "Payment may be too much or not enough!", "Invalid Payment!", JOptionPane.WARNING_MESSAGE);
                } else JOptionPane.showMessageDialog(null, "Please input a proper value!", "Invalid Payment!", JOptionPane.WARNING_MESSAGE);
            }
        } else JOptionPane.showMessageDialog(null, "Transaction is already paid!", "Inform", JOptionPane.INFORMATION_MESSAGE);
    }
    private void Popup(MouseEvent me, int num, String supplier)
    {
        JPopupMenu sample = new JPopupMenu();
        JMenuItem adjust = new JMenuItem("Pay Transaction");
        adjust.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                processPayment(num, supplier);
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
    public void openDetailsFrame(RecordsFrame rec, int id, String supplier, String name)
    {
        recordsFrame = rec;
        initComponents();
        selectedId = id;
        createColumns();
        prepareData(supplier);
        
        nameLabel.setText(name);
        supplierLabel.setText(supplier);
        
        recordTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me)
            {
                if(SwingUtilities.isRightMouseButton(me))
                {
                    Popup(me, recordTable.getSelectedRow(), supplier);
                }
            }
        });
        resizeColumnWidth(recordTable);
        setupTable(recordTable, Color.white, new Dimension(0,30), Color.black);
    }
    public void ShowFreakingError(String message)
    {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTable recordTable;
    private javax.swing.JLabel supplierLabel;
    // End of variables declaration//GEN-END:variables
}
