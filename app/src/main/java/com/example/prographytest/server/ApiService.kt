package com.example.prographytest.server

import com.example.prographytest.data.DataDefine
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/films")
    fun requestFilmsList() : Call<List<DataDefine>>
}