package inventorysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClientDatabaseManager {
    final private String CLIENT_TABLE = "CLIENTTABLE";
    final private String CLIENT_ID = "CLIENT_ID";
    final private String CLIENT_NAME = "CLIENT_NAME";
    final private String CLIENT_ADDRESS = "CLIENT_ADDRESS";
    final private String CLIENT_CONTACT = "CLIENT_CONTACT";
    
    private ArrayList<String> clientIdList = new ArrayList<String>();
    private ArrayList<String> clientNameList = new ArrayList<String>();
    private ArrayList<String> clientAddressList = new ArrayList<String>();
    private ArrayList<String> clientContactList = new ArrayList<String>();
    
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
        PreparedStatement allQuery = con.prepareStatement("SELECT * FROM " + CLIENT_TABLE + " ORDER BY " + CLIENT_NAME + " ASC");
        ResultSet result = allQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    private void re_initializeVariables(ResultSet result) throws Exception
    {
        clientIdList.clear();
        clientNameList.clear();
        clientAddressList.clear();
        clientContactList.clear();
        while(result.next())
        {
            clientIdList.add(result.getString(CLIENT_ID));
            clientNameList.add(result.getString(CLIENT_NAME));
            clientAddressList.add(result.getString(CLIENT_ADDRESS));
            clientContactList.add(result.getString(CLIENT_CONTACT));
        }
    }
    public void insertData(String _name, String _address, String _contact) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement insertQuery = con.prepareStatement("call sp_clientInsert('"+
                _name + "','" +
                _address + "','" + 
                _contact + "');");
        insertQuery.executeUpdate();
        con.close();
        processAllData();
    }
    public void updateData(int _id, String _name, String _address, String _contact) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement insertQuery = con.prepareStatement("call sp_clientUpdate("+
                _id + ",'" +
                _name + "','" +
                _address + "','"+
                _contact + "');");
        insertQuery.executeUpdate();
        con.close();
        processAllData();
    }
    public void deleteData(int _id) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement deleteQuery = con.prepareStatement("call sp_clientDelete(" + _id + ");");
        deleteQuery.executeUpdate();
        con.close();
        processAllData();
    }
    public String returnDataById(String id)
    {
        try
        {
            processAllData();
        }catch(Exception e){System.out.println(e);}
        String allData = "";
        for(int i = 0; i < clientIdList.size(); i++)
        {
            if(clientIdList.get(i).equals(id))
            {
                allData = clientNameList.get(i) + "=" +
                        clientAddressList.get(i) + "=" + 
                        clientContactList.get(i);
            }
        }
        return allData;
    }
    
    public ArrayList<String> getClientIdList()
    {
        return this.clientIdList;
    }
    public ArrayList<String> getClientNameList()
    {
        return this.clientNameList;
    }
    public ArrayList<String> getClientAddressList()
    {
        return this.clientAddressList;
    }
    public ArrayList<String> getClientContactList()
    {
        return this.clientContactList;
    }
}