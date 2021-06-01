package inventorysystem;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class PrinterManager extends javax.swing.JFrame 
{
    
    int globalRowPosition = 0;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        printButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        printPanel = new javax.swing.JPanel();
        LabelLogo = new javax.swing.JLabel();
        LabelLogo5 = new javax.swing.JLabel();
        infoLabel = new javax.swing.JLabel();
        infoLabel1 = new javax.swing.JLabel();
        infoLabel2 = new javax.swing.JLabel();
        infoLabel3 = new javax.swing.JLabel();
        infoLabel4 = new javax.swing.JLabel();
        infoLabel5 = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        LabelLogo6 = new javax.swing.JLabel();
        LabelLogo7 = new javax.swing.JLabel();
        LabelLogo8 = new javax.swing.JLabel();
        LabelLogo9 = new javax.swing.JLabel();
        item1 = new javax.swing.JLabel();
        quantity = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Print Preview");
        setResizable(false);

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
        printPanel.setMaximumSize(new java.awt.Dimension(922, 519));
        printPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelLogo.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        LabelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        printPanel.add(LabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 36, 345, 117));

        LabelLogo5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LabelLogo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLogo5.setText("Product Description");
        printPanel.add(LabelLogo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 242, -1, -1));

        infoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        infoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel.setText("H2-MED ENTERPRISES");
        printPanel.add(infoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 36, -1, -1));

        infoLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel1.setText("Contact Number:");
        printPanel.add(infoLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 59, -1, -1));

        infoLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel2.setText("Address:");
        printPanel.add(infoLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 82, -1, -1));

        infoLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel3.setText("Mail:");
        printPanel.add(infoLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 105, -1, -1));

        infoLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        infoLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel4.setText("Cash/Copy/Etc. Recipt #:");
        printPanel.add(infoLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 36, -1, -1));

        infoLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        infoLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel5.setText("000000000");
        printPanel.add(infoLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(729, 59, -1, -1));

        price.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        price.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        price.setText("Price1");
        printPanel.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 260, -1, -1));

        LabelLogo6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LabelLogo6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLogo6.setText("Product Description");
        printPanel.add(LabelLogo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 242, -1, -1));

        LabelLogo7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LabelLogo7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLogo7.setText("Product Description");
        printPanel.add(LabelLogo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 242, -1, -1));

        LabelLogo8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LabelLogo8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLogo8.setText("Price");
        printPanel.add(LabelLogo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, 150, 20));

        LabelLogo9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LabelLogo9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLogo9.setText("Quantity");
        printPanel.add(LabelLogo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 150, 20));

        item1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        item1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        item1.setText("Item1");
        printPanel.add(item1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 265, 40, -1));

        quantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        quantity.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        quantity.setText("Quantity1");
        printPanel.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, -1, 20));

        jScrollPane1.setViewportView(printPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        print();
    }//GEN-LAST:event_printButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed

    
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
    private void newRow(String itemName, String quanName, String priceName)
    {        
        JLabel newItem = new JLabel(itemName);
        JLabel newQuantity = new JLabel(quanName);
        JLabel newPrice = new JLabel(priceName);
        
        newItem.setFont(new java.awt.Font("Tahoma", 0, 14));
        newQuantity.setFont(new java.awt.Font("Tahoma", 0, 14));
        newPrice.setFont(new java.awt.Font("Tahoma", 0, 14));
        
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                globalRowPosition+=20;
                printPanel.add(newItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, globalRowPosition, -1, -1));
                printPanel.add(newQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, globalRowPosition, -1, -1));
                printPanel.add(newPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, globalRowPosition, -1, -1));
                //printPanel.setPreferredSize(new Dimension(printPanel.getPreferredSize().height + 20, printPanel.getPreferredSize().width));
                printPanel.validate();
                printPanel.repaint();
            }
        });
    }
    public void openPrinterManager(ArrayList<String> itemName, ArrayList<String> itemQuantity, ArrayList<String> itemPrice)
    {
        initComponents();
        LabelLogo.setIcon(getScaledImageIcon("h2med_logo.png", 300, 100));
        setAlwaysOnTop(true);
        
        globalRowPosition = 265;
        
        for(int i = 0; i < itemName.size(); i++)
            newRow(itemName.get(i), itemQuantity.get(i), itemPrice.get(i));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JLabel LabelLogo5;
    private javax.swing.JLabel LabelLogo6;
    private javax.swing.JLabel LabelLogo7;
    private javax.swing.JLabel LabelLogo8;
    private javax.swing.JLabel LabelLogo9;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JLabel infoLabel1;
    private javax.swing.JLabel infoLabel2;
    private javax.swing.JLabel infoLabel3;
    private javax.swing.JLabel infoLabel4;
    private javax.swing.JLabel infoLabel5;
    private javax.swing.JLabel item1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel price;
    private javax.swing.JButton printButton;
    private javax.swing.JPanel printPanel;
    private javax.swing.JLabel quantity;
    // End of variables declaration//GEN-END:variables
}
