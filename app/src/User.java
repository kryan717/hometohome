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
    private List<Item> owneditems;
    private List<Item> boughtitems;
    private List<Item> proposedtradingitems;


    public User(String user,String pass,String first, String last,String phone,int zipcode){
        username = user;
        password = pass;
        firstname = first;
        lastname = last;
        phonenumber = phone;
        this.zipcode = zipcode;
        owneditems = new ArrayList<Item>();
      boughtitems = new ArrayList<Item>();
        proposedtradingitems = new ArrayList<Item>();
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
        else if(A=="Bought"){
            items = boughtitems;
        }
        else if(A=="Trading"){
            items = proposedtradingitems;
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
          else if(B=="Trading"){
              proposedtradingitems.add(A);
          }
    }
    public void removeItem(Item A){
        owneditems.remove(A);
    }


    public int getZipcode() {
        return zipcode;
    }

}
