package com.louis.paint_gradient;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class MyGradientView extends View {

    private Paint mPaint;
    private Bitmap mBitmap = null;
    private int[] mColors = {Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW};


    public MyGradientView(Context context) {
        this(context,null);
    }

    public MyGradientView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.xyjy3);
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);

        //位图图像渲染
/*//        BitmapShader bitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//        BitmapShader bitmapShader = new BitmapShader(mBitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        BitmapShader bitmapShader = new BitmapShader(mBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        mPaint.setShader(bitmapShader);

        canvas.drawRect(new Rect(0,0,2000,2000),mPaint);*/

//ShapeDrawable
      /*  BitmapShader bitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setShader(bitmapShader);
        shapeDrawable.setBounds(0, 0, mBitmap.getWidth(), mBitmap.getHeight());
        shapeDrawable.draw(canvas);*/

//线性渲染
/*//        LinearGradient linearGradient = new LinearGradient(0, 0, 200, 200, mColors, null, Shader.TileMode.CLAMP);
        LinearGradient linearGradient = new LinearGradient(0, 0, 400, 0, mColors, null, Shader.TileMode.MIRROR);
        mPaint.setShader(linearGradient);
        canvas.drawRect(0,0,800,800,mPaint);*/

       /* Bitmap heartBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.heart);
        BitmapShader bitmapShader = new BitmapShader(heartBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        LinearGradient linearGradient = new LinearGradient(0, 0, heartBitmap.getWidth(), heartBitmap.getHeight(), mColors, null, Shader.TileMode.CLAMP);
        ComposeShader composeShader = new ComposeShader(bitmapShader, linearGradient, PorterDuff.Mode.MULTIPLY);
        mPaint.setShader(composeShader);
        canvas.drawRect(0,0,heartBitmap.getWidth(),heartBitmap.getHeight(),mPaint);*/

        SweepGradient sweepGradient = new SweepGradient(200, 200, mColors, null);
//        RadialGradient radialGradient = new RadialGradient(200, 200, 200, mColors, new float[]{0.2f, 0.5f, 0.8f,0.9f}, Shader.TileMode.CLAMP);
        mPaint.setShader(sweepGradient);
        canvas.drawCircle(200,200,200,mPaint);
    }
}
