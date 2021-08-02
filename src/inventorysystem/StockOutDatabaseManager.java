package inventorysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StockOutDatabaseManager {

    final private String STOCK_OUT_TABLE = "STOCKOUTTABLE";
    final private String ID = "ID";
    final private String STOCK_OUT_ID = "STOCK_OUT_ID";
    final private String FK_ITEM_NAME = "FK_ITEM_NAME";
    final private String ITEM_QUANTITY = "ITEM_QUANTITY";
    final private String ITEM_DATE_OUT = "ITEM_DATE_OUT";
    final private String STOCK_ADDRESS = "STOCK_ADDRESS";
    final private String ITEM_COST = "ITEM_COST";
    final private String ITEM_PRICE = "ITEM_PRICE";
    final private String ITEM_SUPPLIER = "ITEM_SUPPLIER";
    
    private ArrayList<String> idList = new ArrayList<>();
    private ArrayList<String> stockOutIdList = new ArrayList<>();
    private ArrayList<String> fkItemNameList = new ArrayList<>();
    private ArrayList<String> itemQuantityList = new ArrayList<>();
    private ArrayList<String> itemDateInList = new ArrayList<>();
    private ArrayList<String> stockAddressList = new ArrayList<>();
    private ArrayList<String> itemCostList = new ArrayList<>();
    private ArrayList<String> itemPriceList = new ArrayList<>();
    private ArrayList<String> itemSupplierList = new ArrayList<>();
    
    private ArrayList<String> distinctIdList = new ArrayList<>();
    
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
        PreparedStatement allQuery = con.prepareStatement("SELECT * FROM " + STOCK_OUT_TABLE);
        ResultSet result = allQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    private void re_initializeVariables(ResultSet result) throws Exception
    {
        idList.clear();
        stockOutIdList.clear();
        fkItemNameList.clear();
        itemQuantityList.clear();
        itemDateInList.clear();
        stockAddressList.clear();
        itemCostList.clear();
        itemPriceList.clear();
        itemSupplierList.clear();
        while(result.next())
        {
            idList.add(result.getString(ID));
            stockOutIdList.add(result.getString(STOCK_OUT_ID));
            fkItemNameList.add(result.getString(FK_ITEM_NAME));
            itemQuantityList.add(result.getString(ITEM_QUANTITY));
            itemDateInList.add(result.getString(ITEM_DATE_OUT));
            stockAddressList.add(result.getString(STOCK_ADDRESS));
            itemCostList.add(result.getString(ITEM_COST));
            itemPriceList.add(result.getString(ITEM_PRICE));
            itemSupplierList.add(result.getString(ITEM_SUPPLIER));
        }
    }
    public void insertData(String _stockOutId, String _fkItemName, double _itemQuantity, String _itemDate, String _address, double _cost, double _price, String _supplier) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement insertQuery = con.prepareStatement("call sp_insertStockOutData("+
                _stockOutId + "," +
                _fkItemName + "," + 
                _itemQuantity + ",'" +
                _itemDate + "','" +
                _address + "', " +
                _cost + ", " + 
                _price + ", '" +
                _supplier + "'" +
                ");");
        insertQuery.executeUpdate();
        con.close();
        processAllData();
    }
    public ArrayList<String> getDistinctId() throws Exception
    {
        distinctIdList.clear();
        Connection con = getConnection();
        PreparedStatement getQuery = con.prepareStatement("SELECT distinct(" + STOCK_OUT_ID + ") from " + STOCK_OUT_TABLE + ";");
        ResultSet result = getQuery.executeQuery();
        while(result.next())
        {
            distinctIdList.add(result.getString(STOCK_OUT_ID));
        }
        con.close();
        return distinctIdList;
    }
    public ArrayList<String> getIdList()
    {
        return this.idList;
    }    
    public ArrayList<String> getStockInIdList()
    {
        return this.stockOutIdList;
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
    public ArrayList<String> getStockAddress()
    {
        return this.stockAddressList;
    }
    public ArrayList<String> getCostList()
    {
        return this.itemCostList;
    }
    public ArrayList<String> getPriceList()
    {
        return this.itemPriceList;
    }
    public ArrayList<String> getSupplierList()
    {
        return this.itemSupplierList;
    }
}