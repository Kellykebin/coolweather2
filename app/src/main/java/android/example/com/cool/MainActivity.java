package android.example.com.cool;

import android.content.Intent;
import android.content.SharedPreferences;
import android.example.com.cool.gson.Basic;
import android.example.com.cool.gson.Forecast;
import android.example.com.cool.gson.Now;
import android.example.com.cool.gson.Suggestion;
import android.example.com.cool.gson.Weather;
import android.preference.PreferenceManager;
import android.service.autofill.Dataset;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  DataSupport.deleteAll(Basic.class);
   //     DataSupport.deleteAll(Forecast.class);
    //    DataSupport.deleteAll(Now.class);
    //    DataSupport.deleteAll(Suggestion.class);
  //      DataSupport.deleteAll(Weather.class);
        SharedPreferences prefs=PreferenceManager.getDefaultSharedPreferences(this);
        if(prefs.getString("weather",null)!=null){
            Intent intent=new Intent(this,WeatherActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
