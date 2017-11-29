package com.happy.mvp.utils;

import android.content.Context;
import android.content.pm.PackageInfo;

import com.happy.mvp.R;
import com.happy.mvp.model.bean.AppInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhonglongquan on 2017/7/27.
 */

public class CommonUtil {
    /**
     * 获取手机上安装的app
     */
    public static ArrayList<AppInfo> getAllAppInfos(Context context) {
        ArrayList<AppInfo> appInfos = new ArrayList<>();
        List<PackageInfo> packages = context.getPackageManager()
                .getInstalledPackages(0);

        for (int i = 0; i < packages.size(); i++) {
            PackageInfo packageInfo = packages.get(i);
//            if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                long firstInstallTime = packageInfo.firstInstallTime;//应用第一次安装的时间
                long lastUpdateTime = packageInfo.lastUpdateTime;   //应用最后更新的时间
                String appName = packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
                String packageName = packageInfo.packageName;
                AppInfo appInfo = new AppInfo();
                appInfo.setAppName(appName);
                appInfo.setPackageName(packageName);
                appInfo.setIcon(context.getResources().getDrawable(R.mipmap.ic_launcher));
                appInfos.add(appInfo);
//            }
        }
        return appInfos;
    }
}
