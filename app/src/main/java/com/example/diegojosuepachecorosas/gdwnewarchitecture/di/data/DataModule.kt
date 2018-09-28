package com.example.diegojosuepachecorosas.gdwnewarchitecture.di.data

import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.data.datasource.FileDatasource
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.data.datasource.rest.FilesRestDatasource
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.data.repository.FileRepositoryImpl
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.domain.repository.FileRepository
import dagger.Binds
import dagger.Module


@Module
abstract class DataModule{

    @Binds
    abstract fun provideFileDatasource(impl:FilesRestDatasource) : FileDatasource

    @Binds
    abstract fun provideFileRepository(impl: FileRepositoryImpl) : FileRepository

}