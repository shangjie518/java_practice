package com.example.tacoviewer.data;

import com.example.tacoviewer.bean.Order;
import com.example.tacoviewer.bean.Shelf_State;

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

    public ArrayList<Order> getHotShelf(){
        ArrayList<Order> result = new ArrayList<Order>();
        for(int i=0 ;i<orderList.size();i++){
            if(orderList.get(i).shelf == Shelf_State.HOT){
                result.add(orderList.get(i));
            }

        }
        return result;
    }

    public ArrayList<Order> getColdShelf(){
        ArrayList<Order> result = new ArrayList<Order>();
        for(int i=0 ;i<orderList.size();i++){
            if(orderList.get(i).shelf == Shelf_State.COLD){
                result.add(orderList.get(i));
            }

        }
        return result;
    }

    public ArrayList<Order> getFrozenShelf(){
        ArrayList<Order> result = new ArrayList<Order>();
        for(int i=0 ;i<orderList.size();i++){
            if(orderList.get(i).shelf == Shelf_State.FROZEN){
                result.add(orderList.get(i));
            }

        }
        return result;
    }

    public ArrayList<Order> getOverflowShelf(){
        ArrayList<Order> result = new ArrayList<Order>();
        for(int i=0 ;i<orderList.size();i++){
            if(orderList.get(i).shelf == Shelf_State.OVERFLOW){
                result.add(orderList.get(i));
            }

        }
        return result;
    }

    public ArrayList<Order> getNoneShelf() {
        ArrayList<Order> result = new ArrayList<Order>();
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).shelf == Shelf_State.NONE) {
                result.add(orderList.get(i));
            }

        }
        return result;
    }

}
