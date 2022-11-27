package com.example.ejemplomvvm.data

import com.example.ejemplomvvm.data.model.CitaModel
import com.example.ejemplomvvm.data.model.CitaProvider
import com.example.ejemplomvvm.data.network.CitaService

class CitaRepository {

    private val api = CitaService()

    suspend fun getCitas():MutableList<CitaModel> {
        val response = api.getCitas()
        CitaProvider.listaDeCitas = response
        return response
    }
}