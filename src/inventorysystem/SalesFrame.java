package inventorysystem;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class SalesFrame extends javax.swing.JFrame {

    MainFrame myFrame;
    SalesDatabaseManager salesDb = new SalesDatabaseManager();
    
    DefaultTableModel dtm;
    
    private double sales = 0;
    private double capital = 0;
    private double profit = 0;
    private double outstanding = 0;
    
    private double maxValue = 0;
    
    private int counting = 1;
    
    final private int UNPAID = 0;
    final private int OUTSTANDING = 1;
    final private int PAID = 2;
    
    private int properHeight = 0;
    private int properWidth = 0;
    
    ArrayList<Integer> salesIdList = new ArrayList<>();
    ArrayList<Double> totalSalesList = new ArrayList<>();
    ArrayList<Double> totalCostList = new ArrayList<>();
    ArrayList<Double> totalOutstandingList = new ArrayList<>();
    ArrayList<String> transactionDateList = new ArrayList<>();
    ArrayList<Integer> recordModeList = new ArrayList<>();
    ArrayList<String> addressList = new ArrayList<>();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        labelSales = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        labelCapital = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        labelProfit = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        monthCombo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        dayCombo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        yearCombo = new javax.swing.JComboBox<>();
        yearCombo1 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        dayCombo1 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        monthCombo1 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        salesComboBox = new javax.swing.JComboBox<>();
        processButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        transactionTable = new javax.swing.JTable();
        chartPanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        labelOutstanding = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setPreferredSize(new java.awt.Dimension(135, 144));

        labelSales.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelSales.setForeground(new java.awt.Color(255, 255, 255));
        labelSales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSales.setText("0.00");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Sales");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(labelSales))
                    .addComponent(jLabel9))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelSales)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(51, 51, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(135, 144));

        labelCapital.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelCapital.setForeground(new java.awt.Color(255, 255, 255));
        labelCapital.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCapital.setText("0.00");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Capital");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(labelCapital))
                    .addComponent(jLabel12))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCapital)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(0, 204, 0));
        jPanel7.setPreferredSize(new java.awt.Dimension(135, 144));

        labelProfit.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelProfit.setForeground(new java.awt.Color(255, 255, 255));
        labelProfit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelProfit.setText("0.00");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Profit");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(labelProfit))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelProfit)
                .addContainerGap())
        );

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("From:");

        monthCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel10.setText("/");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel11.setText("/");

        yearCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboActionPerformed(evt);
            }
        });

        yearCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearCombo1ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel18.setText("/");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel17.setText("/");

        monthCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthCombo1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("To:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Client:");

        salesComboBox.setBackground(new java.awt.Color(255, 255, 255));
        salesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesComboBoxActionPerformed(evt);
            }
        });

        processButton.setText("Process");
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        transactionTable.setBackground(new java.awt.Color(255, 252, 237));
        transactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            }, new String[]
            {

            }
        ));
        transactionTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        transactionTable.setSelectionBackground(new java.awt.Color(177, 0, 0));
        transactionTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        transactionTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(transactionTable);

        javax.swing.GroupLayout chartPanelLayout = new javax.swing.GroupLayout(chartPanel);
        chartPanel.setLayout(chartPanelLayout);
        chartPanelLayout.setHorizontalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1075, Short.MAX_VALUE)
        );
        chartPanelLayout.setVerticalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 293, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setPreferredSize(new java.awt.Dimension(135, 144));

        labelOutstanding.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelOutstanding.setForeground(new java.awt.Color(255, 255, 255));
        labelOutstanding.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelOutstanding.setText("0.00");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Outstanding");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(labelOutstanding))
                    .addComponent(jLabel19))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelOutstanding)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(monthCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dayCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yearCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(salesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(processButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(dayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(salesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(processButton))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(monthCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17)
                                .addComponent(dayCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18)
                                .addComponent(yearCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14))
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1099, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
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

    private void yearCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearCombo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearCombo1ActionPerformed

    private void monthCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthCombo1ActionPerformed
        updateDate2(dayCombo1, yearCombo1, monthCombo1.getSelectedIndex());
    }//GEN-LAST:event_monthCombo1ActionPerformed

    private void yearComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearComboActionPerformed

    private void monthComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthComboActionPerformed
        updateDate2(dayCombo, yearCombo, monthCombo.getSelectedIndex());
    }//GEN-LAST:event_monthComboActionPerformed

    private void salesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesComboBoxActionPerformed

    }//GEN-LAST:event_salesComboBoxActionPerformed

    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed
        if(monthCombo.getSelectedIndex() == 0 || monthCombo1.getSelectedIndex() == 0)
        {
            JOptionPane.showMessageDialog(null, "Date/s are not available", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            counting = 1;

            transactionTable.removeAll();

            for(int i = dtm.getRowCount(); i > 0; i--)
            {
                dtm.removeRow(i - 1);
            }

            salesIdList.clear();
            totalSalesList.clear();
            totalCostList.clear();
            totalOutstandingList.clear();
            transactionDateList.clear();
            recordModeList.clear();
            addressList.clear();

            processGraph();
            //processInformation();
            displayStatus();
        }
    }//GEN-LAST:event_processButtonActionPerformed
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
        }catch(Exception e){ShowFreakingError(e + "");}
        
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
        salesComboBox.addItem("All");
        for(int i = 0; i <listOfAddress.size(); i++)
        {
            salesComboBox.addItem(listOfAddress.get(i));
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
        transactionTable.setModel(dtm);
        dtm.addColumn("No.");
        dtm.addColumn("Transaction");
        dtm.addColumn("Amount");
    }
    private String setAcceptableFormat(String date)
    {
        String splitDate[] = date.split("-");
        
        String year = splitDate[0];
        String month = splitDate[1].length() == 1 ? "0" + splitDate[1] : splitDate[1];
        String day = splitDate[2].length() == 1 ? "0" + splitDate[2] : splitDate[2];
        
        String newDate = year + "-" + month + "-" + day;
        return newDate;
    }
    private boolean isWithinDateRange(String dateValue, String fromDate, String toDate)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        dateValue = dateValue.length() > 10 ? dateValue.substring(0,10): dateValue;
        fromDate = setAcceptableFormat(fromDate.length() > 10 ? fromDate.substring(0,10) : fromDate);
        toDate = setAcceptableFormat(toDate.length() > 10 ? toDate.substring(0,10) : toDate);
        
        LocalDate currentDate = LocalDate.parse(dateValue, dtf);
        LocalDate from = LocalDate.parse(fromDate, dtf);
        LocalDate to = LocalDate.parse(toDate, dtf);
        
        if(currentDate.compareTo(from) >= 0 && currentDate.compareTo(to) <= 0)
            return true;
        else
            return false;
    }
    private void processLists(int _mode, String address)
    {
        try
        {
            salesDb.getDataByMode(_mode, goodString(address));
        }catch(Exception e){ShowFreakingError(e + "");};
        salesIdList = salesDb.getSalesIdList();
        totalSalesList = salesDb.getTotalSalesList();
        totalCostList = salesDb.getTotalCostList();
        totalOutstandingList = salesDb.getOutstandingList();
        transactionDateList = salesDb.getTransactionDateList();
        for(int i = 0; i < transactionDateList.size(); i++)
        {
            transactionDateList.set(i, transactionDateList.get(i).substring(0, 10));
        }
        recordModeList = salesDb.getRecordModeList();
        addressList = salesDb.getAddressList();
    }
    private String goodString(String data)
    {
        String temp = data.replaceAll("'", "\\\\'");
        return temp;
    }
