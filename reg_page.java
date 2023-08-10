package com.example.project02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class reg_page extends AppCompatActivity {
    EditText regusername,regemail,regpassword,regcpass;
    Button btnreg;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_page);

        regusername = findViewById(R.id.regusername);
        regemail = findViewById(R.id.regemail);
        regpassword = findViewById(R.id.regpassword);
        regcpass = findViewById(R.id.regcpass);
        btnreg = findViewById(R.id.btnreg);
        tv = findViewById(R.id.textView7);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reg_page.this,login_page.class));
            }
        });

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = regusername.getText().toString();
                String email = regemail.getText().toString();
                String password = regpassword.getText().toString();
                String cpass = regcpass.getText().toString();
                database db = new database(getApplicationContext(),"project02",null,1);
                if(username.length() == 0 || email.length() == 0 || password.length() == 0 || cpass.length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "Please Fill All Details", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(password.compareTo(cpass)==0) {
                        if (isValid(password)) {
                            db.register(username,email,password);
                            Toast.makeText(getApplicationContext(), "Recode inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(reg_page.this,login_page.class));
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "please must contain  at 8 character , having letter , digit letter and special symbol ", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "password and confirm password didn't match", Toast.LENGTH_SHORT).show();
                    }
            }
            }
        });
    }
    public static boolean isValid(String passwordhere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwordhere.length() < 8) {
            return false;
        } else {
            for(int p=0;p<passwordhere.length();p++)
            {
                if(Character.isLetter(passwordhere.charAt(p)))
                {
                    f1=1;
                }
            }
            for(int r=0;r<passwordhere.length();r++)
            {
                if(Character.isDigit(passwordhere.charAt(r)))
                {
                    f2=1;
                }
            }
            for(int s=0;s<passwordhere.length();s++)
            {
                    char c = passwordhere.charAt(s);
                    if(c>=33&&c<=46||c==64){
                    f3=1;
                    }

            }
            if(f1 == 1 && f2 == 1 && f3 == 1)
                return true;
            return false;
        }
    }
}