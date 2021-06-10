package inventorysystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PrinterManager extends javax.swing.JFrame 
{
    
    DefaultTableModel dtm, dtm2;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        printButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        printPanel = new javax.swing.JPanel();
        LabelLogo = new javax.swing.JLabel();
        infoLabel = new javax.swing.JLabel();
        infoLabel4 = new javax.swing.JLabel();
        infoLabel5 = new javax.swing.JLabel();
        invoiceNum = new javax.swing.JLabel();
        infoLabel10 = new javax.swing.JLabel();
        infoLabel11 = new javax.swing.JLabel();
        purchaseNum = new javax.swing.JLabel();
        infoLabel13 = new javax.swing.JLabel();
        deliveryNum = new javax.swing.JLabel();
        infoLabel15 = new javax.swing.JLabel();
        invoiceDate = new javax.swing.JLabel();
        infoLabel17 = new javax.swing.JLabel();
        infoLabel18 = new javax.swing.JLabel();
        infoLabel19 = new javax.swing.JLabel();
        infoLabel20 = new javax.swing.JLabel();
        infoLabel21 = new javax.swing.JLabel();
        infoLabel22 = new javax.swing.JLabel();
        infoLabel23 = new javax.swing.JLabel();
        infoLabel24 = new javax.swing.JLabel();
        infoLabel25 = new javax.swing.JLabel();
        infoLabel26 = new javax.swing.JLabel();
        infoLabel27 = new javax.swing.JLabel();
        infoLabel28 = new javax.swing.JLabel();
        infoLabel29 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        detailsTable = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        totalTable = new javax.swing.JTable();
        infoLabel6 = new javax.swing.JLabel();
        infoLabel8 = new javax.swing.JLabel();
        infoLabel9 = new javax.swing.JLabel();
        infoLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Print Preview");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setMaximumSize(new java.awt.Dimension(943, 471));

        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        printPanel.setBackground(new java.awt.Color(255, 255, 255));
        printPanel.setMaximumSize(new java.awt.Dimension(953, 1250));
        printPanel.setMinimumSize(new java.awt.Dimension(953, 1250));
        printPanel.setPreferredSize(new java.awt.Dimension(953, 1250));
        printPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelLogo.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        LabelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        printPanel.add(LabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 36, 345, 100));

        infoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        infoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel.setText("H2-MED ENTERPRISES");
        printPanel.add(infoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 36, -1, -1));

        infoLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        infoLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel4.setText("INVOICE");
        printPanel.add(infoLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 200, -1));

        infoLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel5.setText("09071807417/09352920126");
        printPanel.add(infoLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 59, -1, -1));

        invoiceNum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        invoiceNum.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        invoiceNum.setText("000");
        printPanel.add(invoiceNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 60, -1, -1));

        infoLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel10.setText("Invoice Date");
        printPanel.add(infoLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, -1, -1));

        infoLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel11.setText("Purchase Number");
        printPanel.add(infoLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, -1, -1));

        purchaseNum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        purchaseNum.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        purchaseNum.setText("000");
        printPanel.add(purchaseNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 80, -1, -1));

        infoLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel13.setText("Delivery Number");
        printPanel.add(infoLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, -1, -1));

        deliveryNum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deliveryNum.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        deliveryNum.setText("000");
        printPanel.add(deliveryNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, -1, -1));

        infoLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel15.setText("_________________");
        printPanel.add(infoLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1190, -1, -1));

        invoiceDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        invoiceDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        invoiceDate.setText("Jan 1, 2001");
        printPanel.add(invoiceDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 120, -1, -1));

        infoLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel17.setText("Name and Delivery Date");
        printPanel.add(infoLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 1210, -1, -1));

        infoLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel18.setText("Invoiced by:");
        printPanel.add(infoLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1050, -1, -1));

        infoLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel19.setText("_________________");
        printPanel.add(infoLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1080, -1, -1));

        infoLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel20.setText("Approved by:");
        printPanel.add(infoLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1110, -1, -1));

        infoLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel21.setText("___________________________");
        printPanel.add(infoLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 1190, -1, -1));

        infoLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel22.setText("Released by:");
        printPanel.add(infoLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1160, -1, -1));

        infoLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel23.setText("_________________");
        printPanel.add(infoLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1140, -1, -1));

        infoLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel24.setText("RECEIVED BY:");
        printPanel.add(infoLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 1130, -1, -1));

        infoLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel25.setText("Delivered by:");
        printPanel.add(infoLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1130, -1, -1));

        infoLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel26.setText("___________________________");
        printPanel.add(infoLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 1130, -1, -1));

        infoLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel27.setText("Name of Receiver and Date");
        printPanel.add(infoLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 1150, -1, -1));

        infoLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel28.setText("Signature");
        printPanel.add(infoLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 1210, -1, -1));

        infoLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel29.setText("___________________________");
        printPanel.add(infoLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 1190, -1, -1));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(null));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setToolTipText("");
        jScrollPane2.setFocusable(false);
        jScrollPane2.setViewportView(itemTable);

        itemTable.setBackground(new java.awt.Color(255, 255, 255));
        itemTable.setForeground(new java.awt.Color(0, 0, 0));
        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            }, new String[]
            {

            }
        ));
        itemTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        itemTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemTable.setFillsViewportHeight(true);
        itemTable.setFocusable(false);
        itemTable.setGridColor(new java.awt.Color(0, 0, 0));
        itemTable.setMaximumSize(new java.awt.Dimension(500, 500));
        itemTable.setRequestFocusEnabled(false);
        itemTable.setRowSelectionAllowed(false);
        itemTable.setSelectionBackground(new java.awt.Color(177, 0, 0));
        itemTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        itemTable.setShowGrid(false);
        itemTable.setShowVerticalLines(true);
        itemTable.getTableHeader().setReorderingAllowed(false);
        itemTable.setUpdateSelectionOnSort(false);
        itemTable.setVerifyInputWhenFocusTarget(false);
        /*
        jScrollPane2.setViewportView(itemTable);
        */

        printPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 890, 660));

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setBorder(null);

        detailsTable.setBackground(new java.awt.Color(255, 255, 255));
        detailsTable.setForeground(new java.awt.Color(0, 0, 0));
        detailsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        detailsTable.setFillsViewportHeight(true);
        detailsTable.setFocusable(false);
        detailsTable.setGridColor(new java.awt.Color(0, 0, 0));
        detailsTable.setRequestFocusEnabled(false);
        detailsTable.setRowSelectionAllowed(false);
        detailsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        detailsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        detailsTable.setShowGrid(true);
        detailsTable.setUpdateSelectionOnSort(false);
        detailsTable.setVerifyInputWhenFocusTarget(false);
        jScrollPane5.setViewportView(detailsTable);

        printPanel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 890, 80));

        totalTable.setBackground(new java.awt.Color(255, 255, 255));
        totalTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        totalTable.setFillsViewportHeight(true);
        totalTable.setFocusable(false);
        totalTable.setGridColor(new java.awt.Color(0, 0, 0));
        totalTable.setRequestFocusEnabled(false);
        totalTable.setRowSelectionAllowed(false);
        totalTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        totalTable.setShowGrid(false);
        totalTable.setUpdateSelectionOnSort(false);
        totalTable.setVerifyInputWhenFocusTarget(false);
        jScrollPane7.setViewportView(totalTable);

        printPanel.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 950, 450, 30));

        infoLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel6.setText("Prk. 7, Brgy. Ising, Carmen,");
        printPanel.add(infoLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 82, -1, -1));

        infoLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel8.setText("Davao del Norte, 8100");
        printPanel.add(infoLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 102, -1, 20));

        infoLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel9.setText("h2med.lezil@gmail.com");
        printPanel.add(infoLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 122, -1, 20));

        infoLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel12.setText("Invoice Number");
        printPanel.add(infoLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, -1, -1));

        jScrollPane1.setViewportView(printPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        setAlwaysOnTop(false);
        print();
    }//GEN-LAST:event_printButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        setAlwaysOnTop(true);
    }//GEN-LAST:event_formWindowActivated

    private void print()
    {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("Print Stock-in Receipt");
        
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if(pageIndex > 0)
                {
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D graphics2D = (Graphics2D)graphics;
                graphics2D.translate(pageFormat.getImageableX()*2, pageFormat.getImageableY()*2);
                graphics2D.scale(0.6,0.6);
                
                printPanel.paint(graphics);
                
                return Printable.PAGE_EXISTS;
            }
        });
        boolean returningResult = printerJob.printDialog();
        if(returningResult)
        {
            try
            {
                printerJob.print();
            }catch(PrinterException pe)
            {
                JOptionPane.showMessageDialog(this, "Print Error: " + pe);
            }
        }
    }
    private ImageIcon getScaledImageIcon(String imageName, int height, int width)
    {
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/Images/" + imageName)).getImage());
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(height, width, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImage);
        return imageIcon;
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
        itemTable.setModel(dtm);
        dtm.addColumn("Quantity");
        dtm.addColumn("Item");
        dtm.addColumn("Unit Price");
        dtm.addColumn("Amount");
    }
    private void createColumns2(boolean isCash)
    {
        //dtm = (DefaultTableModel) displayTable.getModel();
        dtm2 = new DefaultTableModel(0,0)
        {
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        detailsTable.setModel(dtm2);
        if(isCash)
        {
            dtm2.addColumn("Customer Name");
            dtm2.addColumn("Method of Transaction");
        }
        else
        {
            dtm2.addColumn("Customer Name");
            dtm2.addColumn("Method of Transaction");
            dtm2.addColumn("Cheque Number");
            dtm2.addColumn("Due Date");
        }
    }
    private void prepareDetails(Map<String, String> data)
    {
        invoiceNum.setText(data.get("invoice"));
        purchaseNum.setText(data.get("purchase"));
        deliveryNum.setText(data.get("delivery"));
        invoiceDate.setText(data.get("invoiceDate"));
        
        boolean isCash = data.get("mode").toLowerCase().equals("true");
        createColumns2(isCash);
        if(isCash)
        {
            String [] rowData = {
                data.get("client"), "Cash"
            };
            dtm2.addRow(rowData);
        }
        else
        {
            String [] rowData = {
                data.get("client"),"Post Dated Check", data.get("cheque"), data.get("dueDate")
            };
            dtm2.addRow(rowData);
        }
        detailsTable.setRowHeight(40);
    }
    private void prepareTable(ArrayList<Double> quantityList, ArrayList<String> itemList, ArrayList<String> descriptionList, ArrayList<Double> priceList)
    {
        double total = 0;
        for(int i = 0; i < itemList.size(); i++)
        {
            double currentTotal = quantityList.get(i) * priceList.get(i);
            String [] rowData = {
                quantityList.get(i) + "", itemList.get(i), (char)8369 + " " + priceList.get(i),
                (char)8369 + " " + currentTotal
            };
            dtm.addRow(rowData);
            total += currentTotal;
        }
        itemTable.setRowHeight(20);
        
        DefaultTableModel dtm3 = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        totalTable.setModel(dtm3);
        dtm3.addColumn("Total");
        dtm3.addColumn((char)8369 + " " + total);
    }
    public void openPrinterManager(ArrayList<Double> quantityList, ArrayList<String> itemList, ArrayList<String> descriptionList, ArrayList<Double> priceList, Map<String, String> details)
    {
        initComponents();
        LabelLogo.setIcon(getScaledImageIcon("h2med_logo.png", 300, 100));
        setAlwaysOnTop(true);
        createColumns();
        setupTable(itemTable, Color.white, new Dimension(0, 30), Color.black);
        setupTable(detailsTable, Color.white, new Dimension(0, 30), Color.black);
        setupTable(totalTable, Color.white, new Dimension(0, 30), Color.black);
        prepareTable(quantityList, itemList, descriptionList, priceList);
        prepareDetails(details);
        jScrollPane2.setViewportView(itemTable);
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel deliveryNum;
    private javax.swing.JTable detailsTable;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JLabel infoLabel10;
    private javax.swing.JLabel infoLabel11;
    private javax.swing.JLabel infoLabel12;
    private javax.swing.JLabel infoLabel13;
    private javax.swing.JLabel infoLabel15;
    private javax.swing.JLabel infoLabel17;
    private javax.swing.JLabel infoLabel18;
    private javax.swing.JLabel infoLabel19;
    private javax.swing.JLabel infoLabel20;
    private javax.swing.JLabel infoLabel21;
    private javax.swing.JLabel infoLabel22;
    private javax.swing.JLabel infoLabel23;
    private javax.swing.JLabel infoLabel24;
    private javax.swing.JLabel infoLabel25;
    private javax.swing.JLabel infoLabel26;
    private javax.swing.JLabel infoLabel27;
    private javax.swing.JLabel infoLabel28;
    private javax.swing.JLabel infoLabel29;
    private javax.swing.JLabel infoLabel4;
    private javax.swing.JLabel infoLabel5;
    private javax.swing.JLabel infoLabel6;
    private javax.swing.JLabel infoLabel8;
    private javax.swing.JLabel infoLabel9;
    private javax.swing.JLabel invoiceDate;
    private javax.swing.JLabel invoiceNum;
    private javax.swing.JTable itemTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JButton printButton;
    private javax.swing.JPanel printPanel;
    private javax.swing.JLabel purchaseNum;
    private javax.swing.JTable totalTable;
    // End of variables declaration//GEN-END:variables
}
