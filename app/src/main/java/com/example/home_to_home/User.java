package com.example.home_to_home;

import java.util.ArrayList;
import java.util.List;

public class User  {
    private String username;
    private String password;
    private String name;
    private String phonenumber;
    private int zipcode;
    public List<Item> owneditems = new ArrayList<Item>();
    private List<Item> boughtitems = new ArrayList<Item>();


    public User(String user, String name, String phone){
        username = user;
        name = name;
        phonenumber = phone;
    }
    public User(){ }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }
    public String getPhoneNumber(){
        return phonenumber;
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
