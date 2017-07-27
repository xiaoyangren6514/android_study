package com.happy.mvp.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.happy.mvp.R;
import com.happy.mvp.model.bean.AppInfo;
import com.happy.mvp.presenter.AppListPresenter;
import com.happy.mvp.view.IAppListView;
import com.happy.mvp.view.adapter.AppListAdapter;

import java.util.List;

public class AppListFragment extends Fragment implements IAppListView {

    private ListView mListView;

    private AppListPresenter appListPresenter = new AppListPresenter(this);

    public static AppListFragment newInstance() {
        return new AppListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_app_list, container, false);
        initView(view);
        appListPresenter.loadData(getActivity());
        return view;
    }

    private void initView(View view) {
        mListView = (ListView) view.findViewById(R.id.lv_list);
    }

    @Override
    public void initData(List<AppInfo> appInfos) {
        AppListAdapter adapter = new AppListAdapter(getActivity(), appInfos);
        mListView.setAdapter(adapter);
    }

}
