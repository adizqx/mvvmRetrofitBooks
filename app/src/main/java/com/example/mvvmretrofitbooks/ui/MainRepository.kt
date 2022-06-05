package com.example.mvvmretrofitbooks.ui

import com.example.mvvmretrofitbooks.model.Item
import com.example.mvvmretrofitbooks.network.ApiInterface
import com.example.mvvmretrofitbooks.network.RetrofitClient

class MainRepository {
    suspend fun getBookByName(query: String): List<Item>? {
        val client =
            RetrofitClient.getInstance().create(ApiInterface::class.java).getBookByName(query)
        return client.body()?.items
    }
}