package com.hconve.findroom.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideUtils {
    public static void loadDrawable(int resId, ImageView imageView) {
        Glide.with(imageView.getContext()).load(resId).into(imageView);
    }
}
