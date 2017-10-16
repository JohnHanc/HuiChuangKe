package com.huida.utils;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.huida.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by liling on 2017/9/30.
 */

public  class CityDataBean{

   public HashMap<String, String> provinceHash = new HashMap<String, String>();
   public String[] provinceString = new String[34];

  public   HashMap<String, String> cityHash = new HashMap<String, String>();
   public String[] cityString;

    String file;

    String cityNo = null;// 最重要的参数，选中的城市的cityNo


    private ArrayAdapter<String> proviceAdapter;
    private ArrayAdapter<String> cityAdapter;
    private RecyclerView proviceSpinner;
    private EditText citySpinner;
    private ArrayList<String> pro;

    public CityDataBean() {
//        file = readFile(); // 读取txt文件
//        ArrayList<String> provinces =  getProvinces(file);// 得到省的列表


    }


    public String readFile(Activity mActivity) {
        /*
         * 读取文件中数据的方法
         */
        InputStream myFile = null;
        Context context = MyApplication.getContext();
        myFile = mActivity.getResources().openRawResource(R.raw.ub_city);
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(myFile, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        String temp;
        String str = "";
        try {
            while ((temp = br.readLine()) != null) {
                str = str + temp;
                // Log.i("zhiyinqing", "断点3"+temp);
            }
            br.close();
            myFile.close();
            return str;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";
        }
    }

    public ArrayList<String> getProvinces(String jsonData) {

        /*
         * 从json字符串中得到省的信息
         */
        pro = new ArrayList<String>();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < 34; i++) {
                // 获取了34个省市区信息
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String guid = jsonObject.getString("guid");
                String cityName = jsonObject.getString("cityName");
              Log.i("zhiyinqing", i+guid+cityName);
                provinceHash.put(cityName, guid);
                provinceString[i] = cityName;
                pro.add(cityName);

            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return pro;
    }

    public String[] getCitys(String guid, String jsonData) {
        /*
         * 此方法用于查找一个省下的所有城市
         */
        // 初始化hashmap
        cityHash.clear();
        // 暂时存放城市的数组
        String[] cityBuffer = new String[21];
        int j = 0;

        // 解析数据
        JSONArray jsonArray;
        try {
            jsonArray = new JSONArray(jsonData);
            int length = jsonArray.length();
            int i = 33;
            int continuous = 0;// 这个变量用于判断是否连续几次没有找到，如果是，则该省信息全部找到了
            boolean isFind = false;

            while (i < length) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String fGuid = jsonObject.getString("fGuid");
                String cityName = jsonObject.getString("cityName");
                String cityNo = jsonObject.getString("cityNo");
                if (fGuid.equals(guid)) {
                    isFind = true;
                    cityHash.put(cityName, cityNo);
                    cityBuffer[j] = cityName;
                    j++;
                    // Log.i("zhiyinqing", cityName);
                } else {
                    if (isFind == true) {
                        continuous += 1;

                        if (continuous > 5) {
                            Log.i("zhiyinqing", "城市数:" + j);
                            break;
                        }
                    }
                }
                i++;
            }

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String[] citys = new String[j];
        for(int i=0;i<j;i++){
            citys[i] = cityBuffer[i];
        }
        return citys;
    }

}
