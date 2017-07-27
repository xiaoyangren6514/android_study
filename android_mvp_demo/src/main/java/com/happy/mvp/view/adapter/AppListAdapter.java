package com.happy.mvp.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.happy.mvp.R;
import com.happy.mvp.model.bean.AppInfo;

import java.util.List;

/**
 * Created by zhonglongquan on 2017/7/27.
 */

public class AppListAdapter extends BaseAdapter {

    private Context context;
    private List<AppInfo> appInfos;

    public AppListAdapter(Context context, List<AppInfo> appInfos) {
        this.context = context;
        this.appInfos = appInfos;
    }

    @Override
    public int getCount() {
        return appInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return appInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.view_item_app_info, null);
            viewHolder = new ViewHolder();
            viewHolder.ivIcon = (ImageView) convertView.findViewById(R.id.iv_list_logo);
            viewHolder.tvAppName = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tvPackageName = (TextView) convertView.findViewById(R.id.tv_package_name);
            viewHolder.tvVersionName = (TextView) convertView.findViewById(R.id.tv_version_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        AppInfo appInfo = (AppInfo) getItem(position);
        viewHolder.tvAppName.setText(appInfo.getAppName());
        viewHolder.tvPackageName.setText("包名:" + appInfo.getPackageName());
        viewHolder.tvVersionName.setText("版本号:" + appInfo.getVersionName());
        viewHolder.ivIcon.setImageDrawable(appInfo.getIcon());
        return convertView;
    }

    static class ViewHolder {
        TextView tvAppName;
        TextView tvPackageName;
        TextView tvVersionName;
        ImageView ivIcon;
    }

}
