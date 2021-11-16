
package inventorysystem;

/**
 *
 * @author User
 */
public class SalesObject {
    private String date;
    private String customer;
    private String invoiceNumber;
    private String totalPurchase;
    private String collectionReceipt;
    private Double paid;
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getTotalPurchase() {
        return totalPurchase;
    }

    public void setTotalPurchase(String totalPurchase) {
        this.totalPurchase = totalPurchase;
    }

    public String getCollectionReceipt() {
        return collectionReceipt;
    }

    public void setCollectionReceipt(String collectionReceipt) {
        this.collectionReceipt = collectionReceipt;
    }

    public Double getPaid() {
        return paid;
    }

    public void setPaid(Double paid) {
        this.paid = paid;
    }
}
