package com.example.project02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class complain_page extends AppCompatActivity {
    EditText txtproblem,txtproc,txtdec,txtdevice,txtdeviceid;
    Button btnsubmitcomplain,datepicker;
    TextView tvdate,tv;
    ImageButton close;
    DBHelperCom db;
    //private int mYear, mMonth, mDay, mHour, mMinute;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain_page);
        txtproblem = findViewById(R.id.txtproblem);
        txtproc = findViewById(R.id.txtproc);
        txtdec = findViewById(R.id.txtdec);
        tv = findViewById(R.id.tv);
        txtdevice = findViewById(R.id.txtdevice);
        txtdeviceid = findViewById(R.id.txtdeviceid);
        close = findViewById(R.id.close);
        btnsubmitcomplain = findViewById(R.id.btnsubmitcomplain);
        datepicker = findViewById(R.id.datepicker);
        tvdate = findViewById(R.id.tvdate);
        db = new DBHelperCom(this);

        datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendailog();
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(complain_page.this,updel_page.class));
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(complain_page.this,home_page.class));
            }
        });
        btnsubmitcomplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deviceid = txtdeviceid.getText().toString();
                String date = tvdate.getText().toString();
                String device = txtdevice.getText().toString();
                String problem = txtproblem.getText().toString();
                String proc = txtproc.getText().toString();
                String dec = txtdec.getText().toString();
                if(deviceid.length()==0 || date.length()==0 || device.length()==0 || problem.length()==0 || proc.length()==0 || dec.length()==0 )
                {
                    Toast.makeText(getApplicationContext(), "please fill all the field", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean checkcomplain = db.insertcomdata(deviceid, date, device, problem, proc, dec);
                    if (checkcomplain == true) {
                        Toast.makeText(getApplicationContext(), "complain register", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    private void opendailog() {
            DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    tvdate.setText(String.valueOf(year) + "." + String.valueOf(month)+1 + "." + String.valueOf(day));
                }
            }, 2023, 0, 15);
            dialog.show();
        }
    }
