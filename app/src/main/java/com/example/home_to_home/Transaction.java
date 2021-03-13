import java.util.HashMap;

public class Transaction {
    public HashMap<User,Item> items = new HashMap<User,Item>;
    private int time;
    private int date;
    private String Offer;
    public HashMap<Integer,User> queue = new HashMap<Integer,User>;
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
    public void buy(User A, Item B, User C){

    }
}
