package com.hconve.findroom.data.source.sharedprefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.hconve.findroom.app.Constants;

public class SharedPrefsImpl implements SharedPrefs {
    private SharedPreferences mSharedPreferences;

    private SharedPrefsImpl(Context context) {
        mSharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> anonymousClass) {
        if (anonymousClass == String.class) {
            return (T) mSharedPreferences.getString(key, "");
        } else if (anonymousClass == Boolean.class) {
            return (T) Boolean.valueOf(mSharedPreferences.getBoolean(key, false));
        } else if (anonymousClass == Float.class) {
            return (T) Float.valueOf(mSharedPreferences.getFloat(key, 0));
        } else if (anonymousClass == Integer.class) {
            return (T) Integer.valueOf(mSharedPreferences.getInt(key, 0));
        } else if (anonymousClass == Long.class) {
            return (T) Long.valueOf(mSharedPreferences.getLong(key, 0));
        } else {
            return (T) (new Gson())
                    .fromJson(mSharedPreferences.getString(key, ""), anonymousClass);
        }
    }

    @Override
    public <T> void put(String key, T data) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        if (data instanceof String) {
            editor.putString(key, (String) data);
        } else if (data instanceof Boolean) {
            editor.putBoolean(key, (Boolean) data);
        } else if (data instanceof Float) {
            editor.putFloat(key, (Float) data);
        } else if (data instanceof Integer) {
            editor.putInt(key, (Integer) data);
        } else if (data instanceof Long) {
            editor.putLong(key, (Long) data);
        } else {
            editor.putString(key, (new Gson()).toJson(data));
        }
        editor.apply();
    }
}
