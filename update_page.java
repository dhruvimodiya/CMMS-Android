package com.example.project02;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class update_page extends AppCompatActivity {
    EditText txtproblem,txtproc,txtdec,txtdevice,txtdeviceid;
    Button btnsubmitcomplain,datepicker;
    ImageButton close;
    TextView tvdate;
    DBHelperCom db;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_page);
        txtproblem = findViewById(R.id.txtproblem);
        txtproc = findViewById(R.id.txtproc);
        txtdec = findViewById(R.id.txtdec);
        txtdevice = findViewById(R.id.txtdevice);
        close = findViewById(R.id.close);
        txtdeviceid = findViewById(R.id.txtdeviceid);
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
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(update_page.this,updel_page.class));
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

                Boolean checkupdateddata = db.updateuserdata(deviceid, date, device, problem, proc, dec);
                if(checkupdateddata == true){
                    Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "device id not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void opendailog() {
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                tvdate.setText(String.valueOf(year) + "." + String.valueOf(month) + "." + String.valueOf(day));
            }
        }, 2023, 0, 15);
        dialog.show();
    }
}