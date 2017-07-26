package com.happy.news.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.happy.news.R;

/**
 * Created by zhonglongquan on 2017/4/6.
 */

public class NewsContentFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_news_fragment, null);
        return view;
    }

    public void refresh(String title, String content) {
        View visiableLayout = view.findViewById(R.id.ll_visiable);
        visiableLayout.setVisibility(View.VISIBLE);
        TextView titleView = (TextView) visiableLayout.findViewById(R.id.tv_title);
        TextView contentView = (TextView) visiableLayout.findViewById(R.id.tv_content);
        titleView.setText(title);
        contentView.setText(content);
    }

}
