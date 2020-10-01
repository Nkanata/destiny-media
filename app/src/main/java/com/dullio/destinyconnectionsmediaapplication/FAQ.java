package com.dullio.destinyconnectionsmediaapplication;

public class FAQ {
    String mTitle;
    String mDescription;

    public FAQ (String title, String description){
        this.mDescription = description;
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
}
