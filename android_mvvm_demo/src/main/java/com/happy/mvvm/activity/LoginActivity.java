package com.happy.mvvm.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.happy.mvvm.R;
import com.happy.mvvm.controller.UserController;
import com.happy.mvvm.databinding.ActivityLoginBinding;
import com.happy.mvvm.domain.User;
import com.happy.mvvm.interfaces.UserLoginInterface;

/**
 * 单／双向绑定
 */
public class LoginActivity extends AppCompatActivity implements UserLoginInterface {

    private UserController userController = UserController.getInstance();

    private User user;

    private ActivityLoginBinding activityLoginBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        user = new User();
        activityLoginBinding.setUser(user);
        userController.setUserLoginInterface(this);
    }

    public void login(View view) {
        if (TextUtils.isEmpty(user.getUserName()) || TextUtils.isEmpty(user.getPassWord())) {
            Toast.makeText(this, "请输入有效的用户名和密码", Toast.LENGTH_SHORT).show();
            return;
        }
        userController.doLogin(user.getUserName(), user.getPassWord());
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(this, "登录成功，go on", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFail() {
        Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
    }
}
