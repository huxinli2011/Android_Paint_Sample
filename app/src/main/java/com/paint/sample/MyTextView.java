package com.paint.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class MyTextView extends View {
    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);

        int baseLineY = 90;
        int baseLineX = 0;

        Paint paint = new Paint();
        //写文字
        paint.setColor(Color.BLACK);
        paint.setTextSize(60); //以px为单位
        paint.setTextAlign(Paint.Align.LEFT);//绘制文字在x点开始画，Paint.Align.CENTER:表示从x的坐标向两边画  Paint.Align.RIGHT:表示文字从x的坐标向左画
        canvas.drawText("harvic\'s blog", baseLineX, baseLineY, paint);

        //计算各线在位置
        Paint.FontMetrics fm = paint.getFontMetrics();//解析详见210 baseLiner指基线
        float ascent = baseLineY + fm.ascent; //指当前绘制顶线
        float descent = baseLineY + fm.descent;//当前绘制底线
        float top = baseLineY + fm.top;//可绘制最顶线
        float bottom = baseLineY + fm.bottom;//可绘制最底线

        //画基线
        paint.setColor(Color.RED);
        canvas.drawLine(baseLineX, baseLineY, 3000, baseLineY, paint);

        //画top
        paint.setColor(Color.BLUE);
        canvas.drawLine(baseLineX, top, 3000, top, paint);

        //画ascent
        paint.setColor(Color.GREEN);
        canvas.drawLine(baseLineX, ascent, 3000, ascent, paint);

        //画descent
        paint.setColor(Color.GREEN);
        canvas.drawLine(baseLineX, descent, 3000, descent, paint);

        //画bottom
        paint.setColor(Color.RED);
        canvas.drawLine(baseLineX, bottom, 3000, bottom, paint);




    }
}
