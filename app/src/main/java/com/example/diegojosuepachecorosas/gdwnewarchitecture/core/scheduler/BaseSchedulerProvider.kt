package com.example.diegojosuepachecorosas.gdwnewarchitecture.core.scheduler

import io.reactivex.Scheduler

interface BaseSchedulerProvider {

    fun computation() : Scheduler
    fun io() : Scheduler
    fun ui() : Scheduler
}