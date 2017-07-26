package com.happy.custom.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.happy.custom.view.domain.PieData;
import com.happy.custom.view.R;
import com.happy.custom.view.view.PieView;

import java.util.ArrayList;

public class PieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);
        PieView pieView = (PieView) findViewById(R.id.pie_view);
        ArrayList<PieData> pieDatas = new ArrayList<>();
        PieData pieData1 = new PieData("数学", 120);
        PieData pieData2 = new PieData("英语", 30);
        PieData pieData3 = new PieData("综合", 190);
        PieData pieData4 = new PieData("语文", 80);
        pieDatas.add(pieData1);
        pieDatas.add(pieData2);
        pieDatas.add(pieData3);
        pieDatas.add(pieData4);
        pieView.setData(pieDatas);
    }
}
