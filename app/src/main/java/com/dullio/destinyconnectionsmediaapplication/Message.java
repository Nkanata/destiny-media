package com.dullio.destinyconnectionsmediaapplication;

public class Message {
    private String mContent,mTimeStamp;
    private boolean isMine = true;

    public Message(String message,boolean isMine){
        this.mContent = message;
        this.isMine = isMine;
        this.mTimeStamp = "12:12 PM";
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmTimeStamp() {
        return mTimeStamp;
    }

    public void setmTimeStamp(String mTimeStamp) {
        this.mTimeStamp = mTimeStamp;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }
}
