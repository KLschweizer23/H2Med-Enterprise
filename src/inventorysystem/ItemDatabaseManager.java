package inventorysystem;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class ItemDatabaseManager 
{
    final private String ITEM_TABLE = "ITEMTABLE";
    final private String ITEM_ID = "ITEM_ID";
    final private String ITEM_NAME = "ITEM_NAME";
    final private String ITEM_CATEGORY = "ITEM_CATEGORY";
    final private String ITEM_QUANTITY = "ITEM_QUANTITY";
    final private String ITEM_COST = "ITEM_COST";
    final private String ITEM_PRICE = "ITEM_PRICE";
    final private String ITEM_STOCK_OUT = "ITEM_STOCK_OUT";
    final private String ITEM_SUPPLIER = "ITEM_SUPPLIER";
    final private String ITEM_PURCHASE_DATE = "ITEM_PURCHASE_DATE";
    final private String ITEM_EXPIRATION_DATE = "ITEM_EXPIRATION_DATE";
    final private String ITEM_BRAND = "ITEM_BRAND";
    final private String ITEM_ARTICLE = "ITEM_ARTICLE";
    
    private ArrayList<String> itemIdList = new ArrayList<>();
    private ArrayList<String> itemNameList = new ArrayList<>();
    private ArrayList<String> itemCategoryList = new ArrayList<>();
    private ArrayList<Double> itemQuantityList = new ArrayList<>();
    private ArrayList<Double> itemCostList = new ArrayList<>();
    private ArrayList<Double> itemPriceList = new ArrayList<>();
    private ArrayList<Double> itemStockOutList = new ArrayList<>();
    private ArrayList<String> itemSupplierList = new ArrayList<>();
    private ArrayList<Date> itemPurchaseDateList = new ArrayList<>();
    private ArrayList<Date> itemExpirationDateList = new ArrayList<>();
    private ArrayList<String> itemBrandList = new ArrayList<>();
    private ArrayList<String> itemArticleList = new ArrayList<>();
    
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
    public void processAllData(int sort) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement allQuery;
        
        if(sort == 1)
            allQuery = con.prepareStatement("SELECT * FROM " + ITEM_TABLE);
        else
            allQuery = con.prepareStatement("SELECT * FROM " + ITEM_TABLE + " ORDER BY " + ITEM_STOCK_OUT + " DESC;");
        
        ResultSet result = allQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    public void filterByCategory(String _category, String _supplier, int sort) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement filterQuery = con.prepareStatement("call sp_filterByCategory('" + _category + "','" + _supplier + "', " + sort + ");");
        ResultSet result = filterQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    public void filterBySearch(String keyword, String category, String supplier, int sort) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement filterQuery = con.prepareStatement("call sp_filterBySearch('" + keyword + "', '" + category + "','" + supplier + "', " + sort + ");");
        ResultSet result = filterQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    public void getItemsBySupplier(String _supplier) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement getQuery = con.prepareStatement("SELECT * FROM " + ITEM_TABLE + " WHERE " + ITEM_SUPPLIER + " ='" + _supplier + "'");
        ResultSet result = getQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    public void processItemsByQuantity(boolean asc) throws Exception
    {
        String order = asc ? "ASC" : "DESC";
        
        Connection con = getConnection();
        PreparedStatement getQuery = con.prepareStatement("SELECT * FROM " + ITEM_TABLE + " ORDER BY " + ITEM_QUANTITY + " " + order + " LIMIT 3");
        ResultSet result = getQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    private void re_initializeVariables(ResultSet result) throws Exception
    {
        itemIdList.clear();
        itemNameList.clear();
        itemCategoryList.clear();
        itemQuantityList.clear();
        itemCostList.clear();
        itemPriceList.clear();
        itemStockOutList.clear();
        itemSupplierList.clear();
        itemPurchaseDateList.clear();
        itemExpirationDateList.clear();
        itemBrandList.clear();
        itemArticleList.clear();
        while(result.next())
        {
            itemIdList.add(result.getString(ITEM_ID));
            itemNameList.add(result.getString(ITEM_NAME));
            itemCategoryList.add(result.getString(ITEM_CATEGORY));
            itemQuantityList.add(result.getDouble(ITEM_QUANTITY));
            itemCostList.add(result.getDouble(ITEM_COST));
            itemPriceList.add(result.getDouble(ITEM_PRICE));
            itemStockOutList.add(result.getDouble(ITEM_STOCK_OUT));
            itemSupplierList.add(result.getString(ITEM_SUPPLIER));
            itemPurchaseDateList.add(result.getDate(ITEM_PURCHASE_DATE));
            itemExpirationDateList.add(result.getDate(ITEM_EXPIRATION_DATE));
            itemBrandList.add(result.getString(ITEM_BRAND));
            itemArticleList.add(result.getString(ITEM_ARTICLE));
        }
    }
    public void insertData(String _name, String _category, double _quantity, double _cost, double _price, double _stock_out, String _purchase_date, String _expiration_date, String _supplier, String _brand, String _article) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement insertQuery = con.prepareStatement("call sp_itemInsert('"+
                _name + "','" +
                _category + "'," +
                _quantity + "," +
                _cost + "," +
                _price + "," +
                _stock_out + ",'" +
                _purchase_date + "','" +
                _expiration_date + "','" +
                _supplier + "', '" +
                _brand + "', '" +
                _article + "'" +
                ");");
        insertQuery.executeUpdate();
        processAllData(1);
        con.close();
    }
    public void updateData(int _id, String _name, String _category, double _quantity, double _cost, double _price, double _stock_out, String _purchase_date, String _expiration_date, String _supplier, String _brand, String _article) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement updateQuery = con.prepareStatement("call sp_itemUpdate("+
                _id + ",'" +
                _name + "','" +
                _category + "'," +
                _quantity + "," +
                _cost + "," +
                _price + "," +
                _stock_out + ",'" +
                _purchase_date + "','" +
                _expiration_date + "','" +
                _supplier + "', '" +
                _brand + "', '" +
                _article + "'" +
                ");");
        updateQuery.executeUpdate();
        processAllData(1);
        con.close();
    }
    public void deleteData(int _id) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement deleteQuery = con.prepareStatement("call sp_itemDelete(" + _id + ");");
        deleteQuery.executeUpdate();
        processAllData(1);
        con.close();
    }
    public void updateQuantityById(int _id, double _newVal) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement updateQuery = con.prepareStatement("call sp_updateItemQuantityById(" + _id + ", " + _newVal + ");");
        updateQuery.executeUpdate();
        con.close();
    }
    public void addStockOutById(int _id, double _newVal) throws Exception
    {        
        Connection con = getConnection();
        PreparedStatement addQuery = con.prepareStatement("call sp_addStockOutById(" + _id + ", " + _newVal + ");");
        addQuery.executeUpdate();
        con.close();
    }
    public String returnDataById(String id)
    {
        try
        {
            processAllData(1);
        }catch(Exception e){System.out.println(e);}
        String allData = "";
        for(int i = 0; i < itemIdList.size(); i++)
        {
            if(itemIdList.get(i).equals(id))
            {
                allData = itemNameList.get(i) + "=" +
                        itemCategoryList.get(i) + "=" +
                        itemQuantityList.get(i) + "=" +
                        itemCostList.get(i) + "=" +
                        itemPriceList.get(i) + "=" +
                        itemStockOutList.get(i) + "=" +
                        itemPurchaseDateList.get(i) + "=" +
                        itemExpirationDateList.get(i) + "=" +
                        itemSupplierList.get(i) + "=" +
                        itemBrandList.get(i) + "=" +
                        itemArticleList.get(i);
            }
        }
        return allData;
    }
    public ArrayList<String> getItemIdList()
    {
        return this.itemIdList;
    }
    public ArrayList<String> getItemNameList()
    {
        return this.itemNameList;
    }
    public ArrayList<String> getItemCategoryList()
    {
        return this.itemCategoryList;
    }
    public ArrayList<Double> getItemQuantityList()
    {
        return this.itemQuantityList;
    }
    public ArrayList<Double> getItemCostList()
    {
        return this.itemCostList;
    }
    public ArrayList<Double> getItemPriceList()
    {
        return this.itemPriceList;
    }
    public ArrayList<Double> getItemStockOutList()
    {
        return this.itemStockOutList;
    }
    public ArrayList<Date> getItemPurchaseDateList()
    {
        return this.itemPurchaseDateList;
    }
    public ArrayList<Date> getItemExpirationDateList()
    {
        return this.itemExpirationDateList;
    }
    public ArrayList<String> getItemSupplierList()
    {
        return this.itemSupplierList;
    }
    public ArrayList<String> getItemBrandList()
    {
        return this.itemBrandList;
    }
    public ArrayList<String> getItemArticleList()
    {
        return this.itemArticleList;
    }
}