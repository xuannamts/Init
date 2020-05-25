package com.hconve.findroom.widgets.recyclerview.item;

import com.hconve.findroom.widgets.recyclerview.CustomRecyclerView;

public class TitleItem extends CustomRecyclerView.Item {
    public String text;

    public TitleItem(String text) {
        this.text = text;
    }
}
