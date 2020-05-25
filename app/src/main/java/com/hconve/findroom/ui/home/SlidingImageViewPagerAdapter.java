package com.hconve.findroom.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.hconve.findroom.R;

import java.util.ArrayList;

public class SlidingImageViewPagerAdapter extends PagerAdapter {
    private ArrayList<Integer> mItems;
    private Context mContext;

    SlidingImageViewPagerAdapter(Context context) {
        mContext = context;
        mItems = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_image_pager, container, false);
        ImageView imageView = itemView.findViewById(R.id.imageView);
        imageView.setBackgroundResource(mItems.get(position));
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    public void addImage(int resId) {
        mItems.add(resId);
    }
}
