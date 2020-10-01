package com.dullio.destinyconnectionsmediaapplication;

public class DashboardItem {
    private String mTitle,mDescription,mAction;
    private int mResource;

    public DashboardItem (String title, String description, String action,int imageResource){
        this.mAction = action;
        this.mDescription = description;
        this.mResource = imageResource;
        this.mTitle = title;
    }

    public java.lang.String getmTitle() {
        return mTitle;
    }

    public void setmTitle(java.lang.String mTitle) {
        this.mTitle = mTitle;
    }

    public java.lang.String getmDescription() {
        return mDescription;
    }

    public void setmDescription(java.lang.String mDescription) {
        this.mDescription = mDescription;
    }

    public java.lang.String getmAction() {
        return mAction;
    }

    public void setmAction(java.lang.String mAction) {
        this.mAction = mAction;
    }

    public int getmResource() {
        return mResource;
    }

    public void setmResource(int mResource) {
        this.mResource = mResource;
    }
}
