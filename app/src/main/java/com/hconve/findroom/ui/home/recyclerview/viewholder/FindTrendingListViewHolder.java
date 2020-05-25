package com.hconve.findroom.ui.home.recyclerview.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hconve.findroom.R;
import com.hconve.findroom.ui.home.recyclerview.item.FindTrendingItem;
import com.hconve.findroom.ui.home.recyclerview.item.FindTrendingListItem;
import com.hconve.findroom.widgets.recyclerview.CustomRecyclerView;

import java.util.ArrayList;

public class FindTrendingListViewHolder extends CustomRecyclerView.ViewHolder<FindTrendingListItem> {

    private RecyclerView mRecyclerView;

    public FindTrendingListViewHolder(ViewGroup parent) {
        super(newInstance(parent));
        mRecyclerView = itemView.findViewById(R.id.recyclerView);

        initViews();
    }

    @Override
    public void bind(FindTrendingListItem item) {
        ArrayList<CustomRecyclerView.Item> items = new ArrayList<>();
        items.addAll(item.toListOfFindTrendingItem());
        mRecyclerView.setAdapter(
                new FindTrendingAdapter(items)
        );
    }

    private void initViews() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(
                mRecyclerView.getContext(),
                MAX_ROWS_ITEM,
                GridLayoutManager.HORIZONTAL,
                false
        );
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setNestedScrollingEnabled(false);
    }

    public static View newInstance(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_find_trending_list, parent, false);
    }

    private static class FindTrendingAdapter extends CustomRecyclerView.Adapter {

        public FindTrendingAdapter(ArrayList<CustomRecyclerView.Item> items) {
            super(items);
        }

        @NonNull
        @Override
        public CustomRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            if (getViewType(FindTrendingItem.class.getName()) == viewType) {
                return new FindTrendingItemViewHolder(parent);
            }
            return null;
        }


    }

    private static int MAX_ROWS_ITEM = 2;
}