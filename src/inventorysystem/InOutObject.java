package inventorysystem;
public class InOutObject {
    private String[] ids;
    private String methodOfTransaction;
    private String chequeNumber;
    private String fromOrTo;
    private String amount;
    private String startDate;
    private String dueDate;
    private String info;
    private String status;

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public String getMethodOfTransaction() {
        return methodOfTransaction;
    }

    public void setMethodOfTransaction(String methodOfTransaction) {
        this.methodOfTransaction = methodOfTransaction;
    }

    public String getChequeNumber() {
        return chequeNumber;
    }

    public void setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    public String getFromOrTo() {
        return fromOrTo;
    }

    public void setFromOrTo(String fromOrTo) {
        this.fromOrTo = fromOrTo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
