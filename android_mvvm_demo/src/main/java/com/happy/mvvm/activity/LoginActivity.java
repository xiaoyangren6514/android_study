package com.happy.mvvm.activity;

import android.app.ProgressDialog;
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
 * 此功能以MVVP为主，结合MVP view接口引用和现工程代码controller进行处理的。
 * 可结合项目中event事件分发，这样就更方便了
 * 单／双向绑定
 */
public class LoginActivity extends AppCompatActivity implements UserLoginInterface {

    private UserController userController = UserController.getInstance();

    private User user = new User();

    private ActivityLoginBinding activityLoginBinding;

    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        activityLoginBinding.setUser(user);
        userController.setUserLoginInterface(this);
        pd = new ProgressDialog(this);
        pd.setMessage("登录中...");
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
        user.setUserName("admin");
        user.setPassWord("12345");
        Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dismissDialog() {
        pd.dismiss();
    }

    @Override
    public void showDialog() {
        pd.show();
    }

}
