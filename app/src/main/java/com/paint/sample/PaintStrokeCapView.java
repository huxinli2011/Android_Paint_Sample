package com.paint.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.SumPathEffect;
import android.util.AttributeSet;
import android.view.View;

/**
 * https://blog.csdn.net/harvic880925/article/details/51010839
 */
public class PaintStrokeCapView extends View {
    public PaintStrokeCapView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 设置线帽样式，取值有Cap.ROUND(圆形线帽)、Cap.SQUARE(方形线帽)、Paint.Cap.BUTT(无线帽)   就这三种线帽
         *
         */

        Paint paint = new Paint();
        paint.setStrokeWidth(80);
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);


        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawLine(100,200,400,200,paint);
        DrawTextUtil.drawText(canvas,"setStrokeCap(Paint.Cap.BUTT)  无线帽",450,200);

        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(100,400,400,400,paint);
        DrawTextUtil.drawText(canvas,"setStrokeCap(Paint.Cap.SQUARE)  方形线帽",450,400);

        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(100,600,400,600,paint);
        DrawTextUtil.drawText(canvas,"setStrokeCap(Paint.Cap.ROUND)  圆形线帽",450,600);

//垂直画出x=100这条线
        paint.reset();
        paint.setStrokeWidth(2);
        paint.setColor(Color.RED);
        canvas.drawLine(100,50,100,750,paint);



    }



}
