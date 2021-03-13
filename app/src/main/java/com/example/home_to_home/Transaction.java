package com.example.home_to_home;

public class Transaction {
    private String time;
    private String date;
    private String Offer;
    private int SellerUID;
    private int BuyerUID;
    private Catalogue catalogue = new Catalogue();

    // i'm not sure these three things belong in this class really? perhaps in a different higher class?


    //    public Transaction(){
//        this.time="0:00";
//        this.date = "0/00/00";
//        this.Offer=0;
//
//    }
    public Transaction(String time,String date, String Offer, int BuyerUID, int SellerUID){
        this.time = time;
        this.date = date;
        this.Offer=Offer;
        this.SellerUID = SellerUID;
        this.BuyerUID = BuyerUID;

    }

    public Transaction(){}

    public String getTime(){
        return time;
    }

    public String getDate(){
        return date;
    }

    public String getOffer(){
        return Offer;

    }

    public void buy(Item A,User B,User C){ //i think this makes sense now as long as we set it up correctly with the xml stuff
        if(A.containUserinQueue(B)) {
            int index = A.indexinQueue(B);
            if (index == 1) {
                catalogue.transaction(A,B,C);
            }
        }
        else {
            A.addtoQueue(B);
        }

    }
    public void proposingTransaction(Item A, User B, User C, Boolean sellerDecision){
        if (!sellerDecision) {
            A.removeFromQueue(B);
        } else {
            buy(A, B, C);
        }
    }





}
