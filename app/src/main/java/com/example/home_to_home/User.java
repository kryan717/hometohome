import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User  {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private int phonenumber;
    private int zipcode;
    public List<Item> owneditems = new ArrayList<Item>();


    public User(String user,String pass,String first, String last,int phone){
        username = user;
        password = pass;
        firstname = first;
        lastname = last;
        phonenumber = phone;
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
    public int getPhoneNumber(){
        return phonenumber;
    }
    public List getItems(){
        return owneditems;
    }
    public void additem(Item A){
            owneditems.add(A);
    }

    public int getZipcode() {
        return zipcode;
    }

}
