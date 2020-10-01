package com.dullio.destinyconnectionsmediaapplication;

public class ListViewContact {
    private String mTitle;
    private int mResource;

    public ListViewContact(String title, int resource){
        this.mResource = resource;
        this.mTitle = title;
    }

    public java.lang.String getmTitle() {
        return mTitle;
    }

    public void setmTitle(java.lang.String mTitle) {
        this.mTitle = mTitle;
    }

    public int getmResource() {
        return mResource;
    }

    public void setmResource(int mResource) {
        this.mResource = mResource;
    }
}
