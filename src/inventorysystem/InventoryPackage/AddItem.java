/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem.InventoryPackage;

import inventorysystem.ItemDatabaseManager;
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
public class AddItem extends javax.swing.JFrame {
    
    private StocksConfigurationFrame scf;

    private DefaultTableModel dtm;

    private HashMap<String, ItemObject> addedItemList = new HashMap<>();
    private HashMap<String, ItemObject> itemList = new HashMap<>();
    
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
        table_items = new javax.swing.JTable();
        textField_search = new javax.swing.JTextField();
        button_cancel = new javax.swing.JButton();
        buton_add = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        table_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_items.setFocusable(false);
        table_items.setRequestFocusEnabled(false);
        table_items.setSelectionBackground(new java.awt.Color(177, 0, 0));
        table_items.setSelectionForeground(new java.awt.Color(255, 255, 255));
        table_items.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_items.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_items.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table_items);

        textField_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textField_searchKeyReleased(evt);
            }
        });

        button_cancel.setText("Cancel");
        button_cancel.setFocusable(false);
        button_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelActionPerformed(evt);
            }
        });

        buton_add.setText("Add");
        buton_add.setFocusable(false);
        buton_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buton_add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_cancel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textField_search, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(textField_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_cancel)
                    .addComponent(buton_add))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textField_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_searchKeyReleased
        processItems();
    }//GEN-LAST:event_textField_searchKeyReleased

    private void buton_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_addActionPerformed
        addItem();
    }//GEN-LAST:event_buton_addActionPerformed

    private void button_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_button_cancelActionPerformed

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
        dtm.addColumn("Id");
        dtm.addColumn("Item");
        dtm.addColumn("Article");
        dtm.addColumn("Brand");
        dtm.addColumn("Price");
        table_items.setModel(dtm);
        
        TableColumnModel tcm = table_items.getColumnModel();
        table_items.removeColumn(tcm.getColumn(0));
    }
    private void removeData()
    {
        for(int i = table_items.getRowCount(); i != 0 && table_items.getRowCount() > 0; i--)
            dtm.removeRow(i - 1);
    }
    private void processItems()
    {
        removeData();
        
        ItemDatabaseManager itemDb = new ItemDatabaseManager();
        SystemUtilities su = new SystemUtilities();
        
        try
        {
            itemDb.filterBySearch(textField_search.getText(), "All", "", 1);
        }catch(Exception e){System.out.println(e);}
        
        for(int i = 0; i < itemDb.getItemIdList().size() && !hasAdded(itemDb.getItemIdList().get(i)); i++)
        {
            ItemObject io = new ItemObject();
            io.setId(itemDb.getItemIdList().get(i));
            io.setItem(itemDb.getItemNameList().get(i));
            io.setArticle(itemDb.getItemArticleList().get(i));
            io.setBrand(itemDb.getItemBrandList().get(i));
            io.setPrice(itemDb.getItemPriceList().get(i).toString());
            addData(io);
        }
        su.setSelectionToZero(table_items, true);
    }
    private boolean hasAdded(String id)
    {
        return addedItemList.containsKey(id);
    }
    private void addData(ItemObject io)
    {
        itemList.put(io.getId(), io);
        String[] rowData = {
            io.getId(),
            io.getItem(),
            io.getArticle(),
            io.getBrand(),
            (char)8369 + " " + io.getPrice()
        };
        dtm.addRow(rowData);
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
                            addItem();
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
    private void addItem()
    {
        if(table_items.getRowCount() > 0)
        {
            SystemUtilities su = new SystemUtilities();
            String stocksLeft = su.inputNumberUser("Input Available Stocks");
            if(stocksLeft != null)
            {
                String id = dtm.getValueAt(table_items.getSelectedRow(), 0).toString();
                itemList.get(id).setStocksLeft(Integer.parseInt(stocksLeft));
                scf.addNewItem(itemList.get(id));
                dispose();
            }
        }
    }
    private void setupCommands()
    {
        int property = JComponent.WHEN_IN_FOCUSED_WINDOW;
        //ENTER - ADD ITEM
        getRootPane().registerKeyboardAction(e->{
            addItem();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), property);
        
        //ESCAPE - CANCEL
        getRootPane().registerKeyboardAction(e->{
            dispose();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), property);
    }
    public void openFrame(StocksConfigurationFrame scf, HashMap<String, ItemObject> addedItemList)
    {
        this.addedItemList = addedItemList;
        this.scf = scf;
        initComponents();
        createColumns();
        processItems();
        setupTable();
        setupCommands();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buton_add;
    private javax.swing.JButton button_cancel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_items;
    private javax.swing.JTextField textField_search;
    // End of variables declaration//GEN-END:variables
}
