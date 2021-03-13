import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class Transaction {
    private String time;
    private String date;
    private int Offer;
    private HashMap<Integer,List<Item>> catalogue = new HashMap<Integer,Item>;
    private List<Item> Products = new ArrayList<Item>;
    private HashMap<User,List<Item>> Bought = new HashMap<User,Item>;
    public Transaction(){
        this.time="0:00";
        this.date = "0/00/00";
        this.Offer=0;

    }
    public Transaction(String time,String date,int Offer){
        this.time = time;
        this.date = date;
        this.Offer=Offer;
    }
    public String getTime(){
        return time;
    }
    public String getDate(){
        return date;
    }
    public int getOffer(){
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
    public void buy(Item A,User B,User C){
        if(A.containUserinQueue(B)) {
            int index = A.indexinQueue(B);
            if (index == 1) {
                A.removefromQueue();
                B.additem(A, "Bought");
                Bought.put(B, B.getItems("Bought"));
                C.removeItem(A);
            }
        }
        else {
            A.addtoQueue(B);
        }

    }
    public void proposingTrade(Item A, Item B, User C, User D){

    }





}
