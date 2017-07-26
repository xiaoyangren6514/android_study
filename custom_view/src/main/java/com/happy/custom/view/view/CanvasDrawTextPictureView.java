package com.happy.custom.view.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.happy.custom.view.R;

/**
 * Created by zhonglongquan on 2017/3/16.
 */

public class CanvasDrawTextPictureView extends View {

    private Paint mPaint;

    private Context mContext;

    public CanvasDrawTextPictureView(Context context) {
        this(context, null);
    }

    public CanvasDrawTextPictureView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasDrawTextPictureView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(5f);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        drawBitmap(canvas);
//        drawBitmap2(canvas);
        drawText(canvas);
    }

    private void drawText(Canvas canvas) {
        String content = "hello world";
        canvas.drawText(content, 100, 200, mPaint);
        canvas.drawText(content,3,content.length()-2,100,500,mPaint);
        canvas.drawPosText("happy",new float[]{
                100,700,
                200,800,
                300,900,
                300,800,
                200,700
        },mPaint);
    }

    /**
     * 通过dest src进行绘制
     *
     * @param canvas
     */
    private void drawBitmap2(Canvas canvas) {
        canvas.translate(getWidth() / 2, getHeight() / 2);
        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_round);
        Rect src = new Rect(0, 0, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        Rect dest = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawBitmap(bitmap, src, dest, new Paint(Paint.ANTI_ALIAS_FLAG));
    }

    /**
     * 绘制bitmap
     *
     * @param canvas
     */
    private void drawBitmap(Canvas canvas) {
        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_round);
        canvas.drawBitmap(bitmap, new Matrix(), new Paint());

        canvas.drawBitmap(bitmap, 500, 500, new Paint());
    }

}
