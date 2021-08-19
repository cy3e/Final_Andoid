package com.example.me_net;

import com.google.firebase.storage.StorageReference;

// patron de dsieño singleton par el firebase
public class Firebase extends MainActivity
{
    private String objectState;
    private static final Firebase instance = new Firebase();

    private Firebase()
    {
        this.objectState = "";
    }
    public static  Firebase getInstance()
    {

        return instance;
    }
    public String getObjectState()
    {
        return objectState;
    }
    public void setObjectState()
    {
        this.objectState = objectState;
    }

}
