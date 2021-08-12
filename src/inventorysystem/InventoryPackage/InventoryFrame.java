package inventorysystem.InventoryPackage;

import inventorysystem.InventoryPackage.StoreConfigurationFrame;
import inventorysystem.MainFrame;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author KL_Schweizer
 */
public class InventoryFrame extends javax.swing.JFrame {

    MainFrame myFrame;
    
    DefaultTableModel dtm;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabParent = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        label_store = new javax.swing.JLabel();
        button_configure = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_stocks = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        textField_search = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tabParent.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabParent.setFocusable(false);
        tabParent.setRequestFocusEnabled(false);

        jPanel1.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Store:");
        jLabel1.setToolTipText("");
        jLabel1.setFocusable(false);
        jLabel1.setRequestFocusEnabled(false);

        label_store.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label_store.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_store.setText("None");
        label_store.setToolTipText("");
        label_store.setFocusable(false);
        label_store.setRequestFocusEnabled(false);

        button_configure.setToolTipText("Configure Store");
        button_configure.setFocusable(false);
        button_configure.setRequestFocusEnabled(false);
        button_configure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_configureActionPerformed(evt);
            }
        });

        table_stocks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_stocks.setSelectionBackground(new java.awt.Color(177, 0, 0));
        table_stocks.setSelectionForeground(new java.awt.Color(255, 255, 255));
        table_stocks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_stocks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_stocks.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table_stocks);

        jButton1.setText("Cancel");
        jButton1.setEnabled(false);
        jButton1.setFocusable(false);
        jButton1.setRequestFocusEnabled(false);

        jButton2.setText("Apply");
        jButton2.setEnabled(false);
        jButton2.setFocusable(false);
        jButton2.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label_store)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button_configure, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(textField_search, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(label_store)
                    .addComponent(button_configure, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(textField_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tabParent.addTab("Manage", jPanel1);

        displayTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        displayTable.setFillsViewportHeight(true);
        displayTable.setGridColor(new java.awt.Color(51, 204, 0));
        displayTable.setMaximumSize(new java.awt.Dimension(3, 3));
        displayTable.setSelectionBackground(new java.awt.Color(204, 0, 0));
        displayTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        displayTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        displayTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(displayTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        tabParent.addTab("Summary", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabParent)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabParent)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_configureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_configureActionPerformed
        StoreConfigurationFrame scf = new StoreConfigurationFrame();
        scf.openFrame(myFrame);
        scf.setVisible(true);
        int x = (myFrame.getWidth() - scf.getWidth()) / 2;
        int y = (myFrame.getHeight() - scf.getHeight()) / 2;
        scf.setLocation(x,y);
    }//GEN-LAST:event_button_configureActionPerformed
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
        dtm.addColumn("Item");
        dtm.addColumn("Article");
        dtm.addColumn("Brand");
        dtm.addColumn("Price");
        dtm.addColumn("Stocks Left");
        dtm.addColumn("Sold Stocks");
        dtm.addColumn("Action");
        table_stocks.setModel(dtm);
    }
    private ImageIcon getScaledImageIcon(String imageName, int height, int width)
    {
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/Images/" + imageName)).getImage());
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(height, width, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImage);
        return imageIcon;
    }
    private void setIcons()
    {
        button_configure.setIcon(getScaledImageIcon("settings_icon.png", 20,20));
        button_configure.setContentAreaFilled(false);
    }
    public void openInventoryFrame(MainFrame mainFrame)
    {
        myFrame = mainFrame;
        initComponents();
        setIcons();
        createColumns();
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_configure;
    private javax.swing.JTable displayTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_store;
    private javax.swing.JTabbedPane tabParent;
    private javax.swing.JTable table_stocks;
    private javax.swing.JTextField textField_search;
    // End of variables declaration//GEN-END:variables
}