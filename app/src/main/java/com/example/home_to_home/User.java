import java.util.HashMap;

public class User  {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String location;
    private int phonenumber;
    private Item[] items;


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
    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public int getPhoneNumber(){
        return phonenumber;
    }

    public void initializeitems(){

    }
}
