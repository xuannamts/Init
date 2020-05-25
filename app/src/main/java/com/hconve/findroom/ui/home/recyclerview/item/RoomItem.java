package com.hconve.findroom.ui.home.recyclerview.item;

import com.hconve.findroom.data.models.Room;
import com.hconve.findroom.widgets.recyclerview.CustomRecyclerView;

public class RoomItem extends CustomRecyclerView.Item {
    public Room data;

    public RoomItem(Room data) {
        this.data = data;
    }
}
