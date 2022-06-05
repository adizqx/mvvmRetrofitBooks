package com.example.mvvmretrofitbooks.model

data class BooksModel(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int
)