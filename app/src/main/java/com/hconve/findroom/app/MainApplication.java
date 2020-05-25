package com.hconve.findroom.app;

import com.hconve.findroom.utils.LanguageUtils;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class MainApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        LanguageUtils.changeLanguage(getBaseContext(), "vi");
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
