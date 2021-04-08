package com.example.tacoviewer.connection;
import android.graphics.Bitmap;


public class HttpResponseData {
    public String content;
    public Bitmap bitmap;
    public String cookie;
    public String err_msg;

    public HttpResponseData() {
        content = "";
        bitmap = null;
        cookie = "";
        err_msg = "";
    }
}