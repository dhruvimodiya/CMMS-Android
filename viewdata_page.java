package com.example.project02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class viewdata_page extends AppCompatActivity {
//    RecyclerView recyclerView;
//    ArrayList<String> deviceid,date,device,problem,proc,dec;
    ImageButton close;
    ListView listView;
    ArrayList<String> listItem;
    Button btnback;

    ArrayAdapter adapter;
    DBHelperCom db;
//    MyAdapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdata_page);
        close = findViewById(R.id.close);
        db = new DBHelperCom(this);
//        deviceid = new ArrayList<>();
//        date = new ArrayList<>();
//        device = new ArrayList<>();
//        problem = new ArrayList<>();
//        proc = new ArrayList<>();
//        dec = new ArrayList<>();
//        recyclerView = findViewById(R.id.recycleview);
//        adapter = new MyAdapter(this,deviceid,date,device,problem,proc,dec);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        displaydata();


        listView = findViewById(R.id.listview);
//        btnback = findViewById(R.id.btnback);
        listItem = new ArrayList<String>();
        db = new DBHelperCom(this);
        viewdata1();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(viewdata_page.this,home_page.class));
            }
        });

    }
    private void viewdata1(){
        Cursor cursor = db.getData();
        if(cursor.getCount() == 0){
            Toast.makeText(getApplicationContext(), "No Data Exists", Toast.LENGTH_SHORT).show();

        }else {
                while(cursor.moveToNext())
                {
                    listItem.add("Deviceid:"+cursor.getString(0));
                    listItem.add("Date :"+cursor.getString(1));
                    listItem.add("Device :"+cursor.getString(2));
                    listItem.add("Problem :"+cursor.getString(3));
                    listItem.add("Problem Occ"+cursor.getString(4));
                    listItem.add("Dec :"+cursor.getString(5));
                    listItem.add("\n");
                }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listItem);
            listView.setAdapter(adapter);
        }
    }
}