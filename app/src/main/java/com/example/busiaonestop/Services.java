package com.example.busiaonestop;

public class Services {

    private String mTitle;
    private String mDescription;
    private int mResource;



    public Services (String mTitle,String mDescription,int mResource){

        this.mDescription = mDescription;
        this.mResource = mResource;
        this.mTitle = mTitle;

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

    public int getmResource() {
        return mResource;
    }

    public void setmResource(int mResource) {
        this.mResource = mResource;
    }
}
