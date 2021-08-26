package inventorysystem;

import LoginPackage.LoginDialog;
import LoginPackage.LoginObject;
import inventoryPackage.InventoryFrame;
import com.formdev.flatlaf.FlatLightLaf;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
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
    
    private ArrayList<String> itemIdList;
    
    //CLASS VARIABLES
    static MainFrame myFrame;
    private ItemDatabaseManager itemDatabaseManager = new ItemDatabaseManager();
    
    //UNCOMMON VARIABLES
    private DefaultTableModel dtm;
    
    public boolean grantedAccess = false;
    private LoginObject logObj;
    
    private JButton[] buttons = new JButton[7];
    
    public MainFrame() {
        
        initComponents();
        buttons[0] = button_stockIn;
        buttons[1] = button_stockOut;
        buttons[2] = button_records;
        buttons[3] = button_invoices;
        buttons[4] = button_sales;
        buttons[5] = button_database;
        buttons[6] = button_inventory;
        do
        {
            loginForm();
        }while(!grantedAccess);
        
        if(grantedAccess)
        {
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
            accountAccess();
        }
    }
    private void accountAccess()
    {
        String role = logObj.getRole();
        if(role.equals("ADMIN"))
        {
            for(JButton but : buttons)
                but.setEnabled(true);
        }
        else if(role.equals("INVENTORY"))
        {
            for(JButton but : buttons)
                but.setEnabled(false);
            buttons[6].setEnabled(true);
        }
    }
    private void loginForm()
    {
        LoginDialog logDialog = new LoginDialog(this, true);
        System.out.println(getWidth() + " --- " + getHeight());
        System.out.println(logDialog.getWidth() + " --- " + logDialog.getHeight());
        int x = (this.getWidth() - logDialog.getWidth()) / 2;
        int y = (this.getHeight() - logDialog.getHeight()) / 2;
        logDialog.setLocation(x,y);
        logDialog.setVisible(true);
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
        buttonHover(button_stockIn, "Stockin_icon.png");
        buttonHover(button_stockOut, "Stockout_icon.png");
        buttonHover(button_records, "Record_icon.png");
        buttonHover(button_invoices, "Invoices_icon.png");
        buttonHover(button_sales, "Sales_icon.png");
        buttonHover(button_database, "Database_icon.png");
        buttonHover(button_inventory, "Inventory_icon.png");
        jLabel2.setIcon(getScaledImageIcon("filter.png", 20, 20));
        button_stockIn.setIcon(getScaledImageIcon("Stockin_icon.png", 30, 30));
        button_stockOut.setIcon(getScaledImageIcon("Stockout_icon.png", 30, 30));
        button_records.setIcon(getScaledImageIcon("Record_icon.png", 30, 30));
        button_invoices.setIcon(getScaledImageIcon("Invoices_icon.png", 30, 30));
        button_sales.setIcon(getScaledImageIcon("Sales_icon.png", 30, 30));
        button_database.setIcon(getScaledImageIcon("Database_icon.png", 30, 30));
        button_inventory.setIcon(getScaledImageIcon("Inventory_icon.png", 30, 30));
        logo.setIcon(getScaledImageIcon("h2med_logo.png", 530, 150));
        int w = 150;
        wing.setIcon(getScaledImageIcon("h2med_sidewings.png", (w / 2) + w, w));
        w = 198;
        wing2.setIcon(getScaledImageIcon("h2med_sidewings2.png", (w / 2) + w, w));
        
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png")).getImage());
        alarmButton.setIcon(getScaledImageIcon("alarm_false.png", 25, 25));
        
        alarmButton.setOpaque(false);
        alarmButton.setContentAreaFilled(false);
        alarmButton.setBorderPainted(false);
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
                iterate(button, model, icon);
            }
        });
    }
    private void iterate(JButton button, ButtonModel model, String icon)
    {
        Thread t = new Thread()
        {
            @Override
            public void run()
            {
                int r_color = 0;
                int g_color = 57;
                int b_color = 191;
                
                int r = button.getBackground().getRed();
                int g = button.getBackground().getGreen();
                int b = button.getBackground().getBlue();
                
                int r_goal = model.isRollover() ? r_color : 255;
                int g_goal = model.isRollover() ? g_color : 255;
                int b_goal = model.isRollover() ? b_color : 255;
                
                int counts = 10;
                
                int r_step = (r - r_goal) / counts;
                int g_step = (g - g_goal) / counts;
                int b_step = (b - b_goal) / counts;
                
                if(model.isRollover())
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
                        @Override
                        public void run()
                        {
                            button.setBackground(new Color(_r,_g,_b));
                            button.setForeground(model.isRollover() ? Color.white : Color.black);
                        }
                    });
                    try
                    {
                        Thread.sleep(20);
                    }catch(InterruptedException e){System.out.println(e + "222");System.exit(0);}
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
        jComboBox1.setSelectedIndex(0);
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

    public void setLogObj(LoginObject logObj) {
        this.logObj = logObj;
    }
    //CLASSES
    class backPanelGradient extends JPanel
    {
        @Override
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
        button_stockIn = new javax.swing.JButton();
        button_stockOut = new javax.swing.JButton();
        button_records = new javax.swing.JButton();
        button_database = new javax.swing.JButton();
        button_invoices = new javax.swing.JButton();
        button_sales = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        wing = new javax.swing.JLabel();
        wing2 = new javax.swing.JLabel();
        button_inventory = new javax.swing.JButton();
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
        alarmButton = new javax.swing.JButton();

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

        button_stockIn.setBackground(new java.awt.Color(255, 255, 255));
        button_stockIn.setText("Stock In");
        button_stockIn.setFocusable(false);
        button_stockIn.setRequestFocusEnabled(false);
        button_stockIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_stockInActionPerformed(evt);
            }
        });

        button_stockOut.setBackground(new java.awt.Color(255, 255, 255));
        button_stockOut.setText("Stock Out");
        button_stockOut.setFocusable(false);
        button_stockOut.setRequestFocusEnabled(false);
        button_stockOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_stockOutActionPerformed(evt);
            }
        });

        button_records.setBackground(new java.awt.Color(255, 255, 255));
        button_records.setText("Records");
        button_records.setFocusable(false);
        button_records.setRequestFocusEnabled(false);
        button_records.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_recordsActionPerformed(evt);
            }
        });

        button_database.setBackground(new java.awt.Color(255, 255, 255));
        button_database.setText("Database");
        button_database.setFocusable(false);
        button_database.setRequestFocusEnabled(false);
        button_database.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_databaseActionPerformed(evt);
            }
        });

        button_invoices.setBackground(new java.awt.Color(255, 255, 255));
        button_invoices.setText("Invoices");
        button_invoices.setFocusable(false);
        button_invoices.setRequestFocusEnabled(false);
        button_invoices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_invoicesesActionPerformed(evt);
            }
        });

        button_sales.setBackground(new java.awt.Color(255, 255, 255));
        button_sales.setText("Sales");
        button_sales.setFocusable(false);
        button_sales.setRequestFocusEnabled(false);
        button_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_salesActionPerformed(evt);
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

        button_inventory.setBackground(new java.awt.Color(255, 255, 255));
        button_inventory.setText("Inventory");
        button_inventory.setFocusable(false);
        button_inventory.setRequestFocusEnabled(false);
        button_inventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_inventoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(wing, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                        .addGap(174, 174, 174)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(button_stockIn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_stockOut, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_records, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_invoices, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_database, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_inventory, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(wing2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(wing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_stockIn)
                    .addComponent(button_stockOut)
                    .addComponent(button_records)
                    .addComponent(button_database)
                    .addComponent(button_invoices)
                    .addComponent(button_sales)
                    .addComponent(button_inventory))
                .addGap(5, 5, 5))
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
                    .addComponent(sales1)
                    .addComponent(jLabel7)
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
                    .addComponent(most3)
                    .addComponent(jLabel19)
                    .addComponent(invoice1)
                    .addComponent(invoice2)
                    .addComponent(invoice3)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(270, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        displayTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        displayTable.setFillsViewportHeight(true);
        displayTable.setGridColor(new java.awt.Color(51, 204, 0));
        displayTable.setMaximumSize(new java.awt.Dimension(3, 3));
        displayTable.setSelectionBackground(new java.awt.Color(204, 0, 0));
        displayTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        displayTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        displayTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(displayTable);
        displayTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        main_searchBar.setToolTipText("Enter keyword");
        main_searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                main_searchBarKeyReleased(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 8)); // NOI18N
        //ImageIcon imageIcon = new ImageIcon(new ImageIcon("filter.png").getImage().getScaledInstance(0.5, 0.5, Image.SCALE_SMOOTH));
        //jLabel2.setIcon(imageIcon);

        alarmButton.setToolTipText("Open to see notifications!");
        alarmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alarmButtonActionPerformed(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alarmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(main_searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(alarmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
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

    private void button_stockInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_stockInActionPerformed
        StockInFrame stockInFrame = new StockInFrame();
        stockInFrame.openStockInFrame(this, "");
        stockInFrame.setVisible(true);
        int x = (getWidth() - stockInFrame.getWidth()) / 2;
        int y = (getHeight() - stockInFrame.getHeight()) / 2;
        stockInFrame.setLocation(x,y);
    }//GEN-LAST:event_button_stockInActionPerformed

    private void button_stockOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_stockOutActionPerformed
        StockOutFrame stockOutFrame = new StockOutFrame();
        stockOutFrame.openStockOutFrame(this);
        stockOutFrame.setVisible(true);
        int x = (getWidth() - stockOutFrame.getWidth()) / 2;
        int y = (getHeight() - stockOutFrame.getHeight()) / 2;
        stockOutFrame.setLocation(x,y);
    }//GEN-LAST:event_button_stockOutActionPerformed

    private void button_recordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_recordsActionPerformed
        RecordsFrame recordsFrame = new RecordsFrame();
        recordsFrame.openRecordsFrame(this);
        recordsFrame.setVisible(true);
        recordsFrame.setLocation((int)(getWidth() - recordsFrame.getWidth()) / 2, (int)(getHeight() - recordsFrame.getHeight()) / 2);
    }//GEN-LAST:event_button_recordsActionPerformed

    private void button_databaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_databaseActionPerformed
        DatabaseFrame databaseFrame = new DatabaseFrame();
        databaseFrame.openDatabaseFrame(this);
        databaseFrame.setVisible(true);
        int x = (getWidth() - databaseFrame.getWidth()) / 2;
        int y = (getHeight() - databaseFrame.getHeight()) / 2;
        databaseFrame.setLocation(x,y);
    }//GEN-LAST:event_button_databaseActionPerformed

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
        AlarmDialog alarm = new AlarmDialog(this, false, false);
        boolean hasNotif = alarm.hasNotification();
        alarmButton.setIcon(getScaledImageIcon("alarm_" + hasNotif + ".png", 25, 25));
        updateStatus();
    }//GEN-LAST:event_formWindowActivated

    private void button_invoicesesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_invoicesesActionPerformed
        InvoiceFrame invoiceFrame = new InvoiceFrame();
        invoiceFrame.openInvoiceFrame(this);
        invoiceFrame.setVisible(true);
        int x = (getWidth() - invoiceFrame.getWidth()) / 2;
        int y = (getHeight() - invoiceFrame.getHeight()) / 2;
        invoiceFrame.setLocation(x,y);
    }//GEN-LAST:event_button_invoicesesActionPerformed

    private void button_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_salesActionPerformed
        SalesFrame salesFrame = new SalesFrame();
        salesFrame.openFrame(this);
        salesFrame.setVisible(true);
        int x = (getWidth() - salesFrame.getWidth()) / 2;
        int y = (getHeight() - salesFrame.getHeight()) / 2;
        salesFrame.setLocation(x,y);
    }//GEN-LAST:event_button_salesActionPerformed

    private void alarmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alarmButtonActionPerformed
        AlarmDialog alarm = new AlarmDialog(this, true, true);
        int x = (getWidth() - alarm.getWidth()) / 2;
        int y = (getHeight() - alarm.getHeight()) / 2;
        alarm.setLocation(x,y);
        alarm.setVisible(true);
    }//GEN-LAST:event_alarmButtonActionPerformed

    private void button_inventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_inventoryActionPerformed
        InventoryFrame inventory = new InventoryFrame();
        inventory.openInventoryFrame(this);
        inventory.setVisible(true);
        int x = (getWidth() - inventory.getWidth()) / 2;
        int y = (getHeight() - inventory.getHeight()) / 2;
        inventory.setLocation(x,y);
    }//GEN-LAST:event_button_inventoryActionPerformed
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
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } 
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
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
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);System.exit(0);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alarmButton;
    private javax.swing.JButton button_database;
    private javax.swing.JButton button_inventory;
    private javax.swing.JButton button_invoices;
    private javax.swing.JButton button_records;
    private javax.swing.JButton button_sales;
    private javax.swing.JButton button_stockIn;
    private javax.swing.JButton button_stockOut;
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