package com.example.diegojosuepachecorosas.gdwnewarchitecture.core.navigation

import android.content.Context
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.presentation.activity.FilesActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator
@Inject constructor(){
    fun showMain(context: Context){
        context.startActivity(FilesActivity.newInstance(context))
    }
}