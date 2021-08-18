package inventorysystem.InventoryPackage;

import LoginPackage.LoginDatabaseManager;
import inventorysystem.MainFrame;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import myUtilities.MessageHandler;
import myUtilities.SystemUtilities;

/**
 *
 * @author KL_Schweizer
 */
public class StocksConfigurationFrame extends javax.swing.JFrame {

    private MainFrame mainFrame;
    private StoreObject currentStore = new StoreObject();
    
    private DefaultTableModel dtm;
    
    private HashMap<String, ItemObject> itemList = new HashMap<>();
    
    private final int rowHeight = 30;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_items = new javax.swing.JTable();
        label_currentStore = new javax.swing.JLabel();
        button_delete = new javax.swing.JButton();
        button_add = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Current Store:");
        jLabel1.setFocusable(false);

        table_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_items.setSelectionBackground(new java.awt.Color(177, 0, 0));
        table_items.setSelectionForeground(new java.awt.Color(255, 255, 255));
        table_items.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_items.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_items.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table_items);

        label_currentStore.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label_currentStore.setText("None");
        label_currentStore.setFocusable(false);

        button_delete.setText("-");
        button_delete.setFocusable(false);
        button_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_deleteActionPerformed(evt);
            }
        });

        button_add.setText("+");
        button_add.setFocusable(false);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_currentStore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_delete)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_delete)
                    .addComponent(button_add)
                    .addComponent(jLabel1)
                    .addComponent(label_currentStore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addActionPerformed
        addAction();
    }//GEN-LAST:event_button_addActionPerformed

    private void addAction()
    {
        AddItem ai = new AddItem();
        ai.openFrame(this, itemList);
        ai.setVisible(true);
        int x = (mainFrame.getWidth() - ai.getWidth()) / 2;
        int y = (mainFrame.getHeight() - ai.getHeight()) / 2;
        ai.setLocation(x,y);
    }
    
    private void button_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_deleteActionPerformed
        deleteAction();
    }//GEN-LAST:event_button_deleteActionPerformed
    
    private void deleteAction()
    {
        boolean permissionGranted;
        String adminPass = getPass();
        
        LoginDatabaseManager logDb = new LoginDatabaseManager();
        MessageHandler mh = new MessageHandler();
        
        permissionGranted = adminPass != null ? adminPass.equals(logDb.getAdminPass()) : false;
        
        if(table_items.getRowCount() > 0 && permissionGranted)
        {
            InventoryDatabaseManager inventoryDb = new InventoryDatabaseManager();
            String id = dtm.getValueAt(table_items.getSelectedRow(), 1).toString();
            inventoryDb.deleteItem(currentStore.getId(), currentStore.getName(), itemList.get(id));
            processStocks();
        }
        else if(adminPass == null){}
        else if(!permissionGranted) mh.warning("Wrong admin Password");
    }
    private String getPass()
    {
        String pass = null;
        
        JPanel panel = new JPanel();
        JLabel label = new JLabel("<html>Input Administrator Password<br></html>");
        JPasswordField passField = new JPasswordField(15);
        panel.add(label);
        panel.add(passField);
        String[] options = new String[]{"Confirm", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panel, "Input Admin Password", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
        if(option == 0)
        {
            pass = "";
            char[] password = passField.getPassword();
            for(char c : password)
                pass += c;
        }
        return pass;
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
        dtm.addColumn("I_ID");
        dtm.addColumn("Item");
        dtm.addColumn("Article");
        dtm.addColumn("Brand");
        dtm.addColumn("Price");
        dtm.addColumn("Stocks Left");
        table_items.setModel(dtm);
        
        TableColumnModel tcm = table_items.getColumnModel();
        table_items.removeColumn(tcm.getColumn(0));
        table_items.removeColumn(tcm.getColumn(0));
    }
    
    public void addNewItem(ItemObject io)
    {
        InventoryDatabaseManager inventoryDb = new InventoryDatabaseManager();
        inventoryDb.insertItem(currentStore.getId(), currentStore.getName(), io);
        
        processStocks();
    }
    private void removeData()
    {
        for(int i = table_items.getRowCount(); i != 0 && table_items.getRowCount() > 0; i--)
            dtm.removeRow(i - 1);
    }
    private void processStocks()
    {
        removeData();
        itemList.clear();
        
        
        InventoryDatabaseManager inventoryDb = new InventoryDatabaseManager();
        SystemUtilities su = new SystemUtilities();
        
        HashMap<String, ItemObject> itemHashList = inventoryDb.processData(currentStore.getId(), currentStore.getName(), "");
        
        for(String key : itemHashList.keySet())
        {
            ItemObject io = itemHashList.get(key);
            String[] rowData = {
                io.getId(),
                io.getI_id(),
                io.getItem(),
                io.getArticle(),
                io.getBrand(),
                (char)8369 + " " + io.getPrice(),
                io.getStocksLeft() + ""
            };
            itemList.put(io.getI_id(), io);
            dtm.addRow(rowData);
        }
        su.setSelectionToZero(table_items, true);
        table_items.setRowHeight(rowHeight);
    }
    private void setupTable()
    {
        SystemUtilities su = new SystemUtilities();
        su.setHoverableTable(table_items);
        table_items.addMouseListener(new MouseListener() {
            private boolean onTable = false;
            
            @Override
            public void mouseClicked(MouseEvent e) {
                if(onTable)
                {
                    Point p = e.getPoint();
                    int y = p.y / rowHeight;
                    if(y < dtm.getRowCount())
                    {}//        addItem();
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
            addAction();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), property);
        
        //ESCAPE - CANCEL
        getRootPane().registerKeyboardAction(e->{
            dispose();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), property);
        
        //DELETE - DELETE
        getRootPane().registerKeyboardAction(e->{
            deleteAction();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), property);
    }
    public void openFrame(MainFrame mainFrame, StoreObject so)
    {
        this.mainFrame = mainFrame;
        currentStore = so;
        
        initComponents();
        createColumns();
        processStocks();
        setupTable();
        setupCommands();
        
        label_currentStore.setText(currentStore.getName());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_add;
    private javax.swing.JButton button_delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_currentStore;
    private javax.swing.JTable table_items;
    // End of variables declaration//GEN-END:variables
}
