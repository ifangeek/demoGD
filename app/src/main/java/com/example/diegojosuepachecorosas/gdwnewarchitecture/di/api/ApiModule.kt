package com.example.diegojosuepachecorosas.gdwnewarchitecture.di.api

import com.example.diegojosuepachecorosas.gdwnewarchitecture.BuildConfig
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.data.datasource.rest.api.DriveService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule(private val baseUrl:String) {

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() : HttpLoggingInterceptor{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = if(BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        return interceptor
    }

    @Singleton
    @Provides
    fun provdesGson() : Gson{
        return GsonBuilder()
                .setLenient()
                .create()
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(loggingInterceptor: HttpLoggingInterceptor) : OkHttpClient{
        return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
    }
    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient,gson: Gson) : Retrofit{
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Singleton
    @Provides
    fun providesFilesService(retrofit: Retrofit) = retrofit.create(DriveService::class.java)
    
}