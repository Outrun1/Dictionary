package com.example.userprofile23_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CollectActivity extends AppCompatActivity {
    List<Bean> data = new ArrayList<>();
    private String who = "未登录";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        getSupportActionBar().setTitle("收藏");
        Intent intent = getIntent();
        if (intent != null)
            who = intent.getStringExtra("account");
        if (who == null)
            who = "未登录";
        for (int i = 0; i < 100; i++) {
            Bean bean = new Bean();
            bean.setName("单词" + i + "\n" + "翻译" + i);
            data.add(bean);
        }

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