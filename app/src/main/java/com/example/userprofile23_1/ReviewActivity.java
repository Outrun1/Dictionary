package com.example.userprofile23_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ReviewActivity extends AppCompatActivity {
    private String who = "未登录";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        if (intent != null)
            who = intent.getStringExtra("account");
        if (who == null)
            who = "未登录";
    }
    public void back(View view) {
        Intent intent = new Intent(ReviewActivity.this, IndexActivity.class);
        intent.putExtra("account", who);
        startActivity(intent);
    }
    public void collect(View view) {

    }
}