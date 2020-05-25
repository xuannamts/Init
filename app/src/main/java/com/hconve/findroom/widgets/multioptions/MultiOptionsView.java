package com.hconve.findroom.widgets.multioptions;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.hconve.findroom.R;

public class MultiOptionsView extends RelativeLayout {
    public MultiOptionsView(Context context) {
        super(context);
        initViews();
    }

    public MultiOptionsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        retrieveAttributes(attrs);
        initViews();
    }

    public MultiOptionsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        retrieveAttributes(attrs);
        initViews();
    }

    private void initViews() {
        inflate(getContext(), R.layout.layout_multi_options, this);
        bindingUI();
    }

    private void retrieveAttributes(AttributeSet attrs) {

    }

    private void bindingUI() {

    }
}
