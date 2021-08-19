package inventorysystem.InventoryPackage;

import java.util.ArrayList;
import java.util.HashMap;
import myUtilities.DatabaseFunctions;
import myUtilities.MessageHandler;

public class InventoryDatabaseManager {
    
    private final String tablePrefix = "inventory_";
    
    private final String ID = "ID";
    private final String I_ID = "I_ID";
    private final String ITEM = "ITEM";
    private final String ARTICLE = "ARTICLE";
    private final String BRAND = "BRAND";
    private final String PRICE = "PRICE";
    private final String STOCKS_LEFT = "STOCKS_LEFT";
    private final String STOCKS_SOLD = "STOCKS_SOLD";
    private final String SOLD_HISTORY = "SOLD_HISTORY";
    
    private HashMap<String, String> storeList = new HashMap<>();
    
    public HashMap<String, ItemObject> processData(String id, String storeName, String keyword)
    {
        DatabaseFunctions dbf = new DatabaseFunctions();
        HashMap<String, ItemObject> itemList = new HashMap<>();
        
        String[] keys = columnToKeys(false);
        String query = dbf.selectAll() + dbf.from("`" + tablePrefix + id + "_" + storeName + "`") + dbf.where() + ITEM + dbf.like(keyword);
        HashMap<String, ArrayList> map = dbf.customReturnQuery(query, keys);
        for(int i = 0; i < (map.get(ID) == null ? 0 : map.get(ID).size());i++)
        {
            ItemObject item = new ItemObject();
            item.setId(map.get(ID).get(i).toString());
            item.setI_id(map.get(I_ID).get(i).toString());
            item.setItem(map.get(ITEM).get(i).toString());
            item.setArticle(map.get(ARTICLE).get(i).toString());
            item.setBrand(map.get(BRAND).get(i).toString());
            item.setPrice(map.get(PRICE).get(i).toString());
            item.setStocksLeft(Integer.parseInt(map.get(STOCKS_LEFT).get(i).toString()));
            item.setSoldHistory(map.get(SOLD_HISTORY).get(i).toString());
            itemList.put(item.getId(), item);
        }
        return itemList;
    }
    
    public HashMap<String, String> getTables()
    {
        DatabaseFunctions dbf = new DatabaseFunctions();
        
        String[] keys = {"tables"};
        
        String query = dbf.getTables("Inventory_Database", keys[0]) + dbf.and() + "TABLE_NAME " + dbf.like(tablePrefix);
        HashMap<String, ArrayList> map = dbf.customReturnQuery(query, keys);
        
        storeList = new HashMap<>();
        
        for(int i = 0; i < (map.get(keys[0]) == null ? 0 : map.get(keys[0]).size()); i++)
        {
            String incStore = map.get(keys[0]).get(i).toString().substring(tablePrefix.length());
            String id = incStore.split("_")[0];
            String store = incStore.split("_")[1];
            storeList.put(id, store);
        }
        return storeList;
    }
    
    public void newStore(String storeName)
    {
        DatabaseFunctions dbf = new DatabaseFunctions();
        dbf.createTable("`" + tablePrefix + storeName + "`", columnToKeys(true));
    }
    public void deleteStore(String id, String storeName)
    {
        DatabaseFunctions dbf = new DatabaseFunctions();
        dbf.dropTable("`" + tablePrefix + id + "_" + storeName + "`");
    }
    public void insertItem(String id, String storeName, ItemObject io)
    {
        DatabaseFunctions dbf = new DatabaseFunctions();
        dbf.insertData("`" + tablePrefix + id + "_" + storeName + "`", columnToKeys(false), dataToKeys(io, true));
    }
    public void deleteItem(String id, String storeName, ItemObject io)
    {
        DatabaseFunctions dbf = new DatabaseFunctions();
        dbf.deleteData("`" + tablePrefix + id + "_" + storeName + "`", ID, io.getId());
    }
    public void updateItem(String id, String storeName, ItemObject io)
    {
        DatabaseFunctions dbf = new DatabaseFunctions();
        String[] myKeys = {ID, I_ID, ITEM, ARTICLE, BRAND, PRICE, STOCKS_LEFT, STOCKS_SOLD, SOLD_HISTORY};
        dbf.updateData("`" + tablePrefix + id + "_" + storeName + "`", myKeys, dataToKeys(io, false));
    }
    public void addStocks(String id, String storeName, String itemId, double finalStocks)
    {
        DatabaseFunctions dbf = new DatabaseFunctions();
        MessageHandler mh = new MessageHandler();
        
        String query = "UPDATE `" + tablePrefix + id + "_" + storeName + "` SET " + STOCKS_LEFT + " = '" + (int)finalStocks + "' " + dbf.whereEquals(I_ID, itemId); 
        try
        {
            dbf.executeQuery(query);
        }catch(Exception e){mh.error(e.getMessage(), true);System.exit(0);}
    }
    public HashMap<String, String> getItems(String id, String storeName)
    {
        DatabaseFunctions dbf = new DatabaseFunctions();
        String query = "SELECT * FROM `" + tablePrefix + id + "_" + storeName + "` ";
        String[] key = {I_ID, STOCKS_LEFT};
        HashMap<String, ArrayList<String>> map = dbf.customReturnQuery(query, key);
        HashMap<String, String> items = new HashMap<>();
        for(int i = 0; i < (map.get(I_ID) == null ? 0 : map.get(I_ID).size());i++)
            items.put(map.get(I_ID).get(i), map.get(STOCKS_LEFT).get(i));
        return items;
    }
    public String[] columnToKeys(boolean withAttr)
    {
        DatabaseFunctions dbf = new DatabaseFunctions();
        
        String[] keys = {ID, I_ID, ITEM, ARTICLE, BRAND, PRICE, STOCKS_LEFT, STOCKS_SOLD, SOLD_HISTORY};
        String[] keysWithAttr = 
        {
            dbf.makeIntAttr(ID, false, false, true, true),
            dbf.makeIntAttr(I_ID, false, false, false, false),
            dbf.makeVarcharAttr(ITEM, 150, false),
            dbf.makeVarcharAttr(ARTICLE, 150, false),
            dbf.makeVarcharAttr(BRAND, 150, true),
            dbf.makeVarcharAttr(PRICE, 150, true),
            dbf.makeVarcharAttr(STOCKS_LEFT, 150, true),
            dbf.makeVarcharAttr(STOCKS_SOLD, 150, true),
            dbf.makeVarcharAttr(SOLD_HISTORY, 250, true)
        };
        return withAttr ? keysWithAttr : keys;
    }    
    public String[] dataToKeys(ItemObject itemObject, boolean removeFirstItem)
    {
        String[] keysWithId ={
            itemObject.getId(),
            itemObject.getI_id(),
            itemObject.getItem(),
            itemObject.getArticle(),
            itemObject.getBrand(),
            itemObject.getPrice(),
            itemObject.getStocksLeft() + "",
            itemObject.getSoldStocks() + "",
            itemObject.getSoldHistory()
        };
        String[] keys ={
            itemObject.getI_id(),
            itemObject.getItem(),
            itemObject.getArticle(),
            itemObject.getBrand(),
            itemObject.getPrice(),
            itemObject.getStocksLeft() + "",
            itemObject.getSoldStocks() + "",
            itemObject.getSoldHistory()
        };
        return removeFirstItem ? keys : keysWithId;
    }
}
