package com.example.diegojosuepachecorosas.gdwnewarchitecture.di

import android.app.Application
import com.example.diegojosuepachecorosas.gdwnewarchitecture.AndroidApplication
import com.example.diegojosuepachecorosas.gdwnewarchitecture.di.activity.ActivityBuilderModule
import com.example.diegojosuepachecorosas.gdwnewarchitecture.di.api.ApiModule
import com.example.diegojosuepachecorosas.gdwnewarchitecture.di.data.DataModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class,ActivityBuilderModule::class,DataModule::class,AndroidSupportInjectionModule::class])
interface ApplicationComponent : AndroidInjector<DaggerApplication> {
    fun inject(application: AndroidApplication)

    @Component.Builder
    interface Builder {
        fun Build(): ApplicationComponent

        @BindsInstance
        fun application(application: Application): Builder

        fun apiModule(apiModule: ApiModule): Builder
    }
}