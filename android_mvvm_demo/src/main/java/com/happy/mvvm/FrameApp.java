package com.happy.mvvm;

import android.app.Application;

import com.nostra13.universalimageloader.cache.disc.impl.ext.LruDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LRULimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhonglongquan on 2017/7/26.
 */

public class FrameApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initUniversalImageLoader();
    }

    private void initUniversalImageLoader() {
        File path = StorageUtils.getOwnCacheDirectory(this, "/mvvm_dmeo/images", true);
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .imageScaleType(ImageScaleType.NONE)
                .build();
        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(this)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .threadPoolSize(3)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LRULimitedMemoryCache(4 * 1024 * 1024))
                .memoryCacheSize(4 * 1024 * 1024)
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .defaultDisplayImageOptions(options)
                .writeDebugLogs();
        if (path != null) {
            long maxDiskCacheSize = 30 * 1024 * 1024;
            long diskFreeSize = path.getFreeSpace() / 3;
            long diskCacheSize = Math.min(maxDiskCacheSize, diskFreeSize);
            try {
                builder = builder.diskCache(new LruDiskCache(path, new Md5FileNameGenerator(), diskCacheSize));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ImageLoader.getInstance().init(builder.build());
    }
}
