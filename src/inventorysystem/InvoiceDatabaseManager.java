package inventorysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class InvoiceDatabaseManager 
{
    final private String invoicetable = "invoicetable";
    final private String ID = "ID";
    final private String INVOICE_NUMBER = "INVOICE_NUMBER";
    final private String ITEMS = "ITEMS";
    final private String COST = "COST";
    final private String PRICE = "PRICE";
    final private String QUANTITY = "QUANTITY";
    final private String ADDRESS = "ADDRESS";
    final private String PAID = "PAID";
    final private String INVOICE_DATE = "INVOICE_DATE";
    final private String INVOICE_STATUS = "INVOICE_STATUS";
    final private String DELIVERY_NUMBER = "DELIVERY_NUMBER";
    final private String PURCHASE_NUMBER = "PURCHASE_NUMBER";
    final private String ITEM_SUPPLIER = "ITEM_SUPPLIER";
    final private String CHEQUE_NUMBER = "CHEQUE_NUMBER";
    final private String DUE_DATE = "DUE_DATE";
    final private String COLLECTION = "COLLECTION";
    
    private ArrayList<Integer> idList = new ArrayList<>();
    private ArrayList<Integer> invoiceNumberList = new ArrayList<>();
    private ArrayList<String> itemsList = new ArrayList<>();
    private ArrayList<Double> costList = new ArrayList<>();
    private ArrayList<Double> priceList = new ArrayList<>();
    private ArrayList<Double> quantityList = new ArrayList<>();
    private ArrayList<String> addressList = new ArrayList<>();
    private ArrayList<Double> paidList = new ArrayList<>();
    private ArrayList<String> invoiceDateList = new ArrayList<>();
    private ArrayList<Integer> invoiceStatusList = new ArrayList<>();
    private ArrayList<Integer> deliveryNumberList = new ArrayList<>();
    private ArrayList<Integer> purchaseNumberList = new ArrayList<>();
    private ArrayList<String> itemSupplierList = new ArrayList<>();
    private ArrayList<String> itemChequeList = new ArrayList<>();
    private ArrayList<String> itemDueDateList = new ArrayList<>();
    private ArrayList<Integer> itemResult = new ArrayList<>();
    private ArrayList<Double> itemTotal = new ArrayList<>();
    private ArrayList<Integer> collection = new ArrayList<>();
    
    private ArrayList<Integer> distinctInvoiceNumber = new ArrayList<>();
    private ArrayList<Integer> distinctDeliveryNumber = new ArrayList<>();
    private ArrayList<Integer> distinctPurchaseNumber = new ArrayList<>();
    
    public Connection getConnection() throws Exception
    {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/Inventory_Database";
        String username = "root";
        String password = "umtc";
        Class.forName(driver);
        
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
    public void processAllData() throws Exception
    {
        Connection con = getConnection();
        PreparedStatement allQuery = con.prepareStatement("SELECT * FROM " + invoicetable);
        ResultSet result = allQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    public void filterByCategory(String _address) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement filterQuery = con.prepareStatement("call sp_invoiceFilterByCategory('" + _address + "')");
        ResultSet result = filterQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    public void filterBySearch(String _keyword, String _address) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement filterQuery = con.prepareStatement("call sp_invoiceFilterBySearch('" + _keyword + "', '" + _address + "')");
        ResultSet result = filterQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    public void getItemsByInvoiceNumber(int _invoice_number, String _address) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement getQuery = con.prepareStatement("SELECT * FROM " + invoicetable + " WHERE " + INVOICE_NUMBER + " = " + _invoice_number + " AND " + ADDRESS + " = '" + _address +"';");
        ResultSet result = getQuery.executeQuery();
        re_initializeVariables(result);
        con.close();        
    }
    public void getDataBySupplier(String _supplier, String _item) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement getQuery = con.prepareStatement("SELECT * FROM " + invoicetable + " WHERE " + ITEM_SUPPLIER + " ='" + _supplier + "' AND " + ITEMS + " ='" + _item + "'");
        ResultSet result = getQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    public void processPayment(int _invoice_number, double payment, int status, String _address, String _date) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement processQuery = con.prepareStatement("UPDATE " + invoicetable + " set " + PAID + " = " + payment + ", " + INVOICE_STATUS + " = " + status + ", " + DUE_DATE + " = '" + _date + "' WHERE " + INVOICE_NUMBER + " = " + _invoice_number
                + " AND "
                + ADDRESS + " = '" + _address + "' " +
                ";");
        processQuery.executeUpdate();
        con.close();   
        processAllData();
    }
    public void processMostSales() throws Exception
    {
        Connection con = getConnection();
        PreparedStatement processQuery = con.prepareStatement("SELECT *, COUNT(*) AS RESULT FROM " + invoicetable + " GROUP BY " + ITEMS + " ORDER BY RESULT DESC LIMIT 3");
        ResultSet result = processQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    public void processLongestInvoice() throws Exception
    {
        Connection con = getConnection();
        PreparedStatement processQuery = con.prepareStatement("SELECT * FROM " + invoicetable + " WHERE " + INVOICE_STATUS + "=" + 0 +" GROUP BY " + INVOICE_NUMBER + " ORDER BY " + INVOICE_DATE + " ASC LIMIT 3");
        ResultSet result = processQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    public void processMostOutstanding() throws Exception
    {
        Connection con = getConnection();
        PreparedStatement processQuery = con.prepareStatement("SELECT *, SUM(" + PRICE + " * " + QUANTITY + ") AS TOTAL FROM " + invoicetable + " WHERE " + INVOICE_STATUS + " = " + 0 + " GROUP BY " + ADDRESS + " ORDER BY TOTAL DESC LIMIT 3");
        ResultSet result = processQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    public double getSalesByMonth(int year, int monthInt)
    {
        String month = monthInt < 10 ? "0" + monthInt : monthInt + "";
        String month1 = ++monthInt < 10 ? "0" + monthInt : monthInt + "";
        double sales = 0;
        try
        {
            Connection con = getConnection();
            PreparedStatement getQuery = con.prepareStatement("SELECT SUM(PRICE * QUANTITY) AS 'total' FROM invoicetable WHERE INVOICE_STATUS = 2 AND DUE_DATE BETWEEN '" + year + "-" + month + "-0' AND '" + year + "-" + month1 + "-0' ;");
            ResultSet result = getQuery.executeQuery();
            while(result.next())
                sales = Double.parseDouble(result.getString("total"));
            con.close();
        }catch(Exception e){System.out.println(e);}
        
        return sales;
    }
    public double getOutstandingsByMonth(int year, int monthInt)
    {
        String month = monthInt < 10 ? "0" + monthInt : monthInt + "";
        String month1 = ++monthInt < 10 ? "0" + monthInt : monthInt + "";
        double outstanding = 0;
        try
        {
            Connection con = getConnection();
            PreparedStatement getQuery = con.prepareStatement("SELECT SUM(PRICE * QUANTITY) AS 'total' FROM invoicetable WHERE INVOICE_STATUS = 0 AND DUE_DATE BETWEEN '" + year + "-" + month + "-0' AND '" + year + "-" + month1 + "-0' ;");
            ResultSet result = getQuery.executeQuery();
            while(result.next())
                outstanding = Double.parseDouble(result.getString("total"));
            con.close();
        }catch(Exception e){System.out.println(e);}
        
        return outstanding;
    }
    private void re_initializeVariables(ResultSet result) throws Exception
    {
        idList.clear();
        invoiceNumberList.clear();
        itemsList.clear();
        costList.clear();
        priceList.clear();
        quantityList.clear();
        addressList.clear();
        paidList.clear();
        invoiceDateList.clear();
        invoiceStatusList.clear();
        deliveryNumberList.clear();
        purchaseNumberList.clear();
        itemSupplierList.clear();
        itemChequeList.clear();
        itemDueDateList.clear();
        itemResult.clear();
        itemTotal.clear();
        collection.clear();
        while(result.next())
        {
            idList.add(result.getInt(ID));
            invoiceNumberList.add(result.getInt(INVOICE_NUMBER));
            itemsList.add(result.getString(ITEMS));
            costList.add(result.getDouble(COST));
            priceList.add(result.getDouble(PRICE));
            quantityList.add(result.getDouble(QUANTITY));
            addressList.add(result.getString(ADDRESS));
            paidList.add(result.getDouble(PAID));
            invoiceDateList.add(result.getString(INVOICE_DATE));
            invoiceStatusList.add(result.getInt(INVOICE_STATUS));
            deliveryNumberList.add(result.getInt(DELIVERY_NUMBER));
            purchaseNumberList.add(result.getInt(PURCHASE_NUMBER));
            itemSupplierList.add(result.getString(ITEM_SUPPLIER));
            itemChequeList.add(result.getString(CHEQUE_NUMBER));
            itemDueDateList.add(result.getString(DUE_DATE));
            collection.add(result.getInt(COLLECTION));
            try
            {
                itemResult.add(result.getInt("RESULT"));
            }catch(Exception e){}
            try
            {
                itemTotal.add(result.getDouble("TOTAL"));
            }catch(Exception e){}
        }
    }
    public void insertData(int _invoice_number, String _items, double _cost, double _price, double _quantity, String _address, int _paid, String _invoice_date, int _invoice_status, int _delivery_number, int _purchase_number, String _item_supplier, String _cheque, String _due, int _collection) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement insertQuery = con.prepareStatement("call sp_invoiceInsert(" 
                + _invoice_number + ", '"
                + _items + "', "
                + _cost + ", "
                + _price + ", "
                + _quantity + ", '"
                + _address + "', "
                + _paid + ", '"
                + _invoice_date + "', "
                + _invoice_status + ", "
                + _delivery_number + ", "
                + _purchase_number + ", '"
                + _item_supplier + "', '"
                + _cheque + "', '"
                + _due + "',"
                + _collection
                + ");");
        insertQuery.executeUpdate();
        con.close();
        processAllData();
    }
    public void deleteData(int _id, String _address) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement deleteQuery = con.prepareStatement("DELETE FROM " + invoicetable + " WHERE " + INVOICE_NUMBER + "=" + _id + " AND " + ADDRESS + " ='" + _address + "'");
        deleteQuery.executeUpdate();
        con.close();
        processAllData();
    }
    public void updateCollection(int _receiptNumber, int _invoice, String _address) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement updateQuery = con.prepareStatement("UPDATE " + invoicetable + " SET " + COLLECTION + " = " + _receiptNumber + " WHERE " + INVOICE_NUMBER + " = " + _invoice + " AND " + ADDRESS + " = '" + _address + "'");
        updateQuery.executeUpdate();
    }
    public ArrayList<Integer> getDistinctInvoiceNumber(String address) throws Exception
    {
        ArrayList<Integer> invList = new ArrayList<>();
        
        Connection con = getConnection();
        PreparedStatement invoiceQuery = con.prepareStatement("SELECT DISTINCT(" + INVOICE_NUMBER + ") FROM " + invoicetable + " WHERE " + INVOICE_STATUS + " != 2 AND " + ADDRESS + " = '" + address + "';");
        ResultSet result = invoiceQuery.executeQuery();
        
        while(result.next())
        {
            invList.add(result.getInt(INVOICE_NUMBER));
        }
        return invList;
    }
    public void processDistinctNumbers(String address) throws Exception
    {
        distinctInvoiceNumber.clear();
        distinctDeliveryNumber.clear();
        distinctPurchaseNumber.clear();
        Connection con = getConnection();
        PreparedStatement invoiceQuery = con.prepareStatement("call sp_invoiceGetDistinctInvoiceNumber('" + address + "')");
        ResultSet result = invoiceQuery.executeQuery();
        initializeDistinctArrays(result, distinctInvoiceNumber, INVOICE_NUMBER);
        PreparedStatement deliveryQuery = con.prepareStatement("call sp_deliveryGetDistinctNumber('" + address + "')");
        ResultSet result2 = deliveryQuery.executeQuery();
        initializeDistinctArrays(result2, distinctDeliveryNumber, DELIVERY_NUMBER);
        PreparedStatement purchaseQuery = con.prepareStatement("call sp_purchaseGetDistinctNumber('" + address + "')");
        ResultSet result3 = purchaseQuery.executeQuery();
        initializeDistinctArrays(result3, distinctPurchaseNumber, PURCHASE_NUMBER);
        con.close();
    }
    private void initializeDistinctArrays(ResultSet result, ArrayList<Integer> list, String colName) throws Exception
    {
        while(result.next())
        {
            list.add(result.getInt(colName));
        }
    }
    public int getAvailableInvoiceNumber() throws Exception
    {
        int listSize = distinctInvoiceNumber.size();
        int availableNumber = 1;
        for(int j = 0, i = 1; j < listSize && listSize > 0; j++)
        {
            if(i != distinctInvoiceNumber.get(j)){
                availableNumber = i;
                break;
            }
            else
                i++;
            int temp = j + 1;
            if(temp >= listSize)
                availableNumber = i;
        }
        return availableNumber;
    }
    public int getAvailableDeliveryNumber() throws Exception
    {
        int listSize = distinctDeliveryNumber.size();
        int availableNumber = 1;
        for(int j = 0, i = 1; j < listSize && listSize > 0; j++)
        {
            if(i != distinctDeliveryNumber.get(j)){
                availableNumber = i;
                break;
            }
                i++;
            int temp = j + 1;
            if(temp >= listSize)
                availableNumber = i;
        }
        return availableNumber;
    }
    public int getAvailablePurchaseNumber() throws Exception
    {
        int listSize = distinctPurchaseNumber.size();
        int availableNumber = 1;
        for(int j = 0, i = 1; j < listSize && listSize > 0; j++)
        {
            if(i != distinctPurchaseNumber.get(j)){
                availableNumber = i;
                break;
            }
            else
                i++;
            int temp = j + 1;
            if(temp >= listSize)
                availableNumber = i;
        }
        return availableNumber;
    }
    public boolean checkInvoiceIfExist(int checkId) throws Exception
    {
        int listSize = distinctInvoiceNumber.size();
        boolean hasExist = false;
        
        for(int i = 0; i < listSize; i++)
        {
            if(checkId == distinctInvoiceNumber.get(i))
                hasExist = true;
        }
        
        return hasExist;
    }
    public HashMap<String, ArrayList<String>> getOutgoingInvoices() throws Exception
    {
        String[] keys = {ID, INVOICE_NUMBER, DELIVERY_NUMBER, PURCHASE_NUMBER, ADDRESS, INVOICE_DATE, CHEQUE_NUMBER, DUE_DATE, "Total"};
        
        Connection con = getConnection();
        PreparedStatement getQuery = con.prepareStatement("SELECT *, SUM(PRICE * QUANTITY) AS Total FROM invoicetable WHERE INVOICE_STATUS = 0 GROUP BY ADDRESS, INVOICE_NUMBER;");
        ResultSet result = getQuery.executeQuery();
        
        HashMap<String, ArrayList<String>> incomingInvoices = new HashMap<>();
        ArrayList<String> idList, iList, dList, pList, addList, invDateList, chequeList, dueList, totalList;
        
        ArrayList[] list = 
        {
            idList = new ArrayList<>(),
            iList = new ArrayList<>(),
            dList = new ArrayList<>(),
            pList = new ArrayList<>(),
            addList = new ArrayList<>(),
            invDateList = new ArrayList<>(),
            chequeList = new ArrayList<>(),
            dueList = new ArrayList<>(),
            totalList = new ArrayList<>()
        };
        
        while(result.next())
            for(int i = 0; i < keys.length; i++)
                list[i].add(result.getString(keys[i]));
        for(int i = 0; i < list.length; i++)
            incomingInvoices.put(keys[i], list[i]);
        return incomingInvoices;
    }
    public ArrayList<Integer> getIdList()
    {
        return idList;
    }
    public ArrayList<Integer> getInvoiceNumberList()
    {
        return invoiceNumberList;
    }
    public ArrayList<String> getItemsList()
    {
        return itemsList;
    }
    public ArrayList<Double> getCostList()
    {
        return costList;
    }
    public ArrayList<Double> getPriceList()
    {
        return priceList;
    }
    public ArrayList<Double> getQuantityList()
    {
        return quantityList;
    }
    public ArrayList<String> getAddressList()
    {
        return addressList;
    }
    public ArrayList<Double> getPaidList()
    {
        return paidList;
    }
    public ArrayList<String> getInvoiceDateList()
    {
        return invoiceDateList;
    }
    public ArrayList<Integer> getInvoiceStatusList()
    {
        return invoiceStatusList;
    }
    public ArrayList<Integer> getDeliveryNumberList()
    {
        return deliveryNumberList;
    }
    public ArrayList<Integer> getPurchaseNumberList()
    {
        return purchaseNumberList;
    }
    public ArrayList<String> getItemSupplierList()
    {
        return itemSupplierList;
    }
    public ArrayList<String> getItemChequeList()
    {
        return itemChequeList;
    }
    public ArrayList<String> getItemDueDateList()
    {
        return itemDueDateList;
    }
    public ArrayList<Integer> getItemResultList()
    {
        return itemResult;
    }
    public ArrayList<Double> getItemTotalList()
    {
        return itemTotal;
    }
    public ArrayList<Integer> getCollection()
    {
        return collection;
    }
}