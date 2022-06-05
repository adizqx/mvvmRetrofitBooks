package com.example.mvvmretrofitbooks.model

import java.io.Serializable

data class Item(
    val etag: String,
    val id: String,
    val kind: String,
    val selfLink: String,
    val volumeInfo: VolumeInfo
):Serializable