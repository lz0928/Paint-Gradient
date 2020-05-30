package com.louis.paint_gradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class RadarGradientView extends View {

    private Paint mCirclePaint;
    private Paint mShaderPaint;

    private int mWidth;
    private int mHeight;
    private Shader mScanShader;

    private float[] pots = {0.05f, 0.1f, 0.15f, 0.2f, 0.25f};
    private int mSpeed = 5;
    private Matrix mMatrix = new Matrix();


    public RadarGradientView(Context context) {
        this(context,null);
    }

    public RadarGradientView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RadarGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setStyle(Paint.Style.STROKE);
        mCirclePaint.setStrokeWidth(1);
        mCirclePaint.setColor(Color.parseColor("#B0C4DE")); // 设置颜色 亮钢兰色

        mShaderPaint = new Paint();
        mShaderPaint.setAntiAlias(true);

        post(mRunnable);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        mWidth = mHeight = Math.min(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < pots.length; i++) {
            canvas.drawCircle(mWidth/2,mHeight/2,mWidth * pots[i],mCirclePaint);
        }

        canvas.save();

        mScanShader = new SweepGradient(mWidth/2,mHeight/2,new int[]{Color.TRANSPARENT, Color.parseColor("#84B5CA")}, null);
        mScanShader.setLocalMatrix(mMatrix);
        mShaderPaint.setShader(mScanShader);
        canvas.concat(mMatrix);
        canvas.drawCircle(mWidth/2,mHeight/2,mWidth * pots[pots.length - 1],mShaderPaint);


        canvas.restore();
    }

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            mMatrix.postRotate(mSpeed, mWidth / 2, mHeight / 2);
            invalidate();
            postDelayed(this, 50);
        }
    };
}
