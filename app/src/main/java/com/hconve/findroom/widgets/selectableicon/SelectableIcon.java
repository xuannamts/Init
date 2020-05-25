package com.hconve.findroom.widgets.selectableicon;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hconve.findroom.R;
import com.hconve.findroom.utils.ResourceUtils;

public class SelectableIcon extends RelativeLayout {

    private ImageView imageView;

    private int mIconResId = -1;
    private boolean mIsSelected = false;

    public SelectableIcon(Context context, int iconResId) {
        super(context);
        mIconResId = iconResId;
        initViews();
    }

    public SelectableIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        retrieveAttributes(attrs);
        initViews();
    }

    public SelectableIcon(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        retrieveAttributes(attrs);
        initViews();
    }

    public void setIconResource(int resId) {
        mIconResId = resId;
        imageView.setImageResource(mIconResId);
    }

    private void initViews() {
        inflate(getContext(), R.layout.layout_selectable_icon, this);
        bindingUI();

        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mIsSelected = !mIsSelected;
                if (mIsSelected) {
                    imageView.setColorFilter(ResourceUtils.getColor(getContext(), R.color.colorPrimary));
                } else {
                    imageView.setColorFilter(ResourceUtils.getColor(getContext(), R.color.colorBlack));
                }
            }
        });

        if (mIconResId != -1) {
            imageView.setImageResource(mIconResId);
        }
    }

    private void retrieveAttributes(AttributeSet attrs) {
        if (attrs == null) return;
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.SelectableIcon);
        mIconResId = typedArray.getResourceId(R.styleable.SelectableIcon_si_icon, mIconResId);
        typedArray.recycle();
    }

    private void bindingUI() {
        imageView = findViewById(R.id.imageView);
    }
}
