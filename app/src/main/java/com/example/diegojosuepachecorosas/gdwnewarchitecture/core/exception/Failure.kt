package com.example.diegojosuepachecorosas.gdwnewarchitecture.core.exception

sealed class Failure : Throwable(){
    class NetworkConnection : Failure()
    class ServerError: Failure()
    class ConflictFailure(val code:String,override val message:String) : Failure()

    /**
     * Extend this class for feature specific failures.
     */
    abstract class FeatureFailure: Failure()
}