package com.example.prographytest.data

import com.google.gson.annotations.SerializedName

data class DataDefine(
    @SerializedName("title")
    val title: String?,
    @SerializedName("director")
    val director: String,
    @SerializedName("release_date")
    val release_date: String?
)
