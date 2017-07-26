package com.happy.mvvm.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.happy.mvvm.BR;
import com.happy.mvvm.R;
import com.happy.mvvm.adapter.AppListAdapter;
import com.happy.mvvm.domain.AppInfoTwo;
import com.happy.mvvm.utils.CommonUtil;

public class UpdateDateTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView listView = (ListView) findViewById(R.id.lv_list);
        AppListAdapter appListAdapter = new AppListAdapter(this, R.layout.view_item_app_info_two, CommonUtil.getAllAppInfosTwo(this), BR.appinfo_two);
        listView.setAdapter(appListAdapter);
        // 修改数据值
        AppInfoTwo appInfoTwo = new AppInfoTwo();
        appInfoTwo.appName.set("旺财");
        System.out.println(appInfoTwo.appName.get());
    }

}
