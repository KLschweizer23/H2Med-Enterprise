package inventorysystem;

import java.util.ArrayList;

public class StatementOfAccount 
{
    private ArrayList<Invoices> allList = new ArrayList<>();
    ArrayList<Integer> invoices = new ArrayList<>();
    private String client;
    
    private ArrayList<Integer> invoice = new ArrayList<>();
    private ArrayList<Integer> purchase = new ArrayList<>();
    private ArrayList<Integer> delivery = new ArrayList<>();
    private ArrayList<String> dateOfInvoice = new ArrayList<>();
    private ArrayList<String> details = new ArrayList<>();
    private ArrayList<Double> quantity = new ArrayList<>();
    private ArrayList<String> item = new ArrayList<>();
    private ArrayList<Double> amount = new ArrayList<>();
    private ArrayList<Double> totalAmount = new ArrayList<>();
    
    private Double allTotalAmount = 0.0;
    
    public ArrayList<Invoices> GetStatementOfAccount(String client)
    {
        this.client = client;
        prepareList();
        return allList;
    }
    private void prepareList()
    {
        //Get All The Invoice Numbers (Distinct)
        invoices = getDistinctInvoices();
        System.out.println(invoices + "--invoices");
        //Get Data Per Invoice Number
        for(int i = 0; i < invoices.size(); i++)
        {
            //Get Data of The Invoice Number
            processData(invoices.get(i));
            Invoices invFirst = new Invoices();
            invFirst.setInvoice(invoice.get(0) + "");
            invFirst.setPurchase(purchase.get(0) + "");
            invFirst.setDelivery(delivery.get(0) + "");
            invFirst.setDateOfInvoice(goodDate(dateOfInvoice.get(0)));
            invFirst.setDetails(details.get(0));
            invFirst.setQuantity("");
            invFirst.setItem("");
            invFirst.setAmount("");
            invFirst.setTotalAmount("");
            allList.add(invFirst);
            
            double OverAllTotalAmount = 0;
            
            for(int j = 0; j < invoice.size(); j++)
            {
                Invoices inv = new Invoices();
                inv.setInvoice("");
                inv.setPurchase("");
                inv.setDelivery("");
                inv.setDateOfInvoice("");
                inv.setDetails("");
                inv.setQuantity(quantity.get(j) + "");
                inv.setItem(item.get(j));
                inv.setAmount((char)8369 + " " + amount.get(j));
                inv.setTotalAmount((char)8369 + " " + totalAmount.get(j));
                OverAllTotalAmount += totalAmount.get(j);
                allTotalAmount += totalAmount.get(j);
                System.out.println(totalAmount.get(j) + " - " + OverAllTotalAmount + " -- " + allTotalAmount);
                allList.add(inv);
            }
            allList.add(customInv("TOTAL", (char)8369 + " " + OverAllTotalAmount, false));
            allList.add(customInv("- - / - -", "- - / - -", true));
        }
    }
    private String goodDate(String date)
    {
        date = date.substring(0,11);
        String[] data = date.split("-");
        String years = data[0];
        String month = data[1];
        String day = data[2].charAt(0) == '0' ? data[2].charAt(1) + "" : data[2];
        switch(Integer.parseInt(month))
        {
            case 1: month = "Jan"; break; case 2: month = "Feb"; break; case 3: month = "Mar"; break;
            case 4: month = "Apr"; break; case 5: month = "May"; break; case 6: month = "Jun"; break;
            case 7: month = "Jul"; break; case 8: month = "Aug"; break; case 9: month = "Sep"; break;
            case 10: month = "Oct"; break; case 11: month = "Nov"; break; case 12: month = "Dec"; break;
        }
        return month + " " + day + ", " + years;
    }
    private Invoices customInv(String totalString, String Total, boolean isBlank)
    {
        Invoices blank = new Invoices();
        String x = isBlank ? "- - / - -" : "";
        blank.setInvoice(x);
        blank.setPurchase(x);
        blank.setDelivery(x);
        blank.setDateOfInvoice(x);
        blank.setDetails(x);
        blank.setQuantity(x);
        blank.setItem(x);
        blank.setAmount(totalString);
        blank.setTotalAmount(Total);
        return blank;
    }
    private void processData(int invoiceId)
    {
        invoice.clear();
        purchase.clear();
        delivery.clear();
        dateOfInvoice.clear();
        details.clear();
        quantity.clear();
        item.clear();
        amount.clear();
        totalAmount.clear();
        InvoiceDatabaseManager invoiceDb = new InvoiceDatabaseManager();
        try
        {
            invoiceDb.getItemsByInvoiceNumber(invoiceId, client);
        }catch(Exception e){System.out.println(e);}
        invoice = invoiceDb.getInvoiceNumberList();
        purchase = invoiceDb.getPurchaseNumberList();
        delivery = invoiceDb.getDeliveryNumberList();
        dateOfInvoice = invoiceDb.getInvoiceDateList();
        
        for(int i = 0; invoice != null && i < invoice.size(); i++)
        {
            String addData = invoiceDb.getItemChequeList().get(i).charAt(0) == 'C' && invoiceDb.getItemDueDateList().get(i).charAt(0) == '-'
                    ? "Cash"
                    : "Cheque #: " + invoiceDb.getItemChequeList().get(i) + ", due on " + invoiceDb.getItemDueDateList().get(i)
                    ;
            details.add(addData);
        }
                
        quantity = invoiceDb.getQuantityList();
        item = invoiceDb.getItemsList();
        amount = invoiceDb.getPriceList();
        
        for(int i = 0; i < item.size(); i++)
            totalAmount.add(quantity.get(i) * amount.get(i));
    }
    private ArrayList<Integer> getDistinctInvoices()
    {
        InvoiceDatabaseManager invoiceDb = new InvoiceDatabaseManager();
        ArrayList<Integer> invList = new ArrayList<>();
        try
        {
            invList = invoiceDb.getDistinctInvoiceNumber(client);
        }catch(Exception e){System.out.println(e);}
        return invList;
    }

    public Integer getInvoiceTotal() {
        return invoices.size();
    }

    public Double getAllTotalAmount() {
        return allTotalAmount;
    }
    
}
