package com.example.tacoviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.os.Bundle;

import android.os.Handler;
import android.widget.RadioGroup;
import android.os.AsyncTask;


import com.example.tacoviewer.connection.HttpRequestData;
import com.example.tacoviewer.connection.HttpRequestUtil;
import com.example.tacoviewer.connection.HttpResponseData;
import com.example.tacoviewer.data.TacoOrder;
import com.example.tacoviewer.fragment.FragmentFactory;
import com.example.tacoviewer.json.JsonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    final HttpRequestData requestURL= new HttpRequestData("http://10.0.2.2:8080/order_events");

    private TacoOrder tacoOrder;
    private FragmentManager fragmentManager;
    private RadioGroup radioGroup;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable(){
        public void run(){
            update();//更新数据
            handler.postDelayed(this,2000);//定时时间
        }
    };

    private void update(){
        try{
            HttpResponseData response=HttpRequestUtil.getData(requestURL);
            ArrayList<HashMap<String, Object>> list = JsonUtil.parserJsonArray(response.content.toString());
            tacoOrder= new TacoOrder(list);
        }catch(Exception e) {
            e.printStackTrace();

        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable,2000);



        fragmentManager = getFragmentManager();
        radioGroup = (RadioGroup) findViewById(R.id.rg_tab);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                Fragment fragment = FragmentFactory.getInstanceByIndex(checkedId);
                transaction.replace(R.id.content, fragment);
                transaction.commit();
            }
        });

        /**
        Button btnRefresh= findViewById(R.id.btnRefresh);
        final TextView txtDisplay= findViewById(R.id.txtDisplay);


        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask asyncTask =new AsyncTask() {
                    @Override
                    protected Object doInBackground(Object[] objects) {
                        try{
                            HttpResponseData response=HttpRequestUtil.getData(requestURL);
                            return response.content;
                        }catch(Exception e) {
                            e.printStackTrace();

                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Object o) {
                        txtDisplay.setText(o.toString());
                    }
                }.execute();

            }
        });
         **/

    }



}
