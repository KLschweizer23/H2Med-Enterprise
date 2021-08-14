package inventorysystem.InventoryPackage;

import inventorysystem.MainFrame;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import myUtilities.SystemUtilities;

/**
 *
 * @author KL_Schweizer
 */
public class StoreConfigurationFrame extends javax.swing.JFrame {

    private MainFrame mainFrame;
    private InventoryFrame inventoryFrame;
    
    private DefaultTableModel dtm;
    
    private HashMap<String, StoreObject> storeList = new HashMap<>();
    
    private final int rowHeight = 40;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        table_store = new javax.swing.JTable();
        button_configStocks = new javax.swing.JButton();
        button_delete = new javax.swing.JButton();
        button_add = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        table_store.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_store.setSelectionBackground(new java.awt.Color(177, 0, 0));
        table_store.setSelectionForeground(new java.awt.Color(255, 255, 255));
        table_store.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_store.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_store.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table_store);

        button_configStocks.setText("Configure Stocks");
        button_configStocks.setFocusable(false);
        button_configStocks.setRequestFocusEnabled(false);
        button_configStocks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_configStocksActionPerformed(evt);
            }
        });

        button_delete.setText("-");
        button_delete.setFocusable(false);
        button_delete.setRequestFocusEnabled(false);
        button_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_deleteActionPerformed(evt);
            }
        });

        button_add.setText("+");
        button_add.setFocusable(false);
        button_add.setRequestFocusEnabled(false);
        button_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button_configStocks, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_add, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_configStocks)
                    .addComponent(button_delete)
                    .addComponent(button_add))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addActionPerformed
        AddStore as = new AddStore();
        as.openFrame(this, storeList);
        as.setVisible(true);
        int x = (mainFrame.getWidth() - as.getWidth()) / 2;
        int y = (mainFrame.getHeight() - as.getHeight()) / 2;
        as.setLocation(x,y);
    }//GEN-LAST:event_button_addActionPerformed

    private void button_configStocksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_configStocksActionPerformed
        configStocks();
    }//GEN-LAST:event_button_configStocksActionPerformed

    private void configStocks()
    {
        StocksConfigurationFrame scf = new StocksConfigurationFrame();
        
        String id = dtm.getValueAt(table_store.getSelectedRow(), 0).toString();
        
        scf.openFrame(mainFrame, storeList.get(id));
        scf.setVisible(true);
        int x = (mainFrame.getWidth() - scf.getWidth()) / 2;
        int y = (mainFrame.getHeight() - scf.getHeight()) / 2;
        scf.setLocation(x,y);
    }
    
    private void button_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_deleteActionPerformed
        deleteMethod();
    }//GEN-LAST:event_button_deleteActionPerformed
    private void deleteMethod()
    {
        if(table_store.getRowCount() > 0)
        {
            InventoryDatabaseManager inventoryDb = new InventoryDatabaseManager();
            inventoryDb.deleteStore(dtm.getValueAt(table_store.getSelectedRow(), 0).toString(),dtm.getValueAt(table_store.getSelectedRow(), 1).toString());
            processStores();
        }
    }
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
        dtm.addColumn("ID");
        dtm.addColumn("Store");
        table_store.setModel(dtm);
        TableColumnModel tcm = table_store.getColumnModel();
        table_store.removeColumn(tcm.getColumn(0));
    }
    public void addNewStore(StoreObject so)
    {
        InventoryDatabaseManager inventoryDb = new InventoryDatabaseManager();
        inventoryDb.newStore(so.getId() + "_" + so.getName());
        
        processStores();
    }
    private void removeData()
    {
        for(int i = table_store.getRowCount(); i != 0 && table_store.getRowCount() > 0; i--)
            dtm.removeRow(i - 1);
    }
    private void processStores()
    {
        removeData();
        storeList.clear();
        
        InventoryDatabaseManager inventoryDb = new InventoryDatabaseManager();
        SystemUtilities su = new SystemUtilities();
        
        ArrayList<String> tableList = inventoryDb.getTables();
        
        for(int i = 0; i < tableList.size(); i++)
        {
            String id = tableList.get(i).split("_")[0];
            String store = tableList.get(i).split("_")[1];
            
            StoreObject so = new StoreObject();
            so.setId(id);
            so.setName(store);
            
            String[] rowData = {
                id,
                store
            };
            storeList.put(id, so);
            dtm.addRow(rowData);
        }
        su.setSelectionToZero(table_store, true);
        table_store.setRowHeight(rowHeight);
    }    
    private void setupTable()
    {
        SystemUtilities su = new SystemUtilities();
        su.setHoverableTable(table_store);
        table_store.addMouseListener(new MouseListener() {
            private boolean onTable = false;
            
            @Override
            public void mouseClicked(MouseEvent e) {
                if(onTable)
                {
                    Point p = e.getPoint();
                    int y = p.y / rowHeight;
                    if(y < dtm.getRowCount())
                        setStore();
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                onTable = true;
            }
            @Override
            public void mouseExited(MouseEvent e) {
                onTable = false;
            }
        });
    }    
    private void setupCommands()
    {
        int property = JComponent.WHEN_IN_FOCUSED_WINDOW;
        //ENTER - ADD ITEM
        getRootPane().registerKeyboardAction(e->{
            setStore();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), property);
        
        //ESCAPE - CANCEL
        getRootPane().registerKeyboardAction(e->{
            dispose();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), property);
        
        //DELETE - DELETE
        getRootPane().registerKeyboardAction(e->{
            deleteMethod();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), property);
    }
    private void setStore()
    {
        String id = dtm.getValueAt(table_store.getSelectedRow(), 0).toString();
        inventoryFrame.setSelectedStore(storeList.get(id));
        dispose();
    }
    public void openFrame(MainFrame mainFrame, InventoryFrame inventoryFrame)
    {
        this.mainFrame = mainFrame;
        this.inventoryFrame = inventoryFrame;
        initComponents();
        createColumns();
        processStores();
        setupTable();
        setupCommands();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_add;
    private javax.swing.JButton button_configStocks;
    private javax.swing.JButton button_delete;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_store;
    // End of variables declaration//GEN-END:variables
}
