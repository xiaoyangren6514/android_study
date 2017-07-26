package com.happy.mvvm.domain;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by zhonglongquan on 2017/7/26.
 */

public class Student {
    private String name;
    private int age;
    private String imageUrl;

    public Student(String name, int age, String imageUrl) {
        this.name = name;
        this.age = age;
        this.imageUrl = imageUrl;
    }

    @BindingAdapter("bind:userimage")
    public static void loadImage(ImageView imageView, String imageUrl) {
        ImageLoader.getInstance().displayImage(imageUrl, imageView);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