//    private void processInformation()
//    {
//        String address = salesComboBox.getSelectedItem().toString();
//        processLists(UNPAID, address);
//        processCosts();
//        processLists(PAID, address);
//        processSales();        
//        if(transactionTable.getRowCount() >= 1)
//            transactionTable.setRowSelectionInterval(0, 0);
//        transactionTable.setRowHeight(30);
//    }
//    private void processSales()
//    {
//        ArrayList<Double> outstandings = new ArrayList<>();
//        String fromDate = yearCombo.getSelectedItem() + "-" + monthCombo.getSelectedIndex() + "-" + dayCombo.getSelectedItem();
//        String toDate = yearCombo1.getSelectedItem() + "-" + monthCombo1.getSelectedIndex() + "-" + dayCombo1.getSelectedItem();
//        for(int i = 0; i < totalSalesList.size(); i++)
//        {
//            if(isWithinDateRange(transactionDateList.get(i), fromDate, toDate))
//            {
//                if(totalOutstandingList.get(i) == 0)
//                    sales += totalSalesList.get(i);
//                else
//                {
//                    sales += totalSalesList.get(i);
//                    outstandings.add(totalOutstandingList.get(i));
//                }
//                String[] rowData = {counting++ + "", "Payment",totalSalesList.get(i) + ""};
//                dtm.addRow(rowData);
//            }
//
//        }
//        processOutstanding(outstandings);
//    }
//    private void processOutstanding(ArrayList<Double> partialOutstandings)
//    {
//        processLists(OUTSTANDING, salesComboBox.getSelectedItem().toString());
//        String fromDate = yearCombo.getSelectedItem() + "-" + monthCombo.getSelectedIndex() + "-" + dayCombo.getSelectedItem();
//        String toDate = yearCombo1.getSelectedItem() + "-" + monthCombo1.getSelectedIndex() + "-" + dayCombo1.getSelectedItem();
//        for(int i = 0; i < totalOutstandingList.size(); i++)
//        {
//            if(isWithinDateRange(transactionDateList.get(i), fromDate, toDate))
//            {
//                outstanding += totalOutstandingList.get(i);
//                String[] rowData = {counting++ + "", "Outstanding",totalOutstandingList.get(i) + ""};
//                dtm.addRow(rowData);
//            }
//        }
//        for(int i = 0; i < partialOutstandings.size(); i++)
//        {
//            outstanding += partialOutstandings.get(i);
//        }
//    }
//    private void processCosts()
//    {
//        String fromDate = yearCombo.getSelectedItem() + "-" + monthCombo.getSelectedIndex() + "-" + dayCombo.getSelectedItem();
//        String toDate = yearCombo1.getSelectedItem() + "-" + monthCombo1.getSelectedIndex() + "-" + dayCombo1.getSelectedItem();
//        for(int i = 0; i < totalCostList.size(); i++)
//        {
//            if(isWithinDateRange(transactionDateList.get(i), fromDate, toDate))
//            {
//                capital += totalCostList.get(i);
//                String[] rowData = {counting++ + "", "Stock-in",totalCostList.get(i) + ""};
//                dtm.addRow(rowData);
//            }
//        }
//    }
    private void displayStatus()
    {
        labelSales.setText((char)8369 + " " + sales);
        labelCapital.setText((char)8369 + " " + capital);
        profit = sales - capital;
        labelProfit.setText((char)8369 + " " + profit);
        labelOutstanding.setText((char)8369 + " " + outstanding);
    }
    private void updateDate(JComboBox monthCombo, JComboBox dayCombo, JComboBox yearCombo, int selectedMonth)
    {
        String[] month = {"None", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for(int i = 0; i < month.length; i++)
            monthCombo.addItem(month[i]);
        if(selectedMonth == 0)
        {
            dayCombo.addItem("None");
            yearCombo.addItem("None");
        }
        else
        {
            monthCombo.setSelectedIndex(selectedMonth);
            updateDate2(dayCombo, yearCombo, selectedMonth);
        }
    }
    private void updateDate2(JComboBox dayCombo, JComboBox yearCombo, int selectedMonth)
    {
        yearCombo.removeAllItems();
        dayCombo.removeAllItems();
        
        int days[] = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year[] = {2015,2016,2017,2018,2019,2020,2021,2022,2023,2024,2025,2026,2027,2028,2029,2030,2031,2032,2033,2034,2035,2036,2037,2038,2039,2040};
        
        for(int i = 0; i < days[selectedMonth]; i++)
        {
            dayCombo.addItem(i + 1);
        }
        if(selectedMonth != 0)
        {
            for(int i = 0; i < year.length; i++)
                yearCombo.addItem(year[i] + "");
        }
    }
    private void setDate()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
        LocalDateTime now = LocalDateTime.now();  
        String date = dtf.format(now);
        int selectedYear = Integer.parseInt(date.split("/")[0]);
        int selectedMonth = Integer.parseInt(date.split("/")[1]);
        int selectedDay = Integer.parseInt(date.split("/")[2]);
        updateDate(monthCombo1, dayCombo1, yearCombo1, selectedMonth);
        dayCombo1.setSelectedIndex(selectedDay - 1);
        yearCombo1.setSelectedItem(selectedYear + "");
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
    private HashMap<String, double[]> getSalesThisYear()
    {
        HashMap<String, double[]> allSales = new HashMap<>();
        
        String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int fromYear = Integer.parseInt(yearCombo.getSelectedItem().toString());
        
        ArrayList<Double> costList = new ArrayList<>();
        ArrayList<Double> salesList = new ArrayList<>();
        ArrayList<Double> profitList = new ArrayList<>();
        ArrayList<Double> outstandingList = new ArrayList<>();
        
        StockInDatabaseManager sDb = new StockInDatabaseManager();
        InvoiceDatabaseManager iDb = new InvoiceDatabaseManager();
        
        maxValue = capital = sales = profit = outstanding = 0;
        
        for(int i = 0; i < months.length; i++)
        {
            double costOfMonth = sDb.getCostByMonth(fromYear, i+1);
            double salesOfMonth = iDb.getSalesByMonth(fromYear, i+1);
            double profitOfMonth = salesOfMonth - costOfMonth;
            double outstandingOfMonth = iDb.getOutstandingsByMonth(fromYear, i+1);
            
            if(costOfMonth > maxValue) 
                maxValue = costOfMonth;
            if(salesOfMonth > maxValue) 
                maxValue = salesOfMonth;
            if(outstandingOfMonth > maxValue) 
                maxValue = outstandingOfMonth;
            
            capital += costOfMonth;
            sales += salesOfMonth;
            profit += profitOfMonth;
            outstanding += outstandingOfMonth;
            
            costList.add(costOfMonth);
            salesList.add(salesOfMonth);
            profitList.add(profitOfMonth < 0 ? 0 : profitOfMonth);
            outstandingList.add(outstandingOfMonth);
        }
        for(int i = 0; i < months.length; i++)
        {
            double[] data = {profitList.get(i), salesList.get(i), costList.get(i), outstandingList.get(i)};
            allSales.put(months[i], data);
        }
        displayStatus();
        return allSales;
    }
    public void processGraph()
    {
        Runnable r = () ->
        {
            chartPanel.removeAll();
            HashMap<String, double[]> map = getSalesThisYear();
            
            MonthlyBarGraph mbg = new MonthlyBarGraph("None", maxValue, properHeight, properWidth);
            
            String[] barNames = {"simp1", "simp2", "simp3", "simp4"};
            Color[] colorPerBar = {Color.green, Color.RED, Color.blue, Color.gray};

            mbg.setMultipleBars(4, barNames, colorPerBar);
            
            mbg.generateMultiBars(map);
            chartPanel.add(mbg);
            javax.swing.GroupLayout chartPanelLayout = new javax.swing.GroupLayout(chartPanel);
            chartPanel.setLayout(chartPanelLayout);
            chartPanelLayout.setHorizontalGroup(
                chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(chartPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mbg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            chartPanelLayout.setVerticalGroup(
                chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(chartPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mbg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
        };
        SwingUtilities.invokeLater(r);
    }
    public void openFrame(MainFrame main)
    {
        myFrame = main;
        initComponents();
        processGraph();
        updateComboBox();
        createColumns();
        updateDate(monthCombo, dayCombo, yearCombo, 1);
        setDate();
//        progress1.setOrientation(JProgressBar.HORIZONTAL);
//        progress1.setValue(100);
//        processInformation();
        resizeColumnWidth(transactionTable);
        setupTable(transactionTable, Color.white, new Dimension(0,30), Color.black);
        properHeight = (int)chartPanel.getPreferredSize().getHeight();
        properWidth = (int)chartPanel.getPreferredSize().getWidth();
    }
    public void ShowFreakingError(String message)
    {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chartPanel;
    private javax.swing.JComboBox<String> dayCombo;
    private javax.swing.JComboBox<String> dayCombo1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCapital;
    private javax.swing.JLabel labelOutstanding;
    private javax.swing.JLabel labelProfit;
    private javax.swing.JLabel labelSales;
    private javax.swing.JComboBox<String> monthCombo;
    private javax.swing.JComboBox<String> monthCombo1;
    private javax.swing.JButton processButton;
    private javax.swing.JComboBox<String> salesComboBox;
    private javax.swing.JTable transactionTable;
    private javax.swing.JComboBox<String> yearCombo;
    private javax.swing.JComboBox<String> yearCombo1;
    // End of variables declaration//GEN-END:variables
}
