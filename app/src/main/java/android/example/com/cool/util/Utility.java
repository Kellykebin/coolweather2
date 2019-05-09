package android.example.com.cool.util;

import android.example.com.cool.db.Province;
import android.example.com.cool.db.City;
import android.example.com.cool.db.County;
import android.example.com.cool.gson.Weather;
import android.text.TextUtils;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Utility {

    //解析和處理服務器返回的省級數據
    public static  boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvinces=new JSONArray(response);
                for(int i=0;i<allProvinces.length();i++){
                    JSONObject provinceObject=allProvinces.getJSONObject(i);
                    Province province=new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode((provinceObject.getInt("id")));
                    province.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    //解析和處理服務器返回的市級數據
    public static  boolean handleCityResponse(String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            try
            {
                JSONArray allCities=new JSONArray(response);
                for(int i=0;i<allCities.length();i++){
                    JSONObject cityObject=allCities.getJSONObject(i);
                    City city=new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return  true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return  false;
    }
    //解析和處理服務器返回的縣級數據
    public static  boolean handleCountyResponse(String response,int CityId){
        if(!TextUtils.isEmpty(response)){
            try
            {
                JSONArray allCounties=new JSONArray(response);
                for(int i=0;i<allCounties.length();i++){
                    JSONObject countyObject=allCounties.getJSONObject(i);
                    County county=new County();
                    county.setCountyName(countyObject.getString("name"));
                  //  String weatherid=countyObject.getString("weather_id");
                  //  county.setWeatherId(weatherid);
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(CityId);
                    county.save();
                }
                return  true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return  false;
    }
    //將返回的JSON 數據解析成weather實體類
    public static Weather handleWeatherResponse(String response){
        try{
            JSONObject jsonObject=new JSONObject(response);
            JSONArray jsonArray=jsonObject.getJSONArray("HeWeather");
            String weatherContent=jsonArray.getJSONObject(0).toString();
            Weather weather= new Gson().fromJson(weatherContent,Weather.class);
            return weather;
        }catch (Exception e){
            String ex=e.getMessage();
            e.printStackTrace();
        }
        return null;
    }
}
