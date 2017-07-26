package com.happy.mvvm.domain;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.happy.mvvm.BR;

/**
 * Created by zhonglongquan on 2017/7/26.
 */

public class User extends BaseObservable {

    private String userName;
    private String passWord;

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
        notifyPropertyChanged(BR.passWord);
    }

}
