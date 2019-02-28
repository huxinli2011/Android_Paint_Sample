package com.paint.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.text_lines).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,MyTextViewActivity.class));
            }
        });

        findViewById(R.id.text_min_rect).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,MinTextRectActivity.class));
            }
        });

        findViewById(R.id.text_paint_base).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,PaintPathEffectActivity.class));
            }
        });
        findViewById(R.id.text_paint_strokecap).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,PaintSrokeCapActivity.class));
            }
        });
        findViewById(R.id.text_paint_strokjoin).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,PaintSrokeJoinActivity.class));
            }
        });
    }
}
