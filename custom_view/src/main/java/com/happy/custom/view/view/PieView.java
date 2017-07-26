package com.happy.custom.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.happy.custom.view.domain.PieData;

import java.util.ArrayList;

/**
 * Created by zhonglongquan on 2017/3/16.
 */

public class PieView extends View {

    private static final String TAG = "PieView";

    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};

    private Paint mPaint;

    private ArrayList<PieData> pieDatas;

    private float startAngel = 0;

    private int mWidth;
    private int mHeight;

    public PieView(Context context) {
        this(context, null);
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (pieDatas == null || pieDatas.isEmpty()) return;
        float currentStartAngle = startAngel;
        canvas.translate(mWidth / 2, mHeight / 2);
        float radius = (float) (Math.min(mHeight, mWidth) / 2 * 0.8);
        RectF rectF = new RectF(-radius, -radius, radius, radius);
        for (int i = 0; i < pieDatas.size(); i++) {
            PieData pieData = pieDatas.get(i);
            mPaint.setColor(pieData.getColor());
            canvas.drawArc(rectF, currentStartAngle, pieData.getAngle(), true, mPaint);
            currentStartAngle += pieData.getAngle();
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    public void setData(ArrayList<PieData> pieDatas) {
        this.pieDatas = pieDatas;
        initData();
        invalidate();
    }

    private void initData() {
        if (pieDatas == null || pieDatas.isEmpty()) return;
        // 计算总值
        float totalValue = 0f;
        for (int i = 0; i < pieDatas.size(); i++) {
            PieData pieData = pieDatas.get(i);
            totalValue += pieData.getValue();
            int j = i % mColors.length;
            pieData.setColor(mColors[j]);
        }

        Log.v(TAG, "totalValue:" + totalValue);

        for (int i = 0; i < pieDatas.size(); i++) {
            PieData pieData = pieDatas.get(i);
            float percentage = pieData.getValue() / totalValue;
            float angle = percentage * 360;

            pieData.setAngle(angle);
            pieData.setPercentage(percentage);

            Log.v(TAG, "name:" + pieData.getName() + "value:" + pieData.getValue() + "percentage:" + percentage + ",angel:" + pieData.getAngle());
        }
    }

}
