package com.example.ejemplomvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.viewbinding.ViewBinding
import com.example.ejemplomvvm.databinding.ActivityMainBinding
import com.example.ejemplomvvm.ui.viewmodel.CitaViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    //by viewmodels() hace el trabajo de la conexion del viewmodel con el activity
    private val citaViewModel: CitaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        citaViewModel.onCreate()

        citaViewModel.citaModel.observe(this) { citaActual ->
            binding.tvAutor.text = citaActual.autor
            binding.tvCita.text = citaActual.cita
        }
        binding.viewContainer.setOnClickListener {
            citaViewModel.citaRandom()
        }

        citaViewModel.isLoading.observe(this){
            binding.progressBar.isVisible = it
        }


    }
}