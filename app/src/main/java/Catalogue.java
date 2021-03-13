package com.example.home_to_home;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Catalogue {
    private HashMap<Integer,List<Item>> catalogue = new HashMap<Integer,Item>;
    private List<Item> Products = new ArrayList<Item>;
    private HashMap<User,List<Item>> Bought = new HashMap<User,Item>;
    public Catalogue(){}

    public void addItems(User a){  //when would this be called/used?
        int zipcode = a.getZipcode();
        List<Item> userproducts = a.getItems("Owned");
        for(Item items: userproducts) {
            Products.add(items);
        }
        catalogue.put(zipcode, Products);
    }

    public List<Item> findProducts(User b){ //this finds potential products given a zipcode
        int zipcode = b.getZipcode();
        List<Item> products = catalogue.get(zipcode);
        return products;
    }
    public void transaction(Item A,User B,User C){
        A.emptyQueue();
        B.additem(A, "Bought");
        Bought.put(B, B.getItems("Bought"));
        C.removeItem(A);
    }

}
