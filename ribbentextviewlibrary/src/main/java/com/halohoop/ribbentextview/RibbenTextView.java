package com.halohoop.ribbentextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.halohoop.ribbentextview.utils.DensityUtil;
import com.halohoop.ribbentextview.utils.LogUtils;

/**
 * Created by Pooholah on 2016/7/26.
 */

public class RibbenTextView extends View {

    private Context mContext;
    private float mRotateDegrees = 45;
    private String mText;
    private Paint mRibbenPaint;
    private Paint mTextPaint;
    private int mTextColor = android.graphics.Color.parseColor("#FFFFFFFF");//white
    private int mRibbenColor = android.graphics.Color.parseColor("#FFFF0000");//red
    private Rect mTextRect;
    private TextRectWidhPadding mTextRectWidhPadding;
    private float mTextSize = 12;
    private int mTextPaddingTopAndBottom = 2;
    private int mTextPaddingLeftAndRight = 2;
    private int mRotatePosition = 0;

    public RibbenTextView(Context context) {
        this(context, null);
    }

    public RibbenTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RibbenTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        //设置背景为透明
        setBackgroundColor(android.graphics.Color.parseColor("#00000000"));
        TypedArray attributes = context.obtainStyledAttributes(attrs,
                R.styleable.RibbenTextView);
        mText = attributes.getString(R.styleable.RibbenTextView_text);
        if (TextUtils.isEmpty(mText)) {
            throw new RuntimeException("please use attr text to add a text for this widget!");
        }
        int defaultTextSize = DensityUtil.dip2px(context, mTextSize);
        int defaultTextPaddingTopAndBottom = DensityUtil.dip2px(context, mTextPaddingTopAndBottom);
        int defaultTextPaddingLeftAndRight = DensityUtil.dip2px(context, mTextPaddingLeftAndRight);
        mTextSize = attributes.getFloat(R.styleable.RibbenTextView_text_size, defaultTextSize);
        mTextPaddingTopAndBottom = attributes.getInteger(R.styleable.RibbenTextView_text_padding_top_and_bottom, defaultTextPaddingTopAndBottom);
        mTextPaddingLeftAndRight = attributes.getInteger(R.styleable.RibbenTextView_text_padding_left_and_right, defaultTextPaddingLeftAndRight);
        mTextSize = DensityUtil.dip2px(context, mTextSize);
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(mTextSize);
        mRibbenPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        getTextHeight();//get the width and height of the text based on the mTextSize;
        mRotateDegrees = attributes.getFloat(R.styleable.RibbenTextView_rotate_degree, mRotateDegrees);
        mRotatePosition = attributes.getInteger(R.styleable.RibbenTextView_rotate_position, mRotatePosition);
        mTextColor = attributes.getColor(R.styleable.RibbenTextView_text_color, mTextColor);
        mRibbenColor = attributes.getColor(R.styleable.RibbenTextView_ribben_color, mRibbenColor);
        mTextPaint.setColor(mTextColor);
        mRibbenPaint.setColor(mRibbenColor);
        attributes.recycle();
    }

    class TextRectWidhPadding {
        int width;
        int height;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //TODO 根据文字的宽度高度 以及角度 计算出宽高
        int textWidthWithPadding = mTextRectWidhPadding.width;
        int textHeightWithPadding = mTextRectWidhPadding.height;
        //计算出宽度
        double tan = Math.tan(mRotateDegrees * Math.PI / 180);
        double v = textHeightWithPadding / tan;
        double sqrt = Math.sqrt(textHeightWithPadding * textHeightWithPadding + v * v);
        double v1 = textHeightWithPadding * v / sqrt;
        double v2 = v1 / tan;
        double sin = Math.sin(mRotateDegrees * Math.PI / 180);
        double v3 = textWidthWithPadding * sin;
        double v4 = v3 / tan;
        double v5 = textHeightWithPadding * tan;
        double cos = Math.cos(mRotateDegrees * Math.PI / 180);
        double v6 = v5 * cos;
        double v7 = v6 * tan;
        int measuredHeight = (int) Math.round(v1 + v3 + v7);
        int measuredWidth = (int) Math.round(v2 + v4 + v6);
        setMeasuredDimension(Math.abs(measuredWidth), Math.abs(measuredHeight));
    }

