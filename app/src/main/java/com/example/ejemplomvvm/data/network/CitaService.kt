package com.example.ejemplomvvm.data.network

import com.example.ejemplomvvm.core.RetrofilHelper
import com.example.ejemplomvvm.data.model.CitaModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CitaService {

    private val retrofit = RetrofilHelper.getRetrofit()

    suspend fun getCitas():MutableList<CitaModel> {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(CitaApiCliente::class.java).getAllCitas()
            response.body() ?: mutableListOf()
        }

    }
}