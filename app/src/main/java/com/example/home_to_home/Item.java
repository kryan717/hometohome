import java.util.ArrayList;
import java.util.List;

public class Item {
    private int quantity, cost;
    private String name;
    private List<User> Queue = new ArrayList<User>;
    public Item(int count,int price,String label){
        quantity=count;
        cost = price;
        name = label;
    }
    public Item(){
        this.quantity=0;
        this.cost=0;
        this.name=" ";

    }

    public int getCost() {
        return cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void addtoQueue(User A){
        Queue.add(A);
    }
    public int indexinQueue(User A){
        int number = Queue.indexOf(A) + 1;

        return number;
    }
    public void removefromQueue(){
        Queue.remove(Queue.get(0));
    }

}
