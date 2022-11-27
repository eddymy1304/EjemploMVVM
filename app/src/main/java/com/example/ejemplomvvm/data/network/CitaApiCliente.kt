package com.example.ejemplomvvm.data.network

import com.example.ejemplomvvm.data.model.CitaModel
import retrofit2.Response
import retrofit2.http.GET

interface CitaApiCliente {
    @GET("/.json")
    suspend fun getAllCitas():Response<MutableList<CitaModel>>
}