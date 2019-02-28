package com.paint.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

/**
 * https://blog.csdn.net/harvic880925/article/details/51010839
 */
public class PaintStrokeJoinView extends View {
    public PaintStrokeJoinView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * setStrokeJoin(Paint.Join join)
         * 设置线段连接处样式，取值有：Join.MITER（结合处为锐角）、Join.Round(结合处为圆弧)、Join.BEVEL(结合处为直线)
         * 运行出来 Join.Round和 Join.BEVEL没有明显的区别
         */


        Paint paint = new Paint();
        paint.setStrokeWidth(80);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        Path path = new Path();
        path.moveTo(100, 100);
        path.lineTo(450, 100);
        path.lineTo(450, 300);
        paint.setStrokeJoin(Paint.Join.MITER);
        canvas.drawPath(path, paint);
        DrawTextUtil.drawText(canvas, "setStrokeJoin(Paint.Join.MITER) 结合处为锐角", 100, 350);

        path.moveTo(100, 400);
        path.lineTo(450, 400);
        path.lineTo(450, 600);
        paint.setStrokeJoin(Paint.Join.BEVEL);//bevel 斜角
        canvas.drawPath(path, paint);
        DrawTextUtil.drawText(canvas, "setStrokeJoin(Paint.Join.BEVEL) 结合处为直线", 100, 650);

        path.moveTo(100, 700);
        path.lineTo(450, 700);
        path.lineTo(450, 900);
        paint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawPath(path, paint);
        DrawTextUtil.drawText(canvas, "setStrokeJoin(Paint.Join.ROUND) 结合处为圆弧", 100, 950);


        Paint paintTxt = new Paint();
        paintTxt.setColor(Color.GREEN);
        String text = "乌龟&梦想";
        paintTxt.setTextSize(100);
        paintTxt.setFakeBoldText(true);//是否加粗
        paintTxt.setStrikeThruText(true);//删除线
        paintTxt.setUnderlineText(true);//下划线
        paintTxt.setTextAlign(Paint.Align.LEFT);//开始绘图点位置
        paintTxt.setTextScaleX(2f);//设置水平拉伸
        paintTxt.setTextSkewX(-0.25f);
        paintTxt.setTypeface(Typeface.SERIF);//字体样式

        canvas.translate(0, 1000);
        paintTxt.setSubpixelText(true);
        canvas.drawText(text, 0, 200, paintTxt);

    }

}
