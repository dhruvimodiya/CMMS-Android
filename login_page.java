package com.example.project02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login_page extends AppCompatActivity {
    EditText txtusername,txtpassword;
    Button btnlogin;
    private static final String FILE_NAME = "myfile";
    TextView tv;
    CheckBox remeber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        txtusername=findViewById(R.id.txtusername);
        txtpassword=findViewById(R.id.txtpassword);
        btnlogin=findViewById(R.id.btnlogin);
        tv=findViewById(R.id.textView3);
        remeber = findViewById(R.id.remember);

        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME,MODE_PRIVATE);
        String username = sharedPreferences.getString("username","");
        String password = sharedPreferences.getString("password","");

        txtpassword.setText(password);
        txtusername.setText(username);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtusername.getText().toString();
                String password = txtpassword.getText().toString();
                if(remeber.isChecked())
                {
                    StoredDataUsingSHaredPref(username,password);
                }
                Intent intent = new Intent(getApplicationContext(),home_page.class);
                startActivity(intent);

                database db = new database(getApplicationContext(),"project02",null,1);
                if(username.length() == 0 || password.length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "Please Fill All Details", Toast.LENGTH_SHORT).show();
                }else{
                    if(db.login(username,password)==1)
                    {
                        Toast.makeText(getApplicationContext(), "login Success", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username",username);
                        //to save the data with key and values
                        editor.apply();
                        startActivity(new Intent(login_page.this,home_page.class));
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "invalid username and password", Toast.LENGTH_SHORT).show();
                    }
            }
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login_page.this,reg_page.class));
            }
        });
    }
    private void StoredDataUsingSHaredPref(String username, String password) {
        SharedPreferences.Editor editor = getSharedPreferences(FILE_NAME,MODE_PRIVATE).edit();
        editor.putString("username",username);
        editor.putString("password",password);
        editor.apply();
    }
}