import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User  {
    private String username;
    private String password; //we can't just store the password like this
    private String firstname;
    private String lastname;
    private String phonenumber;
    private int zipcode;
    private int uid;

    private List<Item> owneditems;
    private List<Item> boughtitems;



    public User(String user, String pass, String first, String last, String phone, int zipcode, int uid){
        username = user;
        password = pass;
        firstname = first;
        lastname = last;
        phonenumber = phone;
        uid = uid;
        this.zipcode = zipcode;
        owneditems = new ArrayList<Item>();
        boughtitems = new ArrayList<Item>();

    }
    public User(){ }

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
    public void removeItem(Item A,String B){
        if(B=="Owned") {
            owneditems.remove(A);
        }
    }


    public int getZipcode() {
        return zipcode;
    }

}
