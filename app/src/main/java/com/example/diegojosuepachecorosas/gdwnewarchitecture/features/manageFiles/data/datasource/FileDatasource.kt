package com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.data.datasource

import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.domain.entity.File
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.domain.entity.files
import io.reactivex.Observable

interface FileDatasource {

    fun allFiles(): Observable<List<files>>
}