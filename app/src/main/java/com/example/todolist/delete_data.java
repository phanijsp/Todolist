package com.example.todolist;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class delete_data {

    public static SQLiteHelper sqLiteHelper;
    public void deletedata(String s, Context c){
        sqLiteHelper = new SQLiteHelper(c, "FoodDB.sqlite", null, 1);
        sqLiteHelper.queryData("DELETE FROM tasks where task in"+s);

    }
}


