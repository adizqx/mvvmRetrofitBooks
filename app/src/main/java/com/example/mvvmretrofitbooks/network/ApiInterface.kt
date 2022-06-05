package com.example.mvvmretrofitbooks.network

import com.example.mvvmretrofitbooks.model.BooksModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("volumes?")
    suspend fun getBookByName(@Query("q") q: String): Response<BooksModel>
}