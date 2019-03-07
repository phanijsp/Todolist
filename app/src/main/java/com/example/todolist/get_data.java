package com.example.todolist;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class get_data{

    public static SQLiteHelper sqLiteHelper;
    public ArrayList<String> getdata(Context c){
        String[] tasks_data ={"Adi","phani","phani","phani","phani","phani","phani","phani"};
        ArrayList<String> mylist = new ArrayList<String>();
        sqLiteHelper = new SQLiteHelper(c, "FoodDB.sqlite", null, 1);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS tasks(Id INTEGER PRIMARY KEY AUTOINCREMENT, task VARCHAR, strike VARCHAR)");
        Cursor cursor = sqLiteHelper.getData("SELECT * FROM tasks");
        while (cursor.moveToNext()){
           mylist.add(cursor.getString(1));
        }
        return mylist;
    }
}
