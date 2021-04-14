package com.example.tacoviewer.fragment;


import com.example.tacoviewer.data.TacoOrder;

public class FrozenFragment extends BaseFragment {
    @Override
    public String initContent() {
        return "这是评论我界面";
    }

    public String initOrders(TacoOrder tacoOrder){
        StringBuilder sb= new StringBuilder();

        return tacoOrder.getFrozenShelf().toString();
    }
}
