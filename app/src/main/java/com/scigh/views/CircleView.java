package com.scigh.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.scigh.activities.R;


/*
Circle View for intro screen
 */
public class CircleView extends View {

    private static int DEFAULT_FILL_COLOR = Color.DKGRAY;

    private static float DEFAULT_FILL_RADIUS = 1f;

    private static final int DEFAULT_VIEW_SIZE = 96;

    private int mFillColor = DEFAULT_FILL_COLOR;

    private float mFillRadius = DEFAULT_FILL_RADIUS;

    private Paint mFillPaint;

    private int mViewSize;

    public CircleView(Context context) {
        super(context);
        init(null, 0);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.CircleView, defStyle, 0);


        mFillColor = a.getColor(R.styleable.CircleView_circleFillColor, DEFAULT_FILL_COLOR);
        mFillRadius = a.getFloat(R.styleable.CircleView_fillRadius, DEFAULT_FILL_RADIUS);

        a.recycle();

        //Fill Paint
        mFillPaint = new Paint();
        mFillPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mFillPaint.setStyle(Paint.Style.FILL);
        mFillPaint.setColor(mFillColor);

    }

    private void invalidatePaints() {
        mFillPaint.setColor(mFillColor);
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = resolveSize(DEFAULT_VIEW_SIZE, widthMeasureSpec);
        int height = resolveSize(DEFAULT_VIEW_SIZE, heightMeasureSpec);
        mViewSize = Math.min(width, height);

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        float radius = (mViewSize / 2) * mFillRadius;

        canvas.drawCircle(getWidth()/2, getHeight()/2, radius, mFillPaint);

    }

    /**
     * Gets the fill color attribute value.
     *
     * @return The fill color attribute value.
     */
    public int getFillColor() {
        return mFillColor;
    }


    /**
     * Sets the view's fill color attribute value.
     *
     * @param fillColor The fill color attribute value to use.
     */
    public void setFillColor(int fillColor) {
        mFillColor = fillColor;
        invalidatePaints();
    }

    /**
     * Gets the fill radius dimension attribute value.
     *
     * @return The fill radius dimension attribute value.
     */
    public float getFillRadius() {
        return mFillRadius;
    }

    /**
     * Sets the view's fill radius attribute value.
     *
     * @param fillRadius The fill radius attribute value to use.
     */
    public void setFillRadius(float fillRadius) {
        mFillRadius = fillRadius;
        invalidate();
    }
}