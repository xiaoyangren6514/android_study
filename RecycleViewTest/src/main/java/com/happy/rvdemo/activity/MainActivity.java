package com.happy.rvdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.happy.rvdemo.R;
import com.happy.rvdemo.adapter.StudentAdapter;
import com.happy.rvdemo.domain.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;

    private StudentAdapter mStudentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycleView = (RecyclerView) findViewById(R.id.rv_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(layoutManager);
        mStudentAdapter = new StudentAdapter(this, initData());
        mRecycleView.setAdapter(mStudentAdapter);

    }

    private List<Student> initData() {
        ArrayList<Student> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Student student = new Student("旺财" + i, R.mipmap.ic_launcher_round);
            arrayList.add(student);
        }
        return arrayList;
    }
}
