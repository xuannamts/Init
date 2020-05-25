package com.hconve.findroom.di;

import com.hconve.findroom.data.repositories.SearchOptionRepository;
import com.hconve.findroom.di.scopes.AppScoped;

import dagger.Binds;
import dagger.Module;

@Module(includes = {RepositoryModule.RepositoryAbstractModule.class})
public class RepositoryModule {

    @Module
    interface RepositoryAbstractModule {
        @AppScoped
        @Binds
        SearchOptionRepository bindLocationRepository(SearchOptionRepository.SearchOptionRepositoryImpl repository);
    }
}
