package com.hconve.findroom.di;

import com.hconve.findroom.di.scopes.FragmentScoped;
import com.hconve.findroom.ui.home.HomeFragment;
import com.hconve.findroom.ui.home.HomeModule;
import com.hconve.findroom.ui.home.popupsearch.PopupSearchFragment;
import com.hconve.findroom.ui.home.popupsearch.PopupSearchModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBindingModule {
    @FragmentScoped
    @ContributesAndroidInjector(modules = {HomeModule.class})
    abstract HomeFragment contributeHomeFragment();

    @FragmentScoped
    @ContributesAndroidInjector(modules = {PopupSearchModule.class})
    abstract PopupSearchFragment contributePopupSearchFragment();
}
