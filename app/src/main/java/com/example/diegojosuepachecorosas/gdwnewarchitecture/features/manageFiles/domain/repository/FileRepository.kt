package com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.domain.repository

import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.domain.entity.files
import io.reactivex.Observable

interface FileRepository {

    fun allFiles(): Observable<List<files>>
}