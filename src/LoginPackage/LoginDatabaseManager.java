
package LoginPackage;

import java.util.ArrayList;
import java.util.HashMap;
import myUtilities.DatabaseFunctions;

public class LoginDatabaseManager {
    private final String table = "loginTable";
    
    private final String ID = "ID";
    private final String USERNAME = "USERNAME";
    private final String PASSWORD = "PASSWORD";
    private final String ROLE = "ROLE";
    
    private final String adminUser = "admin";
    private final String adminPass = "kladmin";
    
    private HashMap<String, LoginObject> logs = new HashMap<>();
    
    public LoginDatabaseManager()
    {
        DatabaseFunctions dbf = new DatabaseFunctions();
        dbf.createTable(table, columnToKeys(true));
    }
    public HashMap<String, LoginObject> processData()
    {
        logs.clear();
        
        DatabaseFunctions dbf = new DatabaseFunctions();
        String[] keys = columnToKeys(false);
        
        HashMap<String, ArrayList> map = dbf.selectAllData(table, keys, "", 0, ID, true);
        for(int i = 0; i < (map.get(ID) == null ? 0 : map.get(ID).size()); i++)
        {
            LoginObject log = new LoginObject();
            String id = map.get(ID).get(i).toString();
            
            log.setId(id);
            log.setUsername(map.get(USERNAME).get(i).toString());
            log.setPassword(map.get(PASSWORD).get(i).toString());
            log.setRole(map.get(ROLE).get(i).toString());
            logs.put(id, log);
        }
        return logs;
    }
    public void insertData(LoginObject log)
    {
        DatabaseFunctions df = new DatabaseFunctions();
        df.insertData(table, columnToKeys(false), dataToKeys(log, true));
    }
    public LoginObject checkAccount(String user, char[] password)
    {
        processData();
        boolean accountExist = false;
        String id = "";
        for(String idArr : logs.keySet())
        {
            accountExist = true;
            id = idArr;
            if(logs.get(idArr).getPassword().length() == password.length && logs.get(idArr).getUsername().equals(user))
                for(int j = 0; j < password.length; j++)
                {
                    if(password[j] != logs.get(idArr).getPassword().charAt(j))
                        accountExist = false;
                }
            else accountExist = false;
        }
        if(accountExist) return logs.get(id);
        else return null;
    }
    public String[] dataToKeys(LoginObject lo, boolean removeFirstItem)
    {
        String[] keysWithId ={
            lo.getId(),
            lo.getUsername(),
            lo.getPassword(),
            lo.getRole()
        };
        String[] keys ={
            lo.getUsername(),
            lo.getPassword(),
            lo.getRole()
        };
        return removeFirstItem ? keys : keysWithId;
    }
    public String[] columnToKeys(boolean withAttr)
    {
        DatabaseFunctions dbf = new DatabaseFunctions();
        
        String[] keys = {ID, USERNAME, PASSWORD, ROLE};
        String[] keysWithAttr = 
        {
            dbf.makeIntAttr(ID, false, false, true, true),
            dbf.makeVarcharAttr(USERNAME, 150, false),
            dbf.makeVarcharAttr(PASSWORD, 150, false),
            dbf.makeVarcharAttr(ROLE, 150, false),
        };
        return withAttr ? keysWithAttr : keys;
    }

    public String getAdminUser() {
        return adminUser;
    }

    public String getAdminPass() {
        return adminPass;
    }
}
