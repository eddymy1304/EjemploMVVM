package com.example.ejemplomvvm.domain

import com.example.ejemplomvvm.data.CitaRepository
import com.example.ejemplomvvm.data.model.CitaModel
import com.example.ejemplomvvm.data.model.CitaProvider
import javax.inject.Inject

class GetRandomCitasCasosDeUso @Inject constructor(
    private val citaProvider: CitaProvider
) {
    //private val repository = CitaRepository()

    operator fun invoke(): CitaModel? {
        val citas = citaProvider.listaDeCitas
        if (!citas.isNullOrEmpty()) {
            val numeroRandom = (0 until citas.size).random()
            return citas[numeroRandom]
        }
        return null
    }
}