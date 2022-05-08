package com.example.userprofile23_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int RESULT_CODE_REGISTER = 0;
    private Button btnRegister;
    private EditText etAccount,etPass,etPassConfirm;
    private CheckBox cbAgree;
    private TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("注册");

        etAccount = findViewById(R.id.et_account);
        etPass = findViewById(R.id.et_password);
        etPassConfirm = findViewById(R.id.et_password_confirm);
        cbAgree = findViewById(R.id.cb_agree);
        btnRegister = findViewById(R.id.btn_register);
        back = findViewById(R.id.back);

        btnRegister.setOnClickListener(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        etAccount.addTextChangedListener(new TextWatcher() {
            //每次EditText文本改变之前的时候，会回调这个方法
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //s     输入框中改变前的字符串信息
                //start 输入框中改变前的字符串的起始位置
                //count 输入框中改变前后的字符串改变数量一般为0
                //after 输入框中改变后的字符串与起始位置的偏移量
            }
            //每次EditText文本改变的时候，会回调这个方法
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //第一个参数s 的含义: 输入框中改变后的字符串信息
                //start 输入框中改变后的字符串的起始位置
                //before 输入框中改变前的字符串的位置 默认为0
                //count 输入框中改变后的一共输入字符串的数量
                
            }
            //每次EditText文本改变之后的时候，会回调这个方法
            @Override
            public void afterTextChanged(Editable s) {
                //edit  输入结束呈现在输入框中的信息

                if (TextUtils.isEmpty(s)) {
                    etAccount.setError("用户名不能为空");
                    return;
                }
                if (s.length() < 6 || s.length() > 12) {
                    etAccount.setError("用户名长度为必须6-12位");
                    return;
                }
                for (int i = 0; i < s.length(); i++) {
                    if (!Character.isDigit(s.charAt(i))) {
                        etAccount.setError("用户名必须为纯数字");
                        return;
                    }
                }
            }
        });
        etPass.addTextChangedListener(new TextWatcher() {
            //每次EditText文本改变之前的时候，会回调这个方法
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //s     输入框中改变前的字符串信息
                //start 输入框中改变前的字符串的起始位置
                //count 输入框中改变前后的字符串改变数量一般为0
                //after 输入框中改变后的字符串与起始位置的偏移量
            }
            //每次EditText文本改变的时候，会回调这个方法
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //第一个参数s 的含义: 输入框中改变后的字符串信息
                //start 输入框中改变后的字符串的起始位置
                //before 输入框中改变前的字符串的位置 默认为0
                //count 输入框中改变后的一共输入字符串的数量
                
            }
            //每次EditText文本改变之后的时候，会回调这个方法
            @Override
            public void afterTextChanged(Editable s) {
                //edit  输入结束呈现在输入框中的信息
                if (TextUtils.isEmpty(s)) {
                    etPass.setError("密码不能为空");
                    return;
                }
                if (s.length() < 8) {
                    etPass.setError("密码长度为必须大于7位");
                    return;
                }

                boolean digit = false;
                boolean charact = false;

                for (int i = 0; i < s.length(); i++) {
                    if (Character.isDigit(s.charAt(i))) {
                        digit = true;
                    } else if (Character.isAlphabetic(s.charAt(i))){
                        charact = true;
                    } else if (s.charAt(i) != '.' && s.charAt(i) != '+' && s.charAt(i) != '-' && s.charAt(i) != '=' && s.charAt(i) != '/') {
                        etPass.setError("密码只能包含数字和字母以及普通符号（.+-=/）");
                        return;
                    }
                }
                if (!digit || !charact) {
                    etPass.setError("密码必须同时包含数字和字母");
                    return;
                }
                
            }
        });
    }

    @Override
    public void onClick(View v) {
        String name = etAccount.getText().toString();
        String pass = etPass.getText().toString();
        String passConfirm = etPassConfirm.getText().toString();

        if (TextUtils.isEmpty(name)) {
            Toast.makeText(RegisterActivity.this, "用户名不能为空", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(RegisterActivity.this, "密码不能为空", Toast.LENGTH_LONG).show();
            return;
        }

        if (name.length() < 6 || name.length() > 12) {
            Toast.makeText(RegisterActivity.this, "用户名长度为必须6-12位", Toast.LENGTH_LONG).show();
            return;
        }

        for (int i = 0; i < name.length(); i++) {
            if (!Character.isDigit(name.charAt(i))) {
                Toast.makeText(RegisterActivity.this, "用户名必须为纯数字", Toast.LENGTH_LONG).show();
                return;
            }
        }

        if (pass.length() < 8) {
            Toast.makeText(RegisterActivity.this, "密码长度为必须大于7位", Toast.LENGTH_LONG).show();
            return;
        }

        boolean digit = false;
        boolean charact = false;

        for (int i = 0; i < pass.length(); i++) {
            if (Character.isDigit(pass.charAt(i))) {
                digit = true;
            } else if (Character.isAlphabetic(pass.charAt(i))){
                charact = true;
            } else if (pass.charAt(i) != '.' && pass.charAt(i) != '+' && pass.charAt(i) != '-' && pass.charAt(i) != '=' && pass.charAt(i) != '/') {
                Toast.makeText(RegisterActivity.this, "密码只能包含数字和字母以及普通符号（.+-=/）", Toast.LENGTH_LONG).show();
                return;
            }
        }
        if (!digit || !charact) {
            Toast.makeText(RegisterActivity.this, "密码必须同时包含数字和字母", Toast.LENGTH_LONG).show();
            return;
        }

        if (!TextUtils.equals(pass,passConfirm)) {
            Toast.makeText(RegisterActivity.this, "密码不一致", Toast.LENGTH_LONG).show();
            return;
        }

        // 存储注册的用户名 密码
        SharedPreferences spf = getSharedPreferences("spfRecord", MODE_PRIVATE);
        SharedPreferences.Editor edit = spf.edit();
        edit.putString("account", name);
        edit.putString("password", pass);
        edit.apply();

        // 数据回传
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("account",name);
        bundle.putString("password",pass);
        intent.putExtras(bundle);
        setResult(RESULT_CODE_REGISTER,intent);


        Toast.makeText(RegisterActivity.this, "注册成功！", Toast.LENGTH_LONG).show();
        this.finish();
    }
}