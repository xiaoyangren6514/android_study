package com.happy.mvp.model;

import android.content.Context;

import com.happy.mvp.model.bean.AppInfo;

import java.util.List;

/**
 * Created by zhonglongquan on 2017/7/27.
 */

public interface IAppListData {
    List<AppInfo> getAppList(Context context);
}
