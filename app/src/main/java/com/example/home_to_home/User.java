import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User  {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String phonenumber;
    private int zipcode;
    public List<Item> owneditems = new ArrayList<Item>();
    private List<Item> boughtitems = new ArrayList<Item>();


    public User(String user,String pass,String first, String last,String phone){
        username = user;
        password = pass;
        firstname = first;
        lastname = last;
        phonenumber = phone;
    }
    public User(){
        this.username="Guest";
        this.password = " ";
        this.firstname=" ";
        this.lastname=" ";
        this.phonenumber= "1-000-000-0000";

    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public String getUsername() {
        return username;
    }
    public String getPhoneNumber(){
        return phonenumber;
    }
    public List<Item> getItems(String A){
        List<Item> items = new ArrayList<Item>;
        if(A=="Owned") {
            items = owneditems;
        }
        if(A=="Bought"){
            items = boughtitems;
        }
        return items;
    }
    public void additem(Item A,String B){
          if(B=="Owned") {
              owneditems.add(A);
          }
          else if(B=="Bought"){
              boughtitems.add(A);
          }
    }
    public void removeItem(Item A){
        owneditems.remove(A);
    }


    public int getZipcode() {
        return zipcode;
    }

}
