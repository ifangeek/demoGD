package com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.data.datasource.rest

import com.example.diegojosuepachecorosas.gdwnewarchitecture.core.rest.BaseRestDatasource
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.data.datasource.FileDatasource
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.data.datasource.rest.api.DriveService
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.domain.entity.files
import io.reactivex.Observable
import javax.inject.Inject

class FilesRestDatasource
@Inject constructor(private val driveService: DriveService) : BaseRestDatasource(), FileDatasource {

    override fun allFiles(): Observable<List<files>> {
        return parseResult(driveService.allFiles())
                .map(FileDataMapper::map)
                .toObservable()
    }
}