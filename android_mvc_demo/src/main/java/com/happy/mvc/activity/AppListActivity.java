package com.happy.mvc.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.happy.mvc.R;
import com.happy.mvc.adapter.AppListAdapter;
import com.happy.mvc.utils.CommonUtil;

public class AppListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.lv_list);
        AppListAdapter adapter = new AppListAdapter(this, CommonUtil.getAllAppInfos(this));
        listView.setAdapter(adapter);
    }

}
