package com.example.ejemplomvvm.data.model

import javax.inject.Inject
import javax.inject.Singleton

//Unica instancia
@Singleton
class CitaProvider @Inject constructor() {
    var listaDeCitas = mutableListOf<CitaModel>()
}