package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView textViewChats;
    TextView textViewStatus;
    TextView textViewCall;
    private static final String TAG = "HomeActivity"; //logt
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
        //specific logcat
        Log.i(TAG, "onCreate: ");  //logi
        //to show chat the frist
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.continer,new ChatFragment())
                .commit();

        textViewChats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new ChatFragment());
            }
        });
        textViewStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new StatusFragment());
            }
        });
        textViewCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new CallFragment());
            }
        });
    }
    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.continer,fragment)
                .commit();
    }
    private void initViews() {
        textViewChats=findViewById(R.id.tv_chats_home_activity);
        textViewCall=findViewById(R.id.tv_calls_home_activity);
        textViewStatus=findViewById(R.id.tv_status_home_activity);
    }
}