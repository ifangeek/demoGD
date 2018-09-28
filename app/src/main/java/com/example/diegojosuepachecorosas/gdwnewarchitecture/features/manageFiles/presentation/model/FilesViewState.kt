package com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.presentation.model

sealed class FilesViewState{
    object Loading : FilesViewState()
    class Error(val reason:String): FilesViewState()
    object noFiles: FilesViewState()
    class Success(val files:List<FilesVM>) : FilesViewState()
}