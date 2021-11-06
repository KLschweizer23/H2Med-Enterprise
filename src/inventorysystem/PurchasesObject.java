
package inventorysystem;

/**
 *
 * @author User
 */
public class PurchasesObject {
    private String date;
    private String supplier;
    private String referenceNumber;
    private String collectionReceipt;
    private String amount;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getCollectionReceipt() {
        return collectionReceipt;
    }

    public void setCollectionReceipt(String collectionReceipt) {
        this.collectionReceipt = collectionReceipt;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
