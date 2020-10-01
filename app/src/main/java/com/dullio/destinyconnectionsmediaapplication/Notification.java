package com.dullio.destinyconnectionsmediaapplication;

public class Notification {
   private String mDescription,mTimeStamp,mSender;

    public Notification (String description,String sender){
        this.mDescription = description;
        this.mSender = sender;
        this.mTimeStamp = "12:12 PM";
    }

    public java.lang.String getmDescription() {
        return mDescription;
    }

    public void setmDescription(java.lang.String mDescription) {
        this.mDescription = mDescription;
    }

    public java.lang.String getmTimeStamp() {
        return mTimeStamp;
    }

    public void setmTimeStamp(java.lang.String mTimeStamp) {
        this.mTimeStamp = mTimeStamp;
    }

    public java.lang.String getmSender() {
        return mSender;
    }

    public void setmSender(java.lang.String mSender) {
        this.mSender = mSender;
    }
}
