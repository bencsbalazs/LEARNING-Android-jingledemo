package com.example.jingle_demo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import com.example.jingle_demo.R;

public class RoundedCornerView extends View {
    private int topLeftCornerRadius;
    private int topRightCornerRadius;
    private int bottomLeftCornerRadius;
    private int bottomRightCornerRadius;
    private float[] corners;

    public RoundedCornerView(Context context) {
        super(context);
        init(context);
    }

    public RoundedCornerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        readAttributes(context, attrs);
    }

    public RoundedCornerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        readAttributes(context, attrs);
    }

    private void init(final Context context){
        corners = new float[] {
                topLeftCornerRadius,
                topLeftCornerRadius,
                topRightCornerRadius,
                topRightCornerRadius,
                bottomRightCornerRadius,
                bottomRightCornerRadius,
                bottomLeftCornerRadius,
                bottomLeftCornerRadius
        };
    }
    private void readAttributes(final Context context, final AttributeSet attr){
        TypedArray ta = context.obtainStyledAttributes(attr, R.styleable.RoundedCornerView, 0, 0);
        try {
            this.topLeftCornerRadius = Math.round(ta.getDimension(R.styleable.RoundedCornerView_topLeftCornerRadius, 0.0f));
            this.topRightCornerRadius = Math.round(ta.getDimension(R.styleable.RoundedCornerView_topRightCornerRadius, 0.0f));
            this.bottomLeftCornerRadius = Math.round(ta.getDimension(R.styleable.RoundedCornerView_bottomLeftCornerRadius, 0.0f));
            this.bottomRightCornerRadius = Math.round(ta.getDimension(R.styleable.RoundedCornerView_bottomRightCornerRadius, 0.0f));
        } finally {
            ta.recycle();
        }
    }

    public void setCorners(final float topLeftRadius, final float topRightRadius, final float bottomLeftRadius, final float bottomRightRadius){
        corners = new float[] {
                topLeftRadius,
                topLeftRadius,
                topRightRadius,
                topRightRadius,
                bottomLeftRadius,
                bottomLeftRadius,
                bottomRightRadius,
                bottomRightRadius
        };
    }

    public void setBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            setBackground(new RoundedCornerDrawable(bitmap, 0, corners));
        } else {
            setBackgroundColor(Color.TRANSPARENT);
        }
    }
}
