package com.example.diegojosuepachecorosas.gdwnewarchitecture

import android.app.Activity
import android.app.Application
import android.support.multidex.MultiDex
import com.example.diegojosuepachecorosas.gdwnewarchitecture.di.ApplicationComponent
import com.example.diegojosuepachecorosas.gdwnewarchitecture.di.DaggerApplicationComponent
import com.example.diegojosuepachecorosas.gdwnewarchitecture.di.api.ApiModule
import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class AndroidApplication : Application(), HasActivityInjector {

    @Inject
    internal lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent.builder()
                .application(this)
                .apiModule(ApiModule("https://www.googleapis.com/drive/v3/"))
                .Build()
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }

    override fun onCreate() {
        super.onCreate()
        injectMembers()
        MultiDex.install(this)
        initializeLeakDetection()
    }

    private fun injectMembers() = appComponent.inject(this)

    private fun initializeLeakDetection() {
        if (BuildConfig.DEBUG) LeakCanary.install(this)
    }


}
