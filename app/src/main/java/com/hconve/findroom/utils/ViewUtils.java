package com.hconve.findroom.utils;

import android.view.View;

public class ViewUtils {
    public static void gone(View view) {
        view.setVisibility(View.GONE);
    }

    public static void show(View view) {
        view.setVisibility(View.VISIBLE);
    }

    public static void hidden(View view) {
        view.setVisibility(View.INVISIBLE);
    }
}
