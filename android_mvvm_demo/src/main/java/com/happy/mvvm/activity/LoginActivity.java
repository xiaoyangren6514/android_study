package com.happy.mvvm.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.happy.mvvm.R;
import com.happy.mvvm.databinding.ActivityLoginBinding;
import com.happy.mvvm.domain.User;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        User user = new User();
        activityLoginBinding.setUser(user);
        user = activityLoginBinding.getUser();
    }
}
