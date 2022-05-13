package com.example.myapplication.ui.sign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.HomeActivity;
import com.example.myapplication.R;

public class LoginActivity extends AppCompatActivity {

    TextView textViewSign;
    Button login_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_button=findViewById(R.id.login_button_to_home);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btn_log=new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(btn_log);
            }
        });
        textViewSign=findViewById(R.id.tv_sign_login_activity);
        textViewSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}