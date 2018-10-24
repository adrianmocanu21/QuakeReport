package com.example.android.quakereport;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * Created by skorpyo1 on 2/24/2018.
 */

public class Earthquake {

    private double magnitude;
    private String earthquakeName;
    private Long earthquakeDate;
//    private Date date;
    private String link;

    public Earthquake(double magnitude, String earthquakeName, Long earthquakeDate,String link) {
        this.magnitude = magnitude;
        this.earthquakeName = earthquakeName;
        this.earthquakeDate = earthquakeDate;
        this.link = link;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getEarthquakeName() {
        return earthquakeName;
    }

    public Long getEarthquakeDate() {
        return earthquakeDate;
    }

    public String getLink() {
        return link;
    }

    //    public String getTheDate() {
//        String x = this.earthquakeDate.get(Calendar.YEAR) + "." + this.earthquakeDate.get(Calendar.MONTH) + "." +  this.earthquakeDate.get(Calendar.DATE) ;
//        return x;
//    }
}
