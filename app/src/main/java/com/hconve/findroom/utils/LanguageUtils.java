package com.hconve.findroom.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;

public class LanguageUtils {
    public static void changeLanguage(Context context, String languageCode) {
        Locale locale = new Locale(languageCode);
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
