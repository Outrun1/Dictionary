package com.example.userprofile23_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.userprofile23_1.bean.Words;

import java.util.ArrayList;
import java.util.List;

public class CollectActivity extends AppCompatActivity {
    List<Words> data;
    private String who = "未登录";
    private MySQLiteOpenHelper mMySQLiteOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        getSupportActionBar().setTitle("收藏");
        mMySQLiteOpenHelper = new MySQLiteOpenHelper(this);

        Intent intent = getIntent();
        if (intent != null)
            who = intent.getStringExtra("account");
        if (who == null)
            who = "未登录";
        data = mMySQLiteOpenHelper.getCollectWords();

        ListView listView = findViewById(R.id.collect_lv);
        listView.setAdapter(new MyAdapter(data, this));

        LinearLayout mine = findViewById(R.id.mine);
        mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CollectActivity.this, UserProfileActivity.class);
                intent.putExtra("account", who);
                startActivity(intent);
            }
        });

        LinearLayout find = findViewById(R.id.find);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CollectActivity.this, TranslateActivity.class);
                intent.putExtra("account", who);
                startActivity(intent);
            }
        });

        LinearLayout index = findViewById(R.id.index);
        index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CollectActivity.this, IndexActivity.class);
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