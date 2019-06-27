package com.example.listafilmes.network.Response

import com.google.gson.annotations.SerializedName

data class FilmesResult(
    @SerializedName("results")
    val resultado: List<FilmeReponse>
) {
}