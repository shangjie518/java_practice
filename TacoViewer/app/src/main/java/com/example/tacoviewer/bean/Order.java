package com.example.tacoviewer.bean;


import android.text.method.DateTimeKeyListener;

import java.util.Date;

public class Order {

    public String id;
    public Order_State state;
    public int price;

    public String item;
    public String customer;
    public Shelf_State shelf;

    public Date timestamp;
    public String destination;


    public Order(String id, String state, int price, String item, String customer, String shelf, String timestamp, String destination){

        this.id= id;
        this.state = Order_State.valueOf(state);
        this.price = price;

        this.item=item;
        this.customer=customer;
        this.shelf=Shelf_State.valueOf(shelf);
        this.timestamp= new Date(Long.valueOf(timestamp));

        this.destination = destination;


    }

}
