package com.hconve.findroom.di;

import android.app.Application;
import android.content.Context;

import com.hconve.findroom.data.source.sharedprefs.SharedPrefs;
import com.hconve.findroom.data.source.sharedprefs.SharedPrefsImpl;
import com.hconve.findroom.di.scopes.AppScoped;

import dagger.Binds;
import dagger.Module;

@Module(includes = {AppModule.AppAbstractModule.class})
public class AppModule {

    @Module
    interface AppAbstractModule {
        @AppScoped
        @Binds
        Context bindApplicationContext(Application application);

        @AppScoped
        @Binds
        SharedPrefs bindSharedPreference(SharedPrefsImpl sharedPrefsImpl);
    }
}
