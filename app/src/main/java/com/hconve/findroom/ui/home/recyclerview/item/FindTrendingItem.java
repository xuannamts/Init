package com.hconve.findroom.ui.home.recyclerview.item;

import com.hconve.findroom.data.models.FindTrending;
import com.hconve.findroom.widgets.recyclerview.CustomRecyclerView;

public class FindTrendingItem extends CustomRecyclerView.Item {
    public FindTrending data;

    public FindTrendingItem(FindTrending data) {
        this.data = data;
    }
}
