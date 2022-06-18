package com.example.userprofile23_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class LearnActivity extends AppCompatActivity {
    private String who = "未登录";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        if (intent != null)
            who = intent.getStringExtra("account");
        if (who == null)
            who = "未登录";
    }

    public void back(View view) {
        Intent intent = new Intent(LearnActivity.this, IndexActivity.class);
        intent.putExtra("account", who);
        startActivity(intent);
    }
    public void collect(View view) {

    }
}