package com.happy.custom.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhonglongquan on 2017/3/15.
 */

public class SimpleCanvasView extends View {

    private Paint mPaint;

    public SimpleCanvasView(Context context) {
        this(context, null);
    }

    public SimpleCanvasView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleCanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(8f);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        drawLine(canvas);
//        drawPoint(canvas);
//        drawRect(canvas);
//        drawRoundRect(canvas);
//        drawOval(canvas);
//        drawCircle(canvas);
        drawArc(canvas);
    }

    /**
     * 绘制椭圆
     *
     * @param canvas
     */
    private void drawArc(Canvas canvas) {
        RectF rectF = new RectF(100, 100, 600, 600);
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF, mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectF, 0, 90, false, mPaint);

        RectF rectF2 = new RectF(100, 700, 600, 1200);
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF2, mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectF2, 0, 90, true, mPaint);
    }

    /**
     * 绘制圆
     *
     * @param canvas
     */
    private void drawCircle(Canvas canvas) {
        canvas.drawCircle(300, 300, 50, mPaint);
    }

    /**
     * 绘制椭圆
     *
     * @param canvas
     */
    private void drawOval(Canvas canvas) {
        RectF rectF = new RectF(100, 200, 400, 300);
        canvas.drawOval(rectF, mPaint);
    }

    /**
     * 绘制圆角矩形
     */
    private void drawRoundRect(Canvas canvas) {
        RectF rect = new RectF(100, 200, 400, 600);
        canvas.drawRoundRect(rect, 30, 60, mPaint);
    }

    /**
     * 绘制矩形
     *
     * @param canvas
     */
    private void drawRect(Canvas canvas) {
        canvas.drawRect(50, 60, 120, 300, mPaint);
        Rect rect = new Rect(180, 200, 360, 400);
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(rect, mPaint);
    }

    /**
     * 绘制直线
     *
     * @param canvas
     */
    private void drawLine(Canvas canvas) {
        canvas.drawLine(200, 400, 600, 800, mPaint);
        canvas.drawLines(new float[]{
                100, 100, 100, 200,
                200, 100, 400, 600
        }, mPaint);
    }

    /**
     * 绘制点
     *
     * @param canvas
     */
    private void drawPoint(Canvas canvas) {
        canvas.drawPoint(100f, 130f, mPaint);
        canvas.drawPoint(100f, 140f, mPaint);
        canvas.drawPoint(100f, 150f, mPaint);
        canvas.drawPoints(new float[]{
                500, 500,
                500, 600,
                500, 700
        }, mPaint);
    }

}
