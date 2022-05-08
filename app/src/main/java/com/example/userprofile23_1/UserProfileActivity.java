package com.example.userprofile23_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class UserProfileActivity extends AppCompatActivity {

    private TextView tvNickName,tvAccount,tvGender,tvCity,tvHome,tvSchool;
    private String who = "未登录";

    private ImageView ivAvatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profilectivity);
        Intent intent = getIntent();
        if (intent != null)
            who = intent.getStringExtra("account");
        if (who == null)
            who = "未登录";
        initView();
        initData();
        if (who.equals("未登录")) {
            Button button = findViewById(R.id.logout);
            button.setText("登录");
            tvNickName.setText("未登录");
            tvAccount.setText("未登录");
            tvGender.setText("");
            tvCity.setText("未登录");
            tvHome.setText("未登录");
            tvSchool.setText("未登录");
            findViewById(R.id.myCollect).setVisibility(View.INVISIBLE);
            findViewById(R.id.myTranslate).setVisibility(View.INVISIBLE);
        }
        LinearLayout index = findViewById(R.id.index);
        index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileActivity.this, IndexActivity.class);
                intent.putExtra("account", who);
                startActivity(intent);
            }
        });

        LinearLayout find = findViewById(R.id.find);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileActivity.this, TranslateActivity.class);
                intent.putExtra("account", who);
                startActivity(intent);
            }
        });
    }



    private void initData() {
        getDataFromSpf();
    }

    private void getDataFromSpf() {
        SharedPreferences spfRecord = getSharedPreferences("spfRecord", MODE_PRIVATE);
        String account = spfRecord.getString("account", "账号");
        String nickName = spfRecord.getString("nick_name", "昵称");
        String city = spfRecord.getString("city", "深圳");
        String gender = spfRecord.getString("gender", "性别");
        String school = spfRecord.getString("school", "学校");
        String image64 = spfRecord.getString("image_64", "");


        tvAccount.setText(account);
        tvNickName.setText(nickName);
        tvHome.setText(city);
        tvSchool.setText(school);
        tvGender.setText(gender);
        tvCity.setText(city);

        ivAvatar.setImageBitmap(ImageUtil.base64ToImage(image64));

    }

    private void initView() {
        tvAccount = findViewById(R.id.tv_account_text);
        tvNickName = findViewById(R.id.tv_nick_name);
        tvHome = findViewById(R.id.tv_home_text);
        tvSchool = findViewById(R.id.tv_school_text);
        tvGender = findViewById(R.id.tv_gender);
        tvCity = findViewById(R.id.tv_city);
        ivAvatar = findViewById(R.id.iv_avatar);

    }

    public void toCollect(View view) {
        Intent intent = new Intent(this, CollectActivity.class);
        intent.putExtra("account", who);
        startActivity(intent);
    }

    public void toEdit(View view) {
        Intent intent = new Intent(this, EditProfileActivity.class);
        intent.putExtra("account", who);
        startActivity(intent);
    }

    public void logout(View view) {
        SharedPreferences spf = getSharedPreferences("spfRecord", MODE_PRIVATE);
        SharedPreferences.Editor edit = spf.edit();
        edit.putBoolean("isLogin", false);
        edit.putBoolean("isAutoLogin", false);
        edit.apply();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        this.finish();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences spf = getSharedPreferences("spfRecord", MODE_PRIVATE);
        spf.edit().putBoolean("isLogin", false);
    }
}