package com.happy.mvc.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.happy.mvc.R;
import com.happy.mvc.domain.User;

public class LoginActivity extends Activity implements View.OnClickListener {

    private EditText etNameView;
    private EditText etPwdView;
    private Button btnLoginView;

    private ProgressDialog pd;

    private User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etNameView = (EditText) findViewById(R.id.et_username);
        etPwdView = (EditText) findViewById(R.id.et_pwd);
        btnLoginView = (Button) findViewById(R.id.btn_login);

        btnLoginView.setOnClickListener(this);

        pd = new ProgressDialog(this);
        pd.setMessage("登录中...");
    }

    @Override
    public void onClick(View v) {
        if (v == btnLoginView) {
            final String userName = etNameView.getText().toString().trim();
            final String pwd = etPwdView.getText().toString().trim();
            if (TextUtils.isEmpty(userName)) {
                Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(pwd)) {
                Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            pd.show();
            user.setUserName(userName);
            user.setPassWord(pwd);
            // 模拟登录操作
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        pd.dismiss();
                        if (user.getUserName().equals("admin") && user.getPassWord().equals("12345")) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(LoginActivity.this, "登录成功，进入主页面", Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            });
                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(LoginActivity.this, "用户名或密码错误，请重试", Toast.LENGTH_SHORT).show();
                                    etNameView.setText("admin");
                                    etPwdView.setText("12345");
                                }
                            });
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

}
