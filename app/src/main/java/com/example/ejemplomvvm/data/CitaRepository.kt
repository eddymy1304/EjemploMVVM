package com.example.ejemplomvvm.data

import com.example.ejemplomvvm.data.model.CitaModel
import com.example.ejemplomvvm.data.model.CitaProvider
import com.example.ejemplomvvm.data.network.CitaService
import javax.inject.Inject

class CitaRepository @Inject constructor(
    private val api: CitaService,
    private val citasProvider: CitaProvider
) {


    suspend fun getCitas(): MutableList<CitaModel> {
        val response = api.getCitas()
        citasProvider.listaDeCitas = response
        return response
    }
}