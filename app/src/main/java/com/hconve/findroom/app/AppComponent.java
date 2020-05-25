package com.hconve.findroom.app;

import android.app.Application;

import com.hconve.findroom.di.ActivityBindingModule;
import com.hconve.findroom.di.AppModule;
import com.hconve.findroom.di.FragmentBindingModule;
import com.hconve.findroom.di.RepositoryModule;
import com.hconve.findroom.di.scopes.AppScoped;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@AppScoped
@Component(
        modules = {AppModule.class,
                ActivityBindingModule.class,
                FragmentBindingModule.class,
                RepositoryModule.class,
                AndroidSupportInjectionModule.class}
)
interface AppComponent extends AndroidInjector<MainApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
