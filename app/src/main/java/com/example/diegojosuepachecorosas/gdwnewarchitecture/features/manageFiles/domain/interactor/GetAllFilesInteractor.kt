package com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.domain.interactor

import com.example.diegojosuepachecorosas.gdwnewarchitecture.core.interactor.Interactor
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.domain.entity.files
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.domain.repository.FileRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetAllFilesInteractor
@Inject constructor(private val fileRespository:FileRepository):Interactor<Interactor.None,Observable<List<files>>>{
    override fun execute(params: Interactor.None): Observable<List<files>> {
        return fileRespository.allFiles()
    }



}