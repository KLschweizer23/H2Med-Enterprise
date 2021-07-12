package inventorysystem;

import java.awt.Component;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class AlarmDialog extends javax.swing.JDialog {

    private DefaultTableModel dtmIn, dtmOut;
    
    private boolean hasIncomingAlarm = false;
    private boolean hasOutgoingAlarm = false;
    
    private boolean ready = false;
    
    /**
     * Creates new form AlarmDialog
     */
    public AlarmDialog(java.awt.Frame parent, boolean modal, boolean showDisplay) {
        super(parent, modal);
        initComponents();
        
        createColumns1();
        createColumns2();
        prepareIncomingInvoice(showDisplay);
        prepareOutgoingInvoice(showDisplay);
        
        resizeColumnWidth(incomingTable);
        resizeColumnWidth(outgoingTable);
        
        TableColumnModel tcm = outgoingTable.getColumnModel();
        outgoingTable.removeColumn(tcm.getColumn(0));
        
        ready = true;
    }

    private void createColumns1()
    {
        dtmIn = new DefaultTableModel(0,0)
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        incomingTable.setModel(dtmIn);
        dtmIn.addColumn("ID");
        dtmIn.addColumn("Transaction Method");
        dtmIn.addColumn("Cheque #");
        dtmIn.addColumn("Supplier");
        dtmIn.addColumn("Total Amount");
        dtmIn.addColumn("Stock In Date");
        dtmIn.addColumn("Due Date");
        dtmIn.addColumn("Info");
    }    
    private void createColumns2()
    {
        dtmOut = new DefaultTableModel(0,0)
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        outgoingTable.setModel(dtmOut);
        dtmOut.addColumn("ID");
        dtmOut.addColumn("Invoice#");
        dtmOut.addColumn("Delivery#");
        dtmOut.addColumn("Purchase#");
        dtmOut.addColumn("Transaction Method");
        dtmOut.addColumn("Cheque #");
        dtmOut.addColumn("Customer");
        dtmOut.addColumn("Total Amount");
        dtmOut.addColumn("Stock In Date");
        dtmOut.addColumn("Due Date");
        dtmOut.addColumn("Info");
    }
    private void prepareOutgoingInvoice(boolean showDisplay)
    {        
        InvoiceDatabaseManager invoiceDb = new InvoiceDatabaseManager();
        HashMap<String, ArrayList<String>> list = new HashMap<>();
        try
        {
            list = invoiceDb.getOutgoingInvoices();
        }catch(Exception e){System.out.println(e + " 100 ");}
        String[] keys = {
            "ID",
            "INVOICE_NUMBER", 
            "DELIVERY_NUMBER", 
            "PURCHASE_NUMBER", 
            "ADDRESS", 
            "INVOICE_DATE", 
            "CHEQUE_NUMBER", 
            "DUE_DATE", 
            "Total"
        };
        ArrayList<String> idList = list.get(keys[0]);
        ArrayList<InOutObject> objList = mapToListOfObjectOut(list, keys);
        HashMap<String, InOutObject> objectMap = makeHashObject(idList, objList);
        if(showDisplay)
            showDisplayOut(objectMap, idList);
        else
        {
            for(int i = 0; i < idList.size(); i++)
            {
                String number = objectMap.get(idList.get(i)).getStatus();
                if(Integer.parseInt(number) <= 3)
                {
                    hasOutgoingAlarm = true;
                    break;
                }
            }
        }
    }
    private void prepareIncomingInvoice(boolean showDisplay)
    {
        
        StockInDatabaseManager inDb = new StockInDatabaseManager();
        HashMap<String, ArrayList<String>> list = new HashMap<>();
        try
        {
            list = inDb.getIncomingInvoices();
        }catch(Exception e){System.out.println(e + " 138 ");}
        String[] keys = {
            "Dist_Id", 
            "Total", 
            "ITEM_SUPPLIER",
            "TRANSACTION_METHOD",
            "TRANSACTION_STATUS",
            "ITEM_DATE_IN",
            "TRANSACTION_DUE"
        };
        ArrayList<String> idList = list.get(keys[0]);
        ArrayList<InOutObject> objList = mapToListOfObjectIn(list, keys);
        HashMap<String, InOutObject> objectMap = makeHashObject(idList, objList);
        if(showDisplay)
            showDisplayIn(objectMap, idList);
        else
        {
            for(int i = 0; i < idList.size(); i++)
            {
                String number = objectMap.get(idList.get(i)).getStatus();
                if(Integer.parseInt(number) <= 5)
                {
                    hasIncomingAlarm = true;
                    break;
                }
            }
        }
    }
    private void showDisplayIn(HashMap<String, InOutObject> objectMap, ArrayList<String> idList)
    {
        for(int i = 0; dtmIn.getRowCount() != 0;)
            dtmIn.removeRow(i);
        for(int i = 0 ; i < idList.size(); i++)
        {
            String id = idList.get(i);
            InOutObject obj = objectMap.get(id);
            String number = obj.getStatus();
            String[] rowData = 
            {
                obj.getIds()[0],
                obj.getMethodOfTransaction(),
                obj.getChequeNumber(),
                obj.getFromOrTo(),
                obj.getAmount(),
                obj.getStartDate(),
                obj.getDueDate(),
                obj.getInfo()
            };
            if(Integer.parseInt(number) < 0 && dueComboIn.getSelectedIndex() == 2)
                dtmIn.addRow(rowData);
            else if(Integer.parseInt(number) > 5 && dueComboIn.getSelectedIndex() == 0)
                dtmIn.addRow(rowData);
            else if((Integer.parseInt(number) <= 5 && Integer.parseInt(number) >= 0) && dueComboIn.getSelectedIndex() == 1)
                dtmIn.addRow(rowData);
        }
        incomingTable.setRowHeight(30);
        sortTable(incomingTable, 7);
    }
    private void showDisplayOut(HashMap<String, InOutObject> objectMap, ArrayList<String> idList)
    {
        for(int i = 0; dtmOut.getRowCount() != 0;)
            dtmOut.removeRow(i);
        for(int i = 0 ; i < idList.size(); i++)
        {
            String id = idList.get(i);
            InOutObject obj = objectMap.get(id);
            String number = obj.getStatus();
            String[] rowData = 
            {
                obj.getIds()[0],
                obj.getIds()[1],
                obj.getIds()[2],
                obj.getIds()[3],
                obj.getMethodOfTransaction(),
                obj.getChequeNumber(),
                obj.getFromOrTo(),
                obj.getAmount(),
                obj.getStartDate(),
                obj.getDueDate(),
                obj.getInfo()
            };
            if(Integer.parseInt(number) < 0 && dueComboOut.getSelectedIndex() == 2)
                dtmOut.addRow(rowData);
            else if(Integer.parseInt(number) > 5 && dueComboOut.getSelectedIndex() == 0)
                dtmOut.addRow(rowData);
            else if((Integer.parseInt(number) <= 5 && Integer.parseInt(number) >= 0) && dueComboOut.getSelectedIndex() == 1)
                dtmOut.addRow(rowData);
        }
        outgoingTable.setRowHeight(30);
        sortTable(outgoingTable, 10);
    }
    private void sortTable(JTable table, int row)
    {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);
        
        List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
        sortKeys.add(new RowSorter.SortKey(row, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
    }
    private HashMap<String, InOutObject> makeHashObject(ArrayList<String> idList, ArrayList<InOutObject> objList)
    {
        HashMap<String, InOutObject> map = new HashMap<>();
        
        for(int i = 0; i < idList.size(); i++)
            map.put(idList.get(i), objList.get(i));
        
        return map;
    }
    private ArrayList<InOutObject> mapToListOfObjectOut(HashMap<String, ArrayList<String>> map, String[] keys)
    {
        ArrayList<InOutObject> objList = new ArrayList<>();
        ArrayList<String[]> dataList = new ArrayList<>();
        for(int i = 0; i < map.get(keys[0]).size(); i++)
        {
            String[] data = new String[keys.length];
            for(int j = 0; j < keys.length; j++)
                data[j] = map.get(keys[j]).get(i);
            dataList.add(data);
        }
        for(int i = 0; i < dataList.size(); i++)
        {
            InOutObject obj = new InOutObject();
            String[] currentData = dataList.get(i);
            String[] ids = {currentData[0], currentData[1], currentData[2], currentData[3]};
            obj.setIds(ids);
            obj.setAmount((char)8369 + " " + currentData[8]);
            obj.setFromOrTo(currentData[4]);
            boolean isCash = currentData[6].toLowerCase().equals("cash");
            obj.setMethodOfTransaction(isCash ? "Cash" : "Post Dated Check");
            obj.setChequeNumber(isCash ? "N/A" : "#" + currentData[6]);
            obj.setStartDate(currentData[5].substring(0, 10));
            obj.setDueDate(currentData[7]);
            obj.setInfo(getInfoOfDates(currentData[7], false));
            obj.setStatus(getDaysBetween(currentData[7]) + "");
            
            objList.add(obj);
        }
        return objList;
    }
    private ArrayList<InOutObject> mapToListOfObjectIn(HashMap<String, ArrayList<String>> map, String[] keys)
    {
        ArrayList<InOutObject> objList = new ArrayList<>();
        ArrayList<String[]> dataList = new ArrayList<>();
        for(int i = 0; i < map.get(keys[0]).size(); i++)
        {
            String[] data = new String[keys.length];
            for(int j = 0; j < keys.length; j++)
                data[j] = map.get(keys[j]).get(i);
            dataList.add(data);
        }
        for(int i = 0; i < dataList.size(); i++)
        {
            InOutObject obj = new InOutObject();
            String[] currentData = dataList.get(i);
            
            String[] ids = {currentData[0]};
            obj.setIds(ids);
            obj.setAmount((char)8369 + " " + currentData[1]);
            obj.setFromOrTo(currentData[2]);
            boolean isCash = currentData[3].toLowerCase().equals("cash");
            obj.setMethodOfTransaction(isCash ? "Cash" : "Post Dated Check");
            obj.setChequeNumber(isCash ? "N/A" : "#" + currentData[3]);
            obj.setStartDate(currentData[5].substring(0, 10));
            obj.setDueDate(currentData[6]);
            obj.setInfo(getInfoOfDates(currentData[6], true));
            obj.setStatus(getDaysBetween(currentData[6]) + "");
            
            objList.add(obj);
        }
        return objList;
    }
    public String getCurrentDateTime()
    {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    private long getDaysBetween(String duedate)
    {
        String currentDate = getCurrentDateTime();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        long daysBetween = 0;
        if(duedate.charAt(0) != '-')
            try
            {
                LocalDate todayDate = LocalDate.parse(currentDate, dtf);
                LocalDate dueDate = LocalDate.parse(setProperDate(duedate), dtf);
                daysBetween = ChronoUnit.DAYS.between(todayDate, dueDate);
            } catch(Exception e){System.out.println(e + " 325 ");}
        return daysBetween;
    }
    private String setProperDate(String date)
    {
        String[] splitDate = date.split("-");
        String year = splitDate[0];
        String month = splitDate[1].length() == 1 ? "0" + splitDate[1] : splitDate[1];
        String day = splitDate[2].length() == 1 ? "0" + splitDate[2] : splitDate[2];
        return year + "-" + month + "-" + day;
    }
    private String getInfoOfDates(String duedate, boolean isIncoming)
    {
        String[] inMessage = { " day/s left for payment", " day/s late for payment", " day, Please pay within this day!"};
        String[] outMessage = { " day/s to collect payment", " day/s late to collect payment", " day, Collect the payment within this day!"};
        long daysBetween = getDaysBetween(duedate);
        
        String message = "";
        
        if(daysBetween > 0)
            message = daysBetween + (isIncoming ? inMessage[0] : outMessage[0]);
        else if(daysBetween < 0)
            message = (daysBetween * -1) + (isIncoming ? inMessage[1] : outMessage[1]);
        else
            message = daysBetween + (isIncoming ? inMessage[2] : outMessage[2]);
        
        return message;
    }
    public boolean hasNotification()
    {
        return hasIncomingAlarm || hasOutgoingAlarm;
    }
    private void resizeColumnWidth(JTable table) 
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        dueComboIn = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        incomingTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outgoingTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        dueComboOut = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setRequestFocusEnabled(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        dueComboIn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Far from Due", "Near Due", "Overdue" }));
        dueComboIn.setSelectedIndex(1);
        dueComboIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dueComboInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dueComboIn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(dueComboIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        incomingTable.setBackground(new java.awt.Color(255, 255, 255));
        incomingTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        incomingTable.setFillsViewportHeight(true);
        incomingTable.setGridColor(new java.awt.Color(51, 204, 0));
        incomingTable.setMaximumSize(new java.awt.Dimension(3, 3));
        incomingTable.setSelectionBackground(new java.awt.Color(204, 0, 0));
        incomingTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        incomingTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        incomingTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(incomingTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1069, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Incoming Invoice", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        outgoingTable.setBackground(new java.awt.Color(255, 255, 255));
        outgoingTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        outgoingTable.setFillsViewportHeight(true);
        outgoingTable.setGridColor(new java.awt.Color(51, 204, 0));
        outgoingTable.setMaximumSize(new java.awt.Dimension(3, 3));
        outgoingTable.setSelectionBackground(new java.awt.Color(204, 0, 0));
        outgoingTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        outgoingTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        outgoingTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(outgoingTable);

        dueComboOut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Far from Due", "Near Due", "Overdue" }));
        dueComboOut.setSelectedIndex(1);
        dueComboOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dueComboOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dueComboOut, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(dueComboOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1069, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Outgoing Invoice", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dueComboInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dueComboInActionPerformed
        if(ready)
        {
            prepareIncomingInvoice(true);
            resizeColumnWidth(incomingTable);
        }
    }//GEN-LAST:event_dueComboInActionPerformed

    private void dueComboOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dueComboOutActionPerformed
        if(ready)
        {
            prepareOutgoingInvoice(true);
            resizeColumnWidth(outgoingTable);
        }
    }//GEN-LAST:event_dueComboOutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> dueComboIn;
    private javax.swing.JComboBox<String> dueComboOut;
    private javax.swing.JTable incomingTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable outgoingTable;
    // End of variables declaration//GEN-END:variables
}