//    private int getHeightCalculateFromMeasuredWidth(int measuredWidth, float mRotateDegrees) {
//        if (mRotateDegrees == 0) {
//            return mTextRect.height() + getPaddingBottom() + getPaddingTop();
//        }
//        double tan = Math.tan(mRotateDegrees * Math.PI / 180);
//        double v = tan * (float) measuredWidth;
//        return Math.abs((int) Math.round(v));
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        //draw ribben
        Path mPath = new Path();
        //对角线↓
        mPath.moveTo(0, 0);
        mPath.lineTo(getWidth(), getHeight());
        //对角线↑
        double cos = Math.cos(mRotateDegrees * Math.PI / 180);
        int rightBottomDistance = (int) Math.round(mTextRectWidhPadding.height / cos);
        mPath.lineTo(getWidth(), getHeight() - rightBottomDistance);
        double sin = Math.sin(mRotateDegrees * Math.PI / 180);
        int topLeftDistance = (int) Math.round(mTextRectWidhPadding.height / sin);
        mPath.lineTo(topLeftDistance, 0);
        mPath.close();
        canvas.drawPath(mPath, mRibbenPaint);
        canvas.restore();
        //------------------------
        //draw text
//        int height = mTextRect.height();
        canvas.save();
        int height = mTextRectWidhPadding.height;
        double tan = Math.tan(mRotateDegrees * Math.PI / 180);
        int transDistance = (int) Math.round(height / tan);
        canvas.rotate(mRotateDegrees, 0, 0);
        //需要把padding值给加上
        canvas.translate(transDistance + mTextPaddingLeftAndRight,
                -mTextPaddingTopAndBottom - mTextPaddingTopAndBottom / 4 - 2);//旋转之后就是斜着移动了
        canvas.drawText(mText, 0, 0, mTextPaint);
        canvas.restore();
    }

    private void getTextHeight() {
        if (mTextRect == null) {
            mTextRect = new Rect();
        }
        mTextPaint.getTextBounds(mText, 0, mText.length(), mTextRect);
        if (mTextRectWidhPadding == null) {
            mTextRectWidhPadding = new TextRectWidhPadding();
        }
        mTextRectWidhPadding.width = mTextRect.width() + mTextPaddingLeftAndRight * 2;
        mTextRectWidhPadding.height = mTextRect.height() + mTextPaddingTopAndBottom * 2;
        LogUtils.i("textWidth:" + mTextRect.width());
        LogUtils.i("textHeight:" + mTextRect.height());
        LogUtils.i("textWidthWidhPadding:" + mTextRectWidhPadding.width);
        LogUtils.i("textHeightWidhPadding:" + mTextRectWidhPadding.height);
    }

    public void invalidateIncludeReMeasureLayout() {
        getTextHeight();
        requestLayout();
        invalidate();
    }

    public void setText(String text) {
        this.mText = text;
        invalidateIncludeReMeasureLayout();
    }

    public void setTextSize(int textSize) {
        int textSizeNew = DensityUtil.dip2px(mContext, textSize);
        this.mTextSize = textSizeNew;
        invalidateIncludeReMeasureLayout();
    }


    public void setTextColor(int color) {
        this.mTextColor = color;
        invalidateIncludeReMeasureLayout();
    }

    public String getText() {
        return mText;
    }

    public int getTextColor() {
        return mTextColor;
    }

    public int getRibbenColor() {
        return mRibbenColor;
    }

    public float getTextSize() {
        return mTextSize;
    }
}
