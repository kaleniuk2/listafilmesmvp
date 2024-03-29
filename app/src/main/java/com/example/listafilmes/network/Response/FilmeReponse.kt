package com.example.listafilmes.network.Response

import com.google.gson.annotations.SerializedName

data class FilmeReponse(
    @SerializedName("poster_path")
    val caminhoPoster: String?,

    @SerializedName("original_title")
    val tituloOriginal: String
) {
}