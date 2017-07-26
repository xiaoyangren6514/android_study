package com.happy.mvvm.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.happy.mvvm.BR;
import com.happy.mvvm.R;
import com.happy.mvvm.adapter.AppListAdapter;
import com.happy.mvvm.utils.CommonUtil;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView listView = (ListView) findViewById(R.id.lv_list);
        AppListAdapter appListAdapter = new AppListAdapter(this, R.layout.view_item_app_info, CommonUtil.getAllAppInfos(this), BR.appinfo);
        listView.setAdapter(appListAdapter);
    }
}
