public class Item {
    private int quantity, cost;
    private String name;
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


    public void setName(String name) {
        this.name = name;
    }

}
