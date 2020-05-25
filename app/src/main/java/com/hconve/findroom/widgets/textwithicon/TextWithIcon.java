package com.hconve.findroom.widgets.textwithicon;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

import com.hconve.findroom.R;

public class TextWithIcon extends RelativeLayout {

    private TextView textView;
    private ImageView iconImageView;
    private View clickableView;

    private String mText;
    @DrawableRes
    private Integer mIconResId = -1;

    public TextWithIcon(Context context) {
        super(context);
        initViews();
    }

    public TextWithIcon(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        retrieveAttributes(attrs);
        initViews();
    }

    public TextWithIcon(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        retrieveAttributes(attrs);
        initViews();
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        clickableView.setOnClickListener(l);
    }

    public void setText(String text) {
        mText = text;
        if (mText != null) textView.setText(mText);
    }

    private void retrieveAttributes(AttributeSet attrs) {
        if (attrs == null) return;
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.TextWithIcon);
        mText = typedArray.getString(R.styleable.TextWithIcon_twi_text);
        mIconResId = typedArray.getResourceId(R.styleable.TextWithIcon_twi_icon, -1);
        typedArray.recycle();
    }

    private void initViews() {
        inflate(getContext(), R.layout.layout_text_with_icon, this);
        bindingUI();

        if (mText != null) textView.setText(mText);
        if (mIconResId != -1) {
            iconImageView.setImageResource(mIconResId);
            iconImageView.setColorFilter(getContext().getResources().getColor(R.color.colorPrimary));
        }
    }

    private void bindingUI() {
        textView = findViewById(R.id.textView);
        iconImageView = findViewById(R.id.iconImageView);
        clickableView = findViewById(R.id.clickableView);
    }
}
