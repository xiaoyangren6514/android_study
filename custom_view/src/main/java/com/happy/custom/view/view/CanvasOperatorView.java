package com.happy.custom.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhonglongquan on 2017/3/16.
 */

public class CanvasOperatorView extends View {

    private Paint mPaint;

    public CanvasOperatorView(Context context) {
        this(context, null);
    }

    public CanvasOperatorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasOperatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(6f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        translate(canvas);
//        scale1(canvas);
//        scale2(canvas);
//        scale3(canvas);
//        scale4(canvas)；
//        scaleDemo(canvas);
//        rotate(canvas);
//        rotate2(canvas);
        rotateDemo(canvas);
    }

    /**
     * 旋转示例 类表盘效果
     *
     * @param canvas
     */
    private void rotateDemo(Canvas canvas) {
        canvas.translate(getWidth() / 2, getHeight() / 2);
        canvas.drawCircle(0, 0, 400, mPaint);
        canvas.drawCircle(0, 0, 380, mPaint);
        for (int i = 0; i < 360; i += 30) {
            canvas.drawLine(0, 380, 0, 400, mPaint);
            canvas.rotate(30);
        }
    }

    /**
     * 旋转 同时改变旋转中心点
     *
     * @param canvas
     */
    private void rotate2(Canvas canvas) {
        canvas.translate(getWidth() / 2, getHeight() / 2);
        RectF rectF = new RectF(0, -400, 400, 0);
        canvas.drawRect(rectF, mPaint);

        canvas.rotate(180, 200, 0);
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF, mPaint);
    }

    /**
     * 旋转
     *
     * @param canvas
     */
    private void rotate(Canvas canvas) {
        canvas.translate(getWidth() / 2, getHeight() / 2);
        RectF rectF = new RectF(0, -400, 400, 0);
        canvas.drawRect(rectF, mPaint);

        canvas.rotate(180);
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF, mPaint);
    }

    /**
     * 缩放示例
     *
     * @param canvas
     */
    private void scaleDemo(Canvas canvas) {
        canvas.translate(getWidth() / 2, getHeight() / 2);
        RectF rectF = new RectF(-400, -400, 400, 400);
        for (int i = 0; i < 20; i++) {
            canvas.scale(0.9f, 0.9f);
            canvas.drawRect(rectF, mPaint);
        }
    }

    /**
     * 缩放示例四，比例为负，并且旋转中心点偏移
     *
     * @param canvas
     */
    private void scale4(Canvas canvas) {
        canvas.translate(getWidth() / 2, getHeight() / 2);
        RectF rectF = new RectF(0, -400, 400, 0);
        canvas.drawRect(rectF, mPaint);

        canvas.scale(-0.5f, -0.5f, 200, 200);//当缩放比例为负数的时候会根据缩放中心轴进行翻转,旋转中心向右 向下进行偏移
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(rectF, mPaint);
    }

    /**
     * 缩放示例三，比例为负
     *
     * @param canvas
     */
    private void scale3(Canvas canvas) {
        canvas.translate(getWidth() / 2, getHeight() / 2);
        RectF rectF = new RectF(0, -400, 400, 0);
        canvas.drawRect(rectF, mPaint);

        canvas.scale(-0.5f, -0.5f);//当缩放比例为负数的时候会根据缩放中心轴进行翻转
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(rectF, mPaint);
    }

    /**
     * 缩放示例二，带偏移量
     *
     * @param canvas
     */
    private void scale2(Canvas canvas) {
        canvas.translate(getWidth() / 2, getHeight() / 2);
        RectF rectF = new RectF(0, -400, 400, 0);
        canvas.drawRect(rectF, mPaint);

        canvas.scale(0.5f, 0.5f, 200, -200);// 缩放中心点向X轴偏移200，向上偏移200
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(rectF, mPaint);
    }

    /**
     * 缩放示例一
     *
     * @param canvas
     */
    private void scale1(Canvas canvas) {
        canvas.translate(getWidth() / 2, getHeight() / 2);
        RectF rectF = new RectF(0, -400, 400, 0);
        canvas.drawRect(rectF, mPaint);

        canvas.scale(0.5f, 0.5f);
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(rectF, mPaint);
    }

    /**
     * 位移
     *
     * @param canvas
     */
    private void translate(Canvas canvas) {
        mPaint.setColor(Color.RED);
        canvas.drawCircle(100, 100, 50, mPaint);
        canvas.translate(300, 300);
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(100, 100, 50, mPaint);
    }
}
