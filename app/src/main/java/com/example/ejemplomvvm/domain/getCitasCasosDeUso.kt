package com.example.ejemplomvvm.domain

import com.example.ejemplomvvm.data.CitaRepository
import com.example.ejemplomvvm.data.model.CitaModel

class getCitasCasosDeUso {

    private val repository = CitaRepository()

    suspend operator fun invoke(): MutableList<CitaModel>? = repository.getCitas()
}
