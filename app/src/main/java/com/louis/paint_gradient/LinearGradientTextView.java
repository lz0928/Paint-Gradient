package com.louis.paint_gradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class LinearGradientTextView extends AppCompatTextView {

    private TextPaint mTextPaint;

    private LinearGradient mLinearGradient;
    private Matrix mMatrix;

    private float mTranslate;
    private float DELTAX = 20;

    public LinearGradientTextView(Context context) {
        super(context);
    }

    public LinearGradientTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mTextPaint = getPaint();
        String text = getText().toString();
        float textWidth = mTextPaint.measureText(text);

        //3个文字的宽度
        int gradientSize = ((int) (textWidth / text.length() * 3));

        //从左边-gradientSize开始，即左边距离文字gradientSize开始渐变
        mLinearGradient = new LinearGradient(-gradientSize, 0, 0, 0, new int[]{0x22ffffff, 0xffffffff, 0x22ffffff}, null, Shader.TileMode.CLAMP);

        mTextPaint.setShader(mLinearGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mTranslate += DELTAX;
        float textWidth = getPaint().measureText(getText().toString());

        if (mTranslate > textWidth + 3 || mTranslate < 1) {
            DELTAX = -DELTAX;
        }

        mMatrix = new Matrix();
        mMatrix.setTranslate(mTranslate, 2);
        mLinearGradient.setLocalMatrix(mMatrix);
        postInvalidateDelayed(50);
    }
}
