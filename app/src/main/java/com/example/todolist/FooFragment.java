package com.example.todolist;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FooFragment extends Fragment {
    public static SQLiteHelper sqLiteHelper;

Button btn;
FrameLayout frameLayout;
Button cancelbtn;
ListView listView;
Context context;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        View V = inflater.inflate(R.layout.fragment_foo, parent, false);
        final LinearLayout ll=(LinearLayout) V.findViewById(R.id.ll);
        final EditText et= (EditText) V.findViewById(R.id.editText);

        btn=(Button) V.findViewById(R.id.button);
        cancelbtn=(Button) V.findViewById(R.id.button2);

        frameLayout=foohelper.getfl();
        listView=foohelper.getlv();
        context=foohelper.getContext();

        sqLiteHelper = new SQLiteHelper(getContext(), "FoodDB.sqlite", null, 1);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS tasks(Id INTEGER PRIMARY KEY AUTOINCREMENT, task VARCHAR, strike VARCHAR)");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=et.getText().toString();
                if(s.equals("")){
                    Toast.makeText(getContext(),"You can't add empty notes!",Toast.LENGTH_SHORT).show();
                }
                else{
                    sqLiteHelper.insertData(s,"False");
                    Toast.makeText(getContext(),s,Toast.LENGTH_SHORT).show();
                    frameLayout.setVisibility(View.INVISIBLE);
                    ArrayList<String> x=new ArrayList<String>();
                    x=new get_data().getdata(context);
                    ArrayAdapter<String> rldaptam_arrayAdapter   =   new ArrayAdapter<String>(context,R.layout.vselementcat,R.id.tv5,x);
                    listView.setAdapter(rldaptam_arrayAdapter);

                }


            }
        });
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrameLayout frameLayout=foohelper.getfl();
                frameLayout.setVisibility(View.INVISIBLE);
            }
        });
        return V;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

    }

}