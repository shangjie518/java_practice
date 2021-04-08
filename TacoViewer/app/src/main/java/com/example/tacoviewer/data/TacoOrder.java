package com.example.tacoviewer.data;

import com.example.tacoviewer.bean.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class TacoOrder {

    private ArrayList<Order> orderList;

    public TacoOrder(ArrayList<HashMap<String, Object>> list){
        Iterator<HashMap<String, Object>> it = list.iterator();
        while (it.hasNext()) {
            HashMap<String, Object> ma = it.next();
            Order order = new Order((String)ma.get("id"),(String)ma.get("state"),(int)ma.get("price"),
                    (String)ma.get("item"),(String)ma.get("customer"),(String)ma.get("shelf"),
                    (String)ma.get("timestamp"),(String)ma.get("destination"));
            orderList.add(order);

        }

    }

}
