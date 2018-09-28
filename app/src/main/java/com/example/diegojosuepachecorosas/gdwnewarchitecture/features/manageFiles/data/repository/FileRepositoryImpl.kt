package com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.data.repository

import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.data.datasource.FileDatasource
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.domain.repository.FileRepository
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.domain.entity.files
import io.reactivex.Observable
import javax.inject.Inject

class FileRepositoryImpl
@Inject constructor(private val fileDatasource: FileDatasource) : FileRepository {


    override fun allFiles(): Observable<List<files>> {
        return fileDatasource.allFiles()

    }
}