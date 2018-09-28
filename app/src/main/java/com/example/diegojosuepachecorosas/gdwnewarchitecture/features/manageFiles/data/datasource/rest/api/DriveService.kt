package com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.data.datasource.rest.api

import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.data.datasource.rest.ResultResponseData
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface DriveService {

    @GET("files")
    fun allFiles(): Single<Response<ResultResponseData>>



}