package com.example.diegojosuepachecorosas.gdwnewarchitecture.di.activity

import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.presentation.activity.FilesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [])
    abstract fun providesFileActivity(): FilesActivity


}