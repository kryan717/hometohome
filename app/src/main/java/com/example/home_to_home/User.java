public class User {
    private final String username;
    private final String password;
    private final String firstname;
    private final String lastname;
    private String location;
    private final int phonenumber;
    private int[];

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


}
