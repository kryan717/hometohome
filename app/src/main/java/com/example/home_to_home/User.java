import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User  {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private int phonenumber;
    public List<Item> items = new ArrayList<Item>();
    private String city;
    private String state;


    public User(String user,String pass,String first, String last,int phone){
        username = user;
        password = pass;
        firstname = first;
        lastname = last;
        phonenumber = phone;
    }
    public String setState
    public String getFirstname() {
        return firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public String getUsername() {
        return username;
    }
    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public int getPhoneNumber(){
        return phonenumber;
    }
    public void setLocation(String city,String state){
        this.city = city;
        this.state = state;
    }

    public void additem(Item A){
            items.add(A);
    }
    public List searchItems(Item A, String city, String state){
        List<Item> foundItems = new ArrayList<Item>;
         for(Item item: items){
             if(item.getCity()==city && item.getState()==state){
                 foundItems.add(item);
             }
         }
         return foundItems;
    }


}
