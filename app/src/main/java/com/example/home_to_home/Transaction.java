import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class Transaction {
    private int time;
    private int date;
    private String Offer;
    public HashMap<Integer,List<Item>> catalogue = new HashMap<Integer,Item>;
    public List<Item> Products = new ArrayList<Item>;
    public Transaction(int time,int date,String Offer){
        this.time = time;
        this.date = date;
        this.Offer=Offer;
    }
    public int getTime(){
        return time;
    }
    public int getDate(){
        return date;
    }
    public String getOffer(){
        return Offer;

    }
    public void addItems(User a){
        int zipcode = a.getZipcode();
         List<Item> userproducts = a.getItems();
         for(Item items: userproducts) {
             Products.add(items);
         }
         catalogue.put(zipcode,Products);
    }
    public List<Item> findProducts(User b){
        int zipcode = b.getZipcode();
        List<Item> products = catalogue.get(zipcode);
        return products;
    }




}
