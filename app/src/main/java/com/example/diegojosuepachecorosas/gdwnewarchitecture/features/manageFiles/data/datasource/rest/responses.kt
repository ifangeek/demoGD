package com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.data.datasource.rest

import com.google.gson.annotations.SerializedName


data class ResultResponseData(
        @SerializedName("files")
        val files:ArrayList<FilesResponseData>? = ArrayList()
)

data class FilesResponseData(
        @SerializedName("id")
        val id:String,
        @SerializedName("name")
        val name:String,
        @SerializedName("mimetype")
        val mimetype:String

)