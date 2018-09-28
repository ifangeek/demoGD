package com.example.diegojosuepachecorosas.gdwnewarchitecture.core.platform

import android.content.Context
import com.example.diegojosuepachecorosas.gdwnewarchitecture.core.extension.networkInfo
import java.security.AccessControlContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkHandle
@Inject constructor(private val context: Context){

    val isConnected
        get() = context.networkInfo?.isConnectedOrConnecting

}