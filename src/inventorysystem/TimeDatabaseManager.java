package inventorysystem; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class TimeDatabaseManager 
{
    final private String TIMETABLE = "TIMETABLE";
    final private String ID = "ID";
    final private String INFO = "INFO";
    final private String SELECTED_TIME = "SELECTED_TIME";
    
    private ArrayList<String> id = new ArrayList<String>();
    private ArrayList<String> info = new ArrayList<String>();
    private ArrayList<String> selectedTime = new ArrayList<String>();
    
    private int dayInterval = 0;
    
    private int day = 0;
    private int month = 0;
    private int year = 0;
    
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
        PreparedStatement allQuery;
        
        allQuery = con.prepareStatement("SELECT * FROM " + TIMETABLE);
        
        ResultSet result = allQuery.executeQuery();
        re_initializeVariables(result);
        con.close();
    }
    private void re_initializeVariables(ResultSet result) throws Exception
    {
        id.clear();
        info.clear();
        selectedTime.clear();
        while(result.next())
        {
            id.add(result.getString(ID));
            info.add(result.getString(INFO));
            selectedTime.add(result.getString(SELECTED_TIME));
        }
    }
    public void processDateData() throws Exception
    {
        processAllData();
        
        String startDate = selectedTime.get(0);
        
        startDate = startDate.substring(0,10);
        
        String[] data = startDate.split("-");
        year = Integer.parseInt(data[0]);
        month = Integer.parseInt(data[1]);
        day = Integer.parseInt(data[2]);
    }
    public int getDayInterval(String date)
    {
        try{
            processDateData();
        }catch(Exception e){System.out.println(e + "/");}
        
        LocalDate dateBefore = LocalDate.parse(selectedTime.get(0).substring(0, 10));
        LocalDate dateAfter = LocalDate.parse(date.substring(0, 10));
        
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
        
        return (int)noOfDaysBetween;
    }
}