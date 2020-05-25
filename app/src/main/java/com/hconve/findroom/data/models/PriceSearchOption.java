package com.hconve.findroom.data.models;

import android.content.Context;

import com.hconve.findroom.R;

public class PriceSearchOption {
    int lowerBound;
    int upperBound;

    public PriceSearchOption(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public String getDescription(Context context) {
        if (lowerBound == -1 && upperBound == -1) return "";
        if (lowerBound == -1) {
            return String.format("%s %d VND", context.getString(R.string.below), upperBound);
        }
        if (upperBound == -1) {
            return String.format("%s %d VND", context.getString(R.string.above), lowerBound);
        }
        return String.format("%d - %d VND", lowerBound, upperBound);
    }
}
