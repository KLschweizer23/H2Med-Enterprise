package inventorysystem;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class SalesFrame extends javax.swing.JFrame {

    MainFrame myFrame;
    SalesDatabaseManager salesDb = new SalesDatabaseManager();
    
    CardLayout card;
    
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
    
    private String selectedCard = "";
    
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

        jPanel2 = new javax.swing.JPanel();
        button_summary = new javax.swing.JButton();
        button_expenses = new javax.swing.JButton();
        panel_main = new javax.swing.JPanel();
        scroll_summary = new javax.swing.JScrollPane();
        panel_summary = new javax.swing.JPanel();
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
        processButton = new javax.swing.JButton();
        chartPanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        labelOutstanding = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        l_month = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        l_totalSales = new javax.swing.JLabel();
        l_totalExpenses = new javax.swing.JLabel();
        l_totalProfit = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        l_totalOutstanding = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        l_outstandingPaid = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        l_totalCosts = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        l_additionalExpenses = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        l_outstandingLeft = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        l_topSelling = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        l_fastMoving = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        l_mostOutInvoice = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        l_mostInInvoice = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        r_month = new javax.swing.JLabel();
        r_topSelling = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        r_totalCosts = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        r_totalSales = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        r_mostOutInvoice = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        r_outstandingPaid = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        r_additionalExpenses = new javax.swing.JLabel();
        r_fastMoving = new javax.swing.JLabel();
        r_mostInInvoice = new javax.swing.JLabel();
        r_totalExpenses = new javax.swing.JLabel();
        r_totalProfit = new javax.swing.JLabel();
        r_outstandingLeft = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        r_totalOutstanding = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        c_month = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        c_topSelling = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        c_mostInInvoice = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        c_mostOutInvoice = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        c_totalExpenses = new javax.swing.JLabel();
        c_totalSales = new javax.swing.JLabel();
        c_outstandingLeft = new javax.swing.JLabel();
        c_totalOutstanding = new javax.swing.JLabel();
        c_additionalExpenses = new javax.swing.JLabel();
        c_outstandingPaid = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        c_totalProfit = new javax.swing.JLabel();
        c_fastMoving = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        c_totalCosts = new javax.swing.JLabel();
        button_monthlyReport = new javax.swing.JButton();
        panel_expenses = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_expenses = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        label_totalExpenses = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        label_monthExpenses = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        label_mostExpensesParticular = new javax.swing.JLabel();
        label_mostExpensesAmount = new javax.swing.JLabel();
        button_newExpenses = new javax.swing.JButton();
        button_deleteExpenses = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(136, 133, 133));
        jPanel2.setForeground(new java.awt.Color(235, 235, 235));

        button_summary.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        button_summary.setForeground(new java.awt.Color(255, 255, 255));
        button_summary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/summary_back.png"))); // NOI18N
        button_summary.setToolTipText("");
        button_summary.setActionCommand("Summary");
        button_summary.setFocusable(false);
        button_summary.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button_summary.setLabel("Summary");
        button_summary.setRequestFocusEnabled(false);
        button_summary.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/summary_hover.png"))); // NOI18N
        button_summary.setSelected(true);
        button_summary.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/summary_pressed.png"))); // NOI18N
        button_summary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_summaryActionPerformed(evt);
            }
        });

        button_expenses.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        button_expenses.setForeground(new java.awt.Color(255, 255, 255));
        button_expenses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/summary_back.png"))); // NOI18N
        button_expenses.setFocusable(false);
        button_expenses.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button_expenses.setLabel("Expenses");
        button_expenses.setRequestFocusEnabled(false);
        button_expenses.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/summary_hover.png"))); // NOI18N
        button_expenses.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/summary_pressed.png"))); // NOI18N
        button_expenses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_expensesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button_summary, javax.swing.GroupLayout.PREFERRED_SIZE, 181, Short.MAX_VALUE)
            .addComponent(button_expenses, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(button_summary, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(button_expenses, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_main.setLayout(new java.awt.CardLayout());

        scroll_summary.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel_summary.setBackground(new java.awt.Color(255, 255, 255));

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
        jLabel12.setText("Expenses");

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
                .addContainerGap(156, Short.MAX_VALUE))
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

        processButton.setText("Process");
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chartPanelLayout = new javax.swing.GroupLayout(chartPanel);
        chartPanel.setLayout(chartPanelLayout);
        chartPanelLayout.setHorizontalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1054, Short.MAX_VALUE)
        );
        chartPanelLayout.setVerticalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
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
                .addContainerGap(122, Short.MAX_VALUE))
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel12.setBackground(new java.awt.Color(237, 239, 255));
        jPanel12.setForeground(new java.awt.Color(227, 246, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(310, 380));

        l_month.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        l_month.setForeground(new java.awt.Color(191, 193, 214));
        l_month.setText("Month");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(191, 193, 214));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Total Sales:");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(191, 193, 214));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Total Expenses:");

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(191, 193, 214));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Total Profit:");

        l_totalSales.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_totalSales.setForeground(new java.awt.Color(191, 193, 214));
        l_totalSales.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l_totalSales.setText("0.0");

        l_totalExpenses.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_totalExpenses.setForeground(new java.awt.Color(191, 193, 214));
        l_totalExpenses.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l_totalExpenses.setText("0.0");

        l_totalProfit.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_totalProfit.setForeground(new java.awt.Color(191, 193, 214));
        l_totalProfit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l_totalProfit.setText("0.0");

        jLabel23.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(191, 193, 214));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Total Outstanding:");

        l_totalOutstanding.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_totalOutstanding.setForeground(new java.awt.Color(191, 193, 214));
        l_totalOutstanding.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l_totalOutstanding.setText("0.0");

        jLabel25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(191, 193, 214));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Outstanding Paid:");

        l_outstandingPaid.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_outstandingPaid.setForeground(new java.awt.Color(191, 193, 214));
        l_outstandingPaid.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l_outstandingPaid.setText("0.0");

        jLabel27.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(191, 193, 214));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("- Item Total Costs:");

        l_totalCosts.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_totalCosts.setForeground(new java.awt.Color(191, 193, 214));
        l_totalCosts.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l_totalCosts.setText("0.0");

        jLabel29.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(191, 193, 214));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("- Additional Expenses:");

        l_additionalExpenses.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_additionalExpenses.setForeground(new java.awt.Color(191, 193, 214));
        l_additionalExpenses.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l_additionalExpenses.setText("0.0");

        jLabel31.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(191, 193, 214));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("Outstanding Left:");

        l_outstandingLeft.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_outstandingLeft.setForeground(new java.awt.Color(191, 193, 214));
        l_outstandingLeft.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l_outstandingLeft.setText("0.0");

        jLabel33.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(191, 193, 214));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("Top Selling Item:");

        l_topSelling.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_topSelling.setForeground(new java.awt.Color(191, 193, 214));
        l_topSelling.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l_topSelling.setText("Item");

        jLabel35.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(191, 193, 214));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("Fast Moving Item:");

        l_fastMoving.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_fastMoving.setForeground(new java.awt.Color(191, 193, 214));
        l_fastMoving.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l_fastMoving.setText("Item");

        jLabel37.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(191, 193, 214));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel37.setText("Most Outgoing Invoice:");

        l_mostOutInvoice.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_mostOutInvoice.setForeground(new java.awt.Color(191, 193, 214));
        l_mostOutInvoice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l_mostOutInvoice.setText("Customer");

        jLabel39.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(191, 193, 214));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel39.setText("Most Ingoing Invoice:");

        l_mostInInvoice.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_mostInInvoice.setForeground(new java.awt.Color(191, 193, 214));
        l_mostInInvoice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l_mostInInvoice.setText("Supplier");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_month)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel16)
                            .addComponent(jLabel23)
                            .addComponent(jLabel25)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel27)))
                            .addComponent(jLabel31)
                            .addComponent(jLabel33)
                            .addComponent(jLabel35)
                            .addComponent(jLabel37)
                            .addComponent(jLabel39))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(l_fastMoving)
                            .addComponent(l_topSelling)
                            .addComponent(l_outstandingLeft)
                            .addComponent(l_totalCosts)
                            .addComponent(l_totalSales)
                            .addComponent(l_totalExpenses)
                            .addComponent(l_totalProfit)
                            .addComponent(l_totalOutstanding)
                            .addComponent(l_outstandingPaid)
                            .addComponent(l_additionalExpenses)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(l_mostInInvoice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(l_mostOutInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(l_month)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(l_totalSales))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(l_totalExpenses))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(l_totalCosts))
                .addGap(5, 5, 5)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(l_additionalExpenses))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(l_totalProfit))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(l_totalOutstanding))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(l_outstandingPaid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(l_outstandingLeft))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(l_topSelling))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(l_fastMoving))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(l_mostOutInvoice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(l_mostInInvoice))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(113, 123, 227));
        jPanel13.setForeground(new java.awt.Color(116, 197, 237));
        jPanel13.setPreferredSize(new java.awt.Dimension(310, 380));

        r_month.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        r_month.setForeground(new java.awt.Color(48, 52, 92));
        r_month.setText("Month");

        r_topSelling.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        r_topSelling.setForeground(new java.awt.Color(48, 52, 92));
        r_topSelling.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        r_topSelling.setText("Item");

        jLabel79.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(48, 52, 92));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel79.setText("Top Selling Item:");

        jLabel87.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(48, 52, 92));
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel87.setText("Total Sales:");

        jLabel81.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(48, 52, 92));
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel81.setText("Fast Moving Item:");

        jLabel85.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(48, 52, 92));
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel85.setText("Most Ingoing Invoice:");

        jLabel71.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(48, 52, 92));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel71.setText("Outstanding Paid:");

        r_totalCosts.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        r_totalCosts.setForeground(new java.awt.Color(48, 52, 92));
        r_totalCosts.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        r_totalCosts.setText("0.0");

        jLabel75.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(48, 52, 92));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel75.setText("- Additional Expenses:");

        r_totalSales.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        r_totalSales.setForeground(new java.awt.Color(48, 52, 92));
        r_totalSales.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        r_totalSales.setText("0.0");

        jLabel73.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(48, 52, 92));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel73.setText("- Item Total Costs:");

        jLabel65.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(48, 52, 92));
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel65.setText("Total Profit:");

        jLabel83.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(48, 52, 92));
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel83.setText("Most Outgoing Invoice:");

        r_mostOutInvoice.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        r_mostOutInvoice.setForeground(new java.awt.Color(48, 52, 92));
        r_mostOutInvoice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        r_mostOutInvoice.setText("Customer");

        jLabel77.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(48, 52, 92));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel77.setText("Outstanding Left:");

        r_outstandingPaid.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        r_outstandingPaid.setForeground(new java.awt.Color(48, 52, 92));
        r_outstandingPaid.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        r_outstandingPaid.setText("0.0");

        jLabel69.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(48, 52, 92));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel69.setText("Total Outstanding:");

        r_additionalExpenses.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        r_additionalExpenses.setForeground(new java.awt.Color(48, 52, 92));
        r_additionalExpenses.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        r_additionalExpenses.setText("0.0");

        r_fastMoving.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        r_fastMoving.setForeground(new java.awt.Color(48, 52, 92));
        r_fastMoving.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        r_fastMoving.setText("Item");

        r_mostInInvoice.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        r_mostInInvoice.setForeground(new java.awt.Color(48, 52, 92));
        r_mostInInvoice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        r_mostInInvoice.setText("Supplier");

        r_totalExpenses.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        r_totalExpenses.setForeground(new java.awt.Color(48, 52, 92));
        r_totalExpenses.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        r_totalExpenses.setText("0.0");

        r_totalProfit.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        r_totalProfit.setForeground(new java.awt.Color(48, 52, 92));
        r_totalProfit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        r_totalProfit.setText("0.0");

        r_outstandingLeft.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        r_outstandingLeft.setForeground(new java.awt.Color(48, 52, 92));
        r_outstandingLeft.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        r_outstandingLeft.setText("0.0");

        jLabel88.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(48, 52, 92));
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel88.setText("Total Expenses:");

        r_totalOutstanding.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        r_totalOutstanding.setForeground(new java.awt.Color(48, 52, 92));
        r_totalOutstanding.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        r_totalOutstanding.setText("0.0");

        jLabel89.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(48, 52, 92));
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel89.setText("* possible monthly report if invoices within this month is paid.");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel89)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(18, 22, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel87)
                            .addComponent(jLabel88)
                            .addComponent(jLabel65)
                            .addComponent(jLabel69)
                            .addComponent(jLabel71)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel75)
                                    .addComponent(jLabel73)))
                            .addComponent(jLabel77)
                            .addComponent(jLabel79)
                            .addComponent(jLabel81)
                            .addComponent(jLabel83)
                            .addComponent(jLabel85))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(r_fastMoving)
                                    .addComponent(r_topSelling)
                                    .addComponent(r_outstandingLeft)
                                    .addComponent(r_totalCosts)
                                    .addComponent(r_totalSales)
                                    .addComponent(r_totalExpenses)
                                    .addComponent(r_totalProfit)
                                    .addComponent(r_totalOutstanding)
                                    .addComponent(r_outstandingPaid)
                                    .addComponent(r_additionalExpenses))
                                .addGap(91, 91, 91))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(r_mostOutInvoice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                .addComponent(r_mostInInvoice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(r_month)
                        .addGap(1, 1, 1))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(r_month)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(r_totalSales))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88)
                    .addComponent(r_totalExpenses))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(r_totalCosts))
                .addGap(5, 5, 5)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(r_additionalExpenses))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(r_totalProfit))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(r_totalOutstanding))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(r_outstandingPaid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(r_outstandingLeft))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(r_topSelling))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(r_fastMoving))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel83)
                    .addComponent(r_mostOutInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85)
                    .addComponent(r_mostInInvoice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jLabel89)
                .addContainerGap())
        );

        jPanel14.setBackground(new java.awt.Color(193, 199, 245));
        jPanel14.setForeground(new java.awt.Color(189, 233, 255));
        jPanel14.setPreferredSize(new java.awt.Dimension(330, 400));

        c_month.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        c_month.setForeground(new java.awt.Color(71, 74, 105));
        c_month.setText("Month");

        jLabel53.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(71, 74, 105));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel53.setText("- Additional Expenses:");

        jLabel47.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(71, 74, 105));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel47.setText("Total Outstanding:");

        jLabel55.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(71, 74, 105));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel55.setText("Outstanding Left:");

        c_topSelling.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        c_topSelling.setForeground(new java.awt.Color(71, 74, 105));
        c_topSelling.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        c_topSelling.setText("Item");

        jLabel41.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(71, 74, 105));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel41.setText("Most Ingoing Invoice:");

        c_mostInInvoice.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        c_mostInInvoice.setForeground(new java.awt.Color(71, 74, 105));
        c_mostInInvoice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        c_mostInInvoice.setText("Supplier");

        jLabel64.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(71, 74, 105));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel64.setText("Total Expenses:");

        jLabel59.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(71, 74, 105));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel59.setText("Fast Moving Item:");

        jLabel61.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(71, 74, 105));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel61.setText("Most Outgoing Invoice:");

        c_mostOutInvoice.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        c_mostOutInvoice.setForeground(new java.awt.Color(71, 74, 105));
        c_mostOutInvoice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        c_mostOutInvoice.setText("Customer");

        jLabel63.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(71, 74, 105));
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel63.setText("Total Sales:");

        jLabel57.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(71, 74, 105));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel57.setText("Top Selling Item:");

        c_totalExpenses.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        c_totalExpenses.setForeground(new java.awt.Color(71, 74, 105));
        c_totalExpenses.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        c_totalExpenses.setText("0.0");

        c_totalSales.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        c_totalSales.setForeground(new java.awt.Color(71, 74, 105));
        c_totalSales.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        c_totalSales.setText("0.0");

        c_outstandingLeft.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        c_outstandingLeft.setForeground(new java.awt.Color(71, 74, 105));
        c_outstandingLeft.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        c_outstandingLeft.setText("0.0");

        c_totalOutstanding.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        c_totalOutstanding.setForeground(new java.awt.Color(71, 74, 105));
        c_totalOutstanding.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        c_totalOutstanding.setText("0.0");

        c_additionalExpenses.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        c_additionalExpenses.setForeground(new java.awt.Color(71, 74, 105));
        c_additionalExpenses.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        c_additionalExpenses.setText("0.0");

        c_outstandingPaid.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        c_outstandingPaid.setForeground(new java.awt.Color(71, 74, 105));
        c_outstandingPaid.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        c_outstandingPaid.setText("0.0");

        jLabel43.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(71, 74, 105));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel43.setText("Total Profit:");

        jLabel49.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(71, 74, 105));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel49.setText("Outstanding Paid:");

        c_totalProfit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        c_totalProfit.setForeground(new java.awt.Color(71, 74, 105));
        c_totalProfit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        c_totalProfit.setText("0.0");

        c_fastMoving.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        c_fastMoving.setForeground(new java.awt.Color(71, 74, 105));
        c_fastMoving.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        c_fastMoving.setText("Item");

        jLabel51.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(71, 74, 105));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel51.setText("- Item Total Costs:");

        c_totalCosts.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        c_totalCosts.setForeground(new java.awt.Color(71, 74, 105));
        c_totalCosts.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        c_totalCosts.setText("0.0");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63)
                    .addComponent(jLabel64)
                    .addComponent(jLabel43)
                    .addComponent(jLabel47)
                    .addComponent(jLabel49)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel53)
                            .addComponent(jLabel51)))
                    .addComponent(jLabel55)
                    .addComponent(jLabel57)
                    .addComponent(jLabel59)
                    .addComponent(jLabel61)
                    .addComponent(jLabel41))
                .addGap(44, 44, 44)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c_mostOutInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(c_mostInInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c_fastMoving)
                    .addComponent(c_topSelling)
                    .addComponent(c_outstandingLeft)
                    .addComponent(c_totalCosts)
                    .addComponent(c_totalSales)
                    .addComponent(c_totalExpenses)
                    .addComponent(c_totalProfit)
                    .addComponent(c_totalOutstanding)
                    .addComponent(c_outstandingPaid)
                    .addComponent(c_additionalExpenses))
                .addContainerGap())
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(c_month)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(c_month)
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(c_totalSales))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(c_totalExpenses))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(c_totalCosts))
                .addGap(5, 5, 5)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(c_additionalExpenses))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(c_totalProfit))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(c_totalOutstanding))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(c_outstandingPaid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(c_outstandingLeft))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(c_topSelling))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(c_fastMoving))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(c_mostOutInvoice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(c_mostInInvoice))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, 403, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        button_monthlyReport.setText("Create Monthly Report");
        button_monthlyReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_monthlyReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_summaryLayout = new javax.swing.GroupLayout(panel_summary);
        panel_summary.setLayout(panel_summaryLayout);
        panel_summaryLayout.setHorizontalGroup(
            panel_summaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_summaryLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panel_summaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_summaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panel_summaryLayout.createSequentialGroup()
                            .addGroup(panel_summaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panel_summaryLayout.createSequentialGroup()
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
                                .addGroup(panel_summaryLayout.createSequentialGroup()
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
                            .addComponent(processButton)
                            .addGap(505, 505, 505)
                            .addComponent(button_monthlyReport)
                            .addGap(40, 40, 40))
                        .addGroup(panel_summaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_summaryLayout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        panel_summaryLayout.setVerticalGroup(
            panel_summaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_summaryLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panel_summaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_summaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(dayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_summaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_summaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(monthCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(dayCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)
                        .addComponent(yearCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(processButton)
                        .addComponent(button_monthlyReport))
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_summaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        scroll_summary.setViewportView(panel_summary);

        panel_main.add(scroll_summary, "scroll_summary");

        panel_expenses.setBackground(new java.awt.Color(255, 255, 255));

        table_expenses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_expenses.setSelectionBackground(new java.awt.Color(177, 0, 0));
        table_expenses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_expenses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_expenses.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table_expenses);

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));

        jPanel10.setPreferredSize(new java.awt.Dimension(337, 155));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Total Expenses");

        label_totalExpenses.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        label_totalExpenses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_totalExpenses.setText("0.0");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_totalExpenses, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(label_totalExpenses, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setPreferredSize(new java.awt.Dimension(337, 155));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Expenses this month");

        label_monthExpenses.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        label_monthExpenses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_monthExpenses.setText("0.0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_monthExpenses, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(label_monthExpenses, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel11.setPreferredSize(new java.awt.Dimension(337, 155));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Most Expenses");

        label_mostExpensesParticular.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        label_mostExpensesParticular.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_mostExpensesParticular.setText("0.0");

        label_mostExpensesAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_mostExpensesAmount.setText("0.0");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_mostExpensesParticular, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_mostExpensesAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(label_mostExpensesParticular, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_mostExpensesAmount)
                .addGap(8, 8, 8)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        button_newExpenses.setText("New Expenses");
        button_newExpenses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_newExpensesActionPerformed(evt);
            }
        });

        button_deleteExpenses.setText("Delete Expenses");
        button_deleteExpenses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_deleteExpensesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_expensesLayout = new javax.swing.GroupLayout(panel_expenses);
        panel_expenses.setLayout(panel_expensesLayout);
        panel_expensesLayout.setHorizontalGroup(
            panel_expensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_expensesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(button_newExpenses)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_deleteExpenses)
                .addContainerGap())
            .addGroup(panel_expensesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_expensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(8, 8, 8))
        );
        panel_expensesLayout.setVerticalGroup(
            panel_expensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_expensesLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(panel_expensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_newExpenses)
                    .addComponent(button_deleteExpenses))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_main.add(panel_expenses, "panel_expenses");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(panel_main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_main, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
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

    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed
        processGraph();
        displayStatus();
    }//GEN-LAST:event_processButtonActionPerformed

    private void monthCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthCombo1ActionPerformed
        updateDate2(dayCombo1, yearCombo1, monthCombo1.getSelectedIndex());
    }//GEN-LAST:event_monthCombo1ActionPerformed

    private void yearCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearCombo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearCombo1ActionPerformed

    private void yearComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearComboActionPerformed

    private void monthComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthComboActionPerformed
        updateDate2(dayCombo, yearCombo, monthCombo.getSelectedIndex());
    }//GEN-LAST:event_monthComboActionPerformed

    private void button_summaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_summaryActionPerformed
        setButtonSelection(0);
    }//GEN-LAST:event_button_summaryActionPerformed

    private void button_expensesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_expensesActionPerformed
        processExpensesData();
        processExpensesStatus();
        setButtonSelection(1);
    }//GEN-LAST:event_button_expensesActionPerformed

    private void button_newExpensesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_newExpensesActionPerformed
        ExpensesFormDialog efd = new ExpensesFormDialog(this, true);
        int x = (myFrame.getWidth() - efd.getWidth()) / 2;
        int y = (myFrame.getHeight() - efd.getHeight()) / 2;
        efd.setLocation(x,y);
        efd.setVisible(true);
    }//GEN-LAST:event_button_newExpensesActionPerformed

    private void button_deleteExpensesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_deleteExpensesActionPerformed
        if(table_expenses.getRowCount() > 0)
        {
            ExpensesDatabaseManager edb = new ExpensesDatabaseManager();
            int id = Integer.parseInt(dtm.getValueAt(table_expenses.getSelectedRow(), 0).toString());
            try
            {
                edb.deleteExpense(id);
            }catch(Exception e){System.out.println(e);}
        }
        processExpensesData();
        processExpensesStatus();
    }//GEN-LAST:event_button_deleteExpensesActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(selectedCard.equals("panel_expenses"))
        {
            processExpensesData();
            processExpensesStatus();
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void button_monthlyReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_monthlyReportActionPerformed
        try{
            String reportPath = System.getProperty("user.dir") + "\\SalesReport.jrxml";
            //String client = invoice_client.getText();
            
            StockOutFrame sof = new StockOutFrame();
            sof.updateComboBox2(true);
            
            List<StockItems> collectionList = new ArrayList<>();//getStocks();
            
            JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(collectionList);
            
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("CollectionBeanParam", itemsJRBean);
            parameters.put("logo", getClass().getResource("/Images/h2med_logo.png").toString());
            InputStream input = new FileInputStream(new File(reportPath));
            JasperDesign jdesign = JRXmlLoader.load(input);
            
            
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, parameters, new JREmptyDataSource());
            
            JasperViewer.viewReport(jprint, false);
        }catch(FileNotFoundException | JRException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_button_monthlyReportActionPerformed
    private void processExpensesStatus()
    {
        ExpensesDatabaseManager edb = new ExpensesDatabaseManager();
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        double totalExpenses = edb.getExpenses();
        double monthlyExpenses = edb.getExpenses(date.split("-")[0], date.split("-")[1], date.split("-")[2]);
        String mostExpense = edb.getMostExpenses();
        String mostExpenseAmount = mostExpense.split("`")[0];
        String mostExpenseParticular = mostExpense.split("`")[1];
        
        label_totalExpenses.setText((char)8369 + " " + properAmount(totalExpenses));
        label_monthExpenses.setText((char)8369 + " " + properAmount(monthlyExpenses));
        label_mostExpensesParticular.setText(mostExpenseParticular);
        label_mostExpensesAmount.setText((char)8369 + " " + mostExpenseAmount + " in total!");
    }
    public String properAmount(double amount)
    {
        String amountString = amount + "";
        for(int i = 0; i < amountString.length(); i++)
            if(amountString.charAt(i) == '.' && amountString.length() > i + 2)
                return amountString.substring(0, i + 2);
        return amountString;
    }
    private void setButtonSelection(int buttonIndex)
    {
        switch(buttonIndex)
        {
            case 0:
                button_summary.setSelected(true);
                button_expenses.setSelected(false);
                
                selectedCard = "scroll_summary";
                card.show(panel_main, selectedCard);
                
                break;
                
            case 1:
                button_expenses.setSelected(true);
                button_summary.setSelected(false);
                
                selectedCard = "panel_expenses";
                card.show(panel_main, selectedCard);
                break;
        }
    }
    private void processStatus()
    {
        InvoiceDatabaseManager iDb = new InvoiceDatabaseManager();
        StockInDatabaseManager sDb = new StockInDatabaseManager();
        
        String fromDate = yearCombo.getSelectedItem() + "-" + (monthCombo.getSelectedIndex() + 1 < 10 ? "0" : "") + (monthCombo.getSelectedIndex() + 1) + "-" + (dayCombo.getSelectedIndex() + 1 < 10 ? "0" : "") + (dayCombo.getSelectedIndex() + 1);
        String toDate = yearCombo1.getSelectedItem() + "-" + (monthCombo1.getSelectedIndex() + 1 < 10 ? "0" : "") + (monthCombo1.getSelectedIndex() + 1) + "-" + (dayCombo1.getSelectedIndex() + 1 < 10 ? "0" : "") + (dayCombo1.getSelectedIndex() + 1);
        
        sales = iDb.getSalesByMonth(fromDate, toDate);
        capital = sDb.getCostByMonth(fromDate, toDate);
        outstanding = iDb.getOutstandingsByMonth(fromDate, toDate);
        
        displayStatus();
    }
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
            double costOfMonth = sDb.getCostByMonth(fromYear, i+1, 0);
            double salesOfMonth = iDb.getSalesByMonth(fromYear, i+1, 0);
            double profitOfMonth = salesOfMonth - costOfMonth;
            double outstandingOfMonth = iDb.getOutstandingsByMonth(fromYear, i+1, 0, 0);
            
            if(costOfMonth > maxValue) 
                maxValue = costOfMonth;
            if(salesOfMonth > maxValue) 
                maxValue = salesOfMonth;
            if(outstandingOfMonth > maxValue) 
                maxValue = outstandingOfMonth;
            
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
            Color[] colorPerBar = {Color.green, Color.RED, Color.blue, Color.lightGray};

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
            processStatus();
        };
        SwingUtilities.invokeLater(r);
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
        table_expenses.setModel(dtm);
        dtm.addColumn("ID");
        dtm.addColumn("Date");
        dtm.addColumn("Particulars");
        dtm.addColumn("Amount");
        dtm.addColumn("Description");
        dtm.addColumn("Status");
        dtm.addColumn("Transaction Method");
        dtm.addColumn("Due Date");
    }
    private void processExpensesData()
    {
        for(int i = 0; dtm.getRowCount() != 0;)
            dtm.removeRow(i);
        ExpensesDatabaseManager edb = new ExpensesDatabaseManager();
        ArrayList<ExpensesObject> eoList = edb.getListObject();
        for(ExpensesObject eo : eoList)
        {
            String[] rowData = {
                eo.getId(), 
                eo.getDate(), 
                eo.getParticulars(), 
                (char)8369 + " " + eo.getAmount(), 
                eo.getReason() + (eo.getOtherReason().isBlank() ? "" : ": " + eo.getOtherReason()),
                eo.isPaid() ? "Paid" : "Unpaid",
                eo.getMethod(),
                eo.getDueDate()
            };
            dtm.addRow(rowData);
        }
        if(dtm.getRowCount() > 0)
            table_expenses.setRowSelectionInterval(0, 0);
        table_expenses.setRowHeight(30);
    }
    private void processThreeMonths()
    {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int year = Integer.parseInt(date.split("-")[0]), month = Integer.parseInt(date.split("-")[1]), day = Integer.parseInt(date.split("-")[2]);
        
        String[] monthLists = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        
        InvoiceDatabaseManager iDb = new InvoiceDatabaseManager();
        StockInDatabaseManager sDb = new StockInDatabaseManager();
        ExpensesDatabaseManager eDb = new ExpensesDatabaseManager();
        
        JLabel[] months = {l_month, c_month, r_month}, 
                totalSales = {l_totalSales, c_totalSales, r_totalSales},
                totalExpenses = {l_totalExpenses, c_totalExpenses, r_totalExpenses},
                totalCosts = {l_totalCosts, c_totalCosts, r_totalCosts},
                additionalExpenses = {l_additionalExpenses, c_additionalExpenses, r_additionalExpenses},
                totalProfit = {l_totalProfit, c_totalProfit, r_totalProfit},
                totalOutstanding = {l_totalOutstanding, c_totalOutstanding, r_totalOutstanding},
                outstandingPaid = {l_outstandingPaid, c_outstandingPaid, r_outstandingPaid},
                outstandingLeft = {l_outstandingLeft, c_outstandingLeft, r_outstandingLeft},
                topSellingItem = {l_topSelling, c_topSelling, r_topSelling},
                fastMovingItem = {l_fastMoving, c_fastMoving, r_fastMoving},
                mostOutgoingInvoice = {l_mostOutInvoice, c_mostOutInvoice, r_mostOutInvoice},
                mostIngoingInvoice = {l_mostInInvoice, c_mostInInvoice, r_mostInInvoice};
        
        
        for(int j = month - 1, i = 0; j < month + 2; j++, i++)
        {
            months[i].setText("Month of " + monthLists[j-1] + " Summary");
            double salesOfMonth = iDb.getSalesByMonth(year, j, 0);
            double expensesOfMonth = sDb.getCostByMonth(year, j, 0);
            double additionalExpensesOfMonth = eDb.getExpenses(year + "", j + "", "");
            double allExpenses = expensesOfMonth + additionalExpensesOfMonth;
            totalSales[i].setText((char)8369 + " " + salesOfMonth);
            totalExpenses[i].setText((char)8369 + " " + allExpenses);
            totalCosts[i].setText((char)8369 + " " + expensesOfMonth);
            additionalExpenses[i].setText((char)8369 + " " + additionalExpensesOfMonth);
            totalProfit[i].setText((char)8369 + " " + (salesOfMonth-allExpenses));
            totalOutstanding[i].setText((char)8369 + " " + iDb.getOutstandingsByMonth(year, j, 0, 5));// outstanding made this month paid and unpaid
            outstandingPaid[i].setText((char)8369 + " " + iDb.getOutstandingsByMonth(year, j, 0, 2));// due date this month and paid
            outstandingLeft[i].setText((char)8369 + " " + iDb.getOutstandingsByMonth(year, j, 0, 0));// due date this month and unpaid
            
            String TopItem = iDb.getTopSelling(year, j, 0);
            String fastItem = iDb.getFastMoving(year, j, 0);
            String out = iDb.getOutgoingInvoice(year, j, 0);
            String in = sDb.getIngoingInvoice(year, j, 0);
            
            topSellingItem[i].setText(TopItem.isBlank() ? "None" : TopItem);
            fastMovingItem[i].setText(fastItem.isBlank() ? "None" : fastItem);
//            mostOutgoingInvoice[i].setText("<html>" + (out.isBlank() ? "None" : out) + "</html>");
//            mostIngoingInvoice[i].setText("<html>" + (in.isBlank() ? "None" : in) + "</html>");
            mostOutgoingInvoice[i].setText(String.format("<html><div WIDTH=%d>%s</div></html>", 10, (out.isBlank() ? "None" : out)));
            mostIngoingInvoice[i].setText(String.format("<html><div WIDTH=%d>%s</div></html>", 10, (in.isBlank() ? "None" : in)));
        }
        
    }
    public void openFrame(MainFrame main)
    {
        myFrame = main;
        initComponents();
        processGraph();
        createColumns();
        TableColumnModel tcm = table_expenses.getColumnModel();
        table_expenses.removeColumn(tcm.getColumn(0));
        updateDate(monthCombo, dayCombo, yearCombo, 1);
        setDate();
        card = (CardLayout)panel_main.getLayout();
        properHeight = (int)chartPanel.getPreferredSize().getHeight();
        properWidth = (int)chartPanel.getPreferredSize().getWidth();
        processStatus();
        processThreeMonths();
    }
    public void ShowFreakingError(String message)
    {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_deleteExpenses;
    private javax.swing.JButton button_expenses;
    private javax.swing.JButton button_monthlyReport;
    private javax.swing.JButton button_newExpenses;
    private javax.swing.JButton button_summary;
    private javax.swing.JLabel c_additionalExpenses;
    private javax.swing.JLabel c_fastMoving;
    private javax.swing.JLabel c_month;
    private javax.swing.JLabel c_mostInInvoice;
    private javax.swing.JLabel c_mostOutInvoice;
    private javax.swing.JLabel c_outstandingLeft;
    private javax.swing.JLabel c_outstandingPaid;
    private javax.swing.JLabel c_topSelling;
    private javax.swing.JLabel c_totalCosts;
    private javax.swing.JLabel c_totalExpenses;
    private javax.swing.JLabel c_totalOutstanding;
    private javax.swing.JLabel c_totalProfit;
    private javax.swing.JLabel c_totalSales;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_additionalExpenses;
    private javax.swing.JLabel l_fastMoving;
    private javax.swing.JLabel l_month;
    private javax.swing.JLabel l_mostInInvoice;
    private javax.swing.JLabel l_mostOutInvoice;
    private javax.swing.JLabel l_outstandingLeft;
    private javax.swing.JLabel l_outstandingPaid;
    private javax.swing.JLabel l_topSelling;
    private javax.swing.JLabel l_totalCosts;
    private javax.swing.JLabel l_totalExpenses;
    private javax.swing.JLabel l_totalOutstanding;
    private javax.swing.JLabel l_totalProfit;
    private javax.swing.JLabel l_totalSales;
    private javax.swing.JLabel labelCapital;
    private javax.swing.JLabel labelOutstanding;
    private javax.swing.JLabel labelProfit;
    private javax.swing.JLabel labelSales;
    private javax.swing.JLabel label_monthExpenses;
    private javax.swing.JLabel label_mostExpensesAmount;
    private javax.swing.JLabel label_mostExpensesParticular;
    private javax.swing.JLabel label_totalExpenses;
    private javax.swing.JComboBox<String> monthCombo;
    private javax.swing.JComboBox<String> monthCombo1;
    private javax.swing.JPanel panel_expenses;
    private javax.swing.JPanel panel_main;
    private javax.swing.JPanel panel_summary;
    private javax.swing.JButton processButton;
    private javax.swing.JLabel r_additionalExpenses;
    private javax.swing.JLabel r_fastMoving;
    private javax.swing.JLabel r_month;
    private javax.swing.JLabel r_mostInInvoice;
    private javax.swing.JLabel r_mostOutInvoice;
    private javax.swing.JLabel r_outstandingLeft;
    private javax.swing.JLabel r_outstandingPaid;
    private javax.swing.JLabel r_topSelling;
    private javax.swing.JLabel r_totalCosts;
    private javax.swing.JLabel r_totalExpenses;
    private javax.swing.JLabel r_totalOutstanding;
    private javax.swing.JLabel r_totalProfit;
    private javax.swing.JLabel r_totalSales;
    private javax.swing.JScrollPane scroll_summary;
    private javax.swing.JTable table_expenses;
    private javax.swing.JComboBox<String> yearCombo;
    private javax.swing.JComboBox<String> yearCombo1;
    // End of variables declaration//GEN-END:variables
}
