package com.happy.mvp.model;

import android.text.TextUtils;

/**
 * Created by zhonglongquan on 2017/7/27.
 */

public class IUserLoginModelImpl implements IUserLoginModel {

    @Override
    public int doLogin(String userName, String passWord) {
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord)) {
            return -1;
        }
        if (userName.equals("admin") && passWord.equals("12345")) {
            return 1;
        }
        return -1;
    }

}
