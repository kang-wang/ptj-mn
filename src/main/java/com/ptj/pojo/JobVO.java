package com.ptj.pojo;

import java.io.Serializable;

/**
 * @author wh
 * @create 2018-12-14 19:19
 **/
public class JobVO extends Job implements Serializable {
    private String longitude;
    private String latitude;
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
