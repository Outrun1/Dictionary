package com.example.userprofile23_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Map;

public class LearnActivity extends AppCompatActivity {

    private TextView word, translate1, translate2, translate3, translate4;
    private LinearLayout layout1, layout2, layout3, layout4;
    private ImageView imageView1, imageView2, imageView3, imageView4, collect;
    private Button next;
    private String who = "未登录";
    private MySQLiteOpenHelper mMySQLiteOpenHelper;
    Map<String, String> words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        getSupportActionBar().hide();
        mMySQLiteOpenHelper = new MySQLiteOpenHelper(this);
        words = mMySQLiteOpenHelper.getWords(0, null);

        Intent intent = getIntent();
        if (intent != null)
            who = intent.getStringExtra("account");
        if (who == null)
            who = "未登录";
        initView();
        initEvent();
    }

    @SuppressLint("NewApi")
    void initView() {
        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);
        layout4 = findViewById(R.id.layout4);
        layout1.setBackground(getDrawable(R.drawable.setbar_bg));
        layout2.setBackground(getDrawable(R.drawable.setbar_bg));
        layout3.setBackground(getDrawable(R.drawable.setbar_bg));
        layout4.setBackground(getDrawable(R.drawable.setbar_bg));
        layout1.setClickable(true);
        layout2.setClickable(true);
        layout3.setClickable(true);
        layout4.setClickable(true);

        imageView1 = findViewById(R.id.image1);
        imageView2 = findViewById(R.id.image2);
        imageView3 = findViewById(R.id.image3);
        imageView4 = findViewById(R.id.image4);
        next = findViewById(R.id.next);
        imageView1.setVisibility(View.INVISIBLE);
        imageView2.setVisibility(View.INVISIBLE);
        imageView3.setVisibility(View.INVISIBLE);
        imageView4.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);

        word = findViewById(R.id.word);
        translate1 = findViewById(R.id.translate1);
        translate2 = findViewById(R.id.translate2);
        translate3 = findViewById(R.id.translate3);
        translate4 = findViewById(R.id.translate4);


        word.setText(words.get("word"));
        translate1.setText(words.get("translate"));
        translate2.setText(words.get("translate1"));
        translate3.setText(words.get("translate2"));
        translate4.setText(words.get("translate3"));

        collect = findViewById(R.id.collect);

    }

    @SuppressLint("NewApi")
    void initEvent() {
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout1.setBackground(getDrawable(R.color.textSelect));
                setCheck(1);
                layout1.setClickable(false);
                layout2.setClickable(false);
                layout3.setClickable(false);
                layout4.setClickable(false);
            }
        });
       layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout2.setBackground(getDrawable(R.color.textSelect));
                setCheck(2);
                layout1.setClickable(false);
                layout2.setClickable(false);
                layout3.setClickable(false);
                layout4.setClickable(false);
            }
        });
       layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout3.setBackground(getDrawable(R.color.textSelect));
                setCheck(3);
                layout1.setClickable(false);
                layout2.setClickable(false);
                layout3.setClickable(false);
                layout4.setClickable(false);
            }
        });
       layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout4.setBackground(getDrawable(R.color.textSelect));
                setCheck(4);
                layout1.setClickable(false);
                layout2.setClickable(false);
                layout3.setClickable(false);
                layout4.setClickable(false);
            }
        });
       collect.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

           }
       });

       next.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               words = mMySQLiteOpenHelper.getWords(0, Integer.valueOf(words.get("id")));
               initView();
               initEvent();
           }
       });
    }

    @SuppressLint("NewApi")
    void setCheck(int which) {
        imageView1.setVisibility(View.VISIBLE);
        imageView2.setVisibility(View.VISIBLE);
        imageView3.setVisibility(View.VISIBLE);
        imageView4.setVisibility(View.VISIBLE);
        next.setVisibility(View.VISIBLE);

        String text = translate1.getText().toString();
        if (words.get("translate").equals(text)) {
            if (which == 1) {
                imageView1.setBackground(getDrawable(R.drawable.ic_baseline_check_green));
                mMySQLiteOpenHelper.setLearn(words.get("id"));
            }
            else
                imageView1.setBackground(getDrawable(R.drawable.ic_baseline_check_gray));
        } else {
            if (which == 1)
                imageView1.setBackground(getDrawable(R.drawable.ic_baseline_clear_green));
            else
                imageView1.setBackground(getDrawable(R.drawable.ic_baseline_clear_gray));
        }

        text = translate2.getText().toString();
        if (words.get("translate").equals(text)) {
            if (which == 2) {
                imageView2.setBackground(getDrawable(R.drawable.ic_baseline_check_green));
                mMySQLiteOpenHelper.setLearn(words.get("id"));
            }
            else
                imageView2.setBackground(getDrawable(R.drawable.ic_baseline_check_gray));
        } else {
            if (which == 2)
                imageView2.setBackground(getDrawable(R.drawable.ic_baseline_clear_green));
            else
                imageView2.setBackground(getDrawable(R.drawable.ic_baseline_clear_gray));
        }

        text = translate3.getText().toString();
        if (words.get("translate").equals(text)) {
            if (which == 3) {
                imageView3.setBackground(getDrawable(R.drawable.ic_baseline_check_green));
                mMySQLiteOpenHelper.setLearn(words.get("id"));
            }
            else
                imageView3.setBackground(getDrawable(R.drawable.ic_baseline_check_gray));
        } else {
            if (which == 3)
                imageView3.setBackground(getDrawable(R.drawable.ic_baseline_clear_green));
            else
                imageView3.setBackground(getDrawable(R.drawable.ic_baseline_clear_gray));
        }

        text = translate4.getText().toString();
        if (words.get("translate").equals(text)) {
            if (which == 4) {
                imageView4.setBackground(getDrawable(R.drawable.ic_baseline_check_green));
                mMySQLiteOpenHelper.setLearn(words.get("id"));
            }
            else
                imageView4.setBackground(getDrawable(R.drawable.ic_baseline_check_gray));
        } else {
            if (which == 4)
                imageView4.setBackground(getDrawable(R.drawable.ic_baseline_clear_green));
            else
                imageView4.setBackground(getDrawable(R.drawable.ic_baseline_clear_gray));
        }
    }

    public void back(View view) {
        Intent intent = new Intent(LearnActivity.this, IndexActivity.class);
        intent.putExtra("account", who);
        startActivity(intent);
    }
}