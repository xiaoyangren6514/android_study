package com.happy.mvvm.interfaces;

/**
 * Created by zhonglongquan on 2017/7/26.
 */

public interface UserLoginInterface {
    public void onLoginSuccess();

    public void onLoginFail();

    public void dismissDialog();

    public void showDialog();
}
