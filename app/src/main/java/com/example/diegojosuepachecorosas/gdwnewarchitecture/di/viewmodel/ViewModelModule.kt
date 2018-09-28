package com.example.diegojosuepachecorosas.gdwnewarchitecture.di.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.presentation.viewmodel.FilesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(FilesViewModel::class)
    abstract fun bindsFilesViewModel(filesViewModel: FilesViewModel) : ViewModel


}