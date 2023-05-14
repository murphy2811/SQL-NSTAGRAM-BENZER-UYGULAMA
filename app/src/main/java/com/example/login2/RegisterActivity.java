package com.example.login2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText username,email,name,password;
    TextView back;
    Button kaydol;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username=findViewById(R.id.kullaniciAdi);
        email=findViewById(R.id.kullaniciEmail);
        name=findViewById(R.id.Adi);
        password=findViewById(R.id.kullaniciSifre);
        kaydol=findViewById(R.id.btnkaydol);

        kaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namee=name.getText().toString();
                String usernamee=username.getText().toString();
                String emaill=email.getText().toString();
                String passwordd=password.getText().toString();
                Database db = new Database(getApplicationContext(),"LoginApp",null,1);
                if(!TextUtils.isEmpty(namee) && !TextUtils.isEmpty(emaill) && !TextUtils.isEmpty(usernamee) && !TextUtils.isEmpty(passwordd)){
                    db.Register(namee,usernamee,emaill,passwordd);
                    Toast.makeText(RegisterActivity.this, "Başarıyla Kayıt Oldunuz", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                }else{
                    Toast.makeText(RegisterActivity.this, "Bilgiler Boş Olamaz", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}