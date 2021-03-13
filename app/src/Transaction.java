import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class Transaction {
    private String time;
    private String date;
    private String Offer;
    private int SellerUID;
    private int BuyerUID;

    // i'm not sure these three things belong in this class really? perhaps in a different higher class?
    private HashMap<Integer,List<Item>> catalogue = new HashMap<Integer,Item>;
    private List<Item> Products = new ArrayList<Item>;
    private HashMap<User,List<Item>> Bought = new HashMap<User,Item>;


//    public Transaction(){
//        this.time="0:00";
//        this.date = "0/00/00";
//        this.Offer=0;
//
//    }
    public Transaction(String time,String date, int Offer, int BuyerUID, int SellerUID){
        this.time = time;
        this.date = date;
        this.Offer=Offer;
        this.SellerUID = SellerUID;
        this.BuyerUID = BuyerUID;

    }

    public Transaction(){}

    public String getTime(){
        return time;
    }

    public String getDate(){
        return date;
    }

    public int getOffer(){
        return Offer;

    }

    public void addItems(User a){  //when would this be called/used?
        int zipcode = a.getZipcode();
         List<Item> userproducts = a.getItems();
         for(Item items: userproducts) {
             Products.add(items);
         }
         catalogue.put(zipcode, Products);
    }

    public List<Item> findProducts(User b){ //this finds potential products given a zipcode
        int zipcode = b.getZipcode();
        List<Item> products = catalogue.get(zipcode);
        return products;
    }

    public void buy(Item A,User B,User C){ //i think this makes sense now as long as we set it up correctly with the xml stuff
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
    public void proposingTransaction(Item A, User B, User C, Boolean sellerDecision){
        if (!sellerDecision) {
            A.removeFromQueue(B)
        } else {
            buy(A, B, C)
        }
    }





}
