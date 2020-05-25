package com.hconve.findroom.ui.home.recyclerview.item;

import com.hconve.findroom.data.models.FindTrending;
import com.hconve.findroom.widgets.recyclerview.CustomRecyclerView;

import java.util.ArrayList;

public class FindTrendingListItem extends CustomRecyclerView.Item {
    public ArrayList<FindTrending> findTrending = new ArrayList<>();

    public FindTrendingListItem(ArrayList<FindTrending> findTrending) {
        this.findTrending = findTrending;
    }

    public ArrayList<FindTrendingItem> toListOfFindTrendingItem() {
        ArrayList<FindTrendingItem> result = new ArrayList<>();
        for (int i = 0; i < findTrending.size(); i++) {
            result.add(new FindTrendingItem(findTrending.get(i)));
        }
        return result;
    }
}
