package com.hconve.findroom.ui.home;

import dagger.Module;

@Module(includes = {HomeModule.HomeAbstractModule.class})
public class HomeModule {

    @Module
    interface HomeAbstractModule {
    }
}
