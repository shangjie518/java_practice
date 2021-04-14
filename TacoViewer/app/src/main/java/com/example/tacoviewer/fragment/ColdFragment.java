package com.example.tacoviewer.fragment;


import com.example.tacoviewer.data.TacoOrder;

public class ColdFragment extends BaseFragment {
    @Override
    public String initContent() {
        return "这是关注我界面";
    }
    public String initOrders(TacoOrder tacoOrder){
        StringBuilder sb= new StringBuilder();

        return tacoOrder.getColdShelf().toString();
    }
}
