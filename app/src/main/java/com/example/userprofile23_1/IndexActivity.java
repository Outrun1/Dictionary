package com.example.userprofile23_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.userprofile23_1.Translate.Translate;

public class IndexActivity extends AppCompatActivity {
    private String who = "未登录";
    private MySQLiteOpenHelper mMySQLiteOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        mMySQLiteOpenHelper = new MySQLiteOpenHelper(this);
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

        TextView learn = findViewById(R.id.learn);
        learn.setText("Learn\n" + mMySQLiteOpenHelper.getTotalWords(0));

        TextView review = findViewById(R.id.review);
        review.setText("Review\n" + mMySQLiteOpenHelper.getTotalWords(1));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences spf = getSharedPreferences("spfRecord", MODE_PRIVATE);
        spf.edit().putBoolean("isLogin", false);
    }

    public void learn(View view) {
        if (mMySQLiteOpenHelper.getTotalWords(0) == 0) {
            Toast.makeText(IndexActivity.this, "该词书没有需要学习的单词了！", Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent = new Intent(IndexActivity.this, LearnActivity.class);
        intent.putExtra("account", who);
        startActivity(intent);
    }

    public void review(View view) {
        if (mMySQLiteOpenHelper.getTotalWords(1) == 0) {
            Toast.makeText(IndexActivity.this, "该词书没有需要复习的单词了！", Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent = new Intent(IndexActivity.this, ReviewActivity.class);
        intent.putExtra("account", who);
        startActivity(intent);
    }
}