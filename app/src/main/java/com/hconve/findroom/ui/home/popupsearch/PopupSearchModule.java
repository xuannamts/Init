package com.hconve.findroom.ui.home.popupsearch;

import com.hconve.findroom.di.scopes.FragmentScoped;

import dagger.Binds;
import dagger.Module;

@Module(includes = {PopupSearchModule.PopupSearchAbstractModule.class})
public class PopupSearchModule {

    @Module
    interface PopupSearchAbstractModule {
        @FragmentScoped
        @Binds
        PopupSearchContract.View bindPopupSearchView(PopupSearchFragment popupSearchView);

        @FragmentScoped
        @Binds
        PopupSearchContract.Presenter bindPopupSearchPresenter(PopupSearchPresenter popupSearchPresenter);
    }
}
