package com.example.ejemplomvvm.domain

import com.example.ejemplomvvm.data.CitaRepository
import com.example.ejemplomvvm.data.model.CitaModel
import javax.inject.Inject

class GetCitasCasosDeUso @Inject constructor(
    private val repository:CitaRepository
){

    suspend operator fun invoke(): MutableList<CitaModel>? = repository.getCitas()
}
