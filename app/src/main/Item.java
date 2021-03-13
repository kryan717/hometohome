import java.util.ArrayList;
import java.util.List;

public class Item {
    private int quantity;
    private String cost;
    private String name;
    private List<User> Queue;

    public Item(int count, String suggestion,String label){
        quantity=count;
        cost = suggestion;
        name = label;
        private List<User> Queue = new ArrayList<User>;
    }
    public Item(){ }

    public String getCost() {
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
    public void emptyQueue(){
        for(User users:Queue){
            Queue.remove(users);
        }
    }
    public void removeFromQueue(user){
            Queue.remove(user);
    }

    public boolean containUserinQueue(User A){
        return Queue.contains(A);
    }

}
