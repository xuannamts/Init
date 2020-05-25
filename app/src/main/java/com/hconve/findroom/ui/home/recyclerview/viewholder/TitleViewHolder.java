package com.hconve.findroom.ui.home.recyclerview.viewholder;

import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hconve.findroom.widgets.recyclerview.viewholder.BaseTitleViewHolder;

public class TitleViewHolder extends BaseTitleViewHolder {
    public TitleViewHolder(ViewGroup parent) {
        super(parent);
    }

    @Override
    protected void applyTextView(TextView textView) {
        textView.setTextSize(20);
        textView.setGravity(Gravity.LEFT);

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        if (params != null) {
            params.leftMargin = 20;
            params.topMargin = params.bottomMargin = 10;
            itemView.setLayoutParams(params);
        }
    }
}
