package com.dullio.destinyconnectionsmediaapplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Event {
    private String mTitle, mDescription,mLocation;
    private int mResource;
    private Date mDate;

    public Event (String title, String location,String date,String description, int resource){
        this.mDescription = description;
        this.mLocation = location;
        this.mResource = resource;
        this.mTitle = title;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public int getmResource() {
        return mResource;
    }

    public void setmResource(int mResource) {
        this.mResource = mResource;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    private String dateToString (Date date){
        // Convert here
        return "";
    }

    private Date stringToDate(String date){
        return new Date();
    }

    private String dateFormatter (Date date){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm,dd mmm");
        return simpleDateFormat.format(date);
    }
}
