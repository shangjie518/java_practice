package com.example.tacoviewer.fragment;
import android.app.Fragment;

import com.example.tacoviewer.data.TacoOrder;

public class FragmentFactory {
    public static Fragment getInstanceByIndex(int index) {
        Fragment fragment = null;
        switch (index) {
            case 1:
                fragment = new HotFragment();
                break;
            case 2:
                fragment = new ColdFragment();
                break;
            case 3:
                fragment = new FrozenFragment();
                break;
            case 4:
                fragment = new OverflowFragment();
                break;
            case 5:
                fragment = new NoneFragment();
                break;
        }
        return fragment;
    }
}
