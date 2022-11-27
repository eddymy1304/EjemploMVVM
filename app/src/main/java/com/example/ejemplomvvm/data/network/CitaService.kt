package com.example.ejemplomvvm.data.network

import com.example.ejemplomvvm.core.RetrofilHelper
import com.example.ejemplomvvm.data.model.CitaModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CitaService @Inject constructor(private val apiCliente: CitaApiCliente) {


    suspend fun getCitas():MutableList<CitaModel> {
        return withContext(Dispatchers.IO){
            val response = apiCliente.getAllCitas()
            response.body() ?: mutableListOf()
        }

    }
}