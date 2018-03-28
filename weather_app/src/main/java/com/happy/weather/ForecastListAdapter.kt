package com.happy.weather

import android.support.v7.widget.RecyclerView
import android.widget.TextView

/**
 * Created by zhonglongquan on 2017/12/20.
 */
class ForecastListAdapter(val items: List<String>) : RecyclerView.Adapter(ForecastListAdapter.ViewHolder) {

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}