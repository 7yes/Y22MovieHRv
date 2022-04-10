package com.sevenyes.w5moviesrvhiltmvvm.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ViewModelComponent::class)
class ServicesModule {

    @Provides
    fun providesIO(): CoroutineDispatcher{
        return Dispatchers.IO
    }
}