package com.example.ejemplomvvm.data.model

import com.google.gson.annotations.SerializedName

data class CitaModel(@SerializedName("quote") val cita:String,@SerializedName("author") val autor: String)