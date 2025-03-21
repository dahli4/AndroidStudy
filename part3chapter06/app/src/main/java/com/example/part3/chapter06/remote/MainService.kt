package com.example.part3.chapter06.remote

import com.example.part3.chapter06.model.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MainService {

    @GET("chapter6")
    suspend fun getList(
        @Query("page") page: Int,
        @Query("size") size: Int = 20,
    ): NetworkResponse
}