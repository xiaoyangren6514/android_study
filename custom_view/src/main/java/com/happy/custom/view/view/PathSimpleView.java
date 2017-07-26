package com.happy.custom.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhonglongquan on 2017/3/16.
 */

public class PathSimpleView extends View {

    private Paint mPaint;

    public PathSimpleView(Context context) {
        this(context, null);
    }

    public PathSimpleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathSimpleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(3f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        drawPath(canvas);
//        drawPath2(canvas);
//        drawPathCw(canvas);
//        drawAddPath(canvas);
        drawArcPath(canvas);
    }

    /**
     * @param canvas
     */
    private void drawArcPath(Canvas canvas) {
        canvas.translate(getWidth() / 2, getHeight() / 2);
        canvas.scale(1, -1);
        Path path = new Path();
        path.lineTo(100, 100);
        RectF oval = new RectF(0, 0, 300, 300);
//        path.addArc(oval, 90, 270);
//        path.arcTo(oval,90,270,true);
        path.arcTo(oval,90,270,false);
        canvas.drawPath(path, mPaint);
    }

    private void drawAddPath(Canvas canvas) {
        canvas.translate(getWidth() / 2, getHeight() / 2);
        Path path = new Path();
        Path src = new Path();
        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
        src.addCircle(0, 0, 100, Path.Direction.CW);
        path.addPath(src, 0, 200);
        canvas.drawPath(path, mPaint);
    }

    /**
     * 顺时针 逆时针画
     *
     * @param canvas
     */
    private void drawPathCw(Canvas canvas) {
        canvas.translate(getWidth() / 2, getHeight() / 2);
        Path path = new Path();
        RectF rectF = new RectF(-200, -200, 200, 200);
        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
        path.setLastPoint(-300, 300);
//        path.close();
        canvas.drawPath(path, mPaint);
    }

    private void drawPath2(Canvas canvas) {
        canvas.translate(getWidth() / 2, getHeight() / 2);
        Path path = new Path();
        path.lineTo(200, 200);
        path.moveTo(400, 500);
        path.lineTo(600, 800);
        path.setLastPoint(100, 100);
        path.lineTo(200, 0);
        path.close();
        canvas.drawPath(path, mPaint);
    }

    private void drawPath(Canvas canvas) {
        canvas.translate(getWidth() / 2, getHeight() / 2);
        Path path = new Path();
        path.lineTo(200, 200);
        path.lineTo(200, 0);
        path.close();
        canvas.drawPath(path, mPaint);
    }

}
