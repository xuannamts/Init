package com.hconve.findroom.widgets.recyclerview.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hconve.findroom.R;
import com.hconve.findroom.utils.GlideUtils;
import com.hconve.findroom.widgets.recyclerview.CustomRecyclerView;
import com.hconve.findroom.widgets.recyclerview.item.LoadingItem;

public class BaseLoadingViewHolder extends CustomRecyclerView.ViewHolder<LoadingItem> {

    public BaseLoadingViewHolder(ViewGroup parent) {
        super(newInstance(parent));
    }

    @Override
    public void bind(LoadingItem item) {
        // No-op
    }

    private static View newInstance(ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_loading, parent, false);
        ImageView imageView = itemView.findViewById(R.id.imageView);
        GlideUtils.loadDrawable(R.drawable.ic_loading, imageView);
        return itemView;
    }
}
