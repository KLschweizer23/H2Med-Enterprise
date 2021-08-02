package inventorysystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class SystemStatusManager
{
    public ArrayList<String> getMostItemSales()
    {
        InvoiceDatabaseManager invoiceDb = new InvoiceDatabaseManager();
        try
        {
            invoiceDb.processMostSales();
        }catch(Exception e){System.out.println(e);System.exit(0);}
        
        ArrayList<String> itemName = invoiceDb.getItemsList();
        ArrayList<Integer> result = invoiceDb.getItemResultList();
        ArrayList<String> itemSupplier = invoiceDb.getItemSupplierList();
        
        ArrayList<String> allData = new ArrayList<>();
        
        for(int i = 0; i < itemName.size(); i++)
            allData.add(itemName.get(i) + " from " + itemSupplier.get(i)+ " - " + result.get(i) + " time/s");
        
        return allData;
    }
    public ArrayList<String> getLongestInvoices()
    {
        InvoiceDatabaseManager invoiceDb = new InvoiceDatabaseManager();
        try
        {
            invoiceDb.processLongestInvoice();
        }catch(Exception e){System.out.println(e);System.exit(0);}
        
        ArrayList<Integer> invoiceNum = invoiceDb.getInvoiceNumberList();
        ArrayList<String> address = invoiceDb.getAddressList();
        ArrayList<String> dates = invoiceDb.getInvoiceDateList();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
        LocalDate now = LocalDate.now();  
        String today = setFormat(dtf.format(now));
        
        ArrayList<String> allData = new ArrayList<>();
        
        for(int i = 0; i < invoiceNum.size(); i++)
        {
            String concatinatedString = "Invoice #" + invoiceNum.get(i) + " from " + address.get(i) + ", started " + getDetailedAging(dayInterval(today, dates.get(i)));
            allData.add(concatinatedString);
        }
        
        return allData;
    }
    public ArrayList<String> getMostOutstanding()
    {
        InvoiceDatabaseManager invoiceDb = new InvoiceDatabaseManager();
        try
        {
            invoiceDb.processMostOutstanding();
        }catch(Exception e){System.out.println(e);System.exit(0);}
        
        ArrayList<String> address = invoiceDb.getAddressList();
        ArrayList<Double> total = invoiceDb.getItemTotalList();
        
        ArrayList<String> allData = new ArrayList<>();
        
        for(int i = 0; i < address.size(); i++)
        {
            String concatinatedString = address.get(i) + " has " + (char)8369 + " " + total.get(i);
            allData.add(concatinatedString);
        }
        
        return allData;
    }
    public ArrayList<String> getItemQuantity(boolean ascending)
    {
        ItemDatabaseManager itemDb = new ItemDatabaseManager();
        try
        {
            itemDb.processItemsByQuantity(ascending);
        }catch(Exception e){System.out.println(e);System.exit(0);}
        
        ArrayList<String> itemName = itemDb.getItemNameList();
        ArrayList<String> itemArticle = itemDb.getItemArticleList();
        ArrayList<String> itemBrand = itemDb.getItemBrandList();
        ArrayList<Double> itemQuantity = itemDb.getItemQuantityList();
        
        ArrayList<String> allData = new ArrayList<>();
        
        for(int i = 0; i < itemName.size(); i++)
        {
            String article = itemArticle.get(i).equals("None") ? "" : " " + itemArticle.get(i);
            String brand = itemBrand.get(i).equals("None") ? "" : "-" + itemBrand.get(i);
            
            String concatinatedString = itemName.get(i) + article + brand + " has " + itemQuantity.get(i) + " left";
            allData.add(concatinatedString);
        }
        
        return allData;
    }
    private String setFormat(String date)
    {
        String returnDate = "";
        String splitDate [] = date.split("/");
        returnDate = splitDate[0] + "-" + splitDate[1] + "-" + splitDate[2];
        return returnDate;
    }
    private long dayInterval(String date, String today)
    {
        
        date = date.substring(0, 10);
        today = today.substring(0, 10);
        LocalDate dateBefore = LocalDate.parse(date);
        LocalDate dateAfter = LocalDate.parse(today);
        
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateAfter,dateBefore);
        
        return noOfDaysBetween;
    }
    private String getDetailedAging(long dayInterval)
    {
        final int year = 365;
        final int month = 31;
        
        String returnDetails = "";
        
        int years = (int)dayInterval / year;
        dayInterval %= year;
        int months = (int)dayInterval / month;
        dayInterval %= month;
        int days = (int)dayInterval;
        
        if(years > 0)
            returnDetails += years == 1 ? years + " Year" : years + " Years ";
        if(months > 0)
            returnDetails += months == 1 ? months + " Month " : months + " Months ";
        if(days >= 0)
            returnDetails += days <= 1 ? days + " Day " : days + " Days";
        
        return returnDetails;
    }
}
