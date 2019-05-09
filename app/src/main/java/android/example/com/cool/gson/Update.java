package android.example.com.cool.gson;

import com.google.gson.annotations.SerializedName;

public class Update {
    @SerializedName("loc")
    public String locTime;
    @SerializedName("utc")
    public String utcTime;
}
