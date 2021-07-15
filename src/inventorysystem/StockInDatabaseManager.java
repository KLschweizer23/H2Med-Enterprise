package inventorysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class StockInDatabaseManager 
{
    final private String STOCK_IN_TABLE = "STOCKINTABLE";
    final private String ID = "ID";
    final private String STOCK_IN_ID = "STOCK_IN_ID";
    final private String FK_ITEM_NAME = "FK_ITEM_NAME";
    final private String ITEM_QUANTITY = "ITEM_QUANTITY";
    final private String ITEM_DATE_IN = "ITEM_DATE_IN";
    final private String ITEM_COST = "ITEM_COST";
    final private String ITEM_SUPPLIER = "ITEM_SUPPLIER";
    final private String ITEM_STOCKIN = "ITEM_STOCKIN";
    final private String TRANSACTION_METHOD = "TRANSACTION_METHOD";
    final private String TRANSACTION_STATUS = "TRANSACTION_STATUS";
    final private String TRANSACTION_DUE = "TRANSACTION_DUE";
    final private String TRANSACTION_ID = "TRANSACTION_ID";
    
    private ArrayList<String> idList = new ArrayList<>();
    private ArrayList<String> stockInIdList = new ArrayList<>();
    private ArrayList<String> fkItemNameList = new ArrayList<>();
    private ArrayList<String> itemQuantityList = new ArrayList<>();
    private ArrayList<String> itemDateInList = new ArrayList<>();
    private ArrayList<String> itemCostList = new ArrayList<>();
    private ArrayList<String> itemSupplierList = new ArrayList<>();
    private ArrayList<String> itemStockInList = new ArrayList<>();
    private ArrayList<String> transactionMethodList = new ArrayList<>();
    private ArrayList<Integer> transactionStatusList = new ArrayList<>();
    private ArrayList<String> transactionDueList = new ArrayList<>();
    private ArrayList<Integer> transactionIdList = new ArrayList<>();
    
    private ArrayList<String> distinctId = new ArrayList<String>();
    
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
        PreparedStatement allQuery = con.prepareStatement("SELECT * FROM " + STOCK_IN_TABLE + " ORDER BY " + FK_ITEM_NAME);
        ResultSet result = allQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    private void re_initializeVariables(ResultSet result) throws Exception
    {
        idList.clear();
        stockInIdList.clear();
        fkItemNameList.clear();
        itemQuantityList.clear();
        itemDateInList.clear();
        itemCostList.clear();
        itemSupplierList.clear();
        itemStockInList.clear();
        transactionMethodList.clear();
        transactionStatusList.clear();
        transactionDueList.clear();
        transactionIdList.clear();
        while(result.next())
        {
            idList.add(result.getString(ID));
            stockInIdList.add(result.getString(STOCK_IN_ID));
            fkItemNameList.add(result.getString(FK_ITEM_NAME));
            itemQuantityList.add(result.getString(ITEM_QUANTITY));
            itemDateInList.add(result.getString(ITEM_DATE_IN));
            itemCostList.add(result.getString(ITEM_COST));
            itemSupplierList.add(result.getString(ITEM_SUPPLIER));
            itemStockInList.add(result.getString(ITEM_STOCKIN));
            transactionMethodList.add(result.getString(TRANSACTION_METHOD));
            transactionStatusList.add(result.getInt(TRANSACTION_STATUS));
            transactionDueList.add(result.getString(TRANSACTION_DUE));
            transactionIdList.add(result.getInt(TRANSACTION_ID));
        }
    }
    public void insertData(String _stockInId, String _fkItemName, double _itemQuantity, String _itemDate, double _cost, String _supplier, double _stockIn, String _method, int _status, String _due, int _transaction_id) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement insertQuery = con.prepareStatement("call sp_insertStockInData("+
                _stockInId + "," +
                _fkItemName + "," + 
                _itemQuantity + ",'" +
                _itemDate + "'," +
                _cost + ",'" + 
                _supplier + "'," +
                _stockIn + ", '" +
                _method + "', " +
                _status + ", '" +
                _due + "', " +
                _transaction_id +
                ");");
        insertQuery.executeUpdate();
        processAllData();
        con.close();
    }
    public void getDataBySupplierAndItem(String _supplier, int _id) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement allQuery = con.prepareStatement("SELECT * FROM " + STOCK_IN_TABLE + " WHERE " + ITEM_SUPPLIER + " ='" + _supplier + "' AND " + FK_ITEM_NAME + " = " + _id);
        ResultSet result = allQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    public void updateTransactionStatus(String _supplier, int _id, int _status, String _date) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement updateQuery = con.prepareStatement("UPDATE " + STOCK_IN_TABLE + " SET " + TRANSACTION_STATUS + " = " + _status + ", " + TRANSACTION_DUE + " = '" + _date + "' WHERE " + ITEM_SUPPLIER + " ='" + _supplier + "' AND " + ID + " = " + _id);
        updateQuery.executeUpdate();
        con.close();
    }
    public ArrayList<String> getDistinctId() throws Exception
    {
        distinctId.clear();
        Connection con = getConnection();
        PreparedStatement getQuery = con.prepareStatement("SELECT distinct(" + STOCK_IN_ID + ") from " + STOCK_IN_TABLE + ";");
        ResultSet result = getQuery.executeQuery();
        while(result.next())
        {
            distinctId.add(result.getString(STOCK_IN_ID));
        }
        con.close();
        return distinctId;
    }
    public String getTotalAmount(String client) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement totalQuery = con.prepareStatement("SELECT SUM(" + ITEM_QUANTITY + " * " + ITEM_COST + ") AS TOTAL FROM " + STOCK_IN_TABLE + " WHERE " + ITEM_SUPPLIER + " = '" + client + "' AND " + TRANSACTION_STATUS + " = 1;");
        ResultSet result = totalQuery.executeQuery();
        String resultString = "";
        while(result.next())
        {
            resultString = result.getString("TOTAL");
        }
        return (char)8369 + " " + (resultString == null ? "0.00" : resultString); 
    }
    public HashMap<String, ArrayList<String>> getIncomingInvoices() throws Exception
    {
        String[] keys = {"Dist_Id", "Total", ITEM_SUPPLIER, TRANSACTION_METHOD, TRANSACTION_STATUS, ITEM_DATE_IN, TRANSACTION_DUE};
        
        Connection con = getConnection();
        PreparedStatement getQuery = con.prepareStatement("SELECT DISTINCT(STOCK_IN_ID) AS Dist_Id, SUM(ITEM_COST * ITEM_STOCKIN) AS Total, ITEM_SUPPLIER,TRANSACTION_METHOD,TRANSACTION_STATUS, ITEM_DATE_IN,TRANSACTION_DUE FROM stockintable WHERE TRANSACTION_STATUS = 1 GROUP BY STOCK_IN_ID;");
        ResultSet result = getQuery.executeQuery();
        
        HashMap<String, ArrayList<String>> incomingInvoices = new HashMap<>();
        ArrayList<String> distIdList, totalList, supplierList, methodList, statusList, dateInList, dueList;
        
        ArrayList[] list = 
        {
            distIdList = new ArrayList<>(),
            totalList = new ArrayList<>(),
            supplierList = new ArrayList<>(),
            methodList = new ArrayList<>(),
            statusList = new ArrayList<>(),
            dateInList = new ArrayList<>(),
            dueList = new ArrayList<>()
        };
        
        while(result.next())
        {
            for(int i = 0; i < keys.length; i++)
                list[i].add(result.getString(keys[i]));
        }
        for(int i = 0; i < list.length; i++)
            incomingInvoices.put(keys[i], list[i]);
        return incomingInvoices;
    }
    public double getCostByMonth(int year, int monthInt, int day)
    {
        String month = monthInt < 10 ? "0" + monthInt : monthInt + "";
        String month1 = ++monthInt < 10 ? "0" + monthInt : monthInt + "";
        double cost = 0;
        try
        {
            Connection con = getConnection();
            PreparedStatement getQuery = con.prepareStatement("SELECT SUM(ITEM_COST * ITEM_STOCKIN) AS 'total' FROM stockintable WHERE TRANSACTION_STATUS = 0 AND TRANSACTION_DUE BETWEEN '" + year + "-" + month + "-" + day + "' AND '" + year + "-" + month1 + "-" + day + "';");
            ResultSet result = getQuery.executeQuery();
            while(result.next())
                cost = Double.parseDouble(result.getString("total"));
            con.close();
        }catch(Exception e){System.out.println(e);}
        
        return cost;
    }
    public double getCostByMonth(String fromYear, String toYear)
    {
        double cost = 0;
        try
        {
            Connection con = getConnection();
            PreparedStatement getQuery = con.prepareStatement("SELECT SUM(ITEM_COST * ITEM_STOCKIN) AS 'total' FROM stockintable WHERE TRANSACTION_STATUS = 0 AND TRANSACTION_DUE BETWEEN '" + fromYear + "' AND '" + toYear + "';");
            ResultSet result = getQuery.executeQuery();
            while(result.next())
                cost = Double.parseDouble(result.getString("total"));
            con.close();
        }catch(Exception e){System.out.println(e);}
        
        return cost;
    }
    public ArrayList<String> getIdList()
    {
        return this.idList;
    }    
    public ArrayList<String> getStockInIdList()
    {
        return this.stockInIdList;
    }    
    public ArrayList<String> getFkItemNameList()
    {
        return this.fkItemNameList;
    }    
    public ArrayList<String> getItemQuantityList()
    {
        return this.itemQuantityList;
    }
    public ArrayList<String> getItemDateInList()
    {
        return this.itemDateInList;
    } 
    public ArrayList<String> getItemCostList()
    {
        return this.itemCostList;
    }
    public ArrayList<String> getItemSupplierList()
    {
        return this.itemSupplierList;
    }
    public ArrayList<String> getItemStockInList()
    {
        return this.itemStockInList;
    }
    public ArrayList<String> getTransactionMethodList()
    {
        return this.transactionMethodList;
    }
    public ArrayList<Integer> getTransactionStatusList()
    {
        return this.transactionStatusList;
    }
    public ArrayList<String> getTransactionDueList()
    {
        return this.transactionDueList;
    }
    public ArrayList<Integer> getTransactionIdList()
    {
        return this.transactionIdList;
    }
}