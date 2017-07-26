package com.happy.rvdemo.domain;

import java.io.Serializable;

/**
 * Created by zhonglongquan on 2017/4/6.
 */

public class Student implements Serializable {
    private String name;
    private int resId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public Student(String name, int resId) {

        this.name = name;
        this.resId = resId;
    }
}
