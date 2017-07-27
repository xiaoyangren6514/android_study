package com.happy.mvp.presenter;

import android.content.Context;

import com.happy.mvp.common.BasePresenter;
import com.happy.mvp.model.IAppListData;
import com.happy.mvp.model.IAppListDataImpl;
import com.happy.mvp.view.IAppListView;

/**
 * Created by zhonglongquan on 2017/7/27.
 */

public class AppListPresenter extends BasePresenter {

    private IAppListView iAppListView;
    private IAppListData iAppListData;

    public AppListPresenter(IAppListView iAppListView) {
        this.iAppListView = iAppListView;
        iAppListData = new IAppListDataImpl();
    }

    public void loadData(Context context) {
        iAppListView.initData(iAppListData.getAppList(context));
    }


}
