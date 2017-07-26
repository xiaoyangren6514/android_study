package com.happy.mvvm.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.happy.mvvm.R;
import com.happy.mvvm.databinding.ActivityTestBinding;
import com.happy.mvvm.domain.UserEntity;

/**
 * 1. 基本的三目运算
 *      @{user.username??user.nickname} 两个??表示如果username属性为null则显示nickname属性，否则显示username属性
 * 2. 字符拼接
 *      @{`username is :`+user.username} 目前单引号需要使用esc按键字符
 * 3. 根据数据显示文本样式
 *      @{user.age>20?0xFF0000FF:0xFFFF0000}  DataBinding对于基本的四则运算、逻辑与、逻辑或、取反位移等都是支持的
 */
public class TextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTestBinding activityTestBinding = DataBindingUtil.
                setContentView(this, R.layout.activity_test);
        UserEntity user = new UserEntity();
        user.setAge(34);
        user.setUsername("zhangsan");
        user.setNickname("张三");
        activityTestBinding.setUser(user);
    }

}
