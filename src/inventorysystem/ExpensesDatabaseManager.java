package inventorysystem;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesDatabaseManager {
    final private String table = "expensesTable";
    final private String ID = "ID";
    final private String DATE = "DATE";
    final private String PARTICULARS = "PARTICULARS";
    final private String AMOUNT = "AMOUNT";
    final private String REASON = "REASON";
    final private String OTHERREASON = "OTHERREASON";
    final private String PAID = "PAID";
    final private String METHOD = "METHOD";
    final private String DUEDATE = "DUEDATE";
    
    private ArrayList<ExpensesObject> eoList = new ArrayList<>();
    
    public ExpensesDatabaseManager()
    {
        try
        {
            Connection con = getConnection();
            PreparedStatement createQuery = con.prepareStatement("CREATE TABLE IF NOT EXISTS " + table +" (" +
            "  " + ID +" INTEGER UNSIGNED NOT NULL AUTO_INCREMENT," +
            "  " + DATE + " VARCHAR(150) NOT NULL," +
            "  " + PARTICULARS + " VARCHAR(150) NOT NULL," +
            "  " + AMOUNT + " VARCHAR(150) NOT NULL," +
            "  " + REASON + " VARCHAR(150) NOT NULL," +
            "  " + OTHERREASON + " VARCHAR(255) NOT NULL," +
            "  " + PAID + " BOOLEAN NOT NULL," +
            "  " + METHOD + " VARCHAR(20) NOT NULL," +
            "  " + DUEDATE + " VARCHAR(150) NOT NULL," +
            "  PRIMARY KEY (" + ID + ")" +
            ")");
            createQuery.executeUpdate();
            con.close();
        }catch(Exception e){System.out.println(e);}
    }
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
    public void insertExpenses(ExpensesObject eo) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement insertQuery = con.prepareStatement("INSERT INTO " + table + " (" 
                + DATE 
                + "," + PARTICULARS
                + "," + AMOUNT 
                + "," + REASON 
                + "," + OTHERREASON 
                + "," + PAID 
                + "," + METHOD 
                + "," + DUEDATE 
                + ") VALUES ("
                + "'" + eo.getDate() + "',"
                + "'" + goodString(eo.getParticulars()) + "',"
                + "'" + eo.getAmount() + "',"
                + "'" + goodString(eo.getReason()) + "',"
                + "'" + goodString(eo.getOtherReason()) + "',"
                + "'" + (eo.isPaid() ? "1" : "0") + "',"
                + "'" + eo.getMethod() + "',"
                + "'" + eo.getDueDate()+ "'"
                + ")");
        insertQuery.executeUpdate();
        con.close();
    }
    public void deleteExpense(int id) throws Exception
    {
        Connection con = getConnection();
        PreparedStatement insertQuery = con.prepareStatement("DELETE FROM " + table + " WHERE " + ID + " = " + id);
        insertQuery.executeUpdate();
        con.close();
    }
    public ArrayList<ExpensesObject> getListObject()
    {
        try{
            Connection con = getConnection();
            PreparedStatement getQuery = con.prepareStatement("Select * from " + table);
            ResultSet result = getQuery.executeQuery();
            while(result.next())
            {
                ExpensesObject eo = new ExpensesObject();
                eo.setId(result.getString(ID));
                eo.setDate(result.getString(DATE));
                eo.setParticulars(result.getString(PARTICULARS));
                eo.setAmount(result.getString(AMOUNT));
                eo.setReason(result.getString(REASON));
                eo.setOtherReason(result.getString(OTHERREASON));
                eo.setPaid(result.getBoolean(PAID));
                eo.setMethod(result.getString(METHOD));
                eo.setDueDate(result.getString(DUEDATE));
                eoList.add(eo);
            }
        }catch(Exception e){System.out.println(e);}
        return eoList;
    }
    public double getExpenses()
    {
        double expenses = 0;
        try
        {
            Connection con = getConnection();
            PreparedStatement getQuery = con.prepareStatement("SELECT SUM(" + AMOUNT + ") AS total FROM " + table);
            ResultSet result = getQuery.executeQuery();
            while(result.next())
                expenses = result.getDouble("total");
        }catch(Exception e){System.out.println(e);}
        
        return expenses;
    }
    public double getExpenses(String year, String month, String day)
    {
        double expenses = 0;
        
        String from = year + "-" + (Integer.parseInt(month) < 10 ? "0" + (Integer.parseInt(month)) : Integer.parseInt(month)) + "-00";
        String to = year + "-" + (Integer.parseInt(month) + 1 < 10 ? "0" + (Integer.parseInt(month) + 1) : Integer.parseInt(month) + 1) + "-00";
        
        try
        {
            Connection con = getConnection();
            PreparedStatement getQuery = con.prepareStatement("SELECT SUM(" + AMOUNT + ") AS total FROM " + table + " WHERE " + DATE + " BETWEEN '" + from + "' AND '" + to + "'");
            ResultSet result = getQuery.executeQuery();
            while(result.next())
                expenses = result.getDouble("total");
        }catch(Exception e){System.out.println(e);}
        
        return expenses;
    }
    public String getMostExpenses()
    {        
        String amount = "";
        String part = "";
        try
        {
            Connection con = getConnection();
            PreparedStatement getQuery = con.prepareStatement("SELECT SUM(AMOUNT) AS total, PARTICULARS FROM expensestable GROUP BY PARTICULARS ORDER BY total DESC LIMIT 1;");
            ResultSet result = getQuery.executeQuery();
            while(result.next())
            {
                amount = result.getString("total");
                part = result.getString(PARTICULARS);
            }
        }catch(Exception e){System.out.println(e);}
        return amount + "`" + part;
    }
    private String goodString(String data)
    {
        String temp = data.replaceAll("'", "\\\\'");
        return temp;
    }
}
