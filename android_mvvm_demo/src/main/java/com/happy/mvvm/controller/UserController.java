package com.happy.mvvm.controller;

import android.os.Handler;

import com.happy.mvvm.interfaces.UserLoginInterface;

/**
 * Created by zhonglongquan on 2017/7/26.
 */

public class UserController {

    private UserLoginInterface userLoginInterface;

    public void setUserLoginInterface(UserLoginInterface userLoginInterface) {
        this.userLoginInterface = userLoginInterface;
    }

    private static UserController instance = new UserController();

    private UserController() {

    }

    public static UserController getInstance() {
        return instance;
    }

    public void doLogin(final String userName, final String passWord) {
        userLoginInterface.showDialog();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                userLoginInterface.dismissDialog();
                if (userName.equals("admin") && passWord.equals("12345")) {
                    userLoginInterface.onLoginSuccess();
                } else {
                    userLoginInterface.onLoginFail();
                }
            }
        }, 3000);
    }

}
