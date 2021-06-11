package inventorysystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
/**
 *
 * @author Administrator
 */
public class MainFrame extends javax.swing.JFrame {    
    /**
     * Creates new form MainFrame
     */
    
    //VARIABLES
    private int MODE_PROCESS = 0;
    private int MODE_FILTER_CATEGORY = 1;
    private int MODE_FILTER_SEARCH = 2;
    
    private int MODE_SORT = 0;
    
    ArrayList<String> itemIdList;
    
    //CLASS VARIABLES
    static MainFrame myFrame;
    ItemDatabaseManager itemDatabaseManager = new ItemDatabaseManager();
    
    //UNCOMMON VARIABLES
    DefaultTableModel dtm;
    
    public MainFrame() {
        initComponents();
        
        try
        {
            itemDatabaseManager.getConnection();
        }catch(Exception e){ShowFreakingError(e + " - Error 0001");}
        createColumns();
        updateComboBox();
        changeIcons();
        setupTable(displayTable, Color.white, new Dimension(0,30), Color.black);
        updateStatus();
        try
        {
            updateTableData(MODE_PROCESS, main_searchBar.getText(), jComboBox1.getSelectedItem().toString());
        }catch(Exception e){ShowFreakingError(e + " - Error 0002");}
        resizeColumnWidth(displayTable);
        main_searchBar.requestFocus();
    }
    private void updateStatus()
    {
        sales1.setText("N/A");
        sales2.setText("N/A");
        sales3.setText("N/A");
        invoice1.setText("N/A");
        invoice2.setText("N/A");
        invoice2.setText("N/A");
        outstanding1.setText("N/A");
        outstanding2.setText("N/A");
        outstanding3.setText("N/A");
        least1.setText("N/A");
        least2.setText("N/A");
        least3.setText("N/A");
        most1.setText("N/A");
        most2.setText("N/A");
        most3.setText("N/A");
        
        SystemStatusManager system = new SystemStatusManager();
        
        JLabel[] sales = {sales1, sales2, sales3};
        ArrayList<String> saleData = system.getMostItemSales();
        for(int i = 0; i < saleData.size(); i++)
            sales[i].setText(displayableString(i + 1 + ". " + saleData.get(i)));
        
        JLabel[] invoices = {invoice1, invoice2, invoice3};
        ArrayList<String> longInvoices = system.getLongestInvoices();
        for(int i = 0; i < longInvoices.size(); i++)
            invoices[i].setText(displayableString(i + 1 + ". " + longInvoices.get(i)));
        
        JLabel[] outstandings = {outstanding1, outstanding2, outstanding3};
        ArrayList<String> outstandingData = system.getMostOutstanding();
        for(int i = 0; i < outstandingData.size(); i++)
            outstandings[i].setText(displayableString(i + 1 + ". " + outstandingData.get(i)));
        
        JLabel[] leasts = {least1, least2, least3};
        ArrayList<String> leastsData = system.getItemQuantity(true);
        for(int i = 0; i < leastsData.size(); i++)
            leasts[i].setText(displayableString(i + 1 + ". " + leastsData.get(i)));
        
        JLabel[] mosts = {most1, most2, most3};
        ArrayList<String> mostsData = system.getItemQuantity(false);
        for(int i = 0; i < mostsData.size(); i++)
            mosts[i].setText(displayableString(i + 1 + ". " + mostsData.get(i)));
    }
    private void changeIcons()
    {
        buttonHover(button_main_stockIn, "Stockin_icon.png");
        buttonHover(main_button_stockOutTransfer, "Stockout_icon.png");
        buttonHover(main_button_records, "Record_icon.png");
        buttonHover(main_button_invoices, "Invoices_icon.png");
        buttonHover(main_button_sales, "Sales_icon.png");
        buttonHover(main_button_database, "Database_icon.png");
        jLabel2.setIcon(getScaledImageIcon("filter.png", 20, 20));
        button_main_stockIn.setIcon(getScaledImageIcon("Stockin_icon.png", 30, 30));
        main_button_stockOutTransfer.setIcon(getScaledImageIcon("Stockout_icon.png", 30, 30));
        main_button_records.setIcon(getScaledImageIcon("Record_icon.png", 30, 30));
        main_button_invoices.setIcon(getScaledImageIcon("Invoices_icon.png", 30, 30));
        main_button_sales.setIcon(getScaledImageIcon("Sales_icon.png", 30, 30));
        main_button_database.setIcon(getScaledImageIcon("Database_icon.png", 30, 30));
        logo.setIcon(getScaledImageIcon("h2med_logo.png", 530, 150));
        int w = 150;
        wing.setIcon(getScaledImageIcon("h2med_sidewings.png", (w / 2) + w, w));
        w = 198;
        wing2.setIcon(getScaledImageIcon("h2med_sidewings2.png", (w / 2) + w, w));
        
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png")).getImage());
    }
    private String displayableString(String string)
    {
        int space = getMiddleSpace(string);
        if(string.length() > 50)
            string = "<html> " + string.substring(0, space) + " <br/>" + string.substring(space + 1) + " </html>";
        return string;
    }
    private int getMiddleSpace(String string)
    {
        ArrayList<Integer> spaces = new ArrayList<>();
        for(int i = 0; i < string.length(); i++)
        {
            if(string.charAt(i) == ' ')
                spaces.add(i);
        }
        
        return spaces.size() % 2 == 0 ? spaces.get((spaces.size() / 2) + 1) : spaces.get((spaces.size() / 2));
    }
    private void buttonHover(JButton button, String icon)
    {
        button.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();
                iterate(button, model.isRollover(), icon);
            }
        });
    }
    private void iterate(JButton button, boolean hover, String icon)
    {
        Thread t = new Thread()
        {
            public void run()
            {
                int r_color = 0;
                int g_color = 57;
                int b_color = 191;
                
                int r = button.getBackground().getRed();
                int g = button.getBackground().getGreen();
                int b = button.getBackground().getBlue();
                
                int r_goal = hover ? r_color : 255;
                int g_goal = hover ? g_color : 255;
                int b_goal = hover ? b_color : 255;
                
                int counts = 10;
                
                int r_step = (r - r_goal) / counts;
                int g_step = (g - g_goal) / counts;
                int b_step = (b - b_goal) / counts;
                
                if(hover)
                    button.setIcon(getScaledImageIcon("2" + icon, 30, 30));
                else
                    button.setIcon(getScaledImageIcon(icon, 30, 30));
                
                while(counts > 0)
                {
                    r -= r_step;
                    g -= g_step;
                    b -= b_step;
                    
                    final int _r = r;
                    final int _g = g;
                    final int _b = b;
                    
                    SwingUtilities.invokeLater(new Runnable()
                    {
                        public void run()
                        {
                            button.setBackground(new Color(_r,_g,_b));
                            button.setForeground(hover ? Color.white : Color.black);
                        }
                    });
                    try
                    {
                        Thread.sleep(20);
                    }catch(InterruptedException e){}
                    counts--;
                }
            }
        };
        t.start();                                                                               
    }
    private void updateComboBox()
    {
        ArrayList<String> listOfCat = new ArrayList<>();
        listOfCat.add("All");
        listOfCat.add("Medicine");
        listOfCat.add("Medical Supplies");
        listOfCat.add("Office Supplies");
        listOfCat.add("Janitorial Supplies");
        listOfCat.add("General Merchandise");
        listOfCat.add("Foods");
        listOfCat.add("Laboratory Supplies");
        for(int i = 0; i <listOfCat.size(); i++)
        {
            jComboBox1.addItem(listOfCat.get(i));
        }
    }
    private void createColumns()
    {
        dtm = new DefaultTableModel(0,0)
        {
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        displayTable.setModel(dtm);
        dtm.addColumn("Rank");
        dtm.addColumn("Item Name");
        dtm.addColumn("Article");
        dtm.addColumn("Brand");
        dtm.addColumn("Supplier");
        dtm.addColumn("Price");
        dtm.addColumn("Quantity");
        dtm.addColumn("Category");
        dtm.addColumn("Rate per week");
    }
    public void updateTableData(int mode, String keyword, String category) throws Exception
    {
        itemDatabaseManager = new ItemDatabaseManager();

        if(mode == MODE_PROCESS)
            itemDatabaseManager.processAllData(MODE_SORT);
        else if(mode == MODE_FILTER_CATEGORY)
            itemDatabaseManager.filterByCategory(goodString(jComboBox1.getSelectedItem().toString()), null, MODE_SORT);
        else if(mode == MODE_FILTER_SEARCH)
            itemDatabaseManager.filterBySearch(goodString(keyword), goodString(category), null, MODE_SORT);

        itemIdList = itemDatabaseManager.getItemIdList();
        ArrayList<String> itemNameList = itemDatabaseManager.getItemNameList();
        ArrayList<String> itemCategoryList = itemDatabaseManager.getItemCategoryList();
        ArrayList<Double> itemQuantityList = itemDatabaseManager.getItemQuantityList();
        ArrayList<Double> itemPriceList = itemDatabaseManager.getItemPriceList();
        ArrayList<Double> itemStockOutList = itemDatabaseManager.getItemStockOutList();
        ArrayList<String> itemArticleList = itemDatabaseManager.getItemArticleList();
        ArrayList<String> itemBrandList = itemDatabaseManager.getItemBrandList();
        ArrayList<String> itemSupplierList = itemDatabaseManager.getItemSupplierList();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
        LocalDateTime now = LocalDateTime.now();  
        String date = setFormat(dtf.format(now));
        
        dtm.setRowCount(0);
        
        TimeDatabaseManager timeDatabaseManager = new TimeDatabaseManager();
        
        for(int i = 0; i < itemIdList.size(); i++)
        {
            double stockRate = itemStockOutList.get(i)/timeDatabaseManager.getDayInterval(date);
            
            stockRate *= 7;
            
            String [] rowData = {
                i + 1 + "", itemNameList.get(i), itemArticleList.get(i), itemBrandList.get(i), itemSupplierList.get(i),(char)8369 + " " + itemPriceList.get(i).toString(),
                itemQuantityList.get(i)+"", itemCategoryList.get(i),(int)stockRate + " per week"
            };
            dtm.addRow(rowData);
        }
        if(displayTable.getRowCount() >= 1)
        {
            displayTable.setRowSelectionInterval(0, 0);
        }
        displayTable.setRowHeight(30);
    }
    private String goodString(String data)
    {
        String temp = data.replaceAll("'", "\\\\'");
        return temp;
    }
    private String setFormat(String date)
    {
        String returnDate = "";
        String splitDate [] = date.split("/");
        returnDate = splitDate[0] + "-" + splitDate[1] + "-" + splitDate[2];
        return returnDate;
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
    //CLASSES
    class backPanelGradient extends JPanel
    {
        protected void paintComponent(Graphics g)
        {
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();
            
            Color color1 = new Color(65, 183, 252);
            Color color2 = new Color(12, 96, 145);
            GradientPaint gp = new GradientPaint(0,0,color1,width,height,color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);
        }
    }
    class buttonPanelGradient extends JPanel
    {
        @Override
        protected void paintComponent(Graphics g)
        {
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();
            
            Color color2 = new Color(0, 51, 255);
            Color color1 = new Color(102, 102, 255);
            GradientPaint gp = new GradientPaint(width/2,0,color1,width/2,height,color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new backPanelGradient();
        jPanel2 = new javax.swing.JPanel();
        button_main_stockIn = new javax.swing.JButton();
        main_button_stockOutTransfer = new javax.swing.JButton();
        main_button_records = new javax.swing.JButton();
        main_button_database = new javax.swing.JButton();
        main_button_invoices = new javax.swing.JButton();
        main_button_sales = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        wing = new javax.swing.JLabel();
        wing2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        sales1 = new javax.swing.JLabel();
        sales2 = new javax.swing.JLabel();
        sales3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        outstanding3 = new javax.swing.JLabel();
        outstanding1 = new javax.swing.JLabel();
        outstanding2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        least1 = new javax.swing.JLabel();
        least2 = new javax.swing.JLabel();
        least3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        most1 = new javax.swing.JLabel();
        most2 = new javax.swing.JLabel();
        most3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        invoice3 = new javax.swing.JLabel();
        invoice1 = new javax.swing.JLabel();
        invoice2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        main_searchBar = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("H2Med Enterprise Software");
        setBackground(new java.awt.Color(153, 153, 153));
        setBounds(new java.awt.Rectangle(0, 0, 1366, 768));
        setResizable(false);
        setSize(getWidth(), getHeight());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setMinimumSize(new java.awt.Dimension(1366, 768));
        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                jPanel1AncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        button_main_stockIn.setBackground(new java.awt.Color(255, 255, 255));
        button_main_stockIn.setText("Stock In");
        button_main_stockIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_main_stockInActionPerformed(evt);
            }
        });

        main_button_stockOutTransfer.setBackground(new java.awt.Color(255, 255, 255));
        main_button_stockOutTransfer.setText("Stock Out");
        main_button_stockOutTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                main_button_stockOutTransferActionPerformed(evt);
            }
        });

        main_button_records.setBackground(new java.awt.Color(255, 255, 255));
        main_button_records.setText("Records");
        main_button_records.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                main_button_recordsActionPerformed(evt);
            }
        });

        main_button_database.setBackground(new java.awt.Color(255, 255, 255));
        main_button_database.setText("Database");
        main_button_database.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                main_button_databaseActionPerformed(evt);
            }
        });

        main_button_invoices.setBackground(new java.awt.Color(255, 255, 255));
        main_button_invoices.setText("Invoices");
        main_button_invoices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                main_button_invoicesesActionPerformed(evt);
            }
        });

        main_button_sales.setBackground(new java.awt.Color(255, 255, 255));
        main_button_sales.setText("Sales");
        main_button_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                main_button_salesActionPerformed(evt);
            }
        });

        logo.setFont(new java.awt.Font("sansserif", 0, 8)); // NOI18N
        //ImageIcon imageIcon = new ImageIcon(new ImageIcon("filter.png").getImage().getScaledInstance(0.5, 0.5, Image.SCALE_SMOOTH));
        //jLabel2.setIcon(imageIcon);

        wing.setFont(new java.awt.Font("sansserif", 0, 8)); // NOI18N
        //ImageIcon imageIcon = new ImageIcon(new ImageIcon("filter.png").getImage().getScaledInstance(0.5, 0.5, Image.SCALE_SMOOTH));
        //jLabel2.setIcon(imageIcon);

        wing2.setFont(new java.awt.Font("sansserif", 0, 8)); // NOI18N
        //ImageIcon imageIcon = new ImageIcon(new ImageIcon("filter.png").getImage().getScaledInstance(0.5, 0.5, Image.SCALE_SMOOTH));
        //jLabel2.setIcon(imageIcon);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(button_main_stockIn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(main_button_stockOutTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(main_button_records, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(main_button_invoices, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(main_button_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(main_button_database, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(wing, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                        .addGap(174, 174, 174)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(132, 132, 132)
                .addComponent(wing2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(wing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_main_stockIn)
                    .addComponent(main_button_stockOutTransfer)
                    .addComponent(main_button_records)
                    .addComponent(main_button_database)
                    .addComponent(main_button_invoices)
                    .addComponent(main_button_sales))
                .addContainerGap())
            .addComponent(wing2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Most Item Sales");

        sales1.setBackground(new java.awt.Color(0, 0, 0));
        sales1.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        sales1.setText("N/A");

        sales2.setBackground(new java.awt.Color(0, 0, 0));
        sales2.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        sales2.setText("N/A");

        sales3.setBackground(new java.awt.Color(0, 0, 0));
        sales3.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        sales3.setText("N/A");

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Large Outstandings");

        outstanding3.setBackground(new java.awt.Color(0, 0, 0));
        outstanding3.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        outstanding3.setText("N/A");

        outstanding1.setBackground(new java.awt.Color(0, 0, 0));
        outstanding1.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        outstanding1.setText("N/A");

        outstanding2.setBackground(new java.awt.Color(0, 0, 0));
        outstanding2.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        outstanding2.setText("N/A");

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Item Least Quantity");

        least1.setBackground(new java.awt.Color(0, 0, 0));
        least1.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        least1.setText("N/A");

        least2.setBackground(new java.awt.Color(0, 0, 0));
        least2.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        least2.setText("N/A");

        least3.setBackground(new java.awt.Color(0, 0, 0));
        least3.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        least3.setText("N/A");

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Item Most Quantity");

        most1.setBackground(new java.awt.Color(0, 0, 0));
        most1.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        most1.setText("N/A");

        most2.setBackground(new java.awt.Color(0, 0, 0));
        most2.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        most2.setText("N/A");

        most3.setBackground(new java.awt.Color(0, 0, 0));
        most3.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        most3.setText("N/A");

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Unpaid Invoices");

        invoice3.setBackground(new java.awt.Color(0, 0, 0));
        invoice3.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        invoice3.setText("N/A");

        invoice1.setBackground(new java.awt.Color(0, 0, 0));
        invoice1.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        invoice1.setText("N/A");

        invoice2.setBackground(new java.awt.Color(0, 0, 0));
        invoice2.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        invoice2.setText("N/A");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(sales1)
                            .addComponent(sales2)
                            .addComponent(sales3)
                            .addComponent(outstanding1)
                            .addComponent(outstanding2)
                            .addComponent(outstanding3)
                            .addComponent(jLabel11)
                            .addComponent(least1)
                            .addComponent(least2)
                            .addComponent(least3)
                            .addComponent(jLabel15)
                            .addComponent(most1)
                            .addComponent(most2)
                            .addComponent(most3))
                        .addGap(0, 248, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(invoice1)
                            .addComponent(invoice2)
                            .addComponent(invoice3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sales1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sales2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sales3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invoice1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invoice2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invoice3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outstanding1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outstanding2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outstanding3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(least1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(least2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(least3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(most1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(most2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(most3)
                .addContainerGap(263, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        displayTable.setBackground(new java.awt.Color(255, 255, 255));
        displayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            }, new String[]
            {

            }
        ));
        displayTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        displayTable.setGridColor(new java.awt.Color(51, 204, 0));
        displayTable.setMaximumSize(new java.awt.Dimension(3, 3));
        displayTable.setSelectionBackground(new java.awt.Color(204, 0, 0));
        displayTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        displayTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(displayTable);
        displayTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        main_searchBar.setBackground(new java.awt.Color(255, 255, 255));
        main_searchBar.setToolTipText("Enter keyword");
        main_searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                main_searchBarKeyReleased(evt);
            }
        });

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 8)); // NOI18N
        //ImageIcon imageIcon = new ImageIcon(new ImageIcon("filter.png").getImage().getScaledInstance(0.5, 0.5, Image.SCALE_SMOOTH));
        //jLabel2.setIcon(imageIcon);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(main_searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(main_searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1406, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel1AncestorMoved

    }//GEN-LAST:event_jPanel1AncestorMoved

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        try
        {
            updateTableData( MODE_FILTER_SEARCH, main_searchBar.getText(), jComboBox1.getSelectedItem().toString());
        }catch(Exception e){ShowFreakingError(e + " - Error 0003");}
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void button_main_stockInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_main_stockInActionPerformed
        StockInFrame stockInFrame = new StockInFrame();
        stockInFrame.openStockInFrame(this);
        stockInFrame.setVisible(true);
        int x = (getWidth() - stockInFrame.getWidth()) / 2;
        int y = (getHeight() - stockInFrame.getHeight()) / 2;
        stockInFrame.setLocation(x,y);
        myFrame.setEnabled(false);
    }//GEN-LAST:event_button_main_stockInActionPerformed

    private void main_button_stockOutTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_main_button_stockOutTransferActionPerformed
        StockOutFrame stockOutFrame = new StockOutFrame();
        stockOutFrame.openStockOutFrame(this);
        stockOutFrame.setVisible(true);
        int x = (getWidth() - stockOutFrame.getWidth()) / 2;
        int y = (getHeight() - stockOutFrame.getHeight()) / 2;
        stockOutFrame.setLocation(x,y);
        myFrame.setEnabled(false);
    }//GEN-LAST:event_main_button_stockOutTransferActionPerformed

    private void main_button_recordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_main_button_recordsActionPerformed
        RecordsFrame recordsFrame = new RecordsFrame();
        recordsFrame.openRecordsFrame(this);
        recordsFrame.setVisible(true);
        recordsFrame.setLocation((int)(getWidth() - recordsFrame.getWidth()) / 2, (int)(getHeight() - recordsFrame.getHeight()) / 2);
        setEnabled(false);
    }//GEN-LAST:event_main_button_recordsActionPerformed

    private void main_button_databaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_main_button_databaseActionPerformed
        DatabaseFrame databaseFrame = new DatabaseFrame();
        databaseFrame.openDatabaseFrame(this);
        databaseFrame.setVisible(true);
        int x = (getWidth() - databaseFrame.getWidth()) / 2;
        int y = (getHeight() - databaseFrame.getHeight()) / 2;
        databaseFrame.setLocation(x,y);
        setEnabled(false);
    }//GEN-LAST:event_main_button_databaseActionPerformed

    private void main_searchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_main_searchBarKeyReleased
        String keyword = main_searchBar.getText();
        try
        {
            updateTableData(MODE_FILTER_SEARCH, keyword, jComboBox1.getSelectedItem().toString());
        }catch(Exception e){ShowFreakingError(e + " - Error 0004");}
    }//GEN-LAST:event_main_searchBarKeyReleased

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try
        {
            updateTableData(MODE_FILTER_SEARCH, main_searchBar.getText(), jComboBox1.getSelectedItem().toString());
        }catch(Exception e){ShowFreakingError(e + " - Error 0005");}
        updateStatus();
    }//GEN-LAST:event_formWindowActivated

    private void main_button_invoicesesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_main_button_invoicesesActionPerformed
        InvoiceFrame invoiceFrame = new InvoiceFrame();
        invoiceFrame.openInvoiceFrame(this);
        invoiceFrame.setVisible(true);
        int x = (getWidth() - invoiceFrame.getWidth()) / 2;
        int y = (getHeight() - invoiceFrame.getHeight()) / 2;
        invoiceFrame.setLocation(x,y);
        myFrame.setEnabled(false);
    }//GEN-LAST:event_main_button_invoicesesActionPerformed

    private void main_button_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_main_button_salesActionPerformed
        SalesFrame salesFrame = new SalesFrame();
        salesFrame.openFrame(this);
        salesFrame.setVisible(true);
        int x = (getWidth() - salesFrame.getWidth()) / 2;
        int y = (getHeight() - salesFrame.getHeight()) / 2;
        salesFrame.setLocation(x,y);
        setEnabled(false);
    }//GEN-LAST:event_main_button_salesActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                myFrame = new MainFrame();
                myFrame.setVisible(true);
                myFrame.setExtendedState(myFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
                myFrame.setMaximumSize(myFrame.getSize());
            }
        });
    }
    
    public void ShowFreakingError(String message)
    {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_main_stockIn;
    private javax.swing.JTable displayTable;
    private javax.swing.JLabel invoice1;
    private javax.swing.JLabel invoice2;
    private javax.swing.JLabel invoice3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel least1;
    private javax.swing.JLabel least2;
    private javax.swing.JLabel least3;
    private javax.swing.JLabel logo;
    private javax.swing.JButton main_button_database;
    private javax.swing.JButton main_button_invoices;
    private javax.swing.JButton main_button_records;
    private javax.swing.JButton main_button_sales;
    private javax.swing.JButton main_button_stockOutTransfer;
    private javax.swing.JTextField main_searchBar;
    private javax.swing.JLabel most1;
    private javax.swing.JLabel most2;
    private javax.swing.JLabel most3;
    private javax.swing.JLabel outstanding1;
    private javax.swing.JLabel outstanding2;
    private javax.swing.JLabel outstanding3;
    private javax.swing.JLabel sales1;
    private javax.swing.JLabel sales2;
    private javax.swing.JLabel sales3;
    private javax.swing.JLabel wing;
    private javax.swing.JLabel wing2;
    // End of variables declaration//GEN-END:variables
}