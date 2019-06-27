package com.example.listafilmes.data.mapper

import com.example.listafilmes.data.model.Filme
import com.example.listafilmes.network.Response.FilmeReponse

object FilmeMapper {

    fun doResponseParaDominio(listaFilmeResponse: List<FilmeReponse>) : List<Filme> {
        val listaFilme: ArrayList<Filme> = arrayListOf()

        for (filmeUnidade in listaFilmeResponse) {
            var filme = Filme(filmeUnidade.tituloOriginal, filmeUnidade.caminhoPoster)
            listaFilme.add(filme)
        }

        return listaFilme
    }

}