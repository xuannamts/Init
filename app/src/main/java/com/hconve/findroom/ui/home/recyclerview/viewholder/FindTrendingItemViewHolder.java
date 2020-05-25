package com.hconve.findroom.ui.home.recyclerview.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hconve.findroom.R;
import com.hconve.findroom.ui.home.recyclerview.item.FindTrendingItem;
import com.hconve.findroom.widgets.recyclerview.CustomRecyclerView;

public class FindTrendingItemViewHolder extends CustomRecyclerView.ViewHolder<FindTrendingItem> {

    private ImageView imageView;
    private TextView textView;

    public FindTrendingItemViewHolder(ViewGroup parent) {
        super(newInstance(parent));
        bindingUI();
    }

    @Override
    public void bind(FindTrendingItem item) {
        imageView.setBackgroundResource(item.data.backgroundColor);
        textView.setText(item.data.text);
    }

    private void bindingUI() {
        imageView = itemView.findViewById(R.id.imageView);
        textView = itemView.findViewById(R.id.textView);
    }

    private static View newInstance(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_find_trending, parent, false);
    }
}
