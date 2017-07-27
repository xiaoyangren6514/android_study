package com.happy.mvp.view.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.happy.mvp.R;
import com.happy.mvp.presenter.ILoginPresenter;
import com.happy.mvp.presenter.LoginPresenter;
import com.happy.mvp.view.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    private EditText userNameView, passWordView;

    private ProgressDialog progressDialog;

    private ILoginPresenter loginPresenter = new LoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userNameView = (EditText) findViewById(R.id.et_username);
        passWordView = (EditText) findViewById(R.id.et_password);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("登录中...");
    }

    public void login(View view) {
        loginPresenter.login();
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void loginFail() {
        Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getUsername() {
        return userNameView.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return passWordView.getText().toString().trim();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }
}
