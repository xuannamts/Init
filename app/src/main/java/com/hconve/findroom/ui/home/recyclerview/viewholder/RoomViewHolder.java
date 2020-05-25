package com.hconve.findroom.ui.home.recyclerview.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hconve.findroom.R;
import com.hconve.findroom.ui.home.recyclerview.item.RoomItem;
import com.hconve.findroom.ui.room.detail.RoomDetailActivity;
import com.hconve.findroom.widgets.recyclerview.CustomRecyclerView;

public class RoomViewHolder extends CustomRecyclerView.ViewHolder<RoomItem> {
    private ImageView imageView;
    private TextView titleTextView;
    private TextView addressTextView;
    private TextView priceTextView;
    private View clickableView;

    public RoomViewHolder(ViewGroup parent) {
        super(newInstance(parent));
        bindingUI();
        handleEvents();
    }

    @Override
    public void bind(RoomItem item) {
        imageView.setImageResource(item.data.backgroundColor);
        titleTextView.setText(item.data.title);
        addressTextView.setText(item.data.address);
        priceTextView.setText(String.valueOf(item.data.price));
    }

    private void bindingUI() {
        imageView = itemView.findViewById(R.id.imageView);
        titleTextView = itemView.findViewById(R.id.titleTextView);
        addressTextView = itemView.findViewById(R.id.addressTextView);
        priceTextView = itemView.findViewById(R.id.priceTextView);
        clickableView = itemView.findViewById(R.id.clickableView);
    }

    private void handleEvents() {
        clickableView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = itemView.getContext();
                context.startActivity(RoomDetailActivity.getInstance(context));
            }
        });
    }

    public static View newInstance(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_room, parent, false);
    }
}
