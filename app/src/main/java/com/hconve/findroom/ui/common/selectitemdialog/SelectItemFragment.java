package com.hconve.findroom.ui.common.selectitemdialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.hconve.findroom.R;

import java.util.ArrayList;

public class SelectItemFragment extends BottomSheetDialogFragment {
    private OnSelectItemListener mOnSelectItemListener;
    private String mKey;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_select_item, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mKey = getArguments().getString(KEY_EXTRA);
        ArrayList<String> items = getArguments().getStringArrayList(LIST_ITEM_EXTRA);
        recyclerView.setAdapter(new ItemAdapter(items));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mOnSelectItemListener = null;
    }

    public void setOnSelectItemListener(OnSelectItemListener onSelectItemListener) {
        mOnSelectItemListener = onSelectItemListener;
    }

    public static String TAG = SelectItemFragment.class.getName();
    private static String LIST_ITEM_EXTRA = "LIST_ITEM_EXTRA";
    private static String KEY_EXTRA = "KEY_EXTRA";

    public static SelectItemFragment newInstance(String key, ArrayList<String> items) {
        SelectItemFragment result = new SelectItemFragment();
        final Bundle args = new Bundle();
        args.putStringArrayList(LIST_ITEM_EXTRA, items);
        args.putString(KEY_EXTRA, key);
        result.setArguments(args);
        return result;
    }

    public interface OnSelectItemListener {
        void onSelectItem(String key, int selectedIndex);
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        final TextView text;

        ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            // TODO: Customize the item layout
            super(inflater.inflate(R.layout.item_selectable_title, parent, false));
            text = itemView.findViewById(R.id.text);
        }
    }

    private class ItemAdapter extends RecyclerView.Adapter<ViewHolder> {

        private final ArrayList<String> items;

        ItemAdapter(ArrayList<String> items) {
            this.items = items;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.text.setText(items.get(position));
            holder.text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnSelectItemListener != null) {
                        mOnSelectItemListener.onSelectItem(mKey, position);
                    }
                    dismiss();
                }
            });
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }
}
