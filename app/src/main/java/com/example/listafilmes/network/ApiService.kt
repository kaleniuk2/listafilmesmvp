package com.example.listafilmes.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private const val BASE_URL: String = "https://api.themoviedb.org/3/"

    val instance: FilmeService by lazy {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        retrofit.create(FilmeService::class.java)
    }
}