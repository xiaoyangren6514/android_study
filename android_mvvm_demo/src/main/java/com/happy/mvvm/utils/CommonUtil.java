package com.happy.mvvm.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;

import com.happy.mvvm.domain.AppInfo;
import com.happy.mvvm.domain.AppInfoTwo;
import com.happy.mvvm.domain.AppInfoOne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhonglongquan on 2017/7/26.
 */

public class CommonUtil {
    /**
     * 获取手机上安装的app
     */
    public static ArrayList<AppInfo> getAllAppInfos(Context context) {
        ArrayList<AppInfo> appInfos = new ArrayList<>();
        PackageManager pm = context.getPackageManager(); // 获得PackageManager对象
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        // 通过查询，获得所有ResolveInfo对象.
        List<ResolveInfo> resolveInfos = pm
                .queryIntentActivities(mainIntent, PackageManager.MATCH_DEFAULT_ONLY);
        // 调用系统排序 ， 根据name排序
        // 该排序很重要，否则只能显示系统应用，而不能列出第三方应用程序
        Collections.sort(resolveInfos, new ResolveInfo.DisplayNameComparator(pm));
        for (ResolveInfo reInfo : resolveInfos) {
            String pkgName = reInfo.activityInfo.packageName; // 获得应用程序的包名
            String appLabel = (String) reInfo.loadLabel(pm); // 获得应用程序的Label
            Drawable icon = reInfo.loadIcon(pm); // 获得应用程序图标
            // 创建一个AppInfo对象，并赋值
            AppInfo appInfo = new AppInfo();
            appInfo.setAppName(appLabel);
            appInfo.setPackageName(pkgName);
            appInfo.setIcon(icon);
            appInfos.add(appInfo); // 添加至列表中
        }
        List<PackageInfo> packages = context.getPackageManager()
                .getInstalledPackages(0);

        for (int i = 0; i < packages.size(); i++) {
            PackageInfo packageInfo = packages.get(i);
            // Only display the non-system app info
//            if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
            long firstInstallTime = packageInfo.firstInstallTime;//应用第一次安装的时间
            long lastUpdateTime = packageInfo.lastUpdateTime;   //应用最后更新的时间
            String appName = packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
            for (AppInfo appInfo : appInfos) {
                if (appInfo.getAppName().equals(appName)) {
                    appInfo.setVersionName(packageInfo.versionName);
                    appInfo.setIntallTime(firstInstallTime);
                    break;
                }
            }
//            }
        }
        return appInfos;
    }

    public static ArrayList<AppInfoOne> getAllAppInfosOne(Context context) {
        ArrayList<AppInfoOne> appInfos = new ArrayList<>();
        for (AppInfo appInfo : getAllAppInfos(context)) {
            AppInfoOne appInfoOne = new AppInfoOne();
            appInfoOne.setIntallTime(appInfo.getIntallTime());
            appInfoOne.setVersionName(appInfo.getVersionName());
            appInfoOne.setAppName(appInfo.getAppName());
            appInfoOne.setIcon(appInfo.getIcon());
            appInfoOne.setPackageName(appInfo.getPackageName());
            appInfos.add(appInfoOne);
        }
        return appInfos;
    }

    public static ArrayList<AppInfoTwo> getAllAppInfosTwo(Context context) {
        ArrayList<AppInfoTwo> appInfos = new ArrayList<>();
        for (AppInfo appInfo : getAllAppInfos(context)) {
            AppInfoTwo dataUpdateAppInfoOne = new AppInfoTwo();
            dataUpdateAppInfoOne.setIntallTime(appInfo.getIntallTime());
            dataUpdateAppInfoOne.setVersionName(appInfo.getVersionName());
            dataUpdateAppInfoOne.setAppName(appInfo.getAppName());
//            dataUpdateAppInfoOne.setIcon(appInfo.getIcon());
            dataUpdateAppInfoOne.setPackageName(appInfo.getPackageName());
            appInfos.add(dataUpdateAppInfoOne);
        }
        return appInfos;
    }
}
