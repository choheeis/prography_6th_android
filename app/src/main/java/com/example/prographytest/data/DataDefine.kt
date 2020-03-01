package com.example.prographytest.data

import com.google.gson.annotations.SerializedName

data class DataDefine(
    @SerializedName("title")
    val title: String?,
    @SerializedName("director")
    val director: String,
    @SerializedName("release_date")
    val release_date: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("producer")
    val producer: String?,
    @SerializedName("rt_score")
    val rt_score: String?
)
