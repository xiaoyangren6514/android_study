package com.happy.mvp.view;

/**
 * Created by zhonglongquan on 2017/7/27.
 */

public interface ILoginView {
    void showProgress();

    void hideProgress();

    void loginFail();

    String getUsername();

    String getPassword();

    void loginSuccess();

}
