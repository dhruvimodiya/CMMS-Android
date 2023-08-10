package com.example.project02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class service_page extends AppCompatActivity {
    LinearLayout linearlayout1,linearlayout2,linearlayout3,linearlayout4,linearlayout5;
    ImageButton close;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_page);
        close = findViewById(R.id.close);
        builder = new AlertDialog.Builder(this);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(service_page.this,home_page.class));
            }
        });
        linearlayout1 = findViewById(R.id.linearlayout1);
        linearlayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(service_page.this,service_details.class);
//                i.putExtra("title","Hardware repair services");
//                startActivity(i);

                builder.setTitle("Hardware repair services")
                        .setMessage("These professionals use their knowledge in networking and software applications to provide technical support for both employees and customers onsite or remotely.")
                        .setCancelable(true)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                finish();
//                                startActivity(new Intent(service_page.this,complain_page.class));
                            }
                        })
                        .show();
            }
        });

        linearlayout2 = findViewById(R.id.linearlayout2);
        linearlayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(service_page.this,service_details.class);
//                i.putExtra("title","Software repair services");
//                startActivity(i);
                builder.setTitle("Hardware repair services")
                        .setMessage("These professionals use their knowledge in networking and software applications to provide technical support for both employees and customers onsite or remotely.")
                        .setCancelable(true)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                finish();
                            }
                        })
                        .show();
            }
        });

        linearlayout3 = findViewById(R.id.linearlayout3);
        linearlayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(service_page.this,service_details.class);
//                i.putExtra("title","PC Setup / Installation");
//                startActivity(i);
                builder.setTitle("Hardware repair services")
                        .setMessage("These professionals use their knowledge in networking and software applications to provide technical support for both employees and customers onsite or remotely.")
                        .setCancelable(true)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                finish();
                            }
                        })
                        .show();
            }
        });

        linearlayout4 = findViewById(R.id.linearlayout4);
        linearlayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(service_page.this,service_details.class);
//                i.putExtra("title","Motherboard Replacement");
//                startActivity(i);
                builder.setTitle("Hardware repair services")
                        .setMessage("These professionals use their knowledge in networking and software applications to provide technical support for both employees and customers onsite or remotely.")
                        .setCancelable(true)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                finish();
                            }
                        })
                        .show();
            }
        });

        linearlayout5 = findViewById(R.id.linearlayout5);
        linearlayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(service_page.this,service_details.class);
//                i.putExtra("title","Anti-Virus Installation/Removal");
//                startActivity(i);
                builder.setTitle("Hardware repair services")
                        .setMessage("These professionals use their knowledge in networking and software applications to provide technical support for both employees and customers onsite or remotely.")
                        .setCancelable(true)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
            }
        });
    }
}