package com.happy.custom.view.activity;

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

import com.happy.custom.view.R;

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
            DEMOS.put("Canvas之绘制图形", CanvasDrawActivity.class);
            DEMOS.put("Canvas Demo(饼图)", PieActivity.class);
            DEMOS.put("Canvas之画布操作", CanvasOperatorActivity.class);
            DEMOS.put("Canvas之文本图片", CanvasDrawTextPictureActivity.class);
            DEMOS.put("Path之基本操作", PathSimpleActivity.class);
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
