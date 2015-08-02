package com.logoocc.titleview.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.logoocc.titleview.R;

/**
 * Created by samchen on 8/2/15.
 */

// 属性在 values/attrs.xml 内定义
public class TitleView extends RelativeLayout {
    private ImageView left;
    private TextView center;
    private TextView right;


    public TitleView(Context context) {
        super(context);
        init(null);
    }

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public TitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_title, this);

        left = (ImageView) findViewById(R.id.title_left);
        center = (TextView) findViewById(R.id.title_center);
        right = (TextView) findViewById(R.id.title_right);

        if (attrs == null) {
            return;
        }
        // 从 attrs.xml 中读取属性
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.TitleView);
        int N = a.getIndexCount();
        for (int i = 0; i < N; i++) {
            int index = a.getIndex(i);
            switch (index) {
                case R.styleable.TitleView_tv_left_img_src:
                    Drawable drawable = a.getDrawable(index);
                    left.setImageDrawable(drawable);
                    break;
                case R.styleable.TitleView_tv_left_img_visibility:
                    int value = a.getInt(index, 0);
                    if (value == 0) {
                        left.setVisibility(View.VISIBLE);
                    } else {
                        left.setVisibility(View.GONE);
                    }
                    break;
                case R.styleable.TitleView_tv_center_text:
                    String str = a.getString(index);
                    center.setText(str);
                    break;
                case R.styleable.TitleView_tv_center_textSize:
                    int size = a.getDimensionPixelSize(index, 20);
                    center.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
                    break;
                case R.styleable.TitleView_tv_right_text:
                    str = a.getString(index);
                    right.setText(str);
                    break;
                case R.styleable.TitleView_tv_right_textSize:
                    size = a.getDimensionPixelSize(index, 20);
                    right.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
                    break;

            }

        }
    }

    public void setOnLeftClickListener(OnClickListener clickListener) {
        left.setOnClickListener(clickListener);
    }

    public void setOnRightClickListener(OnClickListener clickListener) {
        right.setOnClickListener(clickListener);
    }

    public void setCenterTitle(String str) {
        center.setText(str);
    }

    public void setRightTitle(String str) {
        right.setText(str);
    }

    public void setLeftImage(int resid) {
        Drawable drawable = getResources().getDrawable(resid);
        left.setImageDrawable(drawable);
    }
}
