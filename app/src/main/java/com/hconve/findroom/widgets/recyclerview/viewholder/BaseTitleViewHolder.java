package com.hconve.findroom.widgets.recyclerview.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hconve.findroom.R;
import com.hconve.findroom.widgets.recyclerview.CustomRecyclerView;
import com.hconve.findroom.widgets.recyclerview.item.TitleItem;

public class BaseTitleViewHolder extends CustomRecyclerView.ViewHolder<TitleItem> {

    private TextView mTextView;

    public BaseTitleViewHolder(ViewGroup parent) {
        super(newInstance(parent));
        mTextView = itemView.findViewById(R.id.titleTextView);
        applyTextView(mTextView);
    }

    @Override
    public void bind(TitleItem item) {
        mTextView.setText(item.text);
    }

    protected void applyTextView(TextView textView) {
        // No-op, override in sub-class
    }

    private static View newInstance(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_title, parent, false);
    }
}