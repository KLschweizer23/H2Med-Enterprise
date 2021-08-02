package inventorysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CollectionDatabaseManager {
    private final String TABLE = "collectiontable";
    private final String ID = "ID";
    private final String COLLECTION = "COLLECTION";
    private final String RECEIVED = "RECEIVED";
    private final String ADDRESS = "ADDRESS";
    private final String SUM_TOTAL = "SUM_TOTAL";
    private final String PAYMENT_FOR = "PAYMENT_FOR";
    private final String CHECK_NUM = "CHECK_NUM";
    private final String BANK = "BANK";
    private final String CDATE = "CDATE";
    private final String INVOICE = "INVOICE";
    
    private ArrayList<Integer> idList = new ArrayList<>();
    private ArrayList<Integer> collectionList = new ArrayList<>();
    private ArrayList<String> receivedList = new ArrayList<>();
    private ArrayList<String> addressList = new ArrayList<>();
    private ArrayList<Double> sumList = new ArrayList<>();
    private ArrayList<String> paymentList = new ArrayList<>();
    private ArrayList<String> checkList = new ArrayList<>();
    private ArrayList<String> bankList = new ArrayList<>();
    private ArrayList<String> dateList = new ArrayList<>();
    private ArrayList<Integer> invoiceList = new ArrayList<>();

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
        PreparedStatement allQuery = con.prepareStatement("SELECT * FROM " + TABLE);
        ResultSet result = allQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    
    private void re_initializeVariables(ResultSet result) throws Exception
    {
        idList.clear();
        collectionList.clear();
        receivedList.clear();
        addressList.clear();
        sumList.clear();
        paymentList.clear();
        checkList.clear();
        bankList.clear();
        dateList.clear();
        invoiceList.clear();
        while(result.next())
        {
            idList .add(result.getInt(ID));
            collectionList .add(result.getInt(COLLECTION));
            receivedList .add(result.getString(RECEIVED));
            addressList .add(result.getString(ADDRESS));
            sumList .add(result.getDouble(SUM_TOTAL));
            paymentList .add(result.getString(PAYMENT_FOR));
            checkList .add(result.getString(CHECK_NUM));
            bankList .add(result.getString(BANK));
            dateList .add(result.getString(CDATE));
            invoiceList .add(result.getInt(INVOICE));
        }
    }
    
    public void insertData(int _collection, String _received, String _address, double _sum, String _payment, String _check, String _bank, String _date, int _invoice) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement insertQuery = con.prepareStatement("call sp_insertCollection("
                + "" + _collection 
                + ",'" + _received
                + "','" + _address
                + "'," + _sum
                + ",'" + _payment
                + "','" + _check
                + "','" + _bank
                + "','" + _date
                + "'," + _invoice
                + ");");
        insertQuery.executeUpdate();
        con.close();
        processAllData();
    }
    
    public void updateData(int _collection, String _received, String _address, double _sum, String _payment, String _check, String _bank, String _date, int _invoice) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement insertQuery = con.prepareStatement("UPDATE " + TABLE + " SET " + 
                RECEIVED + " = '" + _received + "', " + 
                ADDRESS + " = '" + _address + "', " + 
                SUM_TOTAL + " = " + _sum + ", " +
                PAYMENT_FOR + " = '" + _payment + "'," +
                CHECK_NUM + " = '" + _check + "', " +
                BANK + " = '" + _bank + "', " + 
                CDATE + " = '" + _date + "' " + 
                "WHERE " + COLLECTION + " = " + _collection + " AND " + INVOICE + " = " + _invoice
                );
        insertQuery.executeUpdate();
        con.close();
        processAllData();
    }
        
    public void getDataByReceipt(int _receiptNumber) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement getQuery = con.prepareStatement("SELECT * FROM " + TABLE + " WHERE " + COLLECTION + " = " + _receiptNumber);
        ResultSet result = getQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    
    public boolean isReceiptExist(int _receiptNumber) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement getQuery = con.prepareStatement("SELECT IFNULL((SELECT " + COLLECTION + " FROM " + TABLE + " WHERE " + COLLECTION + " = " + _receiptNumber + "), 0) as result;");
        ResultSet result = getQuery.executeQuery();
        
        boolean returnValue = true;
        
        while(result.next())
        {
            System.out.println(result.getInt("result"));
            if(result.getInt("result") == 0)
                returnValue = false;
        }
        
        con.close();
        return returnValue;
    }
    
    public ArrayList<Integer> getIdList() {
        return idList;
    }

    public ArrayList<Integer> getCollectionList() {
        return collectionList;
    }

    public ArrayList<String> getReceivedList() {
        return receivedList;
    }

    public ArrayList<String> getAddressList() {
        return addressList;
    }

    public ArrayList<Double> getSumList() {
        return sumList;
    }

    public ArrayList<String> getPaymentList() {
        return paymentList;
    }

    public ArrayList<String> getCheckList() {
        return checkList;
    }

    public ArrayList<String> getBankList() {
        return bankList;
    }

    public ArrayList<String> getDateList() {
        return dateList;
    }

    public ArrayList<Integer> getInvoiceList() {
        return invoiceList;
    }
}
