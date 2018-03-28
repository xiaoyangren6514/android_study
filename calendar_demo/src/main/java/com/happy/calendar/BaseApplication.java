package com.happy.calendar;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

import dalvik.system.DexClassLoader;

/**
 * Created by zhonglongquan on 2017/11/30.
 */

public class BaseApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        install();
    }

    private void install() {
        // 存放dex文件
        File dexDir = new File(getFilesDir(), "dex");
        if (dexDir != null && !dexDir.exists()) {
            dexDir.mkdirs();
        }
        // 存放经过opt后的dex文件
        File odexDir = new File(getFilesDir(), "odex");
        if (odexDir != null && !odexDir.exists()) {
            odexDir.mkdirs();
        }
        // 从asset目录拷贝文件
        File dexFile = new File(dexDir, "libs.apk");
        int len = -1;
        byte[] buf = new byte[2048];
        InputStream inputStream = null;
        FileOutputStream fos = null;
        try {
            inputStream = getAssets().open("libs.apk");
            if (inputStream != null) {
                fos = new FileOutputStream(dexFile);
                while ((len = inputStream.read(buf)) != -1) {
                    fos.write(buf, 0, len);
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (fos != null) {
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 将dexclassLoader插入到PathClassLoader和bootClassLoader中间
        ClassLoader classLoader = getClassLoader();
        ApplicationInfo applicationInfo = getApplicationInfo();
        String nativeSoPath = null;
        if (Build.VERSION.SDK_INT > 8) {
            // 2.2以后
            nativeSoPath = applicationInfo.nativeLibraryDir;
        } else {
            nativeSoPath = "/data/data/" + applicationInfo.packageName + "/lib/";
        }
        DexClassLoader dexClassLoader = new DexClassLoader(dexFile.getAbsolutePath(), odexDir.getAbsolutePath(),
                nativeSoPath, classLoader.getParent());
        try {
            Field field = ClassLoader.class.getDeclaredField("parent");
            if (field != null) {
                field.setAccessible(true);
                field.set(classLoader, dexClassLoader);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
