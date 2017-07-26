package com.happy.news.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.happy.news.R;
import com.happy.news.activity.NewsContentActivity;
import com.happy.news.domain.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhonglongquan on 2017/4/6.
 */

public class NewsTitleFragment extends Fragment {

    private boolean isTwoPane;

    private View view;

    private RecyclerView rvNewsTitleView;

    private NewsAdapter newsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_title, container, false);
        rvNewsTitleView = (RecyclerView) view.findViewById(R.id.rv_list);
        newsAdapter = new NewsAdapter(initData());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvNewsTitleView.setLayoutManager(layoutManager);
        rvNewsTitleView.setAdapter(newsAdapter);
        return view;
    }

    private List<News> initData() {
        ArrayList<News> newsList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            News news = new News();
            news.setTitle("标题" + i);
            news.setContent("内容" + i);
            newsList.add(news);
        }
        return newsList;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_fragment) != null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }
    }

    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

        private List<News> newsList;

        public NewsAdapter(List<News> newsList) {
            this.newsList = newsList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(getActivity(), R.layout.item_news_title, null);
            final ViewHolder viewHolder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News news = newsList.get(viewHolder.getAdapterPosition());
                    if (isTwoPane) {// 平板
                        NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
                        newsContentFragment.refresh(news.getTitle(), news.getContent());
                    } else {//普通手机
                        NewsContentActivity.createIntent(getActivity(), news.getTitle(), news.getContent());
                    }
                }
            });
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            News news = newsList.get(position);
            holder.tvTitle.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return newsList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvTitle;

            public ViewHolder(View itemView) {
                super(itemView);
                tvTitle = (TextView) itemView.findViewById(R.id.tv_news_title);
            }
        }

    }

}
