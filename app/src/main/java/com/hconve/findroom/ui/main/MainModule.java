package com.hconve.findroom.ui.main;

import com.hconve.findroom.di.scopes.ActivityScoped;
import com.hconve.findroom.ui.account.AccountFragment;
import com.hconve.findroom.ui.around.MapsFragment;
import com.hconve.findroom.ui.exchange.ExchangeFragment;
import com.hconve.findroom.ui.home.HomeFragment;

import dagger.Module;
import dagger.Provides;

@Module(includes = {MainModule.MainAbstractModule.class})
public class MainModule {
    @ActivityScoped
    @Provides
    MainViewPagerAdapter provideMainViewPagerAdapter(MainActivity mainActivity) {
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(mainActivity.getSupportFragmentManager());
        adapter.addFragment(HomeFragment.newInstance());
        adapter.addFragment(MapsFragment.newInstance());
        adapter.addFragment(ExchangeFragment.newInstance());
        adapter.addFragment(AccountFragment.newInstance());
        return adapter;
    }

    @Module
    interface MainAbstractModule {
    }
}
