package com.example.userprofile23_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.userprofile23_1.bean.Book;

public class MainActivity extends AppCompatActivity {

    private EditText tvContent;
    private MySQLiteOpenHelper mMySQLiteOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvContent = findViewById(R.id.tv_content);
        mMySQLiteOpenHelper = new MySQLiteOpenHelper(this);

        Intent intent = getIntent();
        String account;
        if (intent != null)
            account = intent.getStringExtra("account");
        else
            account = "未登录";

    }

    public void logout(View view) {
//        String name = tvContent.getText().toString().trim();
//
//        Book book = new Book();
//        book.setName(name);
//        book.setIsSelected(0);
//
//        // 插入数据库中
//        mMySQLiteOpenHelper.insertBook(book);

        mMySQLiteOpenHelper.initData(getResources());
    }
}