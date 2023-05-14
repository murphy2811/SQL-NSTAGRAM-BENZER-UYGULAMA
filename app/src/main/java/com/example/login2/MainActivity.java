package com.example.login2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView img1;


    Button btn1,btn2;
    SQLiteDatabase db;
    RelativeLayout pn;
    EditText kAdi,kSifre;
    String kullaniciAdi,kullaniciSifre;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1=findViewById(R.id.img1);
        Animation anim2 =AnimationUtils.loadAnimation(getApplicationContext(),R.anim.panelanim);
        btn1=findViewById(R.id.butongiris);
        btn2=findViewById(R.id.Kaydol);
        kAdi=findViewById(R.id.kullaniciAdi);
        kSifre=findViewById(R.id.kullaniciSifre);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kullaniciAdi=kAdi.getText().toString();
                String kullanicisifre=kSifre.getText().toString();
                Database db= new Database(getApplicationContext(),"LoginApp",null,1);

                if(kullaniciAdi.length()==0 || kullanicisifre.length()==0)
                {
                    Toast.makeText(MainActivity.this, "Kullanıcı adı veya şifre boş bırakılamaz!", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(db.Login(kullaniciAdi,kullanicisifre)==1)
                    {
                        Toast.makeText(MainActivity.this, "Giriş Yapıldı", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,MainActivity2.class));
                        finish();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Geçersiz Kullanıcı Adı vey Şifre", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));

            }
        });

    }
}