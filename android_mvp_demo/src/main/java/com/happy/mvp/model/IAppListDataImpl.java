package com.happy.mvp.model;

import android.content.Context;

import com.happy.mvp.model.bean.AppInfo;
import com.happy.mvp.utils.CommonUtil;

import java.util.List;

/**
 * Created by zhonglongquan on 2017/7/27.
 */

public class IAppListDataImpl implements IAppListData {

    @Override
    public List<AppInfo> getAppList(Context context) {
        return CommonUtil.getAllAppInfos(context);
    }

}
