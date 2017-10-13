package com.huida.view;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class ClipImageBorderView extends View {
    /**
     * 水平方向与View的边距
     */
    private int mHorizontalPadding;
    /**
     * 边框的宽度 单位dp
     */
    private int mBorderWidth = 1;

    private Paint mPaint;//圆环（空心圆）paint
    private Paint mPaintCirle;//圆（实心圆）paint
    private Paint mPaintRect;//阴影层paint

    private Canvas mCanvas;//阴影层画布
    private RectF mRect;//整个屏幕

    private Bitmap mBgBitmap;//用于绘制阴影层的bitmap

    public ClipImageBorderView(Context context) {
        this(context, null);
    }

    public ClipImageBorderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClipImageBorderView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mBorderWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, mBorderWidth, getResources().getDisplayMetrics());

        //绘制阴影层
        mPaintRect = new Paint();
        mPaintRect.setARGB(105, 0, 0, 0);


        // 绘制实心圆
        mPaintCirle = new Paint();
        mPaintCirle.setStrokeWidth((getWidth() - 2 * mHorizontalPadding) / 2);  //实心圆半径
        mPaintCirle.setARGB(255, 0, 0, 0);
        mPaintCirle.setXfermode(new PorterDuffXfermode(Mode.XOR));//XOR模式：重叠部分被掏空

        // 绘制圆环
        mPaint = new Paint();
        mPaint.setStyle(Style.STROKE);
        mPaint.setAntiAlias(true); //抗锯齿
        mPaint.setColor(Color.WHITE);//边框颜色白色
        mPaint.setStrokeWidth(mBorderWidth);//画笔宽度


    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mBgBitmap == null) {
            mBgBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
            mCanvas = new Canvas(mBgBitmap);
            mRect = new RectF(0, 0, getWidth(), getHeight());
        }
        //绘制阴影层
        mCanvas.drawRect(mRect, mPaintRect);
        //绘制实心圆 ，绘制完后，在mCanvas画布中，mPaintRect和mPaintCirle相交部分即被掏空
        mCanvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2 - mHorizontalPadding, mPaintCirle);
        //将阴影层画进本View的画布中
        canvas.drawBitmap(mBgBitmap, null, mRect, new Paint());
        //绘制圆环
        mCanvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2 - mHorizontalPadding, mPaint);

    }

    public void setHorizontalPadding(int mHorizontalPadding) {
        this.mHorizontalPadding = mHorizontalPadding;

    }

}
