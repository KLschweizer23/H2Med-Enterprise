package inventoryPackage;

/**
 *
 * @author KL_Schweizer
 */
public class ItemObject 
{
    private String id;
    private String i_id;
    private String item;
    private String article;
    private String brand;
    private String price;
    private int stocksLeft;
    private int soldStocks;
    private String soldHistory;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStocksLeft() {
        return stocksLeft;
    }

    public void setStocksLeft(int stocksLeft) {
        this.stocksLeft = stocksLeft;
    }

    public int getSoldStocks() {
        return soldStocks;
    }

    public void setSoldStocks(int soldStocks) {
        this.soldStocks = soldStocks;
    }

    public String getSoldHistory() {
        return soldHistory;
    }

    public void setSoldHistory(String soldHistory) {
        this.soldHistory = soldHistory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getI_id() {
        return i_id;
    }

    public void setI_id(String i_id) {
        this.i_id = i_id;
    }
}
