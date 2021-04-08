package com.example.tacoviewer.bean;


import android.text.method.DateTimeKeyListener;

import java.util.Date;

public class TacoOrder {

    public String id;
    public Order_State state;
    public int price;

    public String item;
    public String customer;
    public Shelf_State shelf;

    public Date timestamp;
    public String destination;


}
