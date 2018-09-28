package com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.data.datasource.rest

import com.example.diegojosuepachecorosas.gdwnewarchitecture.core.mapper.Mapper
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.domain.entity.files

object FileDataMapper : Mapper<ResultResponseData, List<files>> {


    override fun map(origin: ResultResponseData): List<files> {
        return origin.files.orEmpty().map(FilesDataMapper::map)
    }

}

object FilesDataMapper : Mapper<FilesResponseData, files> {
    override fun map(origin: FilesResponseData): files {
        return files(
                origin.id,
                origin.name,
                origin.mimetype
        )
    }
}

