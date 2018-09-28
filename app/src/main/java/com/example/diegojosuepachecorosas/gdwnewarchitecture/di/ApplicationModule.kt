package com.example.diegojosuepachecorosas.gdwnewarchitecture.di

import com.example.diegojosuepachecorosas.gdwnewarchitecture.core.scheduler.BaseSchedulerProvider
import com.example.diegojosuepachecorosas.gdwnewarchitecture.core.scheduler.SchedulerProvider
import com.example.diegojosuepachecorosas.gdwnewarchitecture.di.api.ApiModule
import com.example.diegojosuepachecorosas.gdwnewarchitecture.di.viewmodel.ViewModelModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class,ApiModule::class])
class ApplicationModule {

    @Singleton
    @Provides
    fun providesScheduler(provider: SchedulerProvider) : BaseSchedulerProvider{
       return provider
   }
}