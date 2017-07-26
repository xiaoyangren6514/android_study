package com.happy.mvvm.domain;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.happy.mvvm.BR;

/**
 * Created by zhonglongquan on 2017/7/26.
 * 对应数据处理方式一
 */

public class AppInfoOne extends BaseObservable {

    private String appName;
    private long intallTime;
    private String versionName;
    private Drawable icon;
    private String packageName;
    private int clickNums;

    @BindingAdapter("bind:app_one_logo")
    public static void setLogo(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
    }

    @Bindable
    public int getClickNums() {
        return clickNums;
    }

    public void setClickNums(int clickNums) {
        this.clickNums = clickNums;
        notifyPropertyChanged(BR.clickNums);
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public long getIntallTime() {
        return intallTime;
    }

    public void setIntallTime(long intallTime) {
        this.intallTime = intallTime;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    /**
     * 点击事件
     * 点击item获取当前position的数据，获取方式非常简单，直接get方法获取即可，比传统的ListView的点击事件通过position来获取数据方便多了
     *
     * @param view
     */
    public void onItemClick(View view) {
        Toast.makeText(view.getContext(), getAppName(), Toast.LENGTH_SHORT).show();
        setClickNums(getClickNums() + 1);
    }
}
