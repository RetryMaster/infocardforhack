package com.example.last;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginRuActivity extends AppCompatActivity {
    Button button_login;
    Button btn_login_en;
    Button btn_login_tat;
    Button btn_login_ru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ru);
        button_login = (Button) findViewById(R.id.button_login);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), MenuRuActivity.class);
                startActivity(intent);
            }

        });
        btn_login_en = (Button) findViewById(R.id.btn_login_en);
        btn_login_en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), LoginEnActivity.class);
                startActivity(intent);
            }

        });
        btn_login_tat = (Button) findViewById(R.id.btn_login_tat);
        btn_login_tat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), LoginTatActivity.class);
                startActivity(intent);
            }

        });
        btn_login_ru = (Button) findViewById(R.id.btn_login_ru);
        btn_login_ru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), LoginRuActivity.class);
                startActivity(intent);
            }

        });
    }
}