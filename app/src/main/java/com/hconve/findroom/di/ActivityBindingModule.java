package com.hconve.findroom.di;

import com.hconve.findroom.di.scopes.ActivityScoped;
import com.hconve.findroom.ui.main.MainActivity;
import com.hconve.findroom.ui.main.MainModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = {MainModule.class})
    abstract MainActivity contributeMainActivity();
}
