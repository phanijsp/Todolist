package com.example.todolist;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ListView;

public class foohelper {
   static FrameLayout frameLayout;
   static ListView listView;

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        foohelper.context = context;
    }

    static Context context;

    public static FrameLayout getfl(){
       return frameLayout;
    }


    public static ListView getlv() {
        return listView;
    }



    public static void setfl(FrameLayout fl){
        frameLayout=fl;
    }

    public static void setlv(ListView lv){
        listView=lv;
    }



}
