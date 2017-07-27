package com.happy.mvp.model.bean;

import android.graphics.drawable.Drawable;

/**
 * Created by zhonglongquan on 2017/7/26.
 */

public class AppInfo {
    private String appName;
    private long intallTime;
    private String versionName;
    private Drawable icon;
    private String packageName;

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

}
