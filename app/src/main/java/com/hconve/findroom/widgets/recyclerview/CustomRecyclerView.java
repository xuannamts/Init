package com.hconve.findroom.widgets.recyclerview;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomRecyclerView {
    public static abstract class Item {
    }

    public static abstract class ViewHolder<T extends Item> extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        public abstract void bind(T item);
    }

    public static abstract class Adapter extends RecyclerView.Adapter<ViewHolder> {
        private ArrayList<Item> mItems;
        private HashMap<String, Integer> mViewTypes;

        public Adapter(ArrayList<Item> items) {
            mItems = items;
            mViewTypes = new HashMap<>();
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.bind(mItems.get(position));
        }

        @Override
        public int getItemViewType(int position) {
            String className = mItems.get(position).getClass().getName();
            Integer viewType = mViewTypes.get(className);
            if (viewType == null) {
                viewType = mViewTypes.size();
                mViewTypes.put(className, viewType);
            }
            return viewType;
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        public ArrayList<Item> getItems() {
            return mItems;
        }

        public int getViewType(String className) {
            Integer result = mViewTypes.get(className);
            return (result != null) ? result : -1;
        }
    }
}