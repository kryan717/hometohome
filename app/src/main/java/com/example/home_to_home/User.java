package com.example.home_to_home;

import java.util.ArrayList;
import java.util.List;

public class User  {
    private String username;
    private String fullname;
    private String phonenumber;
    private int zipcode;
    public List<Item> owneditems;
    private List<Item> boughtitems;


    public User(String email, String name, String phone){
        username = email;
        fullname = name;
        phonenumber = phone;
        zipcode = 00000;
        owneditems = new ArrayList<Item>();
        boughtitems = new ArrayList<Item>();
    }
    public User(){ }

    public String getName() {
        return fullname;
    }

    public String getUsername() {
        return username;
    }
    public String getPhoneNumber(){
        return phonenumber;
    }

    public void setZipcode(int zipcode){
        this.zipcode = zipcode;
    }

    public List<Item> getItems(String A){
        List<Item> items = new ArrayList<Item>();
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
