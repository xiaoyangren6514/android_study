package com.happy.mvvm.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.happy.mvvm.BR;
import com.happy.mvvm.R;
import com.happy.mvvm.adapter.AppListAdapter;
import com.happy.mvvm.utils.CommonUtil;

/**
 * 数据更新处理 方式一
 * 让model类继承自baseObservable，
 * 然后给需要改变的字段get方法添加@bindable注解，
 * 对应的set方法添加，notifyPropertyChanged(com.happy.mvvm.BR.field);即可
 * 次案例对应appinfoOne实体类
 */
public class DataUpdateOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView listView = (ListView) findViewById(R.id.lv_list);
        AppListAdapter appListAdapter = new AppListAdapter(this, R.layout.view_item_app_info_one, CommonUtil.getAllAppInfosOne(this), BR.appinfo_one);
        listView.setAdapter(appListAdapter);
    }
}
