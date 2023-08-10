package com.example.project02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class home_page extends AppCompatActivity {
    CardView service,complain,data,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(), "Welcome" +username, Toast.LENGTH_SHORT).show();

        CardView logout = findViewById(R.id.cradlogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(home_page.this,login_page.class ));
            }
        });

         service = findViewById(R.id.cradservice);
         complain = findViewById(R.id.cradcomplain);
         data = findViewById(R.id.craddata);
         logout =findViewById(R.id.cradlogout);
         logout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 logout();
                 startActivity(new Intent(home_page.this,login_page.class));
             }
         });
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (home_page.this,service_page.class));
            }
        });
        complain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home_page.this,complain_page.class));
            }
        });
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home_page.this,viewdata_page.class));
            }
        });
    }
    public void logout()
    {
        SharedPreferences sp = getSharedPreferences("login",MODE_PRIVATE);
        sp.edit().clear().apply();
        startActivity(new Intent(getApplicationContext(), login_page.class));
    }
}