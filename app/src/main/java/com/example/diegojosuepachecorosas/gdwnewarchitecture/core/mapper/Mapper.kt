package com.example.diegojosuepachecorosas.gdwnewarchitecture.core.mapper

interface Mapper<T, R> {
    fun map(origin: T): R

    fun map(originList: List<T>): List<R> {
        return originList.map(::map)
    }
}

interface FullMapper<T, R> : Mapper<T, R> {
    fun reverse(destiny: R): T
    fun reverse(destinyList: List<R>): List<T> {
        return destinyList.map(::reverse)
    }
}