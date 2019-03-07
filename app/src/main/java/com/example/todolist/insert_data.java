package com.example.todolist;

import android.content.Context;
import android.content.Intent;
import android.widget.FrameLayout;
import android.widget.Toast;

public class insert_data {

static FrameLayout frameLayout;
    public static SQLiteHelper sqLiteHelper;
    public insert_data(String s,Context c){
        sqLiteHelper = new SQLiteHelper(c, "FoodDB.sqlite", null, 1);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS tasks(Id INTEGER PRIMARY KEY AUTOINCREMENT, task VARCHAR, strike VARCHAR)");
        frameLayout=foohelper.getfl();
        try{
            sqLiteHelper.insertData(s,"FALSE");
            Toast.makeText(c,"Data inserted!",Toast.LENGTH_SHORT).show();
        }
        catch (Exception    e){
            e.printStackTrace();
        }
    }
}
