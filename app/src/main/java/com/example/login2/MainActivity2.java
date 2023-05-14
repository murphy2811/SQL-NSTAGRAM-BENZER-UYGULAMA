package com.example.login2;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity2 extends AppCompatActivity {


    BottomNavigationView bottomNavim;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bottomNavim = findViewById(R.id.bnavim);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new HomeFrag()).commit();

       bottomNavim.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {

               switch (item.getItemId()){
                 case R.id.home:
                     getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new HomeFrag()).commit();
                     break;
                 case R.id.search:
                     getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new SearchFrag()).commit();
                 break;
                     case R.id.person:
                     getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new PersonFrag()).commit();
                     break;
             }
               return true;
           }
       });



    }
    public void onBackPressed() {
    Intent geriIntent=new Intent(MainActivity2.this,MainActivity.class);
    finish();
        startActivity(geriIntent);

    }
}

