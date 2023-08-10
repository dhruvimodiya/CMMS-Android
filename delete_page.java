package com.example.project02;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class delete_page extends AppCompatActivity {
    EditText txtdeviceid;
    Button btnsubmitcomplain;
    ImageButton close;
    DBHelperCom db;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_page);
        txtdeviceid = findViewById(R.id.txtdeviceid);
        close = findViewById(R.id.close);
        btnsubmitcomplain = findViewById(R.id.btnsubmitcomplain);
        db = new DBHelperCom(this);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(delete_page.this,updel_page.class));
            }
        });

        btnsubmitcomplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deviceid = txtdeviceid.getText().toString();
                Boolean checkdeletedata = db.deletedata(deviceid);
                if(checkdeletedata == true){
                    Toast.makeText(getApplicationContext(), "Deleted Successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "device id not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}