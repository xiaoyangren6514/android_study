package com.happy.mvvm.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.happy.mvvm.R;
import com.happy.mvvm.databinding.ActivityImageViewBinding;
import com.happy.mvvm.domain.Student;

/**
 * xml 加载图片时，使用的是app:userimage自定义属性名，而不再是android，此处同自定义空间的属性
 */
public class ImageViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityImageViewBinding activityImageViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_image_view);
        Student student = new Student("旺财", 19, "http://img1.imgtn.bdimg.com/it/u=947982974,538813931&fm=26&gp=0.jpg");
        activityImageViewBinding.setStudent(student);
    }

}
