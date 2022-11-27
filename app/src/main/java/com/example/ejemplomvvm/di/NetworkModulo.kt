package com.example.ejemplomvvm.di

import com.example.ejemplomvvm.data.network.CitaApiCliente
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModulo {

    //una unica instancia con singleton
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideCitaApiCliente(retrofit: Retrofit): CitaApiCliente {
        return retrofit.create(CitaApiCliente::class.java)
    }
}