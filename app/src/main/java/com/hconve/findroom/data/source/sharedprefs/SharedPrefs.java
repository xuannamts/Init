package com.hconve.findroom.data.source.sharedprefs;

public interface SharedPrefs {
    <T> T get(String key, Class<T> anonymousClass);

    <T> void put(String key, T data);
}
