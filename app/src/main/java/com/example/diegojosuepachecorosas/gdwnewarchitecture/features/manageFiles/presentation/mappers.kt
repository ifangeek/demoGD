package com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.presentation

import com.example.diegojosuepachecorosas.gdwnewarchitecture.core.mapper.Mapper
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.domain.entity.files
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.presentation.model.FilesVM

object FilesVMMapper: Mapper<files,FilesVM>{
    override fun map(origin: files): FilesVM {
        return FilesVM(
                origin.id,
                origin.name,
                origin.mimetype
        )
    }
}