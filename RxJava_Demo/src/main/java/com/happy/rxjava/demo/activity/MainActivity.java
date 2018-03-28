package com.happy.rxjava.demo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.happy.rxjava.demo.BaseUseActivity;
import com.happy.rxjava.demo.R;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private DemoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView demoList = (ListView) findViewById(R.id.demos);
        demoList.setOnItemClickListener(this);
        adapter = new DemoAdapter(this);
        demoList.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String key = adapter.getItem(position);
        Intent intent = new Intent(this, adapter.getValue(key));
        startActivity(intent);
    }

    public static class DemoAdapter extends BaseAdapter {
        private Map<String, Class<? extends Activity>> DEMOS
                = new HashMap<String, Class<? extends Activity>>();

        {
            DEMOS.put("01.基本使用", BaseUseActivity.class);
            DEMOS.put("02.基本使用", EasyThreadActivity.class);
            DEMOS.put("03.flatMap", FlatMapActivity.class);
            DEMOS.put("04.zip", ZipActivity.class);
            DEMOS.put("05.dead test", DeadActivity.class);
        }

        private String[] keys = null;

        private LayoutInflater mInflater;

        public DemoAdapter(Context context) {
            super();
            mInflater = LayoutInflater.from(context);
            Set<String> strings = DEMOS.keySet();
            keys = new String[strings.size()];
            keys = strings.toArray(keys);
        }

        @Override
        public int getCount() {
            return DEMOS.size();
        }

        public Class<? extends Activity> getValue(String key) {
            return DEMOS.get(key);
        }

        @Override
        public String getItem(int position) {
            return keys[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView name = null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.simple_item, null);
                name = (TextView) convertView.findViewById(R.id.name);
                convertView.setTag(name);
            } else {
                name = (TextView) convertView.getTag();
            }

            name.setText(getItem(position));
            return convertView;
        }
    }
}
