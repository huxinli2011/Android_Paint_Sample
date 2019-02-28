package com.paint.sample;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class DrawTextUtil {

    public static void drawText(Canvas canvas,String text,int x,int y){

        Paint pint=new Paint();
        pint.setColor(Color.RED);
        pint.setTextSize(25f);
        pint.setAntiAlias(true);
        canvas.drawText(text,x,y,pint);

    }
}
