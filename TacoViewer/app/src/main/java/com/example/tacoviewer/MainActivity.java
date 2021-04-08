package com.example.tacoviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tacoviewer.connection.HttpRequestData;
import com.example.tacoviewer.connection.HttpRequestUtil;
import com.example.tacoviewer.connection.HttpResponseData;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    final HttpRequestData requestURL= new HttpRequestData("http://10.0.2.2:8080/order_events");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


    }
}
