package com.example.myapplication.ui.sign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.HomeActivity;
import com.example.myapplication.R;

public class RegisterActivity extends AppCompatActivity {
Button buttonRegister;
EditText editTextUserName;
EditText editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=editTextUserName.getText().toString();
                String password=editTextPassword.getText().toString();
                    Intent intent=new Intent(RegisterActivity.this, HomeActivity.class);
                    startActivity(intent);
                    Toast.makeText(RegisterActivity.this, "Register Success", Toast.LENGTH_LONG).show();
            }
        });
    }
    private void initViews() {
        buttonRegister=findViewById(R.id.btn_register_register_activity);
        editTextUserName=findViewById(R.id.et_username_register_activity);
        editTextPassword=findViewById(R.id.et_password);
    }
}