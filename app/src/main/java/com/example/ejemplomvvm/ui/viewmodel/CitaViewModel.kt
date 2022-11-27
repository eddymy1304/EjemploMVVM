package com.example.ejemplomvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ejemplomvvm.data.model.CitaModel
import com.example.ejemplomvvm.data.model.CitaProvider
import com.example.ejemplomvvm.domain.getCitasCasosDeUso
import kotlinx.coroutines.launch

class CitaViewModel: ViewModel() {

    val citaModel = MutableLiveData<CitaModel>()
    var getcitasCasosDeUso = getCitasCasosDeUso()

    fun citaRandom() {
//        val citaActual = CitaProvider.random()
//        citaModel.postValue(citaActual)
    }

    fun onCreate() {
        viewModelScope.launch {
            val result = getcitasCasosDeUso()
            if (!result.isNullOrEmpty()) {
                citaModel.postValue(result[0])
            }
        }
    }

}