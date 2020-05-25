package com.hconve.findroom.widgets.loadingbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.hconve.findroom.R;
import com.hconve.findroom.utils.ViewUtils;

public class LoadingButton extends RelativeLayout {

    private CardView cardView;
    private View clickableView;
    private TextView textView;
    private View progressBar;

    private float mCornerRadius = 0;
    private String mText = "";

    public LoadingButton(Context context) {
        super(context);
        initViews();
    }

    public LoadingButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        retrieveAttributes(attrs);
        initViews();
    }

    public LoadingButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        retrieveAttributes(attrs);
        initViews();
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        clickableView.setOnClickListener(l);
    }

    public void showLoading() {
        ViewUtils.show(progressBar);
    }

    public void hiddenLoading() {
        ViewUtils.hidden(progressBar);
    }

    private void retrieveAttributes(AttributeSet attrs) {
        if (attrs == null) return;
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.LoadingButton);
        mCornerRadius = typedArray.getDimension(R.styleable.LoadingButton_lb_cornerRadius, mCornerRadius);
        mText = typedArray.getString(R.styleable.LoadingButton_lb_text);
        typedArray.recycle();
    }

    private void initViews() {
        inflate(getContext(), R.layout.layout_loading_button, this);
        bindingUI();

        if (mText != null) textView.setText(mText);
        cardView.setRadius(mCornerRadius);
    }

    private void bindingUI() {
        clickableView = findViewById(R.id.clickableView);
        textView = findViewById(R.id.textView);
        cardView = findViewById(R.id.cardView);
        progressBar = findViewById(R.id.progressBar);
    }
}
