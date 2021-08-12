/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KL_Schweizer
 */
public class AddStore extends javax.swing.JFrame {

    MainFrame mainFrame;
    
    DefaultTableModel dtm;
    
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
        button_cancelp = new javax.swing.JButton();
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

        button_cancelp.setText("Cancel");

        button_add.setText("Add");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(button_add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_cancelp))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_cancelp)
                    .addComponent(button_add))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
        dtm.addColumn("Client");
        dtm.addColumn("Address");
        dtm.addColumn("Contact #");
        table_store.setModel(dtm);
    }
    public void openFrame(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
        initComponents();
        createColumns();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_add;
    private javax.swing.JButton button_cancelp;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_store;
    // End of variables declaration//GEN-END:variables
}
