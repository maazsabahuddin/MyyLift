package com.example.myylift;

import android.app.Application;

public class Globals extends Application {


    public static int data ;

    public int getData() {
        return this.data;
    }

    public void setData(int d) {
        this.data = d;
    }
}
