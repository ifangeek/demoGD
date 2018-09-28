package com.example.diegojosuepachecorosas.gdwnewarchitecture.di.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import io.reactivex.annotations.Nullable
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton


@Singleton
class ViewModelFactory
@Inject constructor(@Nullable private val creators:Map<Class<out ViewModel>?,
                    @JvmSuppressWildcards Provider<ViewModel>>): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?:
                creators.asIterable().firstOrNull{ modelClass.isAssignableFrom(it.key)}?.value?:
                throw  IllegalArgumentException("Unknown Viewmodel class $modelClass")


        return try {creator.get() as T}
        catch (e:Exception) {throw RuntimeException(e)}
    }
}