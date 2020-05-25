package com.hconve.findroom.ui.home;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.hconve.findroom.data.models.FindTrending;
import com.hconve.findroom.ui.home.recyclerview.item.FindTrendingListItem;
import com.hconve.findroom.ui.home.recyclerview.item.RoomItem;
import com.hconve.findroom.ui.home.recyclerview.viewholder.FindTrendingListViewHolder;
import com.hconve.findroom.ui.home.recyclerview.viewholder.RoomViewHolder;
import com.hconve.findroom.ui.home.recyclerview.viewholder.TitleViewHolder;
import com.hconve.findroom.widgets.recyclerview.CustomRecyclerView;
import com.hconve.findroom.widgets.recyclerview.item.LoadingItem;
import com.hconve.findroom.widgets.recyclerview.item.TitleItem;
import com.hconve.findroom.widgets.recyclerview.viewholder.BaseLoadingViewHolder;

import java.util.ArrayList;

public class HomeAdapter extends CustomRecyclerView.Adapter {
    public HomeAdapter(ArrayList<CustomRecyclerView.Item> items) {
        super(items);
    }

    @NonNull
    @Override
    public CustomRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (getViewType(LoadingItem.class.getName()) == viewType) {
            return new BaseLoadingViewHolder(parent);
        }
        if (getViewType(FindTrendingListItem.class.getName()) == viewType) {
            return new FindTrendingListViewHolder(parent);
        }
        if (getViewType(TitleItem.class.getName()) == viewType) {
            return new TitleViewHolder(parent);
        }
        if (getViewType(RoomItem.class.getName()) == viewType) {
            return new RoomViewHolder(parent);
        }
        return null;
    }

    public void updateFindTrendingList(ArrayList<FindTrending> findTrending) {
        ArrayList<CustomRecyclerView.Item> items = getItems();
        for (int i = 0; i < getItemCount(); i++) {
            Object item = items.get(i);
            if (item instanceof FindTrendingListItem) {
                ((FindTrendingListItem) item).findTrending.addAll(findTrending);
                notifyItemChanged(i);
                break;
            }
        }
    }
}
