package com.example.listafilmes.network


import com.example.listafilmes.network.Response.FilmesResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmeService {
    @GET("movie/popular")
    fun obterFilmesPopulares(@Query("api_key") chaveApi: String): Call<FilmesResult>

}