package inventorysystem;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SupplierDatabaseManager 
{
    final private String suppliertable = "suppliertable";
    final private String ID = "ID";
    final private String NAME = "NAME";
    final private String ADDRESS = "ADDRESS";
    final private String CONTACT_INFO = "CONTACT_INFO";
    
    private ArrayList<Integer> idList = new ArrayList<>();
    private ArrayList<String> nameList = new ArrayList<>();
    private ArrayList<String> addressList = new ArrayList<>();
    private ArrayList<String> contact_infoList = new ArrayList<>();
    
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
        PreparedStatement allQuery = con.prepareStatement("SELECT * FROM " + suppliertable);
        ResultSet result = allQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    private void re_initializeVariables(ResultSet result) throws Exception
    {
        idList.clear();
        nameList.clear();
        addressList.clear();
        contact_infoList.clear();
        while(result.next())
        {
            idList.add(result.getInt(ID));
            nameList.add(result.getString(NAME));
            addressList.add(result.getString(ADDRESS));
            contact_infoList.add(result.getString(CONTACT_INFO));
        }
    }
    public void insertData(String _name, String _address, String _contactInfo) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement insertQuery = con.prepareStatement("call sp_supplierInsert('"
                + _name + "', '"
                + _address + "', '"
                + _contactInfo + "'"
                + ")");
        insertQuery.executeUpdate();
        con.close();
        processAllData();
    }
    public void updateData(int _id, String _name, String _address, String _contactInfo) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement updateQuery = con.prepareStatement("call sp_supplierUpdate("
                + _id + ", '"
                + _name + "', '"
                + _address + "', '"
                + _contactInfo + "'"
                + ")");
        updateQuery.executeUpdate();
        con.close();
        processAllData();
    }
    public void deleteData(int _id) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement deleteQuery = con.prepareStatement("call sp_supplierDelete(" + _id + ");");
        deleteQuery.executeUpdate();
        con.close();
        processAllData();
    }
    public String returnDataById(int id)
    {
        try
        {
            processAllData();
        }catch(Exception e){System.out.println(e);}
        String allData = "";
        for(int i = 0; i < idList.size(); i++)
        {
            if(idList.get(i) == id)
            {
                allData = nameList.get(i) + "=" +
                        addressList.get(i) + "=" +
                        contact_infoList.get(i);
            }
        }
        return allData;
    }
    public ArrayList<Integer> getIdList()
    {
        return this.idList;
    }
    public ArrayList<String> getNameList()
    {
        return this.nameList;
    }
    public ArrayList<String> getAddressList()
    {
        return this.addressList;
    }
    public ArrayList<String> getContactInfoList()
    {
        return this.contact_infoList;
    }
}