package com.example.ejemplomvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ejemplomvvm.data.model.CitaModel
import com.example.ejemplomvvm.domain.GetRandomCitasCasosDeUso
import com.example.ejemplomvvm.domain.GetCitasCasosDeUso
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CitaViewModel @Inject constructor(
    private val getcitasCasosDeUso: GetCitasCasosDeUso,
    private val getRandomCitasCasosDeUso: GetRandomCitasCasosDeUso
) : ViewModel() {

    val citaModel = MutableLiveData<CitaModel>()
    var isLoading = MutableLiveData<Boolean>()


    fun citaRandom() {
        val cita = getRandomCitasCasosDeUso()
        cita.let {
            citaModel.postValue(it)
        }
    }

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getcitasCasosDeUso()
            if (!result.isNullOrEmpty()) {
                citaModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

}