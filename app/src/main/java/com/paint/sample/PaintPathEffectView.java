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
import android.graphics.Rect;
import android.graphics.SumPathEffect;
import android.util.AttributeSet;
import android.view.View;

/**
 * https://blog.csdn.net/harvic880925/article/details/51010839
 */
public class PaintPathEffectView extends View {
    public PaintPathEffectView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * reset() 重置画笔
         * setARGB()
         * setAlpha(int a)画笔透明度
         * setStyle(Paint.Style style) 画笔样式 Paint.Style.PILL 填充内部，Paint.Style.STROKE 仅描边，Paint.Style.PILL_STROKE 填充内部和描边
         * setStrokeWidth(float width) 画笔宽度
         * setAntiAlias(boolean aa) 画笔是否抗锯齿
         * setStrokeMiter(float miter) 设置拿画笔的倾斜度
         * setPathEffect(PathEffect effect) 设置路径样式，取值如下
         *
         */




        Paint paint = getPaint();
        Path path = getPath();
//1
        canvas.drawPath(path,paint);//原始路径
        DrawTextUtil.drawText(canvas,"原始路径",100,150);
//2
        canvas.translate(0,200);
        CornerPathEffect cornerPathEffect=new CornerPathEffect(100);
        paint.setPathEffect(cornerPathEffect);//圆形拐角效果
        canvas.drawPath(path,paint);
        DrawTextUtil.drawText(canvas,"setPathEffect(cornerPathEffect); 圆形拐角效果",100,150);
//3
        canvas.translate(0,200);
        DashPathEffect dashPathEffect= new DashPathEffect(new float[]{2,5,10,10},0);
        paint.setPathEffect(dashPathEffect);//虚线效果
        canvas.drawPath(path,paint);
        DrawTextUtil.drawText(canvas,"setPathEffect(dashPathEffect); 虚线效果",100,150);
//4
        canvas.translate(0,200);
        paint.setPathEffect(new DiscretePathEffect(2,5));//离散路径效果
        canvas.drawPath(path,paint);
        DrawTextUtil.drawText(canvas,"setPathEffect(new DiscretePathEffect(2,5)); 离散路径效果",100,150);
//5

        //构建印章路径
        Path stampPath  = new Path();
        stampPath.moveTo(0,20);
        stampPath.lineTo(10,0);
        stampPath.lineTo(20,20);
        stampPath.close();
        stampPath.addCircle(0,0,3, Path.Direction.CCW);
        canvas.translate(0,200);
        paint.setPathEffect(new PathDashPathEffect(stampPath,35,0, PathDashPathEffect.Style.TRANSLATE));//印章路径效果
        canvas.drawPath(path,paint);
        DrawTextUtil.drawText(canvas,"PathDashPathEffect  印章路径效果",100,150);
//6
        canvas.translate(0,200);
        paint.setPathEffect(new ComposePathEffect(cornerPathEffect,dashPathEffect));//使用ComposePathEffect合并虚线与圆形拐角路径效果
        canvas.drawPath(path,paint);
        DrawTextUtil.drawText(canvas,"使用ComposePathEffect合并虚线与圆形拐角路径效果",100,150);
//7
        canvas.translate(0,200);
        paint.setPathEffect(new SumPathEffect(cornerPathEffect,dashPathEffect));//使用SumPathEffect合并路径虚线与圆形拐角路径效果
        canvas.drawPath(path,paint);
        DrawTextUtil.drawText(canvas,"使用SumPathEffect合并路径虚线与圆形拐角路径效果",100,150);

    }

    private Path getPath(){
        Path path = new Path();
        // 定义路径的起点
        path.moveTo(0, 0);

        // 定义路径的各个点
        for (int i = 0; i <= 40; i++) {
            path.lineTo(i*35, (float) (Math.random() * 150));
        }
        return path;
    }

    private Paint getPaint(){
        Paint paint = new Paint();
        paint.setStrokeWidth(4);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }

}
