package com.happy.mvvm.domain;

import android.view.View;
import android.widget.Toast;

/**
 * Created by zhonglongquan on 2017/7/26.
 */

public class User {

    private String userName;
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void onLogin(View view) {
        Toast.makeText(view.getContext(), getUserName() + ":" + getPassWord(), Toast.LENGTH_SHORT).show();
    }

}
