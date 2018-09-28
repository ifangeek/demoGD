package com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.diegojosuepachecorosas.gdwnewarchitecture.core.interactor.Interactor
import com.example.diegojosuepachecorosas.gdwnewarchitecture.core.scheduler.BaseSchedulerProvider
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.domain.interactor.GetAllFilesInteractor
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.presentation.FilesVMMapper
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.presentation.model.FilesViewState
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class FilesViewModel
@Inject constructor(private val schedulerProvider: BaseSchedulerProvider,
                    private val getAllFilesInteractor: GetAllFilesInteractor): ViewModel(){

    private val disposables = CompositeDisposable()
    val state = MutableLiveData<FilesViewState>()

    fun loadFiles() {
        disposables.add(getAllFilesInteractor.execute(Interactor.None)
                .map { FilesVMMapper.map(it) }
                .delay(2,TimeUnit.SECONDS)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe{state.value = FilesViewState.Loading}
                .subscribe({
                    if (it.isEmpty()) {
                        state.value = FilesViewState.noFiles
                    } else {
                        state.value = FilesViewState.Success(it)
                    }

                },{
                    state.value = FilesViewState.Error("Error al conectar con el servidor")
                }))
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}