package com.example.tacoviewer.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class JsonUtil {

    public static ArrayList<HashMap<String, Object>> parserJsonArray(String jsonStr){
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        try {
            JSONArray listArray=new JSONArray(jsonStr);
            for(int i=0; i<listArray.length();i++){
                JSONObject obj=listArray.getJSONObject(i);
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("id", obj.getString("id"));
                map.put("state", obj.getString("state"));
                map.put("price", obj.getInt("price"));
                map.put("item", obj.getString("item"));
                map.put("customer", obj.getString("customer"));
                map.put("shelf", obj.getString("shelf"));
                map.put("timestamp", obj.getString("timestamp"));
                map.put("destination", obj.getString("destination"));
                list.add(map);
            }
            return list;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    private String parserJson(String jsonStr) {
        String result = "";
        try {
            // 根据json串构建一个JSON对象
            JSONObject obj = new JSONObject(jsonStr);
            // 获得名叫name的字符串参数
            String name = obj.getString("name");
            // 获得名叫desc的字符串参数
            String desc = obj.getString("desc");
            // 获得名叫count的整型参数
            int count = obj.getInt("count");
            result = String.format("%sname=%s\n", result, name);
            result = String.format("%sdesc=%s\n", result, desc);
            result = String.format("%scount=%d\n", result, count);
            // 获得名叫list的数组参数
            JSONArray listArray = obj.getJSONArray("list");
            for (int i = 0; i < listArray.length(); i++) {
                // 获得数组中指定下标的JSON对象
                JSONObject list_item = listArray.getJSONObject(i);
                // 获得名叫item的字符串参数
                String item = list_item.getString("item");
                result = String.format("%s\titem=%s\n", result, item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    // 遍历json串保存的键值对信息
    private String traverseJson(String jsonStr) {
        String result = "";
        try {
            // 根据json串构建一个JSON对象
            JSONObject obj = new JSONObject(jsonStr);
            // 获得JSON对象内部的键名称迭代器
            Iterator<String> it = obj.keys();
            while (it.hasNext()) { // 遍历JSONObject
                String key = it.next(); // 获得下一个键的名称
                String value = obj.getString(key); // 获得与该键对应的值信息
                result = String.format("%skey=%s, value=%s\n", result, key, value);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

}
