package com.example.todolist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton add,del;
    ListView lv;
    int iflag;
    public static SQLiteHelper sqLiteHelper;

    static View xview;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        );

        final Context  c=this;
        add = (FloatingActionButton)    findViewById(R.id.addbtn);
        del=    (FloatingActionButton)  findViewById(R.id.deletebtn);
        lv = (ListView)    findViewById(R.id.listview);
        del.setVisibility(View.INVISIBLE);
        ArrayList<String> mylist = new ArrayList<String>();
        final get_data x=new get_data();
        //retrieving data from sqlite database
        mylist=x.getdata(c);
        final ArrayAdapter<String> rldaptam_arrayAdapter   =   new ArrayAdapter<String>(MainActivity.this,R.layout.vselementcat,R.id.tv5,mylist);
        lv.setAdapter(rldaptam_arrayAdapter);
        String r ="abc";
        final String[] delstring = {"("+'"'+r+'"'};
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, long id) {
                xview=view;
                view.setBackgroundColor(getResources().getColor(R.color.blue));
                del.setVisibility(View.VISIBLE);
                iflag=0;
                delstring[0] = delstring[0]+','+'"'+(String) parent.getItemAtPosition(position)+'"';
                Toast.makeText(c,delstring[0],Toast.LENGTH_SHORT).show();
                del.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        delstring[0]=delstring[0]+")";
                        Toast.makeText(c,delstring[0],Toast.LENGTH_SHORT).show();
                        iflag=1;
                        String z=(String) parent.getItemAtPosition(position);
                        z=delstring[0];
                        new delete_data().deletedata(z,c);
                        Intent i=new Intent(MainActivity.this,MainActivity.class);
                        startActivity(i);
                        MainActivity.this.finish();
                    }
                });
                return false;
            }
        });
        final FrameLayout frameLayout=(FrameLayout)findViewById(R.id.framelayout);
        foohelper.setfl(frameLayout);
        foohelper.setlv(lv);
        foohelper.setContext(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.framelayout, new FooFragment());
                ft.add(R.id.framelayout, new FooFragment());
                frameLayout.setVisibility(View.VISIBLE);
                ft.commit();
            }
        });
    }
    @SuppressLint("RestrictedApi")
    @Override
    public void onBackPressed()
    {
        // Example of logic
        if ( iflag==0 ) {
            iflag=1;
            xview.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            del.setVisibility(View.INVISIBLE);
        } else {
            super.onBackPressed();
        }
    }
}



