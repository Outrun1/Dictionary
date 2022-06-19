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

        Book book1 = new Book();
        book1.setName("character");
        book1.setIsSelected(0);
        mMySQLiteOpenHelper.insertBook(book1);

        Book book2 = new Book();
        book2.setName("character");
        book2.setIsSelected(0);
        mMySQLiteOpenHelper.insertBook(book2);

        Book book3 = new Book();
        book3.setName("character");
        book3.setIsSelected(0);
        mMySQLiteOpenHelper.insertBook(book3);

        Book book4 = new Book();
        book4.setName("character");
        book4.setIsSelected(0);
        mMySQLiteOpenHelper.insertBook(book4);

        Book book5 = new Book();
        book5.setName("character");
        book5.setIsSelected(0);
        mMySQLiteOpenHelper.insertBook(book5);

        Book book6 = new Book();
        book6.setName("character");
        book6.setIsSelected(0);
        mMySQLiteOpenHelper.insertBook(book6);

        Book book7 = new Book();
        book7.setName("character");
        book7.setIsSelected(0);
        mMySQLiteOpenHelper.insertBook(book7);

        Book book8 = new Book();
        book8.setName("character");
        book8.setIsSelected(0);
        mMySQLiteOpenHelper.insertBook(book8);

        Book book9 = new Book();
        book9.setName("character");
        book9.setIsSelected(0);
        mMySQLiteOpenHelper.insertBook(book9);

        mMySQLiteOpenHelper.initData(getResources());
    }
}