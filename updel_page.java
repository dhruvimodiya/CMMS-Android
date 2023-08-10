package com.example.project02;

import androidx.appcompat.app.AppCompatActivity;

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

public class updel_page extends AppCompatActivity {
    DBHelperCom db;
    ImageButton close;
    Button btnupdate,btndelete,btnview;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updel_page);

        btndelete = findViewById(R.id.btndelete);
        btnupdate = findViewById(R.id.btnupdate);
        close = findViewById(R.id.close);
        btnview = findViewById(R.id.btnview);
        db = new DBHelperCom(this);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(updel_page.this,complain_page.class));
            }
        });
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(updel_page.this,update_page.class));
            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(updel_page.this,delete_page.class));
            }
        });
        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(updel_page.this,viewdata_page.class));
            }
        });

    }
}