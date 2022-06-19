package com.example.userprofile23_1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.userprofile23_1.bean.Book;

import java.util.List;

public class ChooseBookActivity extends AppCompatActivity {
    private String who = "未登录";
    private MySQLiteOpenHelper mMySQLiteOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_book);
        getSupportActionBar().setTitle("选择词书");
        mMySQLiteOpenHelper = new MySQLiteOpenHelper(this);

        Intent intent = getIntent();
        if (intent != null)
            who = intent.getStringExtra("account");
        if (who == null)
            who = "未登录";

        updateView();
        initEvent();
    }

    void initEvent() {
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

        findViewById(R.id.book1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMySQLiteOpenHelper.chooseBook(1);
                updateView();
            }
        });
       findViewById(R.id.book2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMySQLiteOpenHelper.chooseBook(2);
                updateView();
            }
        });
       findViewById(R.id.book3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMySQLiteOpenHelper.chooseBook(3);
                updateView();
            }
        });
       findViewById(R.id.book4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMySQLiteOpenHelper.chooseBook(4);
                updateView();
            }
        });
       findViewById(R.id.book5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMySQLiteOpenHelper.chooseBook(5);
                updateView();
            }
        });
       findViewById(R.id.book6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMySQLiteOpenHelper.chooseBook(6);
                updateView();
            }
        });
       findViewById(R.id.book7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMySQLiteOpenHelper.chooseBook(8);
                updateView();
            }
        });
       findViewById(R.id.book8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMySQLiteOpenHelper.chooseBook(9);
                updateView();
            }
        });
       findViewById(R.id.book9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMySQLiteOpenHelper.chooseBook(7);
                updateView();
            }
        });
    }

    @SuppressLint("NewApi")
    void updateView() {
        List<Book> books = mMySQLiteOpenHelper.queryAllFromDb();
        for (Book book : books) {
            switch (book.getId()) {
                case 1 :
                    ImageView menu = findViewById(R.id.book1);
                    if (book.getIsSelected() == 1)
                        menu.setBackground(getDrawable(R.drawable.ic_baseline_selected_book));
                    else
                        menu.setBackground(getDrawable(R.drawable.ic_baseline_book_24));
                    break;
                case 2 :
                    ImageView menu2 = findViewById(R.id.book2);
                    if (book.getIsSelected() == 1)
                        menu2.setBackground(getDrawable(R.drawable.ic_baseline_selected_book));
                    else
                        menu2.setBackground(getDrawable(R.drawable.ic_baseline_book_24));
                    break;
                case 3 :
                    ImageView menu3 = findViewById(R.id.book3);
                    if (book.getIsSelected() == 1)
                        menu3.setBackground(getDrawable(R.drawable.ic_baseline_selected_book));
                    else
                        menu3.setBackground(getDrawable(R.drawable.ic_baseline_book_24));
                    break;
               case 4 :
                    ImageView menu4 = findViewById(R.id.book4);
                    if (book.getIsSelected() == 1)
                        menu4.setBackground(getDrawable(R.drawable.ic_baseline_selected_book));
                    else
                        menu4.setBackground(getDrawable(R.drawable.ic_baseline_book_24));
                   break;
                case 5 :
                    ImageView menu5= findViewById(R.id.book5);
                    if (book.getIsSelected() == 1)
                        menu5.setBackground(getDrawable(R.drawable.ic_baseline_selected_book));
                    else
                        menu5.setBackground(getDrawable(R.drawable.ic_baseline_book_24));
                    break;
                case 6 :
                    ImageView menu6 = findViewById(R.id.book6);
                    if (book.getIsSelected() == 1)
                        menu6.setBackground(getDrawable(R.drawable.ic_baseline_selected_book));
                    else
                        menu6.setBackground(getDrawable(R.drawable.ic_baseline_book_24));
                    break;
               case 7 :
                    ImageView menu7 = findViewById(R.id.book9);
                    if (book.getIsSelected() == 1)
                        menu7.setBackground(getDrawable(R.drawable.ic_baseline_selected_book));
                    else
                        menu7.setBackground(getDrawable(R.drawable.ic_baseline_book_24));
                   break;
                case 8 :
                    ImageView menu8 = findViewById(R.id.book7);
                    if (book.getIsSelected() == 1)
                        menu8.setBackground(getDrawable(R.drawable.ic_baseline_selected_book));
                    else
                        menu8.setBackground(getDrawable(R.drawable.ic_baseline_book_24));
                    break;
                case 9 :
                    ImageView menu9 = findViewById(R.id.book8);
                    if (book.getIsSelected() == 1)
                        menu9.setBackground(getDrawable(R.drawable.ic_baseline_selected_book));
                    else
                        menu9.setBackground(getDrawable(R.drawable.ic_baseline_book_24));
            }
        }
    }
}