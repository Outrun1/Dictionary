package com.example.userprofile23_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class IndexActivity extends AppCompatActivity {
    private String who = "未登录";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        getSupportActionBar().setTitle("主页");

        SharedPreferences spf = getSharedPreferences("spfRecord", MODE_PRIVATE);
        boolean isLogin = spf.getBoolean("isLogin", false);
        boolean isAutoLogin = spf.getBoolean("isAutoLogin", false);

        Intent intent = getIntent();
        if (intent != null && intent.getStringExtra("account") != null)
            who = intent.getStringExtra("account");
        if (isLogin && isAutoLogin) {
            who = spf.getString("account", "未登录");
        }
        LinearLayout mine = findViewById(R.id.mine);
        mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndexActivity.this, UserProfileActivity.class);
                intent.putExtra("account", who);
                startActivity(intent);
            }
        });

        LinearLayout find = findViewById(R.id.find);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndexActivity.this, TranslateActivity.class);
                intent.putExtra("account", who);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences spf = getSharedPreferences("spfRecord", MODE_PRIVATE);
        spf.edit().putBoolean("isLogin", false);
    }
}