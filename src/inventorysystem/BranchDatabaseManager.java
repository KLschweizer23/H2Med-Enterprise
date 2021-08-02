package inventorysystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class BranchDatabaseManager 
{
    final private String BRANCH_TABLE = "BRANCHTABLE";
    final private String BRANCH_ID = "BRANCH_ID";
    final private String BRANCH_NAME = "BRANCH_NAME";
    final private String BRANCH_ADDRESS = "BRANCH_ADDRESS";
    
    private ArrayList<String> branchIdList = new ArrayList<String>();
    private ArrayList<String> branchNameList = new ArrayList<String>();
    private ArrayList<String> branchAddressList = new ArrayList<String>();
    
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
        PreparedStatement allQuery = con.prepareStatement("SELECT * FROM " + BRANCH_TABLE);
        ResultSet result = allQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    private void re_initializeVariables(ResultSet result) throws Exception
    {
        branchIdList.clear();
        branchNameList.clear();
        branchAddressList.clear();
        while(result.next())
        {
            branchIdList.add(result.getString(BRANCH_ID));
            branchNameList.add(result.getString(BRANCH_NAME));
            branchAddressList.add(result.getString(BRANCH_ADDRESS));
        }
    }
    public void insertData(String _name, String _address) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement insertQuery = con.prepareStatement("call sp_branchInsert('"+
                _name + "','" +
                _address + "');");
        insertQuery.executeUpdate();
        con.close();
        processAllData();
    }
    public void updateData(int _id, String _name, String _address) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement insertQuery = con.prepareStatement("call sp_branchUpdate("+
                _id + ",'" +
                _name + "','" +
                _address + "');");
        insertQuery.executeUpdate();
        con.close();
        processAllData();
    }
    public void deleteData(int _id) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement deleteQuery = con.prepareStatement("call sp_branchDelete(" + _id + ");");
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
        for(int i = 0; i < branchIdList.size(); i++)
        {
            if(branchIdList.get(i).equals(id))
            {
                allData = branchNameList.get(i) + "=" +
                        branchAddressList.get(i);
                System.out.println(allData);
            }
        }
        return allData;
    }
    public ArrayList<String> getBranchIdList()
    {
        return this.branchIdList;
    }
    public ArrayList<String> getBranchNameList()
    {
        return this.branchNameList;
    }
    public ArrayList<String> getBranchAddressList()
    {
        return this.branchAddressList;
    }
}