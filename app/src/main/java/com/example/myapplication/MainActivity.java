package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.ui.sign.CustomDialogeFragment;

public class MainActivity extends AppCompatActivity {

    Button buttonOpenDialoge;
    TextView textView;
    EditText editTextEmail;
    Button buttonPopUpMenu;
    private static final String TAG = "MainActivity";//logt



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optional_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        if (id==R.id.profile_menu_item){
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
            String name=editTextEmail.getText().toString();
            Bundle bundle=new Bundle();
            bundle.putString("Name",name);
            MainFragment mainFragment=new MainFragment();
            mainFragment.setArguments(bundle);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.continer_fragment,mainFragment)
                    .commit();
            Log.i(TAG, "onOptionsItemSelected: "+name);

        }else if (id==R.id.logout_menu_item){
            Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.item_copy){
            Toast.makeText(this, "Text Copied", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Text Paste", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tv_context_menu_main_activity);
        buttonOpenDialoge=findViewById(R.id.btn_open_dialoge_main_activity);
        editTextEmail=findViewById(R.id.et_email_main_activity);
        buttonPopUpMenu=findViewById(R.id.btn_pop_up_menu);
        buttonPopUpMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu=new PopupMenu(MainActivity.this,buttonPopUpMenu);
                popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu,popupMenu.getMenu());
                popupMenu.show();
                Log.i(TAG, "onClick: ");
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int id=menuItem.getItemId();
                        if (id==R.id.item_one){
                            Toast.makeText(MainActivity.this, "One Item", Toast.LENGTH_SHORT).show();
                        } else if (id==R.id.item_two) {
                            Toast.makeText(MainActivity.this, "Two Item", Toast.LENGTH_LONG).show();
                        }
                        return false;
                    }
                });
            }
        });
        buttonOpenDialoge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(new CustomDialogeFragment(),"Custome Dialoge")
                        .commit();
            }
        });
        registerForContextMenu(textView);
    }
}