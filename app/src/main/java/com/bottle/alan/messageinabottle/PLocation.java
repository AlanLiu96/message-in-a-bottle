package com.bottle.alan.messageinabottle;
/**
 * Created by Patrick on 4/2/2016.
 */
public class PLocation {
    private double latitude;
    private double longitude;

    public PLocation(double la, double lo){
        latitude = la;
        longitude = lo;
    }

    public double getLatitude(){
        return latitude;
    }

    public double getLongitude(){
        return longitude;
    }

    public void setLatitude(double la){
        latitude = la;
    }

    public void setLongitude(double lo){
        longitude = lo;
    }


}
