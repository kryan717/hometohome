public class Item {
    private int quantity, cost;
    private String name;
    private String city;
    private String state;
    public Item(int count,int price,String label){
        quantity=count;
        cost = price;
        name = label;
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
    public void setLocation(String city,String state){
        this.city = city;
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public void setName(String name) {
        this.name = name;
    }

}
