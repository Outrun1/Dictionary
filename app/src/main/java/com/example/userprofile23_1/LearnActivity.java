package com.example.userprofile23_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Map;

public class LearnActivity extends AppCompatActivity {

    private TextView word, translate1, translate2, translate3, translate4;
    private String who = "未登录";
    private MySQLiteOpenHelper mMySQLiteOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        getSupportActionBar().hide();
        mMySQLiteOpenHelper = new MySQLiteOpenHelper(this);

        Intent intent = getIntent();
        if (intent != null)
            who = intent.getStringExtra("account");
        if (who == null)
            who = "未登录";
        initView();
        initEvent();
    }

    void initView() {
        word = findViewById(R.id.word);
        translate1 = findViewById(R.id.translate1);
        translate2 = findViewById(R.id.translate2);
        translate3 = findViewById(R.id.translate3);
        translate4 = findViewById(R.id.translate4);
        Map<String, String> words = mMySQLiteOpenHelper.getWords(0);
        word.setText(words.get("word"));
        translate1.setText(words.get("translate"));
        translate2.setText(words.get("translate1"));
        translate3.setText(words.get("translate2"));
        translate4.setText(words.get("translate3"));
    }

    void initEvent() {
        translate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = translate1.getText().toString();

            }
        });
    }

    public void back(View view) {
        Intent intent = new Intent(LearnActivity.this, IndexActivity.class);
        intent.putExtra("account", who);
        startActivity(intent);
    }
    public void collect(View view) {

    }
}