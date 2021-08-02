package inventorysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SalesDatabaseManager 
{
    final private String SALES_ID = "SALES_ID";
    final private String TOTAL_SALES = "TOTAL_SALES";
    final private String TOTAL_COST = "TOTAL_COST";
    final private String TRANSACTION_DATE = "TRANSACTION_DATE";
    final private String RECORD_MODE = "RECORD_MODE";
    final private String OUTSTANDING = "OUTSTANDING";
    final private String ADDRESS = "ADDRESS";
    
    private ArrayList<Integer> salesIdList = new ArrayList<>();
    private ArrayList<Double> totalSalesList = new ArrayList<>();
    private ArrayList<Double> totalCostList = new ArrayList<>();
    private ArrayList<Double> totalOutstandingList = new ArrayList<>();
    private ArrayList<String> transactionDateList = new ArrayList<>();
    private ArrayList<Integer> recordModeList = new ArrayList<>();
    private ArrayList<String> addressList = new ArrayList<>();
    
    public Connection getConnection() throws Exception
    {
        FileConnectionManager fcm = new FileConnectionManager();
        
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://" + fcm.getConnectionAddress() + ":3306/Inventory_Database";
        String username = "root";
        String password = "umtc";
        Class.forName(driver);
        
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
    public void processAllData() throws Exception
    {
        Connection con = getConnection();
        PreparedStatement allQuery = con.prepareStatement("SELECT * FROM salestable");
        ResultSet result = allQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    public void getDataByMode(int _mode, String _address) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement getQuery;
        if(_address.equals("All"))
            getQuery = con.prepareStatement("SELECT * FROM salestable WHERE " + RECORD_MODE + " = " + _mode);
        else
            getQuery = con.prepareStatement("SELECT * FROM salestable WHERE " + RECORD_MODE + " = " + _mode + " AND " + ADDRESS + " = '" + _address + "'");
        ResultSet result = getQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    private void re_initializeVariables(ResultSet result) throws Exception
    {
        salesIdList.clear();
        totalSalesList.clear();
        totalCostList.clear();
        totalOutstandingList.clear();
        transactionDateList.clear();
        recordModeList.clear();
        addressList.clear();
        while(result.next())
        {
            salesIdList.add(result.getInt(SALES_ID));
            totalSalesList.add(result.getDouble(TOTAL_SALES));
            totalCostList.add(result.getDouble(TOTAL_COST));
            totalOutstandingList.add(result.getDouble(OUTSTANDING));
            transactionDateList.add(result.getString(TRANSACTION_DATE));
            recordModeList.add(result.getInt(RECORD_MODE));
            addressList.add(result.getString(ADDRESS));
        }
    }
    public void insertCost(String _date, double _totalCost) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement costQuery = con.prepareStatement("call sp_insertCostSales('" + _date + "', " + _totalCost + ");");
        costQuery.executeUpdate();
        con.close();
        processAllData();
    }
    public void insertOutstanding(String _date, String _address, double _totalOutstanding, int _invoiceId) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement outstandingQuery = con.prepareStatement("call sp_insertOutstandingSales('" + _date + "', '" + _address + "', " + _totalOutstanding + "," + _invoiceId + ");");
        outstandingQuery.executeUpdate();
        con.close();
        processAllData();
    }
    public void insertSales(int _invoiceId, String _date, double _totalSales, String _address) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement salesQuery = con.prepareStatement("call sp_insertSalesSales(" + _invoiceId + ", '" + _date + "', " + _totalSales + ",'" + _address + "');");
        salesQuery.executeUpdate();
        con.close();
        processAllData();
    }
    public void updateCost(int _id, double _payment, String _supplier) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement updateQuery = con.prepareStatement("UPDATE salestable SET " + TOTAL_COST + " = " + _payment + " WHERE " + SALES_ID + " = " + _id);
        updateQuery.executeUpdate();
        con.close();
    }
    public ArrayList<Integer> getSalesIdList()
    {
        return this.salesIdList;
    }    
    public ArrayList<Double> getTotalSalesList()
    {
        return this.totalSalesList;
    }    
    public ArrayList<Double> getTotalCostList()
    {
        return this.totalCostList;
    }    
    public ArrayList<Double> getOutstandingList()
    {
        return this.totalOutstandingList;
    }    
    public ArrayList<String> getTransactionDateList()
    {
        return this.transactionDateList;
    }    
    public ArrayList<Integer> getRecordModeList()
    {
        return this.recordModeList;
    }    
    public ArrayList<String> getAddressList()
    {
        return this.addressList;
    }
    
    public int getNewestId() throws Exception
    {
        Connection con = getConnection();
        PreparedStatement getQuery = con.prepareStatement("SELECT SALES_ID FROM salestable ORDER BY SALES_ID DESC LIMIT 1");
        ResultSet result = getQuery.executeQuery();
        int id = 0;
        
        while(result.next())
            id = result.getInt(SALES_ID);
        
        return id+1;
    }
}
