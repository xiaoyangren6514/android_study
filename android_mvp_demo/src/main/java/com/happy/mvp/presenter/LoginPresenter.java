package com.happy.mvp.presenter;

import android.os.Handler;

import com.happy.mvp.model.IUserLoginModel;
import com.happy.mvp.model.IUserLoginModelImpl;
import com.happy.mvp.view.ILoginView;

/**
 * Created by zhonglongquan on 2017/7/27.
 */

public class LoginPresenter implements ILoginPresenter {

    private ILoginView iLoginView;

    private IUserLoginModel iUserLoginModel;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        iUserLoginModel = new IUserLoginModelImpl();
    }

    @Override
    public void login() {
        iLoginView.showProgress();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.hideProgress();
                int result = iUserLoginModel.doLogin(iLoginView.getUsername(), iLoginView.getPassword());
                if (result == 1) {
                    iLoginView.loginSuccess();
                } else {
                    iLoginView.loginFail();
                }
            }
        }, 3000);
    }

}
