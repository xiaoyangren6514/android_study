package com.happy.mvc.model;

import com.happy.mvc.domain.User;

/**
 * Created by zhonglongquan on 2017/9/18.
 */

public class LoginManager {
    private static LoginManager instance = new LoginManager();

    private LoginManager() {
    }

    private static LoginManager getInstance() {
        return instance;
    }

    public void login(User user) {
        // check net , start login,  db oprator
    }
}
