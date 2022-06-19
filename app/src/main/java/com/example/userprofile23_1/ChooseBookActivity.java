package com.example.userprofile23_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class ChooseBookActivity extends AppCompatActivity {
    private String who = "未登录";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_book);
        getSupportActionBar().setTitle("选择词书");
        Intent intent = getIntent();
        if (intent != null)
            who = intent.getStringExtra("account");
        if (who == null)
            who = "未登录";

        LinearLayout mine = findViewById(R.id.mine);
        mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseBookActivity.this, UserProfileActivity.class);
                intent.putExtra("account", who);
                startActivity(intent);
            }
        });

        LinearLayout find = findViewById(R.id.find);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseBookActivity.this, TranslateActivity.class);
                intent.putExtra("account", who);
                startActivity(intent);
            }
        });

        LinearLayout index = findViewById(R.id.index);
        index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseBookActivity.this, IndexActivity.class);
                intent.putExtra("account", who);
                startActivity(intent);
            }
        });
    }
}